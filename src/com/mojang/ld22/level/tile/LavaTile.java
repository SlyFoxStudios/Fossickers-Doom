// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.level.tile;

import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.Game;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.gfx.Screen;
import java.util.Random;

public class LavaTile extends Tile
{
    private Random wRandom;
    
    public LavaTile(final int id) {
        super(id);
        this.wRandom = new Random();
        this.connectsToSand = true;
        this.connectsToLava = true;
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        final int col0 = Color.get(400, 400, 520, 450);
        final int col2 = Color.get(3, 400, 211, 322);
        final int col3 = Color.get(3, 400, 330, 440);
        final int col4 = Color.get(500, 500, 520, 450);
        final int col5 = Color.get(3, 500, 211, 322);
        final int col6 = Color.get(3, 500, 440, 550);
        final int col7 = Color.get(400, 400, 420, 450);
        final int col8 = Color.get(3, 400, 100, 211);
        final int col9 = Color.get(3, 400, 220, 330);
        final int col10 = Color.get(300, 300, 320, 350);
        final int col11 = Color.get(3, 300, 0, 100);
        final int col12 = Color.get(3, 300, 110, 220);
        final int col13 = Color.get(500, 500, 520, 550);
        final int col14 = Color.get(3, 500, 111, 222);
        final int col15 = Color.get(3, 500, 440, 550);
        final int col16 = Color.get(500, 500, 520, 550);
        final int col17 = Color.get(3, 500, 159, 59);
        final int col18 = Color.get(3, 500, 440, 550);
        if (level.dirtColor == 322 && Game.Time == 0) {
            this.wRandom.setSeed((LavaTile.tickCount + (x / 2 - y) * 4311) / 10 * 54687121L + x * 3271612L + y * 3412987161L);
            final int col19 = col0;
            final int transitionColor1 = col2;
            final int transitionColor2 = col3;
            final boolean u = !level.getTile(x, y - 1).connectsToLava;
            final boolean d = !level.getTile(x, y + 1).connectsToLava;
            final boolean l = !level.getTile(x - 1, y).connectsToLava;
            final boolean r = !level.getTile(x + 1, y).connectsToLava;
            final boolean su = u && level.getTile(x, y - 1).connectsToSand;
            final boolean sd = d && level.getTile(x, y + 1).connectsToSand;
            final boolean sl = l && level.getTile(x - 1, y).connectsToSand;
            final boolean sr = r && level.getTile(x + 1, y).connectsToSand;
            if (!u && !l) {
                screen.render(x * 16 + 0, y * 16 + 0, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 14 : 15) + (u ? 0 : 1) * 32, (su || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!u && !r) {
                screen.render(x * 16 + 8, y * 16 + 0, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 16 : 15) + (u ? 0 : 1) * 32, (su || sr) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !l) {
                screen.render(x * 16 + 0, y * 16 + 8, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 14 : 15) + (d ? 2 : 1) * 32, (sd || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !r) {
                screen.render(x * 16 + 8, y * 16 + 8, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 16 : 15) + (d ? 2 : 1) * 32, (sd || sr) ? transitionColor2 : transitionColor1, 0);
            }
        }
        if (Game.Time == 1) {
            this.wRandom.setSeed((LavaTile.tickCount + (x / 2 - y) * 4311) / 10 * 54687121L + x * 3271612L + y * 3412987161L);
            final int col19 = col4;
            final int transitionColor1 = col5;
            final int transitionColor2 = col6;
            final boolean u = !level.getTile(x, y - 1).connectsToLava;
            final boolean d = !level.getTile(x, y + 1).connectsToLava;
            final boolean l = !level.getTile(x - 1, y).connectsToLava;
            final boolean r = !level.getTile(x + 1, y).connectsToLava;
            final boolean su = u && level.getTile(x, y - 1).connectsToSand;
            final boolean sd = d && level.getTile(x, y + 1).connectsToSand;
            final boolean sl = l && level.getTile(x - 1, y).connectsToSand;
            final boolean sr = r && level.getTile(x + 1, y).connectsToSand;
            if (!u && !l) {
                screen.render(x * 16 + 0, y * 16 + 0, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 14 : 15) + (u ? 0 : 1) * 32, (su || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!u && !r) {
                screen.render(x * 16 + 8, y * 16 + 0, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 16 : 15) + (u ? 0 : 1) * 32, (su || sr) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !l) {
                screen.render(x * 16 + 0, y * 16 + 8, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 14 : 15) + (d ? 2 : 1) * 32, (sd || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !r) {
                screen.render(x * 16 + 8, y * 16 + 8, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 16 : 15) + (d ? 2 : 1) * 32, (sd || sr) ? transitionColor2 : transitionColor1, 0);
            }
        }
        if (Game.Time == 2) {
            this.wRandom.setSeed((LavaTile.tickCount + (x / 2 - y) * 4311) / 10 * 54687121L + x * 3271612L + y * 3412987161L);
            final int col19 = col7;
            final int transitionColor1 = col8;
            final int transitionColor2 = col9;
            final boolean u = !level.getTile(x, y - 1).connectsToLava;
            final boolean d = !level.getTile(x, y + 1).connectsToLava;
            final boolean l = !level.getTile(x - 1, y).connectsToLava;
            final boolean r = !level.getTile(x + 1, y).connectsToLava;
            final boolean su = u && level.getTile(x, y - 1).connectsToSand;
            final boolean sd = d && level.getTile(x, y + 1).connectsToSand;
            final boolean sl = l && level.getTile(x - 1, y).connectsToSand;
            final boolean sr = r && level.getTile(x + 1, y).connectsToSand;
            if (!u && !l) {
                screen.render(x * 16 + 0, y * 16 + 0, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 14 : 15) + (u ? 0 : 1) * 32, (su || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!u && !r) {
                screen.render(x * 16 + 8, y * 16 + 0, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 16 : 15) + (u ? 0 : 1) * 32, (su || sr) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !l) {
                screen.render(x * 16 + 0, y * 16 + 8, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 14 : 15) + (d ? 2 : 1) * 32, (sd || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !r) {
                screen.render(x * 16 + 8, y * 16 + 8, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 16 : 15) + (d ? 2 : 1) * 32, (sd || sr) ? transitionColor2 : transitionColor1, 0);
            }
        }
        if (Game.Time == 3) {
            this.wRandom.setSeed((LavaTile.tickCount + (x / 2 - y) * 4311) / 10 * 54687121L + x * 3271612L + y * 3412987161L);
            final int col19 = col10;
            final int transitionColor1 = col11;
            final int transitionColor2 = col12;
            final boolean u = !level.getTile(x, y - 1).connectsToLava;
            final boolean d = !level.getTile(x, y + 1).connectsToLava;
            final boolean l = !level.getTile(x - 1, y).connectsToLava;
            final boolean r = !level.getTile(x + 1, y).connectsToLava;
            final boolean su = u && level.getTile(x, y - 1).connectsToSand;
            final boolean sd = d && level.getTile(x, y + 1).connectsToSand;
            final boolean sl = l && level.getTile(x - 1, y).connectsToSand;
            final boolean sr = r && level.getTile(x + 1, y).connectsToSand;
            if (!u && !l) {
                screen.render(x * 16 + 0, y * 16 + 0, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 14 : 15) + (u ? 0 : 1) * 32, (su || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!u && !r) {
                screen.render(x * 16 + 8, y * 16 + 0, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 16 : 15) + (u ? 0 : 1) * 32, (su || sr) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !l) {
                screen.render(x * 16 + 0, y * 16 + 8, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 14 : 15) + (d ? 2 : 1) * 32, (sd || sl) ? transitionColor2 : transitionColor1, 0);
            }
            if (!d && !r) {
                screen.render(x * 16 + 8, y * 16 + 8, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 16 : 15) + (d ? 2 : 1) * 32, (sd || sr) ? transitionColor2 : transitionColor1, 0);
            }
        }
        if (level.dirtColor == 222) {
            if (level.cl != -4) {
                this.wRandom.setSeed((LavaTile.tickCount + (x / 2 - y) * 4311) / 10 * 54687121L + x * 3271612L + y * 3412987161L);
                final int col19 = col13;
                final int transitionColor1 = col14;
                final int transitionColor2 = col15;
                final boolean u = !level.getTile(x, y - 1).connectsToLava;
                final boolean d = !level.getTile(x, y + 1).connectsToLava;
                final boolean l = !level.getTile(x - 1, y).connectsToLava;
                final boolean r = !level.getTile(x + 1, y).connectsToLava;
                final boolean su = u && level.getTile(x, y - 1).connectsToSand;
                final boolean sd = d && level.getTile(x, y + 1).connectsToSand;
                final boolean sl = l && level.getTile(x - 1, y).connectsToSand;
                final boolean sr = r && level.getTile(x + 1, y).connectsToSand;
                if (!u && !l) {
                    screen.render(x * 16 + 0, y * 16 + 0, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, (l ? 14 : 15) + (u ? 0 : 1) * 32, (su || sl) ? transitionColor2 : transitionColor1, 0);
                }
                if (!u && !r) {
                    screen.render(x * 16 + 8, y * 16 + 0, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 0, (r ? 16 : 15) + (u ? 0 : 1) * 32, (su || sr) ? transitionColor2 : transitionColor1, 0);
                }
                if (!d && !l) {
                    screen.render(x * 16 + 0, y * 16 + 8, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 8, (l ? 14 : 15) + (d ? 2 : 1) * 32, (sd || sl) ? transitionColor2 : transitionColor1, 0);
                }
                if (!d && !r) {
                    screen.render(x * 16 + 8, y * 16 + 8, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, (r ? 16 : 15) + (d ? 2 : 1) * 32, (sd || sr) ? transitionColor2 : transitionColor1, 0);
                }
            }
            else if (level.cl == -4) {
                this.wRandom.setSeed((LavaTile.tickCount + (x / 2 - y) * 4311) / 10 * 54687121L + x * 3271612L + y * 3412987161L);
                final int col19 = col16;
                final int transitionColor1 = col17;
                final int transitionColor2 = col18;
                final boolean u = !level.getTile(x, y - 1).connectsToLava;
                final boolean d = !level.getTile(x, y + 1).connectsToLava;
                final boolean l = !level.getTile(x - 1, y).connectsToLava;
                final boolean r = !level.getTile(x + 1, y).connectsToLava;
                final boolean su = u && level.getTile(x, y - 1).connectsToSand;
                final boolean sd = d && level.getTile(x, y + 1).connectsToSand;
                final boolean sl = l && level.getTile(x - 1, y).connectsToSand;
                final boolean sr = r && level.getTile(x + 1, y).connectsToSand;
                if (!u && !l) {
                    screen.render(x * 16 + 0, y * 16 + 0, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, (l ? 14 : 15) + (u ? 0 : 1) * 32, (su || sl) ? transitionColor2 : transitionColor1, 0);
                }
                if (!u && !r) {
                    screen.render(x * 16 + 8, y * 16 + 0, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 0, (r ? 16 : 15) + (u ? 0 : 1) * 32, (su || sr) ? transitionColor2 : transitionColor1, 0);
                }
                if (!d && !l) {
                    screen.render(x * 16 + 0, y * 16 + 8, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 8, (l ? 14 : 15) + (d ? 2 : 1) * 32, (sd || sl) ? transitionColor2 : transitionColor1, 0);
                }
                if (!d && !r) {
                    screen.render(x * 16 + 8, y * 16 + 8, this.wRandom.nextInt(4), col19, this.wRandom.nextInt(4));
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, (r ? 16 : 15) + (d ? 2 : 1) * 32, (sd || sr) ? transitionColor2 : transitionColor1, 0);
                }
            }
        }
    }
    
    @Override
    public boolean mayPass(final Level level, final int x, final int y, final Entity e) {
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
        if (level.getTile(xn, yn) == Tile.hole) {
            level.setTile(xn, yn, this, 0);
        }
    }
    
    @Override
    public int getLightRadius(final Level level, final int x, final int y) {
        if (level.depth != 0) {
            return 6;
        }
        return 0;
    }
}
