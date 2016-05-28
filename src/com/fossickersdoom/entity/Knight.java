// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.entity;

import com.fossickersdoom.Game;
import com.fossickersdoom.gfx.Screen;
import com.fossickersdoom.item.resource.Resource;
import com.fossickersdoom.screen.ModeMenu;
import com.fossickersdoom.screen.StartMenu;
import com.fossickersdoom.item.ResourceItem;
import com.fossickersdoom.gfx.Color;

public class Knight extends Mob
{
    int xa;
    int ya;
    int xe;
    int ye;
    private int randomWalkTime;
    
    public Knight(int lvl) {
        this.xe = this.xa;
        this.ye = this.ya;
        this.randomWalkTime = 0;
        if (lvl == 0) {
            lvl = 1;
        }
        this.col0 = Color.get(-1, 0, 555, 359);
        this.col1 = Color.get(-1, 0, 555, 359);
        this.col2 = Color.get(-1, 0, 333, 59);
        this.col3 = Color.get(-1, 0, 333, 59);
        this.col4 = Color.get(-1, 0, 333, 59);
        if (StartMenu.diff == StartMenu.easy) {
            this.lvl = lvl;
            this.x = this.random.nextInt(1024);
            this.y = this.random.nextInt(1024);
            if (ModeMenu.creative) {
                final boolean b = true;
                this.maxHealth = (b ? 1 : 0);
                this.health = (b ? 1 : 0);
            }
            else {
                final int n = lvl * lvl * 11;
                this.maxHealth = n;
                this.health = n;
            }
        }
        if (StartMenu.diff == StartMenu.norm) {
            this.lvl = lvl;
            this.x = this.random.nextInt(1024);
            this.y = this.random.nextInt(1024);
            if (ModeMenu.creative) {
                final boolean b2 = true;
                this.maxHealth = (b2 ? 1 : 0);
                this.health = (b2 ? 1 : 0);
            }
            else {
                final int n2 = lvl * lvl * 22;
                this.maxHealth = n2;
                this.health = n2;
            }
        }
        if (StartMenu.diff == StartMenu.hard) {
            this.lvl = lvl;
            this.x = this.random.nextInt(1024);
            this.y = this.random.nextInt(1024);
            if (ModeMenu.creative) {
                final boolean b3 = true;
                this.maxHealth = (b3 ? 1 : 0);
                this.health = (b3 ? 1 : 0);
            }
            else {
                final int n3 = lvl * lvl * 33;
                this.maxHealth = n3;
                this.health = n3;
            }
        }
    }
    
    @Override
    public void tick() {
        super.tick();
        this.isenemy = true;
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
        int xt = 24;
        final int yt = 14;
        int flip1 = this.walkDist >> 3 & 0x1;
        int flip2 = this.walkDist >> 3 & 0x1;
        if (this.dir == 1) {
            xt += 2;
        }
        if (this.dir > 1) {
            flip1 = 0;
            flip2 = (this.walkDist >> 4 & 0x1);
            if (this.dir == 2) {
                flip1 = 1;
            }
            xt += 4 + (this.walkDist >> 3 & 0x1) * 2;
        }
        final int xo = this.x - 8;
        final int yo = this.y - 11;
        this.col0 = Color.get(-1, 0, 555, 10);
        this.col1 = Color.get(-1, 0, 555, 10);
        this.col2 = Color.get(-1, 0, 555, 10);
        this.col3 = Color.get(-1, 0, 555, 10);
        this.col4 = Color.get(-1, 0, 555, 10);
        if (this.isLight()) {
            this.col0 = Color.get(-1, 0, 555, 10);
            this.col1 = Color.get(-1, 0, 555, 10);
            this.col2 = Color.get(-1, 0, 555, 10);
            this.col3 = Color.get(-1, 0, 555, 10);
            this.col4 = Color.get(-1, 0, 555, 10);
        }
        else {
            this.col0 = Color.get(-1, 0, 555, 10);
            this.col1 = Color.get(-1, 0, 555, 10);
            this.col2 = Color.get(-1, 0, 555, 10);
            this.col3 = Color.get(-1, 0, 555, 10);
            this.col4 = Color.get(-1, 0, 555, 10);
        }
        if (this.level.dirtColor == 322) {
            if (Game.Time == 0) {
                int col = this.col0;
                if (this.lvl == 2) {
                    col = Color.get(-1, 0, 555, 220);
                }
                if (this.lvl == 3) {
                    col = Color.get(-1, 0, 555, 5);
                }
                if (this.lvl == 4) {
                    col = Color.get(-1, 0, 555, 400);
                }
                if (this.lvl == 5) {
                    col = Color.get(-1, 0, 555, 459);
                }
                if (this.hurtTime > 0) {
                    col = Color.get(-1, 555, 555, 555);
                }
                screen.render(xo + 8 * flip1, yo + 0, xt + yt * 32, col, flip1);
                screen.render(xo + 8 - 8 * flip1, yo + 0, xt + 1 + yt * 32, col, flip1);
                screen.render(xo + 8 * flip2, yo + 8, xt + (yt + 1) * 32, col, flip2);
                screen.render(xo + 8 - 8 * flip2, yo + 8, xt + 1 + (yt + 1) * 32, col, flip2);
            }
            if (Game.Time == 1) {
                int col = this.col1;
                if (this.lvl == 2) {
                    col = Color.get(-1, 0, 555, 220);
                }
                if (this.lvl == 3) {
                    col = Color.get(-1, 0, 555, 5);
                }
                if (this.lvl == 4) {
                    col = Color.get(-1, 0, 555, 400);
                }
                if (this.lvl == 5) {
                    col = Color.get(-1, 0, 555, 459);
                }
                if (this.hurtTime > 0) {
                    col = Color.get(-1, 555, 555, 555);
                }
                screen.render(xo + 8 * flip1, yo + 0, xt + yt * 32, col, flip1);
                screen.render(xo + 8 - 8 * flip1, yo + 0, xt + 1 + yt * 32, col, flip1);
                screen.render(xo + 8 * flip2, yo + 8, xt + (yt + 1) * 32, col, flip2);
                screen.render(xo + 8 - 8 * flip2, yo + 8, xt + 1 + (yt + 1) * 32, col, flip2);
            }
            if (Game.Time == 2) {
                int col = this.col2;
                if (this.lvl == 2) {
                    col = Color.get(-1, 0, 555, 220);
                }
                if (this.lvl == 3) {
                    col = Color.get(-1, 0, 555, 5);
                }
                if (this.lvl == 4) {
                    col = Color.get(-1, 0, 555, 400);
                }
                if (this.lvl == 5) {
                    col = Color.get(-1, 0, 555, 459);
                }
                if (this.hurtTime > 0) {
                    col = Color.get(-1, 555, 555, 555);
                }
                screen.render(xo + 8 * flip1, yo + 0, xt + yt * 32, col, flip1);
                screen.render(xo + 8 - 8 * flip1, yo + 0, xt + 1 + yt * 32, col, flip1);
                screen.render(xo + 8 * flip2, yo + 8, xt + (yt + 1) * 32, col, flip2);
                screen.render(xo + 8 - 8 * flip2, yo + 8, xt + 1 + (yt + 1) * 32, col, flip2);
            }
            if (Game.Time == 3) {
                int col = this.col3;
                if (this.lvl == 2) {
                    col = Color.get(-1, 0, 555, 220);
                }
                if (this.lvl == 3) {
                    col = Color.get(-1, 0, 555, 5);
                }
                if (this.lvl == 4) {
                    col = Color.get(-1, 0, 555, 400);
                }
                if (this.lvl == 5) {
                    col = Color.get(-1, 0, 555, 459);
                }
                if (this.hurtTime > 0) {
                    col = Color.get(-1, 555, 555, 555);
                }
                screen.render(xo + 8 * flip1, yo + 0, xt + yt * 32, col, flip1);
                screen.render(xo + 8 - 8 * flip1, yo + 0, xt + 1 + yt * 32, col, flip1);
                screen.render(xo + 8 * flip2, yo + 8, xt + (yt + 1) * 32, col, flip2);
                screen.render(xo + 8 - 8 * flip2, yo + 8, xt + 1 + (yt + 1) * 32, col, flip2);
            }
        }
        if (this.level.dirtColor != 322) {
            int col = this.col4;
            if (this.lvl == 2) {
                col = Color.get(-1, 0, 555, 220);
            }
            if (this.lvl == 3) {
                col = Color.get(-1, 0, 555, 5);
            }
            if (this.lvl == 4) {
                col = Color.get(-1, 0, 555, 400);
            }
            if (this.lvl == 5) {
                col = Color.get(-1, 0, 555, 459);
            }
            if (this.hurtTime > 0) {
                col = Color.get(-1, 555, 555, 555);
            }
            screen.render(xo + 8 * flip1, yo + 0, xt + yt * 32, col, flip1);
            screen.render(xo + 8 - 8 * flip1, yo + 0, xt + 1 + yt * 32, col, flip1);
            screen.render(xo + 8 * flip2, yo + 8, xt + (yt + 1) * 32, col, flip2);
            screen.render(xo + 8 - 8 * flip2, yo + 8, xt + 1 + (yt + 1) * 32, col, flip2);
        }
    }
    
    @Override
    protected void touchedBy(final Entity entity) {
        if (StartMenu.diff == StartMenu.easy && entity instanceof Player) {
            entity.hurt(this, this.lvl, this.dir);
        }
        if (StartMenu.diff == StartMenu.norm && entity instanceof Player) {
            entity.hurt(this, this.lvl, this.dir);
        }
        if (StartMenu.diff == StartMenu.hard && entity instanceof Player) {
            entity.hurt(this, this.lvl * 2, this.dir);
        }
    }
    
    @Override
    public boolean canWool() {
        return true;
    }
    
    @Override
    protected void die() {
        super.die();
        if (StartMenu.diff == StartMenu.easy) {
            for (int count = this.random.nextInt(2) + 1, i = 0; i < count; ++i) {
                this.level.add(new ItemEntity(new ResourceItem(Resource.shard), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
            }
        }
        if (StartMenu.diff == StartMenu.norm) {
            for (int count = this.random.nextInt(3), i = 0; i < count; ++i) {
                this.level.add(new ItemEntity(new ResourceItem(Resource.shard), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
            }
        }
        if (StartMenu.diff == StartMenu.hard) {
            for (int count = this.random.nextInt(3), i = 0; i < count; ++i) {
                this.level.add(new ItemEntity(new ResourceItem(Resource.shard), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
            }
        }
        if (this.lvl == 0) {
            this.lvl = 1;
        }
        if (this.random.nextInt(10 / this.lvl) == 0) {
            this.level.add(new ItemEntity(new ResourceItem(Resource.key), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
        }
        if (this.level.player != null) {
            final Player player = this.level.player;
            Player.score += 50 * this.lvl;
        }
    }
}
