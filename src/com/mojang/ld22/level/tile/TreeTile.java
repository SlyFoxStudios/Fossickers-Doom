// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.level.tile;

import com.mojang.ld22.entity.particle.TextParticle;
import com.mojang.ld22.entity.particle.SmashParticle;
import com.mojang.ld22.screen.ModeMenu;
import com.mojang.ld22.entity.ItemEntity;
import com.mojang.ld22.item.ResourceItem;
import com.mojang.ld22.item.resource.Resource;
import com.mojang.ld22.item.ToolType;
import com.mojang.ld22.item.ToolItem;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.entity.Mob;
import com.mojang.ld22.entity.AirWizard;
import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.Game;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.gfx.Color;

public class TreeTile extends Tile
{
    public static int col0;
    public static int col00;
    public static int col000;
    public static int col1;
    public static int col11;
    public static int col111;
    public static int col2;
    public static int col22;
    public static int col222;
    public static int col3;
    public static int col33;
    public static int col333;
    
    static {
        TreeTile.col0 = Color.get(10, 20, 151, 131);
        TreeTile.col00 = Color.get(10, 20, 320, 131);
        TreeTile.col000 = Color.get(10, 20, 320, 131);
        TreeTile.col1 = Color.get(10, 30, 151, 141);
        TreeTile.col11 = Color.get(10, 30, 430, 141);
        TreeTile.col111 = Color.get(10, 30, 320, 141);
        TreeTile.col2 = Color.get(10, 20, 151, 30);
        TreeTile.col22 = Color.get(10, 20, 320, 30);
        TreeTile.col222 = Color.get(10, 20, 210, 30);
        TreeTile.col3 = Color.get(0, 10, 30, 20);
        TreeTile.col33 = Color.get(0, 10, 100, 20);
        TreeTile.col333 = Color.get(0, 10, 100, 20);
    }
    
    public TreeTile(final int id) {
        super(id);
        this.connectsToGrass = true;
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        if (level.depth == 0) {
            if (Game.Time == 0) {
                final int col = TreeTile.col0;
                final int barkCol1 = TreeTile.col00;
                final int barkCol2 = TreeTile.col000;
                final boolean u = level.getTile(x, y - 1) == this;
                final boolean l = level.getTile(x - 1, y) == this;
                final boolean r = level.getTile(x + 1, y) == this;
                final boolean d = level.getTile(x, y + 1) == this;
                final boolean ul = level.getTile(x - 1, y - 1) == this;
                final boolean ur = level.getTile(x + 1, y - 1) == this;
                final boolean dl = level.getTile(x - 1, y + 1) == this;
                final boolean dr = level.getTile(x + 1, y + 1) == this;
                if (u && ul && l) {
                    screen.render(x * 16 + 0, y * 16 + 0, 42, col, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, 9, col, 0);
                }
                if (u && ur && r) {
                    screen.render(x * 16 + 8, y * 16 + 0, 74, barkCol2, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 0, 10, col, 0);
                }
                if (d && dl && l) {
                    screen.render(x * 16 + 0, y * 16 + 8, 74, barkCol2, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 8, 41, barkCol1, 0);
                }
                if (d && dr && r) {
                    screen.render(x * 16 + 8, y * 16 + 8, 42, col, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, 106, barkCol2, 0);
                }
            }
            else if (Game.Time == 2) {
                final int col = TreeTile.col2;
                final int barkCol1 = TreeTile.col22;
                final int barkCol2 = TreeTile.col222;
                final boolean u = level.getTile(x, y - 1) == this;
                final boolean l = level.getTile(x - 1, y) == this;
                final boolean r = level.getTile(x + 1, y) == this;
                final boolean d = level.getTile(x, y + 1) == this;
                final boolean ul = level.getTile(x - 1, y - 1) == this;
                final boolean ur = level.getTile(x + 1, y - 1) == this;
                final boolean dl = level.getTile(x - 1, y + 1) == this;
                final boolean dr = level.getTile(x + 1, y + 1) == this;
                if (u && ul && l) {
                    screen.render(x * 16 + 0, y * 16 + 0, 42, col, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, 9, col, 0);
                }
                if (u && ur && r) {
                    screen.render(x * 16 + 8, y * 16 + 0, 74, barkCol2, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 0, 10, col, 0);
                }
                if (d && dl && l) {
                    screen.render(x * 16 + 0, y * 16 + 8, 74, barkCol2, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 8, 41, barkCol1, 0);
                }
                if (d && dr && r) {
                    screen.render(x * 16 + 8, y * 16 + 8, 42, col, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, 106, barkCol2, 0);
                }
            }
            else if (Game.Time == 1) {
                final int col = TreeTile.col1;
                final int barkCol1 = TreeTile.col11;
                final int barkCol2 = TreeTile.col111;
                final boolean u = level.getTile(x, y - 1) == this;
                final boolean l = level.getTile(x - 1, y) == this;
                final boolean r = level.getTile(x + 1, y) == this;
                final boolean d = level.getTile(x, y + 1) == this;
                final boolean ul = level.getTile(x - 1, y - 1) == this;
                final boolean ur = level.getTile(x + 1, y - 1) == this;
                final boolean dl = level.getTile(x - 1, y + 1) == this;
                final boolean dr = level.getTile(x + 1, y + 1) == this;
                if (u && ul && l) {
                    screen.render(x * 16 + 0, y * 16 + 0, 42, col, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, 9, col, 0);
                }
                if (u && ur && r) {
                    screen.render(x * 16 + 8, y * 16 + 0, 74, barkCol2, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 0, 10, col, 0);
                }
                if (d && dl && l) {
                    screen.render(x * 16 + 0, y * 16 + 8, 74, barkCol2, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 8, 41, barkCol1, 0);
                }
                if (d && dr && r) {
                    screen.render(x * 16 + 8, y * 16 + 8, 42, col, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, 106, barkCol2, 0);
                }
            }
            else if (Game.Time == 3) {
                final int col = TreeTile.col3;
                final int barkCol1 = TreeTile.col33;
                final int barkCol2 = TreeTile.col333;
                final boolean u = level.getTile(x, y - 1) == this;
                final boolean l = level.getTile(x - 1, y) == this;
                final boolean r = level.getTile(x + 1, y) == this;
                final boolean d = level.getTile(x, y + 1) == this;
                final boolean ul = level.getTile(x - 1, y - 1) == this;
                final boolean ur = level.getTile(x + 1, y - 1) == this;
                final boolean dl = level.getTile(x - 1, y + 1) == this;
                final boolean dr = level.getTile(x + 1, y + 1) == this;
                if (u && ul && l) {
                    screen.render(x * 16 + 0, y * 16 + 0, 42, col, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 0, 9, col, 0);
                }
                if (u && ur && r) {
                    screen.render(x * 16 + 8, y * 16 + 0, 74, barkCol2, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 0, 10, col, 0);
                }
                if (d && dl && l) {
                    screen.render(x * 16 + 0, y * 16 + 8, 74, barkCol2, 0);
                }
                else {
                    screen.render(x * 16 + 0, y * 16 + 8, 41, barkCol1, 0);
                }
                if (d && dr && r) {
                    screen.render(x * 16 + 8, y * 16 + 8, 42, col, 0);
                }
                else {
                    screen.render(x * 16 + 8, y * 16 + 8, 106, barkCol2, 0);
                }
            }
        }
        else {
            final int col = TreeTile.col1;
            final int barkCol1 = TreeTile.col11;
            final int barkCol2 = TreeTile.col111;
            final boolean u = level.getTile(x, y - 1) == this;
            final boolean l = level.getTile(x - 1, y) == this;
            final boolean r = level.getTile(x + 1, y) == this;
            final boolean d = level.getTile(x, y + 1) == this;
            final boolean ul = level.getTile(x - 1, y - 1) == this;
            final boolean ur = level.getTile(x + 1, y - 1) == this;
            final boolean dl = level.getTile(x - 1, y + 1) == this;
            final boolean dr = level.getTile(x + 1, y + 1) == this;
            if (u && ul && l) {
                screen.render(x * 16 + 0, y * 16 + 0, 42, col, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 0, 9, col, 0);
            }
            if (u && ur && r) {
                screen.render(x * 16 + 8, y * 16 + 0, 74, barkCol2, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 0, 10, col, 0);
            }
            if (d && dl && l) {
                screen.render(x * 16 + 0, y * 16 + 8, 74, barkCol2, 0);
            }
            else {
                screen.render(x * 16 + 0, y * 16 + 8, 41, barkCol1, 0);
            }
            if (d && dr && r) {
                screen.render(x * 16 + 8, y * 16 + 8, 42, col, 0);
            }
            else {
                screen.render(x * 16 + 8, y * 16 + 8, 106, barkCol2, 0);
            }
        }
    }
    
    @Override
    public void tick(final Level level, final int xt, final int yt) {
        final int damage = level.getData(xt, yt);
        if (damage > 0) {
            level.setData(xt, yt, damage - 1);
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
        this.hurt(level, x, y, dmg);
    }
    
    @Override
    public boolean interact(final Level level, final int xt, final int yt, final Player player, final Item item, final int attackDir) {
        int bonus = 0;
        if (player.haste) {
            bonus = 1;
        }
        if (item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.axe && player.payStamina(4 - bonus - tool.level)) {
                if (player.haste) {
                    this.hurt(level, xt, yt, this.random.nextInt(10) + tool.level * 5 + (10 + this.random.nextInt(5)));
                }
                else {
                    this.hurt(level, xt, yt, this.random.nextInt(10) + tool.level * 5 + 10);
                }
                return true;
            }
            if (tool.type == ToolType.hatchet && player.payStamina(3 - bonus - tool.level)) {
                if (player.haste) {
                    this.hurt(level, xt, yt, this.random.nextInt(7) + tool.level * 5 + (5 + this.random.nextInt(5)));
                }
                else {
                    this.hurt(level, xt, yt, this.random.nextInt(7) + tool.level * 5 + 5);
                }
                return true;
            }
        }
        return false;
    }
    
    private void hurt(final Level level, final int x, final int y, int dmg) {
        for (int count = (this.random.nextInt(100) == 0) ? 1 : 0, i = 0; i < count; ++i) {
            level.add(new ItemEntity(new ResourceItem(Resource.apple), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
        }
        if (level.player.haste) {
            dmg += this.random.nextInt(3);
        }
        final int damage = level.getData(x, y) + dmg;
        int treeHealth;
        if (ModeMenu.creative) {
            treeHealth = 1;
        }
        else {
            treeHealth = 20;
        }
        level.add(new SmashParticle(x * 16 + 8, y * 16 + 8));
        level.add(new TextParticle(new StringBuilder().append(dmg).toString(), x * 16 + 8, y * 16 + 8, Color.get(-1, 500, 500, 500)));
        if (damage >= treeHealth) {
            for (int count2 = this.random.nextInt(2) + 1, j = 0; j < count2; ++j) {
                level.add(new ItemEntity(new ResourceItem(Resource.wood), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
            }
            for (int count2 = this.random.nextInt(this.random.nextInt(4) + 1), j = 0; j < count2; ++j) {
                level.add(new ItemEntity(new ResourceItem(Resource.acorn), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
            }
            level.setTile(x, y, Tile.grass, 0);
        }
        else {
            level.setData(x, y, damage);
        }
    }
}
