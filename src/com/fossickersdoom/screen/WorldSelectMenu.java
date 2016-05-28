// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.screen;

import com.fossickersdoom.gfx.Font;
import com.fossickersdoom.gfx.Screen;
import com.fossickersdoom.sound.Sound;
import com.fossickersdoom.gfx.Color;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class WorldSelectMenu extends Menu
{
    private Menu parent;
    private int selected;
    private int worldselected;
    public static boolean loadworld;
    boolean createworld;
    boolean fw;
    String name;
    boolean hasworld;
    boolean delete;
    boolean rename;
    String renamingworldname;
    String location;
    File folder;
    List<String> worldnames;
    public static String worldname;
    private static final String[] options;
    public int tick;
    int wncol;
    
    static {
        WorldSelectMenu.loadworld = false;
        WorldSelectMenu.worldname = "";
        options = new String[] { "Load World", "New World" };
    }
    
    public WorldSelectMenu(final Menu parent) {
        this.selected = 0;
        this.worldselected = 0;
        this.createworld = false;
        this.fw = false;
        this.name = "";
        this.hasworld = false;
        this.delete = false;
        this.rename = false;
        this.renamingworldname = "";
        this.location = String.valueOf(System.getenv("APPDATA")) + "/.fossickersdoom/saves/";
        this.folder = new File(this.location);
        this.worldnames = new ArrayList<String>();
        this.tick = 0;
        this.wncol = Color.get(0, 5, 5, 5);
        this.parent = parent;
        this.folder.mkdirs();
        final File[] listOfFiles = this.folder.listFiles();
        for (int i = 0; i < listOfFiles.length; ++i) {
            if (listOfFiles[i].isDirectory()) {
                final String path = String.valueOf(System.getenv("APPDATA")) + "/.fossickersdoom/saves/" + listOfFiles[i].getName() + "/";
                final File folder2 = new File(path);
                folder2.mkdirs();
                final String[] Files = folder2.list();
                if (Files.length > 0 && Files[0].endsWith(".fdsave")) {
                    this.worldnames.add(listOfFiles[i].getName());
                    System.out.println("World found: " + listOfFiles[i].getName());
                }
            }
        }
        if (this.worldnames.size() > 0) {
            this.fw = true;
        }
    }
    
    @Override
    public void tick() {
        if (this.input.up.clicked) {
            --this.selected;
        }
        if (this.input.down.clicked) {
            ++this.selected;
        }
        if (!this.fw) {
            this.selected = 1;
        }
        final int len = 2;
        if (this.selected < 0) {
            this.selected += len;
        }
        if (this.selected >= len) {
            this.selected -= len;
        }
        if (WorldSelectMenu.loadworld) {
            if (this.input.up.clicked) {
                --this.worldselected;
            }
            if (this.input.down.clicked) {
                ++this.worldselected;
            }
            if (this.worldselected < 0) {
                this.worldselected = 0;
            }
            if (this.worldselected > this.worldnames.size() - 1) {
                this.worldselected = this.worldnames.size() - 1;
            }
        }
        if (this.createworld) {
            this.typename();
            if (this.input.pause.clicked) {
                this.createworld = false;
                WorldSelectMenu.loadworld = false;
                this.game.setMenu(new TitleMenu());
            }
            if (this.input.enter.clicked && this.wncol == Color.get(0, 5, 5, 5)) {
                WorldSelectMenu.worldname = this.name;
                this.name = "";
                this.game.setMenu(new ModeMenu());
            }
        }
        if (WorldSelectMenu.loadworld && this.input.menu.clicked && !this.rename) {
            if (!this.delete) {
                WorldSelectMenu.worldname = this.worldnames.get(this.worldselected);
                Sound.test.play();
                this.game.resetstartGame();
                this.game.setMenu(null);
            }
            else {
                final File world = new File(String.valueOf(this.location) + "/" + this.worldnames.get(this.worldselected));
                System.out.println(world);
                final File[] list = world.listFiles();
                for (int i = 0; i < list.length; ++i) {
                    list[i].delete();
                }
                world.delete();
                this.createworld = false;
                WorldSelectMenu.loadworld = false;
                if (this.worldnames.size() > 0) {
                    this.game.setMenu(new WorldSelectMenu(this.parent));
                }
                else {
                    this.game.setMenu(new TitleMenu());
                }
            }
        }
        if (this.input.attack.clicked && !this.rename && !this.createworld) {
            if (!this.delete && !this.rename) {
                this.createworld = false;
                WorldSelectMenu.loadworld = false;
                this.game.setMenu(new TitleMenu());
            }
            else if (this.delete) {
                this.delete = false;
            }
            else if (this.rename) {
                this.rename = false;
            }
        }
        if (this.input.d.clicked && !this.rename && !this.createworld) {
            if (!this.delete) {
                this.delete = true;
            }
            else {
                this.delete = false;
            }
        }
        if (this.input.r.clicked && !this.rename && !this.createworld) {
            if (!this.rename) {
                this.name = this.worldnames.get(this.worldselected);
                this.renamingworldname = this.name;
                this.rename = true;
            }
            else {
                this.rename = false;
            }
        }
        if (this.rename) {
            ++this.tick;
            if (this.input.pause.clicked) {
                this.tick = 0;
                this.rename = false;
            }
            if (this.input.enter.clicked && this.wncol == Color.get(0, 5, 5, 5)) {
                WorldSelectMenu.worldname = this.name;
                this.name = "";
                final File world = new File(String.valueOf(this.location) + "/" + this.worldnames.get(this.worldselected));
                world.renameTo(new File(String.valueOf(this.location) + "/" + WorldSelectMenu.worldname));
                this.game.setMenu(new WorldSelectMenu(this.parent));
                this.tick = 0;
                this.rename = false;
            }
            if (this.tick > 1) {
                this.typename();
            }
        }
        if (!this.createworld && !WorldSelectMenu.loadworld) {
            if (this.input.menu.clicked) {
                System.out.println(this.selected);
                if (this.selected == 0) {
                    WorldSelectMenu.loadworld = true;
                    this.createworld = false;
                }
                if (this.selected == 1) {
                    this.name = "";
                    this.createworld = true;
                    WorldSelectMenu.loadworld = false;
                }
            }
            if (this.input.attack.clicked) {
                this.createworld = false;
                WorldSelectMenu.loadworld = false;
                this.game.setMenu(new TitleMenu());
            }
        }
    }
    
    @Override
    public void render(final Screen screen) {
        screen.clear(0);
        if (!this.createworld && !WorldSelectMenu.loadworld) {
            for (int lo = 2, i = 0; i < lo; ++i) {
                if (this.fw || i != 0) {
                    String msg = WorldSelectMenu.options[i];
                    int col = Color.get(0, 222, 222, 222);
                    if (i == this.selected) {
                        msg = "> " + msg + " <";
                        col = Color.get(0, 555, 555, 555);
                    }
                    if (!this.fw) {
                        Font.draw(msg, screen, this.centertext(msg), 80, col);
                    }
                    else {
                        Font.draw(msg, screen, this.centertext(msg), 80 + i * 12, col);
                    }
                }
            }
            Font.draw("Arrow keys to move", screen, this.centertext("Arrow keys to move"), screen.h - 170, Color.get(0, 444, 444, 444));
            Font.draw("X to confirm", screen, this.centertext("X to confirm"), screen.h - 60, Color.get(0, 444, 444, 444));
            Font.draw("C to go back to the title screen", screen, this.centertext("C to go back to the title screen"), screen.h - 40, Color.get(0, 444, 444, 444));
        }
        else if (this.createworld && !WorldSelectMenu.loadworld) {
            final String msg2 = "Name of New World";
            final int col2 = Color.get(-1, 555, 555, 555);
            Font.draw(msg2, screen, this.centertext(msg2), 20, col2);
            Font.draw(this.name, screen, this.centertext(this.name), 50, this.wncol);
            Font.draw("A-Z, 0-9, 36 Characters", screen, this.centertext("A-Z, 0-9, 36 Characters"), 80, col2);
            Font.draw("(Space + Backspace as well)", screen, this.centertext("(Space + Backspace as well)"), 92, col2);
            if (this.wncol == Color.get(0, 500, 500, 500)) {
                if (!this.name.equals("")) {
                    Font.draw("Cannot have 2 worlds", screen, this.centertext("Cannot have 2 worlds"), 120, this.wncol);
                    Font.draw(" with the same name!", screen, this.centertext(" with the same name!"), 132, this.wncol);
                }
                else {
                    Font.draw("Name cannot be blank!", screen, this.centertext("Name cannot be blank!"), 125, this.wncol);
                }
            }
            Font.draw("Press Enter to create", screen, this.centertext("Press Enter to create"), 162, col2);
            Font.draw("Press Esc to cancel", screen, this.centertext("Press Esc to cancel"), 172, col2);
        }
        else if (!this.createworld && WorldSelectMenu.loadworld) {
            String msg2 = "Load World";
            int col2 = Color.get(-1, 555, 555, 555);
            final int col3 = Color.get(-1, 222, 222, 222);
            if (this.delete) {
                msg2 = "Delete World!";
                col2 = Color.get(-1, 500, 500, 500);
            }
            if (this.worldnames.size() > 0) {
                Font.draw(msg2, screen, this.centertext(msg2), 20, col2);
                Font.draw(this.worldnames.get(this.worldselected), screen, this.centertext(this.worldnames.get(this.worldselected)), 80, col2);
                if (this.worldselected > 0) {
                    Font.draw(this.worldnames.get(this.worldselected - 1), screen, this.centertext(this.worldnames.get(this.worldselected - 1)), 70, col3);
                }
                if (this.worldselected > 1) {
                    Font.draw(this.worldnames.get(this.worldselected - 2), screen, this.centertext(this.worldnames.get(this.worldselected - 2)), 60, col3);
                }
                if (this.worldselected > 2) {
                    Font.draw(this.worldnames.get(this.worldselected - 3), screen, this.centertext(this.worldnames.get(this.worldselected - 3)), 50, col3);
                }
                if (this.worldselected < this.worldnames.size() - 1) {
                    Font.draw(this.worldnames.get(this.worldselected + 1), screen, this.centertext(this.worldnames.get(this.worldselected + 1)), 90, col3);
                }
                if (this.worldselected < this.worldnames.size() - 2) {
                    Font.draw(this.worldnames.get(this.worldselected + 2), screen, this.centertext(this.worldnames.get(this.worldselected + 2)), 100, col3);
                }
                if (this.worldselected < this.worldnames.size() - 3) {
                    Font.draw(this.worldnames.get(this.worldselected + 3), screen, this.centertext(this.worldnames.get(this.worldselected + 3)), 110, col3);
                }
            }
            else {
                this.game.setMenu(new TitleMenu());
            }
            if (!this.delete && !this.rename) {
                Font.draw("Arrow keys to move", screen, this.centertext("Arrow keys to move"), screen.h - 44, Color.get(0, 444, 444, 444));
                Font.draw("X to confirm", screen, this.centertext("X to confirm"), screen.h - 32, Color.get(0, 444, 444, 444));
                Font.draw("C to go back to the title screen", screen, this.centertext("C to go back to the title screen"), screen.h - 20, Color.get(0, 444, 444, 444));
                Font.draw("D to delete a world", screen, this.centertext("D to delete a world"), screen.h - 70, Color.get(0, 400, 400, 400));
                Font.draw("R to rename world", screen, this.centertext("R to rename world"), screen.h - 60, Color.get(0, 40, 40, 40));
            }
            else if (this.delete) {
                Font.draw("X to delete", screen, this.centertext("X to delete"), screen.h - 48, Color.get(0, 444, 444, 444));
                Font.draw("C to cancel", screen, this.centertext("C to cancel"), screen.h - 36, Color.get(0, 444, 444, 444));
            }
            else if (this.rename) {
                screen.clear(0);
                Font.draw("Rename World", screen, this.centertext("Rename World"), 20, col2);
                Font.draw(this.name, screen, this.centertext(this.name), 50, this.wncol);
                Font.draw("A-Z, 0-9, 36 Characters", screen, this.centertext("A-Z, 0-9, 36 Characters"), 80, col2);
                Font.draw("(Space + Backspace as well)", screen, this.centertext("(Space + Backspace as well)"), 92, col2);
                if (this.wncol == Color.get(0, 500, 500, 500)) {
                    if (!this.name.equals("")) {
                        Font.draw("Cannot have 2 worlds", screen, this.centertext("Cannot have 2 worlds"), 120, this.wncol);
                        Font.draw(" with the same name!", screen, this.centertext(" with the same name!"), 132, this.wncol);
                    }
                    else {
                        Font.draw("Name cannot be blank!", screen, this.centertext("Name cannot be blank!"), 125, this.wncol);
                    }
                }
                Font.draw("Press Enter to rename", screen, this.centertext("Press Enter to rename"), 162, col2);
                Font.draw("Press Esc to cancel", screen, this.centertext("Press Esc to cancel"), 172, col2);
            }
        }
    }
    
    public void typename() {
        final List<String> namedworldnames = new ArrayList<String>();
        if (this.createworld) {
            if (this.worldnames.size() > 0) {
                for (int i = 0; i < this.worldnames.size(); ++i) {
                    if (!this.name.equals(this.worldnames.get(i).toLowerCase())) {
                        this.wncol = Color.get(0, 5, 5, 5);
                    }
                    else {
                        this.wncol = Color.get(0, 500, 500, 500);
                    }
                }
            }
            else {
                this.wncol = Color.get(0, 5, 5, 5);
            }
        }
        if (this.rename) {
            for (int i = 0; i < this.worldnames.size(); ++i) {
                if (!this.worldnames.get(i).equals(this.renamingworldname)) {
                    namedworldnames.add(this.worldnames.get(i).toLowerCase());
                }
            }
            if (namedworldnames.size() > 0) {
                for (int i = 0; i < namedworldnames.size(); ++i) {
                    if (this.name.toLowerCase().equals(namedworldnames.get(i).toLowerCase())) {
                        this.wncol = Color.get(0, 500, 500, 500);
                        break;
                    }
                    this.wncol = Color.get(0, 5, 5, 5);
                }
            }
            else {
                this.wncol = Color.get(0, 5, 5, 5);
            }
        }
        if (this.name.equals("")) {
            this.wncol = Color.get(0, 500, 500, 500);
        }
        if (this.input.backspace.clicked && this.name.length() > 0) {
            this.name = this.name.substring(0, this.name.length() - 1);
        }
        if (this.name.length() < 36) {
            if (this.input.space.clicked) {
                this.name = String.valueOf(this.name) + " ";
            }
            if (this.input.a0.clicked) {
                this.name = String.valueOf(this.name) + "0";
            }
            if (this.input.a1.clicked) {
                this.name = String.valueOf(this.name) + "1";
            }
            if (this.input.a2.clicked) {
                this.name = String.valueOf(this.name) + "2";
            }
            if (this.input.a3.clicked) {
                this.name = String.valueOf(this.name) + "3";
            }
            if (this.input.a4.clicked) {
                this.name = String.valueOf(this.name) + "4";
            }
            if (this.input.a5.clicked) {
                this.name = String.valueOf(this.name) + "5";
            }
            if (this.input.a6.clicked) {
                this.name = String.valueOf(this.name) + "6";
            }
            if (this.input.a7.clicked) {
                this.name = String.valueOf(this.name) + "7";
            }
            if (this.input.a8.clicked) {
                this.name = String.valueOf(this.name) + "8";
            }
            if (this.input.a9.clicked) {
                this.name = String.valueOf(this.name) + "9";
            }
            if (this.input.a.clicked) {
                this.name = String.valueOf(this.name) + "a";
            }
            if (this.input.b.clicked) {
                this.name = String.valueOf(this.name) + "b";
            }
            if (this.input.c.clicked) {
                this.name = String.valueOf(this.name) + "c";
            }
            if (this.input.d.clicked) {
                this.name = String.valueOf(this.name) + "d";
            }
            if (this.input.e.clicked) {
                this.name = String.valueOf(this.name) + "e";
            }
            if (this.input.f.clicked) {
                this.name = String.valueOf(this.name) + "f";
            }
            if (this.input.g.clicked) {
                this.name = String.valueOf(this.name) + "g";
            }
            if (this.input.h.clicked) {
                this.name = String.valueOf(this.name) + "h";
            }
            if (this.input.i.clicked) {
                this.name = String.valueOf(this.name) + "i";
            }
            if (this.input.j.clicked) {
                this.name = String.valueOf(this.name) + "j";
            }
            if (this.input.k.clicked) {
                this.name = String.valueOf(this.name) + "k";
            }
            if (this.input.l.clicked) {
                this.name = String.valueOf(this.name) + "l";
            }
            if (this.input.m.clicked) {
                this.name = String.valueOf(this.name) + "m";
            }
            if (this.input.n.clicked) {
                this.name = String.valueOf(this.name) + "n";
            }
            if (this.input.o.clicked) {
                this.name = String.valueOf(this.name) + "o";
            }
            if (this.input.p.clicked) {
                this.name = String.valueOf(this.name) + "p";
            }
            if (this.input.q.clicked) {
                this.name = String.valueOf(this.name) + "q";
            }
            if (this.input.r.clicked) {
                this.name = String.valueOf(this.name) + "r";
            }
            if (this.input.s.clicked) {
                this.name = String.valueOf(this.name) + "s";
            }
            if (this.input.t.clicked) {
                this.name = String.valueOf(this.name) + "t";
            }
            if (this.input.u.clicked) {
                this.name = String.valueOf(this.name) + "u";
            }
            if (this.input.v.clicked) {
                this.name = String.valueOf(this.name) + "v";
            }
            if (this.input.w.clicked) {
                this.name = String.valueOf(this.name) + "w";
            }
            if (this.input.x.clicked) {
                this.name = String.valueOf(this.name) + "x";
            }
            if (this.input.y.clicked) {
                this.name = String.valueOf(this.name) + "y";
            }
            if (this.input.z.clicked) {
                this.name = String.valueOf(this.name) + "z";
            }
        }
    }
}
