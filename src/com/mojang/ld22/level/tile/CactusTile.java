// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.level.tile;

import com.mojang.ld22.screen.StartMenu;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.entity.ItemEntity;
import com.mojang.ld22.item.ResourceItem;
import com.mojang.ld22.item.resource.Resource;
import com.mojang.ld22.entity.particle.TextParticle;
import com.mojang.ld22.entity.particle.SmashParticle;
import com.mojang.ld22.screen.ModeMenu;
import com.mojang.ld22.entity.Mob;
import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.Game;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.gfx.Color;

public class CactusTile extends Tile
{
    public static int col0;
    public static int col1;
    public static int col2;
    public static int col3;
    
    static {
        CactusTile.col0 = Color.get(20, 30, 40, 440);
        CactusTile.col1 = Color.get(30, 40, 50, 550);
        CactusTile.col2 = Color.get(20, 30, 40, 330);
        CactusTile.col3 = Color.get(10, 20, 30, 220);
    }
    
    public CactusTile(final int id) {
        super(id);
        this.connectsToSand = true;
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        if (Game.Time == 0) {
            final int col = CactusTile.col0;
            screen.render(x * 16 + 0, y * 16 + 0, 72, col, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 73, col, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 104, col, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 105, col, 0);
        }
        if (Game.Time == 1) {
            final int col = CactusTile.col1;
            screen.render(x * 16 + 0, y * 16 + 0, 72, col, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 73, col, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 104, col, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 105, col, 0);
        }
        if (Game.Time == 2) {
            final int col = CactusTile.col2;
            screen.render(x * 16 + 0, y * 16 + 0, 72, col, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 73, col, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 104, col, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 105, col, 0);
        }
        if (Game.Time == 3) {
            final int col = CactusTile.col3;
            screen.render(x * 16 + 0, y * 16 + 0, 72, col, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 73, col, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 104, col, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 105, col, 0);
        }
    }
    
    @Override
    public boolean mayPass(final Level level, final int x, final int y, final Entity e) {
        return false;
    }
    
    @Override
    public void hurt(final Level level, final int x, final int y, final Mob source, final int dmg, final int attackDir) {
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
    
    @Override
    public void bumpedInto(final Level level, final int x, final int y, final Entity entity) {
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
    
    @Override
    public void tick(final Level level, final int xt, final int yt) {
        final int damage = level.getData(xt, yt);
        if (damage > 0) {
            level.setData(xt, yt, damage - 1);
        }
    }
}
