// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.screen;

import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.crafting.Recipe;
import java.util.List;

public class BookTestMenu extends Menu
{
    public int pages;
    public int lastpage;
    
    public BookTestMenu(final List<Recipe> recipes, final Player player) {
        this.pages = 1;
        this.lastpage = 1;
    }
    
    @Override
    public void tick() {
        if (this.input.menu.clicked) {
            this.game.setMenu(null);
        }
        if (this.input.left.clicked) {
            --this.pages;
        }
        if (this.input.right.clicked) {
            ++this.pages;
        }
    }
    
    @Override
    public void render(final Screen screen) {
        Font.renderFrameBook(screen, "", 14, 0, 21, 3);
        Font.renderFrameBook(screen, "", 1, 4, 34, 20);
        final int xo = 132;
        final int xe = 121;
        final int xa = 129;
        final int xu = 125;
        if (this.pages <= 9 && this.pages >= 1) {
            Font.draw(new StringBuilder().append(this.pages).toString(), screen, xo + 7, 16, Color.get(-1, 0, 0, 0));
        }
        else if (this.pages < 1) {
            Font.draw("Title", screen, xe + 4, 16, Color.get(-1, 0, 0, 0));
        }
        else if (this.pages > 9 && this.pages < 100) {
            Font.draw(new StringBuilder().append(this.pages).toString(), screen, xa + 7, 16, Color.get(-1, 0, 0, 0));
        }
        else if (this.pages > 99) {
            Font.draw(new StringBuilder().append(this.pages).toString(), screen, xu + 7, 16, Color.get(-1, 0, 0, 0));
        }
        Font.draw("Page", screen, 128, 6, Color.get(-1, 0, 0, 0));
        if (this.pages < 1) {
            this.pages = 1;
        }
        if (this.pages > this.lastpage) {
            this.pages = this.lastpage;
        }
        if (this.pages == 0) {
            Font.draw(" ", screen, 80, 40, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 58, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 67, Color.get(-1, 0, 0, 0));
            Font.draw(" ", screen, 48, 76, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 85, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 94, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 103, Color.get(-1, 0, 0, 0));
            Font.draw(" ", screen, 108, 112, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 121, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 130, Color.get(-1, 0, 0, 0));
            Font.draw(" ", screen, 126, 139, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 148, Color.get(-1, 0, 0, 0));
        }
        else if (this.pages == 1) {
            Font.draw("There is nothing of use.", screen, 15, 40, Color.get(-1, 0, 0, 0));
            Font.draw(" ", screen, 15, 49, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 58, Color.get(-1, 0, 0, 0));
            Font.draw(" ", screen, 15, 67, Color.get(-1, 0, 0, 0));
            Font.draw(" ", screen, 15, 76, Color.get(-1, 0, 0, 0));
            Font.draw(" ", screen, 15, 85, Color.get(-1, 0, 0, 0));
            Font.draw(" ", screen, 15, 94, Color.get(-1, 0, 0, 0));
            Font.draw(" ", screen, 15, 103, Color.get(-1, 0, 0, 0));
            Font.draw(" ", screen, 15, 112, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 121, Color.get(-1, 0, 0, 0));
            Font.draw(" ", screen, 15, 130, Color.get(-1, 0, 0, 0));
            Font.draw(" ", screen, 15, 139, Color.get(-1, 0, 0, 0));
            Font.draw(" ", screen, 15, 148, Color.get(-1, 0, 0, 0));
        }
    }
}
