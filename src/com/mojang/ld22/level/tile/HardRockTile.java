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
import com.mojang.ld22.screen.ModeMenu;
import com.mojang.ld22.item.ToolItem;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.entity.Mob;
import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.Game;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.gfx.Screen;

public class HardRockTile extends Tile
{
    public HardRockTile(final int id) {
        super(id);
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        final int col0 = Color.get(445, 334, 223, 223);
        final int col2 = Color.get(1, 334, 445, 322);
        final int col3 = Color.get(445, 334, 223, 223);
        final int col4 = Color.get(1, 334, 445, 321);
        final int col5 = Color.get(334, 334, 223, 223);
        final int col6 = Color.get(1, 334, 445, 211);
        final int col7 = Color.get(223, 223, 112, 112);
        final int col8 = Color.get(1, 223, 332, 100);
        if (Game.Time == 0) {
            final int col9 = col0;
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
                    screen.render(x * 16 + 0, y * 16 + 0, 0, col9, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, 7, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 6 : 5) + (u ? 2 : 1) * 32, transitionColor, 3);
            }
            if (!u && !r) {
                if (!ur) {
                    screen.render(x * 16 + 8, y * 16 + 0, 1, col9, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 0, 8, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 4 : 5) + (u ? 2 : 1) * 32, transitionColor, 3);
            }
            if (!d && !l) {
                if (!dl) {
                    screen.render(x * 16 + 0, y * 16 + 8, 2, col9, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 8, 39, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 6 : 5) + (d ? 0 : 1) * 32, transitionColor, 3);
            }
            if (!d && !r) {
                if (!dr) {
                    screen.render(x * 16 + 8, y * 16 + 8, 3, col9, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, 40, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 4 : 5) + (d ? 0 : 1) * 32, transitionColor, 3);
            }
        }
        if (Game.Time == 1) {
            final int col9 = col3;
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
                    screen.render(x * 16 + 0, y * 16 + 0, 0, col9, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, 7, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 6 : 5) + (u ? 2 : 1) * 32, transitionColor, 3);
            }
            if (!u && !r) {
                if (!ur) {
                    screen.render(x * 16 + 8, y * 16 + 0, 1, col9, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 0, 8, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 4 : 5) + (u ? 2 : 1) * 32, transitionColor, 3);
            }
            if (!d && !l) {
                if (!dl) {
                    screen.render(x * 16 + 0, y * 16 + 8, 2, col9, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 8, 39, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 6 : 5) + (d ? 0 : 1) * 32, transitionColor, 3);
            }
            if (!d && !r) {
                if (!dr) {
                    screen.render(x * 16 + 8, y * 16 + 8, 3, col9, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, 40, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 4 : 5) + (d ? 0 : 1) * 32, transitionColor, 3);
            }
        }
        if (Game.Time == 2) {
            final int col9 = col5;
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
                    screen.render(x * 16 + 0, y * 16 + 0, 0, col9, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, 7, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 6 : 5) + (u ? 2 : 1) * 32, transitionColor, 3);
            }
            if (!u && !r) {
                if (!ur) {
                    screen.render(x * 16 + 8, y * 16 + 0, 1, col9, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 0, 8, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 4 : 5) + (u ? 2 : 1) * 32, transitionColor, 3);
            }
            if (!d && !l) {
                if (!dl) {
                    screen.render(x * 16 + 0, y * 16 + 8, 2, col9, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 8, 39, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 6 : 5) + (d ? 0 : 1) * 32, transitionColor, 3);
            }
            if (!d && !r) {
                if (!dr) {
                    screen.render(x * 16 + 8, y * 16 + 8, 3, col9, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, 40, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 4 : 5) + (d ? 0 : 1) * 32, transitionColor, 3);
            }
        }
        if (Game.Time == 3) {
            final int col9 = col7;
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
                    screen.render(x * 16 + 0, y * 16 + 0, 0, col9, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, 7, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 6 : 5) + (u ? 2 : 1) * 32, transitionColor, 3);
            }
            if (!u && !r) {
                if (!ur) {
                    screen.render(x * 16 + 8, y * 16 + 0, 1, col9, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 0, 8, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 4 : 5) + (u ? 2 : 1) * 32, transitionColor, 3);
            }
            if (!d && !l) {
                if (!dl) {
                    screen.render(x * 16 + 0, y * 16 + 8, 2, col9, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 8, 39, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 6 : 5) + (d ? 0 : 1) * 32, transitionColor, 3);
            }
            if (!d && !r) {
                if (!dr) {
                    screen.render(x * 16 + 8, y * 16 + 8, 3, col9, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, 40, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 4 : 5) + (d ? 0 : 1) * 32, transitionColor, 3);
            }
        }
        if (Game.Time == 0) {
            final int col9 = col0;
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
                    screen.render(x * 16 + 0, y * 16 + 0, 0, col9, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, 7, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, (l ? 6 : 5) + (u ? 2 : 1) * 32, transitionColor, 3);
            }
            if (!u && !r) {
                if (!ur) {
                    screen.render(x * 16 + 8, y * 16 + 0, 1, col9, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 0, 8, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, (r ? 4 : 5) + (u ? 2 : 1) * 32, transitionColor, 3);
            }
            if (!d && !l) {
                if (!dl) {
                    screen.render(x * 16 + 0, y * 16 + 8, 2, col9, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 8, 39, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, (l ? 6 : 5) + (d ? 0 : 1) * 32, transitionColor, 3);
            }
            if (!d && !r) {
                if (!dr) {
                    screen.render(x * 16 + 8, y * 16 + 8, 3, col9, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, 40, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 4 : 5) + (d ? 0 : 1) * 32, transitionColor, 3);
            }
        }
    }
    
    @Override
    public boolean mayPass(final Level level, final int x, final int y, final Entity e) {
        return false;
    }
    
    @Override
    public void hurt(final Level level, final int x, final int y, final Mob source, final int dmg, final int attackDir) {
        this.hurt(level, x, y, 0);
    }
    
    @Override
    public boolean interact(final Level level, final int xt, final int yt, final Player player, final Item item, final int attackDir) {
        if (item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (ModeMenu.creative) {
                return true;
            }
            if (tool.type == ToolType.pickaxe && tool.level == 4 && player.payStamina(4 - tool.level)) {
                this.hurt(level, xt, yt, this.random.nextInt(10) + tool.level * 5 + 10);
                return true;
            }
        }
        return ModeMenu.creative;
    }
    
    public void hurt(final Level level, final int x, final int y, final int dmg) {
        final int damage = level.getData(x, y) + dmg;
        level.add(new SmashParticle(x * 16 + 8, y * 16 + 8));
        level.add(new TextParticle(new StringBuilder().append(dmg).toString(), x * 16 + 8, y * 16 + 8, Color.get(-1, 500, 500, 500)));
        int hrHealth;
        if (ModeMenu.creative) {
            hrHealth = 0;
        }
        else {
            hrHealth = 200;
        }
        if (damage >= hrHealth) {
            for (int count = this.random.nextInt(4) + 1, i = 0; i < count; ++i) {
                level.add(new ItemEntity(new ResourceItem(Resource.stone), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
            }
            for (int count = this.random.nextInt(2), i = 0; i < count; ++i) {
                level.add(new ItemEntity(new ResourceItem(Resource.coal), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
            }
            level.setTile(x, y, Tile.dirt, 0);
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
