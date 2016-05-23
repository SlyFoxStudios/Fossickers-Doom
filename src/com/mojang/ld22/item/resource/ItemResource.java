// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.item.resource;

import com.mojang.ld22.Game;
import com.mojang.ld22.screen.BookAntVenomMenu;
import com.mojang.ld22.screen.Menu;
import com.mojang.ld22.screen.BookTestMenu;
import com.mojang.ld22.crafting.Crafting;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.level.tile.Tile;

public class ItemResource extends Resource
{
    public static int dur;
    
    static {
        ItemResource.dur = 20;
    }
    
    public ItemResource(final String name, final int sprite, final int color) {
        super(name, sprite, color);
    }
    
    @Override
    public boolean interactOn(final Tile tile, final Level level, final int xt, final int yt, final Player player, final int attackDir) {
        if (this.name == "book") {
            player.game.setMenu(new BookTestMenu(Crafting.workbenchRecipes, player));
        }
        else if (this.name == "Antidious") {
            player.game.setMenu(new BookAntVenomMenu(Crafting.workbenchRecipes, player));
        }
        else if (this.name == "Fish Rod" && (tile == Tile.water || tile == Tile.lightwater)) {
            System.out.print("Fishing...");
            Game.Fishing(level, player.x - 5, player.y - 5, player);
            --ItemResource.dur;
        }
        return false;
    }
}
