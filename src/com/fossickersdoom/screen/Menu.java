// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.screen;

import com.fossickersdoom.gfx.Font;
import com.fossickersdoom.gfx.Color;
import java.util.List;
import com.fossickersdoom.gfx.Screen;
import com.fossickersdoom.InputHandler;
import com.fossickersdoom.Game;

public class Menu
{
    protected Game game;
    protected InputHandler input;
    
    public void init(final Game game, final InputHandler input) {
        this.input = input;
        this.game = game;
    }
    
    public void tick() {
    }
    
    public void render(final Screen screen) {
    }
    
    public int centertext(final String name) {
        return (288 - name.length() * 8) / 2;
    }
    
    public void renderItemList(final Screen screen, final int xo, final int yo, final int x1, final int y1, final List<? extends ListItem> listItems, int selected) {
        boolean renderCursor = true;
        if (selected < 0) {
            selected = -selected - 1;
            renderCursor = false;
        }
        final int w = x1 - xo;
        final int h = y1 - yo - 1;
        final int i0 = 0;
        int i2 = listItems.size();
        if (i2 > h) {
            i2 = h;
        }
        int io = selected - h / 2;
        if (io > listItems.size() - h) {
            io = listItems.size() - h;
        }
        if (io < 0) {
            io = 0;
        }
        for (int j = i0; j < i2; ++j) {
            ((ListItem)listItems.get(j + io)).renderInventory(screen, (1 + xo) * 8, (j + 1 + yo) * 8);
        }
        if (renderCursor) {
            final int yy = selected + 1 - io + yo;
            Font.draw(">", screen, (xo + 0) * 8, yy * 8, Color.get(-1, 555, 555, 555));
            Font.draw("<", screen, (xo + w) * 8, yy * 8, Color.get(-1, 555, 555, 555));
        }
    }
}
