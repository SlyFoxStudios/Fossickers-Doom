// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.entity;

import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.Game;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.item.ResourceItem;
import com.mojang.ld22.item.resource.Resource;
import com.mojang.ld22.screen.ModeMenu;
import com.mojang.ld22.screen.StartMenu;
import com.mojang.ld22.gfx.Color;

public class Slime extends Mob
{
    private int xa;
    private int ya;
    private int jumpTime;
    
    public Slime(int lvl) {
        this.jumpTime = 0;
        if (lvl == 0) {
            lvl = 1;
        }
        this.col0 = Color.get(-1, 20, 40, 10);
        this.col1 = Color.get(-1, 20, 30, 40);
        this.col2 = Color.get(-1, 20, 40, 10);
        this.col3 = Color.get(-1, 10, 20, 40);
        this.col4 = Color.get(-1, 10, 20, 30);
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
                final int n = lvl * lvl * 3;
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
                final int n2 = lvl * lvl * 5;
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
                final int n3 = lvl * lvl * 10;
                this.maxHealth = n3;
                this.health = n3;
            }
        }
    }
    
    @Override
    public void tick() {
        super.tick();
        this.isenemy = true;
        final int speed = 1;
        if ((!this.move(this.xa * speed, this.ya * speed) || this.random.nextInt(40) == 0) && this.jumpTime <= -10) {
            this.xa = this.random.nextInt(3) - 1;
            this.ya = this.random.nextInt(3) - 1;
            if (this.level.player != null) {
                final int xd = this.level.player.x - this.x;
                final int yd = this.level.player.y - this.y;
                if (xd * xd + yd * yd < 2500) {
                    if (!bed.hasBedSet) {
                        if (xd < 0) {
                            this.xa = -1;
                        }
                        if (xd > 0) {
                            this.xa = 1;
                        }
                        if (yd < 0) {
                            this.ya = -1;
                        }
                        if (yd > 0) {
                            this.ya = 1;
                        }
                    }
                    else {
                        if (xd < 0) {
                            this.xa = 1;
                        }
                        if (xd > 0) {
                            this.xa = -1;
                        }
                        if (yd < 0) {
                            this.ya = 1;
                        }
                        if (yd > 0) {
                            this.ya = -1;
                        }
                    }
                }
            }
            if (this.xa != 0 || this.ya != 0) {
                this.jumpTime = 10;
            }
        }
        --this.jumpTime;
        if (this.jumpTime == 0) {
            final boolean b = false;
            this.ya = (b ? 1 : 0);
            this.xa = (b ? 1 : 0);
        }
    }
    
    @Override
    protected void die() {
        super.die();
        if (!this.hasspawned) {
            if (StartMenu.diff == StartMenu.easy) {
                for (int count = this.random.nextInt(3) + 1, i = 0; i < count; ++i) {
                    this.level.add(new ItemEntity(new ResourceItem(Resource.slime), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
                }
            }
            if (StartMenu.diff == StartMenu.norm) {
                for (int count = this.random.nextInt(2) + 1, i = 0; i < count; ++i) {
                    this.level.add(new ItemEntity(new ResourceItem(Resource.slime), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
                }
            }
            if (StartMenu.diff == StartMenu.hard) {
                for (int count = this.random.nextInt(1) + 1, i = 0; i < count; ++i) {
                    this.level.add(new ItemEntity(new ResourceItem(Resource.slime), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
                }
            }
            if (this.level.player != null) {
                final Player player = this.level.player;
                Player.score += 25 * this.lvl * Game.multiplyer;
            }
        }
        ++Game.multiplyer;
        Game.multiplyertime = (Game.mtm -= 5);
    }
    
    @Override
    public void render(final Screen screen) {
        int xt = 0;
        final int yt = 18;
        final int xo = this.x - 8;
        int yo = this.y - 11;
        if (this.jumpTime > 0) {
            xt += 2;
            yo -= 4;
        }
        this.col0 = Color.get(-1, 20, 40, 222);
        this.col1 = Color.get(-1, 30, 252, 333);
        this.col2 = Color.get(-1, 20, 40, 222);
        this.col3 = Color.get(-1, 10, 20, 111);
        this.col4 = Color.get(-1, 20, 40, 222);
        if (this.isLight()) {
            this.col0 = Color.get(-1, 30, 252, 333);
            this.col1 = Color.get(-1, 30, 252, 333);
            this.col2 = Color.get(-1, 30, 252, 333);
            this.col3 = Color.get(-1, 30, 252, 333);
            this.col4 = Color.get(-1, 30, 252, 333);
        }
        else {
            this.col0 = Color.get(-1, 20, 40, 222);
            this.col1 = Color.get(-1, 30, 252, 333);
            this.col2 = Color.get(-1, 20, 40, 222);
            this.col3 = Color.get(-1, 10, 20, 111);
            this.col4 = Color.get(-1, 20, 40, 222);
        }
        if (this.level.dirtColor == 322) {
            if (Game.Time == 0) {
                int col = this.col0;
                if (this.lvl == 2) {
                    col = Color.get(-1, 100, 522, 555);
                }
                if (this.lvl == 3) {
                    col = Color.get(-1, 111, 444, 555);
                }
                if (this.lvl == 4) {
                    col = Color.get(-1, 0, 111, 224);
                }
                if (this.hurtTime > 0) {
                    col = Color.get(-1, 555, 555, 555);
                }
                screen.render(xo + 0, yo + 0, xt + yt * 32, col, 0);
                screen.render(xo + 8, yo + 0, xt + 1 + yt * 32, col, 0);
                screen.render(xo + 0, yo + 8, xt + (yt + 1) * 32, col, 0);
                screen.render(xo + 8, yo + 8, xt + 1 + (yt + 1) * 32, col, 0);
            }
            if (Game.Time == 1) {
                int col = this.col1;
                if (this.lvl == 2) {
                    col = Color.get(-1, 100, 522, 555);
                }
                if (this.lvl == 3) {
                    col = Color.get(-1, 111, 444, 555);
                }
                if (this.lvl == 4) {
                    col = Color.get(-1, 0, 111, 224);
                }
                if (this.hurtTime > 0) {
                    col = Color.get(-1, 555, 555, 555);
                }
                screen.render(xo + 0, yo + 0, xt + yt * 32, col, 0);
                screen.render(xo + 8, yo + 0, xt + 1 + yt * 32, col, 0);
                screen.render(xo + 0, yo + 8, xt + (yt + 1) * 32, col, 0);
                screen.render(xo + 8, yo + 8, xt + 1 + (yt + 1) * 32, col, 0);
            }
            if (Game.Time == 2) {
                int col = this.col2;
                if (this.lvl == 2) {
                    col = Color.get(-1, 100, 522, 555);
                }
                if (this.lvl == 3) {
                    col = Color.get(-1, 111, 444, 555);
                }
                if (this.lvl == 4) {
                    col = Color.get(-1, 0, 111, 224);
                }
                if (this.hurtTime > 0) {
                    col = Color.get(-1, 555, 555, 555);
                }
                screen.render(xo + 0, yo + 0, xt + yt * 32, col, 0);
                screen.render(xo + 8, yo + 0, xt + 1 + yt * 32, col, 0);
                screen.render(xo + 0, yo + 8, xt + (yt + 1) * 32, col, 0);
                screen.render(xo + 8, yo + 8, xt + 1 + (yt + 1) * 32, col, 0);
            }
            if (Game.Time == 3) {
                int col = this.col3;
                if (this.lvl == 2) {
                    col = Color.get(-1, 100, 522, 555);
                }
                if (this.lvl == 3) {
                    col = Color.get(-1, 111, 444, 555);
                }
                if (this.lvl == 4) {
                    col = Color.get(-1, 0, 111, 224);
                }
                if (this.hurtTime > 0) {
                    col = Color.get(-1, 555, 555, 555);
                }
                screen.render(xo + 0, yo + 0, xt + yt * 32, col, 0);
                screen.render(xo + 8, yo + 0, xt + 1 + yt * 32, col, 0);
                screen.render(xo + 0, yo + 8, xt + (yt + 1) * 32, col, 0);
                screen.render(xo + 8, yo + 8, xt + 1 + (yt + 1) * 32, col, 0);
            }
        }
        if (this.level.dirtColor != 322) {
            int col = this.col4;
            if (this.lvl == 2) {
                col = Color.get(-1, 100, 522, 555);
            }
            if (this.lvl == 3) {
                col = Color.get(-1, 111, 444, 555);
            }
            if (this.lvl == 4) {
                col = Color.get(-1, 0, 111, 224);
            }
            if (this.hurtTime > 0) {
                col = Color.get(-1, 555, 555, 555);
            }
            screen.render(xo + 0, yo + 0, xt + yt * 32, col, 0);
            screen.render(xo + 8, yo + 0, xt + 1 + yt * 32, col, 0);
            screen.render(xo + 0, yo + 8, xt + (yt + 1) * 32, col, 0);
            screen.render(xo + 8, yo + 8, xt + 1 + (yt + 1) * 32, col, 0);
        }
    }
    
    @Override
    public boolean canWool() {
        return true;
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
}
