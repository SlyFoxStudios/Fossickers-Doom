package com.mojang.ld22.screen;

import com.mojang.ld22.GameApplet;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.screen.AboutMenu;
import com.mojang.ld22.screen.Menu;
import com.mojang.ld22.screen.ModeMenu;
import com.mojang.ld22.screen.StartMenu;
import com.mojang.ld22.screen.WorldSelectMenu;
import com.mojang.ld22.sound.Sound;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TitleMenu extends Menu {

    private int selected = 0;
    protected final Random random = new Random();
    public static List splashes = new ArrayList();
    private static final String[] options = new String[]{"Start game", "Tutorial", "Options", "About"};
    public static boolean sentFromMenu;
    int rand = 0;
    int count = 0;
    boolean reverse = false;
    static boolean loadedsplashes = false;
    static boolean loadedunlocks = false;
    String location = System.getenv("APPDATA") + "/.fossickersdoom";
    File folder;
    boolean isblue;


    public TitleMenu() {
        this.folder = new File(this.location);
        this.isblue = false;
        if(splashes.size() == 0) {
            splashes.add("You will never see this!");
        }

        if(splashes.size() == 1) {
            this.getSplashes();
        }

        this.rand = this.random.nextInt(splashes.size());
        if(!loadedunlocks) {
            this.getSplashes();
        }

    }

    public void getSplashes() {
        String ee;
        if(!loadedsplashes) {
            try {
                URL br = new URL("http://zectr.com/game/-splashes.txt");
                URLConnection e = br.openConnection();
                e.setReadTimeout(1000);
                Scanner bufferedWriter = new Scanner(br.openStream());
                splashes.clear();

                while(bufferedWriter.hasNextLine()) {
                    ee = bufferedWriter.nextLine();
                    if(ee.contains("]")) {
                        if(ee.substring(ee.indexOf("]")).length() > 3) {
                            ee = ee.substring(ee.indexOf("]") + 2, ee.length());
                        } else {
                            ee = "";
                        }
                    }

                    if(!ee.equals("")) {
                        splashes.add(ee);
                    }
                }

                bufferedWriter.close();
            } catch (MalformedURLException var43) {
                var43.printStackTrace();
                splashes.clear();
                splashes.add("");
            } catch (ConnectException var44) {
                var44.printStackTrace();
                splashes.clear();
                splashes.add("Connection issue! D:");
            } catch (IOException var45) {
                var45.printStackTrace();
                splashes.clear();
                splashes.add("Why you still got dial-up?");
            }

            loadedsplashes = true;
        }

        if(!loadedunlocks) {
            ModeMenu.unlockedtimes.clear();
            BufferedReader br1 = null;
            this.folder.mkdirs();

            try {
                br1 = new BufferedReader(new FileReader(this.location + "/unlocks.fdsave"));

                String e1;
                while((e1 = br1.readLine()) != null) {
                    List bufferedWriter2 = Arrays.asList(e1.split(","));
                    Iterator var5 = bufferedWriter2.iterator();

                    while(var5.hasNext()) {
                        ee = (String)var5.next();
                        if(ee.contains("AirSkin")) {
                            StartMenu.unlockedskin = true;
                        }

                        if(ee.contains("MINUTEMODE") && !ee.substring(0, ee.indexOf("M") + 1).equals("M")) {
                            ModeMenu.unlockedtimes.add(ee.substring(0, ee.indexOf("M") + 1));
                        }

                        if(ee.contains("HOURMODE") && !ee.substring(0, ee.indexOf("H") + 1).equals("H")) {
                            ModeMenu.unlockedtimes.add(ee.substring(0, ee.indexOf("H") + 1));
                        }
                    }
                }
            } catch (FileNotFoundException var40) {
                BufferedWriter bufferedWriter1 = null;

                try {
                    bufferedWriter1 = new BufferedWriter(new FileWriter(this.location + "/unlocks.fdsave"));
                    bufferedWriter1.write("");
                } catch (IOException var38) {
                    var38.printStackTrace();
                } finally {
                    try {
                        if(bufferedWriter1 != null) {
                            bufferedWriter1.flush();
                            bufferedWriter1.close();
                        }
                    } catch (IOException var37) {
                        var37.printStackTrace();
                    }

                }
            } catch (IOException var41) {
                var41.printStackTrace();
            } finally {
                try {
                    if(br1 != null) {
                        br1.close();
                    }
                } catch (IOException var36) {
                    var36.printStackTrace();
                }

            }

            ModeMenu.times.clear();
            loadedunlocks = true;
        }

    }

    public void tick() {
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

        int len = options.length;
        if(this.selected < 0) {
            this.selected += len;
        }

        if(this.selected >= len) {
            this.selected -= len;
        }

        if(this.input.r.clicked) {
            this.rand = this.random.nextInt(splashes.size());
        }

        if(!this.reverse) {
            ++this.count;
            if(this.count == 25) {
                this.reverse = true;
            }
        } else if(this.reverse) {
            --this.count;
            if(this.count == 0) {
                this.reverse = false;
            }
        }

        if(this.input.attack.clicked || this.input.menu.clicked) {
            if(this.selected == 0) {
                WorldSelectMenu.loadworld = false;
                this.game.setMenu(new WorldSelectMenu(this));
            }

            if(this.selected == 1) {
                //try {
                //    String e = "http://minicraftplus.webs.com/Tutorial.htm";
                //    Desktop.getDesktop().browse(URI.create(e));
                //} catch (IOException var3) {
                //    System.out.println(var3.getMessage());
                //}
            }

            if(this.selected == 2) {
                sentFromMenu = true;
                this.game.setMenu(new StartMenu());
            }

            if(this.selected == 3) {
                //this.game.setMenu(new AboutMenu(this));
            }
        }

    }

    public void render(Screen screen) {
        screen.clear(0);
        byte h = 2;
        byte w = 14;
        int titleColor = Color.get(0, 8, 131, 551);
        int xo = (screen.w - w * 8) / 2;
        byte yo = 36;
        int cols = Color.get(0, 550, 550, 550);

        int i;
        for(i = 0; i < h; ++i) {
            for(int msg = 0; msg < w; ++msg) {
                screen.render(xo + msg * 8, yo + i * 8, msg + (i + 6) * 32, titleColor, 0);
            }
        }

        for(i = 0; i < 4; ++i) {
            String var11 = options[i];
            int col = Color.get(0, 222, 222, 222);
            if(i == this.selected) {
                var11 = "> " + var11 + " <";
                col = Color.get(0, 555, 555, 555);
            }

            Font.draw(var11, screen, (screen.w - var11.length() * 8) / 2, (11 + i) * 8, col);
        }

        if(((String)splashes.get(this.rand)).contains("blue")) {
            this.isblue = true;
        } else {
            this.isblue = false;
        }

        if(this.isblue) {
            if(this.count <= 5) {
                cols = Color.get(0, 5, 5, 5);
            }

            if(this.count <= 10 && this.count > 5) {
                cols = Color.get(0, 4, 4, 4);
            }

            if(this.count <= 15 && this.count > 10) {
                cols = Color.get(0, 3, 3, 3);
            }

            if(this.count <= 20 && this.count > 15) {
                cols = Color.get(0, 2, 2, 2);
            }

            if(this.count <= 25 && this.count > 20) {
                cols = Color.get(0, 1, 1, 1);
            }
        } else {
            if(this.count <= 5) {
                cols = Color.get(0, 505, 550, 550);
            }

            if(this.count <= 10 && this.count > 5) {
                cols = Color.get(0, 405, 440, 440);
            }

            if(this.count <= 15 && this.count > 10) {
                cols = Color.get(0, 305, 330, 330);
            }

            if(this.count <= 20 && this.count > 15) {
                cols = Color.get(0, 205, 220, 220);
            }

            if(this.count <= 25 && this.count > 20) {
                cols = Color.get(0, 5, 110, 110);
            }
        }

        Font.draw((String)splashes.get(this.rand), screen, this.centertext((String)splashes.get(this.rand)), 60, cols);
        if(GameApplet.isApplet) {
            if(GameApplet.username.length() < 27) {
                Font.draw("Welcome, " + GameApplet.username + "!", screen, this.centertext("Welcome, " + GameApplet.username + "!"), screen.h - 190, Color.get(0, 330, 330, 330));
            } else {
                Font.draw("Welcome,", screen, this.centertext("Welcome!"), screen.h - 190, Color.get(0, 330, 330, 330));
                Font.draw(GameApplet.username + "!", screen, this.centertext(GameApplet.username + "!"), screen.h - 180, Color.get(0, 330, 330, 330));
            }

            Font.draw("Version 1.0.1", screen, this.centertext("Version 1.0.1"), screen.h - 10, Color.get(0, 333, 333, 333));
            Font.draw("(Arrow keys to move)", screen, 65, screen.h - 35, Color.get(0, 111, 111, 111));
            Font.draw("(X to accept, C to return)", screen, 45, screen.h - 25, Color.get(0, 111, 111, 111));
        } else {
            Font.draw("Version 1.0.1", screen, 1, screen.h - 190, Color.get(0, 111, 111, 111));
            Font.draw("(Arrow keys to move)", screen, 65, screen.h - 25, Color.get(0, 111, 111, 111));
            Font.draw("(X to accept, C to return)", screen, 45, screen.h - 15, Color.get(0, 111, 111, 111));
        }

    }

    public int centertext(String name) {
        return (288 - name.length() * 8) / 2;
    }
}