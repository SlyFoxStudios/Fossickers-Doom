// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.item.resource;

import com.fossickersdoom.entity.Player;
import com.fossickersdoom.level.Level;
import com.fossickersdoom.level.tile.Tile;

public class ClothesResource extends Resource
{
    int red;
    int blue;
    int green;
    
    public ClothesResource(final String name, final int sprite, final int color, final int r, final int g, final int b) {
        super(name, sprite, color);
        this.red = r;
        this.blue = b;
        this.green = g;
    }
    
    @Override
    public boolean interactOn(final Tile tile, final Level level, final int xt, final int yt, final Player player, final int attackDir) {
        if (player.r != this.red || player.g != this.green || player.b != this.blue) {
            player.r = this.red;
            player.b = this.blue;
            player.g = this.green;
            return true;
        }
        return false;
    }
}
