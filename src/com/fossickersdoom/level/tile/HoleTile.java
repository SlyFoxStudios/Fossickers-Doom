// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.level.tile;

import com.fossickersdoom.entity.Entity;
import com.fossickersdoom.Game;
import com.fossickersdoom.gfx.Color;
import com.fossickersdoom.level.Level;
import com.fossickersdoom.gfx.Screen;

public class HoleTile extends Tile
{
    public HoleTile(final int id) {
        super(id);
        this.connectsToSand = true;
        this.connectsToWater = true;
        this.connectsToLava = true;
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        final int col0 = Color.get(222, 222, 220, 220);
        final int col2 = Color.get(3, 222, 211, 322);
        final int col3 = Color.get(3, 222, 330, 440);
        final int col4 = Color.get(222, 222, 220, 220);
        final int col5 = Color.get(3, 222, 211, 321);
        final int col6 = Color.get(3, 222, 440, 550);
        final int col7 = Color.get(111, 111, 110, 110);
        final int col8 = Color.get(3, 111, 100, 211);
        final int col9 = Color.get(3, 111, 220, 330);
        final int col10 = Color.get(0, 0, 10, 10);
        final int col11 = Color.get(3, 0, 100, 100);
        final int col12 = Color.get(3, 0, 110, 220);
        final int col13 = Color.get(111, 111, 110, 110);
        final int col14 = Color.get(3, 111, 111, 222);
        final int col15 = Color.get(3, 111, 440, 550);
        if (level.dirtColor == 322 && Game.Time == 0) {
            final int col16 = col0;
            final int transitionColor1 = col2;
            final int transitionColor2 = col3;
            final boolean u = !level.getTile(x, y - 1).connectsToLiquid();
            final boolean d = !level.getTile(x, y + 1).connectsToLiquid();
            final boolean l = !level.getTile(x - 1, y).connectsToLiquid();
            final boolean r = !level.getTile(x + 1, y).connectsToLiquid();
            final boolean su = u && level.getTile(x, y - 1).connectsToSand;
            final boolean sd = d && level.getTile(x, y + 1).connectsToSand;
            final boolean sl = l && level.getTile(x - 1, y).connectsToSand;
            final boolean sr = r && level.getTile(x + 1, y).connectsToSand;
            if (!u && !l) {
                screen.render(x * 16 + 0, y * 16 + 0, 0, col16, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 14 : 15) + (u ? 0 : 1) * 32, (su || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!u && !r) {
                screen.render(x * 16 + 8, y * 16 + 0, 1, col16, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 16 : 15) + (u ? 0 : 1) * 32, (su || sr) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !l) {
                screen.render(x * 16 + 0, y * 16 + 8, 2, col16, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 14 : 15) + (d ? 2 : 1) * 32, (sd || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !r) {
                screen.render(x * 16 + 8, y * 16 + 8, 3, col16, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 16 : 15) + (d ? 2 : 1) * 32, (sd || sr) ? transitionColor2 : transitionColor1, 0);
            }
        }
        if (Game.Time == 1) {
            final int col16 = col4;
            final int transitionColor1 = col5;
            final int transitionColor2 = col6;
            final boolean u = !level.getTile(x, y - 1).connectsToLiquid();
            final boolean d = !level.getTile(x, y + 1).connectsToLiquid();
            final boolean l = !level.getTile(x - 1, y).connectsToLiquid();
            final boolean r = !level.getTile(x + 1, y).connectsToLiquid();
            final boolean su = u && level.getTile(x, y - 1).connectsToSand;
            final boolean sd = d && level.getTile(x, y + 1).connectsToSand;
            final boolean sl = l && level.getTile(x - 1, y).connectsToSand;
            final boolean sr = r && level.getTile(x + 1, y).connectsToSand;
            if (!u && !l) {
                screen.render(x * 16 + 0, y * 16 + 0, 0, col16, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 14 : 15) + (u ? 0 : 1) * 32, (su || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!u && !r) {
                screen.render(x * 16 + 8, y * 16 + 0, 1, col16, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 16 : 15) + (u ? 0 : 1) * 32, (su || sr) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !l) {
                screen.render(x * 16 + 0, y * 16 + 8, 2, col16, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 14 : 15) + (d ? 2 : 1) * 32, (sd || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !r) {
                screen.render(x * 16 + 8, y * 16 + 8, 3, col16, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 16 : 15) + (d ? 2 : 1) * 32, (sd || sr) ? transitionColor2 : transitionColor1, 0);
            }
        }
        if (Game.Time == 2) {
            final int col16 = col7;
            final int transitionColor1 = col8;
            final int transitionColor2 = col9;
            final boolean u = !level.getTile(x, y - 1).connectsToLiquid();
            final boolean d = !level.getTile(x, y + 1).connectsToLiquid();
            final boolean l = !level.getTile(x - 1, y).connectsToLiquid();
            final boolean r = !level.getTile(x + 1, y).connectsToLiquid();
            final boolean su = u && level.getTile(x, y - 1).connectsToSand;
            final boolean sd = d && level.getTile(x, y + 1).connectsToSand;
            final boolean sl = l && level.getTile(x - 1, y).connectsToSand;
            final boolean sr = r && level.getTile(x + 1, y).connectsToSand;
            if (!u && !l) {
                screen.render(x * 16 + 0, y * 16 + 0, 0, col16, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 14 : 15) + (u ? 0 : 1) * 32, (su || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!u && !r) {
                screen.render(x * 16 + 8, y * 16 + 0, 1, col16, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 16 : 15) + (u ? 0 : 1) * 32, (su || sr) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !l) {
                screen.render(x * 16 + 0, y * 16 + 8, 2, col16, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 14 : 15) + (d ? 2 : 1) * 32, (sd || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !r) {
                screen.render(x * 16 + 8, y * 16 + 8, 3, col16, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 16 : 15) + (d ? 2 : 1) * 32, (sd || sr) ? transitionColor2 : transitionColor1, 0);
            }
        }
        if (Game.Time == 3) {
            final int col16 = col10;
            final int transitionColor1 = col11;
            final int transitionColor2 = col12;
            final boolean u = !level.getTile(x, y - 1).connectsToLiquid();
            final boolean d = !level.getTile(x, y + 1).connectsToLiquid();
            final boolean l = !level.getTile(x - 1, y).connectsToLiquid();
            final boolean r = !level.getTile(x + 1, y).connectsToLiquid();
            final boolean su = u && level.getTile(x, y - 1).connectsToSand;
            final boolean sd = d && level.getTile(x, y + 1).connectsToSand;
            final boolean sl = l && level.getTile(x - 1, y).connectsToSand;
            final boolean sr = r && level.getTile(x + 1, y).connectsToSand;
            if (!u && !l) {
                screen.render(x * 16 + 0, y * 16 + 0, 0, col16, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 14 : 15) + (u ? 0 : 1) * 32, (su || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!u && !r) {
                screen.render(x * 16 + 8, y * 16 + 0, 1, col16, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 16 : 15) + (u ? 0 : 1) * 32, (su || sr) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !l) {
                screen.render(x * 16 + 0, y * 16 + 8, 2, col16, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 14 : 15) + (d ? 2 : 1) * 32, (sd || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !r) {
                screen.render(x * 16 + 8, y * 16 + 8, 3, col16, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 16 : 15) + (d ? 2 : 1) * 32, (sd || sr) ? transitionColor2 : transitionColor1, 0);
            }
        }
        if (level.dirtColor == 222) {
            final int col16 = col13;
            final int transitionColor1 = col14;
            final int transitionColor2 = col15;
            final boolean u = !level.getTile(x, y - 1).connectsToLiquid();
            final boolean d = !level.getTile(x, y + 1).connectsToLiquid();
            final boolean l = !level.getTile(x - 1, y).connectsToLiquid();
            final boolean r = !level.getTile(x + 1, y).connectsToLiquid();
            final boolean su = u && level.getTile(x, y - 1).connectsToSand;
            final boolean sd = d && level.getTile(x, y + 1).connectsToSand;
            final boolean sl = l && level.getTile(x - 1, y).connectsToSand;
            final boolean sr = r && level.getTile(x + 1, y).connectsToSand;
            if (!u && !l) {
                screen.render(x * 16 + 0, y * 16 + 0, 0, col16, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 14 : 15) + (u ? 0 : 1) * 32, (su || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!u && !r) {
                screen.render(x * 16 + 8, y * 16 + 0, 1, col16, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 16 : 15) + (u ? 0 : 1) * 32, (su || sr) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !l) {
                screen.render(x * 16 + 0, y * 16 + 8, 2, col16, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 14 : 15) + (d ? 2 : 1) * 32, (sd || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !r) {
                screen.render(x * 16 + 8, y * 16 + 8, 3, col16, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 16 : 15) + (d ? 2 : 1) * 32, (sd || sr) ? transitionColor2 : transitionColor1, 0);
            }
        }
    }
    
    @Override
    public boolean mayPass(final Level level, final int x, final int y, final Entity e) {
        return e.canSwim();
    }
}
