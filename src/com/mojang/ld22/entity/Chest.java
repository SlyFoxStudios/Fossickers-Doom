// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.entity;

import com.mojang.ld22.screen.Menu;
import com.mojang.ld22.screen.ContainerMenu;
import com.mojang.ld22.screen.StartMenu;
import com.mojang.ld22.gfx.Color;

public class Chest extends Furniture
{
    public Inventory inventory;
    public boolean isdeathchest;
    public int time;
    public String name;
    int redtick;
    boolean reverse;
    
    public Chest() {
        super("Chest");
        this.inventory = new Inventory();
        this.isdeathchest = false;
        this.time = 0;
        this.redtick = 0;
        if (this.canLight()) {
            this.col0 = Color.get(-1, 220, 331, 552);
            this.col1 = Color.get(-1, 220, 331, 552);
            this.col2 = Color.get(-1, 220, 331, 552);
            this.col3 = Color.get(-1, 220, 331, 552);
        }
        else {
            this.col0 = Color.get(-1, 110, 220, 441);
            this.col1 = Color.get(-1, 220, 331, 552);
            this.col2 = Color.get(-1, 110, 220, 441);
            this.col3 = Color.get(-1, 0, 110, 330);
        }
        this.col = Color.get(-1, 220, 331, 552);
        this.sprite = 1;
    }
    
    @Override
    public void tick() {
        super.tick();
        if (this.isdeathchest) {
            this.name = "Death Chest:" + this.time / 60 + "S";
            if (this.inventory.items.size() < 1) {
                this.remove();
            }
            if (this.time < 3600) {
                this.name = "Death Chest:" + this.time / 60 + "S";
                if (!this.reverse) {
                    ++this.redtick;
                }
                else {
                    --this.redtick;
                }
                if (this.redtick < 5) {
                    this.col0 = Color.get(-1, 100, 200, 300);
                    this.col1 = Color.get(-1, 100, 200, 300);
                    this.col2 = Color.get(-1, 100, 200, 300);
                    this.col3 = Color.get(-1, 100, 200, 300);
                }
                else if (this.redtick > 7 && this.redtick < 11) {
                    this.col0 = Color.get(-1, 200, 300, 400);
                    this.col1 = Color.get(-1, 200, 300, 400);
                    this.col2 = Color.get(-1, 200, 300, 400);
                    this.col3 = Color.get(-1, 200, 300, 400);
                }
                else if (this.redtick > 10) {
                    this.col0 = Color.get(-1, 300, 400, 500);
                    this.col1 = Color.get(-1, 300, 400, 500);
                    this.col2 = Color.get(-1, 300, 400, 500);
                    this.col3 = Color.get(-1, 300, 400, 500);
                }
                if (this.redtick > 13) {
                    this.reverse = true;
                }
                if (this.redtick < 0) {
                    this.reverse = false;
                }
            }
            if (this.time > 0) {
                --this.time;
            }
            if (this.time == 0) {
                this.remove();
            }
        }
    }
    
    public Chest(final boolean deathchest) {
        super("Death Chest");
        this.inventory = new Inventory();
        this.isdeathchest = false;
        this.time = 0;
        this.redtick = 0;
        this.isdeathchest = true;
        if (StartMenu.diff == 1) {
            this.time = 36000;
        }
        else if (StartMenu.diff == 2) {
            this.time = 18000;
        }
        else if (StartMenu.diff == 3) {
            this.time = 1200;
        }
        if (this.canLight()) {
            this.col0 = Color.get(-1, 220, 331, 552);
            this.col1 = Color.get(-1, 220, 331, 552);
            this.col2 = Color.get(-1, 220, 331, 552);
            this.col3 = Color.get(-1, 220, 331, 552);
        }
        else {
            this.col0 = Color.get(-1, 110, 220, 441);
            this.col1 = Color.get(-1, 220, 331, 552);
            this.col2 = Color.get(-1, 110, 220, 441);
            this.col3 = Color.get(-1, 0, 110, 330);
        }
        this.col = Color.get(-1, 220, 331, 552);
        this.sprite = 1;
    }
    
    @Override
    public boolean use(final Player player, final int attackDir) {
        if (this.isdeathchest) {
            this.name = "Death Chest";
        }
        else {
            this.name = "Chest";
        }
        player.game.setMenu(new ContainerMenu(player, this.name, this.inventory, this));
        return true;
    }
}
