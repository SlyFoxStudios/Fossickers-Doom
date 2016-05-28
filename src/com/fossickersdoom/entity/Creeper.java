// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.entity;

import com.fossickersdoom.item.resource.Resource;
import com.fossickersdoom.screen.ModeMenu;
import com.fossickersdoom.item.ResourceItem;
import com.fossickersdoom.Game;
import com.fossickersdoom.gfx.Screen;
import com.fossickersdoom.level.tile.Tile;
import com.fossickersdoom.sound.Sound;
import com.fossickersdoom.screen.StartMenu;
import com.fossickersdoom.gfx.Color;

public class Creeper extends Mob
{
    private int MAX_FUSE_TIME;
    private int BLAST_RADIUS;
    private int BLAST_DAMAGE;
    private int xa;
    private int ya;
    private int randomWalkTime;
    private int fuseTime;
    private boolean fuseLit;
    
    public Creeper(int lvl) {
        this.MAX_FUSE_TIME = 60;
        this.BLAST_RADIUS = 60;
        this.BLAST_DAMAGE = 10;
        this.randomWalkTime = 0;
        this.fuseTime = 0;
        this.fuseLit = false;
        if (lvl == 0) {
            lvl = 1;
        }
        this.col0 = Color.get(-1, 10, 50, 40);
        this.col1 = Color.get(-1, 20, 50, 40);
        this.col2 = Color.get(-1, 10, 50, 30);
        this.col3 = Color.get(-1, 0, 50, 30);
        this.col4 = Color.get(-1, 20, 50, 30);
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
                final int n = lvl * lvl * 10;
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
                final int n2 = lvl * lvl * 20;
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
                final int n3 = lvl * lvl * 40;
                this.maxHealth = n3;
                this.health = n3;
            }
        }
    }
    
    @Override
    public boolean move(final int xa, final int ya) {
        final boolean result = super.move(xa, ya);
        if (xa == 0 && ya == 0) {
            this.walkDist = 0;
        }
        return result;
    }
    
    @Override
    public void tick() {
        super.tick();
        this.isenemy = true;
        if (StartMenu.diff == StartMenu.easy) {
            if (this.fuseTime == 0) {
                if (!this.fuseLit) {
                    if (this.level.player != null && this.randomWalkTime == 0) {
                        final int xd = this.level.player.x - this.x;
                        final int yd = this.level.player.y - this.y;
                        if (xd * xd + yd * yd < 2500) {
                            this.xa = 0;
                            this.ya = 0;
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
                else {
                    final int pdx = Math.abs(this.level.player.x - this.x);
                    final int pdy = Math.abs(this.level.player.y - this.y);
                    if (pdx < this.BLAST_RADIUS && pdy < this.BLAST_RADIUS) {
                        final float pd = (float)Math.sqrt(pdx * pdx + pdy * pdy);
                        final int dmg = (int)(this.BLAST_DAMAGE * (1.0f - pd / this.BLAST_RADIUS)) + 0;
                        this.level.player.hurt(this, dmg, 0);
                        this.level.player.payStamina(dmg * 1);
                        Sound.explode.play();
                        final int xt = this.x >> 4;
                        final int yt = this.y - 2 >> 4;
                        if (this.level.depth == 1) {
                            this.level.setTile(xt, yt, Tile.infiniteFall, 0);
                        }
                        else if (this.level.depth == -3) {
                            this.level.setTile(xt, yt, Tile.lava, 0);
                        }
                        else {
                            this.level.setTile(xt, yt, Tile.hole, 0);
                        }
                        super.die();
                    }
                    else {
                        this.fuseTime = 0;
                        this.fuseLit = false;
                    }
                }
            }
            else {
                --this.fuseTime;
            }
        }
        if (StartMenu.diff == StartMenu.norm) {
            if (this.fuseTime == 0) {
                if (!this.fuseLit) {
                    if (this.level.player != null && this.randomWalkTime == 0) {
                        final int xd = this.level.player.x - this.x;
                        final int yd = this.level.player.y - this.y;
                        if (xd * xd + yd * yd < 2500) {
                            this.xa = 0;
                            this.ya = 0;
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
                else {
                    final int pdx = Math.abs(this.level.player.x - this.x);
                    final int pdy = Math.abs(this.level.player.y - this.y);
                    if (pdx < this.BLAST_RADIUS && pdy < this.BLAST_RADIUS) {
                        final float pd = (float)Math.sqrt(pdx * pdx + pdy * pdy);
                        final int dmg = (int)(this.BLAST_DAMAGE * (1.0f - pd / this.BLAST_RADIUS)) + 1;
                        this.level.player.hurt(this, dmg, 0);
                        this.level.player.payStamina(dmg * 2);
                        Sound.explode.play();
                        final int xt = this.x >> 4;
                        final int yt = this.y - 2 >> 4;
                        if (this.level.depth == 1) {
                            this.level.setTile(xt, yt, Tile.infiniteFall, 0);
                        }
                        else if (this.level.depth == -3) {
                            this.level.setTile(xt, yt, Tile.lava, 0);
                        }
                        else {
                            this.level.setTile(xt, yt, Tile.hole, 0);
                        }
                        super.die();
                    }
                    else {
                        this.fuseTime = 0;
                        this.fuseLit = false;
                    }
                }
            }
            else {
                --this.fuseTime;
            }
        }
        if (StartMenu.diff == StartMenu.hard) {
            if (this.fuseTime == 0) {
                if (!this.fuseLit) {
                    if (this.level.player != null && this.randomWalkTime == 0) {
                        final int xd = this.level.player.x - this.x;
                        final int yd = this.level.player.y - this.y;
                        if (xd * xd + yd * yd < 2500) {
                            this.xa = 0;
                            this.ya = 0;
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
                else {
                    final int pdx = Math.abs(this.level.player.x - this.x);
                    final int pdy = Math.abs(this.level.player.y - this.y);
                    if (pdx < this.BLAST_RADIUS && pdy < this.BLAST_RADIUS) {
                        final float pd = (float)Math.sqrt(pdx * pdx + pdy * pdy);
                        final int dmg = (int)(this.BLAST_DAMAGE * (1.0f - pd / this.BLAST_RADIUS)) + 2;
                        this.level.player.hurt(this, dmg, 0);
                        this.level.player.payStamina(dmg * 2);
                        Sound.explode.play();
                        final int xt = this.x >> 4;
                        final int yt = this.y - 2 >> 4;
                        if (this.level.depth == 1) {
                            this.level.setTile(xt, yt, Tile.infiniteFall, 0);
                        }
                        else if (this.level.depth == -3) {
                            this.level.setTile(xt, yt, Tile.lava, 0);
                        }
                        else {
                            this.level.setTile(xt, yt, Tile.hole, 0);
                        }
                        super.die();
                    }
                    else {
                        this.fuseTime = 0;
                        this.fuseLit = false;
                    }
                }
            }
            else {
                --this.fuseTime;
            }
        }
    }
    
    @Override
    public void render(final Screen screen) {
        int xt = 4;
        final int yt = 18;
        if (this.walkDist > 0) {
            if (this.random.nextInt(2) == 0) {
                xt += 2;
            }
            else {
                xt += 4;
            }
        }
        else {
            xt = 4;
        }
        final int xo = this.x - 8;
        final int yo = this.y - 11;
        this.col0 = Color.get(-1, 10, 30, 20);
        this.col1 = Color.get(-1, 20, 40, 30);
        this.col2 = Color.get(-1, 10, 30, 20);
        this.col3 = Color.get(-1, 0, 20, 10);
        this.col4 = Color.get(-1, 20, 40, 30);
        if (this.isLight()) {
            this.col0 = Color.get(-1, 20, 40, 30);
            this.col1 = Color.get(-1, 20, 40, 30);
            this.col2 = Color.get(-1, 20, 40, 30);
            this.col3 = Color.get(-1, 20, 40, 30);
            this.col4 = Color.get(-1, 20, 40, 30);
        }
        else {
            this.col0 = Color.get(-1, 10, 30, 20);
            this.col1 = Color.get(-1, 20, 40, 30);
            this.col2 = Color.get(-1, 10, 30, 20);
            this.col3 = Color.get(-1, 0, 20, 10);
            this.col4 = Color.get(-1, 20, 40, 30);
        }
        if (this.level.dirtColor == 322) {
            if (Game.Time == 0) {
                int col = this.col0;
                if (this.lvl == 2) {
                    col = Color.get(-1, 200, 262, 232);
                }
                if (this.lvl == 3) {
                    col = Color.get(-1, 200, 272, 222);
                }
                if (this.lvl == 4) {
                    col = Color.get(-1, 200, 292, 282);
                }
                if (this.fuseLit && this.fuseTime % 6 == 0) {
                    col = Color.get(-1, 252, 252, 252);
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
                    col = Color.get(-1, 200, 262, 232);
                }
                if (this.lvl == 3) {
                    col = Color.get(-1, 200, 272, 222);
                }
                if (this.lvl == 4) {
                    col = Color.get(-1, 200, 292, 282);
                }
                if (this.fuseLit && this.fuseTime % 6 == 0) {
                    col = Color.get(-1, 252, 252, 252);
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
                    col = Color.get(-1, 200, 262, 232);
                }
                if (this.lvl == 3) {
                    col = Color.get(-1, 200, 272, 222);
                }
                if (this.lvl == 4) {
                    col = Color.get(-1, 200, 292, 282);
                }
                if (this.fuseLit && this.fuseTime % 6 == 0) {
                    col = Color.get(-1, 252, 252, 252);
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
                    col = Color.get(-1, 200, 262, 232);
                }
                if (this.lvl == 3) {
                    col = Color.get(-1, 200, 272, 222);
                }
                if (this.lvl == 4) {
                    col = Color.get(-1, 200, 292, 282);
                }
                if (this.fuseLit && this.fuseTime % 6 == 0) {
                    col = Color.get(-1, 252, 252, 252);
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
                col = Color.get(-1, 200, 262, 232);
            }
            if (this.lvl == 3) {
                col = Color.get(-1, 200, 272, 222);
            }
            if (this.lvl == 4) {
                col = Color.get(-1, 200, 292, 282);
            }
            if (this.fuseLit && this.fuseTime % 6 == 0) {
                col = Color.get(-1, 252, 252, 252);
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
    protected void touchedBy(final Entity entity) {
        if (entity instanceof Player) {
            if (this.fuseTime == 0) {
                Sound.fuse.play();
                this.fuseTime = this.MAX_FUSE_TIME;
                this.fuseLit = true;
            }
            entity.hurt(this, 1, this.dir);
        }
    }
    
    @Override
    protected void die() {
        super.die();
        if (StartMenu.diff == StartMenu.easy) {
            for (int count = this.random.nextInt(3) + 1, i = 0; i < count; ++i) {
                this.level.add(new ItemEntity(new ResourceItem(Resource.gunp), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
            }
        }
        if (StartMenu.diff == StartMenu.norm) {
            for (int count = this.random.nextInt(2) + 1, i = 0; i < count; ++i) {
                this.level.add(new ItemEntity(new ResourceItem(Resource.gunp), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
            }
        }
        if (StartMenu.diff == StartMenu.hard) {
            for (int count = this.random.nextInt(1) + 1, i = 0; i < count; ++i) {
                this.level.add(new ItemEntity(new ResourceItem(Resource.gunp), this.x + this.random.nextInt(11) - 5, this.y + this.random.nextInt(11) - 5));
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
