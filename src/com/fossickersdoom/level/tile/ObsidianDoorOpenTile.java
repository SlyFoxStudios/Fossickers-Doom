// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.level.tile;

import com.fossickersdoom.Game;
import com.fossickersdoom.entity.Entity;
import com.fossickersdoom.entity.Mob;
import com.fossickersdoom.gfx.Color;
import com.fossickersdoom.level.Level;
import com.fossickersdoom.gfx.Screen;

public class ObsidianDoorOpenTile extends Tile
{
    public ObsidianDoorOpenTile(final int id) {
        super(id);
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        final int col0 = Color.get(333, 222, 222, 111);
        final int col2 = Color.get(444, 333, 333, 222);
        final int col3 = Color.get(333, 222, 222, 111);
        final int col4 = Color.get(222, 111, 111, 0);
        final int col5 = Color.get(59, 159, 159, 259);
        if (level.dirtColor == 322 && Game.Time == 0) {
            final int col6 = col0;
            screen.render(x * 16 + 0, y * 16 + 0, 768, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 769, col6, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 800, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 801, col6, 0);
        }
        if (Game.Time == 1) {
            final int col6 = col2;
            screen.render(x * 16 + 0, y * 16 + 0, 768, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 769, col6, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 800, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 801, col6, 0);
        }
        if (Game.Time == 2) {
            final int col6 = col3;
            screen.render(x * 16 + 0, y * 16 + 0, 768, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 769, col6, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 800, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 801, col6, 0);
        }
        if (Game.Time == 3) {
            final int col6 = col4;
            screen.render(x * 16 + 0, y * 16 + 0, 768, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 769, col6, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 800, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 801, col6, 0);
        }
        if (level.dirtColor == 222) {
            final int col6 = col5;
            screen.render(x * 16 + 0, y * 16 + 0, 768, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 769, col6, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 800, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 801, col6, 0);
        }
    }
    
    @Override
    public void hurt(final Level level, final int x, final int y, final Mob source, final int dmg, final int attackDir) {
        level.setTile(x, y, Tile.odc, 0);
    }
    
    @Override
    public boolean mayPass(final Level level, final int x, final int y, final Entity e) {
        return e.canWool();
    }
}
