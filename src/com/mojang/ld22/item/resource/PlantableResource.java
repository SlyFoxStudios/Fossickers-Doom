// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.item.resource;

import com.mojang.ld22.Game;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.level.Level;
import java.util.Arrays;
import com.mojang.ld22.level.tile.Tile;
import java.util.List;

public class PlantableResource extends Resource
{
    private List<Tile> sourceTiles;
    private Tile targetTile;
    
    public PlantableResource(final String name, final int sprite, final int color, final Tile targetTile, final Tile... sourceTiles1) {
        this(name, sprite, color, targetTile, Arrays.asList(sourceTiles1));
    }
    
    public PlantableResource(final String name, final int sprite, final int color, final Tile targetTile, final List<Tile> sourceTiles) {
        super(name, sprite, color);
        this.sourceTiles = sourceTiles;
        this.targetTile = targetTile;
    }
    
    @Override
    public boolean interactOn(final Tile tile, final Level level, final int xt, final int yt, final Player player, final int attackDir) {
        if (this.sourceTiles.contains(tile)) {
            level.setTile(xt, yt, this.targetTile, 0);
            return true;
        }
        if (this.name == "Plank Wall" && !this.sourceTiles.contains(tile)) {
            Game.notifications.add("Can only be placed on planks!");
        }
        if (this.name == "Wood Door" && !this.sourceTiles.contains(tile)) {
            Game.notifications.add("Can only be placed on planks!");
        }
        if (this.name == "St.BrickWall" && !this.sourceTiles.contains(tile)) {
            Game.notifications.add("Can only be placed on st.brick!");
        }
        if (this.name == "Stone Door" && !this.sourceTiles.contains(tile)) {
            Game.notifications.add("Can only be placed on st.brick!");
        }
        return false;
    }
}
