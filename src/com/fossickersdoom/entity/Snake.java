// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.entity;

import com.fossickersdoom.Game;
import com.fossickersdoom.item.resource.Resource;
import com.fossickersdoom.screen.ModeMenu;
import com.fossickersdoom.item.ResourceItem;
import com.fossickersdoom.gfx.Screen;
import com.fossickersdoom.screen.StartMenu;
import com.fossickersdoom.gfx.Color;

public class Snake extends Mob
{
    int xa;
    int ya;
    int xe;
    int ye;
    private int randomWalkTime;
    
    public Snake(int lvl) {
        this.xe = this.xa;
        this.ye = this.ya;
        this.randomWalkTime = 0;
        if (lvl == 0) {
            lvl = 1;
        }
        this.col0 = Color.get(-1, 0, 40, 444);
        this.col1 = Color.get(-1, 0, 30, 555);
        this.col2 = Color.get(-1, 0, 20, 333);
        this.col3 = Color.get(-1, 0, 10, 222);
        this.col4 = Color.get(-1, 0, 20, 444);
        if (StartMenu.diff == StartMenu.easy) {
            this.lvl = lvl;
            this.x = this.random.nextInt(1024);
            this.y = this.random.nextInt(1024);
            final int n = lvl * lvl * 10;
            this.maxHealth = n;
            this.health = n;
            if (ModeMenu.creative) {
                final boolean b = true;
                this.maxHealth = (b ? 1 : 0);
                this.health = (b ? 1 : 0);
            }
        }
        if (StartMenu.diff == StartMenu.norm) {
            this.lvl = lvl;
            this.x = this.random.nextInt(1024);
            this.y = this.random.nextInt(1024);
            final int n2 = lvl * lvl * 15;
            this.maxHealth = n2;
            this.health = n2;
            if (ModeMenu.creative) {
                final boolean b2 = true;
                this.maxHealth = (b2 ? 1 : 0);
                this.health = (b2 ? 1 : 0);
            }
        }
        if (StartMenu.diff == StartMenu.hard) {
            this.lvl = lvl;
            this.x = this.random.nextInt(1024);
            this.y = this.random.nextInt(1024);
            final int n3 = lvl * lvl * 29;
            this.maxHealth = n3;
            this.health = n3;
            if (ModeMenu.creative) {
                final boolean b3 = true;
                this.maxHealth = (b3 ? 1 : 0);
                this.health = (b3 ? 1 : 0);
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
            this.randomWalkTime = 25;
            this.xa = (this.random.nextInt(3) - 1) * this.random.nextInt(2);
            this.ya = (this.random.nextInt(3) - 1) * this.random.nextInt(2);
        }
        if (this.randomWalkTime > 0) {
            --this.randomWalkTime;
        }
    }
    
    @Override
    public void render(final Screen screen) {
        int xt = 18;
        final int yt = 18;
        int flip1 = this.walkDist >> 3 & 0x1;
        int flip2 = this.walkDist >> 3 & 0x1;
        if (this.dir == 1) {
            xt += 2;
        }
        if (this.dir > 1) {
            flip1 = 0;
            flip2 = 0;
            if (this.dir == 2) {
                flip1 = 1;
                flip2 = 1;
            }
            xt += 4 + (this.walkDist >> 3 & 0x1) * 2;
        }
        final int xo = this.x - 4;
        final int yo = this.y - 11;
        int col0 = Color.get(-1, 0, 444, 40);
        int col2 = Color.get(-1, 0, 555, 30);
        int col3 = Color.get(-1, 0, 333, 20);
        int col4 = Color.get(-1, 0, 222, 10);
        int col5 = Color.get(-1, 0, 444, 20);
        if (this.isLight()) {
            col0 = Color.get(-1, 0, 555, 50);
            col2 = Color.get(-1, 0, 555, 40);
            col3 = Color.get(-1, 0, 555, 30);
            col4 = Color.get(-1, 0, 555, 20);
            col5 = Color.get(-1, 0, 555, 30);
        }
        else {
            col0 = Color.get(-1, 0, 444, 50);
            col2 = Color.get(-1, 0, 555, 40);
            col3 = Color.get(-1, 0, 333, 30);
            col4 = Color.get(-1, 0, 222, 20);
            col5 = Color.get(-1, 0, 444, 30);
        }
        if (this.level.dirtColor == 322) {
            if (Game.Time == 0) {
                int col6 = col0;
                if (this.lvl == 2) {
                    col6 = Color.get(-1, 0, 555, 220);
                }
                if (this.lvl == 3) {
                    col6 = Color.get(-1, 0, 555, 5);
                }
                if (this.lvl == 4) {
                    col6 = Color.get(-1, 0, 555, 400);
                }
                if (this.lvl == 5) {
                    col6 = Color.get(-1, 0, 555, 459);
                }
                if (this.hurtTime > 0) {
                    col6 = Color.get(-1, 555, 555, 555);
                }
                screen.render(xo + 8 * flip1, yo + 0, xt + yt * 32, col6, flip1);
                screen.render(xo + 8 - 8 * flip1, yo + 0, xt + 1 + yt * 32, col6, flip1);
                screen.render(xo + 8 * flip2, yo + 8, xt + (yt + 1) * 32, col6, flip2);
                screen.render(xo + 8 - 8 * flip2, yo + 8, xt + 1 + (yt + 1) * 32, col6, flip2);
            }
            if (Game.Time == 1) {
                int col6 = col2;
                if (this.lvl == 2) {
                    col6 = Color.get(-1, 0, 555, 220);
                }
                if (this.lvl == 3) {
                    col6 = Color.get(-1, 0, 555, 5);
                }
                if (this.lvl == 4) {
                    col6 = Color.get(-1, 0, 555, 400);
                }
                if (this.lvl == 5) {
                    col6 = Color.get(-1, 0, 555, 459);
                }
                if (this.hurtTime > 0) {
                    col6 = Color.get(-1, 555, 555, 555);
                }
                screen.render(xo + 8 * flip1, yo + 0, xt + yt * 32, col6, flip1);
                screen.render(xo + 8 - 8 * flip1, yo + 0, xt + 1 + yt * 32, col6, flip1);
                screen.render(xo + 8 * flip2, yo + 8, xt + (yt + 1) * 32, col6, flip2);
                screen.render(xo + 8 - 8 * flip2, yo + 8, xt + 1 + (yt + 1) * 32, col6, flip2);
            }
            if (Game.Time == 2) {
                int col6 = col3;
                if (this.lvl == 2) {
                    col6 = Color.get(-1, 0, 555, 220);
                }
                if (this.lvl == 3) {
                    col6 = Color.get(-1, 0, 555, 5);
                }
                if (this.lvl == 4) {
                    col6 = Color.get(-1, 0, 555, 400);
                }
                if (this.lvl == 5) {
                    col6 = Color.get(-1, 0, 555, 459);
                }
                if (this.hurtTime > 0) {
                    col6 = Color.get(-1, 555, 555, 555);
                }
                screen.render(xo + 8 * flip1, yo + 0, xt + yt * 32, col6, flip1);
                screen.render(xo + 8 - 8 * flip1, yo + 0, xt + 1 + yt * 32, col6, flip1);
                screen.render(xo + 8 * flip2, yo + 8, xt + (yt + 1) * 32, col6, flip2);
                screen.render(xo + 8 - 8 * flip2, yo + 8, xt + 1 + (yt + 1) * 32, col6, flip2);
            }
            if (Game.Time == 3) {
                int col6 = col4;
                if (this.lvl == 2) {
                    col6 = Color.get(-1, 0, 555, 220);
                }
                if (this.lvl == 3) {
                    col6 = Color.get(-1, 0, 555, 5);
                }
                if (this.lvl == 4) {
                    col6 = Color.get(-1, 0, 555, 400);
                }
                if (this.lvl == 5) {
                    col6 = Color.get(-1, 0, 555, 459);
                }
                if (this.hurtTime > 0) {
                    col6 = Color.get(-1, 555, 555, 555);
                }
                screen.render(xo + 8 * flip1, yo + 0, xt + yt * 32, col6, flip1);
                screen.render(xo + 8 - 8 * flip1, yo + 0, xt + 1 + yt * 32, col6, flip1);
                screen.render(xo + 8 * flip2, yo + 8, xt + (yt + 1) * 32, col6, flip2);
                screen.render(xo + 8 - 8 * flip2, yo + 8, xt + 1 + (yt + 1) * 32, col6, flip2);
            }
        }
        if (this.level.dirtColor != 322) {
            int col6 = col5;
            if (this.lvl == 2) {
                col6 = Color.get(-1, 0, 555, 220);
            }
            if (this.lvl == 3) {
                col6 = Color.get(-1, 0, 555, 5);
            }
            if (this.lvl == 4) {
                col6 = Color.get(-1, 0, 555, 400);
            }
            if (this.lvl == 5) {
                col6 = Color.get(-1, 0, 555, 459);
            }
            if (this.hurtTime > 0) {
                col6 = Color.get(-1, 555, 555, 555);
            }
            screen.render(xo + 8 * flip1, yo + 0, xt + yt * 32, col6, flip1);
            screen.render(xo + 8 - 8 * flip1, yo + 0, xt + 1 + yt * 32, col6, flip1);
            screen.render(xo + 8 * flip2, yo + 8, xt + (yt + 1) * 32, col6, flip2);
            screen.render(xo + 8 - 8 * flip2, yo + 8, xt + 1 + (yt + 1) * 32, col6, flip2);
        }
    }
    
    @Override
    protected void touchedBy(final Entity entity) {
        if (StartMenu.diff == StartMenu.easy && entity instanceof Player) {
            if (this.lvl > 1) {
                entity.hurt(this, this.lvl - 1, this.dir);
            }
            else if (this.lvl < 2) {
                entity.hurt(this, 1, this.dir);
            }
        }
        if (StartMenu.diff == StartMenu.norm && entity instanceof Player) {
            if (this.lvl > 2) {
                entity.hurt(this, 2, this.dir);
            }
            else if (this.lvl < 3) {
                entity.hurt(this, 1, this.dir);
            }
        }
        if (StartMenu.diff == StartMenu.hard && entity instanceof Player) {
            entity.hurt(this, this.lvl + 1, this.dir);
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
            for (int count = this.random.nextInt(1) + 1, i = 0; i < count; ++i) {
                this.level.add(new ItemEntity(new ResourceItem(Resource.scale), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
            }
            if (this.level.player != null) {
                final Player player = this.level.player;
                Player.score += 50 * this.lvl;
            }
        }
        if (StartMenu.diff == StartMenu.norm) {
            for (int count = this.random.nextInt(1) + 1, i = 0; i < count; ++i) {
                this.level.add(new ItemEntity(new ResourceItem(Resource.scale), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
            }
            if (this.level.player != null) {
                final Player player2 = this.level.player;
                Player.score += 50 * this.lvl;
            }
        }
        if (StartMenu.diff == StartMenu.hard) {
            for (int count = this.random.nextInt(1), i = 0; i < count; ++i) {
                this.level.add(new ItemEntity(new ResourceItem(Resource.scale), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
            }
            if (this.level.player != null) {
                final Player player3 = this.level.player;
                Player.score += 50 * this.lvl;
            }
        }
        if (this.lvl == 0) {
            this.lvl = 1;
        }
        if (this.random.nextInt(15 / this.lvl) == 0) {
            this.level.add(new ItemEntity(new ResourceItem(Resource.key), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
        }
    }
}
