// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.level.tile;

import com.fossickersdoom.Game;
import com.fossickersdoom.entity.Entity;
import com.fossickersdoom.entity.Player;
import com.fossickersdoom.gfx.Screen;
import com.fossickersdoom.item.Item;
import com.fossickersdoom.item.ToolItem;
import com.fossickersdoom.item.ToolType;
import com.fossickersdoom.level.Level;
import com.fossickersdoom.gfx.Color;

public class FarmTile extends Tile
{
    public FarmTile(final int id) {
        super(id);
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        final int col0 = Color.get(201, 311, 322, 433);
        final int col2 = Color.get(301, 411, 422, 533);
        final int col3 = Color.get(201, 311, 322, 433);
        final int col4 = Color.get(101, 211, 222, 333);
        final int col5 = Color.get(301, 411, 422, 533);
        if (level.dirtColor == 322) {
            if (Game.Time == 0) {
                final int col6 = col0;
                screen.render(x * 16 + 0, y * 16 + 0, 34, col6, 1);
                screen.render(x * 16 + 8, y * 16 + 0, 34, col6, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 34, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 8, 34, col6, 1);
            }
            if (Game.Time == 1) {
                final int col6 = col2;
                screen.render(x * 16 + 0, y * 16 + 0, 34, col6, 1);
                screen.render(x * 16 + 8, y * 16 + 0, 34, col6, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 34, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 8, 34, col6, 1);
            }
            if (Game.Time == 2) {
                final int col6 = col3;
                screen.render(x * 16 + 0, y * 16 + 0, 34, col6, 1);
                screen.render(x * 16 + 8, y * 16 + 0, 34, col6, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 34, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 8, 34, col6, 1);
            }
            if (Game.Time == 3) {
                final int col6 = col4;
                screen.render(x * 16 + 0, y * 16 + 0, 34, col6, 1);
                screen.render(x * 16 + 8, y * 16 + 0, 34, col6, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 34, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 8, 34, col6, 1);
            }
        }
        if (level.dirtColor == 222) {
            final int col6 = col5;
            screen.render(x * 16 + 0, y * 16 + 0, 34, col6, 1);
            screen.render(x * 16 + 8, y * 16 + 0, 34, col6, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 34, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 34, col6, 1);
        }
    }
    
    @Override
    public boolean interact(final Level level, final int xt, final int yt, final Player player, final Item item, final int attackDir) {
        if (item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.shovel && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.dirt, 0);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void tick(final Level level, final int xt, final int yt) {
        final int age = level.getData(xt, yt);
        if (age < 5) {
            level.setData(xt, yt, age + 1);
        }
    }
    
    @Override
    public void steppedOn(final Level level, final int xt, final int yt, final Entity entity) {
        if (this.random.nextInt(60) != 0) {
            return;
        }
        if (level.getData(xt, yt) < 5) {
            return;
        }
        level.setTile(xt, yt, Tile.dirt, 0);
    }
}
