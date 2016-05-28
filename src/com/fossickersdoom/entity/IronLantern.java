// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.entity;

import com.fossickersdoom.gfx.Color;

public class IronLantern extends Furniture
{
    public IronLantern() {
        super("I.Lantern");
        this.col0 = Color.get(-1, 100, 211, 433);
        this.col1 = Color.get(-1, 211, 322, 544);
        this.col2 = Color.get(-1, 100, 211, 433);
        this.col3 = Color.get(-1, 0, 100, 322);
        this.col = Color.get(-1, 100, 322, 544);
        this.sprite = 5;
        this.xr = 3;
        this.yr = 2;
    }
    
    @Override
    public int getLightRadius() {
        return 12;
    }
}
