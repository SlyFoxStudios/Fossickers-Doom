// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.level.tile;

import com.fossickersdoom.Game;
import com.fossickersdoom.entity.Entity;
import com.fossickersdoom.entity.ItemEntity;
import com.fossickersdoom.entity.Mob;
import com.fossickersdoom.entity.Player;
import com.fossickersdoom.item.Item;
import com.fossickersdoom.item.ToolItem;
import com.fossickersdoom.item.ToolType;
import com.fossickersdoom.item.resource.Resource;
import com.fossickersdoom.level.Level;
import com.fossickersdoom.sound.Sound;
import com.fossickersdoom.item.ResourceItem;
import com.fossickersdoom.gfx.Color;
import com.fossickersdoom.gfx.Screen;

public class WoodDoorOpenTile extends Tile
{
    public WoodDoorOpenTile(final int id) {
        super(id);
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        final int col0 = Color.get(210, 320, 320, 100);
        final int col2 = Color.get(320, 430, 430, 210);
        final int col3 = Color.get(210, 320, 320, 100);
        final int col4 = Color.get(100, 210, 210, 0);
        final int col5 = Color.get(320, 430, 430, 210);
        if (level.dirtColor == 322) {
            if (Game.Time == 0) {
                final int col6 = col0;
                screen.render(x * 16 + 0, y * 16 + 0, 704, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 0, 705, col6, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 736, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 8, 737, col6, 0);
            }
            if (Game.Time == 1) {
                final int col6 = col2;
                screen.render(x * 16 + 0, y * 16 + 0, 704, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 0, 705, col6, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 736, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 8, 737, col6, 0);
            }
            if (Game.Time == 2) {
                final int col6 = col3;
                screen.render(x * 16 + 0, y * 16 + 0, 704, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 0, 705, col6, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 736, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 8, 737, col6, 0);
            }
            if (Game.Time == 3) {
                final int col6 = col4;
                screen.render(x * 16 + 0, y * 16 + 0, 704, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 0, 705, col6, 0);
                screen.render(x * 16 + 0, y * 16 + 8, 736, col6, 0);
                screen.render(x * 16 + 8, y * 16 + 8, 737, col6, 0);
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
        level.setTile(x, y, Tile.wdc, 0);
    }
    
    @Override
    public boolean mayPass(final Level level, final int x, final int y, final Entity e) {
        return e.canWool();
    }
}
