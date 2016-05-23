// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.item;

import com.mojang.ld22.entity.Player;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.level.tile.Tile;
import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.gfx.Color;

public class BucketItem extends Item
{
    @Override
    public int getColor() {
        return Color.get(-1, 222, 333, 555);
    }
    
    @Override
    public int getSprite() {
        return 149;
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
        return "Bucket";
    }
    
    @Override
    public boolean interactOn(final Tile tile, final Level level, final int xt, final int yt, final Player player, final int attackDir) {
        if (tile == Tile.water) {
            level.setTile(xt, yt, Tile.hole, 0);
            final Item item = new BucketWaterItem();
            player.activeItem = item;
        }
        if (tile == Tile.lava) {
            level.setTile(xt, yt, Tile.hole, 0);
            final Item item = new BucketLavaItem();
            player.activeItem = item;
        }
        return true;
    }
}
