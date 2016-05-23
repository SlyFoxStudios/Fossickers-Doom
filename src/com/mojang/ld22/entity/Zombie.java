// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.entity;

import com.mojang.ld22.item.Item;
import com.mojang.ld22.item.ResourceItem;
import com.mojang.ld22.item.resource.Resource;
import com.mojang.ld22.Game;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.screen.ModeMenu;
import com.mojang.ld22.screen.StartMenu;
import com.mojang.ld22.gfx.Color;

public class Zombie extends Mob
{
    int xa;
    int ya;
    int xe;
    int ye;
    private int randomWalkTime;
    
    public Zombie(int lvl) {
        this.xe = this.xa;
        this.ye = this.ya;
        this.randomWalkTime = 0;
        if (lvl == 0) {
            lvl = 1;
        }
        this.lvl = lvl;
        this.col0 = Color.get(-1, 10, 152, 40);
        this.col1 = Color.get(-1, 20, 252, 50);
        this.col2 = Color.get(-1, 10, 152, 40);
        this.col3 = Color.get(-1, 0, 30, 20);
        this.col4 = Color.get(-1, 10, 42, 30);
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
                final int n = lvl * lvl * 5;
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
                final int n2 = lvl * lvl * 10;
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
                final int n3 = lvl * lvl * 20;
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
                if (!bed.hasBedSet) {
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
                else {
                    if (xd < 0) {
                        this.xa = 1;
                    }
                    this.xe = this.xa;
                    if (xd > 0) {
                        this.xa = -1;
                    }
                    this.xe = this.xa;
                    if (yd < 0) {
                        this.ya = 1;
                    }
                    this.xe = this.xa;
                    if (yd > 0) {
                        this.ya = -1;
                    }
                    this.xe = this.xa;
                }
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
        int xt = 0;
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
        this.col0 = Color.get(-1, 10, 152, 40);
        this.col1 = Color.get(-1, 20, 252, 50);
        this.col2 = Color.get(-1, 10, 152, 40);
        this.col3 = Color.get(-1, 0, 30, 20);
        this.col4 = Color.get(-1, 10, 152, 40);
        if (this.isLight()) {
            this.col0 = Color.get(-1, 20, 252, 50);
            this.col1 = Color.get(-1, 20, 252, 50);
            this.col2 = Color.get(-1, 20, 252, 50);
            this.col3 = Color.get(-1, 20, 252, 50);
            this.col4 = Color.get(-1, 20, 252, 50);
        }
        else {
            this.col0 = Color.get(-1, 10, 152, 40);
            this.col1 = Color.get(-1, 20, 252, 50);
            this.col2 = Color.get(-1, 10, 152, 40);
            this.col3 = Color.get(-1, 0, 30, 20);
            this.col4 = Color.get(-1, 10, 152, 40);
        }
        if (this.level.dirtColor == 322) {
            if (Game.Time == 0) {
                int col = this.col0;
                if (this.lvl == 2) {
                    col = Color.get(-1, 100, 522, 40);
                }
                if (this.lvl == 3) {
                    col = Color.get(-1, 111, 444, 40);
                }
                if (this.lvl == 4) {
                    col = Color.get(-1, 0, 111, 16);
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
                    col = Color.get(-1, 100, 522, 40);
                }
                if (this.lvl == 3) {
                    col = Color.get(-1, 111, 444, 40);
                }
                if (this.lvl == 4) {
                    col = Color.get(-1, 0, 111, 16);
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
                    col = Color.get(-1, 100, 522, 40);
                }
                if (this.lvl == 3) {
                    col = Color.get(-1, 111, 444, 40);
                }
                if (this.lvl == 4) {
                    col = Color.get(-1, 0, 111, 16);
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
                    col = Color.get(-1, 100, 522, 40);
                }
                if (this.lvl == 3) {
                    col = Color.get(-1, 111, 444, 40);
                }
                if (this.lvl == 4) {
                    col = Color.get(-1, 0, 111, 16);
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
                col = Color.get(-1, 100, 522, 40);
            }
            if (this.lvl == 3) {
                col = Color.get(-1, 111, 444, 40);
            }
            if (this.lvl == 4) {
                col = Color.get(-1, 0, 111, 16);
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
        if (!this.hasspawned) {
            if (StartMenu.diff == StartMenu.easy) {
                for (int count = this.random.nextInt(3) + 2, i = 0; i < count; ++i) {
                    this.level.add(new ItemEntity(new ResourceItem(Resource.cloth), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
                }
            }
            if (StartMenu.diff == StartMenu.norm) {
                for (int count = this.random.nextInt(2) + 2, i = 0; i < count; ++i) {
                    this.level.add(new ItemEntity(new ResourceItem(Resource.cloth), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
                }
            }
            if (StartMenu.diff == StartMenu.hard) {
                for (int count = this.random.nextInt(1) + 1, i = 0; i < count; ++i) {
                    this.level.add(new ItemEntity(new ResourceItem(Resource.cloth), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
                }
            }
            int rand = this.random.nextInt(60);
            if (rand == 2) {
                this.level.add(new ItemEntity(new ResourceItem(Resource.ironIngot), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
            }
            rand = this.random.nextInt(40);
            if (rand == 19) {
                rand = this.random.nextInt(3);
                if (rand == 0) {
                    this.level.add(new ItemEntity(new ResourceItem(Resource.greenclothes), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
                }
                else if (rand == 1) {
                    this.level.add(new ItemEntity(new ResourceItem(Resource.redclothes), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
                }
                else if (rand == 2) {
                    this.level.add(new ItemEntity(new ResourceItem(Resource.blueclothes), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
                }
            }
            if (this.level.player != null) {
                final Player player = this.level.player;
                Player.score += 50 * this.lvl * Game.multiplyer;
            }
            ++Game.multiplyer;
            Game.multiplyertime = (Game.mtm -= 5);
        }
        else if (this.level.player != null) {
            final Player player2 = this.level.player;
            Player.score += 10;
        }
    }
}
