// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.level.tile;

import com.fossickersdoom.entity.ItemEntity;
import com.fossickersdoom.entity.Player;
import com.fossickersdoom.item.Item;
import com.fossickersdoom.item.resource.Resource;
import com.fossickersdoom.level.Level;
import com.fossickersdoom.item.ResourceItem;
import com.fossickersdoom.item.PowerGloveItem;
import com.fossickersdoom.gfx.Color;
import com.fossickersdoom.gfx.Screen;

public class TorchTile extends Tile
{
    private Tile onType;
    
    public TorchTile(final int id, final Tile onType) {
        super(id);
        this.onType = onType;
        this.connectsToSand = onType.connectsToSand;
        this.connectsToGrass = onType.connectsToGrass;
        this.connectsToWater = onType.connectsToWater;
        this.connectsToLava = onType.connectsToLava;
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        final int col0 = Color.get(320, 500, 520, -1);
        final int col2 = Color.get(320, 500, 520, -1);
        if (level.depth != 0) {
            if (this.onType == Tile.lightdirt) {
                this.onType = Tile.dirt;
            }
            if (this.onType == Tile.lightgrass) {
                this.onType = Tile.grass;
            }
            if (this.onType == Tile.lightsand) {
                this.onType = Tile.sand;
            }
            if (this.onType == Tile.lightplank) {
                this.onType = Tile.plank;
            }
            if (this.onType == Tile.lightsbrick) {
                this.onType = Tile.sbrick;
            }
            if (this.onType == Tile.lightwool) {
                this.onType = Tile.wool;
            }
            if (this.onType == Tile.lightrwool) {
                this.onType = Tile.redwool;
            }
            if (this.onType == Tile.lightbwool) {
                this.onType = Tile.bluewool;
            }
            if (this.onType == Tile.lightgwool) {
                this.onType = Tile.greenwool;
            }
            if (this.onType == Tile.lightywool) {
                this.onType = Tile.yellowwool;
            }
            if (this.onType == Tile.lightblwool) {
                this.onType = Tile.blackwool;
            }
        }
        this.onType.render(screen, level, x, y);
        if (level.depth == 0) {
            final int col3 = col0;
            screen.render(x * 16 + 4, y * 16 + 4, 108, col3, 0);
        }
        if (level.depth != 0) {
            final int col3 = col2;
            screen.render(x * 16 + 4, y * 16 + 4, 108, col3, 0);
        }
    }
    
    @Override
    public int getLightRadius(final Level level, final int x, final int y) {
        if (level.player.light > 1.0) {
            return 6;
        }
        return 4;
    }
    
    @Override
    public void tick(final Level level, final int x, final int y) {
        if (level.depth == 0) {
            if (level.getTile(x, y - 1) == Tile.grass) {
                level.setTile(x, y - 1, Tile.lightgrass, y);
            }
            if (level.getTile(x, y + 1) == Tile.grass) {
                level.setTile(x, y + 1, Tile.lightgrass, y);
            }
            if (level.getTile(x - 1, y) == Tile.grass) {
                level.setTile(x - 1, y, Tile.lightgrass, y);
            }
            if (level.getTile(x + 1, y) == Tile.grass) {
                level.setTile(x + 1, y, Tile.lightgrass, y);
            }
            if (level.getTile(x, y - 2) == Tile.grass) {
                level.setTile(x, y - 2, Tile.lightgrass, y);
            }
            if (level.getTile(x, y + 2) == Tile.grass) {
                level.setTile(x, y + 2, Tile.lightgrass, y);
            }
            if (level.getTile(x - 2, y) == Tile.grass) {
                level.setTile(x - 2, y, Tile.lightgrass, y);
            }
            if (level.getTile(x + 2, y) == Tile.grass) {
                level.setTile(x + 2, y, Tile.lightgrass, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.grass) {
                level.setTile(x - 1, y - 1, Tile.lightgrass, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.grass) {
                level.setTile(x + 1, y - 1, Tile.lightgrass, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.grass) {
                level.setTile(x + 1, y + 1, Tile.lightgrass, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.grass) {
                level.setTile(x - 1, y + 1, Tile.lightgrass, y);
            }
            if (level.getTile(x, y - 1) == Tile.sand) {
                level.setTile(x, y - 1, Tile.lightsand, y);
            }
            if (level.getTile(x, y + 1) == Tile.sand) {
                level.setTile(x, y + 1, Tile.lightsand, y);
            }
            if (level.getTile(x - 1, y) == Tile.sand) {
                level.setTile(x - 1, y, Tile.lightsand, y);
            }
            if (level.getTile(x + 1, y) == Tile.sand) {
                level.setTile(x + 1, y, Tile.lightsand, y);
            }
            if (level.getTile(x, y - 2) == Tile.sand) {
                level.setTile(x, y - 2, Tile.lightsand, y);
            }
            if (level.getTile(x, y + 2) == Tile.sand) {
                level.setTile(x, y + 2, Tile.lightsand, y);
            }
            if (level.getTile(x - 2, y) == Tile.sand) {
                level.setTile(x - 2, y, Tile.lightsand, y);
            }
            if (level.getTile(x + 2, y) == Tile.sand) {
                level.setTile(x + 2, y, Tile.lightsand, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.sand) {
                level.setTile(x - 1, y - 1, Tile.lightsand, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.sand) {
                level.setTile(x + 1, y - 1, Tile.lightsand, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.sand) {
                level.setTile(x + 1, y + 1, Tile.lightsand, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.sand) {
                level.setTile(x - 1, y + 1, Tile.lightsand, y);
            }
            if (level.getTile(x, y - 1) == Tile.tree) {
                level.setTile(x, y - 1, Tile.lighttree, y);
            }
            if (level.getTile(x, y + 1) == Tile.tree) {
                level.setTile(x, y + 1, Tile.lighttree, y);
            }
            if (level.getTile(x - 1, y) == Tile.tree) {
                level.setTile(x - 1, y, Tile.lighttree, y);
            }
            if (level.getTile(x + 1, y) == Tile.tree) {
                level.setTile(x + 1, y, Tile.lighttree, y);
            }
            if (level.getTile(x, y - 2) == Tile.tree) {
                level.setTile(x, y - 2, Tile.lighttree, y);
            }
            if (level.getTile(x, y + 2) == Tile.tree) {
                level.setTile(x, y + 2, Tile.lighttree, y);
            }
            if (level.getTile(x - 2, y) == Tile.tree) {
                level.setTile(x - 2, y, Tile.lighttree, y);
            }
            if (level.getTile(x + 2, y) == Tile.tree) {
                level.setTile(x + 2, y, Tile.lighttree, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.tree) {
                level.setTile(x - 1, y - 1, Tile.lighttree, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.tree) {
                level.setTile(x + 1, y - 1, Tile.lighttree, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.tree) {
                level.setTile(x + 1, y + 1, Tile.lighttree, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.tree) {
                level.setTile(x - 1, y + 1, Tile.lighttree, y);
            }
            if (level.getTile(x, y - 1) == Tile.cactus) {
                level.setTile(x, y - 1, Tile.lightcac, y);
            }
            if (level.getTile(x, y + 1) == Tile.cactus) {
                level.setTile(x, y + 1, Tile.lightcac, y);
            }
            if (level.getTile(x - 1, y) == Tile.cactus) {
                level.setTile(x - 1, y, Tile.lightcac, y);
            }
            if (level.getTile(x + 1, y) == Tile.cactus) {
                level.setTile(x + 1, y, Tile.lightcac, y);
            }
            if (level.getTile(x, y - 2) == Tile.cactus) {
                level.setTile(x, y - 2, Tile.lightcac, y);
            }
            if (level.getTile(x, y + 2) == Tile.cactus) {
                level.setTile(x, y + 2, Tile.lightcac, y);
            }
            if (level.getTile(x - 2, y) == Tile.cactus) {
                level.setTile(x - 2, y, Tile.lightcac, y);
            }
            if (level.getTile(x + 2, y) == Tile.cactus) {
                level.setTile(x + 2, y, Tile.lightcac, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.cactus) {
                level.setTile(x - 1, y - 1, Tile.lightcac, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.cactus) {
                level.setTile(x + 1, y - 1, Tile.lightcac, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.cactus) {
                level.setTile(x + 1, y + 1, Tile.lightcac, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.cactus) {
                level.setTile(x - 1, y + 1, Tile.lightcac, y);
            }
            if (level.getTile(x, y - 1) == Tile.water) {
                level.setTile(x, y - 1, Tile.lightwater, y);
            }
            if (level.getTile(x, y + 1) == Tile.water) {
                level.setTile(x, y + 1, Tile.lightwater, y);
            }
            if (level.getTile(x - 1, y) == Tile.water) {
                level.setTile(x - 1, y, Tile.lightwater, y);
            }
            if (level.getTile(x + 1, y) == Tile.water) {
                level.setTile(x + 1, y, Tile.lightwater, y);
            }
            if (level.getTile(x, y - 2) == Tile.water) {
                level.setTile(x, y - 2, Tile.lightwater, y);
            }
            if (level.getTile(x, y + 2) == Tile.water) {
                level.setTile(x, y + 2, Tile.lightwater, y);
            }
            if (level.getTile(x - 2, y) == Tile.water) {
                level.setTile(x - 2, y, Tile.lightwater, y);
            }
            if (level.getTile(x + 2, y) == Tile.water) {
                level.setTile(x + 2, y, Tile.lightwater, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.water) {
                level.setTile(x - 1, y - 1, Tile.lightwater, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.water) {
                level.setTile(x + 1, y - 1, Tile.lightwater, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.water) {
                level.setTile(x + 1, y + 1, Tile.lightwater, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.water) {
                level.setTile(x - 1, y + 1, Tile.lightwater, y);
            }
            if (level.getTile(x, y - 1) == Tile.dirt) {
                level.setTile(x, y - 1, Tile.lightdirt, y);
            }
            if (level.getTile(x, y + 1) == Tile.dirt) {
                level.setTile(x, y + 1, Tile.lightdirt, y);
            }
            if (level.getTile(x - 1, y) == Tile.dirt) {
                level.setTile(x - 1, y, Tile.lightdirt, y);
            }
            if (level.getTile(x + 1, y) == Tile.dirt) {
                level.setTile(x + 1, y, Tile.lightdirt, y);
            }
            if (level.getTile(x, y - 2) == Tile.dirt) {
                level.setTile(x, y - 2, Tile.lightdirt, y);
            }
            if (level.getTile(x, y + 2) == Tile.dirt) {
                level.setTile(x, y + 2, Tile.lightdirt, y);
            }
            if (level.getTile(x - 2, y) == Tile.dirt) {
                level.setTile(x - 2, y, Tile.lightdirt, y);
            }
            if (level.getTile(x + 2, y) == Tile.dirt) {
                level.setTile(x + 2, y, Tile.lightdirt, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.dirt) {
                level.setTile(x - 1, y - 1, Tile.lightdirt, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.dirt) {
                level.setTile(x + 1, y - 1, Tile.lightdirt, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.dirt) {
                level.setTile(x + 1, y + 1, Tile.lightdirt, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.dirt) {
                level.setTile(x - 1, y + 1, Tile.lightdirt, y);
            }
            if (level.getTile(x, y - 1) == Tile.flower) {
                level.setTile(x, y - 1, Tile.lightflower, y);
            }
            if (level.getTile(x, y + 1) == Tile.flower) {
                level.setTile(x, y + 1, Tile.lightflower, y);
            }
            if (level.getTile(x - 1, y) == Tile.flower) {
                level.setTile(x - 1, y, Tile.lightflower, y);
            }
            if (level.getTile(x + 1, y) == Tile.flower) {
                level.setTile(x + 1, y, Tile.lightflower, y);
            }
            if (level.getTile(x, y - 2) == Tile.flower) {
                level.setTile(x, y - 2, Tile.lightflower, y);
            }
            if (level.getTile(x, y + 2) == Tile.flower) {
                level.setTile(x, y + 2, Tile.lightflower, y);
            }
            if (level.getTile(x - 2, y) == Tile.flower) {
                level.setTile(x - 2, y, Tile.lightflower, y);
            }
            if (level.getTile(x + 2, y) == Tile.flower) {
                level.setTile(x + 2, y, Tile.lightflower, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.flower) {
                level.setTile(x - 1, y - 1, Tile.lightflower, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.flower) {
                level.setTile(x + 1, y - 1, Tile.lightflower, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.flower) {
                level.setTile(x + 1, y + 1, Tile.lightflower, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.flower) {
                level.setTile(x - 1, y + 1, Tile.lightflower, y);
            }
            if (level.getTile(x, y - 1) == Tile.stairsUp) {
                level.setTile(x, y - 1, Tile.lightstairsUp, y);
            }
            if (level.getTile(x, y + 1) == Tile.stairsUp) {
                level.setTile(x, y + 1, Tile.lightstairsUp, y);
            }
            if (level.getTile(x - 1, y) == Tile.stairsUp) {
                level.setTile(x - 1, y, Tile.lightstairsUp, y);
            }
            if (level.getTile(x + 1, y) == Tile.stairsUp) {
                level.setTile(x + 1, y, Tile.lightstairsUp, y);
            }
            if (level.getTile(x, y - 2) == Tile.stairsUp) {
                level.setTile(x, y - 2, Tile.lightstairsUp, y);
            }
            if (level.getTile(x, y + 2) == Tile.stairsUp) {
                level.setTile(x, y + 2, Tile.lightstairsUp, y);
            }
            if (level.getTile(x - 2, y) == Tile.stairsUp) {
                level.setTile(x - 2, y, Tile.lightstairsUp, y);
            }
            if (level.getTile(x + 2, y) == Tile.stairsUp) {
                level.setTile(x + 2, y, Tile.lightstairsUp, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.stairsUp) {
                level.setTile(x - 1, y - 1, Tile.lightstairsUp, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.stairsUp) {
                level.setTile(x + 1, y - 1, Tile.lightstairsUp, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.stairsUp) {
                level.setTile(x + 1, y + 1, Tile.lightstairsUp, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.stairsUp) {
                level.setTile(x - 1, y + 1, Tile.lightstairsUp, y);
            }
            if (level.getTile(x, y - 1) == Tile.stairsDown) {
                level.setTile(x, y - 1, Tile.lightstairsDown, y);
            }
            if (level.getTile(x, y + 1) == Tile.stairsDown) {
                level.setTile(x, y + 1, Tile.lightstairsDown, y);
            }
            if (level.getTile(x - 1, y) == Tile.stairsDown) {
                level.setTile(x - 1, y, Tile.lightstairsDown, y);
            }
            if (level.getTile(x + 1, y) == Tile.stairsDown) {
                level.setTile(x + 1, y, Tile.lightstairsDown, y);
            }
            if (level.getTile(x, y - 2) == Tile.stairsDown) {
                level.setTile(x, y - 2, Tile.lightstairsDown, y);
            }
            if (level.getTile(x, y + 2) == Tile.stairsDown) {
                level.setTile(x, y + 2, Tile.lightstairsDown, y);
            }
            if (level.getTile(x - 2, y) == Tile.stairsDown) {
                level.setTile(x - 2, y, Tile.lightstairsDown, y);
            }
            if (level.getTile(x + 2, y) == Tile.stairsDown) {
                level.setTile(x + 2, y, Tile.lightstairsDown, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.stairsDown) {
                level.setTile(x - 1, y - 1, Tile.lightstairsDown, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.stairsDown) {
                level.setTile(x + 1, y - 1, Tile.lightstairsDown, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.stairsDown) {
                level.setTile(x + 1, y + 1, Tile.lightstairsDown, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.stairsDown) {
                level.setTile(x - 1, y + 1, Tile.lightstairsDown, y);
            }
            if (level.getTile(x, y - 1) == Tile.plank) {
                level.setTile(x, y - 1, Tile.lightplank, y);
            }
            if (level.getTile(x, y + 1) == Tile.plank) {
                level.setTile(x, y + 1, Tile.lightplank, y);
            }
            if (level.getTile(x - 1, y) == Tile.plank) {
                level.setTile(x - 1, y, Tile.lightplank, y);
            }
            if (level.getTile(x + 1, y) == Tile.plank) {
                level.setTile(x + 1, y, Tile.lightplank, y);
            }
            if (level.getTile(x, y - 2) == Tile.plank) {
                level.setTile(x, y - 2, Tile.lightplank, y);
            }
            if (level.getTile(x, y + 2) == Tile.plank) {
                level.setTile(x, y + 2, Tile.lightplank, y);
            }
            if (level.getTile(x - 2, y) == Tile.plank) {
                level.setTile(x - 2, y, Tile.lightplank, y);
            }
            if (level.getTile(x + 2, y) == Tile.plank) {
                level.setTile(x + 2, y, Tile.lightplank, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.plank) {
                level.setTile(x - 1, y - 1, Tile.lightplank, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.plank) {
                level.setTile(x + 1, y - 1, Tile.lightplank, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.plank) {
                level.setTile(x + 1, y + 1, Tile.lightplank, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.plank) {
                level.setTile(x - 1, y + 1, Tile.lightplank, y);
            }
            if (level.getTile(x, y - 1) == Tile.sbrick) {
                level.setTile(x, y - 1, Tile.lightsbrick, y);
            }
            if (level.getTile(x, y + 1) == Tile.sbrick) {
                level.setTile(x, y + 1, Tile.lightsbrick, y);
            }
            if (level.getTile(x - 1, y) == Tile.sbrick) {
                level.setTile(x - 1, y, Tile.lightsbrick, y);
            }
            if (level.getTile(x + 1, y) == Tile.sbrick) {
                level.setTile(x + 1, y, Tile.lightsbrick, y);
            }
            if (level.getTile(x, y - 2) == Tile.sbrick) {
                level.setTile(x, y - 2, Tile.lightsbrick, y);
            }
            if (level.getTile(x, y + 2) == Tile.sbrick) {
                level.setTile(x, y + 2, Tile.lightsbrick, y);
            }
            if (level.getTile(x - 2, y) == Tile.sbrick) {
                level.setTile(x - 2, y, Tile.lightsbrick, y);
            }
            if (level.getTile(x + 2, y) == Tile.sbrick) {
                level.setTile(x + 2, y, Tile.lightsbrick, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.sbrick) {
                level.setTile(x - 1, y - 1, Tile.lightsbrick, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.sbrick) {
                level.setTile(x + 1, y - 1, Tile.lightsbrick, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.sbrick) {
                level.setTile(x + 1, y + 1, Tile.lightsbrick, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.sbrick) {
                level.setTile(x - 1, y + 1, Tile.lightsbrick, y);
            }
            if (level.getTile(x, y - 1) == Tile.wdo) {
                level.setTile(x, y - 1, Tile.lwdo, y);
            }
            if (level.getTile(x, y + 1) == Tile.wdo) {
                level.setTile(x, y + 1, Tile.lwdo, y);
            }
            if (level.getTile(x - 1, y) == Tile.wdo) {
                level.setTile(x - 1, y, Tile.lwdo, y);
            }
            if (level.getTile(x + 1, y) == Tile.wdo) {
                level.setTile(x + 1, y, Tile.lwdo, y);
            }
            if (level.getTile(x, y - 2) == Tile.wdo) {
                level.setTile(x, y - 2, Tile.lwdo, y);
            }
            if (level.getTile(x, y + 2) == Tile.wdo) {
                level.setTile(x, y + 2, Tile.lwdo, y);
            }
            if (level.getTile(x - 2, y) == Tile.wdo) {
                level.setTile(x - 2, y, Tile.lwdo, y);
            }
            if (level.getTile(x + 2, y) == Tile.wdo) {
                level.setTile(x + 2, y, Tile.lwdo, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.wdo) {
                level.setTile(x - 1, y - 1, Tile.lwdo, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.wdo) {
                level.setTile(x + 1, y - 1, Tile.lwdo, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.wdo) {
                level.setTile(x + 1, y + 1, Tile.lwdo, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.wdo) {
                level.setTile(x - 1, y + 1, Tile.lwdo, y);
            }
            if (level.getTile(x, y - 1) == Tile.wdc) {
                level.setTile(x, y - 1, Tile.lwdc, y);
            }
            if (level.getTile(x, y + 1) == Tile.wdc) {
                level.setTile(x, y + 1, Tile.lwdc, y);
            }
            if (level.getTile(x - 1, y) == Tile.wdc) {
                level.setTile(x - 1, y, Tile.lwdc, y);
            }
            if (level.getTile(x + 1, y) == Tile.wdc) {
                level.setTile(x + 1, y, Tile.lwdc, y);
            }
            if (level.getTile(x, y - 2) == Tile.wdc) {
                level.setTile(x, y - 2, Tile.lwdc, y);
            }
            if (level.getTile(x, y + 2) == Tile.wdc) {
                level.setTile(x, y + 2, Tile.lwdc, y);
            }
            if (level.getTile(x - 2, y) == Tile.wdc) {
                level.setTile(x - 2, y, Tile.lwdc, y);
            }
            if (level.getTile(x + 2, y) == Tile.wdc) {
                level.setTile(x + 2, y, Tile.lwdc, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.wdc) {
                level.setTile(x - 1, y - 1, Tile.lwdc, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.wdc) {
                level.setTile(x + 1, y - 1, Tile.lwdc, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.wdc) {
                level.setTile(x + 1, y + 1, Tile.lwdc, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.wdc) {
                level.setTile(x - 1, y + 1, Tile.lwdc, y);
            }
            if (level.getTile(x, y - 1) == Tile.sdo) {
                level.setTile(x, y - 1, Tile.lsdo, y);
            }
            if (level.getTile(x, y + 1) == Tile.sdo) {
                level.setTile(x, y + 1, Tile.lsdo, y);
            }
            if (level.getTile(x - 1, y) == Tile.sdo) {
                level.setTile(x - 1, y, Tile.lsdo, y);
            }
            if (level.getTile(x + 1, y) == Tile.sdo) {
                level.setTile(x + 1, y, Tile.lsdo, y);
            }
            if (level.getTile(x, y - 2) == Tile.sdo) {
                level.setTile(x, y - 2, Tile.lsdo, y);
            }
            if (level.getTile(x, y + 2) == Tile.sdo) {
                level.setTile(x, y + 2, Tile.lsdo, y);
            }
            if (level.getTile(x - 2, y) == Tile.sdo) {
                level.setTile(x - 2, y, Tile.lsdo, y);
            }
            if (level.getTile(x + 2, y) == Tile.sdo) {
                level.setTile(x + 2, y, Tile.lsdo, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.sdo) {
                level.setTile(x - 1, y - 1, Tile.lsdo, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.sdo) {
                level.setTile(x + 1, y - 1, Tile.lsdo, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.sdo) {
                level.setTile(x + 1, y + 1, Tile.lsdo, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.sdo) {
                level.setTile(x - 1, y + 1, Tile.lsdo, y);
            }
            if (level.getTile(x, y - 1) == Tile.sdc) {
                level.setTile(x, y - 1, Tile.lsdc, y);
            }
            if (level.getTile(x, y + 1) == Tile.sdc) {
                level.setTile(x, y + 1, Tile.lsdc, y);
            }
            if (level.getTile(x - 1, y) == Tile.sdc) {
                level.setTile(x - 1, y, Tile.lsdc, y);
            }
            if (level.getTile(x + 1, y) == Tile.sdc) {
                level.setTile(x + 1, y, Tile.lsdc, y);
            }
            if (level.getTile(x, y - 2) == Tile.sdc) {
                level.setTile(x, y - 2, Tile.lsdc, y);
            }
            if (level.getTile(x, y + 2) == Tile.sdc) {
                level.setTile(x, y + 2, Tile.lsdc, y);
            }
            if (level.getTile(x - 2, y) == Tile.sdc) {
                level.setTile(x - 2, y, Tile.lsdc, y);
            }
            if (level.getTile(x + 2, y) == Tile.sdc) {
                level.setTile(x + 2, y, Tile.lsdc, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.sdc) {
                level.setTile(x - 1, y - 1, Tile.lsdc, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.sdc) {
                level.setTile(x + 1, y - 1, Tile.lsdc, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.sdc) {
                level.setTile(x + 1, y + 1, Tile.lsdc, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.sdc) {
                level.setTile(x - 1, y + 1, Tile.lsdc, y);
            }
            if (level.getTile(x, y - 1) == Tile.hole) {
                level.setTile(x, y - 1, Tile.lighthole, y);
            }
            if (level.getTile(x, y + 1) == Tile.hole) {
                level.setTile(x, y + 1, Tile.lighthole, y);
            }
            if (level.getTile(x - 1, y) == Tile.hole) {
                level.setTile(x - 1, y, Tile.lighthole, y);
            }
            if (level.getTile(x + 1, y) == Tile.hole) {
                level.setTile(x + 1, y, Tile.lighthole, y);
            }
            if (level.getTile(x, y - 2) == Tile.hole) {
                level.setTile(x, y - 2, Tile.lighthole, y);
            }
            if (level.getTile(x, y + 2) == Tile.hole) {
                level.setTile(x, y + 2, Tile.lighthole, y);
            }
            if (level.getTile(x - 2, y) == Tile.hole) {
                level.setTile(x - 2, y, Tile.lighthole, y);
            }
            if (level.getTile(x + 2, y) == Tile.hole) {
                level.setTile(x + 2, y, Tile.lighthole, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.hole) {
                level.setTile(x - 1, y - 1, Tile.lighthole, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.hole) {
                level.setTile(x + 1, y - 1, Tile.lighthole, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.hole) {
                level.setTile(x + 1, y + 1, Tile.lighthole, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.hole) {
                level.setTile(x - 1, y + 1, Tile.lighthole, y);
            }
            if (level.getTile(x, y - 1) == Tile.wool) {
                level.setTile(x, y - 1, Tile.lightwool, y);
            }
            if (level.getTile(x, y + 1) == Tile.wool) {
                level.setTile(x, y + 1, Tile.lightwool, y);
            }
            if (level.getTile(x - 1, y) == Tile.wool) {
                level.setTile(x - 1, y, Tile.lightwool, y);
            }
            if (level.getTile(x + 1, y) == Tile.wool) {
                level.setTile(x + 1, y, Tile.lightwool, y);
            }
            if (level.getTile(x, y - 2) == Tile.wool) {
                level.setTile(x, y - 2, Tile.lightwool, y);
            }
            if (level.getTile(x, y + 2) == Tile.wool) {
                level.setTile(x, y + 2, Tile.lightwool, y);
            }
            if (level.getTile(x - 2, y) == Tile.wool) {
                level.setTile(x - 2, y, Tile.lightwool, y);
            }
            if (level.getTile(x + 2, y) == Tile.wool) {
                level.setTile(x + 2, y, Tile.lightwool, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.wool) {
                level.setTile(x - 1, y - 1, Tile.lightwool, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.wool) {
                level.setTile(x + 1, y - 1, Tile.lightwool, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.wool) {
                level.setTile(x + 1, y + 1, Tile.lightwool, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.wool) {
                level.setTile(x - 1, y + 1, Tile.lightwool, y);
            }
            if (level.getTile(x, y - 1) == Tile.redwool) {
                level.setTile(x, y - 1, Tile.lightrwool, y);
            }
            if (level.getTile(x, y + 1) == Tile.redwool) {
                level.setTile(x, y + 1, Tile.lightrwool, y);
            }
            if (level.getTile(x - 1, y) == Tile.redwool) {
                level.setTile(x - 1, y, Tile.lightrwool, y);
            }
            if (level.getTile(x + 1, y) == Tile.redwool) {
                level.setTile(x + 1, y, Tile.lightrwool, y);
            }
            if (level.getTile(x, y - 2) == Tile.redwool) {
                level.setTile(x, y - 2, Tile.lightrwool, y);
            }
            if (level.getTile(x, y + 2) == Tile.redwool) {
                level.setTile(x, y + 2, Tile.lightrwool, y);
            }
            if (level.getTile(x - 2, y) == Tile.redwool) {
                level.setTile(x - 2, y, Tile.lightrwool, y);
            }
            if (level.getTile(x + 2, y) == Tile.redwool) {
                level.setTile(x + 2, y, Tile.lightrwool, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.redwool) {
                level.setTile(x - 1, y - 1, Tile.lightrwool, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.redwool) {
                level.setTile(x + 1, y - 1, Tile.lightrwool, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.redwool) {
                level.setTile(x + 1, y + 1, Tile.lightrwool, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.redwool) {
                level.setTile(x - 1, y + 1, Tile.lightrwool, y);
            }
            if (level.getTile(x, y - 1) == Tile.bluewool) {
                level.setTile(x, y - 1, Tile.lightbwool, y);
            }
            if (level.getTile(x, y + 1) == Tile.bluewool) {
                level.setTile(x, y + 1, Tile.lightbwool, y);
            }
            if (level.getTile(x - 1, y) == Tile.bluewool) {
                level.setTile(x - 1, y, Tile.lightbwool, y);
            }
            if (level.getTile(x + 1, y) == Tile.bluewool) {
                level.setTile(x + 1, y, Tile.lightbwool, y);
            }
            if (level.getTile(x, y - 2) == Tile.bluewool) {
                level.setTile(x, y - 2, Tile.lightbwool, y);
            }
            if (level.getTile(x, y + 2) == Tile.bluewool) {
                level.setTile(x, y + 2, Tile.lightbwool, y);
            }
            if (level.getTile(x - 2, y) == Tile.bluewool) {
                level.setTile(x - 2, y, Tile.lightbwool, y);
            }
            if (level.getTile(x + 2, y) == Tile.bluewool) {
                level.setTile(x + 2, y, Tile.lightbwool, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.bluewool) {
                level.setTile(x - 1, y - 1, Tile.lightbwool, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.bluewool) {
                level.setTile(x + 1, y - 1, Tile.lightbwool, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.bluewool) {
                level.setTile(x + 1, y + 1, Tile.lightbwool, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.bluewool) {
                level.setTile(x - 1, y + 1, Tile.lightbwool, y);
            }
            if (level.getTile(x, y - 1) == Tile.greenwool) {
                level.setTile(x, y - 1, Tile.lightgwool, y);
            }
            if (level.getTile(x, y + 1) == Tile.greenwool) {
                level.setTile(x, y + 1, Tile.lightgwool, y);
            }
            if (level.getTile(x - 1, y) == Tile.greenwool) {
                level.setTile(x - 1, y, Tile.lightgwool, y);
            }
            if (level.getTile(x + 1, y) == Tile.greenwool) {
                level.setTile(x + 1, y, Tile.lightgwool, y);
            }
            if (level.getTile(x, y - 2) == Tile.greenwool) {
                level.setTile(x, y - 2, Tile.lightgwool, y);
            }
            if (level.getTile(x, y + 2) == Tile.greenwool) {
                level.setTile(x, y + 2, Tile.lightgwool, y);
            }
            if (level.getTile(x - 2, y) == Tile.greenwool) {
                level.setTile(x - 2, y, Tile.lightgwool, y);
            }
            if (level.getTile(x + 2, y) == Tile.greenwool) {
                level.setTile(x + 2, y, Tile.lightgwool, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.greenwool) {
                level.setTile(x - 1, y - 1, Tile.lightgwool, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.greenwool) {
                level.setTile(x + 1, y - 1, Tile.lightgwool, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.greenwool) {
                level.setTile(x + 1, y + 1, Tile.lightgwool, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.greenwool) {
                level.setTile(x - 1, y + 1, Tile.lightgwool, y);
            }
            if (level.getTile(x, y - 1) == Tile.yellowwool) {
                level.setTile(x, y - 1, Tile.lightywool, y);
            }
            if (level.getTile(x, y + 1) == Tile.yellowwool) {
                level.setTile(x, y + 1, Tile.lightywool, y);
            }
            if (level.getTile(x - 1, y) == Tile.yellowwool) {
                level.setTile(x - 1, y, Tile.lightywool, y);
            }
            if (level.getTile(x + 1, y) == Tile.yellowwool) {
                level.setTile(x + 1, y, Tile.lightywool, y);
            }
            if (level.getTile(x, y - 2) == Tile.yellowwool) {
                level.setTile(x, y - 2, Tile.lightywool, y);
            }
            if (level.getTile(x, y + 2) == Tile.yellowwool) {
                level.setTile(x, y + 2, Tile.lightywool, y);
            }
            if (level.getTile(x - 2, y) == Tile.yellowwool) {
                level.setTile(x - 2, y, Tile.lightywool, y);
            }
            if (level.getTile(x + 2, y) == Tile.yellowwool) {
                level.setTile(x + 2, y, Tile.lightywool, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.yellowwool) {
                level.setTile(x - 1, y - 1, Tile.lightywool, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.yellowwool) {
                level.setTile(x + 1, y - 1, Tile.lightywool, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.yellowwool) {
                level.setTile(x + 1, y + 1, Tile.lightywool, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.yellowwool) {
                level.setTile(x - 1, y + 1, Tile.lightywool, y);
            }
            if (level.getTile(x, y - 1) == Tile.blackwool) {
                level.setTile(x, y - 1, Tile.lightblwool, y);
            }
            if (level.getTile(x, y + 1) == Tile.blackwool) {
                level.setTile(x, y + 1, Tile.lightblwool, y);
            }
            if (level.getTile(x - 1, y) == Tile.blackwool) {
                level.setTile(x - 1, y, Tile.lightblwool, y);
            }
            if (level.getTile(x + 1, y) == Tile.blackwool) {
                level.setTile(x + 1, y, Tile.lightblwool, y);
            }
            if (level.getTile(x, y - 2) == Tile.blackwool) {
                level.setTile(x, y - 2, Tile.lightblwool, y);
            }
            if (level.getTile(x, y + 2) == Tile.blackwool) {
                level.setTile(x, y + 2, Tile.lightblwool, y);
            }
            if (level.getTile(x - 2, y) == Tile.blackwool) {
                level.setTile(x - 2, y, Tile.lightblwool, y);
            }
            if (level.getTile(x + 2, y) == Tile.blackwool) {
                level.setTile(x + 2, y, Tile.lightblwool, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.blackwool) {
                level.setTile(x - 1, y - 1, Tile.lightblwool, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.blackwool) {
                level.setTile(x + 1, y - 1, Tile.lightblwool, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.blackwool) {
                level.setTile(x + 1, y + 1, Tile.lightblwool, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.blackwool) {
                level.setTile(x - 1, y + 1, Tile.lightblwool, y);
            }
            if (level.getTile(x, y - 1) == Tile.treeSapling) {
                level.setTile(x, y - 1, Tile.lightts, y);
            }
            if (level.getTile(x, y + 1) == Tile.treeSapling) {
                level.setTile(x, y + 1, Tile.lightts, y);
            }
            if (level.getTile(x - 1, y) == Tile.treeSapling) {
                level.setTile(x - 1, y, Tile.lightts, y);
            }
            if (level.getTile(x + 1, y) == Tile.treeSapling) {
                level.setTile(x + 1, y, Tile.lightts, y);
            }
            if (level.getTile(x, y - 2) == Tile.treeSapling) {
                level.setTile(x, y - 2, Tile.lightts, y);
            }
            if (level.getTile(x, y + 2) == Tile.treeSapling) {
                level.setTile(x, y + 2, Tile.lightts, y);
            }
            if (level.getTile(x - 2, y) == Tile.treeSapling) {
                level.setTile(x - 2, y, Tile.lightts, y);
            }
            if (level.getTile(x + 2, y) == Tile.treeSapling) {
                level.setTile(x + 2, y, Tile.lightts, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.treeSapling) {
                level.setTile(x - 1, y - 1, Tile.lightts, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.treeSapling) {
                level.setTile(x + 1, y - 1, Tile.lightts, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.treeSapling) {
                level.setTile(x + 1, y + 1, Tile.lightts, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.treeSapling) {
                level.setTile(x - 1, y + 1, Tile.lightts, y);
            }
            if (level.getTile(x, y - 1) == Tile.cactusSapling) {
                level.setTile(x, y - 1, Tile.lightcs, y);
            }
            if (level.getTile(x, y + 1) == Tile.cactusSapling) {
                level.setTile(x, y + 1, Tile.lightcs, y);
            }
            if (level.getTile(x - 1, y) == Tile.cactusSapling) {
                level.setTile(x - 1, y, Tile.lightcs, y);
            }
            if (level.getTile(x + 1, y) == Tile.cactusSapling) {
                level.setTile(x + 1, y, Tile.lightcs, y);
            }
            if (level.getTile(x, y - 2) == Tile.cactusSapling) {
                level.setTile(x, y - 2, Tile.lightcs, y);
            }
            if (level.getTile(x, y + 2) == Tile.cactusSapling) {
                level.setTile(x, y + 2, Tile.lightcs, y);
            }
            if (level.getTile(x - 2, y) == Tile.cactusSapling) {
                level.setTile(x - 2, y, Tile.lightcs, y);
            }
            if (level.getTile(x + 2, y) == Tile.cactusSapling) {
                level.setTile(x + 2, y, Tile.lightcs, y);
            }
            if (level.getTile(x - 1, y - 1) == Tile.cactusSapling) {
                level.setTile(x - 1, y - 1, Tile.lightcs, y);
            }
            if (level.getTile(x + 1, y - 1) == Tile.cactusSapling) {
                level.setTile(x + 1, y - 1, Tile.lightcs, y);
            }
            if (level.getTile(x + 1, y + 1) == Tile.cactusSapling) {
                level.setTile(x + 1, y + 1, Tile.lightcs, y);
            }
            if (level.getTile(x - 1, y + 1) == Tile.cactusSapling) {
                level.setTile(x - 1, y + 1, Tile.lightcs, y);
            }
        }
    }
    
    @Override
    public boolean canLight() {
        return true;
    }
    
    @Override
    public boolean interact(final Level level, final int xt, final int yt, final Player player, final Item item, final int attackDir) {
        if (item instanceof PowerGloveItem) {
            level.setTile(xt, yt, this.onType, 0);
            level.add(new ItemEntity(new ResourceItem(Resource.torch), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
            return true;
        }
        return false;
    }
}
