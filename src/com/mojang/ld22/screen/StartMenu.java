// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.screen;

import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.sound.Sound;

public class StartMenu extends Menu
{
    public static int easy;
    public static int norm;
    public static int hard;
    public static int diff;
    private static int selectedlr;
    public static boolean isSoundAct;
    private int selected;
    String soundTest;
    public static boolean unlockedskin;
    public static boolean skinon;
    private Menu parent;
    public static boolean hasSetDiff;
    
    static {
        StartMenu.easy = 1;
        StartMenu.norm = 2;
        StartMenu.hard = 3;
        StartMenu.diff = 2;
        StartMenu.selectedlr = StartMenu.diff;
        StartMenu.isSoundAct = true;
        StartMenu.unlockedskin = false;
        StartMenu.skinon = false;
        StartMenu.hasSetDiff = false;
    }
    
    public StartMenu() {
        this.selected = 0;
        this.soundTest = "On";
    }
    
    @Override
    public void tick() {
        if (this.input.left.clicked) {
            --StartMenu.selectedlr;
        }
        if (this.input.right.clicked) {
            ++StartMenu.selectedlr;
        }
        if (this.input.left.clicked) {
            --StartMenu.diff;
        }
        if (this.input.right.clicked) {
            ++StartMenu.diff;
        }
        if (this.input.left.clicked) {
            Sound.craft.play();
        }
        if (this.input.right.clicked) {
            Sound.craft.play();
        }
        if (StartMenu.selectedlr > 3) {
            StartMenu.selectedlr = 1;
        }
        if (StartMenu.selectedlr < 1) {
            StartMenu.selectedlr = 3;
        }
        if (StartMenu.diff > 3) {
            StartMenu.diff = 1;
        }
        if (StartMenu.diff < 1) {
            StartMenu.diff = 3;
        }
        if (this.input.attack.clicked && this.selected == 0) {
            Sound.test.play();
            StartMenu.hasSetDiff = true;
            if (TitleMenu.sentFromMenu) {
                this.game.setMenu(new TitleMenu());
            }
            else {
                this.game.setMenu(new PauseMenu(this.game.player));
            }
        }
        if (StartMenu.unlockedskin && this.input.w.clicked) {
            if (StartMenu.skinon) {
                StartMenu.skinon = false;
            }
            else {
                StartMenu.skinon = true;
            }
        }
        if (this.input.down.clicked) {
            Sound.craft.play();
            if (StartMenu.isSoundAct) {
                StartMenu.isSoundAct = false;
            }
            else {
                StartMenu.isSoundAct = true;
            }
        }
    }
    
    @Override
    public void render(final Screen screen) {
        final int col1 = Color.get(-1, 500, 500, 500);
        final int col2 = Color.get(-1, 50, 50, 50);
        final int rCol = 0;
        screen.clear(0);
        Font.draw("Difficulty:", screen, 70, 64, Color.get(-1, 555, 555, 555));
        if (StartMenu.diff == 1) {
            Font.draw("Easy", screen, 180, 64, Color.get(-1, 555, 555, 555));
        }
        else if (StartMenu.diff == 2) {
            Font.draw("Normal", screen, 180, 64, Color.get(-1, 555, 555, 555));
        }
        else if (StartMenu.diff == 3) {
            Font.draw("Hard", screen, 180, 64, Color.get(-1, 555, 555, 555));
        }
        Font.draw("Press C to return", screen, 80, screen.h - 75, Color.get(0, 555, 555, 555));
        Font.draw("<S>ound:", screen, 80, screen.h - 100, Color.get(0, 555, 555, 555));
        if (StartMenu.isSoundAct) {
            Font.draw("On", screen, 180, screen.h - 100, Color.get(0, 50, 50, 50));
        }
        else {
            Font.draw("Off", screen, 180, screen.h - 100, Color.get(0, 500, 500, 500));
        }
        if (StartMenu.unlockedskin) {
            Font.draw("<W>ear Suit:", screen, 80, screen.h - 110, Color.get(0, 555, 555, 555));
            if (StartMenu.skinon) {
                Font.draw("On", screen, 180, screen.h - 110, Color.get(0, 50, 50, 50));
            }
            else {
                Font.draw("Off", screen, 180, screen.h - 110, Color.get(0, 500, 500, 500));
            }
        }
        Font.draw("Press Left and Right", screen, 67, screen.h - 150, Color.get(0, 555, 555, 555));
    }
}
