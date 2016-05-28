// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.level.tile;

import com.fossickersdoom.Game;
import com.fossickersdoom.entity.ItemEntity;
import com.fossickersdoom.entity.Mob;
import com.fossickersdoom.entity.particle.TextParticle;
import com.fossickersdoom.item.Item;
import com.fossickersdoom.item.resource.Resource;
import com.fossickersdoom.screen.ModeMenu;
import com.fossickersdoom.item.ResourceItem;
import com.fossickersdoom.entity.particle.SmashParticle;
import com.fossickersdoom.item.ToolType;
import com.fossickersdoom.item.ToolItem;
import com.fossickersdoom.entity.Player;
import com.fossickersdoom.entity.Entity;
import com.fossickersdoom.gfx.Color;
import com.fossickersdoom.level.Level;
import com.fossickersdoom.gfx.Screen;

public class WoodWallTile extends Tile
{
    public WoodWallTile(final int id) {
        super(id);
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        final int col0 = Color.get(320, 320, 210, 210);
        final int col2 = Color.get(100, 320, 210, 430);
        final int col3 = Color.get(430, 430, 320, 320);
        final int col4 = Color.get(100, 430, 320, 540);
        final int col5 = Color.get(320, 320, 210, 210);
        final int col6 = Color.get(100, 320, 210, 430);
        final int col7 = Color.get(210, 210, 100, 100);
        final int col8 = Color.get(0, 210, 100, 320);
        final int col9 = Color.get(430, 430, 320, 320);
        final int col10 = Color.get(100, 430, 320, 540);
        if (level.dirtColor == 322 && Game.Time == 0) {
            final int col11 = col0;
            final int transitionColor = col2;
            final boolean u = level.getTile(x, y - 1) != this;
            final boolean d = level.getTile(x, y + 1) != this;
            final boolean l = level.getTile(x - 1, y) != this;
            final boolean r = level.getTile(x + 1, y) != this;
            final boolean ul = level.getTile(x - 1, y - 1) != this;
            final boolean dl = level.getTile(x - 1, y + 1) != this;
            final boolean ur = level.getTile(x + 1, y - 1) != this;
            final boolean dr = level.getTile(x + 1, y + 1) != this;
            if (!u && !l) {
                if (!ul) {
                    screen.render(x * 16 + 0, y * 16 + 0, 741, col11, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, 711, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 6 : 5) + (u ? 24 : 23) * 32, transitionColor, 3);
            }
            if (!u && !r) {
                if (!ur) {
                    screen.render(x * 16 + 8, y * 16 + 0, 741, col11, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 0, 712, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 4 : 5) + (u ? 24 : 23) * 32, transitionColor, 3);
            }
            if (!d && !l) {
                if (!dl) {
                    screen.render(x * 16 + 0, y * 16 + 8, 741, col11, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 8, 743, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 6 : 5) + (d ? 22 : 23) * 32, transitionColor, 3);
            }
            if (!d && !r) {
                if (!dr) {
                    screen.render(x * 16 + 8, y * 16 + 8, 741, col11, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, 744, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 4 : 5) + (d ? 22 : 23) * 32, transitionColor, 3);
            }
        }
        if (Game.Time == 1) {
            final int col11 = col3;
            final int transitionColor = col4;
            final boolean u = level.getTile(x, y - 1) != this;
            final boolean d = level.getTile(x, y + 1) != this;
            final boolean l = level.getTile(x - 1, y) != this;
            final boolean r = level.getTile(x + 1, y) != this;
            final boolean ul = level.getTile(x - 1, y - 1) != this;
            final boolean dl = level.getTile(x - 1, y + 1) != this;
            final boolean ur = level.getTile(x + 1, y - 1) != this;
            final boolean dr = level.getTile(x + 1, y + 1) != this;
            if (!u && !l) {
                if (!ul) {
                    screen.render(x * 16 + 0, y * 16 + 0, 741, col11, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, 711, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 6 : 5) + (u ? 24 : 23) * 32, transitionColor, 3);
            }
            if (!u && !r) {
                if (!ur) {
                    screen.render(x * 16 + 8, y * 16 + 0, 741, col11, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 0, 712, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 4 : 5) + (u ? 24 : 23) * 32, transitionColor, 3);
            }
            if (!d && !l) {
                if (!dl) {
                    screen.render(x * 16 + 0, y * 16 + 8, 741, col11, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 8, 743, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 6 : 5) + (d ? 22 : 23) * 32, transitionColor, 3);
            }
            if (!d && !r) {
                if (!dr) {
                    screen.render(x * 16 + 8, y * 16 + 8, 741, col11, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, 744, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 4 : 5) + (d ? 22 : 23) * 32, transitionColor, 3);
            }
        }
        if (Game.Time == 2) {
            final int col11 = col5;
            final int transitionColor = col6;
            final boolean u = level.getTile(x, y - 1) != this;
            final boolean d = level.getTile(x, y + 1) != this;
            final boolean l = level.getTile(x - 1, y) != this;
            final boolean r = level.getTile(x + 1, y) != this;
            final boolean ul = level.getTile(x - 1, y - 1) != this;
            final boolean dl = level.getTile(x - 1, y + 1) != this;
            final boolean ur = level.getTile(x + 1, y - 1) != this;
            final boolean dr = level.getTile(x + 1, y + 1) != this;
            if (!u && !l) {
                if (!ul) {
                    screen.render(x * 16 + 0, y * 16 + 0, 741, col11, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, 711, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 6 : 5) + (u ? 24 : 23) * 32, transitionColor, 3);
            }
            if (!u && !r) {
                if (!ur) {
                    screen.render(x * 16 + 8, y * 16 + 0, 741, col11, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 0, 712, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 4 : 5) + (u ? 24 : 23) * 32, transitionColor, 3);
            }
            if (!d && !l) {
                if (!dl) {
                    screen.render(x * 16 + 0, y * 16 + 8, 741, col11, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 8, 743, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 6 : 5) + (d ? 22 : 23) * 32, transitionColor, 3);
            }
            if (!d && !r) {
                if (!dr) {
                    screen.render(x * 16 + 8, y * 16 + 8, 741, col11, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, 744, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 4 : 5) + (d ? 22 : 23) * 32, transitionColor, 3);
            }
        }
        if (Game.Time == 3) {
            final int col11 = col7;
            final int transitionColor = col8;
            final boolean u = level.getTile(x, y - 1) != this;
            final boolean d = level.getTile(x, y + 1) != this;
            final boolean l = level.getTile(x - 1, y) != this;
            final boolean r = level.getTile(x + 1, y) != this;
            final boolean ul = level.getTile(x - 1, y - 1) != this;
            final boolean dl = level.getTile(x - 1, y + 1) != this;
            final boolean ur = level.getTile(x + 1, y - 1) != this;
            final boolean dr = level.getTile(x + 1, y + 1) != this;
            if (!u && !l) {
                if (!ul) {
                    screen.render(x * 16 + 0, y * 16 + 0, 741, col11, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, 711, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 6 : 5) + (u ? 24 : 23) * 32, transitionColor, 3);
            }
            if (!u && !r) {
                if (!ur) {
                    screen.render(x * 16 + 8, y * 16 + 0, 741, col11, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 0, 712, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 4 : 5) + (u ? 24 : 23) * 32, transitionColor, 3);
            }
            if (!d && !l) {
                if (!dl) {
                    screen.render(x * 16 + 0, y * 16 + 8, 741, col11, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 8, 743, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 6 : 5) + (d ? 22 : 23) * 32, transitionColor, 3);
            }
            if (!d && !r) {
                if (!dr) {
                    screen.render(x * 16 + 8, y * 16 + 8, 741, col11, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, 744, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 4 : 5) + (d ? 22 : 23) * 32, transitionColor, 3);
            }
        }
        if (level.dirtColor == 222) {
            final int col11 = col9;
            final int transitionColor = col10;
            final boolean u = level.getTile(x, y - 1) != this;
            final boolean d = level.getTile(x, y + 1) != this;
            final boolean l = level.getTile(x - 1, y) != this;
            final boolean r = level.getTile(x + 1, y) != this;
            final boolean ul = level.getTile(x - 1, y - 1) != this;
            final boolean dl = level.getTile(x - 1, y + 1) != this;
            final boolean ur = level.getTile(x + 1, y - 1) != this;
            final boolean dr = level.getTile(x + 1, y + 1) != this;
            if (!u && !l) {
                if (!ul) {
                    screen.render(x * 16 + 0, y * 16 + 0, 741, col11, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, 711, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 6 : 5) + (u ? 24 : 23) * 32, transitionColor, 3);
            }
            if (!u && !r) {
                if (!ur) {
                    screen.render(x * 16 + 8, y * 16 + 0, 741, col11, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 0, 712, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 4 : 5) + (u ? 24 : 23) * 32, transitionColor, 3);
            }
            if (!d && !l) {
                if (!dl) {
                    screen.render(x * 16 + 0, y * 16 + 8, 741, col11, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 8, 743, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 6 : 5) + (d ? 22 : 23) * 32, transitionColor, 3);
            }
            if (!d && !r) {
                if (!dr) {
                    screen.render(x * 16 + 8, y * 16 + 8, 741, col11, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, 744, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 4 : 5) + (d ? 22 : 23) * 32, transitionColor, 3);
            }
        }
    }
    
    @Override
    public boolean mayPass(final Level level, final int x, final int y, final Entity e) {
        return false;
    }
    
    @Override
    public void hurt(final Level level, final int x, final int y, final Mob source, final int dmg, final int attackDir) {
        this.hurt(level, x, y, dmg);
    }
    
    @Override
    public boolean interact(final Level level, final int xt, final int yt, final Player player, final Item item, final int attackDir) {
        if (item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.axe && player.payStamina(4 - tool.level)) {
                this.hurt(level, xt, yt, this.random.nextInt(10) + tool.level * 5 + 10);
                return true;
            }
        }
        if (item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.hatchet && player.payStamina(4 - tool.level)) {
                this.hurt(level, xt, yt, this.random.nextInt(7) + tool.level * 5 + 5);
                return true;
            }
        }
        return false;
    }
    
    public void hurt(final Level level, final int x, final int y, final int dmg) {
        final int damage = level.getData(x, y) + dmg;
        int wwH;
        if (ModeMenu.creative) {
            wwH = 1;
        }
        else {
            wwH = 5;
        }
        level.add(new SmashParticle(x * 16 + 8, y * 16 + 8));
        level.add(new TextParticle(new StringBuilder().append(dmg).toString(), x * 16 + 8, y * 16 + 8, Color.get(-1, 500, 500, 500)));
        if (damage >= wwH) {
            for (int count = this.random.nextInt(3) + 1, i = 0; i < count; ++i) {
                level.add(new ItemEntity(new ResourceItem(Resource.plank), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
            }
            level.setTile(x, y, Tile.plank, 0);
        }
        else {
            level.setData(x, y, damage);
        }
    }
    
    @Override
    public void tick(final Level level, final int xt, final int yt) {
        final int damage = level.getData(xt, yt);
        if (damage > 0) {
            level.setData(xt, yt, damage - 1);
        }
    }
}
