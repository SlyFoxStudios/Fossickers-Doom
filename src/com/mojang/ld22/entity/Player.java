package com.mojang.ld22.entity;

import com.mojang.ld22.Game;
import com.mojang.ld22.InputHandler;
import com.mojang.ld22.crafting.Crafting;
import com.mojang.ld22.entity.Arrow;
import com.mojang.ld22.entity.Chest;
import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.entity.Furniture;
import com.mojang.ld22.entity.Inventory;
import com.mojang.ld22.entity.ItemEntity;
import com.mojang.ld22.entity.Mob;
import com.mojang.ld22.entity.bed;
import com.mojang.ld22.entity.particle.TextParticle;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.item.FurnitureItem;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.item.ListItems;
import com.mojang.ld22.item.PowerGloveItem;
import com.mojang.ld22.item.ToolItem;
import com.mojang.ld22.item.ToolType;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.level.tile.Tile;
import com.mojang.ld22.saveload.Save;
import com.mojang.ld22.screen.CraftInvMenu;
import com.mojang.ld22.screen.HomeMenu;
import com.mojang.ld22.screen.InfoMenu;
import com.mojang.ld22.screen.InventoryMenu;
import com.mojang.ld22.screen.LevelTransitionMenu;
import com.mojang.ld22.screen.LoadingMenu;
import com.mojang.ld22.screen.ModeMenu;
import com.mojang.ld22.screen.PauseMenu;
import com.mojang.ld22.screen.PlayerInfoMenu;
import com.mojang.ld22.screen.StartMenu;
import com.mojang.ld22.screen.WorldSelectMenu;
import com.mojang.ld22.sound.Sound;
import java.util.ArrayList;
import java.util.List;

public class Player extends Mob {

    private InputHandler input;
    public int attackTime;
    public int attackDir;
    public boolean energy = false;
    public Game game;
    public Inventory inventory = new Inventory(this);
    public static Inventory Sinventory;
    public Item attackItem;
    public Item activeItem;
    public int stamina;
    public int staminaRecharge;
    public int staminaRechargeDelay;
    public static int score;
    public int maxStamina = 10;
    public int maxArmor = 0;
    public int maxHunger = 10;
    public int hunger;
    public int homeSetX;
    public int homeSetY;
    public static int SHealth = 10;
    public static int SHunger = 10;
    public static boolean hasSetHome;
    public static boolean canSetHome;
    public static boolean canGoHome;
    public static boolean sentFromSetHome;
    public static boolean sentFromHome;
    public static int spawnx = 0;
    public static int spawny = 0;
    private int onStairDelay;
    int tickCounter = 0;
    int hungerChargeDelay;
    int hungerStarveDelay;
    public int hungStamCnt;
    int timesTick;
    public int stepCount;
    boolean alreadyLostHunger;
    boolean repeatHungerCyc = false;
    public int px;
    public int py;
    public int invulnerableTime;
    public static int xx;
    public static int yy;
    public boolean bedSpawn;
    public double speed;
    public double light;
    public boolean infswim;
    public boolean infstamina;
    public boolean regen;
    public boolean slowtime;
    public boolean lavaimmune;
    public boolean shield;
    public boolean haste;
    public List potioneffects;
    public List potioneffectstime;
    public boolean showinfo;
    public boolean showpotioneffects;
    public int r;
    public int g;
    public int b;
    int cooldowninfo;
    int regentick;


    public Player(Game game, InputHandler input) {
        this.px = this.x;
        this.py = this.y;
        this.invulnerableTime = 0;
        this.speed = 1.0D;
        this.light = 1.0D;
        this.infswim = false;
        this.infstamina = false;
        this.regen = false;
        this.slowtime = false;
        this.lavaimmune = false;
        this.shield = false;
        this.haste = false;
        this.potioneffects = new ArrayList();
        this.potioneffectstime = new ArrayList();
        this.showinfo = false;
        this.showpotioneffects = true;
        this.r = 50;
        this.g = 50;
        this.cooldowninfo = 0;
        this.regentick = 0;
        this.game = game;
        this.input = input;
        this.x = 24;
        this.y = 24;
        this.speed = 1.0D;
        this.light = 1.0D;
        this.infswim = false;
        this.infstamina = false;
        this.regen = false;
        this.slowtime = false;
        this.lavaimmune = false;
        this.shield = false;
        this.haste = false;
        game.nsPerTick = 1.6666666666666666E7D;
        this.stamina = this.maxStamina;
        this.hunger = this.maxHunger;
        this.inventory.items.clear();
        if(ModeMenu.creative) {
            for(int i = 0; i < ListItems.items.size(); ++i) {
                this.inventory.add((Item)ListItems.items.get(i));
            }
        } else if(!ModeMenu.creative) {
            this.inventory.add(new PowerGloveItem());
        }

    }

    public void tick() {
        super.tick();
        this.isenemy = false;
        ++this.tickCounter;
        if(this.level.getTile(this.x / 16, this.y / 16) == Tile.infiniteFall && !StartMenu.skinon) {
            this.game.setMenu(new LevelTransitionMenu(-1));
        }

        if(this.cooldowninfo > 0) {
            --this.cooldowninfo;
        }

        int xa;
        if(this.potioneffectstime.size() > 0 && !bed.hasBedSet) {
            for(int onTile = 0; onTile < this.potioneffectstime.size(); ++onTile) {
                xa = ((Integer)this.potioneffectstime.get(onTile)).intValue();
                --xa;
                this.potioneffectstime.set(onTile, Integer.valueOf(xa));
                if(((String)this.potioneffects.get(onTile)).contains("Light") && this.light != 2.5D) {
                    this.light = 2.5D;
                }

                if(((String)this.potioneffects.get(onTile)).contains("Speed") && this.speed != 2.0D) {
                    this.speed = 2.0D;
                }

                if(((String)this.potioneffects.get(onTile)).contains("Swim") && !this.infswim) {
                    this.infswim = true;
                }

                if(((String)this.potioneffects.get(onTile)).contains("Energy") && !this.infstamina) {
                    this.infstamina = true;
                }

                if(((String)this.potioneffects.get(onTile)).contains("Regen") && !this.regen) {
                    this.regen = true;
                }

                if(((String)this.potioneffects.get(onTile)).contains("Time") && !this.slowtime) {
                    this.slowtime = true;
                    this.game.nsPerTick = 3.3333333333333332E7D;
                }

                if(((String)this.potioneffects.get(onTile)).contains("Lava") && !this.lavaimmune) {
                    this.lavaimmune = true;
                }

                if(((String)this.potioneffects.get(onTile)).contains("Shield") && !this.shield) {
                    this.shield = true;
                }

                if(((String)this.potioneffects.get(onTile)).contains("Haste") && !this.haste) {
                    this.haste = true;
                }

                if(xa == 0) {
                    if(((String)this.potioneffects.get(onTile)).contains("Speed")) {
                        this.speed = 1.0D;
                    }

                    if(((String)this.potioneffects.get(onTile)).contains("Light")) {
                        this.light = 1.0D;
                    }

                    if(((String)this.potioneffects.get(onTile)).contains("Swim")) {
                        this.infswim = false;
                    }

                    if(((String)this.potioneffects.get(onTile)).contains("Energy")) {
                        this.infstamina = false;
                    }

                    if(((String)this.potioneffects.get(onTile)).contains("Regen")) {
                        this.regen = false;
                    }

                    if(((String)this.potioneffects.get(onTile)).contains("Time")) {
                        this.slowtime = false;
                        this.game.nsPerTick = 1.6666666666666666E7D;
                    }

                    if(((String)this.potioneffects.get(onTile)).contains("Lava")) {
                        this.lavaimmune = false;
                    }

                    if(((String)this.potioneffects.get(onTile)).contains("Shield")) {
                        this.shield = false;
                    }

                    if(((String)this.potioneffects.get(onTile)).contains("Haste")) {
                        this.haste = false;
                    }

                    this.potioneffectstime.remove(onTile);
                    this.potioneffects.remove(onTile);
                }
            }
        }

        if(this.input.f3.clicked && this.cooldowninfo == 0) {
            if(this.showinfo) {
                this.cooldowninfo = 10;
                this.showinfo = false;
            } else {
                this.cooldowninfo = 10;
                this.showinfo = true;
            }
        }

        if(this.input.f2.clicked && this.cooldowninfo == 0) {
            if(this.showpotioneffects) {
                this.cooldowninfo = 10;
                this.showpotioneffects = false;
            } else {
                this.cooldowninfo = 10;
                this.showpotioneffects = true;
            }
        }

        if(this.invulnerableTime > 0) {
            --this.invulnerableTime;
        }

        Tile var4 = this.level.getTile(this.x >> 4, this.y >> 4);
        if(var4 != Tile.stairsDown && var4 != Tile.stairsUp && var4 != Tile.lightstairsDown && var4 != Tile.lightstairsUp) {
            if(this.onStairDelay > 0) {
                --this.onStairDelay;
            }
        } else {
            if(this.onStairDelay == 0) {
                this.changeLevel(var4 != Tile.stairsUp && var4 != Tile.lightstairsUp?-1:1);
                this.onStairDelay = 10;
                return;
            }

            this.onStairDelay = 10;
        }

        if(ModeMenu.creative && this.stamina <= 10) {
            this.stamina = 10;
        }

        if(ModeMenu.creative && this.hunger < 10) {
            this.hunger = 10;
        }

        if(this.hunger < 0) {
            this.hunger = 0;
        } else {
            if(this.stamina <= 0 && this.staminaRechargeDelay == 0 && this.staminaRecharge == 0) {
                this.staminaRechargeDelay = 40;
                ++this.hungStamCnt;
                if(StartMenu.diff == StartMenu.easy && this.hungStamCnt == 10) {
                    --this.hunger;
                    this.hungStamCnt = 0;
                }

                if(StartMenu.diff == StartMenu.norm && this.hungStamCnt == 7) {
                    --this.hunger;
                    this.hungStamCnt = 0;
                }

                if(StartMenu.diff == StartMenu.hard && this.hungStamCnt == 5) {
                    --this.hunger;
                    this.hungStamCnt = 0;
                }
            }

            if(this.staminaRechargeDelay > 0) {
                --this.staminaRechargeDelay;
            }

            if(this.staminaRechargeDelay == 0) {
                ++this.staminaRecharge;
                if(this.isSwimming() && !this.infswim) {
                    this.staminaRecharge = 0;
                }

                if(!this.slowtime) {
                    while(this.staminaRecharge > 10) {
                        this.staminaRecharge -= 10;
                        if(this.stamina < this.maxStamina) {
                            ++this.stamina;
                        }
                    }
                } else {
                    while(this.staminaRecharge > 5) {
                        this.staminaRecharge -= 5;
                        if(this.stamina < this.maxStamina) {
                            ++this.stamina;
                        }
                    }
                }
            }
        }

        if(this.hungerChargeDelay == 0) {
            this.hungerChargeDelay = 100;
        }

        if(this.hunger == 10 && this.health < 10) {
            if(this.hungerChargeDelay > 0) {
                --this.hungerChargeDelay;
            }

            if(this.hungerChargeDelay == 0) {
                ++this.health;
            }
        }

        if(this.hungerStarveDelay == 0) {
            this.hungerStarveDelay = 120;
        }

        if(StartMenu.diff == StartMenu.norm && this.stepCount >= 10000) {
            --this.hunger;
            this.stepCount = 0;
        }

        if(StartMenu.diff == StartMenu.hard && this.stepCount >= 5000) {
            --this.hunger;
            this.stepCount = 0;
        }

        if(StartMenu.diff == StartMenu.norm && Game.tickCount == 6000) {
            ++this.timesTick;
            if(this.timesTick == this.random.nextInt(5)) {
                --this.hunger;
            }
        }

        if(StartMenu.diff == StartMenu.hard && Game.tickCount == 6000) {
            ++this.timesTick;
            if(this.timesTick == this.random.nextInt(2)) {
                --this.hunger;
            }
        }

        if(StartMenu.diff == StartMenu.easy && this.hunger == 0 && this.health > 5) {
            if(this.hungerStarveDelay > 0) {
                --this.hungerStarveDelay;
            }

            if(this.hungerStarveDelay == 0) {
                this.hurt(this, 1, this.attackDir);
            }
        }

        if(StartMenu.diff == StartMenu.norm && this.hunger == 0 && this.health > 3) {
            if(this.hungerStarveDelay > 0) {
                --this.hungerStarveDelay;
            }

            if(this.hungerStarveDelay == 0) {
                this.hurt(this, 1, this.attackDir);
            }
        }

        if(StartMenu.diff == StartMenu.hard && this.hunger == 0 && this.health > 0) {
            if(this.hungerStarveDelay > 0) {
                --this.hungerStarveDelay;
            }

            if(this.hungerStarveDelay == 0) {
                this.hurt(this, 1, this.attackDir);
            }
        }

        xa = 0;
        int ya = 0;
        if(!Game.isfishing) {
            if(this.input.up.down) {
                --ya;
                ++this.stepCount;
            }

            if(this.input.down.down) {
                ++ya;
                ++this.stepCount;
            }

            if(this.input.left.down) {
                --xa;
                ++this.stepCount;
            }

            if(this.input.right.down) {
                ++xa;
                ++this.stepCount;
            }
        }

        xx = this.x;
        yy = this.y;
        if(this.isSwimming() && this.tickTime % 60 == 0 && !this.infswim) {
            if(this.stamina > 0) {
                --this.stamina;
            } else {
                this.hurt(this, 1, this.dir ^ 1);
            }
        }

        if(this.game.saving && this.game.savecooldown > 0) {
            xa = 0;
            ya = 0;
        }

        if(this.regen) {
            ++this.regentick;
            if(this.regentick > 60) {
                this.regentick = 0;
                if(this.health < 10) {
                    ++this.health;
                }
            }
        }

        if(this.game.savecooldown > 0 && !this.game.saving) {
            --this.game.savecooldown;
        }

        if(this.staminaRechargeDelay % 2 == 0 && this.game.savecooldown == 0 && !this.game.saving) {
            if(!this.slowtime) {
                this.move((int)((double)xa * this.speed), (int)((double)ya * this.speed));
            } else {
                this.move((int)((double)xa * this.speed) * 2, (int)((double)ya * this.speed) * 2);
            }
        }

        if(this.input.attack.clicked && this.stamina != 0) {
            if(!this.infstamina) {
                --this.stamina;
            }

            this.staminaRecharge = 0;
            this.attack();
        }

        if(this.input.menu.clicked && !this.use()) {
            this.game.setMenu(new InventoryMenu(this));
        }

        if(this.input.pause.clicked) {
            this.game.setMenu(new PauseMenu(this));
        }

        if(this.input.craft.clicked && !this.use()) {
            this.game.setMenu(new CraftInvMenu(Crafting.craftRecipes, this));
        }

        if(this.input.sethome.clicked) {
            this.setHome();
        }

        if(this.input.home.clicked) {
            this.goHome();
        }

        if(this.input.i.clicked) {
            this.game.setMenu(new PlayerInfoMenu());
        }

        if(this.input.r.clicked && !this.game.saving) {
            this.game.saving = true;
            new Save(this, WorldSelectMenu.worldname);
            LoadingMenu.percentage = 0;
        }

        boolean var10000 = this.input.g.clicked;
        var10000 = this.input.y.clicked;
        if(ModeMenu.creative && this.input.dayTime.clicked) {
            Game.tickCount = 5900;
        }

        if(this.attackTime > 0) {
            --this.attackTime;
        }

        if(this.slowtime && !bed.hasBedSet) {
            this.game.nsPerTick = 3.3333333333333332E7D;
        }

    }

    private boolean use() {
        byte yo = -2;
        if(this.dir == 0 && this.use(this.x - 8, this.y + 4 + yo, this.x + 8, this.y + 12 + yo)) {
            return true;
        } else if(this.dir == 1 && this.use(this.x - 8, this.y - 12 + yo, this.x + 8, this.y - 4 + yo)) {
            return true;
        } else if(this.dir == 3 && this.use(this.x + 4, this.y - 8 + yo, this.x + 12, this.y + 8 + yo)) {
            return true;
        } else if(this.dir == 2 && this.use(this.x - 12, this.y - 8 + yo, this.x - 4, this.y + 8 + yo)) {
            return true;
        } else {
            int xt = this.x >> 4;
            int yt = this.y + yo >> 4;
            byte r = 12;
            if(this.attackDir == 0) {
                yt = this.y + r + yo >> 4;
            }

            if(this.attackDir == 1) {
                yt = this.y - r + yo >> 4;
            }

            if(this.attackDir == 2) {
                xt = this.x - r >> 4;
            }

            if(this.attackDir == 3) {
                xt = this.x + r >> 4;
            }

            return xt >= 0 && yt >= 0 && xt < this.level.w && yt < this.level.h && this.level.getTile(xt, yt).use(this.level, xt, yt, this, this.attackDir);
        }
    }

    private void attack() {
        this.walkDist += 8;
        this.attackDir = this.dir;
        this.attackItem = this.activeItem;
        boolean done = false;
        if(this.attackItem instanceof ToolItem && this.stamina - 1 >= 0) {
            ToolItem yo = (ToolItem)this.attackItem;
            if(Game.ac > 0 && yo.type == ToolType.bow && this.stamina - 1 >= 0) {
                if(!this.energy) {
                    this.stamina -= 0;
                }

                switch(this.attackDir) {
                    case 0:
                        this.level.add(new Arrow(this, 0, 1, yo.level, done));
                        if(!ModeMenu.creative) {
                            --Game.ac;
                        }
                        break;
                    case 1:
                        this.level.add(new Arrow(this, 0, -1, yo.level, done));
                        if(!ModeMenu.creative) {
                            --Game.ac;
                        }
                        break;
                    case 2:
                        this.level.add(new Arrow(this, -1, 0, yo.level, done));
                        if(!ModeMenu.creative) {
                            --Game.ac;
                        }
                        break;
                    case 3:
                        this.level.add(new Arrow(this, 1, 0, yo.level, done));
                        if(!ModeMenu.creative) {
                            --Game.ac;
                        }
                }

                done = true;
            }
        }

        byte range;
        int xt;
        int yt;
        byte r;
        byte var7;
        if(this.activeItem != null) {
            this.attackTime = 10;
            var7 = -2;
            range = 12;
            if(this.dir == 0 && this.interact(this.x - 8, this.y + 4 + var7, this.x + 8, this.y + range + var7)) {
                done = true;
            }

            if(this.dir == 1 && this.interact(this.x - 8, this.y - range + var7, this.x + 8, this.y - 4 + var7)) {
                done = true;
            }

            if(this.dir == 3 && this.interact(this.x + 4, this.y - 8 + var7, this.x + range, this.y + 8 + var7)) {
                done = true;
            }

            if(this.dir == 2 && this.interact(this.x - range, this.y - 8 + var7, this.x - 4, this.y + 8 + var7)) {
                done = true;
            }

            if(done) {
                return;
            }

            xt = this.x >> 4;
            yt = this.y + var7 >> 4;
            r = 12;
            if(this.attackDir == 0) {
                yt = this.y + r + var7 >> 4;
            }

            if(this.attackDir == 1) {
                yt = this.y - r + var7 >> 4;
            }

            if(this.attackDir == 2) {
                xt = this.x - r >> 4;
            }

            if(this.attackDir == 3) {
                xt = this.x + r >> 4;
            }

            if(xt >= 0 && yt >= 0 && xt < this.level.w && yt < this.level.h) {
                if(this.activeItem.interactOn(this.level.getTile(xt, yt), this.level, xt, yt, this, this.attackDir)) {
                    done = true;
                } else if(this.level.getTile(xt, yt).interact(this.level, xt, yt, this, this.activeItem, this.attackDir)) {
                    done = true;
                }

                if(this.activeItem.isDepleted()) {
                    this.activeItem = null;
                }
            }
        }

        if(!done) {
            if(this.activeItem == null || this.activeItem.canAttack()) {
                this.attackTime = 5;
                var7 = -2;
                range = 20;
                if(this.dir == 0) {
                    this.hurt(this.x - 8, this.y + 4 + var7, this.x + 8, this.y + range + var7);
                }

                if(this.dir == 1) {
                    this.hurt(this.x - 8, this.y - range + var7, this.x + 8, this.y - 4 + var7);
                }

                if(this.dir == 3) {
                    this.hurt(this.x + 4, this.y - 8 + var7, this.x + range, this.y + 8 + var7);
                }

                if(this.dir == 2) {
                    this.hurt(this.x - range, this.y - 8 + var7, this.x - 4, this.y + 8 + var7);
                }

                xt = this.x >> 4;
                yt = this.y + var7 >> 4;
                r = 12;
                if(this.attackDir == 0) {
                    yt = this.y + r + var7 >> 4;
                }

                if(this.attackDir == 1) {
                    yt = this.y - r + var7 >> 4;
                }

                if(this.attackDir == 2) {
                    xt = this.x - r >> 4;
                }

                if(this.attackDir == 3) {
                    xt = this.x + r >> 4;
                }

                if(xt >= 0 && yt >= 0 && xt < this.level.w && yt < this.level.h) {
                    this.level.getTile(xt, yt).hurt(this.level, xt, yt, this, this.random.nextInt(3) + 1, this.attackDir);
                }
            }

        }
    }

    private boolean use(int x0, int y0, int x1, int y1) {
        List entities = this.level.getEntities(x0, y0, x1, y1);

        for(int i = 0; i < entities.size(); ++i) {
            Entity e = (Entity)entities.get(i);
            if(e != this && e.use(this, this.attackDir)) {
                return true;
            }
        }

        return false;
    }

    private boolean interact(int x0, int y0, int x1, int y1) {
        List entities = this.level.getEntities(x0, y0, x1, y1);

        for(int i = 0; i < entities.size(); ++i) {
            Entity e = (Entity)entities.get(i);
            if(e != this && e.interact(this, this.activeItem, this.attackDir)) {
                return true;
            }
        }

        return false;
    }

    private void hurt(int x0, int y0, int x1, int y1) {
        List entities = this.level.getEntities(x0, y0, x1, y1);

        for(int i = 0; i < entities.size(); ++i) {
            Entity e = (Entity)entities.get(i);
            if(e != this) {
                e.hurt((Mob)this, this.getAttackDamage(e), this.attackDir);
            }
        }

    }

    private int getAttackDamage(Entity e) {
        int dmg = this.random.nextInt(3) + 1;
        if(this.attackItem != null) {
            dmg += this.attackItem.getAttackDamageBonus(e);
        }

        return dmg;
    }

    public void render(Screen screen) {
        this.col0 = Color.get(-1, Color.rgb(22, 47, 114), Color.rgb(0, 182, 225), Color.rgb(221, 183, 160));//TODO HERE
        this.col1 = Color.get(-1, 100, Color.rgb(this.r, this.g, this.b), 532);
        int r2 = this.r - 50;
        int b2 = this.b - 50;
        int g2 = this.g - 50;
        if(this.r == 50 && this.g == 50 && this.b == 0) {
            r2 = 50;
            g2 = 50;
            b2 = 0;
        }

        if(this.r == 50 && this.g == 50 && this.b == 50) {
            r2 = 50;
            g2 = 50;
            b2 = 50;
        }

        if(r2 < 0) {
            r2 = 0;
        }

        if(b2 < 0) {
            b2 = 0;
        }

        if(g2 < 0) {
            g2 = 0;
        }

        this.col2 = Color.get(-1, 100, Color.rgb(r2, g2, b2), 421);
        this.col3 = Color.get(-1, 0, Color.rgb(r2, g2, b2), 321);
        this.col4 = Color.get(-1, 100, Color.rgb(this.r, this.g, this.b), 532);
        if(this.isLight()) {
            this.col0 = Color.get(-1, Color.rgb(22, 47, 114), Color.rgb(0, 182, 225), Color.rgb(221, 183, 160));//TODO HERE
            this.col1 = Color.get(-1, 100, Color.rgb(this.r, this.g, this.b), 532);
            this.col2 = Color.get(-1, 100, Color.rgb(this.r, this.g, this.b), 532);
            this.col3 = Color.get(-1, 100, Color.rgb(this.r, this.g, this.b), 532);
            this.col4 = Color.get(-1, 100, Color.rgb(this.r, this.g, this.b), 532);
        } else {
            this.col0 = Color.get(-1, Color.rgb(22, 47, 114), Color.rgb(0, 182, 225), Color.rgb(221, 183, 160));//TODO HERE
            this.col1 = Color.get(-1, 100, Color.rgb(this.r, this.g, this.b), 532);
            this.col2 = Color.get(-1, 100, Color.rgb(r2, g2, b2), 421);
            this.col3 = Color.get(-1, 0, Color.rgb(r2, g2, b2), 321);
            this.col4 = Color.get(-1, 100, Color.rgb(this.r, this.g, this.b), 532);
        }

        int xt = 0;
        int yt = 14;
        if(StartMenu.skinon) {
            xt = 18;
            yt = 20;
        }

        int flip1 = this.walkDist >> 3 & 1;
        int flip2 = this.walkDist >> 3 & 1;
        if(this.dir == 1) {
            xt += 2;
        }

        if(this.dir > 1) {
            flip1 = 0;
            flip2 = this.walkDist >> 4 & 1;
            if(this.dir == 2) {
                flip1 = 1;
            }

            xt += 4 + (this.walkDist >> 3 & 1) * 2;
        }

        int xo = this.x - 8;
        int yo = this.y - 11;
        int col;
        if(this.isSwimming()) {
            yo += 4;
            col = Color.get(-1, -1, 115, 335);
            if(this.level.getTile(this.x / 16, this.y / 16) == Tile.water) {
                col = Color.get(-1, -1, 115, 335);
                if(this.tickTime / 8 % 2 == 0) {
                    col = Color.get(-1, 335, 5, 115);
                }
            } else if(this.level.getTile(this.x / 16, this.y / 16) == Tile.lava) {
                col = Color.get(-1, -1, 500, 300);
                if(this.tickTime / 8 % 2 == 0) {
                    col = Color.get(-1, 300, 400, 500);
                }
            }

            screen.render(xo + 0, yo + 3, 421, col, 0);
            screen.render(xo + 8, yo + 3, 421, col, 1);
        }

        if(this.attackTime > 0 && this.attackDir == 1) {
            screen.render(xo + 0, yo - 4, 422, Color.get(-1, 555, 555, 555), 0);
            screen.render(xo + 8, yo - 4, 422, Color.get(-1, 555, 555, 555), 1);
            if(this.attackItem != null) {
                this.attackItem.renderIcon(screen, xo + 4, yo - 4);
            }
        }

        Furniture furniture;
        if(this.level.dirtColor == 322) {
            if(Game.Time == 0) {
                col = this.col0;
                if(this.hurtTime > 0) {
                    col = Color.get(-1, 555, 555, 555);
                }

                if(this.activeItem instanceof FurnitureItem) {
                    yt += 2;
                }

                screen.render(xo + 8 * flip1, yo + 0, xt + yt * 32, col, flip1);
                screen.render(xo + 8 - 8 * flip1, yo + 0, xt + 1 + yt * 32, col, flip1);
                if(!this.isSwimming()) {
                    screen.render(xo + 8 * flip2, yo + 8, xt + (yt + 1) * 32, col, flip2);
                    screen.render(xo + 8 - 8 * flip2, yo + 8, xt + 1 + (yt + 1) * 32, col, flip2);
                }

                if(this.attackTime > 0 && this.attackDir == 2) {
                    screen.render(xo - 4, yo, 423, Color.get(-1, 555, 555, 555), 1);
                    screen.render(xo - 4, yo + 8, 423, Color.get(-1, 555, 555, 555), 3);
                    if(this.attackItem != null) {
                        this.attackItem.renderIcon(screen, xo - 4, yo + 4);
                    }
                }

                if(this.attackTime > 0 && this.attackDir == 3) {
                    screen.render(xo + 8 + 4, yo, 423, Color.get(-1, 555, 555, 555), 0);
                    screen.render(xo + 8 + 4, yo + 8, 423, Color.get(-1, 555, 555, 555), 2);
                    if(this.attackItem != null) {
                        this.attackItem.renderIcon(screen, xo + 8 + 4, yo + 4);
                    }
                }

                if(this.attackTime > 0 && this.attackDir == 0) {
                    screen.render(xo + 0, yo + 8 + 4, 422, Color.get(-1, 555, 555, 555), 2);
                    screen.render(xo + 8, yo + 8 + 4, 422, Color.get(-1, 555, 555, 555), 3);
                    if(this.attackItem != null) {
                        this.attackItem.renderIcon(screen, xo + 4, yo + 8 + 4);
                    }
                }

                if(this.activeItem instanceof FurnitureItem) {
                    furniture = ((FurnitureItem)this.activeItem).furniture;
                    furniture.x = this.x;
                    furniture.y = yo;
                    furniture.render(screen);
                }
            }

            if(Game.Time == 1) {
                col = this.col1;
                if(this.hurtTime > 0) {
                    col = Color.get(-1, 555, 555, 555);
                }

                if(this.activeItem instanceof FurnitureItem) {
                    yt += 2;
                }

                screen.render(xo + 8 * flip1, yo + 0, xt + yt * 32, col, flip1);
                screen.render(xo + 8 - 8 * flip1, yo + 0, xt + 1 + yt * 32, col, flip1);
                if(!this.isSwimming()) {
                    screen.render(xo + 8 * flip2, yo + 8, xt + (yt + 1) * 32, col, flip2);
                    screen.render(xo + 8 - 8 * flip2, yo + 8, xt + 1 + (yt + 1) * 32, col, flip2);
                }

                if(this.attackTime > 0 && this.attackDir == 2) {
                    screen.render(xo - 4, yo, 423, Color.get(-1, 555, 555, 555), 1);
                    screen.render(xo - 4, yo + 8, 423, Color.get(-1, 555, 555, 555), 3);
                    if(this.attackItem != null) {
                        this.attackItem.renderIcon(screen, xo - 4, yo + 4);
                    }
                }

                if(this.attackTime > 0 && this.attackDir == 3) {
                    screen.render(xo + 8 + 4, yo, 423, Color.get(-1, 555, 555, 555), 0);
                    screen.render(xo + 8 + 4, yo + 8, 423, Color.get(-1, 555, 555, 555), 2);
                    if(this.attackItem != null) {
                        this.attackItem.renderIcon(screen, xo + 8 + 4, yo + 4);
                    }
                }

                if(this.attackTime > 0 && this.attackDir == 0) {
                    screen.render(xo + 0, yo + 8 + 4, 422, Color.get(-1, 555, 555, 555), 2);
                    screen.render(xo + 8, yo + 8 + 4, 422, Color.get(-1, 555, 555, 555), 3);
                    if(this.attackItem != null) {
                        this.attackItem.renderIcon(screen, xo + 4, yo + 8 + 4);
                    }
                }

                if(this.activeItem instanceof FurnitureItem) {
                    furniture = ((FurnitureItem)this.activeItem).furniture;
                    furniture.x = this.x;
                    furniture.y = yo;
                    furniture.render(screen);
                }
            }

            if(Game.Time == 2) {
                col = this.col2;
                if(this.hurtTime > 0) {
                    col = Color.get(-1, 555, 555, 555);
                }

                if(this.activeItem instanceof FurnitureItem) {
                    yt += 2;
                }

                screen.render(xo + 8 * flip1, yo + 0, xt + yt * 32, col, flip1);
                screen.render(xo + 8 - 8 * flip1, yo + 0, xt + 1 + yt * 32, col, flip1);
                if(!this.isSwimming()) {
                    screen.render(xo + 8 * flip2, yo + 8, xt + (yt + 1) * 32, col, flip2);
                    screen.render(xo + 8 - 8 * flip2, yo + 8, xt + 1 + (yt + 1) * 32, col, flip2);
                }

                if(this.attackTime > 0 && this.attackDir == 2) {
                    screen.render(xo - 4, yo, 423, Color.get(-1, 555, 555, 555), 1);
                    screen.render(xo - 4, yo + 8, 423, Color.get(-1, 555, 555, 555), 3);
                    if(this.attackItem != null) {
                        this.attackItem.renderIcon(screen, xo - 4, yo + 4);
                    }
                }

                if(this.attackTime > 0 && this.attackDir == 3) {
                    screen.render(xo + 8 + 4, yo, 423, Color.get(-1, 555, 555, 555), 0);
                    screen.render(xo + 8 + 4, yo + 8, 423, Color.get(-1, 555, 555, 555), 2);
                    if(this.attackItem != null) {
                        this.attackItem.renderIcon(screen, xo + 8 + 4, yo + 4);
                    }
                }

                if(this.attackTime > 0 && this.attackDir == 0) {
                    screen.render(xo + 0, yo + 8 + 4, 422, Color.get(-1, 555, 555, 555), 2);
                    screen.render(xo + 8, yo + 8 + 4, 422, Color.get(-1, 555, 555, 555), 3);
                    if(this.attackItem != null) {
                        this.attackItem.renderIcon(screen, xo + 4, yo + 8 + 4);
                    }
                }

                if(this.activeItem instanceof FurnitureItem) {
                    furniture = ((FurnitureItem)this.activeItem).furniture;
                    furniture.x = this.x;
                    furniture.y = yo;
                    furniture.render(screen);
                }
            }

            if(Game.Time == 3) {
                col = this.col3;
                if(this.hurtTime > 0) {
                    col = Color.get(-1, 555, 555, 555);
                }

                if(this.activeItem instanceof FurnitureItem) {
                    yt += 2;
                }

                screen.render(xo + 8 * flip1, yo + 0, xt + yt * 32, col, flip1);
                screen.render(xo + 8 - 8 * flip1, yo + 0, xt + 1 + yt * 32, col, flip1);
                if(!this.isSwimming()) {
                    screen.render(xo + 8 * flip2, yo + 8, xt + (yt + 1) * 32, col, flip2);
                    screen.render(xo + 8 - 8 * flip2, yo + 8, xt + 1 + (yt + 1) * 32, col, flip2);
                }

                if(this.attackTime > 0 && this.attackDir == 2) {
                    screen.render(xo - 4, yo, 423, Color.get(-1, 555, 555, 555), 1);
                    screen.render(xo - 4, yo + 8, 423, Color.get(-1, 555, 555, 555), 3);
                    if(this.attackItem != null) {
                        this.attackItem.renderIcon(screen, xo - 4, yo + 4);
                    }
                }

                if(this.attackTime > 0 && this.attackDir == 3) {
                    screen.render(xo + 8 + 4, yo, 423, Color.get(-1, 555, 555, 555), 0);
                    screen.render(xo + 8 + 4, yo + 8, 423, Color.get(-1, 555, 555, 555), 2);
                    if(this.attackItem != null) {
                        this.attackItem.renderIcon(screen, xo + 8 + 4, yo + 4);
                    }
                }

                if(this.attackTime > 0 && this.attackDir == 0) {
                    screen.render(xo + 0, yo + 8 + 4, 422, Color.get(-1, 555, 555, 555), 2);
                    screen.render(xo + 8, yo + 8 + 4, 422, Color.get(-1, 555, 555, 555), 3);
                    if(this.attackItem != null) {
                        this.attackItem.renderIcon(screen, xo + 4, yo + 8 + 4);
                    }
                }

                if(this.activeItem instanceof FurnitureItem) {
                    furniture = ((FurnitureItem)this.activeItem).furniture;
                    furniture.x = this.x;
                    furniture.y = yo;
                    furniture.render(screen);
                }
            }
        }

        if(this.level.dirtColor != 322) {
            col = this.col4;
            if(this.hurtTime > 0) {
                col = Color.get(-1, 555, 555, 555);
            }

            if(this.activeItem instanceof FurnitureItem) {
                yt += 2;
            }

            screen.render(xo + 8 * flip1, yo + 0, xt + yt * 32, col, flip1);
            screen.render(xo + 8 - 8 * flip1, yo + 0, xt + 1 + yt * 32, col, flip1);
            if(!this.isSwimming()) {
                screen.render(xo + 8 * flip2, yo + 8, xt + (yt + 1) * 32, col, flip2);
                screen.render(xo + 8 - 8 * flip2, yo + 8, xt + 1 + (yt + 1) * 32, col, flip2);
            }

            if(this.attackTime > 0 && this.attackDir == 2) {
                screen.render(xo - 4, yo, 423, Color.get(-1, 555, 555, 555), 1);
                screen.render(xo - 4, yo + 8, 423, Color.get(-1, 555, 555, 555), 3);
                if(this.attackItem != null) {
                    this.attackItem.renderIcon(screen, xo - 4, yo + 4);
                }
            }

            if(this.attackTime > 0 && this.attackDir == 3) {
                screen.render(xo + 8 + 4, yo, 423, Color.get(-1, 555, 555, 555), 0);
                screen.render(xo + 8 + 4, yo + 8, 423, Color.get(-1, 555, 555, 555), 2);
                if(this.attackItem != null) {
                    this.attackItem.renderIcon(screen, xo + 8 + 4, yo + 4);
                }
            }

            if(this.attackTime > 0 && this.attackDir == 0) {
                screen.render(xo + 0, yo + 8 + 4, 422, Color.get(-1, 555, 555, 555), 2);
                screen.render(xo + 8, yo + 8 + 4, 422, Color.get(-1, 555, 555, 555), 3);
                if(this.attackItem != null) {
                    this.attackItem.renderIcon(screen, xo + 4, yo + 8 + 4);
                }
            }

            if(this.activeItem instanceof FurnitureItem) {
                furniture = ((FurnitureItem)this.activeItem).furniture;
                furniture.x = this.x;
                furniture.y = yo;
                furniture.render(screen);
            }
        }

    }

    public void touchItem(ItemEntity itemEntity) {
        itemEntity.take(this);
        if(itemEntity.item.getName() == "arrow") {
            ++Game.ac;
        } else {
            this.inventory.add(itemEntity.item);
        }

    }

    public boolean canSwim() {
        return true;
    }

    public boolean canWool() {
        return true;
    }

    public boolean canLight() {
        return true;
    }

    public boolean findStartPoss(Level level) {
        int xxs = this.x;
        int yys = this.y;
        if(level.getTile(this.x, this.y) != Tile.dirt) {
            this.x = xxs;
            this.y = yys;
            return true;
        } else {
            return false;
        }
    }

    public boolean findStartPos(Level level) {
        int x;
        int y;
        do {
            x = this.random.nextInt(level.w);
            y = this.random.nextInt(level.h);
        } while(level.getTile(x, y) != Tile.grass);

        this.x = x * 16 + 8;
        this.y = y * 16 + 8;
        spawnx = y;
        spawny = x;
        return true;
    }

    public void setHome() {
        if(Game.currentLevel == 3) {
            this.homeSetX = this.x;
            this.homeSetY = this.y;
            canSetHome = true;
            sentFromSetHome = true;
            hasSetHome = true;
            this.game.setMenu(new InfoMenu());
        } else {
            canSetHome = false;
            sentFromSetHome = true;
            this.game.setMenu(new InfoMenu());
        }

    }

    public void goHome() {
        if(Game.currentLevel == 3) {
            canGoHome = true;
            sentFromHome = true;
            if(hasSetHome) {
                this.x = this.homeSetX;
                this.y = this.homeSetY;
                if(ModeMenu.hardcore) {
                    this.hurt(this, 2, this.attackDir);
                }

                this.stamina = 0;
                sentFromHome = true;
                this.game.setMenu(new HomeMenu());
            } else {
                this.game.setMenu(new HomeMenu());
            }
        } else {
            canGoHome = false;
            hasSetHome = false;
            sentFromHome = true;
            this.game.setMenu(new HomeMenu());
        }

    }

    public boolean respawn(Level level) {
        while(true) {
            int x = spawnx;
            int y = spawny;
            if(level.getTile(x, y) == Tile.grass && !this.bedSpawn) {
                this.x = spawny * 16 + 8;
                this.y = spawnx * 16 + 8;
                return true;
            }

            if(this.bedSpawn) {
                this.x = spawny * 16 + 8;
                this.y = spawnx * 16 + 8;
                return true;
            }

            this.findStartPos(level);
        }
    }

    public boolean payStamina(int cost) {
        if(this.infstamina) {
            return true;
        } else if(cost > this.stamina) {
            return false;
        } else {
            if(cost < 0) {
                cost = 0;
            }

            this.stamina -= cost;
            return true;
        }
    }

    public void changeLevel(int dir) {
        this.game.scheduleLevelChange(dir);
    }

    public int getLightRadius() {
        int r = (int)(3.0D * this.light);
        if(ModeMenu.creative) {
            r = (int)(12.0D * this.light);
        }

        if(Game.currentLevel == 5 && !ModeMenu.creative) {
            r = (int)(5.0D * this.light);
        }

        if(this.activeItem != null && this.activeItem instanceof FurnitureItem) {
            int rr = ((FurnitureItem)this.activeItem).furniture.getLightRadius();
            if(rr > r) {
                r = rr;
            }
        }

        return r;
    }

    protected void die() {
        super.die();
        int lostscore = score / 3;
        score -= lostscore;
        Chest dc = new Chest(true);
        dc.x = this.x;
        dc.y = this.y;
        PowerGloveItem pg = new PowerGloveItem();
        dc.inventory = this.inventory;
        if(this.activeItem != null) {
            dc.inventory.add(this.activeItem);
        }

        for(int i = 0; i < this.inventory.items.size(); ++i) {
            if(((Item)this.inventory.items.get(i)).matches(pg)) {
                dc.inventory.items.remove((Item)this.inventory.items.get(i));
            }
        }

        Game.levels[Game.currentLevel].add(dc);
        Sound.playerDeath.play();
    }

    protected void touchedBy(Entity entity) {
        if(!(entity instanceof Player)) {
            entity.touchedBy(this);
        }

    }

    protected void doHurt(int damage, int attackDir) {
        if(!ModeMenu.creative) {
            if(this.hurtTime > 0 || this.invulnerableTime > 0) {
                return;
            }

            Sound.playerHurt.play();
            int dmgleft;
            if(this.shield) {
                if(this.maxArmor <= 0) {
                    if(this.random.nextInt(2) == 0) {
                        damage = 0;
                    }

                    this.level.add(new TextParticle("" + damage, this.x, this.y, Color.get(-1, 504, 504, 504)));
                    this.health -= damage;
                }

                if(this.maxArmor > 0) {
                    if(this.random.nextInt(2) == 0) {
                        damage = 0;
                    }

                    this.level.add(new TextParticle("" + damage, this.x, this.y, Color.get(-1, 333, 333, 333)));
                    if(damage > this.maxArmor) {
                        dmgleft = damage - this.maxArmor;
                        this.health -= dmgleft;
                        this.maxArmor = 0;
                    } else {
                        this.maxArmor -= damage;
                    }
                }
            } else {
                if(this.maxArmor <= 0) {
                    this.level.add(new TextParticle("" + damage, this.x, this.y, Color.get(-1, 504, 504, 504)));
                    this.health -= damage;
                }

                if(this.maxArmor > 0) {
                    this.level.add(new TextParticle("" + damage, this.x, this.y, Color.get(-1, 333, 333, 333)));
                    if(damage > this.maxArmor) {
                        dmgleft = damage - this.maxArmor;
                        this.health -= dmgleft;
                        this.maxArmor = 0;
                    } else {
                        this.maxArmor -= damage;
                    }
                }
            }

            if(attackDir == 0) {
                this.yKnockback = 6;
            }

            if(attackDir == 1) {
                this.yKnockback = -6;
            }

            if(attackDir == 2) {
                this.xKnockback = -6;
            }

            if(attackDir == 3) {
                this.xKnockback = 6;
            }

            this.hurtTime = 10;
            this.invulnerableTime = 30;
        }

    }

    public void gameWon() {
        this.level.player.invulnerableTime = 300;
        this.game.won();
    }
}