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

public class Skeleton extends Mob
{
    int xa;
    int ya;
    int xe;
    int ye;
    private int lvl;
    private int randomWalkTime;
    public int arrowtime;
    public int artime;
    
    public Skeleton(int lvl) {
        this.xe = this.xa;
        this.ye = this.ya;
        this.randomWalkTime = 0;
        this.arrowtime = 70 / (this.lvl + 1);
        this.artime = this.arrowtime;
        if (lvl == 0) {
            lvl = 1;
        }
        this.col0 = Color.get(-1, 111, 40, 444);
        this.col1 = Color.get(-1, 222, 50, 555);
        this.col2 = Color.get(-1, 111, 40, 444);
        this.col3 = Color.get(-1, 0, 30, 333);
        this.col4 = Color.get(-1, 111, 40, 444);
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
                final int n = lvl * lvl * 6;
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
                final int n2 = lvl * lvl * 12;
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
                final int n3 = lvl * lvl * 24;
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
            final boolean done = false;
            --this.artime;
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
                if (this.artime < 1) {
                    switch (this.dir) {
                        case 0: {
                            this.level.add(new Arrow(this, 0, 1, this.lvl, done));
                            this.artime = this.arrowtime;
                            break;
                        }
                        case 1: {
                            this.level.add(new Arrow(this, 0, -1, this.lvl, done));
                            this.artime = this.arrowtime;
                            break;
                        }
                        case 2: {
                            this.level.add(new Arrow(this, -1, 0, this.lvl, done));
                            this.artime = this.arrowtime;
                            break;
                        }
                        case 3: {
                            this.level.add(new Arrow(this, 1, 0, this.lvl, done));
                            this.artime = this.arrowtime;
                            break;
                        }
                    }
                }
            }
        }
        final int speed = this.tickTime & 0x1;
        if (!this.move(this.xa * speed, this.ya * speed) || this.random.nextInt(200) == 0) {
            this.randomWalkTime = 45;
            this.xa = (this.random.nextInt(3) - 1) * this.random.nextInt(2);
            this.ya = (this.random.nextInt(3) - 1) * this.random.nextInt(2);
        }
        if (this.randomWalkTime > 0) {
            --this.randomWalkTime;
        }
    }
    
    @Override
    public void render(final Screen screen) {
        int xt = 8;
        final int yt = 16;
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
        this.col0 = Color.get(-1, 111, 40, 444);
        this.col1 = Color.get(-1, 222, 50, 555);
        this.col2 = Color.get(-1, 111, 40, 444);
        this.col3 = Color.get(-1, 0, 30, 333);
        this.col4 = Color.get(-1, 111, 40, 444);
        if (this.isLight()) {
            this.col0 = Color.get(-1, 222, 50, 555);
            this.col1 = Color.get(-1, 222, 50, 555);
            this.col2 = Color.get(-1, 222, 50, 555);
            this.col3 = Color.get(-1, 222, 50, 555);
            this.col4 = Color.get(-1, 222, 50, 555);
        }
        else {
            this.col0 = Color.get(-1, 111, 40, 444);
            this.col1 = Color.get(-1, 222, 50, 555);
            this.col2 = Color.get(-1, 111, 40, 444);
            this.col3 = Color.get(-1, 0, 30, 333);
            this.col4 = Color.get(-1, 111, 40, 444);
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
                    col = Color.get(-1, 0, 111, 555);
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
                    col = Color.get(-1, 100, 522, 555);
                }
                if (this.lvl == 3) {
                    col = Color.get(-1, 111, 444, 555);
                }
                if (this.lvl == 4) {
                    col = Color.get(-1, 0, 111, 555);
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
                    col = Color.get(-1, 100, 522, 555);
                }
                if (this.lvl == 3) {
                    col = Color.get(-1, 111, 444, 555);
                }
                if (this.lvl == 4) {
                    col = Color.get(-1, 0, 111, 555);
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
                    col = Color.get(-1, 100, 522, 555);
                }
                if (this.lvl == 3) {
                    col = Color.get(-1, 111, 444, 555);
                }
                if (this.lvl == 4) {
                    col = Color.get(-1, 0, 111, 555);
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
                col = Color.get(-1, 100, 522, 555);
            }
            if (this.lvl == 3) {
                col = Color.get(-1, 111, 444, 555);
            }
            if (this.lvl == 4) {
                col = Color.get(-1, 0, 111, 555);
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
        if (StartMenu.diff == StartMenu.easy) {
            final boolean b = entity instanceof Player;
        }
        if (StartMenu.diff == StartMenu.norm) {
            final boolean b2 = entity instanceof Player;
        }
        if (StartMenu.diff == StartMenu.hard) {
            final boolean b3 = entity instanceof Player;
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
                final int count = this.random.nextInt(3) + 1;
                final int bookcount = this.random.nextInt(1) + 1;
                final int rand = this.random.nextInt(20);
                if (rand <= 13) {
                    for (int i = 0; i < count; ++i) {
                        this.level.add(new ItemEntity(new ResourceItem(Resource.bone), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
                        this.level.add(new ItemEntity(new ResourceItem(Resource.arrow), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
                    }
                }
                else if (rand >= 14 && rand != 19) {
                    for (int i = 0; i < bookcount; ++i) {
                        this.level.add(new ItemEntity(new ResourceItem(Resource.arrow), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
                        this.level.add(new ItemEntity(new ResourceItem(Resource.bookant), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
                    }
                }
                else if (rand == 19) {
                    for (int i = 0; i < 10; ++i) {
                        this.level.add(new ItemEntity(new ResourceItem(Resource.arrow), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
                    }
                }
            }
            if (StartMenu.diff == StartMenu.norm) {
                final int count = this.random.nextInt(2) + 1;
                final int bookcount = this.random.nextInt(1) + 1;
                final int rand = this.random.nextInt(20);
                if (rand <= 18) {
                    for (int i = 0; i < count; ++i) {
                        this.level.add(new ItemEntity(new ResourceItem(Resource.arrow), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
                        this.level.add(new ItemEntity(new ResourceItem(Resource.bone), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
                    }
                }
                else if (rand >= 19) {
                    for (int i = 0; i < bookcount; ++i) {
                        this.level.add(new ItemEntity(new ResourceItem(Resource.arrow), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
                        this.level.add(new ItemEntity(new ResourceItem(Resource.bookant), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
                    }
                }
            }
            if (StartMenu.diff == StartMenu.hard) {
                final int count = this.random.nextInt(1) + 1;
                final int bookcount = this.random.nextInt(1) + 1;
                final int rand = this.random.nextInt(30);
                if (rand <= 28) {
                    for (int i = 0; i < count; ++i) {
                        this.level.add(new ItemEntity(new ResourceItem(Resource.arrow), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
                        this.level.add(new ItemEntity(new ResourceItem(Resource.bone), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
                    }
                }
                else if (rand >= 29) {
                    for (int i = 0; i < bookcount; ++i) {
                        this.level.add(new ItemEntity(new ResourceItem(Resource.arrow), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
                        this.level.add(new ItemEntity(new ResourceItem(Resource.bookant), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
                    }
                }
            }
            if (this.level.player != null) {
                final Player player = this.level.player;
                Player.score += 50 * this.lvl * Game.multiplyer;
            }
            ++Game.multiplyer;
            Game.multiplyertime = (Game.mtm -= 5);
        }
    }
}
