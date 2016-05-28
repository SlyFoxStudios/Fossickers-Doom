// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.entity;

import com.fossickersdoom.sound.Sound;
import com.fossickersdoom.gfx.Color;
import com.fossickersdoom.gfx.Screen;
import com.fossickersdoom.item.Item;

public class ItemEntity extends Entity
{
    private int lifeTime;
    protected int walkDist;
    protected int dir;
    public int hurtTime;
    protected int xKnockback;
    protected int yKnockback;
    public double xa;
    public double ya;
    public double za;
    public double xx;
    public double yy;
    public double zz;
    public Item item;
    private int time;
    
    public ItemEntity(final Item item, final int x, final int y) {
        this.walkDist = 0;
        this.dir = 0;
        this.hurtTime = 0;
        this.time = 0;
        this.item = item;
        this.x = x;
        this.xx = x;
        this.y = y;
        this.yy = y;
        this.xr = 3;
        this.yr = 3;
        this.zz = 2.0;
        this.xa = this.random.nextGaussian() * 0.3;
        this.ya = this.random.nextGaussian() * 0.2;
        this.za = this.random.nextFloat() * 0.7 + 1.0;
        this.lifeTime = 600 + this.random.nextInt(70);
    }
    
    @Override
    public void tick() {
        ++this.time;
        if (this.time >= this.lifeTime) {
            this.remove();
            return;
        }
        this.xx += this.xa;
        this.yy += this.ya;
        this.zz += this.za;
        if (this.zz < 0.0) {
            this.zz = 0.0;
            this.za *= -0.5;
            this.xa *= 0.6;
            this.ya *= 0.6;
        }
        this.za -= 0.15;
        final int ox = this.x;
        final int oy = this.y;
        final int nx = (int)this.xx;
        final int ny = (int)this.yy;
        final int expectedx = nx - this.x;
        final int expectedy = ny - this.y;
        this.move(nx - this.x, ny - this.y);
        final int gotx = this.x - ox;
        final int goty = this.y - oy;
        this.xx += gotx - expectedx;
        this.yy += goty - expectedy;
        if (this.hurtTime > 0) {
            --this.hurtTime;
        }
    }
    
    @Override
    public boolean isBlockableBy(final Mob mob) {
        return false;
    }
    
    @Override
    public void render(final Screen screen) {
        if (this.time >= this.lifeTime - 120 && this.time / 6 % 2 == 0) {
            return;
        }
        screen.render(this.x - 4, this.y - 4, this.item.getSprite(), Color.get(-1, 0, 0, 0), 0);
        screen.render(this.x - 4, this.y - 4 - (int)this.zz, this.item.getSprite(), this.item.getColor(), 0);
    }
    
    @Override
    protected void touchedBy(final Entity entity) {
        if (this.time > 30) {
            entity.touchItem(this);
        }
    }
    
    public void take(final Player player) {
        Sound.pickup.play();
        this.item.onTake(this);
        this.remove();
    }
}
