// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom;

import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class InputHandler implements MouseListener, KeyListener
{
    public List<Mouse> mouse;
    public Mouse one;
    public Mouse two;
    public Mouse tri;
    public List<Key> keys;
    public Key up;
    public Key down;
    public Key left;
    public Key right;
    public Key attack;
    public Key menu;
    public Key craft;
    public Key pause;
    public Key sethome;
    public Key home;
    public Key mode;
    public Key survival;
    public Key creative;
    public Key hardcore;
    public Key fps;
    public Key options;
    public Key soundOn;
    public Key dayTime;
    public Key nightTime;
    public Key a;
    public Key b;
    public Key c;
    public Key d;
    public Key e;
    public Key f;
    public Key g;
    public Key h;
    public Key i;
    public Key j;
    public Key k;
    public Key l;
    public Key m;
    public Key n;
    public Key o;
    public Key p;
    public Key q;
    public Key r;
    public Key s;
    public Key t;
    public Key u;
    public Key v;
    public Key w;
    public Key x;
    public Key y;
    public Key z;
    public Key a1;
    public Key a2;
    public Key a3;
    public Key a4;
    public Key a5;
    public Key a6;
    public Key a7;
    public Key a8;
    public Key a9;
    public Key a0;
    public Key f2;
    public Key f3;
    public Key backspace;
    public Key space;
    public Key enter;
    public Key delete;
    
    public void releaseAll() {
        for (int i = 0; i < this.keys.size(); ++i) {
            this.keys.get(i).down = false;
        }
    }
    
    public void tick() {
        for (int i = 0; i < this.keys.size(); ++i) {
            this.keys.get(i).tick();
        }
    }
    
    public InputHandler(final Game game) {
        this.mouse = new ArrayList<Mouse>();
        this.one = new Mouse();
        this.two = new Mouse();
        this.tri = new Mouse();
        this.keys = new ArrayList<Key>();
        this.up = new Key();
        this.down = new Key();
        this.left = new Key();
        this.right = new Key();
        this.attack = new Key();
        this.menu = new Key();
        this.craft = new Key();
        this.pause = new Key();
        this.sethome = new Key();
        this.home = new Key();
        this.mode = new Key();
        this.survival = new Key();
        this.creative = new Key();
        this.hardcore = new Key();
        this.fps = new Key();
        this.options = new Key();
        this.soundOn = new Key();
        this.dayTime = new Key();
        this.nightTime = new Key();
        this.a = new Key();
        this.b = new Key();
        this.c = new Key();
        this.d = new Key();
        this.e = new Key();
        this.f = new Key();
        this.g = new Key();
        this.h = new Key();
        this.i = new Key();
        this.j = new Key();
        this.k = new Key();
        this.l = new Key();
        this.m = new Key();
        this.n = new Key();
        this.o = new Key();
        this.p = new Key();
        this.q = new Key();
        this.r = new Key();
        this.s = new Key();
        this.t = new Key();
        this.u = new Key();
        this.v = new Key();
        this.w = new Key();
        this.x = new Key();
        this.y = new Key();
        this.z = new Key();
        this.a1 = new Key();
        this.a2 = new Key();
        this.a3 = new Key();
        this.a4 = new Key();
        this.a5 = new Key();
        this.a6 = new Key();
        this.a7 = new Key();
        this.a8 = new Key();
        this.a9 = new Key();
        this.a0 = new Key();
        this.f2 = new Key();
        this.f3 = new Key();
        this.backspace = new Key();
        this.space = new Key();
        this.enter = new Key();
        this.delete = new Key();
        game.addKeyListener(this);
        game.addMouseListener(this);
    }
    
    @Override
    public void keyPressed(final KeyEvent ke) {
        this.toggle(ke, true);
    }
    
    @Override
    public void keyReleased(final KeyEvent ke) {
        this.toggle(ke, false);
    }
    
    private void toggle(final KeyEvent ke, final boolean pressed) {
        if (ke.getKeyCode() == 104) {
            this.up.toggle(pressed);
        }
        if (ke.getKeyCode() == 98) {
            this.down.toggle(pressed);
        }
        if (ke.getKeyCode() == 100) {
            this.left.toggle(pressed);
        }
        if (ke.getKeyCode() == 102) {
            this.right.toggle(pressed);
        }
        if (ke.getKeyCode() == 87) {
            this.up.toggle(pressed);
        }
        if (ke.getKeyCode() == 83) {
            this.down.toggle(pressed);
        }
        if (ke.getKeyCode() == 65) {
            this.left.toggle(pressed);
        }
        if (ke.getKeyCode() == 68) {
            this.right.toggle(pressed);
        }
        if (ke.getKeyCode() == 38) {
            this.up.toggle(pressed);
        }
        if (ke.getKeyCode() == 40) {
            this.down.toggle(pressed);
        }
        if (ke.getKeyCode() == 37) {
            this.left.toggle(pressed);
        }
        if (ke.getKeyCode() == 39) {
            this.right.toggle(pressed);
        }
        if (ke.getKeyCode() == 9) {
            this.menu.toggle(pressed);
        }
        if (ke.getKeyCode() == 18) {
            this.menu.toggle(pressed);
        }
        if (ke.getKeyCode() == 65406) {
            this.menu.toggle(pressed);
        }
        if (ke.getKeyCode() == 17) {
            this.attack.toggle(pressed);
        }
        if (ke.getKeyCode() == 96) {
            this.attack.toggle(pressed);
        }
        if (ke.getKeyCode() == 155) {
            this.attack.toggle(pressed);
        }
        if (ke.getKeyCode() == 32) {
            this.attack.toggle(pressed);
        }
        if (ke.getKeyCode() == 10) {
            this.menu.toggle(pressed);
        }
        if (ke.getKeyCode() == 81) {
            this.craft.toggle(pressed);
        }
        if (ke.getKeyCode() == 97) {
            this.craft.toggle(pressed);
        }
        if (ke.getKeyCode() == 69) {
            this.craft.toggle(pressed);
        }
        if (ke.getKeyCode() == 27) {
            this.pause.toggle(pressed);
        }
        if (ke.getKeyCode() == 90) {
            this.craft.toggle(pressed);
        }
        if (ke.getKeyCode() == 88) {
            this.menu.toggle(pressed);
        }
        if (ke.getKeyCode() == 67) {
            this.attack.toggle(pressed);
        }
        if (ke.getKeyCode() == 49) {
            this.sethome.toggle(pressed);
        }
        if (ke.getKeyCode() == 72) {
            this.home.toggle(pressed);
        }
        if (ke.getKeyCode() == 71) {
            this.mode.toggle(pressed);
        }
        if (ke.getKeyCode() == 49) {
            this.survival.toggle(pressed);
        }
        if (ke.getKeyCode() == 50) {
            this.creative.toggle(pressed);
        }
        if (ke.getKeyCode() == 51) {
            this.hardcore.toggle(pressed);
        }
        if (ke.getKeyCode() == 114) {
            this.hardcore.toggle(pressed);
        }
        if (ke.getKeyCode() == 79) {
            this.options.toggle(pressed);
        }
        if (ke.getKeyCode() == 83) {
            this.soundOn.toggle(pressed);
        }
        if (ke.getKeyCode() == 83) {
            this.soundOn.toggle(pressed);
        }
        if (ke.getKeyCode() == 50) {
            this.dayTime.toggle(pressed);
        }
        if (ke.getKeyCode() == 51) {
            this.nightTime.toggle(pressed);
        }
        if (ke.getKeyCode() == 8) {
            this.backspace.toggle(pressed);
        }
        if (ke.getKeyCode() == 32) {
            this.space.toggle(pressed);
        }
        if (ke.getKeyCode() == 10) {
            this.enter.toggle(pressed);
        }
        if (ke.getKeyCode() == 65) {
            this.a.toggle(pressed);
        }
        if (ke.getKeyCode() == 66) {
            this.b.toggle(pressed);
        }
        if (ke.getKeyCode() == 67) {
            this.c.toggle(pressed);
        }
        if (ke.getKeyCode() == 68) {
            this.d.toggle(pressed);
        }
        if (ke.getKeyCode() == 69) {
            this.e.toggle(pressed);
        }
        if (ke.getKeyCode() == 70) {
            this.f.toggle(pressed);
        }
        if (ke.getKeyCode() == 71) {
            this.g.toggle(pressed);
        }
        if (ke.getKeyCode() == 72) {
            this.h.toggle(pressed);
        }
        if (ke.getKeyCode() == 73) {
            this.i.toggle(pressed);
        }
        if (ke.getKeyCode() == 74) {
            this.j.toggle(pressed);
        }
        if (ke.getKeyCode() == 75) {
            this.k.toggle(pressed);
        }
        if (ke.getKeyCode() == 76) {
            this.l.toggle(pressed);
        }
        if (ke.getKeyCode() == 77) {
            this.m.toggle(pressed);
        }
        if (ke.getKeyCode() == 78) {
            this.n.toggle(pressed);
        }
        if (ke.getKeyCode() == 79) {
            this.o.toggle(pressed);
        }
        if (ke.getKeyCode() == 80) {
            this.p.toggle(pressed);
        }
        if (ke.getKeyCode() == 81) {
            this.q.toggle(pressed);
        }
        if (ke.getKeyCode() == 82) {
            this.r.toggle(pressed);
        }
        if (ke.getKeyCode() == 83) {
            this.s.toggle(pressed);
        }
        if (ke.getKeyCode() == 84) {
            this.t.toggle(pressed);
        }
        if (ke.getKeyCode() == 85) {
            this.u.toggle(pressed);
        }
        if (ke.getKeyCode() == 86) {
            this.v.toggle(pressed);
        }
        if (ke.getKeyCode() == 87) {
            this.w.toggle(pressed);
        }
        if (ke.getKeyCode() == 88) {
            this.x.toggle(pressed);
        }
        if (ke.getKeyCode() == 89) {
            this.y.toggle(pressed);
        }
        if (ke.getKeyCode() == 90) {
            this.z.toggle(pressed);
        }
        if (ke.getKeyCode() == 49) {
            this.a1.toggle(pressed);
        }
        if (ke.getKeyCode() == 50) {
            this.a2.toggle(pressed);
        }
        if (ke.getKeyCode() == 51) {
            this.a3.toggle(pressed);
        }
        if (ke.getKeyCode() == 52) {
            this.a4.toggle(pressed);
        }
        if (ke.getKeyCode() == 53) {
            this.a5.toggle(pressed);
        }
        if (ke.getKeyCode() == 54) {
            this.a6.toggle(pressed);
        }
        if (ke.getKeyCode() == 55) {
            this.a7.toggle(pressed);
        }
        if (ke.getKeyCode() == 56) {
            this.a8.toggle(pressed);
        }
        if (ke.getKeyCode() == 57) {
            this.a9.toggle(pressed);
        }
        if (ke.getKeyCode() == 48) {
            this.a0.toggle(pressed);
        }
        if (ke.getKeyCode() == 97) {
            this.a1.toggle(pressed);
        }
        if (ke.getKeyCode() == 98) {
            this.a2.toggle(pressed);
        }
        if (ke.getKeyCode() == 99) {
            this.a3.toggle(pressed);
        }
        if (ke.getKeyCode() == 100) {
            this.a4.toggle(pressed);
        }
        if (ke.getKeyCode() == 101) {
            this.a5.toggle(pressed);
        }
        if (ke.getKeyCode() == 102) {
            this.a6.toggle(pressed);
        }
        if (ke.getKeyCode() == 103) {
            this.a7.toggle(pressed);
        }
        if (ke.getKeyCode() == 104) {
            this.a8.toggle(pressed);
        }
        if (ke.getKeyCode() == 105) {
            this.a9.toggle(pressed);
        }
        if (ke.getKeyCode() == 96) {
            this.a0.toggle(pressed);
        }
        if (ke.getKeyCode() == 113) {
            this.f2.toggle(pressed);
        }
        if (ke.getKeyCode() == 114) {
            this.f3.toggle(pressed);
        }
    }
    
    private void click(final MouseEvent e, final boolean clickd) {
        if (e.getButton() == 1) {
            this.one.toggle(clickd);
        }
        if (e.getButton() == 2) {
            this.two.toggle(clickd);
        }
        if (e.getButton() == 3) {
            this.tri.toggle(clickd);
        }
    }
    
    @Override
    public void keyTyped(final KeyEvent ke) {
    }
    
    @Override
    public void mouseClicked(final MouseEvent e) {
    }
    
    @Override
    public void mouseEntered(final MouseEvent e) {
    }
    
    @Override
    public void mouseExited(final MouseEvent e) {
    }
    
    @Override
    public void mousePressed(final MouseEvent e) {
        this.click(e, true);
    }
    
    @Override
    public void mouseReleased(final MouseEvent e) {
        this.click(e, false);
    }
    
    public class Key
    {
        public int presses;
        public int absorbs;
        public boolean down;
        public boolean clicked;
        
        public Key() {
            InputHandler.this.keys.add(this);
        }
        
        public void toggle(final boolean pressed) {
            if (pressed != this.down) {
                this.down = pressed;
            }
            if (pressed) {
                ++this.presses;
            }
        }
        
        public void tick() {
            if (this.absorbs < this.presses) {
                ++this.absorbs;
                this.clicked = true;
            }
            else {
                this.clicked = false;
            }
        }
    }
    
    public class Mouse
    {
        public int pressesd;
        public int absorbsd;
        public boolean click;
        public boolean down;
        
        public Mouse() {
            InputHandler.this.mouse.add(this);
        }
        
        public void toggle(final boolean clickd) {
            if (clickd != this.down) {
                this.down = clickd;
            }
            if (clickd) {
                ++this.pressesd;
            }
        }
        
        public void tick() {
            if (this.absorbsd < this.pressesd) {
                ++this.absorbsd;
                this.click = true;
            }
            else {
                this.click = false;
            }
        }
    }
}
