// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.entity;

import com.fossickersdoom.gfx.Color;

public class GoldLantern extends Furniture
{
    public GoldLantern() {
        super("G.Lantern");
        this.col0 = Color.get(-1, 110, 330, 442);
        this.col1 = Color.get(-1, 220, 440, 553);
        this.col2 = Color.get(-1, 110, 330, 442);
        this.col3 = Color.get(-1, 0, 220, 331);
        this.col = Color.get(-1, 110, 440, 553);
        this.sprite = 5;
        this.xr = 3;
        this.yr = 2;
    }
    
    @Override
    public int getLightRadius() {
        return 15;
    }
}
