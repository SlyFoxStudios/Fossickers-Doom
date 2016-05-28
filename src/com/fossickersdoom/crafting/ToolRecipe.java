// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.crafting;

import com.fossickersdoom.entity.Player;
import com.fossickersdoom.item.ToolItem;
import com.fossickersdoom.item.ToolType;

public class ToolRecipe extends Recipe
{
    private ToolType type;
    private int level;
    
    public ToolRecipe(final ToolType type, final int level) {
        super(new ToolItem(type, level));
        this.type = type;
        this.level = level;
    }
    
    @Override
    public void craft(final Player player) {
        player.inventory.add(0, new ToolItem(this.type, this.level));
    }
}
