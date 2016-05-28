// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.level.tile;

import com.fossickersdoom.Game;
import com.fossickersdoom.entity.Entity;
import com.fossickersdoom.entity.ItemEntity;
import com.fossickersdoom.entity.Mob;
import com.fossickersdoom.entity.Player;
import com.fossickersdoom.item.Item;
import com.fossickersdoom.item.ToolItem;
import com.fossickersdoom.item.ToolType;
import com.fossickersdoom.item.resource.Resource;
import com.fossickersdoom.level.Level;
import com.fossickersdoom.item.ResourceItem;
import com.fossickersdoom.gfx.Color;
import com.fossickersdoom.gfx.Screen;

public class WheatTile extends Tile
{
    public WheatTile(final int id) {
        super(id);
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        final int age = level.getData(x, y);
        int icon = age / 10;
        final int col0 = Color.get(201, 311, 322, 40);
        final int col2 = Color.get(201, 311, 40 + icon * 100, 30 + (icon - 3) * 2 * 100);
        final int col3 = Color.get(0, 0, 40 + icon * 100, 30 + (icon - 3) * 2 * 100);
        final int col4 = Color.get(301, 411, 321, 50);
        final int col5 = Color.get(301, 411, 50 + icon * 100, 40 + (icon - 3) * 2 * 100);
        final int col6 = Color.get(0, 0, 50 + icon * 100, 40 + (icon - 3) * 2 * 100);
        final int col7 = Color.get(201, 311, 211, 40);
        final int col8 = Color.get(201, 311, 40 + icon * 100, 30 + (icon - 3) * 2 * 100);
        final int col9 = Color.get(0, 0, 40 + icon * 100, 30 + (icon - 3) * 2 * 100);
        final int col10 = Color.get(101, 211, 100, 30);
        final int col11 = Color.get(101, 211, 30 + icon * 100, 20 + (icon - 3) * 2 * 100);
        final int col12 = Color.get(0, 0, 30 + icon * 100, 20 + (icon - 3) * 2 * 100);
        final int col13 = Color.get(301, 411, 222, 50);
        final int col14 = Color.get(301, 411, 50 + icon * 100, 40 + (icon - 3) * 2 * 100);
        final int col15 = Color.get(0, 0, 50 + icon * 100, 40 + (icon - 3) * 2 * 100);
        if (level.dirtColor == 322) {
            if (Game.Time == 0) {
                int col16 = col0;
                if (icon >= 3) {
                    col16 = col2;
                    if (age == 50) {
                        col16 = col3;
                    }
                    icon = 3;
                }
                screen.render(x * 16 + 0, y * 16 + 0, 100 + icon, col16, 0);
                screen.render(x * 16 + 8, y * 16 + 0, 100 + icon, col16, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 100 + icon, col16, 1);
                screen.render(x * 16 + 8, y * 16 + 8, 100 + icon, col16, 1);
            }
            if (Game.Time == 1) {
                int col16 = col4;
                if (icon >= 3) {
                    col16 = col5;
                    if (age == 50) {
                        col16 = col6;
                    }
                    icon = 3;
                }
                screen.render(x * 16 + 0, y * 16 + 0, 100 + icon, col16, 0);
                screen.render(x * 16 + 8, y * 16 + 0, 100 + icon, col16, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 100 + icon, col16, 1);
                screen.render(x * 16 + 8, y * 16 + 8, 100 + icon, col16, 1);
            }
            if (Game.Time == 2) {
                int col16 = col7;
                if (icon >= 3) {
                    col16 = col8;
                    if (age == 50) {
                        col16 = col9;
                    }
                    icon = 3;
                }
                screen.render(x * 16 + 0, y * 16 + 0, 100 + icon, col16, 0);
                screen.render(x * 16 + 8, y * 16 + 0, 100 + icon, col16, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 100 + icon, col16, 1);
                screen.render(x * 16 + 8, y * 16 + 8, 100 + icon, col16, 1);
            }
            if (Game.Time == 3) {
                int col16 = col10;
                if (icon >= 3) {
                    col16 = col11;
                    if (age == 50) {
                        col16 = col12;
                    }
                    icon = 3;
                }
                screen.render(x * 16 + 0, y * 16 + 0, 100 + icon, col16, 0);
                screen.render(x * 16 + 8, y * 16 + 0, 100 + icon, col16, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 100 + icon, col16, 1);
                screen.render(x * 16 + 8, y * 16 + 8, 100 + icon, col16, 1);
            }
        }
        if (level.dirtColor == 222) {
            int col16 = col13;
            if (icon >= 3) {
                col16 = col14;
                if (age == 50) {
                    col16 = col15;
                }
                icon = 3;
            }
            screen.render(x * 16 + 0, y * 16 + 0, 100 + icon, col16, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 100 + icon, col16, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 100 + icon, col16, 1);
            screen.render(x * 16 + 8, y * 16 + 8, 100 + icon, col16, 1);
        }
    }
    
    public boolean IfWater(final Level level, final int xs, final int ys) {
        return level.getTile(xs - 1, ys) == Tile.water || level.getTile(xs + 1, ys) == Tile.water || level.getTile(xs, ys + 1) == Tile.water || level.getTile(xs, ys - 1) == Tile.water || level.getTile(xs - 1, ys - 1) == Tile.water || level.getTile(xs + 1, ys + 1) == Tile.water || level.getTile(xs - 1, ys + 1) == Tile.water || level.getTile(xs + 1, ys - 1) == Tile.water;
    }
    
    @Override
    public void tick(final Level level, final int xt, final int yt) {
        if (Game.tickCount > 7200 && Game.tickCount < 36000) {
            if (this.random.nextInt(2) == 0) {
                return;
            }
            if ((Game.tickCount >= 36000 && Game.tickCount <= 43200) || (Game.tickCount >= 0 && Game.tickCount <= 7200)) {
                if (this.random.nextInt(4) != 0) {
                    return;
                }
                if (this.random.nextInt(8) != 0) {
                    return;
                }
            }
        }
        final int age = level.getData(xt, yt);
        if (!this.IfWater(level, xt, yt)) {
            if (age < 50) {
                level.setData(xt, yt, age + 1);
            }
        }
        else if (this.IfWater(level, xt, yt) && age < 50) {
            level.setData(xt, yt, age + 2);
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
    public void steppedOn(final Level level, final int xt, final int yt, final Entity entity) {
        if (this.random.nextInt(60) != 0) {
            return;
        }
        if (level.getData(xt, yt) < 2) {
            return;
        }
        this.harvest(level, xt, yt);
    }
    
    @Override
    public void hurt(final Level level, final int x, final int y, final Mob source, final int dmg, final int attackDir) {
        this.harvest(level, x, y);
    }
    
    private void harvest(final Level level, final int x, final int y) {
        final int age = level.getData(x, y);
        for (int count = this.random.nextInt(2) + 1, i = 0; i < count; ++i) {
            level.add(new ItemEntity(new ResourceItem(Resource.seeds), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
        }
        int count = 0;
        if (age >= 50) {
            count = this.random.nextInt(3) + 2;
        }
        else if (age >= 40) {
            count = this.random.nextInt(2) + 1;
        }
        for (int i = 0; i < count; ++i) {
            level.add(new ItemEntity(new ResourceItem(Resource.wheat), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
        }
        if (age >= 50) {
            Player.score = Player.score + this.random.nextInt(5) + 1;
        }
        level.setTile(x, y, Tile.dirt, 0);
    }
}
