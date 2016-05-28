// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.item;

import com.fossickersdoom.crafting.Crafting;
import com.fossickersdoom.level.tile.Tile;
import com.fossickersdoom.screen.BookTestMenu;
import com.fossickersdoom.entity.Player;
import com.fossickersdoom.level.Level;
import com.fossickersdoom.gfx.Font;
import com.fossickersdoom.gfx.Screen;
import com.fossickersdoom.gfx.Color;

public class BookItem extends Item
{
    @Override
    public int getColor() {
        return Color.get(-1, 200, 531, 430);
    }
    
    @Override
    public int getSprite() {
        return 142;
    }
    
    @Override
    public void renderIcon(final Screen screen, final int x, final int y) {
        screen.render(x, y, this.getSprite(), this.getColor(), 0);
    }
    
    @Override
    public void renderInventory(final Screen screen, final int x, final int y) {
        screen.render(x, y, this.getSprite(), this.getColor(), 0);
        Font.draw(this.getName(), screen, x + 8, y, Color.get(-1, 555, 555, 555));
    }
    
    @Override
    public String getName() {
        return "Book";
    }
    
    @Override
    public boolean interactOn(final Tile tile, final Level level, final int xt, final int yt, final Player player, final int attackDir) {
        player.game.setMenu(new BookTestMenu(Crafting.workbenchRecipes, player));
        return true;
    }
}
