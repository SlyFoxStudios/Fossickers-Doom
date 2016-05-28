// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.item;

import com.fossickersdoom.entity.ItemEntity;
import com.fossickersdoom.level.tile.Tile;
import com.fossickersdoom.screen.ListItem;
import com.fossickersdoom.level.Level;
import com.fossickersdoom.entity.Entity;
import com.fossickersdoom.entity.Player;
import com.fossickersdoom.gfx.Screen;

public class Item implements ListItem
{
    public Item addItem() {
        if (!ListItems.items.contains(this)) {
            ListItems.items.add(this);
        }
        return this;
    }
    
    public int getColor() {
        return 0;
    }
    
    public int getSprite() {
        return 0;
    }
    
    public void onTake(final ItemEntity itemEntity) {
    }
    
    @Override
    public void renderInventory(final Screen screen, final int x, final int y) {
    }
    
    public void renderInventory(final Screen screen, final int x, final int y, final boolean isinv) {
    }
    
    public boolean interact(final Player player, final Entity entity, final int attackDir) {
        return false;
    }
    
    public void renderIcon(final Screen screen, final int x, final int y) {
    }
    
    public boolean interactOn(final Tile tile, final Level level, final int xt, final int yt, final Player player, final int attackDir) {
        return false;
    }
    
    public boolean isDepleted() {
        return false;
    }
    
    public boolean canAttack() {
        return false;
    }
    
    public int getAttackDamageBonus(final Entity e) {
        return 0;
    }
    
    public String getName() {
        return "";
    }
    
    public boolean matches(final Item item) {
        return item.getClass() == this.getClass();
    }
}
