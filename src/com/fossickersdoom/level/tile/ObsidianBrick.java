// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.level.tile;

import com.fossickersdoom.Game;
import com.fossickersdoom.entity.Entity;
import com.fossickersdoom.item.Item;
import com.fossickersdoom.sound.Sound;
import com.fossickersdoom.item.ToolType;
import com.fossickersdoom.item.ToolItem;
import com.fossickersdoom.entity.Player;
import com.fossickersdoom.gfx.Color;
import com.fossickersdoom.level.Level;
import com.fossickersdoom.gfx.Screen;

public class ObsidianBrick extends Tile
{
    public ObsidianBrick(final int id) {
        super(id);
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        final int col0 = Color.get(559, 559, 159, 159);
        final int col2 = Color.get(559, 559, 159, 159);
        final int col3 = Color.get(559, 559, 159, 159);
        final int col4 = Color.get(559, 559, 159, 159);
        final int col5 = Color.get(159, 159, 59, 59);
        if (level.dirtColor == 322 && Game.Time == 0) {
            final int col6 = col0;
            screen.render(x * 16 + 0, y * 16 + 0, 83, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 83, col6, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 83, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 83, col6, 0);
        }
        if (Game.Time == 1) {
            final int col6 = col2;
            screen.render(x * 16 + 0, y * 16 + 0, 83, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 83, col6, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 83, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 83, col6, 0);
        }
        if (Game.Time == 2) {
            final int col6 = col3;
            screen.render(x * 16 + 0, y * 16 + 0, 83, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 83, col6, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 83, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 83, col6, 0);
        }
        if (Game.Time == 3) {
            final int col6 = col4;
            screen.render(x * 16 + 0, y * 16 + 0, 83, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 83, col6, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 83, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 83, col6, 0);
        }
        if (level.dirtColor == 222) {
            final int col6 = col5;
            screen.render(x * 16 + 0, y * 16 + 0, 83, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 83, col6, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 83, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 83, col6, 0);
        }
    }
    
    @Override
    public boolean interact(final Level level, final int xt, final int yt, final Player player, final Item item, final int attackDir) {
        if (item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.pickaxe && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.hole, 0);
                Sound.monsterHurt.play();
                return true;
            }
            if (tool.type == ToolType.pick && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.hole, 0);
                Sound.monsterHurt.play();
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean mayPass(final Level level, final int x, final int y, final Entity e) {
        return true;
    }
}
