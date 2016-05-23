// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.entity;

import com.mojang.ld22.screen.Menu;
import com.mojang.ld22.screen.CraftingMenu;
import com.mojang.ld22.crafting.Crafting;
import com.mojang.ld22.gfx.Color;

public class Oven extends Furniture
{
    public Oven() {
        super("Oven");
        this.col0 = Color.get(-1, 0, 221, 331);
        this.col1 = Color.get(-1, 0, 332, 442);
        this.col2 = Color.get(-1, 0, 221, 331);
        this.col3 = Color.get(-1, 0, 110, 221);
        this.col = Color.get(-1, 0, 332, 442);
        this.sprite = 2;
        this.xr = 3;
        this.yr = 2;
    }
    
    @Override
    public boolean use(final Player player, final int attackDir) {
        player.game.setMenu(new CraftingMenu(Crafting.ovenRecipes, player));
        return true;
    }
}
