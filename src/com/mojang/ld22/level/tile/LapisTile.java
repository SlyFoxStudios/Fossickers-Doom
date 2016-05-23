// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.level.tile;

import com.mojang.ld22.entity.ItemEntity;
import com.mojang.ld22.item.ResourceItem;
import com.mojang.ld22.entity.particle.TextParticle;
import com.mojang.ld22.entity.particle.SmashParticle;
import com.mojang.ld22.item.ToolType;
import com.mojang.ld22.item.ToolItem;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.screen.ModeMenu;
import com.mojang.ld22.entity.Mob;
import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.item.resource.Resource;

public class LapisTile extends Tile
{
    private Resource toDrop;
    private int color;
    
    public LapisTile(final int id, final Resource toDrop) {
        super(id);
        this.toDrop = toDrop;
        this.color = (toDrop.color & 0xFFFF00);
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        screen.render(x * 16 + 0, y * 16 + 0, 49, this.color = (this.toDrop.color & 0xFFFFFF00) + Color.get(level.dirtColor), 0);
        screen.render(x * 16 + 8, y * 16 + 0, 50, this.color, 0);
        screen.render(x * 16 + 0, y * 16 + 8, 81, this.color, 0);
        screen.render(x * 16 + 8, y * 16 + 8, 82, this.color, 0);
    }
    
    @Override
    public boolean mayPass(final Level level, final int x, final int y, final Entity e) {
        return false;
    }
    
    @Override
    public void hurt(final Level level, final int x, final int y, final Mob source, final int dmg, final int attackDir) {
        int playDmg;
        if (ModeMenu.creative) {
            playDmg = this.random.nextInt(4);
        }
        else {
            playDmg = 0;
        }
        this.hurt(level, x, y, playDmg);
    }
    
    @Override
    public boolean interact(final Level level, final int xt, final int yt, final Player player, final Item item, final int attackDir) {
        if (ModeMenu.creative) {
            this.hurt(level, xt, yt, 5);
        }
        else if (item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.pickaxe && player.payStamina(2)) {
                this.hurt(level, xt, yt, 0);
                return true;
            }
        }
        return false;
    }
    
    public void hurt(final Level level, final int x, final int y, final int dmg) {
        final int damage = level.getData(x, y) + 1;
        level.add(new SmashParticle(x * 16 + 8, y * 16 + 8));
        level.add(new TextParticle(new StringBuilder().append(dmg).toString(), x * 16 + 8, y * 16 + 8, Color.get(-1, 5, 115, 115)));
        int lapHealth;
        if (ModeMenu.creative) {
            lapHealth = 1;
            final int mxD = -1;
        }
        else {
            lapHealth = this.random.nextInt(10) + 3;
            final int mxD = 1;
        }
        if (dmg > 0) {
            int count = this.random.nextInt(2) + 2;
            if (damage >= lapHealth) {
                level.setTile(x, y, Tile.dirt, 0);
                count += 2;
            }
            else {
                level.setData(x, y, damage);
            }
            for (int i = 0; i < count; ++i) {
                level.add(new ItemEntity(new ResourceItem(this.toDrop), x * 16 + this.random.nextInt(10) + 3, y * 16 + this.random.nextInt(10) + 3));
            }
        }
    }
    
    @Override
    public void bumpedInto(final Level level, final int x, final int y, final Entity entity) {
        entity.hurt(this, x, y, 0);
    }
}
