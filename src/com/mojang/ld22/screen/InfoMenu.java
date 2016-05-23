// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.screen;

import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.entity.Player;

public class InfoMenu extends Menu
{
    private int inputDelay;
    public static boolean shudrespawn;
    
    public InfoMenu() {
        this.inputDelay = 60;
    }
    
    @Override
    public void tick() {
        if (this.input.menu.clicked || this.input.attack.clicked) {
            this.game.setMenu(null);
            Player.sentFromSetHome = false;
            Player.sentFromHome = false;
        }
    }
    
    @Override
    public void render(final Screen screen) {
        Font.renderFrame(screen, "", 1, 3, 18, 7);
        if (Player.sentFromSetHome) {
            if (Player.canSetHome) {
                Font.draw("Set your home!", screen, 16, 32, Color.get(-1, 555, 555, 555));
            }
            else if (!Player.canSetHome) {
                Font.draw("Can't set home", screen, 16, 32, Color.get(-1, 555, 555, 555));
                Font.draw("here!", screen, 16, 40, Color.get(-1, 555, 555, 555));
            }
        }
    }
}
