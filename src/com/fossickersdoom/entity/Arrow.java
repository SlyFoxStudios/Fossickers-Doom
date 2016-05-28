// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.entity;

import com.fossickersdoom.gfx.Screen;
import java.util.List;
import com.fossickersdoom.gfx.Color;

public class Arrow extends Entity
{
    private int lifeTime;
    private int xdir;
    private int ydir;
    private final int speed = 2;
    private int time;
    private int damage;
    private Mob owner;
    private Player player;
    private int color;
    private int speeddmg;
    private boolean edmg;
    
    public Arrow(final Mob owner, final int dirx, final int diry, final int dmg, final boolean flag) {
        this.edmg = false;
        this.owner = owner;
        this.xdir = dirx;
        this.ydir = diry;
        this.damage = dmg;
        this.color = Color.get(-1, 111, 222, 430);
        if (this.damage > -1) {
            this.speeddmg = 2;
        }
        if (this.damage > 3) {
            this.speeddmg = 3;
        }
        if (flag) {
            this.damage *= 3;
            this.color = Color.get(-1, 111, 222, 430);
        }
        this.x = owner.x;
        this.y = owner.y;
        this.lifeTime = 100 * (this.damage + 2);
    }
    
    @Override
    public void tick() {
        ++this.time;
        if (this.time >= this.lifeTime) {
            this.remove();
            return;
        }
        this.x += this.xdir * this.speeddmg;
        this.y += this.ydir * this.speeddmg;
        final List<Entity> entitylist = this.level.getEntities(this.x, this.y, this.x, this.y);
        final int count = this.random.nextInt(11);
        for (int i = 0; i < entitylist.size(); ++i) {
            final Entity hit = entitylist.get(i);
            if (count < 9) {
                if (hit != null) {
                    if (hit instanceof Mob && hit != this.owner && !this.owner.isenemy) {
                        hit.hurt(this.owner, this.damage + 3, ((Mob)hit).dir);
                    }
                    if (hit instanceof Player && hit != this.owner && this.owner.isenemy) {
                        hit.hurt(this.owner, this.damage, ((Player)hit).dir);
                    }
                }
            }
            else if (count > 8 && hit != null) {
                if (hit instanceof Mob && hit != this.owner && !this.owner.isenemy) {
                    hit.hurt(this.owner, this.damage + 4, ((Mob)hit).dir);
                }
                if (hit instanceof Player && hit != this.owner && this.owner.isenemy) {
                    hit.hurt(this.owner, this.damage + 1, ((Player)hit).dir);
                }
            }
            if (!this.level.getTile(this.x / 16, this.y / 16).mayPass(this.level, this.x / 16, this.y / 16, this) && !this.level.getTile(this.x / 16, this.y / 16).connectsToWater && this.level.getTile(this.x / 16, this.y / 16).id != 16) {
                this.remove();
            }
        }
    }
    
    @Override
    public boolean isBlockableBy(final Mob mob) {
        return false;
    }
    
    @Override
    public void render(final Screen screen) {
        if (this.time >= this.lifeTime - 60 && this.time / 6 % 2 == 0) {
            return;
        }
        if (this.xdir == 0 && this.ydir == -1) {
            final int xt = 15;
            final int yt = 5;
            screen.render(this.x - 4, this.y - 4, xt + yt * 32, this.color, 1);
        }
        else if (this.xdir == 1 && this.ydir == 0) {
            final int xt = 14;
            final int yt = 5;
            screen.render(this.x - 4, this.y - 4, xt + yt * 32, this.color, 1);
        }
        else if (this.xdir == -1 && this.ydir == 0) {
            final int xt = 13;
            final int yt = 5;
            screen.render(this.x - 4, this.y - 4, xt + yt * 32, this.color, 1);
        }
        else if (this.xdir == 0 && this.ydir == 1) {
            final int xt = 16;
            final int yt = 5;
            screen.render(this.x - 4, this.y - 4, xt + yt * 32, this.color, 1);
        }
    }
}
