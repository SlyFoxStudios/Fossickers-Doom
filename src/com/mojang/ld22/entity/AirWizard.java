// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.entity;

import java.io.IOException;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import com.mojang.ld22.screen.StartMenu;
import com.mojang.ld22.Game;
import com.mojang.ld22.sound.Sound;
import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.gfx.Color;
import java.io.File;
import java.util.Random;

public class AirWizard extends Mob
{
    private int xa;
    private int ya;
    private int randomWalkTime;
    private int attackDelay;
    private int attackTime;
    private int attackType;
    public int healthstat;
    public static boolean beaten;
    public boolean secondform;
    Random r;
    String location;
    File folder;
    
    static {
        AirWizard.beaten = false;
    }
    
    public AirWizard(final boolean secondform) {
        this.randomWalkTime = 0;
        this.attackDelay = 0;
        this.attackTime = 0;
        this.attackType = 0;
        this.healthstat = 2000;
        this.secondform = false;
        this.r = new Random();
        this.location = String.valueOf(System.getenv("APPDATA")) + "/.fossickersdoom";
        this.folder = new File(this.location);
        this.col0 = Color.get(-1, 100, 500, 555);
        this.col1 = Color.get(-1, 100, 500, 555);
        this.col2 = Color.get(-1, 0, 200, 333);
        this.col3 = Color.get(-1, 0, 200, 333);
        this.col4 = Color.get(-1, 0, 200, 333);
        if (secondform) {
            this.col = Color.get(-1, 0, 4, 46);
            this.col0 = Color.get(-1, 0, 4, 46);
            this.col1 = Color.get(-1, 0, 4, 46);
            this.col2 = Color.get(-1, 0, 4, 46);
            this.col3 = Color.get(-1, 0, 4, 46);
            this.col4 = Color.get(-1, 0, 1, 32);
        }
        this.x = this.random.nextInt(1024);
        this.y = this.random.nextInt(1024);
        if (!secondform) {
            final int n = 2000;
            this.maxHealth = n;
            this.health = n;
        }
        if (secondform) {
            final int n2 = 5000;
            this.maxHealth = n2;
            this.health = n2;
            this.healthstat = 5000;
            this.secondform = secondform;
        }
    }
    
    @Override
    public boolean canSwim() {
        return this.secondform;
    }
    
    @Override
    public void tick() {
        super.tick();
        this.isenemy = true;
        this.healthstat = this.health;
        if (this.attackDelay > 0) {
            this.dir = (this.attackDelay - 45) / 4 % 4;
            this.dir = this.dir * 2 % 4 + this.dir / 2;
            if (this.attackDelay < 45) {
                this.dir = 0;
            }
            --this.attackDelay;
            if (this.attackDelay == 0) {
                this.attackType = 0;
                if (this.health < 1000) {
                    this.attackType = 1;
                }
                if (this.health < 200) {
                    this.attackType = 2;
                }
                this.attackTime = 120;
                if (this.secondform) {
                    if (this.health < 2500) {
                        this.attackType = 1;
                    }
                    if (this.health < 500) {
                        this.attackType = 2;
                    }
                    this.attackTime = 180;
                }
            }
            return;
        }
        if (this.attackTime > 0) {
            --this.attackTime;
            final double dir = this.attackTime * 0.25 * (this.attackTime % 2 * 2 - 1);
            double speed = 0.7 + this.attackType * 0.2;
            if (this.secondform) {
                speed = 1.2 + this.attackType * 0.2;
            }
            this.level.add(new Spark(this, Math.cos(dir) * speed, Math.sin(dir) * speed));
            return;
        }
        if (this.level.player != null && this.randomWalkTime == 0) {
            final int xd = this.level.player.x - this.x;
            final int yd = this.level.player.y - this.y;
            if (xd * xd + yd * yd < 1024) {
                this.xa = 0;
                this.ya = 0;
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
            else if (xd * xd + yd * yd > 6400) {
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
            if (xd * xd + yd * yd > 22500) {
                final int rx = this.r.nextInt(64);
                final int ry = this.r.nextInt(64);
                this.x = this.level.player.x - 16 + rx;
                this.y = this.level.player.y - 16 + ry;
            }
        }
        int speed2 = (this.tickTime % 4 != 0) ? 1 : 0;
        if (this.secondform) {
            speed2 = ((this.tickTime % 2 != 0) ? 1 : 0);
        }
        if (!this.move(this.xa * speed2, this.ya * speed2) || this.random.nextInt(100) == 0) {
            this.randomWalkTime = 30;
            this.xa = this.random.nextInt(3) - 1;
            this.ya = this.random.nextInt(3) - 1;
        }
        if (this.randomWalkTime > 0) {
            --this.randomWalkTime;
            if (this.level.player != null && this.randomWalkTime == 0) {
                final int xd2 = this.level.player.x - this.x;
                final int yd2 = this.level.player.y - this.y;
                if (this.random.nextInt(4) == 0 && xd2 * xd2 + yd2 * yd2 < 2500 && this.attackDelay == 0 && this.attackTime == 0) {
                    this.attackDelay = 120;
                }
            }
        }
    }
    
    @Override
    protected void doHurt(final int damage, final int attackDir) {
        super.doHurt(damage, attackDir);
        if (this.attackDelay == 0 && this.attackTime == 0) {
            this.attackDelay = 120;
        }
    }
    
    @Override
    public void render(final Screen screen) {
        int xt = 8;
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
        this.col1 = Color.get(-1, 100, 500, 555);
        this.col2 = Color.get(-1, 100, 500, 532);
        if (this.secondform) {
            this.col1 = Color.get(-1, 0, 2, 46);
            this.col2 = Color.get(-1, 0, 2, 46);
        }
        if (this.health < 200) {
            if (this.tickTime / 3 % 2 == 0) {
                this.col1 = Color.get(-1, 500, 100, 555);
                this.col2 = Color.get(-1, 500, 100, 532);
            }
        }
        else if (this.health < 1000 && this.tickTime / 5 % 4 == 0) {
            this.col1 = Color.get(-1, 500, 100, 555);
            this.col2 = Color.get(-1, 500, 100, 532);
        }
        if (this.hurtTime > 0) {
            this.col1 = Color.get(-1, 555, 555, 555);
            this.col2 = Color.get(-1, 555, 555, 555);
        }
        screen.render(xo + 8 * flip1, yo + 0, xt + yt * 32, this.col1, flip1);
        screen.render(xo + 8 - 8 * flip1, yo + 0, xt + 1 + yt * 32, this.col1, flip1);
        screen.render(xo + 8 * flip2, yo + 8, xt + (yt + 1) * 32, this.col2, flip2);
        screen.render(xo + 8 - 8 * flip2, yo + 8, xt + 1 + (yt + 1) * 32, this.col2, flip2);
        int textcol = Color.get(-1, 40, 40, 40);
        int textcol2 = Color.get(-1, 10, 10, 10);
        String h = String.valueOf(this.health / 20) + "%";
        if (!this.secondform) {
            if (this.health / 20 < 51) {
                textcol = Color.get(-1, 440, 440, 440);
                textcol2 = Color.get(-1, 110, 110, 110);
            }
            if (this.health / 20 < 16) {
                textcol = Color.get(-1, 400, 400, 400);
                textcol2 = Color.get(-1, 100, 100, 100);
            }
            if (this.health / 20 < 1) {
                h = "1%";
            }
        }
        else {
            if (this.health / 50 < 51) {
                textcol = Color.get(-1, 440, 440, 440);
                textcol2 = Color.get(-1, 110, 110, 110);
            }
            if (this.health / 50 < 16) {
                textcol = Color.get(-1, 400, 400, 400);
                textcol2 = Color.get(-1, 100, 100, 100);
            }
            h = String.valueOf(this.health / 50) + "%";
            if (this.health / 50 < 1) {
                h = "1%";
            }
        }
        Font.draw(h, screen, this.x - this.centertext(String.valueOf(this.health / 20) + "%") + 1, this.y - 17, textcol2);
        Font.draw(h, screen, this.x - this.centertext(String.valueOf(this.health / 20) + "%"), this.y - 18, textcol);
    }
    
    public int centertext(final String name) {
        return name.length() * 8 / 2;
    }
    
    @Override
    protected void touchedBy(final Entity entity) {
        if (entity instanceof Player) {
            if (!this.secondform) {
                entity.hurt(this, 1, this.dir);
            }
            else {
                entity.hurt(this, 2, this.dir);
            }
        }
    }
    
    @Override
    protected void die() {
        super.die();
        if (this.level.player != null) {
            if (!this.secondform) {
                final Player player = this.level.player;
                Player.score += 100000;
            }
            else {
                final Player player2 = this.level.player;
                Player.score += 500000;
            }
        }
        AirWizard.beaten = true;
        Sound.bossdeath.play();
        if (!this.secondform) {
            Game.notifications.add("The Dungeon is now open!");
            Game.notifications.add("Air Wizard: Defeated!");
            this.level.player.game.notetick = -500;
        }
        else {
            Game.notifications.add("Air Wizard II: Defeated!");
            this.level.player.game.notetick = -200;
            StartMenu.unlockedskin = true;
            BufferedWriter bufferedWriter = null;
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(this.location) + "/unlocks.fdsave", true));
                bufferedWriter.write("AirSkin");
            }
            catch (IOException ee) {
                ee.printStackTrace();
                try {
                    if (bufferedWriter != null) {
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    }
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
                return;
            }
            finally {
                try {
                    if (bufferedWriter != null) {
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    }
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
