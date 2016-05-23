package com.mojang.ld22.screen;

import com.mojang.ld22.entity.Chest;
import com.mojang.ld22.entity.Inventory;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.item.Item;
import com.mojang.ld22.screen.Menu;
import com.mojang.ld22.sound.Sound;

public class ContainerMenu extends Menu {

    private Player player;
    private Inventory container;
    private int selected = 0;
    private String title;
    private int oSelected;
    private int window = 0;
    private Chest chest;


    public ContainerMenu(Player player, String title, Inventory container) {
        this.player = player;
        this.title = title;
        this.container = container;
    }

    public ContainerMenu(Player player, String title, Inventory container, Chest deathchest) {
        this.player = player;
        this.title = title;
        this.container = container;
        this.chest = deathchest;
    }

    public void tick() {
        if(this.chest != null && this.chest.name.contains("Death Chest")) {
            this.chest.tick();
            this.title = this.chest.name;
            if(this.chest.inventory.items.size() < 1) {
                this.game.setMenu((Menu)null);
            }

            if(this.chest.time < 1) {
                this.game.setMenu((Menu)null);
            }
        }

        if(this.input.menu.clicked) {
            this.game.setMenu((Menu)null);
        }

        int i;
        if(this.input.left.clicked) {
            this.window = 0;
            i = this.selected;
            this.selected = this.oSelected;
            this.oSelected = i;
        }

        if(this.input.right.clicked) {
            this.window = 1;
            i = this.selected;
            this.selected = this.oSelected;
            this.oSelected = i;
        }

        Inventory var4 = this.window == 1?this.player.inventory:this.container;
        Inventory i2 = this.window == 0?this.player.inventory:this.container;
        int len = var4.items.size();
        if(this.selected < 0) {
            this.selected = 0;
        }

        if(this.selected >= len) {
            this.selected = len - 1;
        }

        if(this.input.up.clicked) {
            --this.selected;
        }

        if(this.input.down.clicked) {
            ++this.selected;
        }

        if(this.input.up.clicked) {
            Sound.pickup.play();
        }

        if(this.input.down.clicked) {
            Sound.pickup.play();
        }

        if(len == 0) {
            this.selected = 0;
        }

        if(this.selected < 0) {
            this.selected += len;
        }

        if(this.selected >= len) {
            this.selected -= len;
        }

        if(this.input.attack.clicked && len > 0) {
            i2.add(this.oSelected, (Item)var4.items.remove(this.selected));
            if(this.selected >= var4.items.size()) {
                this.selected = var4.items.size() - 1;
            }
        }

    }

    public void render(Screen screen) {
        if(this.window == 1) {
            screen.setOffset(48, 0);
        }

        Font.renderFrame(screen, this.title, 1, 1, 18, 11);
        this.renderItemList(screen, 1, 1, 18, 11, this.container.items, this.window == 0?this.selected:-this.oSelected - 1);
        Font.renderFrame(screen, "inventory", 19, 1, 35, 11);
        this.renderItemList(screen, 19, 1, 35, 11, this.player.inventory.items, this.window == 1?this.selected:-this.oSelected - 1);
        screen.setOffset(0, 0);
    }
}