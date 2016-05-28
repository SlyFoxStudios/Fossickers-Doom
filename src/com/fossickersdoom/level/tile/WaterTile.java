// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.level.tile;

import com.fossickersdoom.Game;
import com.fossickersdoom.entity.AirWizard;
import com.fossickersdoom.entity.Entity;
import com.fossickersdoom.gfx.Screen;
import com.fossickersdoom.level.Level;
import com.fossickersdoom.gfx.Color;

import java.util.Random;

public class WaterTile extends Tile
{
    private Random wRandom;
    
    public WaterTile(final int id) {
        super(id);
        this.wRandom = new Random();
        this.connectsToSand = true;
        this.connectsToWater = true;
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        final int col0 = Color.get(115, 115, 225, 225);
        final int col2 = Color.get(3, 115, 211, 322);
        final int col3 = Color.get(3, 115, 330, 440);
        final int col4 = Color.get(5, 105, 115, 115);
        final int col5 = Color.get(3, 105, 211, 321);
        final int col6 = Color.get(3, 105, 440, 550);
        final int col7 = Color.get(5, 13, 115, 115);
        final int col8 = Color.get(105, 13, 100, 211);
        final int col9 = Color.get(105, 13, 220, 330);
        final int col10 = Color.get(13, 13, 115, 115);
        final int col11 = Color.get(13, 13, 0, 100);
        final int col12 = Color.get(13, 13, 110, 220);
        final int col13 = Color.get(5, 105, 115, 115);
        final int col14 = Color.get(3, 105, 111, 222);
        final int col15 = Color.get(3, 105, 440, 550);
        if (level.dirtColor == 322 && Game.Time == 0) {
            this.wRandom.setSeed((WaterTile.tickCount + (x / 2 - y) * 4311) / 10 * 54687121L + x * 3271612L + y * 3412987161L);
            final int col16 = col0;
            final int transitionColor1 = col2;
            final int transitionColor2 = col3;
            final boolean u = !level.getTile(x, y - 1).connectsToWater;
            final boolean d = !level.getTile(x, y + 1).connectsToWater;
            final boolean l = !level.getTile(x - 1, y).connectsToWater;
            final boolean r = !level.getTile(x + 1, y).connectsToWater;
            final boolean su = u && level.getTile(x, y - 1).connectsToSand;
            final boolean sd = d && level.getTile(x, y + 1).connectsToSand;
            final boolean sl = l && level.getTile(x - 1, y).connectsToSand;
            final boolean sr = r && level.getTile(x + 1, y).connectsToSand;
            if (!u && !l) {
                screen.render(x * 16 + 0, y * 16 + 0, this.wRandom.nextInt(4), col16, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 14 : 15) + (u ? 0 : 1) * 32, (su || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!u && !r) {
                screen.render(x * 16 + 8, y * 16 + 0, this.wRandom.nextInt(4), col16, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 16 : 15) + (u ? 0 : 1) * 32, (su || sr) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !l) {
                screen.render(x * 16 + 0, y * 16 + 8, this.wRandom.nextInt(4), col16, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 14 : 15) + (d ? 2 : 1) * 32, (sd || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !r) {
                screen.render(x * 16 + 8, y * 16 + 8, this.wRandom.nextInt(4), col16, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 16 : 15) + (d ? 2 : 1) * 32, (sd || sr) ? transitionColor2 : transitionColor1, 0);
            }
        }
        if (Game.Time == 1) {
            this.wRandom.setSeed((WaterTile.tickCount + (x / 2 - y) * 4311) / 10 * 54687121L + x * 3271612L + y * 3412987161L);
            final int col16 = col4;
            final int transitionColor1 = col5;
            final int transitionColor2 = col6;
            final boolean u = !level.getTile(x, y - 1).connectsToWater;
            final boolean d = !level.getTile(x, y + 1).connectsToWater;
            final boolean l = !level.getTile(x - 1, y).connectsToWater;
            final boolean r = !level.getTile(x + 1, y).connectsToWater;
            final boolean su = u && level.getTile(x, y - 1).connectsToSand;
            final boolean sd = d && level.getTile(x, y + 1).connectsToSand;
            final boolean sl = l && level.getTile(x - 1, y).connectsToSand;
            final boolean sr = r && level.getTile(x + 1, y).connectsToSand;
            if (!u && !l) {
                screen.render(x * 16 + 0, y * 16 + 0, this.wRandom.nextInt(4), col16, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 14 : 15) + (u ? 0 : 1) * 32, (su || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!u && !r) {
                screen.render(x * 16 + 8, y * 16 + 0, this.wRandom.nextInt(4), col16, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 16 : 15) + (u ? 0 : 1) * 32, (su || sr) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !l) {
                screen.render(x * 16 + 0, y * 16 + 8, this.wRandom.nextInt(4), col16, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 14 : 15) + (d ? 2 : 1) * 32, (sd || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !r) {
                screen.render(x * 16 + 8, y * 16 + 8, this.wRandom.nextInt(4), col16, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 16 : 15) + (d ? 2 : 1) * 32, (sd || sr) ? transitionColor2 : transitionColor1, 0);
            }
        }
        if (Game.Time == 2) {
            this.wRandom.setSeed((WaterTile.tickCount + (x / 2 - y) * 4311) / 10 * 54687121L + x * 3271612L + y * 3412987161L);
            final int col16 = col7;
            final int transitionColor1 = col8;
            final int transitionColor2 = col9;
            final boolean u = !level.getTile(x, y - 1).connectsToWater;
            final boolean d = !level.getTile(x, y + 1).connectsToWater;
            final boolean l = !level.getTile(x - 1, y).connectsToWater;
            final boolean r = !level.getTile(x + 1, y).connectsToWater;
            final boolean su = u && level.getTile(x, y - 1).connectsToSand;
            final boolean sd = d && level.getTile(x, y + 1).connectsToSand;
            final boolean sl = l && level.getTile(x - 1, y).connectsToSand;
            final boolean sr = r && level.getTile(x + 1, y).connectsToSand;
            if (!u && !l) {
                screen.render(x * 16 + 0, y * 16 + 0, this.wRandom.nextInt(4), col16, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 14 : 15) + (u ? 0 : 1) * 32, (su || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!u && !r) {
                screen.render(x * 16 + 8, y * 16 + 0, this.wRandom.nextInt(4), col16, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 16 : 15) + (u ? 0 : 1) * 32, (su || sr) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !l) {
                screen.render(x * 16 + 0, y * 16 + 8, this.wRandom.nextInt(4), col16, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 14 : 15) + (d ? 2 : 1) * 32, (sd || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !r) {
                screen.render(x * 16 + 8, y * 16 + 8, this.wRandom.nextInt(4), col16, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 16 : 15) + (d ? 2 : 1) * 32, (sd || sr) ? transitionColor2 : transitionColor1, 0);
            }
        }
        if (Game.Time == 3) {
            this.wRandom.setSeed((WaterTile.tickCount + (x / 2 - y) * 4311) / 10 * 54687121L + x * 3271612L + y * 3412987161L);
            final int col16 = col10;
            final int transitionColor1 = col11;
            final int transitionColor2 = col12;
            final boolean u = !level.getTile(x, y - 1).connectsToWater;
            final boolean d = !level.getTile(x, y + 1).connectsToWater;
            final boolean l = !level.getTile(x - 1, y).connectsToWater;
            final boolean r = !level.getTile(x + 1, y).connectsToWater;
            final boolean su = u && level.getTile(x, y - 1).connectsToSand;
            final boolean sd = d && level.getTile(x, y + 1).connectsToSand;
            final boolean sl = l && level.getTile(x - 1, y).connectsToSand;
            final boolean sr = r && level.getTile(x + 1, y).connectsToSand;
            if (!u && !l) {
                screen.render(x * 16 + 0, y * 16 + 0, this.wRandom.nextInt(4), col16, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 14 : 15) + (u ? 0 : 1) * 32, (su || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!u && !r) {
                screen.render(x * 16 + 8, y * 16 + 0, this.wRandom.nextInt(4), col16, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 16 : 15) + (u ? 0 : 1) * 32, (su || sr) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !l) {
                screen.render(x * 16 + 0, y * 16 + 8, this.wRandom.nextInt(4), col16, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 14 : 15) + (d ? 2 : 1) * 32, (sd || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !r) {
                screen.render(x * 16 + 8, y * 16 + 8, this.wRandom.nextInt(4), col16, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 16 : 15) + (d ? 2 : 1) * 32, (sd || sr) ? transitionColor2 : transitionColor1, 0);
            }
        }
        if (level.dirtColor == 222) {
            this.wRandom.setSeed((WaterTile.tickCount + (x / 2 - y) * 4311) / 10 * 54687121L + x * 3271612L + y * 3412987161L);
            final int col16 = col13;
            final int transitionColor1 = col14;
            final int transitionColor2 = col15;
            final boolean u = !level.getTile(x, y - 1).connectsToWater;
            final boolean d = !level.getTile(x, y + 1).connectsToWater;
            final boolean l = !level.getTile(x - 1, y).connectsToWater;
            final boolean r = !level.getTile(x + 1, y).connectsToWater;
            final boolean su = u && level.getTile(x, y - 1).connectsToSand;
            final boolean sd = d && level.getTile(x, y + 1).connectsToSand;
            final boolean sl = l && level.getTile(x - 1, y).connectsToSand;
            final boolean sr = r && level.getTile(x + 1, y).connectsToSand;
            if (!u && !l) {
                screen.render(x * 16 + 0, y * 16 + 0, this.wRandom.nextInt(4), col16, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 14 : 15) + (u ? 0 : 1) * 32, (su || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!u && !r) {
                screen.render(x * 16 + 8, y * 16 + 0, this.wRandom.nextInt(4), col16, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 16 : 15) + (u ? 0 : 1) * 32, (su || sr) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !l) {
                screen.render(x * 16 + 0, y * 16 + 8, this.wRandom.nextInt(4), col16, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 14 : 15) + (d ? 2 : 1) * 32, (sd || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !r) {
                screen.render(x * 16 + 8, y * 16 + 8, this.wRandom.nextInt(4), col16, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 16 : 15) + (d ? 2 : 1) * 32, (sd || sr) ? transitionColor2 : transitionColor1, 0);
            }
        }
    }
    
    @Override
    public boolean mayPass(final Level level, final int x, final int y, final Entity e) {
        if (e instanceof AirWizard) {
            final AirWizard aw = (AirWizard)e;
            if (aw.secondform) {
                return true;
            }
        }
        return e.canSwim();
    }
    
    @Override
    public void tick(final Level level, final int xt, final int yt) {
        int xn = xt;
        int yn = yt;
        if (this.random.nextBoolean()) {
            xn += this.random.nextInt(2) * 2 - 1;
        }
        else {
            yn += this.random.nextInt(2) * 2 - 1;
        }
        for (int i = -1; i < 1; ++i) {
            for (int ii = -1; ii < 1; ++ii) {
                if (level.getTile(xn, yn) == Tile.hole) {
                    level.setTile(xn, yn, this, 0);
                }
            }
        }
        for (int i = -1; i < 1; ++i) {
            for (int ii = -1; ii < 1; ++ii) {
                if (level.getTile(xn + i, yn + ii) == Tile.lighthole) {
                    level.setTile(xn + i, yn + ii, this, 0);
                }
            }
        }
        for (int i = -1; i < 2; ++i) {
            for (int ii = -1; ii < 2; ++ii) {
                if (level.getTile(xt + i, yt + ii) == Tile.lava) {
                    level.setTile(xt + i, yt + ii, WaterTile.sbrick, 0);
                }
            }
        }
    }
}
