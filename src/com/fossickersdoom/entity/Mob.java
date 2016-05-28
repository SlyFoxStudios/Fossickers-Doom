// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.entity;

import com.fossickersdoom.screen.ModeMenu;
import com.fossickersdoom.level.Level;
import com.fossickersdoom.sound.Sound;
import com.fossickersdoom.entity.particle.TextParticle;
import com.fossickersdoom.gfx.Color;
import com.fossickersdoom.level.tile.Tile;

public class Mob extends Entity
{
    Player player;
    protected int walkDist;
    protected int dir;
    public int hurtTime;
    protected int xKnockback;
    protected int yKnockback;
    public int maxHealth;
    public int health;
    public int maxHunger;
    public int hunger;
    public int swimTimer;
    public int woolTimer;
    public int lightTimer;
    public int tickTime;
    public int r;
    public int xx;
    public int yy;
    public boolean isenemy;
    public int lvl;
    
    public Mob() {
        this.walkDist = 0;
        this.dir = 0;
        this.hurtTime = 0;
        this.maxHealth = 10;
        this.health = this.maxHealth;
        this.maxHunger = 10;
        this.hunger = this.maxHunger;
        this.swimTimer = 0;
        this.woolTimer = 0;
        this.lightTimer = 0;
        this.tickTime = 0;
        this.isenemy = false;
        final int n = 8;
        this.y = n;
        this.x = n;
        this.xr = 4;
        this.yr = 3;
        this.xx = this.x;
        this.yy = this.y;
    }
    
    @Override
    public void tick() {
        ++this.tickTime;
        if (this.level.getTile(this.x >> 4, this.y >> 4) == Tile.lava) {
            if (this instanceof Player) {
                final Player p = (Player)this;
                if (!p.lavaimmune) {
                    this.hurt(this, 4, this.dir ^ 0x1);
                }
            }
            else {
                this.hurt(this, 4, this.dir ^ 0x1);
            }
        }
        if (this.health <= 0) {
            this.die();
        }
        if (this.hurtTime > 0) {
            --this.hurtTime;
        }
    }
    
    protected void die() {
        this.remove();
    }
    
    @Override
    public boolean move(final int xa, final int ya) {
        if (this.isSwimming() && this.swimTimer++ % 2 == 0) {
            return true;
        }
        if (this.isWooling() && this.woolTimer++ % 2 == 0) {
            return true;
        }
        if (this.isLight() && this.lightTimer++ % 8000 == 0) {
            return true;
        }
        if (this.xKnockback < 0) {
            this.move2(-1, 0);
            ++this.xKnockback;
        }
        if (this.xKnockback > 0) {
            this.move2(1, 0);
            --this.xKnockback;
        }
        if (this.yKnockback < 0) {
            this.move2(0, -1);
            ++this.yKnockback;
        }
        if (this.yKnockback > 0) {
            this.move2(0, 1);
            --this.yKnockback;
        }
        if (this.hurtTime > 0) {
            return true;
        }
        if (xa != 0 || ya != 0) {
            ++this.walkDist;
            if (xa < 0) {
                this.dir = 2;
            }
            if (xa > 0) {
                this.dir = 3;
            }
            if (ya < 0) {
                this.dir = 1;
            }
            if (ya > 0) {
                this.dir = 0;
            }
        }
        return super.move(xa, ya);
    }
    
    protected boolean isWooling() {
        final Tile tile = this.level.getTile(this.x >> 0, this.y >> 0);
        return tile == Tile.wool;
    }
    
    public boolean isLight() {
        final Tile tile = this.level.getTile(this.x >> 4, this.y >> 4);
        return this.level.depth == 0 && (tile == Tile.lightgrass || tile == Tile.lightsand || tile == Tile.lightwater || tile == Tile.lightdirt || tile == Tile.lightflower || tile == Tile.lightstairsDown || tile == Tile.lightstairsUp || tile == Tile.lightplank || tile == Tile.lightsbrick || tile == Tile.lwdo || tile == Tile.lsdo || tile == Tile.lighthole || tile == Tile.lightwool || tile == Tile.lightrwool || tile == Tile.lightbwool || tile == Tile.lightgwool || tile == Tile.lightywool || tile == Tile.lightblwool || tile == Tile.lightts || tile == Tile.lightcs || tile == Tile.torchgrass || tile == Tile.torchsand || tile == Tile.torchdirt || tile == Tile.torchplank || tile == Tile.torchsbrick || tile == Tile.torchwool || tile == Tile.torchwoolred || tile == Tile.torchwoolblue || tile == Tile.torchwoolgreen || tile == Tile.torchwoolyellow || tile == Tile.torchwoolblack);
    }
    
    protected boolean isSwimming() {
        final Tile tile = this.level.getTile(this.x >> 4, this.y >> 4);
        return tile == Tile.water || tile == Tile.lava || tile == Tile.lightwater;
    }
    
    @Override
    public boolean blocks(final Entity e) {
        return e.isBlockableBy(this);
    }
    
    @Override
    public void hurt(final Tile tile, final int x, final int y, final int damage) {
        final int attackDir = this.dir ^ 0x1;
        this.doHurt(damage, attackDir);
    }
    
    @Override
    public void hurt(final Mob mob, final int damage, final int attackDir) {
        this.doHurt(damage, attackDir);
    }
    
    public void heal(final int heal) {
        if (this.hurtTime > 0) {
            return;
        }
        this.level.add(new TextParticle(new StringBuilder().append(heal).toString(), this.x, this.y, Color.get(-1, 50, 50, 50)));
        this.health += heal;
        if (this.health > this.maxHealth) {
            this.health = this.maxHealth;
        }
    }
    
    public void hungerHeal(final int hungerHeal) {
        this.hunger += hungerHeal;
        if (this.hunger > this.maxHunger) {
            this.hunger = this.maxHunger;
        }
    }
    
    protected void doHurt(final int damage, final int attackDir) {
        if (this.hurtTime > 0) {
            return;
        }
        if (this.level.player != null) {
            final int xd = this.level.player.x - this.x;
            final int yd = this.level.player.y - this.y;
            if (xd * xd + yd * yd < 6400) {
                Sound.monsterHurt.play();
            }
        }
        this.level.add(new TextParticle(new StringBuilder().append(damage).toString(), this.x, this.y, Color.get(-1, 500, 500, 500)));
        this.health -= damage;
        if (attackDir == 0) {
            this.yKnockback = 6;
        }
        if (attackDir == 1) {
            this.yKnockback = -6;
        }
        if (attackDir == 2) {
            this.xKnockback = -6;
        }
        if (attackDir == 3) {
            this.xKnockback = 6;
        }
        this.hurtTime = 10;
    }
    
    public boolean findStartPos(final Level level) {
        final int x = this.random.nextInt(level.w);
        final int y = this.random.nextInt(level.h);
        final int xx = x * 16 + 8;
        final int yy = y * 16 + 8;
        if (level.player != null) {
            final int xd = level.player.x - xx;
            final int yd = level.player.y - yy;
            if (xd * xd + yd * yd < 3600) {
                return false;
            }
        }
        final int r = level.monsterDensity * 13;
        if (level.getEntities(xx - r, yy - r, xx + r, yy + r).size() > 0) {
            return false;
        }
        if (level.getTile(x, y).mayPass(level, x, y, this) && level.getTile(x, y) != Tile.sdo && level.getTile(x, y) != Tile.wdo && level.getTile(x, y) != Tile.wheat && level.getTile(x, y) != Tile.farmland && level.getTile(x, y) != Tile.lightsbrick && level.getTile(x, y) != Tile.lightplank && level.getTile(x, y) != Tile.lightwool && level.getTile(x, y) != Tile.lightrwool && level.getTile(x, y) != Tile.lightbwool && level.getTile(x, y) != Tile.lightgwool && level.getTile(x, y) != Tile.lightywool && level.getTile(x, y) != Tile.lightblwool && level.getTile(x, y) != Tile.lightgrass && level.getTile(x, y) != Tile.lightsand && level.getTile(x, y) != Tile.lightdirt && level.getTile(x, y) != Tile.lightflower && level.getTile(x, y) != Tile.torchgrass && level.getTile(x, y) != Tile.torchsand && level.getTile(x, y) != Tile.torchdirt && level.getTile(x, y) != Tile.torchplank && level.getTile(x, y) != Tile.torchsbrick && level.getTile(x, y) != Tile.torchwool && level.getTile(x, y) != Tile.torchwoolred && level.getTile(x, y) != Tile.torchwoolblue && level.getTile(x, y) != Tile.torchwoolgreen && level.getTile(x, y) != Tile.torchwoolyellow && level.getTile(x, y) != Tile.torchwoolblack) {
            this.x = xx;
            this.y = yy;
            return true;
        }
        return false;
    }
    
    public boolean findStartPosDungeon(final Level level) {
        final int x = this.random.nextInt(level.w);
        final int y = this.random.nextInt(level.h);
        final int xx = x * 16 + 8;
        final int yy = y * 16 + 8;
        if (level.player != null) {
            final int xd = level.player.x - xx;
            final int yd = level.player.y - yy;
            if (xd * xd + yd * yd < 3600) {
                return false;
            }
        }
        if (!ModeMenu.score) {
            this.r = level.monsterDensity * 15;
        }
        else {
            this.r = level.monsterDensity * 22;
        }
        if (level.getEntities(xx - this.r, yy - this.r, xx + this.r, yy + this.r).size() > 0) {
            return false;
        }
        if (level.getTile(x, y).mayPass(level, x, y, this) && level.getTile(x, y) == Tile.o) {
            this.x = xx;
            this.y = yy;
            return true;
        }
        return false;
    }
    
    public boolean findStartPosCow(final Level level) {
        final int x = this.random.nextInt(level.w);
        final int y = this.random.nextInt(level.h);
        final int xx = x * 16 + 8;
        final int yy = y * 16 + 8;
        if (level.player != null) {
            final int xd = level.player.x - xx;
            final int yd = level.player.y - yy;
            if (xd * xd + yd * yd < 6400) {
                return false;
            }
        }
        if (!ModeMenu.score) {
            this.r = level.monsterDensity * 20;
        }
        else {
            this.r = level.monsterDensity * 27;
        }
        if (level.getEntities(xx - this.r, yy - this.r, xx + this.r, yy + this.r).size() > 0) {
            return false;
        }
        if (level.getTile(x, y).mayPass(level, x, y, this)) {
            if (level.getTile(x, y) == Tile.grass) {
                this.x = xx;
                this.y = yy;
                return true;
            }
            if (level.getTile(x, y) == Tile.flower) {
                this.x = xx;
                this.y = yy;
                return true;
            }
            if (level.getTile(x, y) == Tile.lightgrass) {
                this.x = xx;
                this.y = yy;
                return true;
            }
            if (level.getTile(x, y) == Tile.lightflower) {
                this.x = xx;
                this.y = yy;
                return true;
            }
        }
        return false;
    }
    
    public boolean findStartPosCowLight(final Level level) {
        final int x = this.random.nextInt(level.w);
        final int y = this.random.nextInt(level.h);
        final int xx = x * 16 + 8;
        final int yy = y * 16 + 8;
        if (level.player != null) {
            final int xd = level.player.x - xx;
            final int yd = level.player.y - yy;
            if (xd * xd + yd * yd < 6400) {
                return false;
            }
        }
        if (!ModeMenu.score) {
            this.r = level.monsterDensity * 15;
        }
        else {
            this.r = level.monsterDensity * 22;
        }
        if (level.getEntities(xx - this.r, yy - this.r, xx + this.r, yy + this.r).size() > 0) {
            return false;
        }
        if (level.getTile(x, y).mayPass(level, x, y, this)) {
            if (level.getTile(x, y) == Tile.grass) {
                this.x = xx;
                this.y = yy;
                return true;
            }
            if (level.getTile(x, y) == Tile.flower) {
                this.x = xx;
                this.y = yy;
                return true;
            }
            if (level.getTile(x, y) == Tile.lightgrass) {
                this.x = xx;
                this.y = yy;
                return true;
            }
            if (level.getTile(x, y) == Tile.lightflower) {
                this.x = xx;
                this.y = yy;
                return true;
            }
        }
        return false;
    }
}
