// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.screen;

import com.fossickersdoom.gfx.Font;
import com.fossickersdoom.gfx.Color;
import com.fossickersdoom.gfx.Screen;

public class AboutMenu extends Menu
{
    private Menu parent;
    
    public AboutMenu(final Menu parent) {
        this.parent = parent;
    }
    
    @Override
    public void tick() {
        if (this.input.attack.clicked || this.input.menu.clicked) {
            this.game.setMenu(this.parent);
        }
    }
    
    @Override
    public void render(final Screen screen) {
        screen.clear(0);
        Font.draw("About MinicraftPlus", screen, 68, 8, Color.get(0, 555, 555, 555));
        Font.draw("Moded by David.b and +Dillyg10+", screen, 20, 24, Color.get(0, 333, 333, 333));
        Font.draw("Our goal is to expand Minicraft to", screen, 12, 40, Color.get(0, 333, 333, 333));
        Font.draw("be more fun and continuous.", screen, 44, 48, Color.get(0, 333, 333, 333));
        Font.draw("Minicraft made by Markus Perrson", screen, 12, 64, Color.get(0, 333, 333, 333));
        Font.draw("for ludum dare 22 competition.", screen, 20, 72, Color.get(0, 333, 333, 333));
    }
}
