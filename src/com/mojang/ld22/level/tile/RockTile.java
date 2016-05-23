// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.level.tile;

import com.mojang.ld22.entity.ItemEntity;
import com.mojang.ld22.item.ResourceItem;
import com.mojang.ld22.item.resource.Resource;
import com.mojang.ld22.entity.particle.TextParticle;
import com.mojang.ld22.entity.particle.SmashParticle;
import com.mojang.ld22.screen.ModeMenu;
import com.mojang.ld22.item.ToolType;
import com.mojang.ld22.item.ToolItem;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.entity.Mob;
import com.mojang.ld22.entity.AirWizard;
import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.Game;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.gfx.Screen;

public class RockTile extends Tile
{
    int coallvl;
    
    public RockTile(final int id) {
        super(id);
        this.coallvl = 1;
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        final int col0 = Color.get(444, 333, 222, 222);
        final int col2 = Color.get(111, 333, 444, 322);
        final int col3 = Color.get(444, 444, 333, 333);
        final int col4 = Color.get(111, 444, 555, 321);
        final int col5 = Color.get(333, 333, 222, 222);
        final int col6 = Color.get(111, 333, 444, 211);
        final int col7 = Color.get(222, 222, 111, 111);
        final int col8 = Color.get(0, 222, 333, 100);
        final int col9 = Color.get(444, 444, 333, 333);
        final int col10 = Color.get(111, 444, 555, 222);
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
                    screen.render(x * 16 + 0, y * 16 + 0, 0, col11, 0);
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
                    screen.render(x * 16 + 8, y * 16 + 0, 1, col11, 0);
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
                    screen.render(x * 16 + 0, y * 16 + 8, 2, col11, 0);
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
                    screen.render(x * 16 + 8, y * 16 + 8, 3, col11, 0);
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
                    screen.render(x * 16 + 0, y * 16 + 0, 0, col11, 0);
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
                    screen.render(x * 16 + 8, y * 16 + 0, 1, col11, 0);
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
                    screen.render(x * 16 + 0, y * 16 + 8, 2, col11, 0);
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
                    screen.render(x * 16 + 8, y * 16 + 8, 3, col11, 0);
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
                    screen.render(x * 16 + 0, y * 16 + 0, 0, col11, 0);
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
                    screen.render(x * 16 + 8, y * 16 + 0, 1, col11, 0);
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
                    screen.render(x * 16 + 0, y * 16 + 8, 2, col11, 0);
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
                    screen.render(x * 16 + 8, y * 16 + 8, 3, col11, 0);
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
                    screen.render(x * 16 + 0, y * 16 + 0, 0, col11, 0);
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
                    screen.render(x * 16 + 8, y * 16 + 0, 1, col11, 0);
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
                    screen.render(x * 16 + 0, y * 16 + 8, 2, col11, 0);
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
                    screen.render(x * 16 + 8, y * 16 + 8, 3, col11, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, 40, transitionColor, 3);
                }
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, (r ? 4 : 5) + (d ? 0 : 1) * 32, transitionColor, 3);
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
                    screen.render(x * 16 + 0, y * 16 + 0, 0, col11, 0);
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
                    screen.render(x * 16 + 8, y * 16 + 0, 1, col11, 0);
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
                    screen.render(x * 16 + 0, y * 16 + 8, 2, col11, 0);
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
                    screen.render(x * 16 + 8, y * 16 + 8, 3, col11, 0);
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
        if (e instanceof AirWizard) {
            final AirWizard aw = (AirWizard)e;
            if (aw.secondform) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void hurt(final Level level, final int x, final int y, final Mob source, final int dmg, final int attackDir) {
        this.hurt(level, x, y, 1);
    }
    
    @Override
    public boolean interact(final Level level, final int xt, final int yt, final Player player, final Item item, final int attackDir) {
        int bonus = 0;
        int bonus2 = 0;
        if (player.haste) {
            bonus = 1;
            bonus2 = this.random.nextInt(5);
        }
        if (item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.pickaxe && player.payStamina(4 - bonus - tool.level)) {
                this.hurt(level, xt, yt, this.random.nextInt(10) + tool.level * 5 + (10 + bonus2));
                this.coallvl = 0;
                return true;
            }
        }
        if (item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.pick && player.payStamina(3 - bonus - tool.level)) {
                this.hurt(level, xt, yt, this.random.nextInt(7) + tool.level * 5 + (10 + bonus2));
                this.coallvl = 1;
                return true;
            }
        }
        return false;
    }
    
    public void hurt(final Level level, final int x, final int y, int dmg) {
        int rockHealth;
        if (ModeMenu.creative) {
            rockHealth = 1;
        }
        else {
            rockHealth = 50;
        }
        if (level.player.haste) {
            dmg += this.random.nextInt(3);
        }
        final int damage = level.getData(x, y) + dmg;
        level.add(new SmashParticle(x * 16 + 8, y * 16 + 8));
        level.add(new TextParticle(new StringBuilder().append(dmg).toString(), x * 16 + 8, y * 16 + 8, Color.get(-1, 500, 500, 500)));
        if (damage >= rockHealth) {
            int count = this.random.nextInt(1);
            if (this.coallvl == 0) {
                count = this.random.nextInt(4) + 1;
                for (int i = 0; i < count; ++i) {
                    level.add(new ItemEntity(new ResourceItem(Resource.stone), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
                }
            }
            if (this.coallvl == 0) {
                count = this.random.nextInt(3);
                for (int i = 0; i < count; ++i) {
                    level.add(new ItemEntity(new ResourceItem(Resource.coal), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
                }
            }
            if (this.coallvl == 1) {
                count = this.random.nextInt(2) + 1;
                for (int i = 0; i < count; ++i) {
                    level.add(new ItemEntity(new ResourceItem(Resource.stone), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
                }
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
