// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.crafting;

import com.mojang.ld22.Game;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.item.ResourceItem;
import com.mojang.ld22.item.resource.Resource;

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
