// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.level.tile;

import com.fossickersdoom.entity.ItemEntity;
import com.fossickersdoom.item.resource.Resource;
import com.fossickersdoom.sound.Sound;
import com.fossickersdoom.item.ResourceItem;
import com.fossickersdoom.item.ToolType;
import com.fossickersdoom.item.ToolItem;
import com.fossickersdoom.item.Item;
import com.fossickersdoom.entity.Player;
import com.fossickersdoom.Game;
import com.fossickersdoom.gfx.Color;
import com.fossickersdoom.level.Level;
import com.fossickersdoom.gfx.Screen;

public class DirtTile extends Tile
{
    public static int dirtc;
    
    static {
        DirtTile.dirtc = 0;
    }
    
    public DirtTile(final int id) {
        super(id);
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        final int col0 = Color.get(level.dirtColor - 111, level.dirtColor, level.dirtColor - 111, level.dirtColor - 222);
        final int col2 = Color.get(321, 321, 210, 210);
        final int col3 = Color.get(level.dirtColor - 111, level.dirtColor - 111, level.dirtColor - 222, level.dirtColor - 111);
        final int col4 = Color.get(level.dirtColor, level.dirtColor - 222, level.dirtColor - 322, level.dirtColor - 111);
        final int col5 = Color.get(222, 222, 111, 111);
        if (level.depth == 0) {
            if (Game.Time == 0) {
                final int col6 = col0;
                screen.render(x * 16 + 0, y * 16 + 0, 0, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 0, 1, col6, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 2, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 8, 3, col6, 0);
            }
            if (Game.Time == 1) {
                final int col6 = col2;
                screen.render(x * 16 + 0, y * 16 + 0, 0, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 0, 1, col6, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 2, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 8, 3, col6, 0);
            }
            if (Game.Time == 2) {
                final int col6 = col3;
                screen.render(x * 16 + 0, y * 16 + 0, 0, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 0, 1, col6, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 2, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 8, 3, col6, 0);
            }
            if (Game.Time == 3) {
                final int col6 = col4;
                screen.render(x * 16 + 0, y * 16 + 0, 0, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 0, 1, col6, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 2, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 8, 3, col6, 0);
            }
        }
        else if (level.depth != 0) {
            if (Game.Time == 0) {
                final int col6 = col5;
                screen.render(x * 16 + 0, y * 16 + 0, 0, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 0, 1, col6, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 2, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 8, 3, col6, 0);
            }
            if (Game.Time == 1) {
                final int col6 = col5;
                screen.render(x * 16 + 0, y * 16 + 0, 0, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 0, 1, col6, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 2, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 8, 3, col6, 0);
            }
            if (Game.Time == 2) {
                final int col6 = col5;
                screen.render(x * 16 + 0, y * 16 + 0, 0, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 0, 1, col6, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 2, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 8, 3, col6, 0);
            }
            if (Game.Time == 3) {
                final int col6 = col5;
                screen.render(x * 16 + 0, y * 16 + 0, 0, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 0, 1, col6, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 2, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 8, 3, col6, 0);
            }
        }
    }
    
    @Override
    public boolean interact(final Level level, final int xt, final int yt, final Player player, final Item item, final int attackDir) {
        if (item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.shovel && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.hole, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.dirt), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
            if (tool.type == ToolType.spade && player.payStamina(5 - tool.level)) {
                level.setTile(xt, yt, Tile.hole, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.dirt), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
            if (tool.type == ToolType.hoe && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.farmland, 0);
                Sound.monsterHurt.play();
                return true;
            }
        }
        return false;
    }
}
