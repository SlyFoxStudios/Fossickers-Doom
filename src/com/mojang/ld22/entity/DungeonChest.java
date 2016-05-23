// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.entity;

import com.mojang.ld22.item.ToolItem;
import com.mojang.ld22.item.ToolType;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.Game;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.item.resource.Resource;
import com.mojang.ld22.entity.particle.TextParticle;
import com.mojang.ld22.entity.particle.SmashParticle;
import com.mojang.ld22.item.ResourceItem;
import com.mojang.ld22.screen.ModeMenu;
import com.mojang.ld22.screen.Menu;
import com.mojang.ld22.screen.ContainerMenu;
import com.mojang.ld22.gfx.Color;
import java.util.Random;

public class DungeonChest extends Furniture
{
    public Inventory inventory;
    public Random random;
    public boolean islocked;
    
    public DungeonChest() {
        super("Dungeon Chest");
        this.inventory = new Inventory();
        this.random = new Random();
        this.islocked = true;
        this.getInventory(this.inventory);
        if (this.canLight()) {
            if (this.islocked) {
                this.col0 = Color.get(-1, 222, 333, 555);
                this.col1 = Color.get(-1, 222, 333, 555);
                this.col2 = Color.get(-1, 222, 333, 555);
                this.col3 = Color.get(-1, 222, 333, 555);
            }
            else {
                this.col0 = Color.get(-1, 111, 115, 225);
                this.col1 = Color.get(-1, 222, 115, 225);
                this.col2 = Color.get(-1, 111, 115, 225);
                this.col3 = Color.get(-1, 0, 115, 225);
            }
        }
        else if (this.islocked) {
            this.col0 = Color.get(-1, 111, 222, 444);
            this.col1 = Color.get(-1, 222, 333, 555);
            this.col2 = Color.get(-1, 111, 222, 444);
            this.col3 = Color.get(-1, 0, 111, 333);
        }
        else {
            this.col0 = Color.get(-1, 2, 115, 225);
            this.col1 = Color.get(-1, 2, 115, 225);
            this.col2 = Color.get(-1, 2, 115, 225);
            this.col3 = Color.get(-1, 2, 115, 225);
        }
        this.col = Color.get(-1, 222, 333, 555);
        this.sprite = 1;
    }
    
    @Override
    public boolean use(final Player player, final int attackDir) {
        if (!this.islocked) {
            player.game.setMenu(new ContainerMenu(player, "Dungeon Chest", this.inventory));
            return true;
        }
        if (player.activeItem != null) {
            if (player.activeItem.getName().equals("Key")) {
                if (!ModeMenu.creative) {
                    final ResourceItem resourceItem;
                    final ResourceItem ri = resourceItem = (ResourceItem)player.activeItem;
                    --resourceItem.count;
                }
                this.islocked = false;
                player.game.setMenu(new ContainerMenu(player, "Dungeon Chest", this.inventory));
                this.col = Color.get(-1, 2, 115, 225);
                this.col0 = Color.get(-1, 2, 115, 225);
                this.col1 = Color.get(-1, 2, 115, 225);
                this.col2 = Color.get(-1, 2, 115, 225);
                this.col3 = Color.get(-1, 2, 115, 225);
                this.col3 = Color.get(-1, 2, 115, 225);
                this.level.add(new SmashParticle(this.x * 16 + 8, this.y * 16 + 8));
                this.level.add(new TextParticle("-1 key", this.x, this.y, Color.get(-1, 500, 500, 500)));
                final Level level = this.level;
                --level.chestcount;
                if (this.level.chestcount == 0) {
                    for (int i = 0; i < 5; ++i) {
                        this.level.add(new ItemEntity(new ResourceItem(Resource.goldapple), this.x, this.y));
                    }
                    Game.notifications.add("You hear a noise from the surface!");
                    final AirWizard aw = new AirWizard(true);
                    aw.x = Game.levels[3].w / 2;
                    aw.y = Game.levels[3].h / 2;
                    Game.levels[3].add(aw);
                }
            }
            return true;
        }
        if (player.inventory.hasResources(Resource.key, 1)) {
            this.islocked = false;
            player.game.setMenu(new ContainerMenu(player, "Dungeon Chest", this.inventory));
            this.col = Color.get(-1, 2, 115, 225);
            this.col0 = Color.get(-1, 2, 115, 225);
            this.col1 = Color.get(-1, 2, 115, 225);
            this.col2 = Color.get(-1, 2, 115, 225);
            this.col3 = Color.get(-1, 2, 115, 225);
            this.col3 = Color.get(-1, 2, 115, 225);
            this.level.add(new SmashParticle(this.x * 16 + 8, this.y * 16 + 8));
            this.level.add(new TextParticle("-1 key", this.x, this.y, Color.get(-1, 500, 500, 500)));
            final Level level2 = this.level;
            --level2.chestcount;
            if (this.level.chestcount == 0) {
                for (int i = 0; i < 5; ++i) {
                    this.level.add(new ItemEntity(new ResourceItem(Resource.goldapple), this.x, this.y));
                }
                Game.notifications.add("You hear a noise from the surface!");
                final AirWizard aw = new AirWizard(true);
                aw.x = Game.levels[3].w / 2;
                aw.y = Game.levels[3].h / 2;
                Game.levels[3].add(aw);
            }
            if (!ModeMenu.creative) {
                player.inventory.removeResource(Resource.key, 1);
            }
        }
        return true;
    }
    
    public void getInventory(final Inventory itemlist) {
        if (this.random.nextInt(8) == 1) {
            itemlist.add(new ResourceItem(Resource.gemarmor));
        }
        if (this.random.nextInt(6) == 1) {
            itemlist.add(new ResourceItem(Resource.garmor));
        }
        if (this.random.nextInt(5) == 1) {
            itemlist.add(new ResourceItem(Resource.iarmor, 2));
        }
        if (this.random.nextInt(4) == 1) {
            itemlist.add(new ResourceItem(Resource.speedpotion, 2));
        }
        if (this.random.nextInt(3) == 1) {
            itemlist.add(new ResourceItem(Resource.lightpotion, 2));
        }
        if (this.random.nextInt(3) == 1) {
            itemlist.add(new ResourceItem(Resource.potion, 10));
        }
        if (this.random.nextInt(4) == 1) {
            itemlist.add(new ResourceItem(Resource.lightpotion, 3));
        }
        if (this.random.nextInt(5) == 1) {
            itemlist.add(new ResourceItem(Resource.steak, 6));
        }
        if (this.random.nextInt(5) == 1) {
            itemlist.add(new ResourceItem(Resource.cookedpork, 6));
        }
        if (this.random.nextInt(6) == 1) {
            itemlist.add(new ToolItem(ToolType.claymore, 2));
        }
        if (this.random.nextInt(4) == 1) {
            itemlist.add(new ToolItem(ToolType.sword, 3));
        }
        if (this.random.nextInt(4) == 1) {
            itemlist.add(new ToolItem(ToolType.claymore, 1));
        }
        if (this.random.nextInt(6) == 1) {
            itemlist.add(new ToolItem(ToolType.bow, 3));
        }
        if (this.random.nextInt(7) == 1) {
            itemlist.add(new ToolItem(ToolType.bow, 4));
        }
        if (this.random.nextInt(7) == 1) {
            itemlist.add(new ToolItem(ToolType.sword, 4));
        }
        if (this.random.nextInt(5) == 1) {
            itemlist.add(new ResourceItem(Resource.gem, 7));
        }
        if (this.random.nextInt(5) == 1) {
            itemlist.add(new ResourceItem(Resource.gem, 8));
        }
        if (this.random.nextInt(6) == 1) {
            itemlist.add(new ResourceItem(Resource.speedpotion, 5));
        }
        if (this.random.nextInt(4) == 1) {
            itemlist.add(new ResourceItem(Resource.wood, 20));
        }
        if (this.random.nextInt(4) == 1) {
            itemlist.add(new ResourceItem(Resource.wool, 12));
        }
        if (this.random.nextInt(2) == 1) {
            itemlist.add(new ResourceItem(Resource.coal, 4));
        }
        if (this.random.nextInt(7) == 1) {
            itemlist.add(new ResourceItem(Resource.regenpotion, 1));
        }
        if (this.random.nextInt(7) == 1) {
            itemlist.add(new ResourceItem(Resource.energypotion, 1));
        }
        if (this.random.nextInt(14) == 1) {
            itemlist.add(new ResourceItem(Resource.timepotion, 1));
        }
        if (this.random.nextInt(14) == 1) {
            itemlist.add(new ResourceItem(Resource.shieldpotion, 1));
        }
        if (this.random.nextInt(7) == 1) {
            itemlist.add(new ResourceItem(Resource.lavapotion, 1));
        }
        if (this.random.nextInt(5) == 1) {
            itemlist.add(new ResourceItem(Resource.hastepotion, 3));
        }
        if (this.inventory.items.size() < 1) {
            this.inventory.items.add(new ResourceItem(Resource.steak, 6));
            this.inventory.items.add(new ResourceItem(Resource.timepotion, 1));
            this.inventory.items.add(new ToolItem(ToolType.hatchet, 4));
        }
    }
    
    @Override
    protected void touchedBy(final Entity entity) {
        if (entity instanceof Player && this.pushTime == 0 && !this.islocked) {
            this.pushDir = ((Player)entity).dir;
            this.pushTime = 10;
        }
    }
    
    @Override
    public void take(final Player player) {
        if (!this.islocked) {
            this.shouldTake = player;
        }
    }
}
