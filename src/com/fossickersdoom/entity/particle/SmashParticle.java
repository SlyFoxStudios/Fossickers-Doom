// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.entity.particle;

import com.fossickersdoom.gfx.Color;
import com.fossickersdoom.gfx.Screen;
import com.fossickersdoom.sound.Sound;
import com.fossickersdoom.entity.Entity;

public class SmashParticle extends Entity
{
    private int time;
    
    public SmashParticle(final int x, final int y) {
        this.time = 0;
        this.x = x;
        this.y = y;
        Sound.monsterHurt.play();
    }
    
    @Override
    public void tick() {
        ++this.time;
        if (this.time > 10) {
            this.remove();
        }
    }
    
    @Override
    public void render(final Screen screen) {
        final int col = Color.get(-1, 555, 555, 555);
        screen.render(this.x - 8, this.y - 8, 389, col, 2);
        screen.render(this.x - 0, this.y - 8, 389, col, 3);
        screen.render(this.x - 8, this.y - 0, 389, col, 0);
        screen.render(this.x - 0, this.y - 0, 389, col, 1);
    }
}
