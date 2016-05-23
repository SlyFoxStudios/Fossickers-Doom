// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.screen;

import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.entity.Player;

public class HomeMenu extends Menu
{
    private int inputDelay;
    public static boolean shudrespawn;
    boolean cgh;
    boolean hsh;
    
    public HomeMenu() {
        this.inputDelay = 60;
        this.cgh = Player.canGoHome;
        this.hsh = Player.hasSetHome;
    }
    
    @Override
    public void tick() {
        if (this.input.menu.clicked || this.input.attack.clicked) {
            this.game.setMenu(null);
            Player.sentFromHome = false;
        }
    }
    
    @Override
    public void render(final Screen screen) {
        Font.renderFrame(screen, "", 1, 3, 18, 7);
        if (Player.sentFromHome && !Player.sentFromSetHome) {
            if (!this.hsh) {
                if (this.cgh) {
                    Font.draw("You don't have a", screen, 16, 32, Color.get(-1, 555, 555, 555));
                    Font.draw("home!", screen, 16, 40, Color.get(-1, 555, 555, 555));
                }
                else if (!this.cgh) {
                    Font.draw("You can't go home", screen, 16, 32, Color.get(-1, 555, 555, 555));
                    Font.draw("from here!", screen, 16, 40, Color.get(-1, 555, 555, 555));
                }
            }
            else if (this.hsh) {
                if (!this.cgh) {
                    Font.draw("You can't go home", screen, 16, 32, Color.get(-1, 555, 555, 555));
                    Font.draw("from here!", screen, 16, 40, Color.get(-1, 555, 555, 555));
                }
                else {
                    Font.draw("Home sweet home!", screen, 16, 32, Color.get(-1, 555, 555, 555));
                    if (ModeMenu.hardcore) {
                        Font.draw("HardCore = -2", screen, 16, 40, Color.get(-1, 555, 555, 555));
                    }
                }
            }
        }
    }
}
