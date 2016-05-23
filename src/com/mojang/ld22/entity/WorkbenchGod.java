// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.entity;

import com.mojang.ld22.screen.Menu;
import com.mojang.ld22.screen.CraftingMenu;
import com.mojang.ld22.crafting.Crafting;
import com.mojang.ld22.gfx.Color;

public class WorkbenchGod extends Furniture
{
    public WorkbenchGod() {
        super("God Workbench");
        this.col0 = Color.get(-1, 110, 330, 442);
        this.col1 = Color.get(-1, 220, 440, 553);
        this.col2 = Color.get(-1, 110, 330, 442);
        this.col3 = Color.get(-1, 0, 220, 331);
        this.col = Color.get(-1, 110, 440, 553);
        this.sprite = 4;
        this.xr = 3;
        this.yr = 2;
    }
    
    @Override
    public boolean use(final Player player, final int attackDir) {
        player.game.setMenu(new CraftingMenu(Crafting.godworkbenchRecipes, player));
        return true;
    }
}
