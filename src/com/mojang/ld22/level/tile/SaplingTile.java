// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.level.tile;

import com.mojang.ld22.entity.Mob;
import com.mojang.ld22.Game;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.gfx.Screen;

public class SaplingTile extends Tile
{
    private Tile onType;
    private Tile growsTo;
    
    public SaplingTile(final int id, final Tile onType, final Tile growsTo) {
        super(id);
        this.onType = onType;
        this.growsTo = growsTo;
        this.connectsToSand = onType.connectsToSand;
        this.connectsToGrass = onType.connectsToGrass;
        this.connectsToWater = onType.connectsToWater;
        this.connectsToLava = onType.connectsToLava;
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        final int col0 = Color.get(10, 30, 40, -1);
        final int col2 = Color.get(20, 40, 50, -1);
        final int col3 = Color.get(10, 30, 40, -1);
        final int col4 = Color.get(0, 20, 30, -1);
        final int col5 = Color.get(20, 40, 50, -1);
        this.onType.render(screen, level, x, y);
        if (level.dirtColor == 322) {
            if (Game.Time == 0) {
                final int col6 = col0;
                screen.render(x * 16 + 4, y * 16 + 4, 107, col6, 0);
            }
            if (Game.Time == 1) {
                final int col6 = col2;
                screen.render(x * 16 + 4, y * 16 + 4, 107, col6, 0);
            }
            if (Game.Time == 2) {
                final int col6 = col3;
                screen.render(x * 16 + 4, y * 16 + 4, 107, col6, 0);
            }
            if (Game.Time == 3) {
                final int col6 = col4;
                screen.render(x * 16 + 4, y * 16 + 4, 107, col6, 0);
            }
        }
        if (level.dirtColor == 222) {
            final int col6 = col5;
            screen.render(x * 16 + 4, y * 16 + 4, 107, col6, 0);
        }
    }
    
    @Override
    public void tick(final Level level, final int x, final int y) {
        final int age = level.getData(x, y) + 1;
        if (age > 100) {
            level.setTile(x, y, this.growsTo, 0);
        }
        else {
            level.setData(x, y, age);
        }
    }
    
    @Override
    public void hurt(final Level level, final int x, final int y, final Mob source, final int dmg, final int attackDir) {
        level.setTile(x, y, this.onType, 0);
    }
}
