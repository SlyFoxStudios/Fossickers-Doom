// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.level.tile;

import com.mojang.ld22.entity.ItemEntity;
import com.mojang.ld22.item.ResourceItem;
import com.mojang.ld22.item.resource.Resource;
import com.mojang.ld22.entity.particle.TextParticle;
import com.mojang.ld22.entity.particle.SmashParticle;
import com.mojang.ld22.item.ToolType;
import com.mojang.ld22.item.ToolItem;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.screen.ModeMenu;
import com.mojang.ld22.entity.Mob;
import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.Game;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.gfx.Screen;

public class StoneWallTile extends Tile
{
    public StoneWallTile(final int id) {
        super(id);
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        final int col0 = Color.get(333, 333, 333, 333);
        final int col2 = Color.get(111, 222, 333, 333);
        final int col3 = Color.get(111, 333, 333, 333);
        final int col4 = Color.get(444, 444, 444, 444);
        final int col5 = Color.get(111, 333, 444, 444);
        final int col6 = Color.get(111, 444, 444, 444);
        final int col7 = Color.get(333, 333, 333, 333);
        final int col8 = Color.get(111, 222, 333, 333);
        final int col9 = Color.get(111, 333, 333, 333);
        final int col10 = Color.get(222, 222, 222, 222);
        final int col11 = Color.get(0, 111, 222, 222);
        final int col12 = Color.get(0, 222, 222, 222);
        final int col13 = Color.get(444, 444, 444, 444);
        final int col14 = Color.get(111, 333, 444, 444);
        final int col15 = Color.get(111, 444, 444, 444);
        if (level.dirtColor == 322) {
            if (Game.Time == 0) {
                final int col16 = col0;
                final int transitionColor = col2;
                final int backColor = col3;
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
                        screen.render(x * 16 + 0, y * 16 + 0, 71, col16, 0);
                    }
                    else {
                        screen.render(x * 16 + 0, y * 16 + 0, 775, backColor, 3);
                    }
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, (l ? 6 : 5) + (u ? 27 : 26) * 32, transitionColor, 3);
                }
                if (!u && !r) {
                    if (!ur) {
                        screen.render(x * 16 + 8, y * 16 + 0, 71, col16, 0);
                    }
                    else {
                        screen.render(x * 16 + 8, y * 16 + 0, 776, backColor, 3);
                    }
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 0, (r ? 4 : 5) + (u ? 27 : 26) * 32, transitionColor, 3);
                }
                if (!d && !l) {
                    if (!dl) {
                        screen.render(x * 16 + 0, y * 16 + 8, 71, col16, 0);
                    }
                    else {
                        screen.render(x * 16 + 0, y * 16 + 8, 807, backColor, 3);
                    }
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 8, (l ? 6 : 5) + (d ? 25 : 26) * 32, transitionColor, 3);
                }
                if (!d && !r) {
                    if (!dr) {
                        screen.render(x * 16 + 8, y * 16 + 8, 71, col16, 0);
                    }
                    else {
                        screen.render(x * 16 + 8, y * 16 + 8, 808, backColor, 3);
                    }
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, (r ? 4 : 5) + (d ? 25 : 26) * 32, transitionColor, 3);
                }
            }
            if (Game.Time == 1) {
                final int col16 = col4;
                final int transitionColor = col5;
                final int backColor = col6;
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
                        screen.render(x * 16 + 0, y * 16 + 0, 71, col16, 0);
                    }
                    else {
                        screen.render(x * 16 + 0, y * 16 + 0, 775, backColor, 3);
                    }
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, (l ? 6 : 5) + (u ? 27 : 26) * 32, transitionColor, 3);
                }
                if (!u && !r) {
                    if (!ur) {
                        screen.render(x * 16 + 8, y * 16 + 0, 71, col16, 0);
                    }
                    else {
                        screen.render(x * 16 + 8, y * 16 + 0, 776, backColor, 3);
                    }
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 0, (r ? 4 : 5) + (u ? 27 : 26) * 32, transitionColor, 3);
                }
                if (!d && !l) {
                    if (!dl) {
                        screen.render(x * 16 + 0, y * 16 + 8, 71, col16, 0);
                    }
                    else {
                        screen.render(x * 16 + 0, y * 16 + 8, 807, backColor, 3);
                    }
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 8, (l ? 6 : 5) + (d ? 25 : 26) * 32, transitionColor, 3);
                }
                if (!d && !r) {
                    if (!dr) {
                        screen.render(x * 16 + 8, y * 16 + 8, 71, col16, 0);
                    }
                    else {
                        screen.render(x * 16 + 8, y * 16 + 8, 808, backColor, 3);
                    }
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, (r ? 4 : 5) + (d ? 25 : 26) * 32, transitionColor, 3);
                }
            }
            if (Game.Time == 2) {
                final int col16 = col7;
                final int transitionColor = col8;
                final int backColor = col9;
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
                        screen.render(x * 16 + 0, y * 16 + 0, 71, col16, 0);
                    }
                    else {
                        screen.render(x * 16 + 0, y * 16 + 0, 775, backColor, 3);
                    }
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, (l ? 6 : 5) + (u ? 27 : 26) * 32, transitionColor, 3);
                }
                if (!u && !r) {
                    if (!ur) {
                        screen.render(x * 16 + 8, y * 16 + 0, 71, col16, 0);
                    }
                    else {
                        screen.render(x * 16 + 8, y * 16 + 0, 776, backColor, 3);
                    }
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 0, (r ? 4 : 5) + (u ? 27 : 26) * 32, transitionColor, 3);
                }
                if (!d && !l) {
                    if (!dl) {
                        screen.render(x * 16 + 0, y * 16 + 8, 71, col16, 0);
                    }
                    else {
                        screen.render(x * 16 + 0, y * 16 + 8, 807, backColor, 3);
                    }
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 8, (l ? 6 : 5) + (d ? 25 : 26) * 32, transitionColor, 3);
                }
                if (!d && !r) {
                    if (!dr) {
                        screen.render(x * 16 + 8, y * 16 + 8, 71, col16, 0);
                    }
                    else {
                        screen.render(x * 16 + 8, y * 16 + 8, 808, backColor, 3);
                    }
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, (r ? 4 : 5) + (d ? 25 : 26) * 32, transitionColor, 3);
                }
            }
            if (Game.Time == 3) {
                final int col16 = col10;
                final int transitionColor = col11;
                final int backColor = col12;
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
                        screen.render(x * 16 + 0, y * 16 + 0, 71, col16, 0);
                    }
                    else {
                        screen.render(x * 16 + 0, y * 16 + 0, 775, backColor, 3);
                    }
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, (l ? 6 : 5) + (u ? 27 : 26) * 32, transitionColor, 3);
                }
                if (!u && !r) {
                    if (!ur) {
                        screen.render(x * 16 + 8, y * 16 + 0, 71, col16, 0);
                    }
                    else {
                        screen.render(x * 16 + 8, y * 16 + 0, 776, backColor, 3);
                    }
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 0, (r ? 4 : 5) + (u ? 27 : 26) * 32, transitionColor, 3);
                }
                if (!d && !l) {
                    if (!dl) {
                        screen.render(x * 16 + 0, y * 16 + 8, 71, col16, 0);
                    }
                    else {
                        screen.render(x * 16 + 0, y * 16 + 8, 807, backColor, 3);
                    }
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 8, (l ? 6 : 5) + (d ? 25 : 26) * 32, transitionColor, 3);
                }
                if (!d && !r) {
                    if (!dr) {
                        screen.render(x * 16 + 8, y * 16 + 8, 71, col16, 0);
                    }
                    else {
                        screen.render(x * 16 + 8, y * 16 + 8, 808, backColor, 3);
                    }
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, (r ? 4 : 5) + (d ? 25 : 26) * 32, transitionColor, 3);
                }
            }
        }
        if (level.dirtColor == 222) {
            final int col16 = col13;
            final int transitionColor = col14;
            final int backColor = col15;
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
                    screen.render(x * 16 + 0, y * 16 + 0, 71, col16, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, 775, backColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 6 : 5) + (u ? 27 : 26) * 32, transitionColor, 3);
            }
            if (!u && !r) {
                if (!ur) {
                    screen.render(x * 16 + 8, y * 16 + 0, 71, col16, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 0, 776, backColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 4 : 5) + (u ? 27 : 26) * 32, transitionColor, 3);
            }
            if (!d && !l) {
                if (!dl) {
                    screen.render(x * 16 + 0, y * 16 + 8, 71, col16, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 8, 807, backColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 6 : 5) + (d ? 25 : 26) * 32, transitionColor, 3);
            }
            if (!d && !r) {
                if (!dr) {
                    screen.render(x * 16 + 8, y * 16 + 8, 71, col16, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, 808, backColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 4 : 5) + (d ? 25 : 26) * 32, transitionColor, 3);
            }
        }
    }
    
    @Override
    public boolean mayPass(final Level level, final int x, final int y, final Entity e) {
        return false;
    }
    
    @Override
    public void hurt(final Level level, final int x, final int y, final Mob source, final int dmg, final int attackDir) {
        int playDmg;
        if (ModeMenu.creative) {
            playDmg = this.random.nextInt(5);
        }
        else {
            playDmg = 0;
        }
        this.hurt(level, x, y, playDmg);
    }
    
    @Override
    public boolean interact(final Level level, final int xt, final int yt, final Player player, final Item item, final int attackDir) {
        if (item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.pickaxe && player.payStamina(4 - tool.level)) {
                this.hurt(level, xt, yt, this.random.nextInt(10) + tool.level * 5 + 10);
                return true;
            }
        }
        if (item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.pick && player.payStamina(4 - tool.level)) {
                this.hurt(level, xt, yt, this.random.nextInt(6) + tool.level * 5 + 5);
                return true;
            }
        }
        return false;
    }
    
    public void hurt(final Level level, final int x, final int y, final int dmg) {
        final int damage = level.getData(x, y) + dmg;
        int sbwHealth;
        if (ModeMenu.creative) {
            sbwHealth = 1;
        }
        else {
            sbwHealth = 100;
        }
        level.add(new SmashParticle(x * 16 + 8, y * 16 + 8));
        level.add(new TextParticle(new StringBuilder().append(dmg).toString(), x * 16 + 8, y * 16 + 8, Color.get(-1, 500, 500, 500)));
        if (damage >= sbwHealth) {
            for (int count = this.random.nextInt(3) + 1, i = 0; i < count; ++i) {
                level.add(new ItemEntity(new ResourceItem(Resource.sbrick), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
            }
            level.setTile(x, y, Tile.sbrick, 0);
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
