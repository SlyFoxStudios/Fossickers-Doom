// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.level.tile;

import com.fossickersdoom.entity.AirWizard;
import com.fossickersdoom.entity.Entity;
import com.fossickersdoom.entity.Mob;
import com.fossickersdoom.entity.Player;
import com.fossickersdoom.entity.particle.SmashParticle;
import com.fossickersdoom.entity.particle.TextParticle;
import com.fossickersdoom.item.Item;
import com.fossickersdoom.item.ToolItem;
import com.fossickersdoom.item.ToolType;
import com.fossickersdoom.level.Level;
import com.fossickersdoom.screen.StartMenu;
import com.fossickersdoom.gfx.Color;
import com.fossickersdoom.gfx.Screen;

public class CloudCactusTile extends Tile
{
    public CloudCactusTile(final int id) {
        super(id);
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
        final int color = Color.get(444, 111, 333, 555);
        screen.render(x * 16 + 0, y * 16 + 0, 49, color, 0);
        screen.render(x * 16 + 8, y * 16 + 0, 50, color, 0);
        screen.render(x * 16 + 0, y * 16 + 8, 81, color, 0);
        screen.render(x * 16 + 8, y * 16 + 8, 82, color, 0);
    }
    
    @Override
    public boolean mayPass(final Level level, final int x, final int y, final Entity e) {
        return e instanceof AirWizard;
    }
    
    @Override
    public void hurt(final Level level, final int x, final int y, final Mob source, final int dmg, final int attackDir) {
        this.hurt(level, x, y, 0);
    }
    
    @Override
    public boolean interact(final Level level, final int xt, final int yt, final Player player, final Item item, final int attackDir) {
        if (item instanceof ToolItem) {
            final ToolItem tool = (ToolItem)item;
            if (tool.type == ToolType.pickaxe && player.payStamina(6 - tool.level)) {
                this.hurt(level, xt, yt, 1);
                return true;
            }
        }
        return false;
    }
    
    public void hurt(final Level level, final int x, final int y, final int dmg) {
        final int damage = level.getData(x, y) + 1;
        level.add(new SmashParticle(x * 16 + 8, y * 16 + 8));
        level.add(new TextParticle(new StringBuilder().append(dmg).toString(), x * 16 + 8, y * 16 + 8, Color.get(-1, 500, 500, 500)));
        if (dmg > 0) {
            if (damage >= 10) {
                level.setTile(x, y, Tile.cloud, 0);
            }
            else {
                level.setData(x, y, damage);
            }
        }
    }
    
    @Override
    public void bumpedInto(final Level level, final int x, final int y, final Entity entity) {
        if (entity instanceof AirWizard) {
            return;
        }
        if (StartMenu.diff == StartMenu.easy) {
            entity.hurt(this, x, y, 3);
        }
        if (StartMenu.diff == StartMenu.norm) {
            entity.hurt(this, x, y, 2);
        }
        if (StartMenu.diff == StartMenu.hard) {
            entity.hurt(this, x, y, 1);
        }
    }
}
