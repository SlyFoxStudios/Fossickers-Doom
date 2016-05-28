// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.screen;

import com.fossickersdoom.gfx.Font;
import com.fossickersdoom.gfx.Color;
import com.fossickersdoom.gfx.Screen;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.awt.event.ActionListener;

public class LoadingMenu extends Menu implements ActionListener
{
    private Menu parent;
    Timer t;
    public static int percentage;
    
    static {
        LoadingMenu.percentage = 0;
    }
    
    public LoadingMenu() {
        this.t = new Timer(400, this);
    }
    
    @Override
    public void tick() {
        this.t.start();
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        this.game.resetstartGame();
        this.game.setMenu(null);
        this.t.stop();
    }
    
    @Override
    public void render(final Screen screen) {
        final int col = Color.get(0, 300, 300, 300);
        final int coll = Color.get(0, 555, 555, 555);
        screen.clear(0);
        Font.draw("Loading...", screen, 110, screen.h - 105, col);
        Font.draw(String.valueOf(LoadingMenu.percentage) + "%", screen, this.centertext(String.valueOf(LoadingMenu.percentage) + "%"), screen.h - 85, col);
    }
}
