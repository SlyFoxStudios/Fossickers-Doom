// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.level.tile;

import com.mojang.ld22.Game;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.gfx.Screen;

public class StairsTile extends Tile
{
    private boolean leadsUp;
    
    public StairsTile(final int id, final boolean leadsUp) {
        super(id);
        this.leadsUp = leadsUp;
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        final int col0 = Color.get(322, 0, 333, 444);
        final int col2 = Color.get(321, 0, 444, 555);
        final int col3 = Color.get(211, 0, 333, 444);
        final int col4 = Color.get(100, 0, 222, 333);
        int col5 = Color.get(222, 0, 333, 444);
        if (Game.currentLevel == 5) {
            col5 = Color.get(59, 0, 333, 444);
        }
        if (Game.currentLevel > -1 && Game.currentLevel < 5) {
            col5 = Color.get(222, 0, 333, 444);
        }
        if (level.dirtColor == 322 && Game.Time == 0) {
            final int color = col0;
            int xt = 0;
            if (this.leadsUp) {
                xt = 2;
            }
            screen.render(x * 16 + 0, y * 16 + 0, xt + 64, color, 0);
            screen.render(x * 16 + 8, y * 16 + 0, xt + 1 + 64, color, 0);
            screen.render(x * 16 + 0, y * 16 + 8, xt + 96, color, 0);
            screen.render(x * 16 + 8, y * 16 + 8, xt + 1 + 96, color, 0);
        }
        if (Game.Time == 1) {
            final int color = col2;
            int xt = 0;
            if (this.leadsUp) {
                xt = 2;
            }
            screen.render(x * 16 + 0, y * 16 + 0, xt + 64, color, 0);
            screen.render(x * 16 + 8, y * 16 + 0, xt + 1 + 64, color, 0);
            screen.render(x * 16 + 0, y * 16 + 8, xt + 96, color, 0);
            screen.render(x * 16 + 8, y * 16 + 8, xt + 1 + 96, color, 0);
        }
        if (Game.Time == 2) {
            final int color = col3;
            int xt = 0;
            if (this.leadsUp) {
                xt = 2;
            }
            screen.render(x * 16 + 0, y * 16 + 0, xt + 64, color, 0);
            screen.render(x * 16 + 8, y * 16 + 0, xt + 1 + 64, color, 0);
            screen.render(x * 16 + 0, y * 16 + 8, xt + 96, color, 0);
            screen.render(x * 16 + 8, y * 16 + 8, xt + 1 + 96, color, 0);
        }
        if (Game.Time == 3) {
            final int color = col4;
            int xt = 0;
            if (this.leadsUp) {
                xt = 2;
            }
            screen.render(x * 16 + 0, y * 16 + 0, xt + 64, color, 0);
            screen.render(x * 16 + 8, y * 16 + 0, xt + 1 + 64, color, 0);
            screen.render(x * 16 + 0, y * 16 + 8, xt + 96, color, 0);
            screen.render(x * 16 + 8, y * 16 + 8, xt + 1 + 96, color, 0);
        }
        if (level.dirtColor != 322) {
            final int color = col5;
            int xt = 0;
            if (this.leadsUp) {
                xt = 2;
            }
            screen.render(x * 16 + 0, y * 16 + 0, xt + 64, color, 0);
            screen.render(x * 16 + 8, y * 16 + 0, xt + 1 + 64, color, 0);
            screen.render(x * 16 + 0, y * 16 + 8, xt + 96, color, 0);
            screen.render(x * 16 + 8, y * 16 + 8, xt + 1 + 96, color, 0);
        }
    }
}
