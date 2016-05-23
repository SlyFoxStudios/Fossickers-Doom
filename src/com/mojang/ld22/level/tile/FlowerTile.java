// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.level.tile;

import com.mojang.ld22.entity.Mob;
import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.entity.ItemEntity;
import com.mojang.ld22.item.ResourceItem;
import com.mojang.ld22.item.resource.Resource;
import com.mojang.ld22.item.ToolType;
import com.mojang.ld22.item.ToolItem;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.Game;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.gfx.Color;

public class FlowerTile extends GrassTile
{
    public int col0;
    public int col1;
    public int col2;
    public int col3;
    
    public FlowerTile(final int id) {
        super(id);
        this.col0 = Color.get(20, 131, 444, 440);
        this.col1 = Color.get(10, 141, 555, 440);
        this.col2 = Color.get(10, 30, 444, 330);
        this.col3 = Color.get(0, 20, 333, 220);
        FlowerTile.tiles[id] = this;
        this.connectsToGrass = true;
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        super.render(screen, level, x, y);
        if (Game.Time == 0) {
            final int data = level.getData(x, y);
            final int shape = data / 16 % 2;
            final int flowerCol = this.col0;
            if (shape == 0) {
                screen.render(x * 16 + 0, y * 16 + 0, 33, flowerCol, 0);
            }
            if (shape == 1) {
                screen.render(x * 16 + 8, y * 16 + 0, 33, flowerCol, 0);
            }
            if (shape == 1) {
                screen.render(x * 16 + 0, y * 16 + 8, 33, flowerCol, 0);
            }
            if (shape == 0) {
                screen.render(x * 16 + 8, y * 16 + 8, 33, flowerCol, 0);
            }
        }
        if (Game.Time == 1) {
            final int data = level.getData(x, y);
            final int shape = data / 16 % 2;
            final int flowerCol = this.col1;
            if (shape == 0) {
                screen.render(x * 16 + 0, y * 16 + 0, 33, flowerCol, 0);
            }
            if (shape == 1) {
                screen.render(x * 16 + 8, y * 16 + 0, 33, flowerCol, 0);
            }
            if (shape == 1) {
                screen.render(x * 16 + 0, y * 16 + 8, 33, flowerCol, 0);
            }
            if (shape == 0) {
                screen.render(x * 16 + 8, y * 16 + 8, 33, flowerCol, 0);
            }
        }
        if (Game.Time == 2) {
            final int data = level.getData(x, y);
            final int shape = data / 16 % 2;
            final int flowerCol = this.col2;
            if (shape == 0) {
                screen.render(x * 16 + 0, y * 16 + 0, 33, flowerCol, 0);
            }
            if (shape == 1) {
                screen.render(x * 16 + 8, y * 16 + 0, 33, flowerCol, 0);
            }
            if (shape == 1) {
                screen.render(x * 16 + 0, y * 16 + 8, 33, flowerCol, 0);
            }
            if (shape == 0) {
                screen.render(x * 16 + 8, y * 16 + 8, 33, flowerCol, 0);
            }
        }
        if (Game.Time == 3) {
            final int data = level.getData(x, y);
            final int shape = data / 16 % 2;
            final int flowerCol = this.col3;
            if (shape == 0) {
                screen.render(x * 16 + 0, y * 16 + 0, 33, flowerCol, 0);
            }
            if (shape == 1) {
                screen.render(x * 16 + 8, y * 16 + 0, 33, flowerCol, 0);
            }
            if (shape == 1) {
                screen.render(x * 16 + 0, y * 16 + 8, 33, flowerCol, 0);
            }
            if (shape == 0) {
                screen.render(x * 16 + 8, y * 16 + 8, 33, flowerCol, 0);
            }
        }
    }
    
    @Override
    public boolean interact(final Level level, final int x, final int y, final Player player, final Item item, final int attackDir) {
        if (item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.shovel && player.payStamina(2 - tool.level)) {
                level.add(new ItemEntity(new ResourceItem(Resource.flower), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
                level.add(new ItemEntity(new ResourceItem(Resource.rose), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
                level.setTile(x, y, Tile.grass, 0);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void hurt(final Level level, final int x, final int y, final Mob source, final int dmg, final int attackDir) {
        for (int count = this.random.nextInt(2) + 1, i = 0; i < count; ++i) {
            level.add(new ItemEntity(new ResourceItem(Resource.flower), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
        }
        for (int count = this.random.nextInt(2), i = 0; i < count; ++i) {
            level.add(new ItemEntity(new ResourceItem(Resource.rose), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
        }
        level.setTile(x, y, Tile.grass, 0);
    }
}
