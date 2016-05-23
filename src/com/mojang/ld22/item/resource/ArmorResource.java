// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.item.resource;

import com.mojang.ld22.entity.Player;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.level.tile.Tile;

public class ArmorResource extends Resource
{
    private int heal;
    private int armor;
    private int staminaCost;
    
    public ArmorResource(final String name, final int sprite, final int color, final int heal, final int staminaCost) {
        super(name, sprite, color);
        this.heal = heal;
        this.armor = heal;
        this.staminaCost = staminaCost;
    }
    
    @Override
    public boolean interactOn(final Tile tile, final Level level, final int xt, final int yt, final Player player, final int attackDir) {
        if (player.maxArmor < 1 && player.payStamina(this.staminaCost)) {
            player.maxArmor = this.heal;
            return true;
        }
        return false;
    }
}
