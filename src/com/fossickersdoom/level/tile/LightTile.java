// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.level.tile;

import com.fossickersdoom.entity.Entity;
import com.fossickersdoom.entity.ItemEntity;
import com.fossickersdoom.entity.Mob;
import com.fossickersdoom.entity.Player;
import com.fossickersdoom.entity.particle.SmashParticle;
import com.fossickersdoom.entity.particle.TextParticle;
import com.fossickersdoom.item.Item;
import com.fossickersdoom.item.ToolItem;
import com.fossickersdoom.item.resource.Resource;
import com.fossickersdoom.level.Level;
import com.fossickersdoom.screen.ModeMenu;
import com.fossickersdoom.screen.StartMenu;
import com.fossickersdoom.sound.Sound;
import com.fossickersdoom.item.ToolType;
import com.fossickersdoom.item.ResourceItem;
import com.fossickersdoom.gfx.Screen;
import com.fossickersdoom.gfx.Color;
import java.util.Random;

public class LightTile extends Tile
{
    private Tile onType;
    private Random wRandom;
    int til;
    public static int col0;
    public static int col00;
    public static int col1;
    public static int col11;
    public static int col2;
    public static int col22;
    public static int col222;
    public static int col3;
    int col4;
    int col44;
    int col444;
    int col5;
    int col6;
    int col7;
    int col8;
    int col9;
    int col10;
    int col111;
    int col12;
    int col13;
    int col14;
    int col114;
    int col1114;
    int col15;
    int col16;
    int col17;
    int col18;
    int col19;
    int col20;
    int col21;
    int col2222;
    
    static {
        LightTile.col0 = Color.get(141, 141, 252, 322);
        LightTile.col00 = Color.get(141, 141, 252, 322);
        LightTile.col1 = Color.get(552, 550, 440, 440);
        LightTile.col11 = Color.get(440, 550, 440, 322);
        LightTile.col2 = Color.get(10, 30, 151, 141);
        LightTile.col22 = Color.get(10, 30, 430, 141);
        LightTile.col222 = Color.get(10, 30, 320, 141);
        LightTile.col3 = Color.get(30, 40, 50, 550);
    }
    
    public LightTile(final int id, final Tile onType, final int tile) {
        super(id);
        this.wRandom = new Random();
        this.til = 0;
        this.col4 = Color.get(5, 105, 115, 115);
        this.col44 = Color.get(3, 105, 211, 322);
        this.col444 = Color.get(3, 105, 440, 550);
        this.col5 = Color.get(321, 321, 210, 210);
        this.col6 = Color.get(10, 141, 555, 440);
        this.col7 = Color.get(321, 0, 444, 555);
        this.col8 = Color.get(210, 210, 430, 320);
        this.col9 = Color.get(333, 333, 444, 444);
        this.col10 = Color.get(320, 430, 430, 210);
        this.col111 = Color.get(320, 430, 210, 430);
        this.col12 = Color.get(444, 333, 333, 222);
        this.col13 = Color.get(444, 333, 222, 333);
        this.col14 = Color.get(222, 222, 220, 220);
        this.col114 = Color.get(3, 222, 211, 321);
        this.col1114 = Color.get(3, 222, 440, 550);
        this.col15 = Color.get(444, 333, 444, 555);
        this.col16 = Color.get(400, 500, 400, 500);
        this.col17 = Color.get(13, 115, 13, 115);
        this.col18 = Color.get(30, 40, 40, 50);
        this.col19 = Color.get(550, 661, 440, 550);
        this.col20 = Color.get(111, 111, 0, 111);
        this.col21 = Color.get(20, 40, 50, 141);
        this.col2222 = Color.get(20, 40, 50, 550);
        this.til = tile;
        if (tile == 0) {
            this.connectsToGrass = true;
        }
        if (tile == 1) {
            this.connectsToSand = true;
        }
        if (tile == 2) {
            this.connectsToGrass = true;
        }
        if (tile == 3) {
            this.connectsToSand = true;
        }
        if (tile == 4) {
            this.connectsToSand = true;
            this.connectsToWater = true;
        }
        if (tile == 5) {
            this.connectsToGrass = false;
        }
        if (tile == 6) {
            this.connectsToGrass = true;
        }
        if (tile == 7) {}
        if (tile == 17) {
            this.connectsToSand = true;
            this.connectsToWater = true;
            this.connectsToLava = true;
        }
        if (tile == 25) {
            this.connectsToGrass = true;
        }
        if (tile == 26) {
            this.connectsToSand = true;
        }
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        if (this.til == 0) {
            final int col = LightTile.col0;
            final int transitionColor = LightTile.col00;
            final boolean u = !level.getTile(x, y - 1).connectsToGrass;
            final boolean d = !level.getTile(x, y + 1).connectsToGrass;
            final boolean l = !level.getTile(x - 1, y).connectsToGrass;
            final boolean r = !level.getTile(x + 1, y).connectsToGrass;
            if (!u && !l) {
                screen.render(x * 16 + 0, y * 16 + 0, 0, col, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 11 : 12) + (u ? 0 : 1) * 32, transitionColor, 0);
            }
            if (!u && !r) {
                screen.render(x * 16 + 8, y * 16 + 0, 1, col, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 13 : 12) + (u ? 0 : 1) * 32, transitionColor, 0);
            }
            if (!d && !l) {
                screen.render(x * 16 + 0, y * 16 + 8, 2, col, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 11 : 12) + (d ? 2 : 1) * 32, transitionColor, 0);
            }
            if (!d && !r) {
                screen.render(x * 16 + 8, y * 16 + 8, 3, col, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 13 : 12) + (d ? 2 : 1) * 32, transitionColor, 0);
            }
        }
        else if (this.til == 1) {
            final int col = LightTile.col1;
            final int transitionColor = LightTile.col11;
            final boolean u = !level.getTile(x, y - 1).connectsToSand;
            final boolean d = !level.getTile(x, y + 1).connectsToSand;
            final boolean l = !level.getTile(x - 1, y).connectsToSand;
            final boolean r = !level.getTile(x + 1, y).connectsToSand;
            if (!u && !l) {
                screen.render(x * 16 + 0, y * 16 + 0, 0, col, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 11 : 12) + (u ? 0 : 1) * 32, transitionColor, 0);
            }
            if (!u && !r) {
                screen.render(x * 16 + 8, y * 16 + 0, 1, col, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 13 : 12) + (u ? 0 : 1) * 32, transitionColor, 0);
            }
            if (!d && !l) {
                screen.render(x * 16 + 0, y * 16 + 8, 2, col, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 11 : 12) + (d ? 2 : 1) * 32, transitionColor, 0);
            }
            if (!d && !r) {
                screen.render(x * 16 + 8, y * 16 + 8, 3, col, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 13 : 12) + (d ? 2 : 1) * 32, transitionColor, 0);
            }
        }
        else if (this.til == 2) {
            final int col = LightTile.col2;
            final int barkCol1 = LightTile.col22;
            final int barkCol2 = LightTile.col222;
            final boolean u2 = level.getTile(x, y - 1) == this;
            final boolean l = level.getTile(x - 1, y) == this;
            final boolean r = level.getTile(x + 1, y) == this;
            final boolean d2 = level.getTile(x, y + 1) == this;
            final boolean ul = level.getTile(x - 1, y - 1) == this;
            final boolean ur = level.getTile(x + 1, y - 1) == this;
            final boolean dl = level.getTile(x - 1, y + 1) == this;
            final boolean dr = level.getTile(x + 1, y + 1) == this;
            if (u2 && ul && l) {
                screen.render(x * 16 + 0, y * 16 + 0, 42, col, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, 9, col, 0);
            }
            if (u2 && ur && r) {
                screen.render(x * 16 + 8, y * 16 + 0, 74, barkCol2, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, 10, col, 0);
            }
            if (d2 && dl && l) {
                screen.render(x * 16 + 0, y * 16 + 8, 74, barkCol2, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, 41, barkCol1, 0);
            }
            if (d2 && dr && r) {
                screen.render(x * 16 + 8, y * 16 + 8, 42, col, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, 106, barkCol2, 0);
            }
        }
        else if (this.til == 3) {
            final int col = LightTile.col3;
            screen.render(x * 16 + 0, y * 16 + 0, 72, col, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 73, col, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 104, col, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 105, col, 0);
        }
        else if (this.til == 4) {
            this.wRandom.setSeed((LightTile.tickCount + (x / 2 - y) * 4311) / 10 * 54687121L + x * 3271612L + y * 3412987161L);
            final int col = this.col4;
            final int transitionColor2 = this.col44;
            final int transitionColor3 = this.col444;
            final boolean u2 = !level.getTile(x, y - 1).connectsToWater;
            final boolean d3 = !level.getTile(x, y + 1).connectsToWater;
            final boolean i = !level.getTile(x - 1, y).connectsToWater;
            final boolean r2 = !level.getTile(x + 1, y).connectsToWater;
            final boolean su = u2 && level.getTile(x, y - 1).connectsToSand;
            final boolean sd = d3 && level.getTile(x, y + 1).connectsToSand;
            final boolean sl = i && level.getTile(x - 1, y).connectsToSand;
            final boolean sr = r2 && level.getTile(x + 1, y).connectsToSand;
            if (!u2 && !i) {
                screen.render(x * 16 + 0, y * 16 + 0, this.wRandom.nextInt(4), col, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (i ? 14 : 15) + (u2 ? 0 : 1) * 32, (su || sl) ? transitionColor3 : transitionColor2, 0);
            }
            if (!u2 && !r2) {
                screen.render(x * 16 + 8, y * 16 + 0, this.wRandom.nextInt(4), col, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r2 ? 16 : 15) + (u2 ? 0 : 1) * 32, (su || sr) ? transitionColor3 : transitionColor2, 0);
            }
            if (!d3 && !i) {
                screen.render(x * 16 + 0, y * 16 + 8, this.wRandom.nextInt(4), col, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (i ? 14 : 15) + (d3 ? 2 : 1) * 32, (sd || sl) ? transitionColor3 : transitionColor2, 0);
            }
            if (!d3 && !r2) {
                screen.render(x * 16 + 8, y * 16 + 8, this.wRandom.nextInt(4), col, this.wRandom.nextInt(4));
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r2 ? 16 : 15) + (d3 ? 2 : 1) * 32, (sd || sr) ? transitionColor3 : transitionColor2, 0);
            }
        }
        else if (this.til == 5) {
            int col = this.col5;
            if (level.depth != 0) {
                col = Color.get(222, 222, 111, 111);
            }
            screen.render(x * 16 + 0, y * 16 + 0, 0, col, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 1, col, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 2, col, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 3, col, 0);
        }
        else if (this.til == 6) {
            final int flowerCol = this.col6;
            screen.render(x * 16 + 0, y * 16 + 0, 33, flowerCol, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 2, Color.get(141, 141, 252, 322), 0);
            screen.render(x * 16 + 0, y * 16 + 8, 2, Color.get(141, 141, 252, 322), 0);
            screen.render(x * 16 + 8, y * 16 + 8, 33, flowerCol, 0);
        }
        else if (this.til == 7) {
            final int color = this.col7;
            final int xt = 2;
            screen.render(x * 16 + 0, y * 16 + 0, xt + 64, color, 0);
            screen.render(x * 16 + 8, y * 16 + 0, xt + 1 + 64, color, 0);
            screen.render(x * 16 + 0, y * 16 + 8, xt + 96, color, 0);
            screen.render(x * 16 + 8, y * 16 + 8, xt + 1 + 96, color, 0);
        }
        else if (this.til == 8) {
            final int color = this.col7;
            final int xt = 0;
            screen.render(x * 16 + 0, y * 16 + 0, xt + 64, color, 0);
            screen.render(x * 16 + 8, y * 16 + 0, xt + 1 + 64, color, 0);
            screen.render(x * 16 + 0, y * 16 + 8, xt + 96, color, 0);
            screen.render(x * 16 + 8, y * 16 + 8, xt + 1 + 96, color, 0);
        }
        else if (this.til == 9) {
            final int col = this.col8;
            screen.render(x * 16 + 0, y * 16 + 0, 51, col, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 51, col, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 51, col, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 51, col, 0);
        }
        else if (this.til == 10) {
            final int col = this.col9;
            screen.render(x * 16 + 0, y * 16 + 0, 83, col, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 83, col, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 83, col, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 83, col, 0);
        }
        else if (this.til == 11) {
            final int col = this.col10;
            screen.render(x * 16 + 0, y * 16 + 0, 704, col, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 705, col, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 736, col, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 737, col, 0);
        }
        else if (this.til == 12) {
            final int col = this.col111;
            screen.render(x * 16 + 0, y * 16 + 0, 706, col, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 707, col, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 738, col, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 739, col, 0);
        }
        else if (this.til == 13) {
            final int col = this.col12;
            screen.render(x * 16 + 0, y * 16 + 0, 768, col, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 769, col, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 800, col, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 801, col, 0);
        }
        else if (this.til == 14) {
            final int col = this.col13;
            screen.render(x * 16 + 0, y * 16 + 0, 770, col, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 771, col, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 802, col, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 803, col, 0);
        }
        else if (this.til == 17) {
            final int col = this.col14;
            final int transitionColor2 = this.col114;
            final int transitionColor3 = this.col1114;
            final boolean u2 = !level.getTile(x, y - 1).connectsToLiquid();
            final boolean d3 = !level.getTile(x, y + 1).connectsToLiquid();
            final boolean i = !level.getTile(x - 1, y).connectsToLiquid();
            final boolean r2 = !level.getTile(x + 1, y).connectsToLiquid();
            final boolean su = u2 && level.getTile(x, y - 1).connectsToSand;
            final boolean sd = d3 && level.getTile(x, y + 1).connectsToSand;
            final boolean sl = i && level.getTile(x - 1, y).connectsToSand;
            final boolean sr = r2 && level.getTile(x + 1, y).connectsToSand;
            if (!u2 && !i) {
                screen.render(x * 16 + 0, y * 16 + 0, 0, col, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (i ? 14 : 15) + (u2 ? 0 : 1) * 32, (su || sl) ? transitionColor3 : transitionColor2, 0);
            }
            if (!u2 && !r2) {
                screen.render(x * 16 + 8, y * 16 + 0, 1, col, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r2 ? 16 : 15) + (u2 ? 0 : 1) * 32, (su || sr) ? transitionColor3 : transitionColor2, 0);
            }
            if (!d3 && !i) {
                screen.render(x * 16 + 0, y * 16 + 8, 2, col, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (i ? 14 : 15) + (d3 ? 2 : 1) * 32, (sd || sl) ? transitionColor3 : transitionColor2, 0);
            }
            if (!d3 && !r2) {
                screen.render(x * 16 + 8, y * 16 + 8, 3, col, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r2 ? 16 : 15) + (d3 ? 2 : 1) * 32, (sd || sr) ? transitionColor3 : transitionColor2, 0);
            }
        }
        else if (this.til == 18) {
            final int col = this.col15;
            screen.render(x * 16 + 0, y * 16 + 0, 17, col, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 17, col, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 17, col, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 17, col, 0);
        }
        else if (this.til == 19) {
            final int col = this.col16;
            screen.render(x * 16 + 0, y * 16 + 0, 17, col, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 17, col, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 17, col, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 17, col, 0);
        }
        else if (this.til == 20) {
            final int col = this.col17;
            screen.render(x * 16 + 0, y * 16 + 0, 17, col, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 17, col, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 17, col, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 17, col, 0);
        }
        else if (this.til == 21) {
            final int col = this.col18;
            screen.render(x * 16 + 0, y * 16 + 0, 17, col, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 17, col, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 17, col, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 17, col, 0);
        }
        else if (this.til == 22) {
            final int col = this.col19;
            screen.render(x * 16 + 0, y * 16 + 0, 17, col, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 17, col, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 17, col, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 17, col, 0);
        }
        else if (this.til == 23) {
            final int col = this.col20;
            screen.render(x * 16 + 0, y * 16 + 0, 17, col, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 17, col, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 17, col, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 17, col, 0);
        }
        else if (this.til == 25) {
            final int col = this.col21;
            final int col2 = LightTile.col0;
            screen.render(x * 16 + 0, y * 16 + 0, 0, col2, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 0, col2, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 0, col2, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 0, col2, 0);
            screen.render(x * 16 + 4, y * 16 + 4, 107, col, 0);
        }
        else if (this.til == 26) {
            final int col = this.col2222;
            final int col2 = LightTile.col1;
            screen.render(x * 16 + 0, y * 16 + 0, 0, col2, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 0, col2, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 0, col2, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 0, col2, 0);
            screen.render(x * 16 + 4, y * 16 + 4, 107, col, 0);
        }
    }
    
    @Override
    public boolean mayPass(final Level level, final int x, final int y, final Entity e) {
        if (this.til == 4) {
            return e.canSwim();
        }
        if (this.til == 17) {
            return e.canSwim();
        }
        return this.til != 2 && (this.til != 3 && this.til != 4 && this.til != 12 && this.til != 14);
    }
    
    @Override
    public void bumpedInto(final Level level, final int x, final int y, final Entity entity) {
        if (this.til == 3) {
            if (StartMenu.diff == StartMenu.easy) {
                entity.hurt(this, x, y, 1);
            }
            if (StartMenu.diff == StartMenu.norm) {
                entity.hurt(this, x, y, 1);
            }
            if (StartMenu.diff == StartMenu.hard) {
                entity.hurt(this, x, y, 2);
            }
        }
    }
    
    @Override
    public void tick(final Level level, final int xt, final int yt) {
        if (level.getTile(xt, yt + 1) != Tile.torchgrass && level.getTile(xt, yt - 1) != Tile.torchgrass && level.getTile(xt + 1, yt) != Tile.torchgrass && level.getTile(xt - 1, yt) != Tile.torchgrass && level.getTile(xt, yt + 2) != Tile.torchgrass && level.getTile(xt, yt - 2) != Tile.torchgrass && level.getTile(xt + 2, yt) != Tile.torchgrass && level.getTile(xt - 2, yt) != Tile.torchgrass && level.getTile(xt + 1, yt + 1) != Tile.torchgrass && level.getTile(xt - 1, yt + 1) != Tile.torchgrass && level.getTile(xt - 1, yt - 1) != Tile.torchgrass && level.getTile(xt + 1, yt - 1) != Tile.torchgrass && level.getTile(xt, yt + 1) != Tile.torchsand && level.getTile(xt, yt - 1) != Tile.torchsand && level.getTile(xt + 1, yt) != Tile.torchsand && level.getTile(xt - 1, yt) != Tile.torchsand && level.getTile(xt, yt + 2) != Tile.torchsand && level.getTile(xt, yt - 2) != Tile.torchsand && level.getTile(xt + 2, yt) != Tile.torchsand && level.getTile(xt - 2, yt) != Tile.torchsand && level.getTile(xt + 1, yt + 1) != Tile.torchsand && level.getTile(xt - 1, yt + 1) != Tile.torchsand && level.getTile(xt - 1, yt - 1) != Tile.torchsand && level.getTile(xt + 1, yt - 1) != Tile.torchsand && level.getTile(xt, yt + 1) != Tile.torchdirt && level.getTile(xt, yt - 1) != Tile.torchdirt && level.getTile(xt + 1, yt) != Tile.torchdirt && level.getTile(xt - 1, yt) != Tile.torchdirt && level.getTile(xt, yt + 2) != Tile.torchdirt && level.getTile(xt, yt - 2) != Tile.torchdirt && level.getTile(xt + 2, yt) != Tile.torchdirt && level.getTile(xt - 2, yt) != Tile.torchdirt && level.getTile(xt + 1, yt + 1) != Tile.torchdirt && level.getTile(xt - 1, yt + 1) != Tile.torchdirt && level.getTile(xt - 1, yt - 1) != Tile.torchdirt && level.getTile(xt + 1, yt - 1) != Tile.torchdirt && level.getTile(xt, yt + 1) != Tile.torchplank && level.getTile(xt, yt - 1) != Tile.torchplank && level.getTile(xt + 1, yt) != Tile.torchplank && level.getTile(xt - 1, yt) != Tile.torchplank && level.getTile(xt, yt + 2) != Tile.torchplank && level.getTile(xt, yt - 2) != Tile.torchplank && level.getTile(xt + 2, yt) != Tile.torchplank && level.getTile(xt - 2, yt) != Tile.torchplank && level.getTile(xt + 1, yt + 1) != Tile.torchplank && level.getTile(xt - 1, yt + 1) != Tile.torchplank && level.getTile(xt - 1, yt - 1) != Tile.torchplank && level.getTile(xt + 1, yt - 1) != Tile.torchplank && level.getTile(xt, yt + 1) != Tile.torchsbrick && level.getTile(xt, yt - 1) != Tile.torchsbrick && level.getTile(xt + 1, yt) != Tile.torchsbrick && level.getTile(xt - 1, yt) != Tile.torchsbrick && level.getTile(xt, yt + 2) != Tile.torchsbrick && level.getTile(xt, yt - 2) != Tile.torchsbrick && level.getTile(xt + 2, yt) != Tile.torchsbrick && level.getTile(xt - 2, yt) != Tile.torchsbrick && level.getTile(xt + 1, yt + 1) != Tile.torchsbrick && level.getTile(xt - 1, yt + 1) != Tile.torchsbrick && level.getTile(xt - 1, yt - 1) != Tile.torchsbrick && level.getTile(xt + 1, yt - 1) != Tile.torchsbrick && level.getTile(xt, yt + 1) != Tile.torchlo && level.getTile(xt, yt - 1) != Tile.torchlo && level.getTile(xt + 1, yt) != Tile.torchlo && level.getTile(xt - 1, yt) != Tile.torchlo && level.getTile(xt, yt + 2) != Tile.torchlo && level.getTile(xt, yt - 2) != Tile.torchlo && level.getTile(xt + 2, yt) != Tile.torchlo && level.getTile(xt - 2, yt) != Tile.torchlo && level.getTile(xt + 1, yt + 1) != Tile.torchlo && level.getTile(xt - 1, yt + 1) != Tile.torchlo && level.getTile(xt - 1, yt - 1) != Tile.torchlo && level.getTile(xt + 1, yt - 1) != Tile.torchlo && level.getTile(xt, yt + 1) != Tile.torchwool && level.getTile(xt, yt - 1) != Tile.torchwool && level.getTile(xt + 1, yt) != Tile.torchwool && level.getTile(xt - 1, yt) != Tile.torchwool && level.getTile(xt, yt + 2) != Tile.torchwool && level.getTile(xt, yt - 2) != Tile.torchwool && level.getTile(xt + 2, yt) != Tile.torchwool && level.getTile(xt - 2, yt) != Tile.torchwool && level.getTile(xt + 1, yt + 1) != Tile.torchwool && level.getTile(xt - 1, yt + 1) != Tile.torchwool && level.getTile(xt - 1, yt - 1) != Tile.torchwool && level.getTile(xt + 1, yt - 1) != Tile.torchwool && level.getTile(xt, yt + 1) != Tile.torchwoolred && level.getTile(xt, yt - 1) != Tile.torchwoolred && level.getTile(xt + 1, yt) != Tile.torchwoolred && level.getTile(xt - 1, yt) != Tile.torchwoolred && level.getTile(xt, yt + 2) != Tile.torchwoolred && level.getTile(xt, yt - 2) != Tile.torchwoolred && level.getTile(xt + 2, yt) != Tile.torchwoolred && level.getTile(xt - 2, yt) != Tile.torchwoolred && level.getTile(xt + 1, yt + 1) != Tile.torchwoolred && level.getTile(xt - 1, yt + 1) != Tile.torchwoolred && level.getTile(xt - 1, yt - 1) != Tile.torchwoolred && level.getTile(xt + 1, yt - 1) != Tile.torchwoolred && level.getTile(xt, yt + 1) != Tile.torchwoolblue && level.getTile(xt, yt - 1) != Tile.torchwoolblue && level.getTile(xt + 1, yt) != Tile.torchwoolblue && level.getTile(xt - 1, yt) != Tile.torchwoolblue && level.getTile(xt, yt + 2) != Tile.torchwoolblue && level.getTile(xt, yt - 2) != Tile.torchwoolblue && level.getTile(xt + 2, yt) != Tile.torchwoolblue && level.getTile(xt - 2, yt) != Tile.torchwoolblue && level.getTile(xt + 1, yt + 1) != Tile.torchwoolblue && level.getTile(xt - 1, yt + 1) != Tile.torchwoolblue && level.getTile(xt - 1, yt - 1) != Tile.torchwoolblue && level.getTile(xt + 1, yt - 1) != Tile.torchwoolblue && level.getTile(xt, yt + 1) != Tile.torchwoolgreen && level.getTile(xt, yt - 1) != Tile.torchwoolgreen && level.getTile(xt + 1, yt) != Tile.torchwoolgreen && level.getTile(xt - 1, yt) != Tile.torchwoolgreen && level.getTile(xt, yt + 2) != Tile.torchwoolgreen && level.getTile(xt, yt - 2) != Tile.torchwoolgreen && level.getTile(xt + 2, yt) != Tile.torchwoolgreen && level.getTile(xt - 2, yt) != Tile.torchwoolgreen && level.getTile(xt + 1, yt + 1) != Tile.torchwoolgreen && level.getTile(xt - 1, yt + 1) != Tile.torchwoolgreen && level.getTile(xt - 1, yt - 1) != Tile.torchwoolgreen && level.getTile(xt + 1, yt - 1) != Tile.torchwoolgreen && level.getTile(xt, yt + 1) != Tile.torchwoolyellow && level.getTile(xt, yt - 1) != Tile.torchwoolyellow && level.getTile(xt + 1, yt) != Tile.torchwoolyellow && level.getTile(xt - 1, yt) != Tile.torchwoolyellow && level.getTile(xt, yt + 2) != Tile.torchwoolyellow && level.getTile(xt, yt - 2) != Tile.torchwoolyellow && level.getTile(xt + 2, yt) != Tile.torchwoolyellow && level.getTile(xt - 2, yt) != Tile.torchwoolyellow && level.getTile(xt + 1, yt + 1) != Tile.torchwoolyellow && level.getTile(xt - 1, yt + 1) != Tile.torchwoolyellow && level.getTile(xt - 1, yt - 1) != Tile.torchwoolyellow && level.getTile(xt + 1, yt - 1) != Tile.torchwoolyellow && level.getTile(xt, yt + 1) != Tile.torchwoolblack && level.getTile(xt, yt - 1) != Tile.torchwoolblack && level.getTile(xt + 1, yt) != Tile.torchwoolblack && level.getTile(xt - 1, yt) != Tile.torchwoolblack && level.getTile(xt, yt + 2) != Tile.torchwoolblack && level.getTile(xt, yt - 2) != Tile.torchwoolblack && level.getTile(xt + 2, yt) != Tile.torchwoolblack && level.getTile(xt - 2, yt) != Tile.torchwoolblack && level.getTile(xt + 1, yt + 1) != Tile.torchwoolblack && level.getTile(xt - 1, yt + 1) != Tile.torchwoolblack && level.getTile(xt - 1, yt - 1) != Tile.torchwoolblack && level.getTile(xt + 1, yt - 1) != Tile.torchwoolblack) {
            if (this.til == 0) {
                level.setTile(xt, yt, Tile.grass, 0);
            }
            else if (this.til == 1) {
                level.setTile(xt, yt, Tile.sand, 0);
            }
            else if (this.til == 2) {
                level.setTile(xt, yt, Tile.tree, 0);
            }
            else if (this.til == 3) {
                level.setTile(xt, yt, Tile.cactus, 0);
            }
            else if (this.til == 4) {
                level.setTile(xt, yt, Tile.water, 0);
            }
            else if (this.til == 5) {
                level.setTile(xt, yt, Tile.dirt, 0);
            }
            else if (this.til == 6) {
                level.setTile(xt, yt, Tile.flower, 0);
            }
            else if (this.til == 7) {
                level.setTile(xt, yt, Tile.stairsUp, 0);
            }
            else if (this.til == 8) {
                level.setTile(xt, yt, Tile.stairsDown, 0);
            }
            else if (this.til == 9) {
                level.setTile(xt, yt, Tile.plank, 0);
            }
            else if (this.til == 10) {
                level.setTile(xt, yt, Tile.sbrick, 0);
            }
            else if (this.til == 11) {
                level.setTile(xt, yt, Tile.wdo, 0);
            }
            else if (this.til == 12) {
                level.setTile(xt, yt, Tile.wdc, 0);
            }
            else if (this.til == 13) {
                level.setTile(xt, yt, Tile.sdo, 0);
            }
            else if (this.til == 14) {
                level.setTile(xt, yt, Tile.sdc, 0);
            }
            else if (this.til == 15) {
                level.setTile(xt, yt, Tile.odo, 0);
            }
            else if (this.til == 16) {
                level.setTile(xt, yt, Tile.odc, 0);
            }
            else if (this.til == 17) {
                level.setTile(xt, yt, Tile.hole, 0);
            }
            else if (this.til == 18) {
                level.setTile(xt, yt, Tile.wool, 0);
            }
            else if (this.til == 19) {
                level.setTile(xt, yt, Tile.redwool, 0);
            }
            else if (this.til == 20) {
                level.setTile(xt, yt, Tile.bluewool, 0);
            }
            else if (this.til == 21) {
                level.setTile(xt, yt, Tile.greenwool, 0);
            }
            else if (this.til == 22) {
                level.setTile(xt, yt, Tile.yellowwool, 0);
            }
            else if (this.til == 23) {
                level.setTile(xt, yt, Tile.blackwool, 0);
            }
            else if (this.til == 24) {
                level.setTile(xt, yt, Tile.o, 0);
            }
            else if (this.til == 25) {
                level.setTile(xt, yt, Tile.treeSapling, 0);
            }
            else if (this.til == 26) {
                level.setTile(xt, yt, Tile.cactusSapling, 0);
            }
        }
        if (this.til == 0) {
            if (this.random.nextInt(40) != 0) {
                return;
            }
            int xn = xt;
            int yn = yt;
            if (this.random.nextBoolean()) {
                xn += this.random.nextInt(2) * 2 - 1;
            }
            else {
                yn += this.random.nextInt(2) * 2 - 1;
            }
            if (level.getTile(xn, yn) == Tile.dirt) {
                level.setTile(xn, yn, this, 0);
            }
            if (level.getTile(xn, yn) == Tile.lightdirt) {
                level.setTile(xn, yn, this, 0);
            }
        }
        if (this.til == 4) {
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
            if (level.getTile(xn, yn) == Tile.lighthole) {
                level.setTile(xn, yn, this, 0);
            }
        }
        if (this.til == 25) {
            final int age = level.getData(xt, yt) + 1;
            if (age > 100) {
                level.setTile(xt, yt, Tile.lighttree, 0);
            }
            else {
                level.setData(xt, yt, age);
            }
        }
        if (this.til == 26) {
            final int age = level.getData(xt, yt) + 1;
            if (age > 100) {
                level.setTile(xt, yt, Tile.lightcac, 0);
            }
            else {
                level.setData(xt, yt, age);
            }
        }
    }
    
    @Override
    public void hurt(final Level level, final int x, final int y, final Mob source, final int dmg, final int attackDir) {
        if (this.til == 3) {
            final int damage = level.getData(x, y) + dmg;
            int cHealth;
            if (ModeMenu.creative) {
                cHealth = 1;
            }
            else {
                cHealth = 10;
            }
            level.add(new SmashParticle(x * 16 + 8, y * 16 + 8));
            level.add(new TextParticle(new StringBuilder().append(dmg).toString(), x * 16 + 8, y * 16 + 8, Color.get(-1, 500, 500, 500)));
            if (damage >= cHealth) {
                for (int count = this.random.nextInt(2) + 2, i = 0; i < count; ++i) {
                    level.add(new ItemEntity(new ResourceItem(Resource.cactusFlower), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
                }
                level.setTile(x, y, Tile.sand, 0);
            }
            else {
                level.setData(x, y, damage);
            }
        }
        if (this.til == 2) {
            for (int count2 = (this.random.nextInt(100) == 0) ? 1 : 0, j = 0; j < count2; ++j) {
                level.add(new ItemEntity(new ResourceItem(Resource.apple), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
            }
            final int damage = level.getData(x, y) + dmg;
            int treeHealth;
            if (ModeMenu.creative) {
                treeHealth = 1;
            }
            else {
                treeHealth = 20;
            }
            level.add(new SmashParticle(x * 16 + 8, y * 16 + 8));
            level.add(new TextParticle(new StringBuilder().append(dmg).toString(), x * 16 + 8, y * 16 + 8, Color.get(-1, 500, 500, 500)));
            if (damage >= treeHealth) {
                for (int count = this.random.nextInt(2) + 1, i = 0; i < count; ++i) {
                    level.add(new ItemEntity(new ResourceItem(Resource.wood), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
                }
                for (int count = this.random.nextInt(this.random.nextInt(4) + 1), i = 0; i < count; ++i) {
                    level.add(new ItemEntity(new ResourceItem(Resource.acorn), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
                }
                level.setTile(x, y, Tile.grass, 0);
            }
            else {
                level.setData(x, y, damage);
            }
        }
        if (this.til == 6) {
            for (int count2 = this.random.nextInt(2) + 1, j = 0; j < count2; ++j) {
                level.add(new ItemEntity(new ResourceItem(Resource.flower), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
            }
            for (int count2 = this.random.nextInt(2), j = 0; j < count2; ++j) {
                level.add(new ItemEntity(new ResourceItem(Resource.rose), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
            }
            level.setTile(x, y, Tile.grass, 0);
        }
        if (this.til == 11) {
            level.setTile(x, y, Tile.lwdc, 0);
        }
        if (this.til == 12) {
            level.setTile(x, y, Tile.lwdo, 0);
        }
        if (this.til == 13) {
            level.setTile(x, y, Tile.lsdc, 0);
        }
        if (this.til == 14) {
            level.setTile(x, y, Tile.lsdo, 0);
        }
    }
    
    @Override
    public boolean interact(final Level level, final int xt, final int yt, final Player player, final Item item, final int attackDir) {
        if (this.til == 0 && item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.shovel && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.dirt, 0);
                Sound.monsterHurt.play();
                if (this.random.nextInt(5) == 0) {
                    level.add(new ItemEntity(new ResourceItem(Resource.seeds), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                    level.add(new ItemEntity(new ResourceItem(Resource.seeds), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                    return true;
                }
            }
            if (tool.type == ToolType.spade && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.dirt, 0);
                Sound.monsterHurt.play();
                if (this.random.nextInt(5) == 0) {
                    return true;
                }
            }
            if (tool.type == ToolType.hoe && player.payStamina(4 - tool.level)) {
                Sound.monsterHurt.play();
                if (this.random.nextInt(5) == 0) {
                    level.add(new ItemEntity(new ResourceItem(Resource.seeds), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                    return true;
                }
                level.setTile(xt, yt, Tile.farmland, 0);
                return true;
            }
        }
        if (this.til == 1 && item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.shovel && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.dirt, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.sand), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                return true;
            }
            if (tool.type == ToolType.spade && player.payStamina(5 - tool.level)) {
                level.setTile(xt, yt, Tile.dirt, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.sand), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                return true;
            }
        }
        if (this.til == 2 && item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.axe && player.payStamina(4 - tool.level)) {
                this.hurt(level, xt, yt, player, this.random.nextInt(10) + tool.level * 5 + 10, attackDir);
                return true;
            }
            if (tool.type == ToolType.hatchet && player.payStamina(3 - tool.level)) {
                this.hurt(level, xt, yt, player, this.random.nextInt(7) + tool.level * 5 + 5, attackDir);
                return true;
            }
        }
        if (this.til == 5 && item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.shovel && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.hole, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.dirt), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
            if (tool.type == ToolType.spade && player.payStamina(5 - tool.level)) {
                level.setTile(xt, yt, Tile.hole, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.dirt), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
            if (tool.type == ToolType.hoe && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.farmland, 0);
                Sound.monsterHurt.play();
                return true;
            }
        }
        if (this.til == 6 && item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.shovel && player.payStamina(2 - tool.level)) {
                level.add(new ItemEntity(new ResourceItem(Resource.flower), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                level.add(new ItemEntity(new ResourceItem(Resource.rose), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                level.setTile(xt, yt, Tile.grass, 0);
                return true;
            }
        }
        if (this.til == 9 && item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.axe && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.hole, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.plank), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
            if (tool.type == ToolType.hatchet && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.hole, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.plank), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
        }
        if (this.til == 11 && item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.axe && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.plank, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.wdoor), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
            if (tool.type == ToolType.hatchet && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.plank, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.wdoor), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
        }
        if (this.til == 12 && item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.axe && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.plank, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.wdoor), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
            if (tool.type == ToolType.hatchet && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.plank, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.wdoor), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
        }
        if (this.til == 13 && item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            int hd = 3;
            if (tool.type == ToolType.pickaxe && player.payStamina(4 - tool.level)) {
                if (hd == 0) {
                    level.setTile(xt, yt, Tile.sbrick, 0);
                    level.add(new ItemEntity(new ResourceItem(Resource.sdoor), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                    Sound.monsterHurt.play();
                    return true;
                }
                if (hd != 0) {
                    --hd;
                }
            }
            if (tool.type == ToolType.pick && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.sbrick, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.sdoor), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
        }
        if (this.til == 14 && item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            int hd = 3;
            if (tool.type == ToolType.pickaxe && player.payStamina(4 - tool.level)) {
                if (hd == 0) {
                    level.setTile(xt, yt, Tile.sbrick, 0);
                    level.add(new ItemEntity(new ResourceItem(Resource.sdoor), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                    Sound.monsterHurt.play();
                    return true;
                }
                if (hd != 0) {
                    --hd;
                }
            }
            if (tool.type == ToolType.pick && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.sbrick, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.sdoor), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
        }
        if (this.til == 18 && item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.shovel && player.payStamina(3 - tool.level)) {
                level.setTile(xt, yt, Tile.hole, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.wool), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
            if (tool.type == ToolType.spade && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.hole, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.wool), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
        }
        if (this.til == 19 && item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.shovel && player.payStamina(3 - tool.level)) {
                level.setTile(xt, yt, Tile.hole, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.redwool), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
            if (tool.type == ToolType.spade && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.hole, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.redwool), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
        }
        if (this.til == 20 && item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.shovel && player.payStamina(3 - tool.level)) {
                level.setTile(xt, yt, Tile.hole, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.bluewool), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
            if (tool.type == ToolType.spade && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.hole, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.bluewool), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
        }
        if (this.til == 21 && item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.shovel && player.payStamina(3 - tool.level)) {
                level.setTile(xt, yt, Tile.hole, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.greenwool), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
            if (tool.type == ToolType.spade && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.hole, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.greenwool), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
        }
        if (this.til == 22 && item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.shovel && player.payStamina(3 - tool.level)) {
                level.setTile(xt, yt, Tile.hole, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.yellowwool), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
            if (tool.type == ToolType.spade && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.hole, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.yellowwool), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
        }
        if (this.til == 23 && item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.shovel && player.payStamina(3 - tool.level)) {
                level.setTile(xt, yt, Tile.hole, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.blackwool), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
            if (tool.type == ToolType.spade && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.hole, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.blackwool), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
        }
        return false;
    }
}
