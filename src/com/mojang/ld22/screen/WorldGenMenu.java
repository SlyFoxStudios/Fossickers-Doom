// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.screen;

import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.sound.Sound;

public class WorldGenMenu extends Menu
{
    private Menu parent;
    public static int normal;
    public static int forest;
    public static int desert;
    public static int plain;
    public static int hell;
    public static int island;
    public static int box;
    public static int mount;
    public static int irreg;
    public static int sizeNorm;
    public static int sizeBig;
    public static int sizeHuge;
    public static int type;
    public static int theme;
    public static int size;
    public static int sized;
    public static int op;
    private static int selected;
    private static int selectedlr;
    private static int selecteds;
    
    static {
        WorldGenMenu.normal = 10;
        WorldGenMenu.forest = 11;
        WorldGenMenu.desert = 12;
        WorldGenMenu.plain = 13;
        WorldGenMenu.hell = 14;
        WorldGenMenu.island = 0;
        WorldGenMenu.box = 1;
        WorldGenMenu.mount = 2;
        WorldGenMenu.irreg = 3;
        WorldGenMenu.sizeNorm = 128;
        WorldGenMenu.sizeBig = 256;
        WorldGenMenu.sizeHuge = 512;
        WorldGenMenu.type = 0;
        WorldGenMenu.theme = 10;
        WorldGenMenu.size = 0;
        WorldGenMenu.sized = 128;
        WorldGenMenu.op = 0;
        WorldGenMenu.selected = WorldGenMenu.theme;
        WorldGenMenu.selectedlr = WorldGenMenu.type;
        WorldGenMenu.selecteds = WorldGenMenu.size;
    }
    
    public void newLevel() {
    }
    
    @Override
    public void tick() {
        if (this.input.attack.clicked) {
            this.game.setMenu(new ModeMenu());
        }
        if (this.input.down.clicked) {
            --WorldGenMenu.op;
        }
        if (this.input.up.clicked) {
            ++WorldGenMenu.op;
        }
        if (WorldGenMenu.op == 0) {
            if (this.input.left.clicked) {
                --WorldGenMenu.selected;
            }
            if (this.input.right.clicked) {
                ++WorldGenMenu.selected;
            }
            if (this.input.left.clicked) {
                --WorldGenMenu.theme;
            }
            if (this.input.right.clicked) {
                ++WorldGenMenu.theme;
            }
        }
        if (WorldGenMenu.op == 1) {
            if (this.input.left.clicked) {
                --WorldGenMenu.selectedlr;
            }
            if (this.input.right.clicked) {
                ++WorldGenMenu.selectedlr;
            }
            if (this.input.left.clicked) {
                --WorldGenMenu.type;
            }
            if (this.input.right.clicked) {
                ++WorldGenMenu.type;
            }
        }
        if (WorldGenMenu.op == 2) {
            if (this.input.left.clicked) {
                --WorldGenMenu.selecteds;
            }
            if (this.input.right.clicked) {
                ++WorldGenMenu.selecteds;
            }
            if (this.input.left.clicked) {
                --WorldGenMenu.size;
            }
            if (this.input.right.clicked) {
                ++WorldGenMenu.size;
            }
        }
        if (this.input.left.clicked) {
            Sound.craft.play();
        }
        if (this.input.right.clicked) {
            Sound.craft.play();
        }
        if (this.input.up.clicked) {
            Sound.craft.play();
        }
        if (this.input.down.clicked) {
            Sound.craft.play();
        }
        if (WorldGenMenu.op > 2) {
            WorldGenMenu.op = 0;
        }
        if (WorldGenMenu.op < 0) {
            WorldGenMenu.op = 2;
        }
        if (WorldGenMenu.size > 2) {
            WorldGenMenu.size = 0;
        }
        if (WorldGenMenu.size < 0) {
            WorldGenMenu.size = 2;
        }
        if (WorldGenMenu.selected > 14) {
            WorldGenMenu.selected = 10;
        }
        if (WorldGenMenu.selected < 10) {
            WorldGenMenu.selected = 14;
        }
        if (WorldGenMenu.selectedlr > 3) {
            WorldGenMenu.selectedlr = 0;
        }
        if (WorldGenMenu.selectedlr < 0) {
            WorldGenMenu.selectedlr = 3;
        }
        if (WorldGenMenu.theme > 14) {
            WorldGenMenu.theme = 10;
        }
        if (WorldGenMenu.theme < 10) {
            WorldGenMenu.theme = 14;
        }
        if (WorldGenMenu.type > 3) {
            WorldGenMenu.type = 0;
        }
        if (WorldGenMenu.type < 0) {
            WorldGenMenu.type = 3;
        }
        if (WorldGenMenu.selected == 10) {
            WorldGenMenu.theme = WorldGenMenu.normal;
        }
        else if (WorldGenMenu.selected == 11) {
            WorldGenMenu.theme = WorldGenMenu.forest;
        }
        else if (WorldGenMenu.selected == 12) {
            WorldGenMenu.theme = WorldGenMenu.desert;
        }
        else if (WorldGenMenu.selected == 13) {
            WorldGenMenu.theme = WorldGenMenu.plain;
        }
        else if (WorldGenMenu.selected == 14) {
            WorldGenMenu.theme = WorldGenMenu.hell;
        }
        if (WorldGenMenu.size == 0) {
            WorldGenMenu.sized = WorldGenMenu.sizeNorm;
        }
        else if (WorldGenMenu.size == 1) {
            WorldGenMenu.sized = WorldGenMenu.sizeBig;
        }
        else if (WorldGenMenu.size == 2) {
            WorldGenMenu.sized = WorldGenMenu.sizeHuge;
        }
        if (WorldGenMenu.type == 0) {
            WorldGenMenu.type = WorldGenMenu.island;
        }
        else if (WorldGenMenu.type == 1) {
            WorldGenMenu.type = WorldGenMenu.box;
        }
        else if (WorldGenMenu.type == 2) {
            WorldGenMenu.type = WorldGenMenu.mount;
        }
        else if (WorldGenMenu.type == 3) {
            WorldGenMenu.type = WorldGenMenu.irreg;
        }
        if (WorldGenMenu.theme == 10) {
            WorldGenMenu.theme = WorldGenMenu.normal;
        }
        else if (WorldGenMenu.theme == 11) {
            WorldGenMenu.theme = WorldGenMenu.forest;
        }
        else if (WorldGenMenu.theme == 12) {
            WorldGenMenu.theme = WorldGenMenu.desert;
        }
        else if (WorldGenMenu.theme == 13) {
            WorldGenMenu.theme = WorldGenMenu.plain;
        }
        else if (WorldGenMenu.theme == 14) {
            WorldGenMenu.theme = WorldGenMenu.hell;
        }
        if (WorldGenMenu.selectedlr == 0) {
            WorldGenMenu.type = WorldGenMenu.island;
        }
        else if (WorldGenMenu.selectedlr == 1) {
            WorldGenMenu.type = WorldGenMenu.box;
        }
        else if (WorldGenMenu.selectedlr == 2) {
            WorldGenMenu.type = WorldGenMenu.mount;
        }
        else if (WorldGenMenu.selectedlr == 3) {
            WorldGenMenu.type = WorldGenMenu.irreg;
        }
        if (WorldGenMenu.size == 0) {
            WorldGenMenu.sized = WorldGenMenu.sizeNorm;
        }
        else if (WorldGenMenu.size == 1) {
            WorldGenMenu.sized = WorldGenMenu.sizeBig;
        }
        else if (WorldGenMenu.size == 2) {
            WorldGenMenu.sized = WorldGenMenu.sizeHuge;
        }
        if (this.input.left.clicked || this.input.right.clicked) {
            this.newLevel();
        }
    }
    
    @Override
    public void render(final Screen screen) {
        screen.clear(0);
        if (WorldGenMenu.op == 0) {
            Font.draw("Size:", screen, 92, 96, Color.get(-1, 111, 111, 111));
            Font.draw("Theme:", screen, 92, 80, Color.get(-1, 555, 555, 555));
            Font.draw("Type:", screen, 92, 64, Color.get(-1, 111, 111, 111));
        }
        else if (WorldGenMenu.op == 1) {
            Font.draw("Size:", screen, 92, 64, Color.get(-1, 111, 111, 111));
            Font.draw("Type:", screen, 92, 80, Color.get(-1, 555, 555, 555));
            Font.draw("Theme:", screen, 92, 96, Color.get(-1, 111, 111, 111));
        }
        else if (WorldGenMenu.op == 2) {
            Font.draw("Size:", screen, 92, 80, Color.get(-1, 555, 555, 555));
            Font.draw("Type:", screen, 92, 96, Color.get(-1, 111, 111, 111));
            Font.draw("Theme:", screen, 92, 64, Color.get(-1, 111, 111, 111));
        }
        if (WorldGenMenu.op == 0) {
            if (WorldGenMenu.theme == 10) {
                Font.draw("Normal", screen, 158, 80, Color.get(-1, 555, 555, 555));
            }
            else if (WorldGenMenu.theme == 12) {
                Font.draw("Desert", screen, 158, 80, Color.get(-1, 555, 555, 555));
            }
            else if (WorldGenMenu.theme == 11) {
                Font.draw("Forest", screen, 158, 80, Color.get(-1, 555, 555, 555));
            }
            else if (WorldGenMenu.theme == 13) {
                Font.draw("Plain", screen, 158, 80, Color.get(-1, 555, 555, 555));
            }
            else if (WorldGenMenu.theme == 14) {
                Font.draw("Hell", screen, 158, 80, Color.get(-1, 555, 555, 555));
            }
        }
        else if (WorldGenMenu.op == 1) {
            if (WorldGenMenu.type == 0) {
                Font.draw("Island", screen, 147, 80, Color.get(-1, 555, 555, 555));
            }
            else if (WorldGenMenu.type == 1) {
                Font.draw("Box", screen, 147, 80, Color.get(-1, 555, 555, 555));
            }
            else if (WorldGenMenu.type == 2) {
                Font.draw("Mountain", screen, 147, 80, Color.get(-1, 555, 555, 555));
            }
            else if (WorldGenMenu.type == 3) {
                Font.draw("Irregular", screen, 147, 80, Color.get(-1, 555, 555, 555));
            }
        }
        else if (WorldGenMenu.op == 2) {
            if (WorldGenMenu.size == 0) {
                Font.draw("Normal (128 x 128)", screen, 136, 80, Color.get(-1, 555, 555, 555));
            }
            else if (WorldGenMenu.size == 1) {
                Font.draw("Big (256 x 256)", screen, 136, 80, Color.get(-1, 555, 555, 555));
            }
            else if (WorldGenMenu.size == 2) {
                Font.draw("Huge (512 x 512)", screen, 136, 80, Color.get(-1, 555, 555, 555));
            }
        }
        Font.draw("World Options", screen, 92, 24, Color.get(0, 555, 555, 555));
        Font.draw("Arrow keys to scroll", screen, 70, 128, Color.get(-1, 555, 555, 555));
        Font.draw("Press c to exit", screen, 85, 144, Color.get(-1, 555, 555, 555));
    }
}
