// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.screen;

import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.saveload.Save;
import com.mojang.ld22.entity.Player;

public class PauseMenu extends Menu
{
    private int selected;
    private boolean o1;
    private boolean o2;
    private boolean o3;
    Player player;
    private static final String[] options;
    
    static {
        options = new String[] { "Return to Game", "Options", "Save Game", "Load Game", "Main Menu" };
    }
    
    public PauseMenu(final Player player) {
        this.selected = 0;
        this.o1 = false;
        this.o2 = false;
        this.o3 = false;
        this.player = player;
    }
    
    @Override
    public void tick() {
        if (this.input.pause.clicked) {
            this.game.setMenu(null);
        }
        if (this.input.up.clicked) {
            --this.selected;
        }
        if (this.input.down.clicked) {
            ++this.selected;
        }
        final int len = PauseMenu.options.length;
        if (this.selected < 0) {
            this.selected += len;
        }
        if (this.selected >= len) {
            this.selected -= len;
        }
        if (this.input.menu.clicked) {
            if (this.o1 && !this.o2 && !this.o3) {
                this.game.setMenu(null);
                final Save save = new Save(this.player, WorldSelectMenu.worldname);
            }
            if (!this.o1 && this.o2 && !this.o3) {
                final WorldSelectMenu m = new WorldSelectMenu(new TitleMenu());
                WorldSelectMenu.loadworld = true;
                m.createworld = false;
                this.game.setMenu(m);
            }
            if (!this.o1 && !this.o2 && this.o3) {
                this.game.setMenu(new TitleMenu());
            }
        }
        if (this.input.attack.clicked) {
            if (this.o1 && !this.o2 && !this.o3) {
                this.game.setMenu(null);
            }
            if (!this.o1 && this.o2 && !this.o3) {
                this.game.setMenu(null);
            }
            if (!this.o1 && !this.o2 && this.o3) {
                this.game.setMenu(null);
            }
        }
        if (this.input.attack.clicked || this.input.menu.clicked) {
            if (this.selected == 0) {
                this.o1 = false;
                this.o2 = false;
                this.o3 = false;
                this.game.setMenu(null);
            }
            if (this.selected == 1) {
                this.o1 = false;
                this.o2 = false;
                this.o3 = false;
                TitleMenu.sentFromMenu = false;
                this.game.setMenu(new StartMenu());
            }
            if (this.selected == 2) {
                this.o1 = true;
                this.o2 = false;
                this.o3 = false;
            }
            if (this.selected == 3) {
                this.o1 = false;
                this.o2 = true;
                this.o3 = false;
            }
            if (this.selected == 4) {
                this.o1 = false;
                this.o2 = false;
                this.o3 = true;
            }
        }
    }
    
    @Override
    public void render(final Screen screen) {
        Font.renderFrame(screen, "", 4, 2, 32, 20);
        if (!this.o1 && !this.o2 && !this.o3) {
            for (int i = 0; i < 5; ++i) {
                String msg = PauseMenu.options[i];
                int col = Color.get(-1, 222, 222, 222);
                if (i == this.selected) {
                    msg = ">" + msg + "<";
                    col = Color.get(-1, 555, 555, 555);
                }
                Font.draw(msg, screen, (screen.w - msg.length() * 8) / 2, (8 + i) * 12 - 35, col);
                Font.draw("Paused", screen, this.centertext("Paused"), 35, Color.get(-1, 550, 550, 550));
                Font.draw("Arrow Keys to Scroll", screen, this.centertext("Arrow Keys to Scroll"), 135, Color.get(-1, 333, 333, 333));
                Font.draw("X or C: Choose", screen, this.centertext("X or C: Choose"), 145, Color.get(-1, 333, 333, 333));
            }
        }
        else if (this.o1 && !this.o2 && !this.o3) {
            String msg2 = "Save Game?";
            Font.draw(msg2, screen, (screen.w - msg2.length() * 8) / 2, 60, Color.get(-1, 555, 555, 555));
            msg2 = "X: Yes";
            Font.draw(msg2, screen, (screen.w - msg2.length() * 8) / 2, 80, Color.get(-1, 555, 555, 555));
            msg2 = "C: No";
            Font.draw(msg2, screen, (screen.w - msg2.length() * 8) / 2, 95, Color.get(-1, 555, 555, 555));
        }
        else if (!this.o1 && this.o2 && !this.o3) {
            String msg2 = "Load Game?";
            Font.draw(msg2, screen, (screen.w - msg2.length() * 8) / 2, 60, Color.get(-1, 555, 555, 555));
            msg2 = "Current game will";
            Font.draw(msg2, screen, (screen.w - msg2.length() * 8) / 2, 70, Color.get(-1, 500, 500, 500));
            msg2 = "not be saved";
            Font.draw(msg2, screen, (screen.w - msg2.length() * 8) / 2, 80, Color.get(-1, 500, 500, 500));
            msg2 = "X: Yes";
            Font.draw(msg2, screen, (screen.w - msg2.length() * 8) / 2, 100, Color.get(-1, 555, 555, 555));
            msg2 = "C: No";
            Font.draw(msg2, screen, (screen.w - msg2.length() * 8) / 2, 115, Color.get(-1, 555, 555, 555));
        }
        else if (!this.o1 && !this.o2 && this.o3) {
            String msg2 = "Back to Main Menu?";
            Font.draw(msg2, screen, (screen.w - msg2.length() * 8) / 2 + 1, 60, Color.get(-1, 555, 555, 555));
            msg2 = "Current game will";
            Font.draw(msg2, screen, (screen.w - msg2.length() * 8) / 2, 70, Color.get(-1, 500, 500, 500));
            msg2 = "not be saved";
            Font.draw(msg2, screen, (screen.w - msg2.length() * 8) / 2, 80, Color.get(-1, 500, 500, 500));
            msg2 = "X: Yes";
            Font.draw(msg2, screen, (screen.w - msg2.length() * 8) / 2, 100, Color.get(-1, 555, 555, 555));
            msg2 = "C: No";
            Font.draw(msg2, screen, (screen.w - msg2.length() * 8) / 2, 115, Color.get(-1, 555, 555, 555));
        }
    }
}
