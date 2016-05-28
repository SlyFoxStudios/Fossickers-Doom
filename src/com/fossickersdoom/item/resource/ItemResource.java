// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.item.resource;

import com.fossickersdoom.Game;
import com.fossickersdoom.crafting.Crafting;
import com.fossickersdoom.entity.Player;
import com.fossickersdoom.level.Level;
import com.fossickersdoom.level.tile.Tile;
import com.fossickersdoom.screen.BookAntVenomMenu;
import com.fossickersdoom.screen.BookTestMenu;

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
