// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.screen;

import com.mojang.ld22.gfx.Screen;

public class InstructionsMenu extends Menu
{
    private Menu parent;
    
    public InstructionsMenu(final Menu parent) {
        this.parent = parent;
    }
    
    @Override
    public void tick() {
    }
    
    @Override
    public void render(final Screen screen) {
        screen.clear(0);
    }
}
