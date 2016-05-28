package com.fossickersdoom.screen;

import com.fossickersdoom.Game;
import com.fossickersdoom.entity.Player;
import com.fossickersdoom.gfx.Font;
import com.fossickersdoom.gfx.Screen;
import com.fossickersdoom.item.Item;
import com.fossickersdoom.sound.Sound;

public class InventoryMenu extends Menu {

    private Player player;
    private int selected = 0;


    public InventoryMenu(Player player) {
        this.player = player;
        if(player.activeItem != null) {
            player.inventory.items.add(0, player.activeItem);
            player.activeItem = null;
        }

    }

    public void tick() {
        if(this.input.menu.clicked) {
            this.game.setMenu((Menu)null);
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

        int len = this.player.inventory.items.size();
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
            Item item = (Item)this.player.inventory.items.remove(this.selected);
            if(item.getName() == "Fish Rod") {
                Game.truerod = true;
            } else {
                Game.truerod = false;
            }

            this.player.activeItem = item;
            this.game.setMenu((Menu)null);
        }

    }

    public void render(Screen screen) {
        Font.renderFrame(screen, "inventory", 1, 1, 20, 11);
        this.renderItemList(screen, 1, 1, 20, 11, this.player.inventory.items, this.selected);
    }
}