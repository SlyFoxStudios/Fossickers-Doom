// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22.item;

public class ToolType
{
    public static ToolType shovel;
    public static ToolType hoe;
    public static ToolType sword;
    public static ToolType pickaxe;
    public static ToolType axe;
    public static ToolType bow;
    public static ToolType claymore;
    public static ToolType hatchet;
    public static ToolType spade;
    public static ToolType pick;
    public final String name;
    public final int sprite;
    
    static {
        ToolType.shovel = new ToolType("Shovel", 0);
        ToolType.hoe = new ToolType("Hoe", 1);
        ToolType.sword = new ToolType("Sword", 2);
        ToolType.pickaxe = new ToolType("Pickaxe", 3);
        ToolType.axe = new ToolType("Axe", 4);
        ToolType.bow = new ToolType("Bow", 5);
        ToolType.claymore = new ToolType("Claymore", 7);
        ToolType.hatchet = new ToolType("Hatchet", 10);
        ToolType.spade = new ToolType("Spade", 11);
        ToolType.pick = new ToolType("Pick", 12);
    }
    
    private ToolType(final String name, final int sprite) {
        this.name = name;
        this.sprite = sprite;
    }
}
