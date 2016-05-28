// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.crafting;

import com.fossickersdoom.Game;
import com.fossickersdoom.entity.Player;
import com.fossickersdoom.item.resource.Resource;
import com.fossickersdoom.item.ResourceItem;

public class ArrowRecipe extends Recipe
{
    private Resource resource;
    static int number;
    
    static {
        ArrowRecipe.number = 1;
    }
    
    public ArrowRecipe(final Resource resource, final int amount) {
        super(new ResourceItem(resource, ArrowRecipe.number).addamount(amount));
        this.resource = resource;
        ArrowRecipe.number = amount;
    }
    
    @Override
    public void craft(final Player player) {
        Game.ac += ArrowRecipe.number;
    }
}
