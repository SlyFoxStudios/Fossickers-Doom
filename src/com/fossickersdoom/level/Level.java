// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.level;

import com.fossickersdoom.Game;
import com.fossickersdoom.item.FurnitureItem;
import com.fossickersdoom.item.ToolItem;
import com.fossickersdoom.item.resource.Resource;
import com.fossickersdoom.level.levelgen.LevelGen;
import com.fossickersdoom.level.tile.DirtTile;
import com.fossickersdoom.level.tile.Tile;
import com.fossickersdoom.screen.WorldSelectMenu;
import com.fossickersdoom.entity.Knight;
import com.fossickersdoom.entity.Snake;
import com.fossickersdoom.entity.Sheep;
import com.fossickersdoom.entity.Pig;
import com.fossickersdoom.entity.Cow;
import com.fossickersdoom.entity.Creeper;

import java.util.Collections;

import com.fossickersdoom.gfx.Screen;
import com.fossickersdoom.item.ToolType;
import com.fossickersdoom.item.ResourceItem;
import com.fossickersdoom.entity.Lantern;
import com.fossickersdoom.entity.Anvil;
import com.fossickersdoom.entity.Tnt;
import com.fossickersdoom.entity.Inventory;
import com.fossickersdoom.entity.AirWizard;
import com.fossickersdoom.entity.Chest;
import com.fossickersdoom.entity.Spawner;
import com.fossickersdoom.entity.Zombie;
import com.fossickersdoom.entity.Slime;
import com.fossickersdoom.entity.Skeleton;
import com.fossickersdoom.entity.Mob;
import com.fossickersdoom.entity.DungeonChest;

import java.util.ArrayList;
import com.fossickersdoom.entity.Player;
import java.util.Comparator;
import com.fossickersdoom.entity.Entity;
import java.util.List;
import java.util.Random;

public class Level
{
    private Random random;
    public int w;
    public int h;
    public int sux;
    public int suy;
    public short[] tiles;
    public short[] data;
    public List<Entity>[] entitiesInTiles;
    public int grassColor;
    public int dirtColor;
    public int cl;
    public int woolColor;
    public int redwoolColor;
    public int yellowwoolColor;
    public int sandColor;
    public int depth;
    public int monsterDensity;
    public static int depthlvl;
    public int chestcount;
    public static List<String> ls;
    public List<Entity> entities;
    private Comparator<Entity> spriteSorter;
    private List<Entity> rowSprites;
    public Player player;
    
    static {
        Level.ls = new ArrayList<String>();
    }
    
    public static String c(final int i) {
        return new StringBuilder().append(i).toString();
    }
    
    public Level(final int w, final int h, final int level, final Level parentLevel) {
        this.random = new Random();
        this.grassColor = 141;
        this.dirtColor = 322;
        this.cl = 0;
        this.woolColor = 444;
        this.redwoolColor = 500;
        this.yellowwoolColor = 550;
        this.sandColor = 550;
        this.monsterDensity = 8;
        this.chestcount = 0;
        this.entities = new ArrayList<Entity>();
        this.spriteSorter = new Comparator<Entity>() {
            @Override
            public int compare(final Entity e0, final Entity e1) {
                if (e1.y < e0.y) {
                    return 1;
                }
                if (e1.y > e0.y) {
                    return -1;
                }
                return 0;
            }
        };
        this.rowSprites = new ArrayList<Entity>();
        this.depth = level;
        this.cl = level;
        this.w = w;
        this.h = h;
        if (level != 0) {
            if (DirtTile.dirtc == 0) {
                this.dirtColor = 222;
                ++DirtTile.dirtc;
            }
            if (DirtTile.dirtc == 1) {
                this.dirtColor = 222;
            }
        }
        if (level == 0) {
            if (DirtTile.dirtc == 0) {
                this.dirtColor = 322;
            }
            if (DirtTile.dirtc == 0) {
                if (level == 0) {
                    this.dirtColor = 322;
                }
                if (level != 0) {
                    this.dirtColor = 222;
                }
                ++DirtTile.dirtc;
            }
        }
        if (level == 1) {
            this.dirtColor = 444;
        }
        short[][] maps;
        if (level == 0) {
            maps = LevelGen.createAndValidateTopMap(w, h);
        }
        else if (level < 0 && level > -4) {
            maps = LevelGen.createAndValidateUndergroundMap(w, h, -level);
            this.monsterDensity = 4;
        }
        else if (level == -4) {
            maps = LevelGen.createAndValidateDungeon(w, h);
        }
        else {
            maps = LevelGen.createAndValidateSkyMap(w, h);
            this.monsterDensity = 4;
        }
        this.tiles = maps[0];
        this.data = maps[1];
        if (parentLevel != null) {
            for (int y = 0; y < h; ++y) {
                for (int x = 0; x < w; ++x) {
                    if (parentLevel.getTile(x, y) == Tile.stairsDown) {
                        this.setTile(x, y, Tile.stairsUp, 0);
                        if (level == -4) {
                            this.setTile(x - 1, y, Tile.o, 0);
                            this.setTile(x + 1, y, Tile.o, 0);
                            this.setTile(x + 2, y, Tile.odc, 0);
                            this.setTile(x - 2, y, Tile.odc, 0);
                            this.setTile(x, y - 1, Tile.o, 0);
                            this.setTile(x, y + 1, Tile.o, 0);
                            this.setTile(x, y + 2, Tile.odc, 0);
                            this.setTile(x, y - 2, Tile.odc, 0);
                            this.setTile(x - 1, y - 1, Tile.o, 0);
                            this.setTile(x - 1, y + 1, Tile.o, 0);
                            this.setTile(x + 1, y - 1, Tile.o, 0);
                            this.setTile(x + 1, y + 1, Tile.o, 0);
                            this.setTile(x + 3, y, Tile.o, 0);
                            this.setTile(x - 3, y, Tile.o, 0);
                            this.setTile(x + 3, y - 1, Tile.o, 0);
                            this.setTile(x - 3, y - 1, Tile.o, 0);
                            this.setTile(x + 3, y + 1, Tile.o, 0);
                            this.setTile(x - 3, y + 1, Tile.o, 0);
                            this.setTile(x + 4, y, Tile.o, 0);
                            this.setTile(x - 4, y, Tile.o, 0);
                            this.setTile(x + 4, y - 1, Tile.o, 0);
                            this.setTile(x - 4, y - 1, Tile.o, 0);
                            this.setTile(x + 4, y + 1, Tile.o, 0);
                            this.setTile(x - 4, y + 1, Tile.o, 0);
                            this.setTile(x, y + 3, Tile.o, 0);
                            this.setTile(x, y - 3, Tile.o, 0);
                            this.setTile(x + 1, y - 3, Tile.o, 0);
                            this.setTile(x - 1, y - 3, Tile.o, 0);
                            this.setTile(x + 1, y + 3, Tile.o, 0);
                            this.setTile(x - 1, y + 3, Tile.o, 0);
                            this.setTile(x, y + 4, Tile.o, 0);
                            this.setTile(x, y - 4, Tile.o, 0);
                            this.setTile(x + 1, y - 4, Tile.o, 0);
                            this.setTile(x - 1, y - 4, Tile.o, 0);
                            this.setTile(x + 1, y + 4, Tile.o, 0);
                            this.setTile(x - 1, y + 4, Tile.o, 0);
                            this.setTile(x - 2, y - 2, Tile.ow, 0);
                            this.setTile(x - 3, y - 2, Tile.ow, 0);
                            this.setTile(x - 3, y + 2, Tile.ow, 0);
                            this.setTile(x - 2, y + 1, Tile.ow, 0);
                            this.setTile(x + 2, y - 2, Tile.ow, 0);
                            this.setTile(x + 4, y - 2, Tile.ow, 0);
                            this.setTile(x + 4, y + 2, Tile.ow, 0);
                            this.setTile(x - 4, y - 2, Tile.ow, 0);
                            this.setTile(x - 4, y + 2, Tile.ow, 0);
                            this.setTile(x + 1, y - 2, Tile.ow, 0);
                            this.setTile(x - 2, y + 2, Tile.ow, 0);
                            this.setTile(x + 2, y + 3, Tile.ow, 0);
                            this.setTile(x + 2, y + 4, Tile.ow, 0);
                            this.setTile(x - 2, y - 3, Tile.ow, 0);
                            this.setTile(x - 2, y - 4, Tile.ow, 0);
                            this.setTile(x + 2, y - 3, Tile.ow, 0);
                            this.setTile(x + 2, y - 4, Tile.ow, 0);
                            this.setTile(x - 2, y + 3, Tile.ow, 0);
                            this.setTile(x - 2, y + 4, Tile.ow, 0);
                            this.setTile(x + 3, y - 2, Tile.ow, 0);
                            this.setTile(x + 3, y + 2, Tile.ow, 0);
                            this.setTile(x + 2, y + 2, Tile.ow, 0);
                            this.setTile(x - 1, y + 2, Tile.ow, 0);
                            this.setTile(x + 2, y - 1, Tile.ow, 0);
                            this.setTile(x + 2, y + 1, Tile.ow, 0);
                            this.setTile(x + 1, y + 2, Tile.ow, 0);
                            this.setTile(x - 2, y - 1, Tile.ow, 0);
                            this.setTile(x - 1, y - 2, Tile.ow, 0);
                        }
                        if (level == 0) {
                            this.sux = x;
                            this.suy = y;
                            System.out.print("X = " + this.sux + " " + "Y = " + this.suy + " ");
                            this.setTile(x - 1, y, Tile.hardRock, 0);
                            this.setTile(x + 1, y, Tile.hardRock, 0);
                            this.setTile(x, y - 1, Tile.hardRock, 0);
                            this.setTile(x, y + 1, Tile.hardRock, 0);
                            this.setTile(x - 1, y - 1, Tile.hardRock, 0);
                            this.setTile(x - 1, y + 1, Tile.hardRock, 0);
                            this.setTile(x + 1, y - 1, Tile.hardRock, 0);
                            this.setTile(x + 1, y + 1, Tile.hardRock, 0);
                        }
                        if (level != 0 && level != -4) {
                            this.setTile(x - 1, y, Tile.dirt, 0);
                            this.setTile(x + 1, y, Tile.dirt, 0);
                            this.setTile(x, y - 1, Tile.dirt, 0);
                            this.setTile(x, y + 1, Tile.dirt, 0);
                            this.setTile(x - 1, y - 1, Tile.dirt, 0);
                            this.setTile(x - 1, y + 1, Tile.dirt, 0);
                            this.setTile(x + 1, y - 1, Tile.dirt, 0);
                            this.setTile(x + 1, y + 1, Tile.dirt, 0);
                        }
                    }
                }
            }
        }
        this.entitiesInTiles = (List<Entity>[])new ArrayList[w * h];
        for (int i = 0; i < w * h; ++i) {
            this.entitiesInTiles[i] = new ArrayList<Entity>();
        }
        if (level == -4 && !WorldSelectMenu.loadworld) {
            for (int i = 0; i < 10 * (w / 128); ++i) {
                final DungeonChest d = new DungeonChest();
                boolean addedchest = false;
                final int x2 = this.random.nextInt(16 * w) / 16;
                final int y2 = this.random.nextInt(16 * h) / 16;
                if (this.getTile(x2, y2) == Tile.o) {
                    final boolean xaxis = this.random.nextBoolean();
                    if (xaxis) {
                        for (int s = x2; s < w - s; ++s) {
                            if (this.getTile(s, y2) == Tile.ow) {
                                d.x = s * 16 - 24;
                                d.y = y2 * 16 - 24;
                            }
                        }
                    }
                    else if (!xaxis) {
                        for (int s = y2; s < y2 - s; ++s) {
                            if (this.getTile(x2, s) == Tile.ow) {
                                d.x = x2 * 16 - 24;
                                d.y = s * 16 - 24;
                            }
                        }
                    }
                    if (d.x == 0 && d.y == 0) {
                        d.x = x2 * 16 - 8;
                        d.y = y2 * 16 - 8;
                    }
                    if (this.getTile(d.x / 16, d.y / 16) == Tile.ow) {
                        this.setTile(d.x / 16, d.y / 16, Tile.o, 0);
                    }
                    this.add(d);
                    ++this.chestcount;
                    addedchest = true;
                }
            }
        }
        if (level < 0 && !WorldSelectMenu.loadworld) {
            for (int i = 0; i < 18 / -level * (w / 128); ++i) {
                Mob m = new Mob();
                final int r = this.random.nextInt(5);
                if (r == 1) {
                    m = new Skeleton(-level);
                }
                else if (r == 2 || r == 0) {
                    m = new Slime(-level);
                }
                else {
                    m = new Zombie(-level);
                }
                final Spawner sp = new Spawner(m, -level);
                final int x3 = this.random.nextInt(16 * w) / 16;
                final int y3 = this.random.nextInt(16 * h) / 16;
                if (this.getTile(x3, y3) == Tile.dirt) {
                    final boolean xaxis2 = this.random.nextBoolean();
                    if (xaxis2) {
                        for (int s2 = x3; s2 < w - s2; ++s2) {
                            if (this.getTile(s2, y3) == Tile.rock) {
                                sp.x = s2 * 16 - 24;
                                sp.y = y3 * 16 - 24;
                            }
                        }
                    }
                    else if (!xaxis2) {
                        for (int s2 = y3; s2 < y3 - s2; ++s2) {
                            if (this.getTile(x3, s2) == Tile.rock) {
                                sp.x = x3 * 16 - 24;
                                sp.y = s2 * 16 - 24;
                            }
                        }
                    }
                    if (sp.x == 0 && sp.y == 0) {
                        sp.x = x3 * 16 - 8;
                        sp.y = y3 * 16 - 8;
                    }
                    if (this.getTile(sp.x / 16, sp.y / 16) == Tile.rock) {
                        this.setTile(sp.x / 16, sp.y / 16, Tile.dirt, 0);
                    }
                    for (int xx = 0; xx < 5; ++xx) {
                        for (int yy = 0; yy < 5; ++yy) {
                            if (this.noStairs(sp.x / 16 - 2 + xx, sp.y / 16 - 2 + yy)) {
                                this.setTile(sp.x / 16 - 2 + xx, sp.y / 16 - 2 + yy, Tile.sbrick, 0);
                            }
                            if (xx < 1 || yy < 1 || xx > 3 || yy > 3) {
                                if (xx != 2 || yy != 0) {
                                    if (xx != 2 || yy != 4) {
                                        if (xx != 0 || yy != 2) {
                                            if (xx != 4 || yy != 2) {
                                                if (this.noStairs(sp.x / 16 - 2 + xx, sp.y / 16 - 2 + yy)) {
                                                    this.setTile(sp.x / 16 - 2 + xx, sp.y / 16 - 2 + yy, Tile.stonewall, 0);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    this.add(sp);
                    if (this.random.nextInt(2) == 0) {
                        final Chest c = new Chest();
                        this.addtoinv(c.inventory, -level);
                        c.x = sp.x - 16;
                        c.y = sp.y - 16;
                        this.add(c);
                    }
                    if (this.random.nextInt(2) == 0) {
                        final Chest c = new Chest();
                        this.addtoinv(c.inventory, -level);
                        c.x = sp.x + 16;
                        c.y = sp.y + 16;
                        System.out.println("Added Chest: X = " + c.x / 16 + ", Y = " + c.y / 16 + "/" + c);
                        this.add(c);
                    }
                }
            }
        }
        if (level == 1 && !WorldSelectMenu.loadworld) {
            final AirWizard aw = new AirWizard(false);
            aw.x = w * 8;
            aw.y = h * 8;
            this.add(aw);
            System.out.println("Added Air Wizard! X = " + aw.x + ", Y = " + aw.y);
        }
    }
    
    public void addtoinv(final Inventory inventory, final int chance) {
        if (this.random.nextInt(9 / chance) == 0) {
            inventory.add(new FurnitureItem(new Tnt()));
        }
        if (this.random.nextInt(10 / chance) == 0) {
            inventory.add(new FurnitureItem(new Anvil()));
        }
        if (this.random.nextInt(7 / chance) == 0) {
            inventory.add(new FurnitureItem(new Lantern()));
        }
        if (this.random.nextInt(3 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.bread, 2));
        }
        if (this.random.nextInt(4 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.bread, 3));
        }
        if (this.random.nextInt(7 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.larmor, 1));
        }
        if (this.random.nextInt(50 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.goldapple, 1));
        }
        if (this.random.nextInt(3 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.lapisOre, 2));
        }
        if (this.random.nextInt(4 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.glass, 2));
        }
        if (this.random.nextInt(4 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.gunp, 3));
        }
        if (this.random.nextInt(4 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.gunp, 3));
        }
        if (this.random.nextInt(4 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.torch, 4));
        }
        if (this.random.nextInt(14 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.swimpotion, 1));
        }
        if (this.random.nextInt(16 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.hastepotion, 1));
        }
        if (this.random.nextInt(14 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.lightpotion, 1));
        }
        if (this.random.nextInt(14 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.speedpotion, 1));
        }
        if (this.random.nextInt(16 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.iarmor, 1));
        }
        if (this.random.nextInt(5 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.sbrick, 4));
        }
        if (this.random.nextInt(5 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.sbrick, 6));
        }
        if (this.random.nextInt(4 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.string, 3));
        }
        if (this.random.nextInt(4 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.bone, 2));
        }
        if (this.random.nextInt(3 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.bone, 1));
        }
        if (this.random.nextInt(6 / chance) == 0) {
            inventory.add(new ToolItem(ToolType.hatchet, 2));
        }
        if (this.random.nextInt(6 / chance) == 0) {
            inventory.add(new ToolItem(ToolType.pick, 2));
        }
        if (this.random.nextInt(6 / chance) == 0) {
            inventory.add(new ToolItem(ToolType.spade, 2));
        }
        if (this.random.nextInt(7 / chance) == 0) {
            inventory.add(new ToolItem(ToolType.claymore, 1));
        }
        if (this.random.nextInt(5 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.torch, 3));
        }
        if (this.random.nextInt(6 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.torch, 6));
        }
        if (this.random.nextInt(7 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.steak, 3));
        }
        if (this.random.nextInt(9 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.steak, 4));
        }
        if (this.random.nextInt(6 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.torch, 6));
        }
        if (this.random.nextInt(7 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.gem, 3));
        }
        if (this.random.nextInt(7 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.gem, 5));
        }
        if (this.random.nextInt(7 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.gem, 4));
        }
        if (this.random.nextInt(10 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.yellowclothes, 1));
        }
        if (this.random.nextInt(10 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.blackclothes, 1));
        }
        if (this.random.nextInt(12 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.orangeclothes, 1));
        }
        if (this.random.nextInt(12 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.cyanclothes, 1));
        }
        if (this.random.nextInt(12 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.purpleclothes, 1));
        }
        if (this.random.nextInt(4 / chance) == 0) {
            inventory.add(new ResourceItem(Resource.arrow, 5));
        }
        if (inventory.items.size() < 1) {
            inventory.add(new ResourceItem(Resource.potion, 1));
            inventory.add(new ResourceItem(Resource.coal, 3));
            inventory.add(new ResourceItem(Resource.apple, 3));
            inventory.add(new ResourceItem(Resource.dirt, 7));
        }
    }
    
    public void renderBackground(final Screen screen, final int xScroll, final int yScroll) {
        final int xo = xScroll >> 4;
        final int yo = yScroll >> 4;
        final int w = screen.w + 15 >> 4;
        final int h = screen.h + 15 >> 4;
        screen.setOffset(xScroll, yScroll);
        for (int y = yo; y <= h + yo; ++y) {
            for (int x = xo; x <= w + xo; ++x) {
                this.getTile(x, y).render(screen, this, x, y);
            }
        }
        screen.setOffset(0, 0);
    }
    
    public void renderSprites(final Screen screen, final int xScroll, final int yScroll) {
        final int xo = xScroll >> 4;
        final int yo = yScroll >> 4;
        final int w = screen.w + 15 >> 4;
        final int h = screen.h + 15 >> 4;
        screen.setOffset(xScroll, yScroll);
        for (int y = yo; y <= h + yo; ++y) {
            for (int x = xo; x <= w + xo; ++x) {
                if (x >= 0 && y >= 0 && x < this.w) {
                    if (y < this.h) {
                        this.rowSprites.addAll(this.entitiesInTiles[x + y * this.w]);
                    }
                }
            }
            if (this.rowSprites.size() > 0) {
                this.sortAndRender(screen, this.rowSprites);
            }
            this.rowSprites.clear();
        }
        screen.setOffset(0, 0);
    }
    
    public void renderLight(final Screen screen, final int xScroll, final int yScroll) {
        final int xo = xScroll >> 4;
        final int yo = yScroll >> 4;
        final int w = screen.w + 15 >> 4;
        final int h = screen.h + 15 >> 4;
        screen.setOffset(xScroll, yScroll);
        for (int r = 4, y = yo - r; y <= h + yo + r; ++y) {
            for (int x = xo - r; x <= w + xo + r; ++x) {
                if (x >= 0 && y >= 0 && x < this.w) {
                    if (y < this.h) {
                        final List<Entity> entities = this.entitiesInTiles[x + y * this.w];
                        for (int i = 0; i < entities.size(); ++i) {
                            final Entity e = entities.get(i);
                            final int lr = e.getLightRadius();
                            if (lr > 0) {
                                screen.renderLight(e.x - 1, e.y - 4, lr * 8);
                            }
                        }
                        final int lr2 = this.getTile(x, y).getLightRadius(this, x, y);
                        if (lr2 > 0) {
                            screen.renderLight(x * 16 + 8, y * 16 + 8, lr2 * 8);
                        }
                    }
                }
            }
        }
        screen.setOffset(0, 0);
    }
    
    private void sortAndRender(final Screen screen, final List<Entity> list) {
        Collections.sort(list, this.spriteSorter);
        for (int i = 0; i < list.size(); ++i) {
            list.get(i).render(screen);
        }
    }
    
    public Tile getTile(final int x, final int y) {
        if (x < 0 || y < 0 || x >= this.w || y >= this.h) {
            return Tile.rock;
        }
        return Tile.tiles[this.tiles[x + y * this.w]];
    }
    
    public void setTile(final int x, final int y, final Tile t, final int dataVal) {
        if (x < 0 || y < 0 || x >= this.w || y >= this.h) {
            return;
        }
        this.tiles[x + y * this.w] = t.id;
        this.data[x + y * this.w] = (short)dataVal;
    }
    
    public int getData(final int x, final int y) {
        if (x < 0 || y < 0 || x >= this.w || y >= this.h) {
            return 0;
        }
        return this.data[x + y * this.w] & 0xFF;
    }
    
    public void setData(final int x, final int y, final int val) {
        if (x < 0 || y < 0 || x >= this.w || y >= this.h) {
            return;
        }
        this.data[x + y * this.w] = (short)val;
    }
    
    public void add(final Entity entity) {
        if (entity instanceof Player) {
            this.player = (Player)entity;
        }
        entity.removed = false;
        this.entities.add(entity);
        entity.init(this);
        this.insertEntity(entity.x >> 4, entity.y >> 4, entity);
    }
    
    public void adds(final Entity entity, final int xs, final int ys) {
        if (entity instanceof Player) {
            this.player = (Player)entity;
        }
        entity.removed = false;
        this.entities.add(entity);
        entity.init(this);
        this.insertEntity(entity.x >> xs, entity.x >> ys, entity);
    }
    
    public void remove(final Entity e) {
        this.entities.remove(e);
        final int xto = e.x >> 4;
        final int yto = e.y >> 4;
        this.removeEntity(xto, yto, e);
    }
    
    public void insertEntity(final int x, final int y, final Entity e) {
        if (x < 0 || y < 0 || x >= this.w || y >= this.h) {
            return;
        }
        this.entitiesInTiles[x + y * this.w].add(e);
    }
    
    private void removeEntity(final int x, final int y, final Entity e) {
        if (x < 0 || y < 0 || x >= this.w || y >= this.h) {
            return;
        }
        this.entitiesInTiles[x + y * this.w].remove(e);
    }
    
    public void trySpawn(final int count) {
        for (int i = 0; i < count; ++i) {
            int minLevel = 1;
            int maxLevel = 1;
            if (this.depth < 0) {
                maxLevel = -this.depth + 1;
            }
            if (this.depth > 0) {
                maxLevel = (minLevel = 4);
            }
            final int lvl = this.random.nextInt(maxLevel - minLevel + 1) + minLevel;
            final int levels = this.depth;
            final int rnd = this.random.nextInt(100);
            final int tim = Game.Time;
            if (levels == 0 && tim > 2) {
                Mob mob;
                if (rnd <= 40) {
                    mob = new Slime(lvl);
                }
                else if (rnd <= 75) {
                    mob = new Zombie(lvl);
                }
                else if (rnd >= 85) {
                    mob = new Skeleton(lvl);
                }
                else {
                    mob = new Creeper(lvl);
                }
                if (mob.findStartPos(this)) {
                    this.add(mob);
                }
            }
            if (levels == 0) {
                if (tim != 3) {
                    Mob mob;
                    if (rnd <= 22) {
                        mob = new Cow(lvl);
                    }
                    else if (rnd >= 68) {
                        mob = new Pig(lvl);
                    }
                    else {
                        mob = new Sheep(lvl);
                    }
                    if (mob.findStartPosCow(this)) {
                        this.add(mob);
                    }
                }
                if (tim == 3) {
                    Mob mob;
                    if (rnd <= 33) {
                        mob = new Cow(lvl);
                    }
                    else if (rnd >= 68) {
                        mob = new Pig(lvl);
                    }
                    else {
                        mob = new Sheep(lvl);
                    }
                    if (mob.findStartPosCowLight(this)) {
                        this.add(mob);
                    }
                }
            }
            else if (levels != 0 && levels != -4) {
                Mob mob;
                if (rnd <= 40) {
                    mob = new Slime(lvl);
                }
                else if (rnd <= 75) {
                    mob = new Zombie(lvl);
                }
                else if (rnd >= 85) {
                    mob = new Skeleton(lvl);
                }
                else {
                    mob = new Creeper(lvl);
                }
                if (mob.findStartPos(this)) {
                    this.add(mob);
                }
            }
            else if (levels == -4) {
                Mob mob;
                if (rnd <= 40) {
                    mob = new Snake(lvl);
                }
                else if (rnd <= 75) {
                    mob = new Knight(lvl);
                }
                else if (rnd >= 85) {
                    mob = new Snake(lvl);
                }
                else {
                    mob = new Knight(lvl);
                }
                if (mob.findStartPosDungeon(this)) {
                    this.add(mob);
                }
            }
        }
    }
    
    public void removeAllEnimies() {
        for (int i = 0; i < this.entities.size(); ++i) {
            final String name = this.entities.get(i).getClass().getCanonicalName().replace("com.mojang.ld22.entity.", "");
            if (name.equals("Slime") || name.equals("Zombie") || name.equals("Skeleton") || name.equals("Creeper")) {
                this.entities.get(i).remove();
            }
        }
    }
    
    public void tick() {
        this.trySpawn(1);
        Level.depthlvl = this.depth;
        for (int i = 0; i < this.w * this.h / 50; ++i) {
            final int xt = this.random.nextInt(this.w);
            final int yt = this.random.nextInt(this.w);
            this.getTile(xt, yt).tick(this, xt, yt);
        }
        for (int i = 0; i < this.entities.size(); ++i) {
            final Entity e = this.entities.get(i);
            final int xto = e.x >> 4;
            final int yto = e.y >> 4;
            e.tick();
            if (e.removed) {
                this.entities.remove(i--);
                this.removeEntity(xto, yto, e);
            }
            else {
                final int xt2 = e.x >> 4;
                final int yt2 = e.y >> 4;
                if (xto != xt2 || yto != yt2) {
                    this.removeEntity(xto, yto, e);
                    this.insertEntity(xt2, yt2, e);
                }
            }
        }
    }
    
    public List<Entity> getEntities(final int x0, final int y0, final int x1, final int y1) {
        final List<Entity> result = new ArrayList<Entity>();
        final int xt0 = (x0 >> 4) - 1;
        final int yt0 = (y0 >> 4) - 1;
        final int xt2 = (x1 >> 4) + 1;
        for (int yt2 = (y1 >> 4) + 1, y2 = yt0; y2 <= yt2; ++y2) {
            for (int x2 = xt0; x2 <= xt2; ++x2) {
                if (x2 >= 0 && y2 >= 0 && x2 < this.w) {
                    if (y2 < this.h) {
                        final List<Entity> entities = this.entitiesInTiles[x2 + y2 * this.w];
                        for (int i = 0; i < entities.size(); ++i) {
                            final Entity e = entities.get(i);
                            if (e.intersects(x0, y0, x1, y1)) {
                                result.add(e);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    
    public boolean noStairs(final int x, final int y) {
        return this.getTile(x, y) != Tile.stairsDown && this.getTile(x, y) != Tile.stairsDown;
    }
}
