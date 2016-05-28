// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.crafting;

import com.fossickersdoom.entity.Player;
import com.fossickersdoom.item.FurnitureItem;
import com.fossickersdoom.entity.Furniture;

public class FurnitureRecipe extends Recipe
{
    private Class<? extends Furniture> clazz;
    
    public FurnitureRecipe(final Class<? extends Furniture> clazz) throws InstantiationException, IllegalAccessException {
        super(new FurnitureItem((Furniture)clazz.newInstance()));
        this.clazz = clazz;
    }
    
    @Override
    public void craft(final Player player) {
        try {
            player.inventory.add(0, new FurnitureItem((Furniture)this.clazz.newInstance()));
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
