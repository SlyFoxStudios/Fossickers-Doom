// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.entity;

import com.mojang.ld22.screen.Menu;
import com.mojang.ld22.screen.CraftingMenu;
import com.mojang.ld22.crafting.Crafting;
import com.mojang.ld22.gfx.Color;

public class Workbench extends Furniture
{
    public Workbench() {
        super("Workbench");
        this.col0 = Color.get(-1, 100, 211, 320);
        this.col1 = Color.get(-1, 211, 321, 431);
        this.col2 = Color.get(-1, 100, 211, 320);
        this.col3 = Color.get(-1, 0, 100, 210);
        this.col = Color.get(-1, 100, 321, 431);
        this.sprite = 4;
        this.xr = 3;
        this.yr = 2;
    }
    
    @Override
    public boolean use(final Player player, final int attackDir) {
        player.game.setMenu(new CraftingMenu(Crafting.workbenchRecipes, player));
        return true;
    }
}
