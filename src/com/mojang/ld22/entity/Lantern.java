// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.entity;

import com.mojang.ld22.gfx.Color;

public class Lantern extends Furniture
{
    public Lantern() {
        super("Lantern");
        this.col0 = Color.get(-1, 111, 222, 555);
        this.col1 = Color.get(-1, 222, 333, 555);
        this.col2 = Color.get(-1, 111, 222, 555);
        this.col3 = Color.get(-1, 0, 111, 555);
        this.col = Color.get(-1, 0, 222, 555);
        this.sprite = 5;
        this.xr = 3;
        this.yr = 2;
    }
    
    @Override
    public int getLightRadius() {
        return 9;
    }
}
