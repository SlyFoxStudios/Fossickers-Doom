// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.entity.particle;

import com.fossickersdoom.entity.Entity;
import com.fossickersdoom.gfx.Color;
import com.fossickersdoom.gfx.Screen;
import com.fossickersdoom.sound.Sound;

public class FireParticle extends Entity
{
    private int time;
    
    public FireParticle(final int x, final int y) {
        this.time = 0;
        this.x = x;
        this.y = y;
        Sound.monsterHurt.play();
    }
    
    @Override
    public void tick() {
        ++this.time;
        if (this.time > 30) {
            this.remove();
        }
    }
    
    @Override
    public void render(final Screen screen) {
        final int col = Color.get(-1, 520, 550, 500);
        screen.render(this.x - 8, this.y - 8, 425, col, 0);
    }
}
