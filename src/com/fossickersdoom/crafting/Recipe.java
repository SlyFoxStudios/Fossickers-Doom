// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.crafting;

import com.fossickersdoom.entity.Player;
import com.fossickersdoom.gfx.Color;
import com.fossickersdoom.gfx.Font;
import com.fossickersdoom.gfx.Screen;
import com.fossickersdoom.item.resource.Resource;
import com.fossickersdoom.screen.ListItem;
import com.fossickersdoom.screen.ModeMenu;
import com.fossickersdoom.item.BucketLavaItem;
import com.fossickersdoom.item.ToolItem;
import com.fossickersdoom.item.ToolType;

import java.util.ArrayList;
import com.fossickersdoom.item.ResourceItem;
import com.fossickersdoom.item.Item;
import java.util.List;

public abstract class Recipe implements ListItem
{
    public List<Item> costs;
    public boolean canCraft;
    public Item resultTemplate;
    public ResourceItem ri;
    
    public Recipe(final Item resultTemplate) {
        this.costs = new ArrayList<Item>();
        this.canCraft = false;
        this.resultTemplate = resultTemplate;
    }
    
    public Recipe addCost(final Resource resource, final int count) {
        this.costs.add(new ResourceItem(resource, count));
        return this;
    }
    
    public Recipe addCostTool(final ToolType tool, final int level, final int counts) {
        this.costs.add(new ToolItem(tool, level));
        return this;
    }
    
    public Recipe addCostBucketLava(final int counts) {
        this.costs.add(new BucketLavaItem());
        return this;
    }
    
    public void checkCanCraft(final Player player) {
        for (int i = 0; i < this.costs.size(); ++i) {
            final Item item = this.costs.get(i);
            if (item instanceof ResourceItem) {
                final ResourceItem ri = (ResourceItem)item;
                if (!player.inventory.hasResources(ri.resource, ri.count) && !ModeMenu.creative) {
                    this.canCraft = false;
                    return;
                }
            }
            else if (item instanceof ToolItem) {
                final ToolItem ti = (ToolItem)item;
                if (!player.inventory.hasTools(ti.type, ti.level) && !ModeMenu.creative) {
                    this.canCraft = false;
                    return;
                }
            }
            else if (item instanceof BucketLavaItem) {
                final BucketLavaItem ti2 = (BucketLavaItem)item;
                if (!player.inventory.hasItem(ti2) && !ModeMenu.creative) {
                    this.canCraft = false;
                    return;
                }
            }
        }
        this.canCraft = true;
    }
    
    @Override
    public void renderInventory(final Screen screen, final int x, final int y) {
        screen.render(x, y, this.resultTemplate.getSprite(), this.resultTemplate.getColor(), 0);
        final int textColor = this.canCraft ? Color.get(-1, 555, 555, 555) : Color.get(-1, 222, 222, 222);
        Font.draw(this.resultTemplate.getName(), screen, x + 8, y, textColor);
        if (this.resultTemplate.getName() == "Torch") {
            Font.draw(String.valueOf(this.resultTemplate.getName()) + " x2", screen, x + 8, y, textColor);
        }
        if (this.resultTemplate.getName() == "string") {
            Font.draw(String.valueOf(this.resultTemplate.getName()) + " x2", screen, x + 8, y, textColor);
        }
        if (this.resultTemplate.getName() == "Plank") {
            Font.draw(String.valueOf(this.resultTemplate.getName()) + " x2", screen, x + 8, y, textColor);
        }
        if (this.resultTemplate.getName() == "St.Brick") {
            Font.draw(String.valueOf(this.resultTemplate.getName()) + " x2", screen, x + 8, y, textColor);
        }
        if (this.resultTemplate.getName() == "arrow") {
            this.ri = (ResourceItem)this.resultTemplate;
            Font.draw(String.valueOf(this.resultTemplate.getName()) + " x" + this.ri.amount, screen, x + 8, y, textColor);
        }
    }
    
    public abstract void craft(final Player p0);
    
    public void deductCost(final Player player) {
        for (int i = 0; i < this.costs.size(); ++i) {
            final Item item = this.costs.get(i);
            if (item instanceof ResourceItem) {
                final ResourceItem ri = (ResourceItem)item;
                player.inventory.removeResource(ri.resource, ri.count);
            }
            else if (item instanceof ToolItem) {
                final ToolItem ti = (ToolItem)item;
                player.inventory.removeTool(ti.type, ti.level);
            }
            else if (item instanceof BucketLavaItem) {
                final BucketLavaItem ti2 = (BucketLavaItem)item;
                player.inventory.removeItem(ti2);
            }
        }
    }
}
