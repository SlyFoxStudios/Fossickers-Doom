// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.crafting;

import com.fossickersdoom.entity.Player;
import com.fossickersdoom.item.BucketItem;
import com.fossickersdoom.item.Item;
import com.fossickersdoom.entity.Furniture;

public class ItemRecipe extends Recipe
{
    private Class<? extends Furniture> clazz;
    
    public ItemRecipe(final Class<? extends Item> clazz) throws InstantiationException, IllegalAccessException {
        super(new BucketItem());
    }
    
    @Override
    public void craft(final Player player) {
        try {
            player.inventory.add(0, new BucketItem());
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
