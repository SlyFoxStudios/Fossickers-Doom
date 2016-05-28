// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.entity;

import java.awt.event.ActionEvent;

import com.fossickersdoom.level.tile.Tile;
import com.fossickersdoom.sound.Sound;
import com.fossickersdoom.gfx.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import java.awt.event.ActionListener;

public class Tnt extends Furniture implements ActionListener
{
    private static int MAX_FUSE_TIME;
    private static int BLAST_RADIUS;
    private static int BLAST_RADIUSTWO;
    private static int BLAST_DAMAGE;
    protected int dir;
    private int lvl;
    private int counter;
    private int fuseTime;
    private int ftik;
    private boolean fuseLit;
    private boolean running;
    private boolean flashing;
    public Tile tile;
    Timer t;
    Timer s;
    Timer flash;
    List<Tile> tiles;
    List<Integer> tilescoord;
    
    static {
        Tnt.MAX_FUSE_TIME = 60;
        Tnt.BLAST_RADIUS = 30;
        Tnt.BLAST_RADIUSTWO = 2000;
        Tnt.BLAST_DAMAGE = 30;
    }
    
    public Tnt() {
        super("Tnt");
        this.dir = 0;
        this.counter = 0;
        this.fuseTime = 0;
        this.ftik = 0;
        this.fuseLit = false;
        this.running = true;
        this.flashing = false;
        this.t = new Timer(400, this);
        this.s = new Timer(50, this);
        this.flash = new Timer(5, this);
        this.tiles = new ArrayList<Tile>();
        this.tilescoord = new ArrayList<Integer>();
        this.col0 = Color.get(-1, 200, 300, 444);
        this.col1 = Color.get(-1, 200, 300, 555);
        this.col2 = Color.get(-1, 100, 200, 444);
        this.col3 = Color.get(-1, 0, 100, 333);
        this.col = Color.get(-1, 200, 300, 555);
        this.sprite = 7;
        this.xr = 3;
        this.yr = 2;
    }
    
    @Override
    public void tick() {
        super.tick();
        for (int i = -2; i < 3; ++i) {
            if (this.level.getTile((this.x + i * 16) / 16, (this.y + i * 16) / 16) == Tile.explode && this.fuseTime == 0) {
                Sound.fuse.play();
                this.flash.start();
            }
            if (this.level.getTile((this.x + i * 16) / 16, this.y / 16) == Tile.explode && this.fuseTime == 0) {
                Sound.fuse.play();
                this.flash.start();
            }
            if (this.level.getTile(this.x / 16, (this.y + i * 16) / 16) == Tile.explode && this.fuseTime == 0) {
                Sound.fuse.play();
                this.flash.start();
            }
        }
        if (this.flashing) {
            ++this.ftik;
            if (this.ftik > 4) {
                this.col0 = Color.get(-1, 200, 300, 555);
                this.col1 = Color.get(-1, 200, 300, 555);
                this.col2 = Color.get(-1, 200, 300, 555);
                this.col3 = Color.get(-1, 200, 300, 555);
            }
            if (this.ftik > 8) {
                this.col0 = Color.get(-1, 300, 400, 555);
                this.col1 = Color.get(-1, 300, 400, 555);
                this.col2 = Color.get(-1, 300, 400, 555);
                this.col3 = Color.get(-1, 300, 400, 555);
            }
            if (this.ftik > 12) {
                this.col0 = Color.get(-1, 400, 500, 555);
                this.col1 = Color.get(-1, 400, 500, 555);
                this.col2 = Color.get(-1, 400, 500, 555);
                this.col3 = Color.get(-1, 400, 500, 555);
            }
            if (this.ftik > 13) {
                System.out.print("BLOW UP!");
                this.s.start();
                this.ftik = 0;
                this.flashing = false;
            }
        }
        if (this.fuseTime == 0) {
            if (this.fuseLit) {
                final int pdx = Math.abs(this.level.player.x - this.x);
                final int pdy = Math.abs(this.level.player.y - this.y);
                if (pdx < Tnt.BLAST_RADIUSTWO && pdy < Tnt.BLAST_RADIUSTWO) {
                    final float pd = (float)Math.sqrt(pdx * pdx + pdy * pdy);
                    final int dmg = (int)(Tnt.BLAST_DAMAGE * (1.0f - pd / Tnt.BLAST_RADIUS)) + 1;
                    this.level.player.hurt(this, dmg, 0);
                    this.level.player.payStamina(dmg * 2);
                    Sound.explode.play();
                    final int xt = this.x >> 4;
                    final int yt = this.y - 2 >> 4;
                    this.explodeTile(xt, yt, Tile.explode);
                    this.explodeTile(xt - 1, yt, Tile.explode);
                    this.explodeTile(xt + 1, yt, Tile.explode);
                    this.explodeTile(xt, yt + 1, Tile.explode);
                    this.explodeTile(xt, yt - 1, Tile.explode);
                    this.explodeTile(xt + 1, yt + 1, Tile.explode);
                    this.explodeTile(xt - 1, yt + 1, Tile.explode);
                    this.explodeTile(xt + 1, yt - 1, Tile.explode);
                    this.explodeTile(xt - 1, yt - 1, Tile.explode);
                    this.t.start();
                    super.remove();
                }
                else {
                    this.fuseTime = 0;
                    this.fuseLit = false;
                }
            }
        }
        else {
            --this.fuseTime;
        }
    }
    
    public void explodeTile(final int xt, final int yt, final Tile tile) {
        if (!this.level.getTile(xt, yt).getClass().getName().equals("StairsTile")) {
            this.level.setTile(xt, yt, tile, 0);
        }
    }
    
    public void explodeTile(final int xt, final int yt, final Tile tile, final Tile tile2) {
        if (!this.level.getTile(xt, yt).getClass().getName().equals("StairsTile")) {
            if (this.random.nextBoolean()) {
                this.level.setTile(xt, yt, tile, 0);
            }
            else {
                System.out.println(this.level.getTile(xt, yt));
                if (this.level.getTile(xt, yt) == Tile.cloud) {
                    this.level.setTile(xt, yt, tile2, 0);
                }
                else {
                    this.level.setTile(xt, yt, tile, 0);
                }
            }
        }
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        final int xt = this.x >> 4;
        final int yt = this.y - 2 >> 4;
        if (e.getSource() == this.t) {
            if (this.level.depth == 1) {
                this.explodeTile(xt, yt, Tile.infiniteFall, Tile.cloud);
                this.explodeTile(xt - 1, yt, Tile.infiniteFall, Tile.cloud);
                this.explodeTile(xt + 1, yt, Tile.infiniteFall, Tile.cloud);
                this.explodeTile(xt, yt + 1, Tile.infiniteFall, Tile.cloud);
                this.explodeTile(xt, yt - 1, Tile.infiniteFall, Tile.cloud);
                this.explodeTile(xt + 1, yt + 1, Tile.infiniteFall, Tile.cloud);
                this.explodeTile(xt - 1, yt + 1, Tile.infiniteFall, Tile.cloud);
                this.explodeTile(xt + 1, yt - 1, Tile.infiniteFall, Tile.cloud);
                this.explodeTile(xt - 1, yt - 1, Tile.infiniteFall, Tile.cloud);
            }
            else {
                this.explodeTile(xt, yt, Tile.hole);
                this.explodeTile(xt - 1, yt, Tile.hole);
                this.explodeTile(xt + 1, yt, Tile.hole);
                this.explodeTile(xt, yt + 1, Tile.hole);
                this.explodeTile(xt, yt - 1, Tile.hole);
                this.explodeTile(xt + 1, yt + 1, Tile.hole);
                this.explodeTile(xt - 1, yt + 1, Tile.hole);
                this.explodeTile(xt + 1, yt - 1, Tile.hole);
                this.explodeTile(xt - 1, yt - 1, Tile.hole);
            }
            this.t.stop();
        }
        if (e.getSource() == this.flash) {
            this.flashing = true;
            this.flash.stop();
        }
        if (e.getSource() == this.s) {
            this.fuseTime = Tnt.MAX_FUSE_TIME;
            this.fuseLit = true;
            this.s.stop();
        }
    }
    
    @Override
    public boolean canWool() {
        return true;
    }
    
    @Override
    protected void touchedBy(final Entity entity) {
        if (entity instanceof Player) {
            if (this.fuseTime == 0) {
                Sound.fuse.play();
                this.flash.start();
            }
            entity.hurt(this, 1, this.dir);
        }
    }
}
