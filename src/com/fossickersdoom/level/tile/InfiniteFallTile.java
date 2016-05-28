// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.level.tile;

import com.fossickersdoom.entity.AirWizard;
import com.fossickersdoom.entity.Entity;
import com.fossickersdoom.entity.Player;
import com.fossickersdoom.gfx.Screen;
import com.fossickersdoom.level.Level;
import com.fossickersdoom.screen.StartMenu;

public class InfiniteFallTile extends Tile
{
    public InfiniteFallTile(final int id) {
        super(id);
    }
    
    @Override
    public void render(final Screen screen, final Level level, final int x, final int y) {
    }
    
    @Override
    public void tick(final Level level, final int xt, final int yt) {
    }
    
    @Override
    public boolean mayPass(final Level level, final int x, final int y, final Entity e) {
        return e instanceof AirWizard || (e instanceof Player && StartMenu.skinon);
    }
}
