// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.entity;

import com.mojang.ld22.screen.Menu;
import com.mojang.ld22.screen.CraftingMenu;
import com.mojang.ld22.crafting.Crafting;
import com.mojang.ld22.gfx.Color;

public class Loom extends Furniture
{
    public Loom() {
        super("Loom");
        this.col0 = Color.get(-1, 100, 333, 211);
        this.col1 = Color.get(-1, 211, 444, 322);
        this.col2 = Color.get(-1, 100, 333, 211);
        this.col3 = Color.get(-1, 0, 222, 100);
        this.col = Color.get(-1, 100, 333, 211);
        this.sprite = 9;
        this.xr = 7;
        this.yr = 2;
    }
    
    @Override
    public boolean use(final Player player, final int attackDir) {
        player.game.setMenu(new CraftingMenu(Crafting.loomRecipes, player));
        return true;
    }
}
