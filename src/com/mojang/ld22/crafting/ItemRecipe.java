// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.crafting;

import com.mojang.ld22.entity.Player;
import com.mojang.ld22.item.BucketItem;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.entity.Furniture;

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
