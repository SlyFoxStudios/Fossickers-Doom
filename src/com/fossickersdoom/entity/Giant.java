// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.entity;

import com.fossickersdoom.item.resource.Resource;
import com.fossickersdoom.item.ResourceItem;
import com.fossickersdoom.screen.StartMenu;
import com.fossickersdoom.gfx.Color;
import com.fossickersdoom.gfx.Screen;

public class Giant extends Mob
{
    int xa;
    int ya;
    int xe;
    int ye;
    private int randomWalkTime;
    int wait;
    int p1;
    int p2;
    int p3;
    int p4;
    int p5;
    int p6;
    int p7;
    int p8;
    int p9;
    
    public Giant(int lvl) {
        this.xe = this.xa;
        this.ye = this.ya;
        this.randomWalkTime = 0;
        this.wait = 0;
        this.p1 = 539;
        this.p2 = 540;
        this.p3 = 541;
        this.p4 = 572;
        this.p5 = 571;
        this.p6 = 602;
        this.p7 = 573;
        this.p8 = 606;
        this.p9 = 604;
        if (lvl == 0) {
            lvl = 1;
        }
        this.lvl = lvl;
        final int lvls = lvl + this.random.nextInt(5);
        final int eh = lvls * 5 * lvls;
        final int eh2 = lvls * lvls + eh;
        this.x = this.random.nextInt(1024);
        this.y = this.random.nextInt(1024);
        final int n = 1000 + eh + eh2;
        this.maxHealth = n;
        this.health = n;
    }
    
    @Override
    public void tick() {
        super.tick();
        this.xr = 6;
        this.yr = 8;
        this.isenemy = true;
        ++this.wait;
        if (this.level.player != null && this.randomWalkTime == 0) {
            final int xd = this.level.player.x - this.x;
            final int yd = this.level.player.y - this.y;
            if (xd * xd + yd * yd < 10000) {
                this.xa = 0;
                this.ya = 0;
                if (xd < 0) {
                    this.xa = -1;
                }
                this.xe = this.xa;
                if (xd > 0) {
                    this.xa = 1;
                }
                this.xe = this.xa;
                if (yd < 0) {
                    this.ya = -1;
                }
                this.xe = this.xa;
                if (yd > 0) {
                    this.ya = 1;
                }
                this.xe = this.xa;
            }
        }
        final int speed = this.tickTime & 0x1;
        if (!this.move(this.xa * speed, this.ya * speed) || this.random.nextInt(200) == 0) {
            this.randomWalkTime = 60;
            this.xa = (this.random.nextInt(3) - 1) * this.random.nextInt(2);
            this.ya = (this.random.nextInt(3) - 1) * this.random.nextInt(2);
        }
        if (this.randomWalkTime > 0) {
            --this.randomWalkTime;
        }
    }
    
    @Override
    public void render(final Screen screen) {
        int xt = 25;
        final int yt = 16;
        int flip1 = this.walkDist >> 3 & 0x1;
        int flip2 = this.walkDist >> 3 & 0x1;
        int col1 = Color.get(-1, 111, 222, 333);
        if (this.dir == 0) {
            col1 = Color.get(-1, 111, 222, 333);
        }
        if (this.dir == 1) {
            xt += 2;
            col1 = Color.get(-1, 100, 200, 300);
        }
        if (this.dir > 1) {
            flip1 = 1;
            flip2 = (this.walkDist >> 4 & 0x1);
            col1 = Color.get(-1, 110, 220, 330);
            if (this.dir == 2) {
                flip1 = 1;
                col1 = Color.get(-1, 5, 105, 205);
            }
            xt += 2 + (this.walkDist >> 4 & 0x1) * 2;
        }
        final int xo = this.x - 8;
        final int yo = this.y - 11;
        if (this.hurtTime > 0) {
            col1 = Color.get(-1, 555, 555, 555);
        }
        screen.render(xo + 8 * flip1, yo + 0, xt + yt * 32, this.col, flip1);
        screen.render(xo + 8 - 8 * flip1, yo + 0, xt + 1 + yt * 32, this.col, flip1);
        screen.render(xo + 8 * flip2, yo + 8, xt + (yt + 1) * 32, this.col, flip2);
        screen.render(xo + 8 - 8 * flip2, yo + 8, xt + 1 + (yt + 1) * 32, this.col, flip2);
    }
    
    @Override
    protected void touchedBy(final Entity entity) {
        if (StartMenu.diff == StartMenu.easy && entity instanceof Player) {
            entity.hurt(this, 3, this.dir);
        }
        if (StartMenu.diff == StartMenu.norm && entity instanceof Player) {
            entity.hurt(this, 3, this.dir);
        }
        if (StartMenu.diff == StartMenu.hard && entity instanceof Player) {
            entity.hurt(this, 4, this.dir);
        }
    }
    
    @Override
    public boolean canWool() {
        return true;
    }
    
    @Override
    protected void die() {
        super.die();
        for (int count = this.random.nextInt(6) + 2, i = 0; i < count; ++i) {
            this.level.add(new ItemEntity(new ResourceItem(Resource.cloth), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
        }
        if (this.level.player != null) {
            final Player player = this.level.player;
            Player.score += 200 * this.lvl;
        }
    }
}
