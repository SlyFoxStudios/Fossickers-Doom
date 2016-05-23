// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.entity;

import java.util.List;
import com.mojang.ld22.Game;
import com.mojang.ld22.gfx.Color;

public class bed extends Furniture
{
    public static boolean hasBedSet;
    public static boolean hasBeenTrigged;
    public static int newSpawnY;
    public static int newSpawnX;
    
    static {
        bed.hasBeenTrigged = false;
    }
    
    public bed() {
        super("Bed");
        this.col0 = Color.get(-1, 211, 444, 400);
        this.col1 = Color.get(-1, 211, 555, 500);
        this.col2 = Color.get(-1, 100, 333, 300);
        this.col3 = Color.get(-1, 0, 222, 200);
        this.col = Color.get(-1, 100, 444, 400);
        this.sprite = 8;
        this.xr = 3;
        this.yr = 2;
    }
    
    @Override
    public boolean use(final Player player, final int attackDir) {
        final Game game = player.game;
        if (!Game.isDayNoSleep) {
            bed.hasBedSet = true;
            Player.spawnx = this.y / 16;
            Player.spawny = this.x / 16;
            player.bedSpawn = true;
            System.out.println(String.valueOf(this.x) + "/" + this.y + "//" + Player.spawnx + "/" + Player.spawny);
        }
        else {
            final List<String> notifications = Game.notifications;
            final StringBuilder sb = new StringBuilder("Can't sleep! ");
            final int n = 43200;
            final Game game2 = player.game;
            final StringBuilder append = sb.append((n - Game.tickCount) / 60 / 60).append("Min ");
            final int n2 = 43200;
            final Game game3 = player.game;
            final int n3 = (n2 - Game.tickCount) / 60;
            final int n4 = 60;
            final int n5 = 43200;
            final Game game4 = player.game;
            notifications.add(append.append(n3 - n4 * ((n5 - Game.tickCount) / 60 / 60)).append(" Sec left!").toString());
        }
        return true;
    }
}
