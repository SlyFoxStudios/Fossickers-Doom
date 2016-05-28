// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.screen;

import com.fossickersdoom.gfx.Font;
import com.fossickersdoom.gfx.Color;
import com.fossickersdoom.gfx.Screen;
import com.fossickersdoom.sound.Sound;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class ModeMenu extends Menu
{
    private Menu parent;
    public static boolean survival;
    public static boolean creative;
    public static boolean hardcore;
    public static boolean score;
    public static boolean hasSetDif;
    public static int diff;
    public static int loading;
    private static int selectedlr;
    private int selected;
    public static String time;
    public static int selection;
    public static String defaultTime;
    public static List<String> times;
    public static List<String> unlockedtimes;
    
    static {
        ModeMenu.diff = 1;
        ModeMenu.loading = 0;
        ModeMenu.selectedlr = ModeMenu.diff;
        ModeMenu.time = "";
        ModeMenu.selection = 0;
        ModeMenu.defaultTime = "20M";
        ModeMenu.times = new ArrayList<String>();
        ModeMenu.unlockedtimes = new ArrayList<String>();
    }
    
    public ModeMenu() {
        this.selected = 0;
        if (ModeMenu.times.size() < 1) {
            ModeMenu.times.add("20M");
            ModeMenu.times.add("30M");
            ModeMenu.times.add("40M");
            ModeMenu.times.add("1H");
            for (int i = 0; i < ModeMenu.unlockedtimes.size(); ++i) {
                ModeMenu.times.add(ModeMenu.unlockedtimes.get(i));
            }
        }
        final List<Integer> mm = new ArrayList<Integer>();
        final List<Integer> hm = new ArrayList<Integer>();
        for (int j = 0; j < ModeMenu.times.size(); ++j) {
            if (ModeMenu.times.get(j).contains("M")) {
                if (!ModeMenu.times.get(j).contains(".")) {
                    mm.add(Integer.parseInt(ModeMenu.times.get(j).substring(0, ModeMenu.times.get(j).length() - 1)));
                }
                else {
                    mm.add((int)Double.parseDouble(ModeMenu.times.get(j).substring(0, ModeMenu.times.get(j).length() - 1)));
                }
                Collections.sort(mm);
            }
            if (ModeMenu.times.get(j).contains("H")) {
                if (!ModeMenu.times.get(j).contains(".")) {
                    hm.add(Integer.parseInt(ModeMenu.times.get(j).substring(0, ModeMenu.times.get(j).length() - 1)));
                }
                else {
                    hm.add((int)Double.parseDouble(ModeMenu.times.get(j).substring(0, ModeMenu.times.get(j).length() - 1)));
                }
                Collections.sort(hm);
            }
        }
        ModeMenu.times.clear();
        for (int j = 0; j < mm.size(); ++j) {
            ModeMenu.times.add(mm.get(j) + "M");
        }
        for (int j = 0; j < hm.size(); ++j) {
            ModeMenu.times.add(hm.get(j) + "H");
        }
        for (int j = 0; j < ModeMenu.times.size(); ++j) {
            if (ModeMenu.times.get(j).equals(ModeMenu.defaultTime) && ModeMenu.time.equals("")) {
                ModeMenu.time = ModeMenu.times.get(j);
                ModeMenu.selection = j;
            }
        }
    }
    
    @Override
    public void tick() {
        if (this.input.left.clicked) {
            --ModeMenu.selectedlr;
        }
        if (this.input.right.clicked) {
            ++ModeMenu.selectedlr;
        }
        if (this.input.left.clicked) {
            --ModeMenu.diff;
        }
        if (this.input.right.clicked) {
            ++ModeMenu.diff;
        }
        if (this.input.left.clicked) {
            Sound.craft.play();
        }
        if (this.input.right.clicked) {
            Sound.craft.play();
        }
        if (this.input.menu.clicked && this.selected == 0) {
            Sound.test.play();
            if (ModeMenu.diff == 4) {
                if (ModeMenu.times.get(ModeMenu.selection).contains("M")) {
                    this.game.newscoreTime = Integer.parseInt(ModeMenu.times.get(ModeMenu.selection).replace("M", "").replace("H", "")) * 60 * 60;
                }
                else if (ModeMenu.times.get(ModeMenu.selection).contains("H")) {
                    this.game.newscoreTime = Integer.parseInt(ModeMenu.times.get(ModeMenu.selection).replace("H", "").replace("M", "")) * 60 * 60 * 60;
                }
                System.out.println(Integer.parseInt(ModeMenu.times.get(ModeMenu.selection).replace("H", "").replace("M", "")) * 60 * 60 * 60);
            }
            this.game.setMenu(new LoadingMenu());
        }
        if (this.input.attack.clicked) {
            this.game.setMenu(new TitleMenu());
        }
        if (this.input.craft.clicked) {
            this.game.setMenu(new WorldGenMenu());
        }
        if (this.input.t.clicked) {
            ++ModeMenu.selection;
            if (ModeMenu.selection > ModeMenu.times.size() - 1) {
                ModeMenu.selection = 0;
            }
            ModeMenu.time = ModeMenu.times.get(ModeMenu.selection);
        }
        if (ModeMenu.diff == 1) {
            ModeMenu.survival = true;
            ModeMenu.creative = false;
            ModeMenu.hardcore = false;
            ModeMenu.score = false;
        }
        else if (ModeMenu.diff == 2) {
            ModeMenu.survival = false;
            ModeMenu.creative = true;
            ModeMenu.hardcore = false;
            ModeMenu.score = false;
        }
        if (ModeMenu.diff == 3) {
            ModeMenu.survival = false;
            ModeMenu.creative = false;
            ModeMenu.hardcore = true;
            ModeMenu.score = false;
        }
        if (ModeMenu.diff == 4) {
            ModeMenu.survival = false;
            ModeMenu.creative = false;
            ModeMenu.hardcore = false;
            ModeMenu.score = true;
        }
        if (ModeMenu.selectedlr > 4) {
            ModeMenu.selectedlr = 1;
        }
        if (ModeMenu.selectedlr < 1) {
            ModeMenu.selectedlr = 4;
        }
        if (ModeMenu.diff > 4) {
            ModeMenu.diff = 1;
        }
        if (ModeMenu.diff < 1) {
            ModeMenu.diff = 4;
        }
    }
    
    @Override
    public void render(final Screen screen) {
        final int col = Color.get(0, 300, 300, 300);
        final int coll = Color.get(0, 0, 0, 0);
        screen.clear(0);
        String msg = "Game Mode:";
        if (ModeMenu.diff == 1) {
            msg = "Game Mode:  Survival";
        }
        else if (ModeMenu.diff == 2) {
            msg = "Game Mode:  Creative";
        }
        else if (ModeMenu.diff == 3) {
            msg = "Game Mode:  Hardcore";
        }
        else if (ModeMenu.diff == 4) {
            msg = "Game Mode:  Score   ";
        }
        Font.draw(msg, screen, this.centertext(msg) + 1, 77, Color.get(-1, 111, 111, 111));
        Font.draw(msg, screen, this.centertext(msg), 76, Color.get(-1, 555, 555, 555));
        Font.draw("Press X to Start", screen, this.centertext("Press X to Start"), screen.h - 75, Color.get(-1, 555, 555, 555));
        if (ModeMenu.loading == 0) {
            Font.draw("Loading...", screen, 120, screen.h - 105, coll);
        }
        else {
            Font.draw("Loading...", screen, 120, screen.h - 105, col);
        }
        Font.draw("World Name:", screen, this.centertext("World Name:"), screen.h - 180, Color.get(0, 444, 444, 444));
        Font.draw(WorldSelectMenu.worldname, screen, this.centertext(WorldSelectMenu.worldname), screen.h - 170, Color.get(-1, 5, 5, 5));
        Font.draw("Press Left and Right", screen, this.centertext("Press Left and Right"), screen.h - 145, Color.get(-1, 555, 555, 555));
        Font.draw("Press C to Return", screen, this.centertext("Press C to Return"), screen.h - 55, Color.get(-1, 555, 555, 555));
        Font.draw("Press Z for world options", screen, this.centertext("Press Z for world options"), screen.h - 35, Color.get(-1, 555, 555, 555));
        if (ModeMenu.diff == 4) {
            Font.draw("<T>ime: " + ModeMenu.time, screen, this.centertext("<T>ime: " + ModeMenu.time), 92, Color.get(0, 555, 555, 555));
        }
    }
}
