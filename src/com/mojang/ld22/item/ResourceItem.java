// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.item;

import com.mojang.ld22.Game;
import com.mojang.ld22.item.resource.ItemResource;
import com.mojang.ld22.screen.ModeMenu;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.level.tile.Tile;
import com.mojang.ld22.entity.ItemEntity;
import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.item.resource.Resource;

public class ResourceItem extends Item
{
    public Resource resource;
    public ToolType tool;
    public int count;
    public int counts;
    public int level;
    public int amount;
    
    public ResourceItem(final Resource resource) {
        this.count = 1;
        this.counts = 1;
        this.level = 0;
        this.amount = 1;
        this.resource = resource;
    }
    
    public ResourceItem(final Resource resource, final int count) {
        this.count = 1;
        this.counts = 1;
        this.level = 0;
        this.amount = 1;
        this.resource = resource;
        this.count = count;
    }
    
    public ResourceItem addamount(final int amount) {
        this.amount = amount;
        return this;
    }
    
    public void ToolItem(final ToolType tool, final int level, final int counts) {
        this.tool = tool;
        this.level = level;
        this.counts = counts;
    }
    
    @Override
    public int getColor() {
        return this.resource.color;
    }
    
    @Override
    public int getSprite() {
        return this.resource.sprite;
    }
    
    @Override
    public void renderIcon(final Screen screen, final int x, final int y) {
        screen.render(x, y, this.resource.sprite, this.resource.color, 0);
    }
    
    @Override
    public void renderInventory(final Screen screen, final int x, final int y, final boolean ininv) {
        screen.render(x, y, this.resource.sprite, this.resource.color, 0);
        final String name = this.resource.name;
        if (name.length() > 11 && !ininv) {
            Font.draw(name.substring(0, 11), screen, x + 32, y, Color.get(-1, 555, 555, 555));
        }
        else {
            Font.draw(name, screen, x + 32, y, Color.get(-1, 555, 555, 555));
        }
        int cc = this.count;
        if (cc > 999) {
            cc = 999;
        }
        Font.draw(new StringBuilder().append(cc).toString(), screen, x + 8, y, Color.get(-1, 444, 444, 444));
    }
    
    @Override
    public void renderInventory(final Screen screen, final int x, final int y) {
        screen.render(x, y, this.resource.sprite, this.resource.color, 0);
        final String name = this.resource.name;
        Font.draw(name, screen, x + 32, y, Color.get(-1, 555, 555, 555));
        int cc = this.count;
        if (cc > 999) {
            cc = 999;
        }
        Font.draw(new StringBuilder().append(cc).toString(), screen, x + 8, y, Color.get(-1, 444, 444, 444));
    }
    
    @Override
    public String getName() {
        return this.resource.name;
    }
    
    @Override
    public void onTake(final ItemEntity itemEntity) {
    }
    
    @Override
    public boolean interactOn(final Tile tile, final Level level, final int xt, final int yt, final Player player, final int attackDir) {
        if (this.resource.interactOn(tile, level, xt, yt, player, attackDir)) {
            --this.count;
            if (ModeMenu.creative && this.count <= 0) {
                this.count = 1;
            }
            return true;
        }
        return false;
    }
    
    @Override
    public boolean isDepleted() {
        if (ItemResource.dur == 0 && this.getName() == "Fish Rod") {
            ItemResource.dur = 20;
            --this.count;
            if (this.count == 0) {
                Game.truerod = false;
                return true;
            }
            if (this.count > 0) {
                return false;
            }
        }
        return this.count <= 0;
    }
}
