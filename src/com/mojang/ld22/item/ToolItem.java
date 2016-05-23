// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.item;

import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.entity.ItemEntity;
import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.gfx.Color;
import java.util.Random;

public class ToolItem extends Item
{
    private Random random;
    public int counts;
    public static final int MAX_LEVEL = 5;
    public static final String[] LEVEL_NAMES;
    public ToolType type;
    public int level;
    public ToolType tool;
    public static final int[] LEVEL_COLORS;
    public static final int[] BOW_COLORS;
    
    static {
        LEVEL_NAMES = new String[] { "Wood", "Rock", "Iron", "Gold", "Gem" };
        LEVEL_COLORS = new int[] { Color.get(-1, 100, 321, 431), Color.get(-1, 100, 321, 111), Color.get(-1, 100, 321, 555), Color.get(-1, 100, 321, 550), Color.get(-1, 100, 321, 45) };
        BOW_COLORS = new int[] { Color.get(-1, 100, 444, 431), Color.get(-1, 100, 444, 111), Color.get(-1, 100, 444, 555), Color.get(-1, 100, 444, 550), Color.get(-1, 100, 444, 45) };
    }
    
    public ToolItem(final ToolType type, final int level) {
        this.random = new Random();
        this.counts = 1;
        this.level = 0;
        this.type = type;
        this.level = level;
    }
    
    @Override
    public int getColor() {
        if (this.type == ToolType.bow) {
            return ToolItem.BOW_COLORS[this.level];
        }
        return ToolItem.LEVEL_COLORS[this.level];
    }
    
    @Override
    public int getSprite() {
        return this.type.sprite + 160;
    }
    
    @Override
    public void renderIcon(final Screen screen, final int x, final int y) {
        screen.render(x, y, this.getSprite(), this.getColor(), 0);
    }
    
    @Override
    public void renderInventory(final Screen screen, final int x, final int y) {
        screen.render(x, y, this.getSprite(), this.getColor(), 0);
        Font.draw(this.getName(), screen, x + 8, y, Color.get(-1, 555, 555, 555));
    }
    
    @Override
    public String getName() {
        return String.valueOf(ToolItem.LEVEL_NAMES[this.level]) + " " + this.type.name;
    }
    
    @Override
    public void onTake(final ItemEntity itemEntity) {
    }
    
    @Override
    public boolean canAttack() {
        return true;
    }
    
    @Override
    public int getAttackDamageBonus(final Entity e) {
        if (this.type == ToolType.hatchet) {
            return (this.level + 1) * 2 + this.random.nextInt(3);
        }
        if (this.type == ToolType.axe) {
            return (this.level + 1) * 2 + this.random.nextInt(4);
        }
        if (this.type == ToolType.sword) {
            return (this.level + 1) * 3 + this.random.nextInt(2 + this.level * this.level * 2);
        }
        if (this.type == ToolType.claymore) {
            return (this.level + 1) * 3 + this.random.nextInt(4 + this.level * this.level * 3);
        }
        return 1;
    }
    
    @Override
    public boolean matches(final Item item) {
        if (item instanceof ToolItem) {
            final ToolItem other = (ToolItem)item;
            return other.type == this.type && other.level == this.level;
        }
        return false;
    }
}
