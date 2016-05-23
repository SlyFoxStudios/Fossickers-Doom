// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.level.tile;

import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.entity.Mob;
import com.mojang.ld22.Game;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.gfx.Screen;

public class ObsidianDoorClosedTile extends Tile
{
    public ObsidianDoorClosedTile(final int id) {
        super(id);
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        final int col0 = Color.get(559, 359, 59, 459);
        final int col2 = Color.get(444, 333, 222, 333);
        final int col3 = Color.get(333, 222, 111, 222);
        final int col4 = Color.get(222, 111, 0, 111);
        final int col5 = Color.get(59, 159, 159, 259);
        if (level.dirtColor == 322 && Game.Time == 0) {
            final int col6 = col0;
            screen.render(x * 16 + 0, y * 16 + 0, 770, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 771, col6, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 802, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 803, col6, 0);
        }
        if (Game.Time == 1) {
            final int col6 = col2;
            screen.render(x * 16 + 0, y * 16 + 0, 770, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 771, col6, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 802, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 803, col6, 0);
        }
        if (Game.Time == 2) {
            final int col6 = col3;
            screen.render(x * 16 + 0, y * 16 + 0, 770, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 771, col6, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 802, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 803, col6, 0);
        }
        if (Game.Time == 3) {
            final int col6 = col4;
            screen.render(x * 16 + 0, y * 16 + 0, 770, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 771, col6, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 802, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 803, col6, 0);
        }
        if (level.dirtColor == 222) {
            final int col6 = col5;
            screen.render(x * 16 + 0, y * 16 + 0, 770, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 771, col6, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 802, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 803, col6, 0);
        }
    }
    
    @Override
    public void hurt(final Level level, final int x, final int y, final Mob source, final int dmg, final int attackDir) {
        level.setTile(x, y, Tile.odo, 0);
    }
    
    @Override
    public boolean mayPass(final Level level, final int x, final int y, final Entity e) {
        return false;
    }
}
