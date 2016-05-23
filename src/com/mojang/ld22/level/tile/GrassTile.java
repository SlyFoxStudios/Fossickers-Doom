// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.level.tile;

import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.entity.ItemEntity;
import com.mojang.ld22.item.ResourceItem;
import com.mojang.ld22.item.resource.Resource;
import com.mojang.ld22.sound.Sound;
import com.mojang.ld22.item.ToolType;
import com.mojang.ld22.item.ToolItem;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.Game;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.gfx.Color;

public class GrassTile extends Tile
{
    public static int col0;
    public static int col00;
    public static int col1;
    public static int col11;
    public static int col2;
    public static int col22;
    public static int col3;
    public static int col33;
    
    static {
        GrassTile.col0 = Color.get(131, 131, 141, 322);
        GrassTile.col00 = Color.get(131, 131, 141, 322);
        GrassTile.col1 = Color.get(141, 141, 252, 321);
        GrassTile.col11 = Color.get(141, 141, 252, 321);
        GrassTile.col2 = Color.get(30, 30, 141, 211);
        GrassTile.col22 = Color.get(20, 30, 141, 211);
        GrassTile.col3 = Color.get(20, 20, 30, 100);
        GrassTile.col33 = Color.get(10, 20, 30, 100);
    }
    
    public GrassTile(final int id) {
        super(id);
        this.connectsToGrass = true;
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        if (Game.Time == 0) {
            final int col = GrassTile.col0;
            final int transitionColor = GrassTile.col00;
            final boolean u = !level.getTile(x, y - 1).connectsToGrass;
            final boolean d = !level.getTile(x, y + 1).connectsToGrass;
            final boolean l = !level.getTile(x - 1, y).connectsToGrass;
            final boolean r = !level.getTile(x + 1, y).connectsToGrass;
            if (!u && !l) {
                screen.render(x * 16 + 0, y * 16 + 0, 0, col, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 11 : 12) + (u ? 0 : 1) * 32, transitionColor, 0);
            }
            if (!u && !r) {
                screen.render(x * 16 + 8, y * 16 + 0, 1, col, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 13 : 12) + (u ? 0 : 1) * 32, transitionColor, 0);
            }
            if (!d && !l) {
                screen.render(x * 16 + 0, y * 16 + 8, 2, col, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 11 : 12) + (d ? 2 : 1) * 32, transitionColor, 0);
            }
            if (!d && !r) {
                screen.render(x * 16 + 8, y * 16 + 8, 3, col, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 13 : 12) + (d ? 2 : 1) * 32, transitionColor, 0);
            }
        }
        if (Game.Time == 1) {
            final int col = GrassTile.col1;
            final int transitionColor = GrassTile.col11;
            final boolean u = !level.getTile(x, y - 1).connectsToGrass;
            final boolean d = !level.getTile(x, y + 1).connectsToGrass;
            final boolean l = !level.getTile(x - 1, y).connectsToGrass;
            final boolean r = !level.getTile(x + 1, y).connectsToGrass;
            if (!u && !l) {
                screen.render(x * 16 + 0, y * 16 + 0, 0, col, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 11 : 12) + (u ? 0 : 1) * 32, transitionColor, 0);
            }
            if (!u && !r) {
                screen.render(x * 16 + 8, y * 16 + 0, 1, col, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 13 : 12) + (u ? 0 : 1) * 32, transitionColor, 0);
            }
            if (!d && !l) {
                screen.render(x * 16 + 0, y * 16 + 8, 2, col, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 11 : 12) + (d ? 2 : 1) * 32, transitionColor, 0);
            }
            if (!d && !r) {
                screen.render(x * 16 + 8, y * 16 + 8, 3, col, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 13 : 12) + (d ? 2 : 1) * 32, transitionColor, 0);
            }
        }
        if (Game.Time == 2) {
            final int col = GrassTile.col2;
            final int transitionColor = GrassTile.col22;
            final boolean u = !level.getTile(x, y - 1).connectsToGrass;
            final boolean d = !level.getTile(x, y + 1).connectsToGrass;
            final boolean l = !level.getTile(x - 1, y).connectsToGrass;
            final boolean r = !level.getTile(x + 1, y).connectsToGrass;
            if (!u && !l) {
                screen.render(x * 16 + 0, y * 16 + 0, 0, col, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 11 : 12) + (u ? 0 : 1) * 32, transitionColor, 0);
            }
            if (!u && !r) {
                screen.render(x * 16 + 8, y * 16 + 0, 1, col, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 13 : 12) + (u ? 0 : 1) * 32, transitionColor, 0);
            }
            if (!d && !l) {
                screen.render(x * 16 + 0, y * 16 + 8, 2, col, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 11 : 12) + (d ? 2 : 1) * 32, transitionColor, 0);
            }
            if (!d && !r) {
                screen.render(x * 16 + 8, y * 16 + 8, 3, col, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 13 : 12) + (d ? 2 : 1) * 32, transitionColor, 0);
            }
        }
        if (Game.Time == 3) {
            final int col = GrassTile.col3;
            final int transitionColor = GrassTile.col33;
            final boolean u = !level.getTile(x, y - 1).connectsToGrass;
            final boolean d = !level.getTile(x, y + 1).connectsToGrass;
            final boolean l = !level.getTile(x - 1, y).connectsToGrass;
            final boolean r = !level.getTile(x + 1, y).connectsToGrass;
            if (!u && !l) {
                screen.render(x * 16 + 0, y * 16 + 0, 0, col, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 11 : 12) + (u ? 0 : 1) * 32, transitionColor, 0);
            }
            if (!u && !r) {
                screen.render(x * 16 + 8, y * 16 + 0, 1, col, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 13 : 12) + (u ? 0 : 1) * 32, transitionColor, 0);
            }
            if (!d && !l) {
                screen.render(x * 16 + 0, y * 16 + 8, 2, col, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 11 : 12) + (d ? 2 : 1) * 32, transitionColor, 0);
            }
            if (!d && !r) {
                screen.render(x * 16 + 8, y * 16 + 8, 3, col, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 13 : 12) + (d ? 2 : 1) * 32, transitionColor, 0);
            }
        }
    }
    
    @Override
    public void tick(final Level level, final int xt, final int yt) {
        if (this.random.nextInt(40) != 0) {
            return;
        }
        int xn = xt;
        int yn = yt;
        if (this.random.nextBoolean()) {
            xn += this.random.nextInt(2) * 2 - 1;
        }
        else {
            yn += this.random.nextInt(2) * 2 - 1;
        }
        if (level.getTile(xn, yn) == Tile.dirt) {
            level.setTile(xn, yn, this, 0);
        }
        if (level.getTile(xn, yn) == Tile.lightdirt) {
            level.setTile(xn, yn, this, 0);
        }
        if (level.getTile(xn, yn) == Tile.torchdirt) {
            level.setTile(xn, yn, Tile.torchgrass, 0);
        }
    }
    
    @Override
    public boolean interact(final Level level, final int xt, final int yt, final Player player, final Item item, final int attackDir) {
        if (item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.shovel && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.dirt, 0);
                Sound.monsterHurt.play();
                if (this.random.nextInt(5) == 0) {
                    level.add(new ItemEntity(new ResourceItem(Resource.seeds), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                    level.add(new ItemEntity(new ResourceItem(Resource.seeds), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                    return true;
                }
            }
            if (tool.type == ToolType.spade && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.dirt, 0);
                Sound.monsterHurt.play();
                if (this.random.nextInt(5) == 0) {
                    return true;
                }
            }
            if (tool.type == ToolType.hoe && player.payStamina(4 - tool.level)) {
                Sound.monsterHurt.play();
                if (this.random.nextInt(5) == 0) {
                    level.add(new ItemEntity(new ResourceItem(Resource.seeds), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                    return true;
                }
                level.setTile(xt, yt, Tile.farmland, 0);
                return true;
            }
        }
        return false;
    }
}
