// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.level.tile;

import com.mojang.ld22.entity.Mob;
import com.mojang.ld22.sound.Sound;
import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.entity.ItemEntity;
import com.mojang.ld22.item.ResourceItem;
import com.mojang.ld22.item.resource.Resource;
import com.mojang.ld22.item.ToolType;
import com.mojang.ld22.item.ToolItem;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.Game;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.gfx.Screen;

public class WoodDoorClosedTile extends Tile
{
    public WoodDoorClosedTile(final int id) {
        super(id);
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        final int col0 = Color.get(210, 320, 100, 320);
        final int col2 = Color.get(320, 430, 210, 430);
        final int col3 = Color.get(210, 320, 100, 320);
        final int col4 = Color.get(100, 210, 0, 210);
        final int col5 = Color.get(320, 430, 210, 430);
        if (level.dirtColor == 322) {
            if (Game.Time == 0) {
                final int col6 = col0;
                screen.render(x * 16 + 0, y * 16 + 0, 706, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 0, 707, col6, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 738, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 8, 739, col6, 0);
            }
            if (Game.Time == 1) {
                final int col6 = col2;
                screen.render(x * 16 + 0, y * 16 + 0, 706, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 0, 707, col6, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 738, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 8, 739, col6, 0);
            }
            if (Game.Time == 2) {
                final int col6 = col3;
                screen.render(x * 16 + 0, y * 16 + 0, 706, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 0, 707, col6, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 738, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 8, 739, col6, 0);
            }
            if (Game.Time == 3) {
                final int col6 = col4;
                screen.render(x * 16 + 0, y * 16 + 0, 706, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 0, 707, col6, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 738, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 8, 739, col6, 0);
            }
        }
        if (level.dirtColor == 222) {
            final int col6 = col5;
            screen.render(x * 16 + 0, y * 16 + 0, 704, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 0, 705, col6, 0);
            screen.render(x * 16 + 0, y * 16 + 8, 736, col6, 0);
            screen.render(x * 16 + 8, y * 16 + 8, 737, col6, 0);
        }
    }
    
    @Override
    public boolean interact(final Level level, final int xt, final int yt, final Player player, final Item item, final int attackDir) {
        if (item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.axe && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.plank, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.wdoor), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
            if (tool.type == ToolType.hatchet && player.payStamina(4 - tool.level)) {
                level.setTile(xt, yt, Tile.plank, 0);
                level.add(new ItemEntity(new ResourceItem(Resource.wdoor), xt * 16 + this.random.nextInt(10) + 3, yt * 16 + this.random.nextInt(10) + 3));
                Sound.monsterHurt.play();
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void hurt(final Level level, final int x, final int y, final Mob source, final int dmg, final int attackDir) {
        level.setTile(x, y, Tile.wdo, 0);
    }
    
    @Override
    public boolean mayPass(final Level level, final int x, final int y, final Entity e) {
        return false;
    }
}
