// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.item;

import com.fossickersdoom.entity.Entity;
import com.fossickersdoom.entity.Furniture;
import com.fossickersdoom.entity.Player;
import com.fossickersdoom.gfx.Font;
import com.fossickersdoom.gfx.Screen;
import com.fossickersdoom.gfx.Color;

public class PowerGloveItem extends Item
{
    @Override
    public int getColor() {
        return Color.get(-1, 100, 320, 430);
    }
    
    @Override
    public int getSprite() {
        return 135;
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
        return "Pow glove";
    }
    
    @Override
    public boolean interact(final Player player, final Entity entity, final int attackDir) {
        if (entity instanceof Furniture) {
            final Furniture f = (Furniture)entity;
            f.take(player);
            return true;
        }
        return false;
    }
}
