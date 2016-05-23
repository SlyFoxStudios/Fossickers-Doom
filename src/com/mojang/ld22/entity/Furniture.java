// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.entity;

import com.mojang.ld22.Game;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.item.FurnitureItem;
import com.mojang.ld22.item.PowerGloveItem;

public class Furniture extends Entity
{
    protected int pushTime;
    protected int pushDir;
    public int col;
    public int col0;
    public int col1;
    public int col2;
    public int col3;
    public int sprite;
    public String name;
    public int lightTimer;
    protected Player shouldTake;
    
    public Furniture(final String name) {
        this.pushTime = 0;
        this.pushDir = -1;
        this.lightTimer = 0;
        this.name = name;
        this.xr = 3;
        this.yr = 3;
    }
    
    @Override
    public void tick() {
        if (this.shouldTake != null) {
            if (this.shouldTake.activeItem instanceof PowerGloveItem) {
                this.remove();
                this.shouldTake.inventory.add(0, this.shouldTake.activeItem);
                this.shouldTake.activeItem = new FurnitureItem(this);
            }
            this.shouldTake = null;
        }
        if (this.pushDir == 0) {
            this.move(0, 1);
        }
        if (this.pushDir == 1) {
            this.move(0, -1);
        }
        if (this.pushDir == 2) {
            this.move(-1, 0);
        }
        if (this.pushDir == 3) {
            this.move(1, 0);
        }
        this.pushDir = -1;
        if (this.pushTime > 0) {
            --this.pushTime;
        }
    }
    
    @Override
    public void render(final Screen screen) {
        if (Game.levels[Game.currentLevel].depth == 0) {
            if (Game.Time == 0) {
                screen.render(this.x - 8, this.y - 8 - 4, this.sprite * 2 + 256, this.col0, 0);
                screen.render(this.x - 0, this.y - 8 - 4, this.sprite * 2 + 256 + 1, this.col0, 0);
                screen.render(this.x - 8, this.y - 0 - 4, this.sprite * 2 + 256 + 32, this.col0, 0);
                screen.render(this.x - 0, this.y - 0 - 4, this.sprite * 2 + 256 + 33, this.col0, 0);
            }
            if (Game.Time == 1) {
                screen.render(this.x - 8, this.y - 8 - 4, this.sprite * 2 + 256, this.col1, 0);
                screen.render(this.x - 0, this.y - 8 - 4, this.sprite * 2 + 256 + 1, this.col1, 0);
                screen.render(this.x - 8, this.y - 0 - 4, this.sprite * 2 + 256 + 32, this.col1, 0);
                screen.render(this.x - 0, this.y - 0 - 4, this.sprite * 2 + 256 + 33, this.col1, 0);
            }
            if (Game.Time == 2) {
                screen.render(this.x - 8, this.y - 8 - 4, this.sprite * 2 + 256, this.col2, 0);
                screen.render(this.x - 0, this.y - 8 - 4, this.sprite * 2 + 256 + 1, this.col2, 0);
                screen.render(this.x - 8, this.y - 0 - 4, this.sprite * 2 + 256 + 32, this.col2, 0);
                screen.render(this.x - 0, this.y - 0 - 4, this.sprite * 2 + 256 + 33, this.col2, 0);
            }
            if (Game.Time == 3) {
                screen.render(this.x - 8, this.y - 8 - 4, this.sprite * 2 + 256, this.col3, 0);
                screen.render(this.x - 0, this.y - 8 - 4, this.sprite * 2 + 256 + 1, this.col3, 0);
                screen.render(this.x - 8, this.y - 0 - 4, this.sprite * 2 + 256 + 32, this.col3, 0);
                screen.render(this.x - 0, this.y - 0 - 4, this.sprite * 2 + 256 + 33, this.col3, 0);
            }
        }
        else {
            screen.render(this.x - 8, this.y - 8 - 4, this.sprite * 2 + 256, this.col1, 0);
            screen.render(this.x - 0, this.y - 8 - 4, this.sprite * 2 + 256 + 1, this.col1, 0);
            screen.render(this.x - 8, this.y - 0 - 4, this.sprite * 2 + 256 + 32, this.col1, 0);
            screen.render(this.x - 0, this.y - 0 - 4, this.sprite * 2 + 256 + 33, this.col1, 0);
        }
    }
    
    @Override
    public boolean blocks(final Entity e) {
        return true;
    }
    
    @Override
    protected void touchedBy(final Entity entity) {
        if (entity instanceof Player && this.pushTime == 0) {
            this.pushDir = ((Player)entity).dir;
            this.pushTime = 10;
        }
    }
    
    public void take(final Player player) {
        this.shouldTake = player;
    }
    
    @Override
    public boolean canWool() {
        return true;
    }
}
