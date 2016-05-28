// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.item.resource;

import com.fossickersdoom.entity.Player;
import com.fossickersdoom.level.Level;
import com.fossickersdoom.level.tile.Tile;

import java.util.Arrays;
import java.util.List;

public class TorchResource extends Resource
{
    private List<Tile> sourceTiles;
    private Tile targetTile;
    
    public TorchResource(final String name, final int sprite, final int color, final Tile targetTile, final Tile... sourceTiles1) {
        this(name, sprite, color, targetTile, Arrays.asList(sourceTiles1));
    }
    
    public TorchResource(final String name, final int sprite, final int color, final Tile targetTile, final List<Tile> sourceTiles) {
        super(name, sprite, color);
        this.sourceTiles = sourceTiles;
        this.targetTile = targetTile;
    }
    
    @Override
    public boolean interactOn(final Tile tile, final Level level, final int xt, final int yt, final Player player, final int attackDir) {
        if (this.sourceTiles.contains(tile)) {
            if (level.depth == 0) {
                if (tile == Tile.grass) {
                    level.setTile(xt, yt, Tile.torchgrass, 0);
                    return true;
                }
                if (tile == Tile.lightgrass) {
                    level.setTile(xt, yt, Tile.torchgrass, 0);
                    return true;
                }
                if (tile == Tile.dirt) {
                    level.setTile(xt, yt, Tile.torchdirt, 0);
                    return true;
                }
                if (tile == Tile.lightdirt) {
                    level.setTile(xt, yt, Tile.torchdirt, 0);
                    return true;
                }
                if (tile == Tile.sand) {
                    level.setTile(xt, yt, Tile.torchsand, 0);
                    return true;
                }
                if (tile == Tile.lightsand) {
                    level.setTile(xt, yt, Tile.torchsand, 0);
                    return true;
                }
                if (tile == Tile.plank) {
                    level.setTile(xt, yt, Tile.torchplank, 0);
                    return true;
                }
                if (tile == Tile.lightplank) {
                    level.setTile(xt, yt, Tile.torchplank, 0);
                    return true;
                }
                if (tile == Tile.sbrick) {
                    level.setTile(xt, yt, Tile.torchsbrick, 0);
                    return true;
                }
                if (tile == Tile.lightsbrick) {
                    level.setTile(xt, yt, Tile.torchsbrick, 0);
                    return true;
                }
                if (tile == Tile.wool) {
                    level.setTile(xt, yt, Tile.torchwool, 0);
                    return true;
                }
                if (tile == Tile.lightwool) {
                    level.setTile(xt, yt, Tile.torchwool, 0);
                    return true;
                }
                if (tile == Tile.redwool) {
                    level.setTile(xt, yt, Tile.torchwoolred, 0);
                    return true;
                }
                if (tile == Tile.lightrwool) {
                    level.setTile(xt, yt, Tile.torchwoolred, 0);
                    return true;
                }
                if (tile == Tile.bluewool) {
                    level.setTile(xt, yt, Tile.torchwoolblue, 0);
                    return true;
                }
                if (tile == Tile.lightbwool) {
                    level.setTile(xt, yt, Tile.torchwoolblue, 0);
                    return true;
                }
                if (tile == Tile.greenwool) {
                    level.setTile(xt, yt, Tile.torchwoolgreen, 0);
                    return true;
                }
                if (tile == Tile.lightgwool) {
                    level.setTile(xt, yt, Tile.torchwoolgreen, 0);
                    return true;
                }
                if (tile == Tile.yellowwool) {
                    level.setTile(xt, yt, Tile.torchwoolyellow, 0);
                    return true;
                }
                if (tile == Tile.lightywool) {
                    level.setTile(xt, yt, Tile.torchwoolyellow, 0);
                    return true;
                }
                if (tile == Tile.blackwool) {
                    level.setTile(xt, yt, Tile.torchwoolblack, 0);
                    return true;
                }
                if (tile == Tile.lightblwool) {
                    level.setTile(xt, yt, Tile.torchwoolblack, 0);
                    return true;
                }
            }
            else {
                if (tile == Tile.grass) {
                    level.setTile(xt, yt, Tile.torchgrass, 0);
                    return true;
                }
                if (tile == Tile.dirt) {
                    level.setTile(xt, yt, Tile.torchdirt, 0);
                    return true;
                }
                if (tile == Tile.sand) {
                    level.setTile(xt, yt, Tile.torchsand, 0);
                    return true;
                }
                if (tile == Tile.plank) {
                    level.setTile(xt, yt, Tile.torchplank, 0);
                    return true;
                }
                if (tile == Tile.sbrick) {
                    level.setTile(xt, yt, Tile.torchsbrick, 0);
                    return true;
                }
                if (tile == Tile.wool) {
                    level.setTile(xt, yt, Tile.torchwool, 0);
                    return true;
                }
                if (tile == Tile.redwool) {
                    level.setTile(xt, yt, Tile.torchwoolred, 0);
                    return true;
                }
                if (tile == Tile.bluewool) {
                    level.setTile(xt, yt, Tile.torchwoolblue, 0);
                    return true;
                }
                if (tile == Tile.greenwool) {
                    level.setTile(xt, yt, Tile.torchwoolgreen, 0);
                    return true;
                }
                if (tile == Tile.yellowwool) {
                    level.setTile(xt, yt, Tile.torchwoolyellow, 0);
                    return true;
                }
                if (tile == Tile.blackwool) {
                    level.setTile(xt, yt, Tile.torchwoolblack, 0);
                    return true;
                }
            }
        }
        return false;
    }
}
