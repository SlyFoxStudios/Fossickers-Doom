// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.level.tile;

import com.mojang.ld22.entity.ItemEntity;
import com.mojang.ld22.item.ResourceItem;
import com.mojang.ld22.item.resource.Resource;
import com.mojang.ld22.item.ToolType;
import com.mojang.ld22.item.ToolItem;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.entity.Mob;
import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.Game;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.gfx.Color;

public class SandTile extends Tile
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
        SandTile.col0 = Color.get(443, 440, 330, 440);
        SandTile.col00 = Color.get(440, 440, 330, 322);
        SandTile.col1 = Color.get(552, 550, 440, 440);
        SandTile.col11 = Color.get(440, 550, 440, 321);
        SandTile.col2 = Color.get(334, 330, 220, 220);
        SandTile.col22 = Color.get(330, 330, 220, 211);
        SandTile.col3 = Color.get(225, 220, 110, 110);
        SandTile.col33 = Color.get(220, 220, 110, 100);
    }
    
    public SandTile(final int id) {
        super(id);
        this.connectsToSand = true;
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        if (Game.Time == 0) {
            final int col = SandTile.col0;
            final int transitionColor = SandTile.col00;
            final boolean u = !level.getTile(x, y - 1).connectsToSand;
            final boolean d = !level.getTile(x, y + 1).connectsToSand;
            final boolean l = !level.getTile(x - 1, y).connectsToSand;
            final boolean r = !level.getTile(x + 1, y).connectsToSand;
            final boolean steppedOn = level.getData(x, y) > 0;
            if (!u && !l) {
                if (!steppedOn) {
                    screen.render(x * 16 + 0, y * 16 + 0, 0, col, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, 35, col, 0);
                }
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
                if (!steppedOn) {
                    screen.render(x * 16 + 8, y * 16 + 8, 3, col, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, 35, col, 0);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 13 : 12) + (d ? 2 : 1) * 32, transitionColor, 0);
            }
        }
        if (Game.Time == 1) {
            final int col = SandTile.col1;
            final int transitionColor = SandTile.col11;
            final boolean u = !level.getTile(x, y - 1).connectsToSand;
            final boolean d = !level.getTile(x, y + 1).connectsToSand;
            final boolean l = !level.getTile(x - 1, y).connectsToSand;
            final boolean r = !level.getTile(x + 1, y).connectsToSand;
            final boolean steppedOn = level.getData(x, y) > 0;
            if (!u && !l) {
                if (!steppedOn) {
                    screen.render(x * 16 + 0, y * 16 + 0, 0, col, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, 35, col, 0);
                }
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
                if (!steppedOn) {
                    screen.render(x * 16 + 8, y * 16 + 8, 3, col, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, 35, col, 0);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 13 : 12) + (d ? 2 : 1) * 32, transitionColor, 0);
            }
        }
        if (Game.Time == 2) {
            final int col = SandTile.col2;
            final int transitionColor = SandTile.col22;
            final boolean u = !level.getTile(x, y - 1).connectsToSand;
            final boolean d = !level.getTile(x, y + 1).connectsToSand;
            final boolean l = !level.getTile(x - 1, y).connectsToSand;
            final boolean r = !level.getTile(x + 1, y).connectsToSand;
            final boolean steppedOn = level.getData(x, y) > 0;
            if (!u && !l) {
                if (!steppedOn) {
                    screen.render(x * 16 + 0, y * 16 + 0, 0, col, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, 35, col, 0);
                }
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
                if (!steppedOn) {
                    screen.render(x * 16 + 8, y * 16 + 8, 3, col, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, 35, col, 0);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 13 : 12) + (d ? 2 : 1) * 32, transitionColor, 0);
            }
        }
        if (Game.Time == 3) {
            final int col = SandTile.col3;
            final int transitionColor = SandTile.col33;
            final boolean u = !level.getTile(x, y - 1).connectsToSand;
            final boolean d = !level.getTile(x, y + 1).connectsToSand;
            final boolean l = !level.getTile(x - 1, y).connectsToSand;
            final boolean r = !level.getTile(x + 1, y).connectsToSand;
            final boolean steppedOn = level.getData(x, y) > 0;
            if (!u && !l) {
                if (!steppedOn) {
                    screen.render(x * 16 + 0, y * 16 + 0, 0, col, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, 35, col, 0);
                }
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
                if (!steppedOn) {
                    screen.render(x * 16 + 8, y * 16 + 8, 3, col, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, 35, col, 0);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 13 : 12) + (d ? 2 : 1) * 32, transitionColor, 0);
            }
        }
    }
    
    @Override
    public void tick(final Level level, final int x, final int y) {
        final int d = level.getData(x, y);
        if (d > 0) {
            level.setData(x, y, d - 1);
        }
    }
    
    @Override
    public void steppedOn(final Level level, final int x, final int y, final Entity entity) {
        if (entity instanceof Mob) {
            level.setData(x, y, 10);
        }
    }
    
    @Override
    public boolean interact(final Level level, final int xt, final int yt, final Player player, final Item item, final int attackDir) {
        if (item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.shovel && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.dirt, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.sand), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                return true;
            }
            if (tool.type == ToolType.spade && player.payStamina(5 - tool.level)) {
                level.setTile(xt, yt, Tile.dirt, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.sand), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                return true;
            }
        }
        return false;
    }
}
