// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.entity;

import com.mojang.ld22.entity.particle.TextParticle;
import com.mojang.ld22.sound.Sound;
import com.mojang.ld22.item.ToolType;
import com.mojang.ld22.item.ToolItem;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.entity.particle.FireParticle;
import com.mojang.ld22.gfx.Color;
import java.util.Random;

public class Spawner extends Furniture
{
    public Entity mob;
    Random rnd;
    int randx;
    int randy;
    int r;
    int health;
    public int lvl;
    int tick;
    boolean spawn;
    int dmg;
    
    public Spawner(final Entity m, final int level) {
        super(String.valueOf(m.getClass().getCanonicalName().replace("com.mojang.ld22.entity.", "")) + " Spawner");
        this.rnd = new Random();
        this.randx = 2;
        this.randy = 2;
        this.r = 90;
        this.health = 100;
        this.lvl = 1;
        this.tick = 0;
        this.spawn = false;
        this.dmg = 0;
        this.mob = m;
        this.lvl = level;
        this.col0 = m.col1;
        this.col1 = m.col2;
        this.col2 = m.col3;
        this.col3 = m.col4;
        this.col = this.col2;
        this.sprite = 10;
        this.xr = 7;
        this.yr = 2;
    }
    
    @Override
    public void tick() {
        super.tick();
        int xd = this.level.player.x - this.x;
        int yd = this.level.player.y - this.y;
        if (xd * xd + yd * yd < this.r * this.r) {
            this.col0 = this.mob.col1;
            this.col1 = this.mob.col1;
            this.col2 = this.mob.col1;
            this.col3 = this.mob.col1;
            ++this.tick;
        }
        else {
            this.col0 = this.mob.col4;
            this.col1 = this.mob.col4;
            this.col2 = this.mob.col4;
            this.col3 = this.mob.col4;
        }
        if (this.tick > 180) {
            this.tick = 0;
            this.spawn = true;
        }
        if (this.spawn && this.mob != null) {
            xd = this.level.player.x - this.x;
            yd = this.level.player.y - this.y;
            if (xd * xd + yd * yd > this.r * this.r) {
                return;
            }
            Entity newmob = this.getEntity(this.mob.getClass().getCanonicalName().replace("com.mojang.ld22.entity.", ""), this.lvl);
            if (newmob instanceof Mob) {
                newmob = newmob;
                this.getEntity(newmob.getClass().getCanonicalName().replace("com.mojang.ld22.entity.", ""), this.lvl);
                if (this.col1 == Color.get(-1, 0, 4, 46)) {
                    newmob = this.getEntity(String.valueOf(this.mob.getClass().getCanonicalName().replace("com.mojang.ld22.entity.", "")) + "II", this.lvl);
                }
            }
            if (this.level.getTile((this.x - 16 + this.rnd.nextInt(32)) / 16, (this.y - 16 + this.rnd.nextInt(32)) / 16).mayPass(this.level, (this.x - 16 + this.rnd.nextInt(32)) / 16, (this.y - 16 + this.rnd.nextInt(32)) / 16, this) && this.level.getTile((this.x - 16 + this.rnd.nextInt(32)) / 16, (this.y - 16 + this.rnd.nextInt(32)) / 16).getLightRadius(this.level, (this.x - 16 + this.rnd.nextInt(32)) / 16, (this.y - 16 + this.rnd.nextInt(32)) / 16) == 0) {
                newmob.x = this.x - 16 + this.rnd.nextInt(32);
                newmob.y = this.y - 16 + this.rnd.nextInt(32);
                newmob.hasspawned = true;
                this.level.add(newmob);
                for (int i = 0; i < 6; ++i) {
                    this.randx = this.rnd.nextInt(16);
                    this.randy = this.rnd.nextInt(12);
                    this.level.add(new FireParticle(this.x - 4 + this.randx, this.y - 4 + this.randy));
                }
            }
            this.spawn = false;
        }
    }
    
    @Override
    public boolean interact(final Player player, final Item item, final int attackDir) {
        if (item instanceof ToolItem) {
            final ToolItem i = (ToolItem)item;
            if (i.type == ToolType.pickaxe) {
                Sound.monsterHurt.play();
                if (player.haste) {
                    this.dmg = i.level + 1 + this.random.nextInt(5);
                }
                else {
                    this.dmg = i.level + 1 + this.random.nextInt(3);
                }
                this.health -= this.dmg;
                this.level.add(new TextParticle(new StringBuilder().append(this.dmg).toString(), this.x, this.y, Color.get(-1, 200, 300, 400)));
                if (this.health < 1) {
                    this.level.remove(this);
                    Sound.playerDeath.play();
                    Player.score += 500;
                }
                return true;
            }
            if (i.type == ToolType.pick) {
                Sound.monsterHurt.play();
                if (player.haste) {
                    this.dmg = i.level + 1 + this.random.nextInt(4);
                }
                else {
                    this.dmg = i.level + 1 + this.random.nextInt(2);
                }
                this.health -= this.dmg;
                this.level.add(new TextParticle(new StringBuilder().append(this.dmg).toString(), this.x, this.y, Color.get(-1, 200, 300, 400)));
                if (this.health < 1) {
                    this.level.remove(this);
                    Sound.playerDeath.play();
                    Player.score += 500;
                }
                return true;
            }
        }
        return false;
    }
    
    @Override
    protected void touchedBy(final Entity entity) {
    }
    
    @Override
    public boolean use(final Player player, final int attackDir) {
        return false;
    }
    
    public Entity getEntity(final String string, final int lvl) {
        if (string.equals("Zombie")) {
            return new Zombie(lvl);
        }
        if (string.equals("Slime")) {
            return new Slime(lvl);
        }
        if (string.equals("Cow")) {
            return new Cow(lvl);
        }
        if (string.equals("Sheep")) {
            return new Sheep(lvl);
        }
        if (string.equals("Pig")) {
            return new Pig(lvl);
        }
        if (string.equals("Creeper")) {
            return new Creeper(lvl);
        }
        if (string.equals("Skeleton")) {
            return new Skeleton(lvl);
        }
        if (string.equals("Workbench")) {
            return new Workbench();
        }
        if (string.equals("AirWizard")) {
            return new AirWizard(false);
        }
        if (string.equals("AirWizardII")) {
            return new AirWizard(true);
        }
        if (string.equals("Chest")) {
            return new Chest();
        }
        if (string.equals("DeathChest")) {
            return new Chest(true);
        }
        if (string.equals("DungeonChest")) {
            return new DungeonChest();
        }
        if (string.equals("Anvil")) {
            return new Anvil();
        }
        if (string.equals("Enchanter")) {
            return new Enchanter();
        }
        if (string.equals("Loom")) {
            return new Loom();
        }
        if (string.equals("Furnace")) {
            return new Furnace();
        }
        if (string.equals("Spawner")) {
            return new Spawner(new Zombie(lvl), lvl);
        }
        if (string.equals("Oven")) {
            return new Oven();
        }
        if (string.equals("bed")) {
            return new bed();
        }
        if (string.equals("Tnt")) {
            return new Tnt();
        }
        if (string.equals("Lantern")) {
            return new Lantern();
        }
        if (string.equals("IronLantern")) {
            return new IronLantern();
        }
        if (string.equals("GoldLantern")) {
            return new GoldLantern();
        }
        if (string.equals("Knight")) {
            return new Knight(lvl);
        }
        if (string.equals("Snake")) {
            return new Snake(lvl);
        }
        return new Zombie(lvl);
    }
}
