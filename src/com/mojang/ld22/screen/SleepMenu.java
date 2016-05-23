// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.screen;

import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.Game;

public class SleepMenu extends Menu
{
    private int inputDelay;
    public static boolean shudrespawn;
    public int tickCount;
    int selectState;
    
    public SleepMenu() {
        this.inputDelay = 60;
        this.tickCount = 0;
        this.selectState = 0;
    }
    
    @Override
    public void tick() {
        if (!Game.isDayNoSleep) {
            if (this.tickCount == 400) {
                this.selectState = 2;
                Game.tickCount = 6000;
                Game.Time = 1;
                System.out.println("SLEEPING!");
            }
            else {
                this.selectState = 1;
                ++this.tickCount;
                if (this.input.menu.clicked) {
                    this.game.setMenu(null);
                    this.tickCount = 0;
                }
            }
        }
        else if (Game.isDayNoSleep) {
            if (this.input.menu.clicked) {
                this.game.setMenu(null);
            }
            this.selectState = 0;
        }
        if (this.selectState == 2 && this.input.menu.clicked) {
            this.game.setMenu(null);
        }
    }
    
    @Override
    public void render(final Screen screen) {
        Font.renderFrame(screen, "", 1, 3, 21, 7);
        if (this.selectState == 0) {
            Font.draw("It's Day, no sleep!", screen, 16, 32, Color.get(-1, 555, 555, 555));
            Font.draw("X:Exit", screen, 16, 40, Color.get(-1, 555, 555, 555));
        }
        else if (this.selectState == 1) {
            Font.draw("Sleeping...", screen, 16, 32, Color.get(-1, 555, 555, 555));
            Font.draw("X:Exit", screen, 16, 40, Color.get(-1, 555, 555, 555));
        }
        else if (this.selectState == 2) {
            Font.draw("It's daytime!", screen, 16, 32, Color.get(-1, 555, 555, 555));
            Font.draw("X:Exit", screen, 16, 40, Color.get(-1, 555, 555, 555));
        }
    }
}
