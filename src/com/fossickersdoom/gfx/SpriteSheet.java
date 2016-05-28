// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet
{
    public int width;
    public int height;
    public int[] pixels;
    public int[] extrapixels;
    
    public SpriteSheet(final BufferedImage image) {
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.pixels = image.getRGB(0, 0, this.width, this.height, null, 0, this.width);
        this.extrapixels = image.getRGB(0, 0, this.width, this.height, null, 0, this.width);
        for (int i = 0; i < this.pixels.length; ++i) {
            this.pixels[i] = (this.pixels[i] & 0xFF) / 64;
        }
        for (int i = 0; i < this.extrapixels.length; ++i) {
            this.extrapixels[i] = (this.extrapixels[i] & 0xFF) / 64;
        }
    }
}
