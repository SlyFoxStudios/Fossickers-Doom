// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.crafting;

import com.mojang.ld22.entity.Player;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.item.ResourceItem;
import com.mojang.ld22.item.resource.Resource;

public class ResourceRecipe extends Recipe
{
    private Resource resource;
    static int number;
    
    static {
        ResourceRecipe.number = 1;
    }
    
    public ResourceRecipe(final Resource resource) {
        super(new ResourceItem(resource, ResourceRecipe.number));
        this.resource = resource;
    }
    
    public static int more(final Resource resource) {
        if (resource.name == "string") {
            ResourceRecipe.number = 2;
        }
        if (resource.name == "Torch") {
            ResourceRecipe.number = 2;
        }
        if (resource.name == "Plank") {
            ResourceRecipe.number = 2;
        }
        if (resource.name == "St.Brick") {
            ResourceRecipe.number = 2;
        }
        if (resource.name != "string" && resource.name != "Torch" && resource.name != "Plank" && resource.name != "St.Brick") {
            ResourceRecipe.number = 1;
        }
        return ResourceRecipe.number;
    }
    
    @Override
    public void craft(final Player player) {
        more(this.resource);
        player.inventory.add(0, new ResourceItem(this.resource, ResourceRecipe.number));
    }
}
