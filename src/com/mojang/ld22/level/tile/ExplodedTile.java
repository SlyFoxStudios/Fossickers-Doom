// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.level.tile;

import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.gfx.Screen;

public class ExplodedTile extends Tile
{
    int tick;
    
    public ExplodedTile(final int id) {
        super(id);
        this.tick = 0;
        this.connectsToSand = true;
        this.connectsToWater = true;
        this.connectsToLava = true;
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        final int col = Color.get(555, 555, 555, 550);
        final int transitionColor1 = Color.get(3, 555, level.dirtColor - 111, level.dirtColor);
        final int transitionColor2 = Color.get(3, 555, level.sandColor - 110, level.sandColor);
        final boolean u = !level.getTile(x, y - 1).connectsToLiquid();
        final boolean d = !level.getTile(x, y + 1).connectsToLiquid();
        final boolean l = !level.getTile(x - 1, y).connectsToLiquid();
        final boolean r = !level.getTile(x + 1, y).connectsToLiquid();
        final boolean su = u && level.getTile(x, y - 1).connectsToSand;
        final boolean sd = d && level.getTile(x, y + 1).connectsToSand;
        final boolean sl = l && level.getTile(x - 1, y).connectsToSand;
        final boolean sr = r && level.getTile(x + 1, y).connectsToSand;
        if (!u && !l) {
            screen.render(x * 16 + 0, y * 16 + 0, 0, col, 0);
        }
        else {
            screen.render(x * 16 + 0, y * 16 + 0, (l ? 14 : 15) + (u ? 0 : 1) * 32, (su || sl) ? transitionColor2 : transitionColor1, 0);
        }
        if (!u && !r) {
            screen.render(x * 16 + 8, y * 16 + 0, 1, col, 0);
        }
        else {
            screen.render(x * 16 + 8, y * 16 + 0, (r ? 16 : 15) + (u ? 0 : 1) * 32, (su || sr) ? transitionColor2 : transitionColor1, 0);
        }
        if (!d && !l) {
            screen.render(x * 16 + 0, y * 16 + 8, 2, col, 0);
        }
        else {
            screen.render(x * 16 + 0, y * 16 + 8, (l ? 14 : 15) + (d ? 2 : 1) * 32, (sd || sl) ? transitionColor2 : transitionColor1, 0);
        }
        if (!d && !r) {
            screen.render(x * 16 + 8, y * 16 + 8, 3, col, 0);
        }
        else {
            screen.render(x * 16 + 8, y * 16 + 8, (r ? 16 : 15) + (d ? 2 : 1) * 32, (sd || sr) ? transitionColor2 : transitionColor1, 0);
        }
    }
    
    @Override
    public void tick(final Level level, final int x, final int y) {
        super.tick(level, 0, 0);
        for (int i = 0; i < level.entities.size(); ++i) {
            if (level.getTile(level.entities.get(i).x / 16, level.entities.get(i).y / 16) == this) {
                level.entities.get(i).hurt(this, level.entities.get(i).x / 16, level.entities.get(i).y / 16, 50);
            }
        }
        ++this.tick;
        if (this.tick > 15) {
            level.setTile(x, y, Tile.hole, 0);
            this.tick = 15;
        }
    }
    
    @Override
    public void steppedOn(final Level level, final int x, final int y, final Entity entity) {
    }
    
    @Override
    public boolean mayPass(final Level level, final int x, final int y, final Entity e) {
        return true;
    }
}
