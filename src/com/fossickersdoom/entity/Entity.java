// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.entity;

import com.fossickersdoom.item.Item;
import com.fossickersdoom.level.tile.Tile;

import java.util.List;

import com.fossickersdoom.gfx.Screen;
import com.fossickersdoom.gfx.Color;
import com.fossickersdoom.level.Level;
import java.util.Random;

public class Entity
{
    protected final Random random;
    public int x;
    public int y;
    public static int xx;
    public static int yy;
    public int xr;
    public int yr;
    public boolean removed;
    public Level level;
    public boolean hasspawned;
    public int col;
    public int col0;
    public int col1;
    public int col2;
    public int col3;
    public int col4;
    
    public Entity() {
        this.random = new Random();
        this.xr = 6;
        this.yr = 6;
        this.hasspawned = false;
        this.col = Color.get(-1, 0, 111, 222);
        this.col0 = Color.get(-1, 0, 111, 222);
        this.col1 = Color.get(-1, 0, 333, 444);
        this.col2 = Color.get(-1, 0, 111, 222);
        this.col3 = Color.get(-1, 0, 111, 222);
        this.col4 = Color.get(-1, 0, 111, 222);
    }
    
    public void render(final Screen screen) {
    }
    
    public void tick() {
    }
    
    public void remove() {
        this.removed = true;
    }
    
    public final void init(final Level level) {
        this.level = level;
    }
    
    public boolean intersects(final int x0, final int y0, final int x1, final int y1) {
        return this.x + this.xr >= x0 && this.y + this.yr >= y0 && this.x - this.xr <= x1 && this.y - this.yr <= y1;
    }
    
    public boolean blocks(final Entity e) {
        return false;
    }
    
    public void hurt(final Mob mob, final int dmg, final int attackDir) {
    }
    
    public void hurt(final Tnt tnt, final int x, final int y, final int dmg) {
    }
    
    public void hurt(final Tile tile, final int x, final int y, final int dmg) {
    }
    
    public boolean move(final int xa, final int ya) {
        if (!this.level.player.game.saving && (xa != 0 || ya != 0)) {
            boolean stopped = true;
            if (xa != 0 && this.move2(xa, 0)) {
                stopped = false;
            }
            if (ya != 0 && this.move2(0, ya)) {
                stopped = false;
            }
            if (!stopped) {
                final int xt = this.x >> 4;
                final int yt = this.y >> 4;
                this.level.getTile(xt, yt).steppedOn(this.level, xt, yt, this);
            }
            return !stopped;
        }
        return true;
    }
    
    protected boolean move2(final int xa, final int ya) {
        if (xa != 0 && ya != 0) {
            throw new IllegalArgumentException("Move2 can only move along one axis at a time!");
        }
        final int xto0 = this.x - this.xr >> 4;
        final int yto0 = this.y - this.yr >> 4;
        final int xto2 = this.x + this.xr >> 4;
        final int yto2 = this.y + this.yr >> 4;
        final int xt0 = this.x + xa - this.xr >> 4;
        final int yt0 = this.y + ya - this.yr >> 4;
        final int xt2 = this.x + xa + this.xr >> 4;
        final int yt2 = this.y + ya + this.yr >> 4;
        boolean blocked = false;
        for (int yt3 = yt0; yt3 <= yt2; ++yt3) {
            for (int xt3 = xt0; xt3 <= xt2; ++xt3) {
                if (xt3 < xto0 || xt3 > xto2 || yt3 < yto0 || yt3 > yto2) {
                    this.level.getTile(xt3, yt3).bumpedInto(this.level, xt3, yt3, this);
                    if (!this.level.getTile(xt3, yt3).mayPass(this.level, xt3, yt3, this)) {
                        blocked = true;
                        return false;
                    }
                }
            }
        }
        if (blocked) {
            return false;
        }
        final List<Entity> wasInside = this.level.getEntities(this.x - this.xr, this.y - this.yr, this.x + this.xr, this.y + this.yr);
        final List<Entity> isInside = this.level.getEntities(this.x + xa - this.xr, this.y + ya - this.yr, this.x + xa + this.xr, this.y + ya + this.yr);
        for (int i = 0; i < isInside.size(); ++i) {
            final Entity e = isInside.get(i);
            if (e != this) {
                e.touchedBy(this);
            }
        }
        isInside.removeAll(wasInside);
        for (int i = 0; i < isInside.size(); ++i) {
            final Entity e = isInside.get(i);
            if (e != this) {
                if (e.blocks(this)) {
                    return false;
                }
            }
        }
        this.x += xa;
        this.y += ya;
        return true;
    }
    
    protected void touchedBy(final Entity entity) {
    }
    
    public boolean isBlockableBy(final Mob mob) {
        return true;
    }
    
    public void touchItem(final ItemEntity itemEntity) {
    }
    
    public boolean canSwim() {
        return false;
    }
    
    public boolean canWool() {
        return false;
    }
    
    public boolean canLight() {
        return false;
    }
    
    public boolean interact(final Player player, final Item item, final int attackDir) {
        return item.interact(player, this, attackDir);
    }
    
    public boolean use(final Player player, final int attackDir) {
        return false;
    }
    
    public int getLightRadius() {
        return 0;
    }
    
    public void hurt(final Tnt tnt, final int dmg, final int i) {
    }
    
    public void hurt(final int i, final int dmg, final int dmg2) {
    }
}
