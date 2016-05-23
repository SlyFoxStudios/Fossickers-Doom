package com.mojang.ld22;

import com.mojang.ld22.InputHandler;
import com.mojang.ld22.entity.Enchanter;
import com.mojang.ld22.entity.Entity;
import com.mojang.ld22.entity.Furniture;
import com.mojang.ld22.entity.IronLantern;
import com.mojang.ld22.entity.ItemEntity;
import com.mojang.ld22.entity.Mob;
import com.mojang.ld22.entity.Player;
import com.mojang.ld22.entity.Workbench;
import com.mojang.ld22.entity.bed;
import com.mojang.ld22.gfx.Color;
import com.mojang.ld22.gfx.Font;
import com.mojang.ld22.gfx.Screen;
import com.mojang.ld22.gfx.SpriteSheet;
import com.mojang.ld22.item.FurnitureItem;
import com.mojang.ld22.item.ListItems;
import com.mojang.ld22.item.ResourceItem;
import com.mojang.ld22.item.resource.ItemResource;
import com.mojang.ld22.item.resource.PotionResource;
import com.mojang.ld22.item.resource.Resource;
import com.mojang.ld22.level.Level;
import com.mojang.ld22.level.tile.DirtTile;
import com.mojang.ld22.level.tile.Tile;
import com.mojang.ld22.saveload.Load;
import com.mojang.ld22.saveload.Save;
import com.mojang.ld22.screen.DeadMenu;
import com.mojang.ld22.screen.LevelTransitionMenu;
import com.mojang.ld22.screen.LoadingMenu;
import com.mojang.ld22.screen.Menu;
import com.mojang.ld22.screen.ModeMenu;
import com.mojang.ld22.screen.StartMenu;
import com.mojang.ld22.screen.TitleMenu;
import com.mojang.ld22.screen.WonMenu;
import com.mojang.ld22.screen.WorldGenMenu;
import com.mojang.ld22.screen.WorldSelectMenu;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Game extends Canvas implements Runnable, ActionListener {

    private static final long serialVersionUID = 1L;
    private static Random random = new Random();
    public static final String NAME = "Fossickers Doom";
    public static final String VERSION = "1.0.1";
    public static final int HEIGHT = 192;
    public static final int WIDTH = 288;
    private static final int SCALE = 3;
    public static int gamespeed = 1;
    public double nsPerTick;
    public static boolean autosave = false;
    public static int astime = 3600;
    public int tick;
    public static int Time = 0;
    private BufferedImage image;
    private int[] pixels;
    private BufferedImage extraimage;
    private int[] extrapixels;
    private boolean running;
    public boolean fpscounter;
    boolean initTick;
    public static boolean tickReset = false;
    int hungerTick;
    private Screen screen;
    private Screen lightScreen;
    private InputHandler input;
    public int newscoreTime;
    int count;
    boolean reverse;
    public int scoreTime;
    public static int multiplyer = 1;
    public static int mtm = 300;
    public static int multiplyertime = mtm;
    int[] oldlvls;
    private int[] colors;
    public static int tickCount = 0;
    public int gameTime;
    public static boolean isDayNoSleep = false;
    public int fra;
    public int tik;
    public static int dayYeahTick;
    public static boolean Load = false;
    public static boolean fasttime = false;
    public static int LoadTime = 3;
    public static boolean paused = false;
    public static int infotime = 120;
    public static boolean infoplank = false;
    public static boolean infosbrick = false;
    public static boolean truerod = false;
    public static boolean isfishing = false;
    public static int fishingcount = 0;
    public Level level;
    public static Level[] levels = new Level[5];
    public static int currentLevel = 3;
    int hungerMinusCount;
    public Player player;
    int l;
    public static int acs = 25;
    public static int ac = acs;
    public static String savedtext;
    public Menu menu;
    private int playerDeadTime;
    private int pendingLevelChange;
    private int wonTimer;
    public boolean hasWon;
    Timer sunrise;
    Timer sunset;
    Timer daytime;
    Timer nighttime;
    public static List notifications = new ArrayList();
    String location;
    public boolean saving;
    public int savecooldown;
    public int notetick;


    public Game() {
        this.nsPerTick = 1.6666666666666666E7D * (double)gamespeed;
        this.tick = 0;
        this.image = new BufferedImage(288, 192, 1);
        this.pixels = ((DataBufferInt)this.image.getRaster().getDataBuffer()).getData();
        this.extraimage = new BufferedImage(288, 192, 1);
        this.extrapixels = ((DataBufferInt)this.extraimage.getRaster().getDataBuffer()).getData();
        this.running = false;
        this.fpscounter = false;
        this.input = new InputHandler(this);
        this.newscoreTime = 72000;
        this.count = 0;
        this.reverse = false;
        this.scoreTime = this.newscoreTime;
        this.colors = new int[256];
        this.gameTime = 0;
        this.fra = 0;
        this.tik = 0;
        this.l = 128;
        this.wonTimer = 0;
        this.hasWon = false;
        this.sunrise = new Timer('\uea60', this);
        this.sunset = new Timer('\uea60', this);
        this.daytime = new Timer(420000, this);
        this.nighttime = new Timer(240000, this);
        this.location = System.getenv("APPDATA") + "\\.fossickersdoom\\mods\\Minicraft Plus\\saves\\" + WorldSelectMenu.worldname + "\\Level3.fdsave";
        this.notetick = 0;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
        if(menu != null) {
            menu.init(this, this.input);
        }

    }

    public void start() {
        this.running = true;
        (new Thread(this)).start();
    }

    public void stop() {
        this.running = false;
    }

    public void SunRtd() {
        int var10000;
        if(Time == 0) {
            this.daytime.stop();
            this.nighttime.stop();
            this.sunrise.stop();
            this.sunset.stop();
            this.sunrise.start();
            var10000 = DirtTile.dirtc;
            if(DirtTile.dirtc == 1) {
                --DirtTile.dirtc;
            }
        }

        if(Time == 1) {
            --Time;
            this.daytime.stop();
            this.nighttime.stop();
            this.sunrise.stop();
            this.sunset.stop();
            this.sunrise.start();
            var10000 = DirtTile.dirtc;
            if(DirtTile.dirtc == 1) {
                --DirtTile.dirtc;
            }
        }

        if(Time == 2) {
            --Time;
            --Time;
            this.daytime.stop();
            this.nighttime.stop();
            this.sunrise.stop();
            this.sunset.stop();
            this.sunrise.start();
            var10000 = DirtTile.dirtc;
            if(DirtTile.dirtc == 1) {
                --DirtTile.dirtc;
            }
        }

        if(Time == 3) {
            --Time;
            --Time;
            --Time;
            this.daytime.stop();
            this.nighttime.stop();
            this.sunrise.stop();
            this.sunset.stop();
            this.sunrise.start();
            var10000 = DirtTile.dirtc;
            if(DirtTile.dirtc == 1) {
                --DirtTile.dirtc;
            }
        }

    }

    public void resetstartGame() {
        ac = acs;
        this.playerDeadTime = 0;
        this.wonTimer = 0;
        this.gameTime = 0;
        Player.hasSetHome = false;
        Player.canGoHome = false;
        bed.hasBedSet = false;
        if(!StartMenu.hasSetDiff) {
            StartMenu.diff = 2;
        }

        this.location = System.getenv("APPDATA") + "\\.fossickersdoom\\saves\\" + WorldSelectMenu.worldname + "\\Level3.fdsave";
        ListItems.items.clear();
        new ListItems();
        this.hasWon = false;
        this.player = new Player(this, this.input);
        levels = new Level[6];
        currentLevel = 3;
        if(WorldGenMenu.sized == WorldGenMenu.sizeNorm) {
            this.l = 128;
        } else if(WorldGenMenu.sized == WorldGenMenu.sizeBig) {
            this.l = 256;
        } else if(WorldGenMenu.sized == WorldGenMenu.sizeHuge) {
            this.l = 512;
        }

        if(ModeMenu.score) {
            this.scoreTime = this.newscoreTime;
        }

        Player.score = 0;
        if(WorldSelectMenu.loadworld) {
            try {
                BufferedReader f = new BufferedReader(new FileReader(this.location));
                this.l = Integer.parseInt(f.readLine().substring(0, 3));
            } catch (FileNotFoundException var4) {
                var4.printStackTrace();
            } catch (NumberFormatException var5) {
                var5.printStackTrace();
            } catch (IOException var6) {
                var6.printStackTrace();
            }
        }

        if(!WorldSelectMenu.loadworld) {
            LoadingMenu.percentage = 0;
        } else {
            LoadingMenu.percentage += 5;
        }

        levels[4] = new Level(this.l, this.l, 1, (Level)null);
        if(!WorldSelectMenu.loadworld) {
            LoadingMenu.percentage = 20;
        } else {
            LoadingMenu.percentage += 5;
        }

        levels[3] = new Level(this.l, this.l, 0, levels[4]);
        if(!WorldSelectMenu.loadworld) {
            LoadingMenu.percentage = 40;
        } else {
            LoadingMenu.percentage += 5;
        }

        levels[2] = new Level(this.l, this.l, -1, levels[3]);
        if(!WorldSelectMenu.loadworld) {
            LoadingMenu.percentage = 60;
        } else {
            LoadingMenu.percentage += 5;
        }

        levels[1] = new Level(this.l, this.l, -2, levels[2]);
        if(!WorldSelectMenu.loadworld) {
            LoadingMenu.percentage = 80;
        } else {
            LoadingMenu.percentage += 5;
        }

        levels[0] = new Level(this.l, this.l, -3, levels[1]);
        if(!WorldSelectMenu.loadworld) {
            LoadingMenu.percentage = 100;
        } else {
            LoadingMenu.percentage += 5;
        }

        levels[5] = new Level(this.l, this.l, -4, levels[0]);
        if(!WorldSelectMenu.loadworld) {
            FurnitureItem f1 = new FurnitureItem(new IronLantern());
            Furniture l = f1.furniture;
            l.x = 984;
            l.y = 984;
            levels[5].add(l);
        }

        LoadingMenu.percentage = 0;
        if(!ModeMenu.creative) {
            this.player.inventory.add(new FurnitureItem(new Enchanter()));
            this.player.inventory.add(new FurnitureItem(new Workbench()));
        }

        this.level = levels[currentLevel];
        this.player.respawn(this.level);
        currentLevel = 3;
        this.level.add(this.player);
        if(WorldSelectMenu.loadworld) {
            new Load(this, WorldSelectMenu.worldname);
        } else {
            tickCount = 0;
            if(this.level.getTile(this.player.x / 16, this.player.y / 16) != Tile.sand) {
                this.level.setTile(this.player.x / 16, this.player.y / 16, Tile.grass, 0);
            }
        }

        DeadMenu.shudrespawn = true;
        if(WorldGenMenu.theme == WorldGenMenu.hell) {
            this.player.inventory.add(new ResourceItem(Resource.lavapotion));
        }

    }

    public void resetGame() {
        this.playerDeadTime = 0;
        this.wonTimer = 0;
        this.gameTime = 0;
        Player.hasSetHome = false;
        Player.canGoHome = false;
        this.hasWon = false;
        this.player = new Player(this, this.input);
        if(DeadMenu.shudrespawn) {
            currentLevel = 3;
            this.level = levels[currentLevel];
            this.player.respawn(this.level);
            this.level.add(this.player);
        } else {
            levels[3] = new Level(this.l, this.l, 0, levels[4]);
            this.level = levels[currentLevel];
            if(currentLevel == 3) {
                currentLevel = 3;
            }

            if(currentLevel != 3) {
                currentLevel = 3;
            }

            DeadMenu.shudrespawn = true;
            this.player.findStartPos(this.level);
        }

    }

    private void init() {
        int pp = 0;

        for(int e = 0; e < 6; ++e) {
            for(int g = 0; g < 6; ++g) {
                for(int b = 0; b < 6; ++b) {
                    int rr = e * 255 / 5;
                    int gg = g * 255 / 5;
                    int bb = b * 255 / 5;
                    int mid = (rr * 30 + gg * 59 + bb * 11) / 100;
                    int r1 = (rr + mid * 1) / 2 * 230 / 255 + 10;
                    int g1 = (gg + mid * 1) / 2 * 230 / 255 + 10;
                    int b1 = (bb + mid * 1) / 2 * 230 / 255 + 10;
                    this.colors[pp++] = r1 << 16 | g1 << 8 | b1;
                }
            }
        }

        try {
            this.screen = new Screen(288, 192, new SpriteSheet(ImageIO.read(Game.class.getResourceAsStream("/icons.png"))));
            this.lightScreen = new Screen(288, 192, new SpriteSheet(ImageIO.read(Game.class.getResourceAsStream("/icons.png"))));
        } catch (IOException var12) {
            var12.printStackTrace();
        }

        this.resetGame();
        this.setMenu(new TitleMenu());
    }

    public void run() {
        long lastTime = System.nanoTime();
        double unprocessed = 0.0D;
        int frames = 0;
        int ticks = 0;
        long lastTimer1 = System.currentTimeMillis();
        this.init();

        while(this.running) {
            long now = System.nanoTime();
            unprocessed += (double)(now - lastTime) / this.nsPerTick;
            lastTime = now;

            boolean shouldRender;
            for(shouldRender = true; unprocessed >= 1.0D; shouldRender = true) {
                ++ticks;
                this.tick();
                --unprocessed;
            }

            try {
                Thread.sleep(2L);
            } catch (InterruptedException var13) {
                var13.printStackTrace();
            }

            if(shouldRender) {
                ++frames;
                this.render();
            }

            if(System.currentTimeMillis() - lastTimer1 > 1000L) {
                lastTimer1 += 1000L;
                this.fra = frames;
                this.tik = ticks;
                frames = 0;
                ticks = 0;
            }
        }

    }

    public static void Fishing(Level level, int x, int y, Player player) {
        isfishing = true;
        int fcatch = random.nextInt(60);
        if(ItemResource.dur == 0) {
            player.activeItem.isDepleted();
        }

        if(fcatch <= 8) {
            System.out.print("Caught a Fish!");
            level.add(new ItemEntity(new ResourceItem(Resource.rawfish), x + random.nextInt(11) - 5, y + random.nextInt(11) - 5));
            isfishing = false;
        }

        if(fcatch == 25 || fcatch == 43 || fcatch == 32 || fcatch == 15 || fcatch == 42) {
            System.out.print("Caught some slime?");
            level.add(new ItemEntity(new ResourceItem(Resource.slime), x + random.nextInt(11) - 5, y + random.nextInt(11) - 5));
            isfishing = false;
        }

        if(fcatch == 56) {
            System.out.print("Rare Armor!");
            level.add(new ItemEntity(new ResourceItem(Resource.larmor), x + random.nextInt(11) - 5, y + random.nextInt(11) - 5));
            isfishing = false;
        } else {
            System.out.print("FAIL!");
            isfishing = false;
        }

    }

    public static void changeTime(int t) {
        Time = t;
    }

    public void tick() {
        if(bed.hasBedSet) {
            this.level.remove(this.player);
            this.nsPerTick = 781250.0D;
            if(isDayNoSleep) {
                this.level.add(this.player);
                this.nsPerTick = 1.6666666666666666E7D;

                for(int i = 0; i < this.level.entities.size(); ++i) {
                    if(((Entity)this.level.entities.get(i)).level == levels[currentLevel]) {
                        int xd = this.level.player.x - ((Entity)this.level.entities.get(i)).x;
                        int yd = this.level.player.y - ((Entity)this.level.entities.get(i)).y;
                        if(xd * xd + yd * yd < 48 && this.level.entities.get(i) instanceof Mob && this.level.entities.get(i) != this.player) {
                            this.level.remove((Entity)this.level.entities.get(i));
                        }
                    }
                }

                bed.hasBedSet = false;
            }
        }

        if(tickReset) {
            tickCount = 0;
            tickReset = false;
        }

        if(!paused) {
            ++tickCount;
        }

        ++this.tick;
        if(this.tick >= astime / 8) {
            savedtext = "";
        }

        if(this.tick > astime) {
            if(autosave && this.player.health > 0 && !this.hasWon && levels[currentLevel].entities.contains(this.player)) {
                new Save(this.player, WorldSelectMenu.worldname);
            }

            this.tick = 0;
        }

        if(tickCount < '\u9c40') {
            isDayNoSleep = true;
        }

        if(tickCount >= '\u9c40') {
            isDayNoSleep = false;
        }

        if(tickReset) {
            tickCount = 0;
            tickReset = false;
        }

        if(tickCount == 0) {
            changeTime(0);
        }

        if(tickCount == 3600) {
            this.level.removeAllEnimies();
        }

        if(tickCount == 7200) {
            changeTime(1);
        }

        if(tickCount == 32000) {
            changeTime(2);
        }

        if(tickCount == '\u9c40') {
            changeTime(3);
        }

        if(tickCount == '\uf3c0') {
            changeTime(0);
            tickCount = 0;
        }

        if(ModeMenu.score) {
            if(!paused) {
                --this.scoreTime;
            }

            if(this.scoreTime < 1 && !this.player.removed) {
                this.setMenu(new WonMenu(this.player));
                System.out.print(Player.score);
                this.player.remove();
            }

            if(multiplyer > 1) {
                if(multiplyertime != 0) {
                    --multiplyertime;
                }

                if(multiplyertime == 0) {
                    multiplyer = 1;
                    mtm = 300;
                    multiplyertime = 300;
                }
            }

            if(multiplyer > 50) {
                multiplyer = 50;
            }
        }

        if(infoplank || infosbrick) {
            if(infotime > 0) {
                --infotime;
            } else {
                infoplank = false;
                infosbrick = false;
                infotime = 120;
            }
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

        if(!this.hasFocus()) {
            this.input.releaseAll();
        } else {
            if(!this.player.removed && !this.hasWon) {
                ++this.gameTime;
            }

            this.input.tick();
            if(this.menu != null) {
                this.menu.tick();
                paused = true;
            } else {
                paused = false;
                if(this.player.removed) {
                    ++this.playerDeadTime;
                    if(this.playerDeadTime > 60) {
                        this.setMenu(new DeadMenu());
                    }
                } else if(this.pendingLevelChange != 0) {
                    this.setMenu(new LevelTransitionMenu(this.pendingLevelChange));
                    this.pendingLevelChange = 0;
                }

                if(this.wonTimer > 0 && --this.wonTimer == 0) {
                    this.wonTimer = 180;
                    this.hasWon = true;
                    this.daytime.stop();
                    this.nighttime.stop();
                    this.sunrise.stop();
                    this.sunset.stop();
                    this.setMenu(new WonMenu(this.player));
                }

                this.level.tick();
                ++Tile.tickCount;
            }
        }

    }

    public void changeLevel(int dir) {
        this.level.remove(this.player);
        currentLevel += dir;
        if(currentLevel == -1) {
            currentLevel = 5;
        }

        if(currentLevel == 6) {
            currentLevel = 0;
        }

        this.level = levels[currentLevel];
        this.player.x = (this.player.x >> 4) * 16 + 8;
        this.player.y = (this.player.y >> 4) * 16 + 8;
        this.level.add(this.player);
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            this.requestFocus();
        } else {
            int xScroll = this.player.x - this.screen.w / 2;
            int yScroll = this.player.y - (this.screen.h - 8) / 2;
            if(xScroll < 16) {
                xScroll = 16;
            }

            if(yScroll < 16) {
                yScroll = 16;
            }

            if(xScroll > this.level.w * 16 - this.screen.w - 16) {
                xScroll = this.level.w * 16 - this.screen.w - 16;
            }

            if(yScroll > this.level.h * 16 - this.screen.h - 16) {
                yScroll = this.level.h * 16 - this.screen.h - 16;
            }

            int col0;
            int col1;
            if(currentLevel > 3) {
                col0 = Color.get(20, 20, 121, 121);

                for(col1 = 0; col1 < 28; ++col1) {
                    for(int col = 0; col < 48; ++col) {
                        this.screen.render(col * 8 - (xScroll / 4 & 7), col1 * 8 - (yScroll / 4 & 7), 0, col0, 0);
                    }
                }
            }

            this.level.renderBackground(this.screen, xScroll, yScroll);
            this.level.renderSprites(this.screen, xScroll, yScroll);
            col0 = Color.get(-1, 555, 555, 555);
            col1 = Color.get(-1, -1, -1, -1);
            boolean var15 = false;
            int colVis = Color.get(-1, 555, 555, 555);
            int colTran = Color.get(-1, -1, -1, -1);
            boolean colSleep = false;
            if(bed.hasBeenTrigged) {
                if(!isDayNoSleep) {
                    ;
                }

                if(dayYeahTick == 600) {
                    ;
                }
            }

            if(!this.fpscounter) {
                ;
            }

            if(this.fpscounter) {
                ;
            }

            if(currentLevel < 3 || currentLevel > 4) {
                this.lightScreen.clear(0);
                this.level.renderLight(this.lightScreen, xScroll, yScroll);
                this.screen.overlay(this.lightScreen, xScroll, yScroll);
            }

            this.renderGui();
            if(!this.hasFocus()) {
                this.renderFocusNagger();
            }

            int g;
            int ww;
            for(g = 0; g < this.screen.h; ++g) {
                for(ww = 0; ww < this.screen.w; ++ww) {
                    int hh = this.screen.pixels[ww + g * this.screen.w];
                    if(hh < 255) {
                        this.pixels[ww + g * 288] = this.colors[hh];
                    }
                }
            }

            int xo;
            int yo;
            for(g = 0; g < this.screen.h; ++g) {
                for(ww = 0; ww < this.screen.w; ++ww) {
                    boolean var18 = false;
                    xo = this.screen.extrapixels[ww + g * this.screen.w];
                    if(xo == 0) {
                        xo = Color.get(0, 0, 0, 0);
                        var18 = true;
                    }

                    if(xo < 255) {
                        this.extrapixels[ww + g * 288] = this.colors[xo];
                    }

                    if(var18) {
                        yo = this.screen.pixels[ww + g * this.screen.w];
                        if(yo < 255) {
                            this.pixels[ww + g * 288] = this.colors[yo];
                        }
                    }
                }
            }

            Graphics var16 = bs.getDrawGraphics();
            var16.fillRect(0, 0, this.getWidth(), this.getHeight());
            short var17 = 864;
            short var19 = 576;
            xo = (this.getWidth() - var17) / 2;
            yo = (this.getHeight() - var19) / 2;
            var16.drawImage(this.image, xo, yo, var17, var19, (ImageObserver)null);
            var16.dispose();
            bs.show();
        }
    }

    private void renderGui() {
        int xfps;
        int txlevel;
        for(xfps = 0; xfps < 2; ++xfps) {
            for(txlevel = 0; txlevel < 29; ++txlevel) {
                this.screen.render(txlevel * 7, this.screen.h - 16 + xfps * 8, 384, Color.get(-1, -1, -1, -1), 0);
            }
        }

        for(xfps = 1; xfps < 2; ++xfps) {
            for(txlevel = 12; txlevel < 29; ++txlevel) {
                this.screen.render(txlevel * 7, this.screen.h - 16 + xfps * 8, 32, Color.get(0, 0, 0, 0), 0);
            }
        }

        for(xfps = 1; xfps < 2; ++xfps) {
            for(txlevel = 12; txlevel < 14; ++txlevel) {
                this.screen.render(txlevel * 7, this.screen.h - 16 + xfps * 8, 32, Color.get(0, 0, 0, 0), 0);
            }
        }

        xfps = this.fra;
        txlevel = Player.xx / 16;
        int tylevel = Player.yy / 16;
        int col0 = Color.get(-1, 555, 555, 555);
        if(this.player.showinfo) {
            Font.draw(xfps + " fps", this.screen, 1, this.screen.h - 190, col0);
            Font.draw("X " + txlevel, this.screen, 1, this.screen.h - 180, col0);
            Font.draw("Y " + tylevel, this.screen, 1, this.screen.h - 170, col0);
            if(ModeMenu.score) {
                Font.draw("Score " + Player.score, this.screen, 1, this.screen.h - 160, col0);
                if(currentLevel == 5) {
                    if(levels[currentLevel].chestcount > 0) {
                        Font.draw("Chests: " + levels[currentLevel].chestcount, this.screen, 1, this.screen.h - 150, col0);
                    } else {
                        Font.draw("Chests: Complete!", this.screen, 1, this.screen.h - 150, col0);
                    }
                }
            } else if(currentLevel == 5) {
                if(levels[currentLevel].chestcount > 0) {
                    Font.draw("Chests: " + levels[currentLevel].chestcount, this.screen, 1, this.screen.h - 160, col0);
                } else {
                    Font.draw("Chests: Complete!", this.screen, 1, this.screen.h - 160, col0);
                }
            }
        }

        if(this.saving) {
            Font.draw("Saving... " + LoadingMenu.percentage + "%", this.screen, this.screen.w / 2 - ("Saving... " + LoadingMenu.percentage + "%").length() * 4 + 1, this.screen.h / 2 - 32 + 1, Color.get(-1, 111, 111, 111));
            Font.draw("Saving... " + LoadingMenu.percentage + "%", this.screen, this.screen.w / 2 - ("Saving... " + LoadingMenu.percentage + "%").length() * 4, this.screen.h / 2 - 32, Color.get(-1, 4, 4, 4));
        }

        if(!ModeMenu.creative) {
            if(ac >= 10000) {
                Font.draw("  x^", this.screen, 84, this.screen.h - 16, Color.get(0, 333, 444, 555));
            } else if(ac < 10000) {
                Font.draw("  x" + ac, this.screen, 84, this.screen.h - 16, Color.get(0, 555, 555, 555));
            }
        } else if(ModeMenu.creative) {
            Font.draw("  x^", this.screen, 84, this.screen.h - 16, Color.get(0, 333, 444, 555));
        }

        int cols = Color.get(300, 555, 555, 555);
        int seconds = this.scoreTime / 60;
        int minutes = seconds / 60;
        seconds %= 60;
        if(this.count <= 5) {
            cols = Color.get(500, 555, 555, 555);
        }

        if(this.count <= 10 && this.count > 5) {
            cols = Color.get(400, 555, 555, 555);
        }

        if(this.count <= 15 && this.count > 10) {
            cols = Color.get(300, 555, 555, 555);
        }

        if(this.count <= 20 && this.count > 15) {
            cols = Color.get(200, 555, 555, 555);
        }

        if(this.count <= 25 && this.count > 20) {
            cols = Color.get(100, 555, 555, 555);
        }

        if(bed.hasBedSet) {
            Font.draw("Sleeping...", this.screen, this.screen.w / 2 + 1 - 44, this.screen.h - 119, Color.get(-1, 222, 222, 222));
            Font.draw("Sleeping...", this.screen, this.screen.w / 2 - 44, this.screen.h - 120, Color.get(-1, 555, 555, 555));
        }

        int i;
        if(notifications.size() > 0) {
            ++this.notetick;
            if(notifications.size() > 3) {
                notifications = notifications.subList(notifications.size() - 3, notifications.size());
            }

            if(this.notetick > 600) {
                notifications.remove(0);
                this.notetick = 0;
            }

            for(i = 0; i < notifications.size(); ++i) {
                Font.draw((String)notifications.get(i), this.screen, this.screen.w / 2 + 1 - ((String)notifications.get(i)).length() * 8 / 2, this.screen.h - 120 - i * 8 + 1, Color.get(-1, 111, 111, 111));
                Font.draw((String)notifications.get(i), this.screen, this.screen.w / 2 - ((String)notifications.get(i)).length() * 8 / 2, this.screen.h - 120 - i * 8, Color.get(-1, 555, 555, 555));
            }
        }

        if(ModeMenu.score) {
            if(this.scoreTime > 18000) {
                Font.draw("Time left " + minutes + "m " + seconds + "s", this.screen, 84, this.screen.h - 190, Color.get(0, 555, 555, 555));
            } else if(this.scoreTime < 3600) {
                Font.draw("Time left " + minutes + "m " + seconds + "s", this.screen, 84, this.screen.h - 190, cols);
            } else {
                Font.draw("Time left " + minutes + "m " + seconds + "s", this.screen, 84, this.screen.h - 190, Color.get(330, 555, 555, 555));
            }

            if(multiplyer > 1 && multiplyer < 50) {
                Font.draw("X" + multiplyer, this.screen, 260, this.screen.h - 190, Color.get(-1, 540, 540, 540));
            } else if(multiplyer > 49) {
                Font.draw("X" + multiplyer, this.screen, 260, this.screen.h - 190, Color.get(-1, 500, 500, 500));
            }
        }

        if(this.player.activeItem != null && truerod) {
            i = ItemResource.dur * 5;
            if(i > 100) {
                i = 100;
            }

            Font.draw(i + "%", this.screen, 164, this.screen.h - 16, Color.get(0, 30, 30, 30));
        }

        if(this.player.activeItem != null) {
            this.player.activeItem.renderInventory(this.screen, 84, this.screen.h - 8);
        }

        if(this.player.potioneffects.size() > 0) {
            for(i = 0; i < this.player.potioneffects.size(); ++i) {
                if(this.player.showpotioneffects) {
                    int pcol = Color.get(PotionResource.potionColor((String)this.player.potioneffects.get(i)), 555, 555, 555);
                    Font.draw("(f2 to hide!)", this.screen, 180, this.screen.h - 183, Color.get(0, 555, 555, 555));
                    Font.draw((String)this.player.potioneffects.get(i) + " (" + ((Integer)this.player.potioneffectstime.get(i)).intValue() / 60 / 60 + ":" + (((Integer)this.player.potioneffectstime.get(i)).intValue() / 60 - 60 * (((Integer)this.player.potioneffectstime.get(i)).intValue() / 60 / 60)) + ")", this.screen, 180, this.screen.h - (175 - i * 8), pcol);
                }
            }
        }

        this.screen.render(88, this.screen.h - 17, 173, Color.get(-1, 111, 222, 430), 0);

        for(i = 0; i < 10; ++i) {
            if(!ModeMenu.creative) {
                if(i < this.player.health) {
                    this.screen.render(i * 8, this.screen.h - 16, 384, Color.get(-1, 200, 500, 533), 0);
                } else {
                    this.screen.render(i * 8, this.screen.h - 16, 384, Color.get(-1, 100, 0, 0), 0);
                }

                if(i < this.player.hunger) {
                    this.screen.render(i * 8 + 208, this.screen.h - 16, 386, Color.get(-1, 100, 530, 211), 0);
                } else {
                    this.screen.render(i * 8 + 208, this.screen.h - 16, 386, Color.get(-1, 100, 0, 0), 0);
                }

                if(i < this.player.maxArmor) {
                    this.screen.render(i * 8 + 208, this.screen.h - 8, 387, Color.get(-1, 333, 444, 555), 0);
                } else {
                    this.screen.render(i * 8 + 208, this.screen.h - 8, 387, Color.get(-1, -1, -1, -1), 0);
                }

                if(this.player.staminaRechargeDelay > 0) {
                    if(this.player.staminaRechargeDelay / 4 % 2 == 0) {
                        this.screen.render(i * 8, this.screen.h - 8, 385, Color.get(-1, 555, 0, 0), 0);
                    } else {
                        this.screen.render(i * 8, this.screen.h - 8, 385, Color.get(-1, 110, 0, 0), 0);
                    }
                } else if(i < this.player.stamina) {
                    this.screen.render(i * 8, this.screen.h - 8, 385, Color.get(-1, 220, 550, 553), 0);
                } else {
                    this.screen.render(i * 8, this.screen.h - 8, 385, Color.get(-1, 110, 0, 0), 0);
                }
            }
        }

        if(this.player.activeItem != null) {
            this.player.activeItem.renderInventory(this.screen, 84, this.screen.h - 8, false);
        }

        if(this.menu != null) {
            this.menu.render(this.screen);
        }

    }

    private void renderFocusNagger() {
        String msg = "Click to focus!";
        paused = true;
        int xx = (288 - msg.length() * 8) / 2;
        byte yy = 92;
        int w = msg.length();
        byte h = 1;
        this.screen.render(xx - 8, yy - 8, 416, Color.get(-1, 1, 5, 445), 0);
        this.screen.render(xx + w * 8, yy - 8, 416, Color.get(-1, 1, 5, 445), 1);
        this.screen.render(xx - 8, yy + 8, 416, Color.get(-1, 1, 5, 445), 2);
        this.screen.render(xx + w * 8, yy + 8, 416, Color.get(-1, 1, 5, 445), 3);

        int y;
        for(y = 0; y < w; ++y) {
            this.screen.render(xx + y * 8, yy - 8, 417, Color.get(-1, 1, 5, 445), 0);
            this.screen.render(xx + y * 8, yy + 8, 417, Color.get(-1, 1, 5, 445), 2);
        }

        for(y = 0; y < h; ++y) {
            this.screen.render(xx - 8, yy + y * 8, 418, Color.get(-1, 1, 5, 445), 0);
            this.screen.render(xx + w * 8, yy + y * 8, 418, Color.get(-1, 1, 5, 445), 1);
        }

        if(tickCount / 20 % 2 == 0) {
            Font.draw(msg, this.screen, xx, yy, Color.get(5, 333, 333, 333));
        } else {
            Font.draw(msg, this.screen, xx, yy, Color.get(5, 555, 555, 555));
        }

    }

    public void scheduleLevelChange(int dir) {
        this.pendingLevelChange = dir;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.setMinimumSize(new Dimension(864, 576));
        game.setMaximumSize(new Dimension(864, 576));
        game.setPreferredSize(new Dimension(864, 576));
        JFrame frame = new JFrame(NAME);
        frame.setDefaultCloseOperation(3);
        frame.setLayout(new BorderLayout());
        frame.add(game, "Center");
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo((Component)null);
        frame.setVisible(true);
        game.start();
    }

    public void won() {
        this.wonTimer = 180;
        this.hasWon = true;
        this.daytime.stop();
        this.nighttime.stop();
        this.sunrise.stop();
        this.sunset.stop();
    }

    public void actionPerformed(ActionEvent arg0) {}
}