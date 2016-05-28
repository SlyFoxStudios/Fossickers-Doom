// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.item.resource;

import com.fossickersdoom.Game;
import com.fossickersdoom.entity.Player;
import com.fossickersdoom.level.Level;
import com.fossickersdoom.level.tile.Tile;
import com.fossickersdoom.gfx.Color;

public class Resource
{
    public static Resource wood;
    public static Resource stone;
    public static Resource flower;
    public static Resource brose;
    public static Resource salvia;
    public static Resource acorn;
    public static Resource torch;
    public static Resource leather;
    public static Resource dirt;
    public static Resource plank;
    public static Resource plankwall;
    public static Resource wdoor;
    public static Resource sdoor;
    public static Resource stonewall;
    public static Resource obrick;
    public static Resource sbrick;
    public static Resource wool;
    public static Resource redwool;
    public static Resource bluewool;
    public static Resource greenwool;
    public static Resource yellowwool;
    public static Resource blackwool;
    public static Resource sand;
    public static Resource cactusFlower;
    public static Resource seeds;
    public static Resource grassseeds;
    public static Resource bone;
    public static Resource wheat;
    public static Resource bread;
    public static Resource apple;
    public static Resource rawpork;
    public static Resource rawfish;
    public static Resource rawbeef;
    public static Resource cookedpork;
    public static Resource cookedfish;
    public static Resource steak;
    public static Resource goldapple;
    public static Resource larmor;
    public static Resource sarmor;
    public static Resource iarmor;
    public static Resource garmor;
    public static Resource gemarmor;
    public static Resource redclothes;
    public static Resource blueclothes;
    public static Resource greenclothes;
    public static Resource yellowclothes;
    public static Resource blackclothes;
    public static Resource orangeclothes;
    public static Resource purpleclothes;
    public static Resource cyanclothes;
    public static Resource regclothes;
    public static Resource key;
    public static Resource potion;
    public static Resource speedpotion;
    public static Resource lightpotion;
    public static Resource swimpotion;
    public static Resource energypotion;
    public static Resource regenpotion;
    public static Resource timepotion;
    public static Resource lavapotion;
    public static Resource shieldpotion;
    public static Resource hastepotion;
    public static Resource arrow;
    public static Resource string;
    public static Resource coal;
    public static Resource ironOre;
    public static Resource lapisOre;
    public static Resource goldOre;
    public static Resource ironIngot;
    public static Resource goldIngot;
    public static Resource rod;
    public static Resource rose;
    public static Resource gunp;
    public static Resource slime;
    public static Resource glass;
    public static Resource cloth;
    public static Resource book;
    public static Resource bookant;
    public static Resource cloud;
    public static Resource gem;
    public static Resource scale;
    public static Resource shard;
    public static Resource redDye;
    public static Resource yellowDye;
    public static Resource blueDye;
    public static Resource greenDye;
    public static Resource purple;
    public final String name;
    public final int sprite;
    public final int color;
    
    static {
        Resource.wood = new Resource("Wood", 129, Color.get(-1, 200, 531, 430));
        Resource.stone = new Resource("Stone", 130, Color.get(-1, 111, 333, 555));
        Resource.flower = new PlantableResource("Flower", 128, Color.get(-1, 10, 444, 330), Tile.flower, new Tile[] { Tile.grass, Tile.lightgrass });
        Resource.brose = new PlantableResource("Black Rose", 128, Color.get(-1, 111, 000, 500), Tile.brose, new Tile[] { Tile.grass, Tile.lightgrass});
        Resource.salvia = new PlantableResource("Salvia", 128, Color.get(20, 131, 222, 440), Tile.salvia, new Tile[] { Tile.grass, Tile.lightgrass});
        Resource.acorn = new PlantableResource("Acorn", 131, Color.get(-1, 100, 531, 320), Tile.treeSapling, new Tile[] { Tile.grass, Tile.lightgrass });
        Resource.torch = new TorchResource("Torch", 146, Color.get(-1, 500, 520, 320), Tile.lightgrass, new Tile[] { Tile.dirt, Tile.lightdirt, Tile.lightplank, Tile.plank, Tile.lightsbrick, Tile.sbrick, Tile.lightwool, Tile.wool, Tile.lightrwool, Tile.redwool, Tile.lightbwool, Tile.bluewool, Tile.lightgwool, Tile.greenwool, Tile.lightywool, Tile.yellowwool, Tile.lightblwool, Tile.blackwool, Tile.lightgrass, Tile.grass, Tile.lightsand, Tile.sand });
        Resource.leather = new Resource("Leather", 147, Color.get(-1, 100, 211, 322));
        Resource.dirt = new PlantableResource("Dirt", 130, Color.get(-1, 100, 322, 432), Tile.dirt, new Tile[] { Tile.hole, Tile.water, Tile.lava, Tile.lightwater, Tile.lighthole });
        Resource.plank = new PlantableResource("Plank", 129, Color.get(-1, 200, 531, 530), Tile.plank, new Tile[] { Tile.hole, Tile.water, Tile.lightwater, Tile.lighthole });
        Resource.plankwall = new PlantableResource("Plank Wall", 144, Color.get(-1, 200, 531, 530), Tile.plankwall, new Tile[] { Tile.plank, Tile.lightplank });
        Resource.wdoor = new PlantableResource("Wood Door", 145, Color.get(-1, 200, 531, 530), Tile.wdc, new Tile[] { Tile.plank, Tile.lightplank });
        Resource.sdoor = new PlantableResource("Stone Door", 145, Color.get(-1, 111, 333, 444), Tile.sdc, new Tile[] { Tile.sbrick, Tile.lightsbrick });
        Resource.stonewall = new PlantableResource("St.BrickWall", 144, Color.get(-1, 100, 333, 444), Tile.stonewall, new Tile[] { Tile.sbrick, Tile.lightsbrick });
        Resource.obrick = new PlantableResource("Ob.Brick", 129, Color.get(-1, 159, 59, 59), Tile.o, new Tile[] { Tile.hole, Tile.water, Tile.lava });
        Resource.sbrick = new PlantableResource("St.Brick", 129, Color.get(-1, 333, 444, 444), Tile.sbrick, new Tile[] { Tile.hole, Tile.water, Tile.lighthole, Tile.lightwater, Tile.lava });
        Resource.wool = new PlantableResource("Wool", 130, Color.get(-1, 555, 555, 555), Tile.wool, new Tile[] { Tile.hole, Tile.lighthole, Tile.lightwater, Tile.water });
        Resource.redwool = new PlantableResource("Red Wool", 130, Color.get(-1, 100, 300, 500), Tile.redwool, new Tile[] { Tile.hole, Tile.water, Tile.lighthole, Tile.lightwater });
        Resource.bluewool = new PlantableResource("Blue Wool", 130, Color.get(-1, 5, 115, 115), Tile.bluewool, new Tile[] { Tile.hole, Tile.water, Tile.lighthole, Tile.lightwater });
        Resource.greenwool = new PlantableResource("Green Wool", 130, Color.get(-1, 10, 40, 50), Tile.greenwool, new Tile[] { Tile.hole, Tile.water, Tile.lighthole, Tile.lightwater });
        Resource.yellowwool = new PlantableResource("Yellow Wool", 130, Color.get(-1, 110, 440, 552), Tile.yellowwool, new Tile[] { Tile.hole, Tile.water, Tile.lighthole, Tile.lightwater });
        Resource.blackwool = new PlantableResource("Black Wool", 130, Color.get(-1, 0, 111, 111), Tile.blackwool, new Tile[] { Tile.hole, Tile.water, Tile.lighthole, Tile.lightwater });
        Resource.sand = new PlantableResource("Sand", 130, Color.get(-1, 110, 440, 550), Tile.sand, new Tile[] { Tile.dirt, Tile.lightdirt });
        Resource.cactusFlower = new PlantableResource("Cactus", 132, Color.get(-1, 10, 40, 50), Tile.cactusSapling, new Tile[] { Tile.lightsand, Tile.sand });
        Resource.seeds = new PlantableResource("Seeds", 133, Color.get(-1, 10, 40, 50), Tile.wheat, new Tile[] { Tile.farmland });
        Resource.grassseeds = new PlantableResource("Grass Seeds", 133, Color.get(-1, 10, 30, 50), Tile.grass, new Tile[] { Tile.dirt, Tile.lightgrass });
        Resource.bone = new PlantableResource("Bone", 143, Color.get(-1, 222, 555, 555), Tile.tree, new Tile[] { Tile.treeSapling, Tile.lightts });
        Resource.wheat = new Resource("Wheat", 134, Color.get(-1, 110, 330, 550));
        Resource.bread = new FoodResource("Bread", 136, Color.get(-1, 110, 330, 550), 2, 5);
        Resource.apple = new FoodResource("Apple", 137, Color.get(-1, 100, 300, 500), 1, 5);
        Resource.rawpork = new FoodResource("Raw Pork", 148, Color.get(-1, 211, 311, 411), 1, 5);
        Resource.rawfish = new FoodResource("Raw Fish", 152, Color.get(-1, 660, 670, 680), 1, 5);
        Resource.rawbeef = new FoodResource("Raw Beef", 148, Color.get(-1, 200, 300, 400), 1, 5);
        Resource.cookedpork = new FoodResource("Cooked Pork", 148, Color.get(-1, 220, 440, 330), 3, 5);
        Resource.cookedfish = new FoodResource("Cooked Fish", 152, Color.get(-1, 220, 330, 440), 3, 5);
        Resource.steak = new FoodResource("Steak", 148, Color.get(-1, 100, 333, 211), 3, 5);
        Resource.goldapple = new FoodResource("G.Apple", 137, Color.get(-1, 110, 440, 550), 10, 5);
        Resource.larmor = new ArmorResource("L.Armor", 387, Color.get(-1, 100, 211, 322), 3, 9);
        Resource.sarmor = new ArmorResource("S.Armor", 387, Color.get(-1, 10, 20, 30), 4, 9);
        Resource.iarmor = new ArmorResource("I.Armor", 387, Color.get(-1, 100, 322, 544), 5, 9);
        Resource.garmor = new ArmorResource("G.Armor", 387, Color.get(-1, 110, 330, 553), 7, 9);
        Resource.gemarmor = new ArmorResource("Gem Armor", 387, Color.get(-1, 101, 404, 545), 10, 9);
        Resource.redclothes = new ClothesResource("Red Clothes", 390, Color.get(-1, Color.rgb(50, 0, 0), Color.rgb(200, 0, 0), Color.rgb(250, 0, 0)), 200, 0, 0);
        Resource.blueclothes = new ClothesResource("Blue Clothes", 390, Color.get(-1, Color.rgb(0, 0, 50), Color.rgb(0, 0, 200), Color.rgb(0, 0, 250)), 0, 0, 200);
        Resource.greenclothes = new ClothesResource("Green Clothes", 390, Color.get(-1, Color.rgb(0, 50, 0), Color.rgb(0, 200, 0), Color.rgb(0, 250, 0)), 0, 200, 0);
        Resource.yellowclothes = new ClothesResource("Yellow Clothes", 390, Color.get(-1, Color.rgb(50, 50, 0), Color.rgb(200, 200, 0), Color.rgb(250, 250, 0)), 200, 200, 0);
        Resource.blackclothes = new ClothesResource("Black Clothes", 390, Color.get(-1, Color.rgb(0, 0, 0), Color.rgb(50, 50, 50), Color.rgb(100, 100, 100)), 50, 50, 50);
        Resource.orangeclothes = new ClothesResource("Orange Clothes", 390, Color.get(-1, Color.rgb(100, 50, 0), Color.rgb(200, 150, 0), Color.rgb(250, 200, 0)), 150, 100, 0);
        Resource.purpleclothes = new ClothesResource("Purple Clothes", 390, Color.get(-1, Color.rgb(50, 0, 100), Color.rgb(100, 0, 150), Color.rgb(200, 0, 250)), 100, 0, 150);
        Resource.cyanclothes = new ClothesResource("Cyan Clothes", 390, Color.get(-1, Color.rgb(0, 50, 100), Color.rgb(0, 100, 150), Color.rgb(0, 200, 250)), 0, 100, 150);
        Resource.regclothes = new ClothesResource("Reg Clothes", 390, Color.get(-1, Color.rgb(50, 50, 50), Color.rgb(200, 200, 200), Color.rgb(250, 250, 250)), 50, 50, 0);
        Resource.key = new Resource("Key", 154, Color.get(-1, -1, 444, 550));
        Resource.potion = new PotionResource("Potion", 155, Color.get(-1, 333, 310, 5), 0);
        Resource.speedpotion = new PotionResource("Speed P.", 155, Color.get(-1, 333, 310, 10), 1);
        Resource.lightpotion = new PotionResource("Light P.", 155, Color.get(-1, 333, 310, 440), 2);
        Resource.swimpotion = new PotionResource("Swim P.", 155, Color.get(-1, 333, 310, 3), 3);
        Resource.energypotion = new PotionResource("Energy P.", 155, Color.get(-1, 333, 310, 510), 4);
        Resource.regenpotion = new PotionResource("Regen P.", 155, Color.get(-1, 333, 310, 464), 5);
        Resource.timepotion = new PotionResource("Time P.", 155, Color.get(-1, 333, 310, 222), 6);
        Resource.lavapotion = new PotionResource("Lava P.", 155, Color.get(-1, 333, 310, 400), 7);
        Resource.shieldpotion = new PotionResource("Shield P.", 155, Color.get(-1, 333, 310, 115), 8);
        Resource.hastepotion = new PotionResource("Haste P.", 155, Color.get(-1, 333, 310, 303), 9);
        Resource.arrow = new Resource("arrow", 173, Color.get(-1, 111, 222, 430));
        Resource.string = new Resource("string", 153, Color.get(-1, 555, 555, 555));
        Resource.coal = new Resource("Coal", 138, Color.get(-1, 0, 111, 111));
        Resource.ironOre = new Resource("Iron Ore", 138, Color.get(-1, 100, 322, 544));
        Resource.lapisOre = new Resource("Lapis", 138, Color.get(-1, 5, 115, 115));
        Resource.goldOre = new Resource("Gold Ore", 138, Color.get(-1, 110, 440, 553));
        Resource.ironIngot = new Resource("Iron", 139, Color.get(-1, 100, 322, 544));
        Resource.goldIngot = new Resource("Gold", 139, Color.get(-1, 110, 330, 553));
        Resource.rod = new ItemResource("Fish Rod", 166, Color.get(-1, 320, 320, 444));
        Resource.rose = new Resource("Rose", 128, Color.get(-1, 100, 300, 500));
        Resource.gunp = new Resource("GunPowder", 130, Color.get(-1, 111, 222, 333));
        Resource.slime = new Resource("Slime", 138, Color.get(-1, 10, 30, 50));
        Resource.glass = new Resource("glass", 140, Color.get(-1, 555, 555, 555));
        Resource.cloth = new Resource("cloth", 129, Color.get(-1, 25, 252, 141));
        Resource.book = new ItemResource("book", 142, Color.get(-1, 200, 531, 430));
        Resource.bookant = new ItemResource("Antidious", 142, Color.get(-1, 100, 300, 500));
        Resource.cloud = new PlantableResource("cloud", 130, Color.get(-1, 222, 555, 444), Tile.cloud, new Tile[] { Tile.infiniteFall });
        Resource.gem = new Resource("gem", 141, Color.get(-1, 101, 404, 545));
        Resource.scale = new Resource("Scale", 150, Color.get(-1, 10, 30, 20));
        Resource.shard = new Resource("Shard", 151, Color.get(-1, 222, 333, 444));
        //Colors
        Resource.redDye = new Resource("Red Dye", 138, Color.get(-1, 110, 000, 500));
        //Resource.yellowDye = new Resource("Yellow Dye", 139, Color.get(-1, ))
    }
    
    public Resource(final String name, final int sprite, final int color) {
        if (name.length() > 20) {
            throw new RuntimeException("Name cannot be longer than twenty characters!");
        }
        this.name = name;
        this.sprite = sprite;
        this.color = color;
    }
    
    public boolean interactOn(final Tile tile, final Level level, final int xt, final int yt, final Player player, final int attackDir) {
        if (this == Resource.arrow) {
            ++Game.ac;
            return true;
        }
        return false;
    }
}
