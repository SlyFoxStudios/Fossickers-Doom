// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.entity;

import com.mojang.ld22.screen.Menu;
import com.mojang.ld22.screen.CraftingMenu;
import com.mojang.ld22.crafting.Crafting;
import com.mojang.ld22.gfx.Color;

public class Enchanter extends Furniture
{
    public Enchanter() {
        super("Enchanter");
        this.col0 = Color.get(-1, 613, 888, 111);
        this.col1 = Color.get(-1, 623, 999, 222);
        this.col2 = Color.get(-1, 613, 888, 111);
        this.col3 = Color.get(-1, 603, 777, 0);
        this.col = Color.get(-1, 623, 999, 111);
        this.sprite = 6;
        this.xr = 7;
        this.yr = 2;
    }
    
    @Override
    public boolean use(final Player player, final int attackDir) {
        player.game.setMenu(new CraftingMenu(Crafting.enchantRecipes, player));
        return true;
    }
}
