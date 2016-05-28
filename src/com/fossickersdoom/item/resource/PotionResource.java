// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.item.resource;

import com.fossickersdoom.entity.Player;
import com.fossickersdoom.level.Level;
import com.fossickersdoom.level.tile.Tile;

public class PotionResource extends Resource
{
    public int type;
    
    public PotionResource(final String name, final int sprite, final int color, final int potiontype) {
        super(name, sprite, color);
        this.type = potiontype;
    }
    
    @Override
    public boolean interactOn(final Tile tile, final Level level, final int xt, final int yt, final Player player, final int attackDir) {
        if (this.type == 1) {
            if (!player.potioneffects.contains("Speed")) {
                player.speed = 2.0;
                player.potioneffects.add("Speed");
                player.potioneffectstime.add(4200);
                return true;
            }
            for (int i = 0; i < player.potioneffects.size(); ++i) {
                if (player.potioneffects.get(i).equals("Speed")) {
                    player.potioneffectstime.set(player.potioneffects.indexOf(player.potioneffects.get(i)), 4200);
                    return true;
                }
            }
        }
        if (this.type == 2) {
            if (!player.potioneffects.contains("Light")) {
                player.light = 2.5;
                player.potioneffects.add("Light");
                player.potioneffectstime.add(6000);
                return true;
            }
            for (int i = 0; i < player.potioneffects.size(); ++i) {
                if (player.potioneffects.get(i).equals("Light")) {
                    player.potioneffectstime.set(player.potioneffects.indexOf(player.potioneffects.get(i)), 6000);
                    return true;
                }
            }
        }
        if (this.type == 3) {
            if (!player.potioneffects.contains("Swim")) {
                player.infswim = true;
                player.potioneffects.add("Swim");
                player.potioneffectstime.add(4800);
                return true;
            }
            for (int i = 0; i < player.potioneffects.size(); ++i) {
                if (player.potioneffects.get(i).equals("Swim")) {
                    player.potioneffectstime.set(player.potioneffects.indexOf(player.potioneffects.get(i)), 4800);
                    return true;
                }
            }
        }
        if (this.type == 4) {
            if (!player.potioneffects.contains("Energy")) {
                player.infstamina = true;
                player.potioneffects.add("Energy");
                player.potioneffectstime.add(8400);
                return true;
            }
            for (int i = 0; i < player.potioneffects.size(); ++i) {
                if (player.potioneffects.get(i).equals("Energy")) {
                    player.potioneffectstime.set(player.potioneffects.indexOf(player.potioneffects.get(i)), 8400);
                    return true;
                }
            }
        }
        if (this.type == 5) {
            if (!player.potioneffects.contains("Regen")) {
                player.regen = true;
                player.potioneffects.add("Regen");
                player.potioneffectstime.add(1800);
                return true;
            }
            for (int i = 0; i < player.potioneffects.size(); ++i) {
                if (player.potioneffects.get(i).equals("Regen")) {
                    player.potioneffectstime.set(player.potioneffects.indexOf(player.potioneffects.get(i)), 1800);
                    return true;
                }
            }
        }
        if (this.type == 6) {
            if (!player.potioneffects.contains("Time")) {
                player.slowtime = true;
                player.potioneffects.add("Time");
                player.potioneffectstime.add(1800);
                return true;
            }
            for (int i = 0; i < player.potioneffects.size(); ++i) {
                if (player.potioneffects.get(i).equals("Time")) {
                    player.potioneffectstime.set(player.potioneffects.indexOf(player.potioneffects.get(i)), 1800);
                    return true;
                }
            }
        }
        if (this.type == 7) {
            if (!player.potioneffects.contains("Lava")) {
                player.lavaimmune = true;
                player.potioneffects.add("Lava");
                player.potioneffectstime.add(7200);
                return true;
            }
            for (int i = 0; i < player.potioneffects.size(); ++i) {
                if (player.potioneffects.get(i).equals("Lava")) {
                    player.potioneffectstime.set(player.potioneffects.indexOf(player.potioneffects.get(i)), 7200);
                    return true;
                }
            }
        }
        if (this.type == 8) {
            if (!player.potioneffects.contains("Shield")) {
                player.shield = true;
                player.potioneffects.add("Shield");
                player.potioneffectstime.add(5400);
                return true;
            }
            for (int i = 0; i < player.potioneffects.size(); ++i) {
                if (player.potioneffects.get(i).equals("Shield")) {
                    player.potioneffectstime.set(player.potioneffects.indexOf(player.potioneffects.get(i)), 3600);
                    return true;
                }
            }
        }
        if (this.type == 9) {
            if (!player.potioneffects.contains("Haste")) {
                player.haste = true;
                player.potioneffects.add("Haste");
                player.potioneffectstime.add(4800);
                return true;
            }
            for (int i = 0; i < player.potioneffects.size(); ++i) {
                if (player.potioneffects.get(i).equals("Haste")) {
                    player.potioneffectstime.set(player.potioneffects.indexOf(player.potioneffects.get(i)), 4800);
                    return true;
                }
            }
        }
        return false;
    }
    
    public static int potionColor(final String name) {
        if (name.equals("Speed")) {
            return 10;
        }
        if (name.equals("Light")) {
            return 440;
        }
        if (name.equals("Swim")) {
            return 2;
        }
        if (name.equals("Energy")) {
            return 510;
        }
        if (name.equals("Regen")) {
            return 464;
        }
        if (name.equals("Time")) {
            return 222;
        }
        if (name.equals("Lava")) {
            return 400;
        }
        if (name.equals("Shield")) {
            return 115;
        }
        if (name.equals("Haste")) {
            return 303;
        }
        return 0;
    }
}
