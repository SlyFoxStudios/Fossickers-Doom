// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.screen;

import com.fossickersdoom.entity.Player;
import com.fossickersdoom.gfx.Font;
import com.fossickersdoom.gfx.Color;
import com.fossickersdoom.gfx.Screen;

public class DeadMenu extends Menu
{
    private int inputDelay;
    public static boolean shudrespawn;
    
    public DeadMenu() {
        this.inputDelay = 60;
    }
    
    @Override
    public void tick() {
        if (this.inputDelay > 0) {
            --this.inputDelay;
        }
        else if (this.input.attack.clicked) {
            this.game.setMenu(new TitleMenu());
            DeadMenu.shudrespawn = false;
        }
        if (!ModeMenu.hardcore && this.input.menu.clicked) {
            DeadMenu.shudrespawn = true;
            this.game.resetGame();
            this.game.setMenu(null);
        }
    }
    
    @Override
    public void render(final Screen screen) {
        Font.renderFrame(screen, "", 1, 3, 18, 10);
        Font.draw("You died! Aww!", screen, 16, 32, Color.get(-1, 555, 555, 555));
        int seconds = this.game.gameTime / 60;
        int minutes = seconds / 60;
        final int hours = minutes / 60;
        minutes %= 60;
        seconds %= 60;
        String timeString = "";
        if (hours > 0) {
            timeString = String.valueOf(hours) + "h" + ((minutes < 10) ? "0" : "") + minutes + "m";
        }
        else {
            timeString = String.valueOf(minutes) + "m " + ((seconds < 10) ? "0" : "") + seconds + "s";
        }
        Font.draw("Time:", screen, 16, 40, Color.get(-1, 555, 555, 555));
        Font.draw(timeString, screen, 56, 40, Color.get(-1, 550, 550, 550));
        Font.draw("Score:", screen, 16, 48, Color.get(-1, 555, 555, 555));
        final StringBuilder sb = new StringBuilder();
        final Player player = this.game.player;
        Font.draw(sb.append(Player.score).toString(), screen, 64, 48, Color.get(-1, 550, 550, 550));
        Font.draw("C = lose", screen, 16, 64, Color.get(-1, 333, 333, 333));
        if (!ModeMenu.hardcore) {
            Font.draw("X = respawn", screen, 16, 72, Color.get(-1, 333, 333, 333));
        }
    }
}
