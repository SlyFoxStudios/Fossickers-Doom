package com.fossickersdoom.saveload;

import com.fossickersdoom.Game;
import com.fossickersdoom.item.Item;
import com.fossickersdoom.item.ListItems;
import com.fossickersdoom.level.tile.Tile;
import com.fossickersdoom.screen.ModeMenu;
import com.fossickersdoom.entity.AirWizard;
import com.fossickersdoom.entity.Anvil;
import com.fossickersdoom.entity.Chest;
import com.fossickersdoom.entity.Cow;
import com.fossickersdoom.entity.Creeper;
import com.fossickersdoom.entity.DungeonChest;
import com.fossickersdoom.entity.Enchanter;
import com.fossickersdoom.entity.Entity;
import com.fossickersdoom.entity.Furnace;
import com.fossickersdoom.entity.GoldLantern;
import com.fossickersdoom.entity.Inventory;
import com.fossickersdoom.entity.IronLantern;
import com.fossickersdoom.entity.Knight;
import com.fossickersdoom.entity.Lantern;
import com.fossickersdoom.entity.Loom;
import com.fossickersdoom.entity.Mob;
import com.fossickersdoom.entity.Oven;
import com.fossickersdoom.entity.Pig;
import com.fossickersdoom.entity.Player;
import com.fossickersdoom.entity.Sheep;
import com.fossickersdoom.entity.Skeleton;
import com.fossickersdoom.entity.Slime;
import com.fossickersdoom.entity.Snake;
import com.fossickersdoom.entity.Spawner;
import com.fossickersdoom.entity.Tnt;
import com.fossickersdoom.entity.Workbench;
import com.fossickersdoom.entity.Zombie;
import com.fossickersdoom.entity.bed;
import com.fossickersdoom.item.ResourceItem;
import com.fossickersdoom.screen.LoadingMenu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Load {

    String location = System.getenv("APPDATA") + "/.fossickersdoom";
    File folder;
    String extention;
    List data;
    List extradata;
    public boolean hasloadedbigworldalready;


    public Load(Game game, String worldname) {
        this.folder = new File(this.location);
        this.extention = ".fdsave";
        this.data = new ArrayList();
        this.extradata = new ArrayList();
        this.hasloadedbigworldalready = false;
        this.location = System.getenv("APPDATA") + "/.fossickersdoom/saves/" + worldname + "/";
        this.loadGame("Game", game);
        this.loadWorld("Level");
        this.loadPlayer("Player", game.player);
        this.loadInventory("Inventory", game.player.inventory);
        this.loadEntities("Entities", game.player);
        LoadingMenu.percentage = 0;
        ArrayList ItemNames = new ArrayList();

        for(int i = 0; i < ListItems.items.size(); ++i) {
            if(!ItemNames.contains(ListItems.items.get(i))) {
                ItemNames.add(((Item)ListItems.items.get(i)).getName());
            }
        }

    }

    public void loadFromFile(String filename) {
        this.data.clear();
        this.extradata.clear();
        BufferedReader br = null;
        BufferedReader br2 = null;

        try {
            br = new BufferedReader(new FileReader(filename));

            String e;
            List neww;
            String item;
            Iterator var7;
            while((e = br.readLine()) != null) {
                neww = Arrays.asList(e.split(","));
                var7 = neww.iterator();

                while(var7.hasNext()) {
                    item = (String)var7.next();
                    this.data.add(item);
                }
            }

            if(filename.contains("Level")) {
                br2 = new BufferedReader(new FileReader(filename.substring(0, filename.lastIndexOf("/") + 7) + "data" + this.extention));

                while((e = br2.readLine()) != null) {
                    neww = Arrays.asList(e.split(","));
                    var7 = neww.iterator();

                    while(var7.hasNext()) {
                        item = (String)var7.next();
                        this.extradata.add(item);
                    }
                }
            }
        } catch (IOException var16) {
            var16.printStackTrace();
        } finally {
            try {
                LoadingMenu.percentage += 13;
                if(LoadingMenu.percentage > 100) {
                    LoadingMenu.percentage = 100;
                }

                if(br != null) {
                    br.close();
                }

                if(br2 != null) {
                    br2.close();
                }
            } catch (IOException var15) {
                var15.printStackTrace();
            }

        }

    }

    public void loadGame(String filename, Game game) {
        this.loadFromFile(this.location + filename + this.extention);
        Game.astime = Integer.parseInt((String)this.data.get(1));
        Game.gamespeed = Integer.parseInt((String)this.data.get(2));
        game.nsPerTick = 1.0E9D / (double)(60 * Game.gamespeed);
        Game.ac = Integer.parseInt((String)this.data.get(3));
        Game.tickCount = Integer.parseInt((String)this.data.get(0));
        if(Game.tickCount > -1 && Game.tickCount < 7200) {
            Game.changeTime(0);
        } else if(Game.tickCount > 7199 && Game.tickCount < 32000) {
            Game.changeTime(1);
        } else if(Game.tickCount > 31999 && Game.tickCount < '\u9c40') {
            Game.changeTime(2);
        } else if(Game.tickCount > '\u9c3f' && Game.tickCount < '\uf3c0') {
            Game.changeTime(3);
        }

    }

    public void loadWorld(String filename) {
        for(int l = 0; l < Game.levels.length; ++l) {
            this.loadFromFile(this.location + filename + l + this.extention);
            Game.levels[l].w = Integer.parseInt((String)this.data.get(0));
            Game.levels[l].h = Integer.parseInt((String)this.data.get(1));
            Game.levels[l].depth = Integer.parseInt((String)this.data.get(2));

            for(int x = 0; x < Game.levels[l].w - 1; ++x) {
                for(int y = 0; y < Game.levels[l].h - 1; ++y) {
                    Game.levels[l].setTile(y, x, Tile.tiles[Integer.parseInt((String)this.data.get(x + y * Game.levels[l].w + 3))], Integer.parseInt((String)this.extradata.get(x + y * Game.levels[l].w)));
                }
            }
        }

    }

    public void loadPlayer(String filename, Player player) {
        this.loadFromFile(this.location + filename + this.extention);
        player.x = Integer.parseInt((String)this.data.get(0));
        player.y = Integer.parseInt((String)this.data.get(1));
        Player.spawnx = Integer.parseInt((String)this.data.get(2));
        Player.spawny = Integer.parseInt((String)this.data.get(3));
        player.health = Integer.parseInt((String)this.data.get(4));
        player.maxArmor = Integer.parseInt((String)this.data.get(5));
        Player.score = Integer.parseInt((String)this.data.get(6));
        Game.currentLevel = Integer.parseInt((String)this.data.get(7));
        Game var10001 = player.game;
        player.game.level = Game.levels[Game.currentLevel];
        String diffdata = (String)this.data.get(8);
        boolean diff = true;
        int var11;
        if(diffdata.contains(";")) {
            var11 = Integer.parseInt(diffdata.substring(0, diffdata.indexOf(";")));
        } else {
            var11 = Integer.parseInt(diffdata);
        }

        if(var11 == 1) {
            ModeMenu.survival = true;
            ModeMenu.creative = false;
            ModeMenu.hardcore = false;
            ModeMenu.score = false;
        } else if(var11 == 2) {
            ModeMenu.survival = false;
            ModeMenu.creative = true;
            ModeMenu.hardcore = false;
            ModeMenu.score = false;
        } else if(var11 == 3) {
            ModeMenu.survival = false;
            ModeMenu.creative = false;
            ModeMenu.hardcore = true;
            ModeMenu.score = false;
        } else if(var11 == 4) {
            ModeMenu.survival = false;
            ModeMenu.creative = false;
            ModeMenu.hardcore = false;
            ModeMenu.score = true;
            if(diffdata.length() > 1) {
                player.game.scoreTime = Integer.parseInt(diffdata.substring(diffdata.indexOf(";") + 1));
            } else {
                player.game.scoreTime = 300;
            }
        }

        ModeMenu.diff = var11;
        String colors = ((String)this.data.get(this.data.size() - 1)).replace("[", "").replace("]", "");
        List color = Arrays.asList(colors.split(";"));
        player.r = Integer.parseInt((String)color.get(0));
        player.g = Integer.parseInt((String)color.get(1));
        player.b = Integer.parseInt((String)color.get(2));
        if(this.data.size() > 10 && ((String)this.data.get(this.data.size() - 1)).contains("PotionEffects[")) {
            String potiondata = ((String)this.data.get(this.data.size() - 1)).replace("PotionEffects[", "").replace("]", "");
            List effects = Arrays.asList(potiondata.split(":"));

            for(int i = 0; i < effects.size(); ++i) {
                List effect = Arrays.asList(((String)effects.get(i)).split(";"));
                player.potioneffects.add((String)effect.get(0));
                player.potioneffectstime.add(Integer.valueOf(Integer.parseInt((String)effect.get(1))));
            }
        }

    }

    public void loadInventory(String filename, Inventory inventory) {
        this.loadFromFile(this.location + filename + this.extention);
        inventory.items.clear();

        for(int i = 0; i < this.data.size(); ++i) {
            String item = (String)this.data.get(i);
            if(item.contains(";")) {
                item = item.substring(0, item.lastIndexOf(";"));
            }

            if(ListItems.getItem(item) instanceof ResourceItem) {
                String name = (String)this.data.get(i) + ";0";
                List neww = Arrays.asList(name.split(";"));
                Item newItem = ListItems.getItem((String)neww.get(0));

                for(int ii = 0; ii < Integer.parseInt((String)neww.get(1)); ++ii) {
                    if(newItem instanceof ResourceItem) {
                        ResourceItem resItem = new ResourceItem(((ResourceItem)newItem).resource);
                        inventory.add(resItem);
                    } else {
                        inventory.items.add(newItem);
                    }
                }
            } else {
                inventory.items.add(ListItems.getItem((String)this.data.get(i)));
            }
        }

    }

    public void loadEntities(String filename, Player player) {
        this.loadFromFile(this.location + filename + this.extention);

        int i;
        for(i = 0; i < Game.levels.length; ++i) {
            Game.levels[i].entities.clear();
        }

        for(i = 0; i < this.data.size(); ++i) {
            Entity newEntity = this.getEntity(((String)this.data.get(i)).substring(0, ((String)this.data.get(i)).indexOf("[")), player);
            List info = Arrays.asList(((String)this.data.get(i)).substring(((String)this.data.get(i)).indexOf("[") + 1, ((String)this.data.get(i)).indexOf("]")).split(":"));
            if(newEntity != null) {
                newEntity.x = Integer.parseInt((String)info.get(0));
                newEntity.y = Integer.parseInt((String)info.get(1));
                int currentlevel;
                if(newEntity instanceof Mob) {
                    Mob var16 = (Mob)newEntity;
                    var16.health = Integer.parseInt((String)info.get(2));
                    var16.maxHealth = Integer.parseInt((String)info.get(3));
                    var16.lvl = Integer.parseInt((String)info.get(4));
                    var16.level = Game.levels[Integer.parseInt((String)info.get(5))];
                    currentlevel = Integer.parseInt((String)info.get(5));
                    Game.levels[currentlevel].add(var16);
                } else {
                    int sublist;
                    String ii;
                    List neww;
                    Item newItem;
                    int ii1;
                    ResourceItem resItem;
                    if(newEntity instanceof Chest) {
                        Chest var15 = (Chest)newEntity;

                        for(sublist = 2; sublist < info.size(); ++sublist) {
                            if(ListItems.getItem((String)info.get(sublist)) instanceof ResourceItem) {
                                ii = (String)info.get(sublist) + ";0";
                                neww = Arrays.asList(ii.split(";"));
                                newItem = ListItems.getItem((String)neww.get(0));

                                for(ii1 = 0; ii1 < Integer.parseInt((String)neww.get(1)); ++ii1) {
                                    if(newItem instanceof ResourceItem) {
                                        resItem = new ResourceItem(((ResourceItem)newItem).resource);
                                        var15.inventory.add(resItem);
                                    } else if(!ListItems.getItem((String)info.get(sublist)).getName().equals("")) {
                                        var15.inventory.items.add(ListItems.getItem((String)info.get(sublist)));
                                    }
                                }
                            } else if(!ListItems.getItem((String)info.get(sublist)).getName().equals("")) {
                                var15.inventory.items.add(ListItems.getItem((String)info.get(sublist)));
                            }

                            if(sublist == info.size() - 2 && ((String)info.get(sublist)).contains("tl;")) {
                                var15.time = Integer.parseInt(((String)info.get(sublist)).replace("tl;", ""));
                            }
                        }

                        newEntity.level = Game.levels[Integer.parseInt((String)info.get(info.size() - 1))];
                        currentlevel = Integer.parseInt((String)info.get(info.size() - 1));
                        Game.levels[currentlevel].add(var15);
                    } else if(!(newEntity instanceof DungeonChest)) {
                        if(newEntity instanceof Spawner) {
                            Spawner var14 = (Spawner)newEntity;
                            var14.x = Integer.parseInt((String)info.get(0));
                            var14.y = Integer.parseInt((String)info.get(1));
                            var14.mob = this.getEntity((String)info.get(2), player);
                            var14.lvl = Integer.parseInt((String)info.get(3));
                            currentlevel = Integer.parseInt((String)info.get(info.size() - 1));
                            Game.levels[currentlevel].add(var14);
                        } else {
                            newEntity.level = Game.levels[Integer.parseInt((String)info.get(2))];
                            currentlevel = Integer.parseInt((String)info.get(2));
                            Game.levels[currentlevel].add(newEntity);
                        }
                    } else {
                        DungeonChest s = (DungeonChest)newEntity;
                        ++Game.levels[5].chestcount;

                        for(sublist = 3; sublist < info.size(); ++sublist) {
                            if(sublist < info.size() - 3) {
                                if(ListItems.getItem((String)info.get(sublist)) instanceof ResourceItem) {
                                    ii = (String)info.get(sublist) + ";0";
                                    neww = Arrays.asList(ii.split(";"));
                                    newItem = ListItems.getItem(((String)neww.get(0)).replace(" ", ""));

                                    for(ii1 = 0; ii1 < Integer.parseInt((String)neww.get(1)); ++ii1) {
                                        if(newItem instanceof ResourceItem) {
                                            resItem = new ResourceItem(((ResourceItem)newItem).resource);
                                            s.inventory.add(resItem);
                                        } else if(!ListItems.getItem((String)info.get(sublist)).getName().equals(" ")) {
                                            s.inventory.items.add(newItem);
                                        }
                                    }
                                } else if(!ListItems.getItem((String)info.get(sublist)).getName().equals(" ")) {
                                    s.inventory.items.add(ListItems.getItem((String)info.get(sublist)));
                                }
                            }

                            if(sublist == info.size() - 2 && (((String)info.get(sublist)).contains("true") || ((String)info.get(sublist)).contains("false"))) {
                                s.islocked = Boolean.parseBoolean((String)info.get(sublist));
                            }
                        }

                        ArrayList var17 = new ArrayList();

                        for(int var18 = 0; var18 < s.inventory.items.size(); ++var18) {
                            if(!((Item)s.inventory.items.get(var18)).getName().equals(" ") && !((Item)s.inventory.items.get(var18)).getName().equals("") && !((Item)s.inventory.items.get(var18)).getName().equals("  ")) {
                                var17.add(((Item)s.inventory.items.get(var18)).getName());
                            } else {
                                s.inventory.items.remove(var18);
                            }
                        }

                        var17.add("/x=" + s.x / 16 + "/y=" + s.y / 16);
                        newEntity.level = Game.levels[Integer.parseInt((String)info.get(info.size() - 1))];
                        currentlevel = Integer.parseInt((String)info.get(info.size() - 1));
                        Game.levels[currentlevel].add(s);
                    }
                }
            }
        }

    }

    public Entity getEntity(String string, Player player) {
        return (Entity)(string.equals("Zombie")?new Zombie(0):(string.equals("Slime")?new Slime(0):(string.equals("Cow")?new Cow(0):(string.equals("Sheep")?new Sheep(0):(string.equals("Pig")?new Pig(0):(string.equals("Creeper")?new Creeper(0):(string.equals("Skeleton")?new Skeleton(0):(string.equals("Workbench")?new Workbench():(string.equals("AirWizard")?new AirWizard(false):(string.equals("AirWizardII")?new AirWizard(true):(string.equals("Chest")?new Chest():(string.equals("DeathChest")?new Chest(true):(string.equals("DungeonChest")?new DungeonChest():(string.equals("Spawner")?new Spawner(new Zombie(1), 1):(string.equals("Anvil")?new Anvil():(string.equals("Enchanter")?new Enchanter():(string.equals("Loom")?new Loom():(string.equals("Furnace")?new Furnace():(string.equals("Oven")?new Oven():(string.equals("bed")?new bed():(string.equals("Tnt")?new Tnt():(string.equals("Lantern")?new Lantern():(string.equals("IronLantern")?new IronLantern():(string.equals("GoldLantern")?new GoldLantern():(string.equals("Player")?player:(string.equals("Knight")?new Knight(0):(string.equals("Snake")?new Snake(0):new Entity())))))))))))))))))))))))))));
    }
}