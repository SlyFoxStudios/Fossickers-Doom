// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.screen;

import com.mojang.ld22.entity.Player;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Screen;

public class PlayerInfoMenu extends Menu
{
    private int inputDelay;
    public static boolean shudrespawn;
    
    public PlayerInfoMenu() {
        this.inputDelay = 60;
    }
    
    @Override
    public void tick() {
        if (this.input.menu.clicked) {
            this.game.setMenu(null);
        }
    }
    
    @Override
    public void render(final Screen screen) {
        Font.renderFrame(screen, "Player Info", 1, 1, 30, 15);
        int seconds = this.game.gameTime / 60;
        int minutes = seconds / 60;
        final int hours = minutes / 60;
        int cStep = this.game.player.stepCount;
        int cHung = this.game.player.hungStamCnt;
        minutes %= 60;
        seconds %= 60;
        String timeString = "";
        if (hours > 0) {
            timeString = String.valueOf(hours) + "h" + ((minutes < 10) ? "0" : "") + minutes + "m";
        }
        else {
            timeString = String.valueOf(minutes) + "m " + ((seconds < 10) ? "0" : "") + seconds + "s";
        }
        Font.draw("General Stats:", screen, 64, 24, Color.get(-1, 324, 200, 150));
        Font.draw(" ----------------------------", screen, 8, 32, Color.get(-1, 540, 540, 540));
        Font.draw("Current Time:", screen, 16, 40, Color.get(-1, 555, 555, 555));
        Font.draw(timeString, screen, 120, 40, Color.get(-1, 550, 550, 550));
        Font.draw("Current Score:", screen, 16, 48, Color.get(-1, 555, 555, 555));
        final StringBuilder sb = new StringBuilder();
        final Player player = this.game.player;
        Font.draw(sb.append(Player.score).toString(), screen, 128, 48, Color.get(-1, 550, 550, 550));
        Font.draw("Health:", screen, 16, 56, Color.get(-1, 555, 555, 555));
        if (ModeMenu.creative) {
            Font.draw("inf", screen, 72, 56, Color.get(-1, 550, 550, 550));
        }
        else {
            Font.draw(new StringBuilder().append(this.game.player.health).toString(), screen, 72, 56, Color.get(-1, 550, 550, 550));
        }
        Font.draw("Hunger:", screen, 16, 64, Color.get(-1, 555, 555, 555));
        if (ModeMenu.creative) {
            Font.draw("inf", screen, 72, 64, Color.get(-1, 550, 550, 550));
        }
        else {
            Font.draw(new StringBuilder().append(this.game.player.hunger).toString(), screen, 72, 64, Color.get(-1, 550, 550, 550));
        }
        Font.draw("Stamina till hunger:", screen, 16, 72, Color.get(-1, 555, 555, 555));
        if (StartMenu.diff == StartMenu.easy) {
            cHung = 10 - cHung;
        }
        if (StartMenu.diff == StartMenu.norm) {
            cHung = 7 - cHung;
        }
        if (StartMenu.diff == StartMenu.hard) {
            cHung = 5 - cHung;
        }
        if (ModeMenu.creative) {
            Font.draw("inf", screen, 176, 72, Color.get(-1, 550, 550, 550));
        }
        if (!ModeMenu.creative) {
            Font.draw(new StringBuilder().append(cHung).toString(), screen, 176, 72, Color.get(-1, 550, 550, 550));
        }
        Font.draw("Steps till hunger:", screen, 16, 80, Color.get(-1, 555, 555, 555));
        if (StartMenu.diff == StartMenu.norm) {
            cStep = 10000 - cStep;
        }
        if (StartMenu.diff == StartMenu.hard) {
            cStep = 5000 - cStep;
        }
        if (StartMenu.diff == StartMenu.easy || ModeMenu.creative) {
            Font.draw("inf", screen, 160, 80, Color.get(-1, 550, 550, 550));
        }
        else {
            Font.draw(new StringBuilder().append(cStep).toString(), screen, 160, 80, Color.get(-1, 550, 550, 550));
        }
        Font.draw(" ----------------------------", screen, 8, 88, Color.get(-1, 540, 540, 540));
        Font.draw("X:Exit", screen, 16, 104, Color.get(-1, 333, 333, 333));
    }
}
