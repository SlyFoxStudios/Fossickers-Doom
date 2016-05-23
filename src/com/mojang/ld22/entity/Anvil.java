// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.entity;

import com.mojang.ld22.screen.Menu;
import com.mojang.ld22.screen.CraftingMenu;
import com.mojang.ld22.crafting.Crafting;
import com.mojang.ld22.gfx.Color;

public class Anvil extends Furniture
{
    public Anvil() {
        super("Anvil");
        this.col0 = Color.get(-1, 0, 222, 333);
        this.col1 = Color.get(-1, 0, 333, 444);
        this.col2 = Color.get(-1, 0, 222, 333);
        this.col3 = Color.get(-1, 0, 111, 222);
        this.col = Color.get(-1, 0, 222, 333);
        this.sprite = 0;
        this.xr = 3;
        this.yr = 2;
    }
    
    @Override
    public boolean use(final Player player, final int attackDir) {
        player.game.setMenu(new CraftingMenu(Crafting.anvilRecipes, player));
        return true;
    }
}
