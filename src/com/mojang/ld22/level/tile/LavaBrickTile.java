// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.level.tile;

import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.sound.Sound;
import com.mojang.ld22.item.ToolType;
import com.mojang.ld22.item.ToolItem;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.gfx.Screen;

public class LavaBrickTile extends Tile
{
    public LavaBrickTile(final int id) {
        super(id);
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        final int col = Color.get(300, 300, 400, 400);
        screen.render(x * 16 + 0, y * 16 + 0, 83, col, 0);
        screen.render(x * 16 + 8, y * 16 + 0, 83, col, 0);
        screen.render(x * 16 + 0, y * 16 + 8, 83, col, 0);
        screen.render(x * 16 + 8, y * 16 + 8, 83, col, 0);
    }
    
    @Override
    public boolean interact(final Level level, final int xt, final int yt, final Player player, final Item item, final int attackDir) {
        if (item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.pickaxe && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.lava, 0);
                Sound.monsterHurt.play();
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void bumpedInto(final Level level, final int x, final int y, final Entity entity) {
        entity.hurt(this, x, y, 3);
    }
    
    @Override
    public boolean mayPass(final Level level, final int x, final int y, final Entity e) {
        return e.canWool();
    }
}
