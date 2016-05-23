// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.level.tile;

import com.mojang.ld22.item.Item;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.entity.Mob;
import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.item.resource.Resource;
import java.util.Random;

public class Tile
{
    public static int tickCount;
    protected Random random;
    public static Tile[] tiles;
    public static Tile grass;
    public static Tile rock;
    public static Tile water;
    public static Tile flower;
    public static Tile tree;
    public static Tile dirt;
    public static Tile wool;
    public static Tile redwool;
    public static Tile bluewool;
    public static Tile greenwool;
    public static Tile yellowwool;
    public static Tile blackwool;
    public static Tile sand;
    public static Tile cactus;
    public static Tile hole;
    public static Tile treeSapling;
    public static Tile cactusSapling;
    public static Tile farmland;
    public static Tile wheat;
    public static Tile lava;
    public static Tile stairsDown;
    public static Tile stairsUp;
    public static Tile cloud;
    public static Tile explode;
    public static Tile plank;
    public static Tile plankwall;
    public static Tile stonewall;
    public static Tile wdo;
    public static Tile wdc;
    public static Tile sdo;
    public static Tile sdc;
    public static Tile lavabrick;
    public static Tile sbrick;
    public static Tile o;
    public static Tile ow;
    public static Tile odc;
    public static Tile odo;
    public static Tile hardRock;
    public static Tile lightgrass;
    public static Tile lightsand;
    public static Tile lighttree;
    public static Tile lightcac;
    public static Tile lightwater;
    public static Tile lightdirt;
    public static Tile lightflower;
    public static Tile lightstairsUp;
    public static Tile lightstairsDown;
    public static Tile lightplank;
    public static Tile lightsbrick;
    public static Tile lwdo;
    public static Tile lwdc;
    public static Tile lsdo;
    public static Tile lsdc;
    public static Tile lodo;
    public static Tile lodc;
    public static Tile lighthole;
    public static Tile lightwool;
    public static Tile lightrwool;
    public static Tile lightbwool;
    public static Tile lightgwool;
    public static Tile lightywool;
    public static Tile lightblwool;
    public static Tile lighto;
    public static Tile lightts;
    public static Tile lightcs;
    public static Tile torchgrass;
    public static Tile torchsand;
    public static Tile torchdirt;
    public static Tile torchplank;
    public static Tile torchsbrick;
    public static Tile torchlo;
    public static Tile torchwool;
    public static Tile torchwoolred;
    public static Tile torchwoolblue;
    public static Tile torchwoolgreen;
    public static Tile torchwoolyellow;
    public static Tile torchwoolblack;
    public static Tile ironOre;
    public static Tile lapisOre;
    public static Tile goldOre;
    public static Tile gemOre;
    public static Tile cloudCactus;
    public static Tile infiniteFall;
    public final byte id;
    public boolean connectsToGrass;
    public boolean connectsToSand;
    public boolean connectsToLava;
    public boolean connectsToWater;
    public int light;
    
    static {
        Tile.tickCount = 0;
        Tile.tiles = new Tile[256];
        Tile.grass = new GrassTile(0);
        Tile.rock = new RockTile(1);
        Tile.water = new WaterTile(2);
        Tile.flower = new FlowerTile(3);
        Tile.tree = new TreeTile(4);
        Tile.dirt = new DirtTile(5);
        Tile.wool = new WoolTile(41);
        Tile.redwool = new WoolRedTile(42);
        Tile.bluewool = new WoolBlueTile(43);
        Tile.greenwool = new WoolGreenTile(45);
        Tile.yellowwool = new WoolYellowTile(127);
        Tile.blackwool = new WoolBlackTile(56);
        Tile.sand = new SandTile(6);
        Tile.cactus = new CactusTile(7);
        Tile.hole = new HoleTile(8);
        Tile.treeSapling = new SaplingTile(9, Tile.grass, Tile.tree);
        Tile.cactusSapling = new SaplingTile(10, Tile.sand, Tile.cactus);
        Tile.farmland = new FarmTile(11);
        Tile.wheat = new WheatTile(12);
        Tile.lava = new LavaTile(13);
        Tile.stairsDown = new StairsTile(14, false);
        Tile.stairsUp = new StairsTile(15, true);
        Tile.cloud = new CloudTile(17);
        Tile.explode = new ExplodedTile(30);
        Tile.plank = new PlankTile(31);
        Tile.plankwall = new WoodWallTile(33);
        Tile.stonewall = new StoneWallTile(34);
        Tile.wdo = new WoodDoorOpenTile(35);
        Tile.wdc = new WoodDoorClosedTile(36);
        Tile.sdo = new StoneDoorOpenTile(37);
        Tile.sdc = new StoneDoorClosedTile(38);
        Tile.lavabrick = new LavaBrickTile(39);
        Tile.sbrick = new StoneBrickTile(32, false);
        Tile.o = new ObsidianBrick(120);
        Tile.ow = new ObsidianWallTile(121);
        Tile.odc = new ObsidianDoorClosedTile(122);
        Tile.odo = new ObsidianDoorOpenTile(123);
        Tile.hardRock = new HardRockTile(18);
        Tile.lightgrass = new LightTile(100, Tile.grass, 0);
        Tile.lightsand = new LightTile(101, Tile.sand, 1);
        Tile.lighttree = new LightTile(102, Tile.tree, 2);
        Tile.lightcac = new LightTile(103, Tile.cactus, 3);
        Tile.lightwater = new LightTile(104, Tile.water, 4);
        Tile.lightdirt = new LightTile(105, Tile.dirt, 5);
        Tile.lightflower = new LightTile(107, Tile.flower, 6);
        Tile.lightstairsUp = new LightTile(108, Tile.stairsUp, 7);
        Tile.lightstairsDown = new LightTile(109, Tile.stairsDown, 8);
        Tile.lightplank = new LightTile(110, Tile.plank, 9);
        Tile.lightsbrick = new LightTile(111, Tile.sbrick, 10);
        Tile.lwdo = new LightTile(112, Tile.wdo, 11);
        Tile.lwdc = new LightTile(113, Tile.wdc, 12);
        Tile.lsdo = new LightTile(114, Tile.sdo, 13);
        Tile.lsdc = new LightTile(115, Tile.sdc, 14);
        Tile.lodo = new LightTile(116, Tile.odo, 15);
        Tile.lodc = new LightTile(117, Tile.odc, 16);
        Tile.lighthole = new LightTile(119, Tile.hole, 17);
        Tile.lightwool = new LightTile(57, Tile.wool, 18);
        Tile.lightrwool = new LightTile(58, Tile.redwool, 19);
        Tile.lightbwool = new LightTile(59, Tile.bluewool, 20);
        Tile.lightgwool = new LightTile(60, Tile.greenwool, 21);
        Tile.lightywool = new LightTile(61, Tile.yellowwool, 22);
        Tile.lightblwool = new LightTile(62, Tile.blackwool, 23);
        Tile.lighto = new LightTile(63, Tile.o, 24);
        Tile.lightts = new LightTile(64, Tile.treeSapling, 25);
        Tile.lightcs = new LightTile(65, Tile.cactusSapling, 26);
        Tile.torchgrass = new TorchTile(44, Tile.lightgrass);
        Tile.torchsand = new TorchTile(40, Tile.lightsand);
        Tile.torchdirt = new TorchTile(46, Tile.lightdirt);
        Tile.torchplank = new TorchTile(47, Tile.lightplank);
        Tile.torchsbrick = new TorchTile(48, Tile.lightsbrick);
        Tile.torchlo = new TorchTile(49, Tile.lighto);
        Tile.torchwool = new TorchTile(50, Tile.wool);
        Tile.torchwoolred = new TorchTile(51, Tile.lightrwool);
        Tile.torchwoolblue = new TorchTile(52, Tile.lightbwool);
        Tile.torchwoolgreen = new TorchTile(53, Tile.lightgwool);
        Tile.torchwoolyellow = new TorchTile(54, Tile.lightywool);
        Tile.torchwoolblack = new TorchTile(55, Tile.lightblwool);
        Tile.ironOre = new OreTile(19, Resource.ironOre);
        Tile.lapisOre = new OreTile(24, Resource.lapisOre);
        Tile.goldOre = new OreTile(20, Resource.goldOre);
        Tile.gemOre = new OreTile(21, Resource.gem);
        Tile.cloudCactus = new CloudCactusTile(22);
        Tile.infiniteFall = new InfiniteFallTile(16);
    }
    
    public Tile(final int id) {
        this.random = new Random();
        this.connectsToGrass = false;
        this.connectsToSand = false;
        this.connectsToLava = false;
        this.connectsToWater = false;
        this.light = 1;
        this.id = (byte)id;
        if (Tile.tiles[id] != null) {
            throw new RuntimeException("Duplicate tile ids!");
        }
        Tile.tiles[id] = this;
    }
    
    public String setDataChar() {
        return null;
    }
    
    public void render(final Screen screen, final Level level, final int x, final int y) {
    }
    
    public boolean mayPass(final Level level, final int x, final int y, final Entity e) {
        return true;
    }
    
    public boolean canLight() {
        return false;
    }
    
    public int getLightRadius(final Level level, final int x, final int y) {
        return 0;
    }
    
    public void hurt(final Level level, final int x, final int y, final Mob source, final int dmg, final int attackDir) {
    }
    
    public void bumpedInto(final Level level, final int xt, final int yt, final Entity entity) {
    }
    
    public void tick(final Level level, final int xt, final int yt) {
    }
    
    public void steppedOn(final Level level, final int xt, final int yt, final Entity entity) {
    }
    
    public boolean interact(final Level level, final int xt, final int yt, final Player player, final Item item, final int attackDir) {
        return false;
    }
    
    public boolean use(final Level level, final int xt, final int yt, final Player player, final int attackDir) {
        return false;
    }
    
    public boolean connectsToLiquid() {
        return this.connectsToWater || this.connectsToLava;
    }
}
