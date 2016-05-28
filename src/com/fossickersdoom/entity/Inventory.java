package com.fossickersdoom.entity;

import com.fossickersdoom.Game;
import com.fossickersdoom.item.BucketLavaItem;
import com.fossickersdoom.item.Item;
import com.fossickersdoom.item.resource.Resource;
import com.fossickersdoom.item.ResourceItem;
import com.fossickersdoom.item.ToolItem;
import com.fossickersdoom.item.ToolType;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    public List items = new ArrayList();
    public boolean playerinventory = false;


    public Inventory() {}

    public Inventory(Player player) {
        this.playerinventory = true;
    }

    public void add(Item item) {
        this.add(this.items.size(), item);
    }

    public void add(int slot, Item item) {
        if(item instanceof ResourceItem) {
            ResourceItem toTake = (ResourceItem)item;
            ResourceItem has = this.findResource(toTake.resource);
            if(has == null) {
                if(toTake.resource.equals(Resource.arrow) && this.playerinventory) {
                    Game.ac += toTake.count;
                } else {
                    this.items.add(slot, toTake);
                }
            } else {
                has.count += toTake.count;
            }
        } else {
            this.items.add(slot, item);
        }

    }

    private ResourceItem findResource(Resource resource) {
        for(int i = 0; i < this.items.size(); ++i) {
            if(this.items.get(i) instanceof ResourceItem) {
                ResourceItem has = (ResourceItem)this.items.get(i);
                if(has.resource == resource) {
                    return has;
                }
            }
        }

        return null;
    }

    private Item findItem(Item item) {
        System.out.println(item.getName());

        for(int i = 0; i < this.items.size(); ++i) {
            Item has = (Item)this.items.get(i);
            if(has.getName().equals(item.getName())) {
                return has;
            }
        }

        System.out.println("Is null!");
        return null;
    }

    private ToolItem findtool(ToolType type) {
        for(int i = 0; i < this.items.size(); ++i) {
            if(this.items.get(i) instanceof ToolItem) {
                ToolItem hass = (ToolItem)this.items.get(i);
                if(hass.type == type) {
                    return hass;
                }
            }
        }

        return null;
    }

    public boolean hasResources(Resource r, int count) {
        ResourceItem ri = this.findResource(r);
        return ri == null?false:ri.count >= count;
    }

    public boolean hasTools(ToolType t, int level) {
        ToolItem ti = this.findtool(t);
        return ti == null?false:ti.level >= level;
    }

    public boolean hasItem(Item i) {
        Item ti = this.findItem(i);
        return ti != null;
    }

    public boolean removeResource(Resource r, int count) {
        ResourceItem ri = this.findResource(r);
        if(ri == null) {
            return false;
        } else if(ri.count < count) {
            return false;
        } else {
            ri.count -= count;
            if(ri.count <= 0) {
                this.items.remove(ri);
            }

            return true;
        }
    }

    public boolean removeItem(Item i) {
        BucketLavaItem ri = (BucketLavaItem)this.findItem(i);
        if(ri == null) {
            return false;
        } else {
            this.items.remove(ri);
            return true;
        }
    }

    public boolean removeTool(ToolType t, int level) {
        ToolItem ti = this.findtool(t);
        if(ti == null) {
            return false;
        } else if(ti.level < level) {
            return false;
        } else {
            ti.level -= level;
            if(ti.level <= 0) {
                this.items.remove(ti);
            }

            return true;
        }
    }

    public int scored(Resource r) {
        int lscore = 0;
        ResourceItem ri = this.findResource(r);
        if(ri == null) {
            lscore = 0;
        } else if(ri != null) {
            lscore = ri.count;
        }

        if(r == Resource.arrow) {
            lscore = Game.ac;
        }

        return lscore;
    }

    public int count(Item item) {
        if(item instanceof ResourceItem) {
            ResourceItem var4 = this.findResource(((ResourceItem)item).resource);
            return var4 != null?var4.count:0;
        } else {
            int count = 0;

            for(int i = 0; i < this.items.size(); ++i) {
                if(((Item)this.items.get(i)).matches(item)) {
                    ++count;
                }
            }

            return count;
        }
    }
}