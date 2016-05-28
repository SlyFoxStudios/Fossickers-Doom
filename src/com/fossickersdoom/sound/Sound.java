// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.sound;

import com.fossickersdoom.screen.StartMenu;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound
{
    public static final Sound playerHurt;
    public static final Sound playerDeath;
    public static final Sound monsterHurt;
    public static final Sound test;
    public static final Sound pickup;
    public static final Sound bossdeath;
    public static final Sound craft;
    public static final Sound fuse;
    public static final Sound explode;
    private AudioClip clip;
    
    static {
        playerHurt = new Sound("/playerhurt.wav");
        playerDeath = new Sound("/death.wav");
        monsterHurt = new Sound("/monsterhurt.wav");
        test = new Sound("/test.wav");
        pickup = new Sound("/pickup.wav");
        bossdeath = new Sound("/bossdeath.wav");
        craft = new Sound("/craft.wav");
        fuse = new Sound("/fuse.wav");
        explode = new Sound("/explode.wav");
    }
    
    private Sound(final String name) {
        try {
            this.clip = Applet.newAudioClip(Sound.class.getResource(name));
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
    
    public void play() {
        try {
            new Thread() {
                @Override
                public void run() {
                    if (StartMenu.isSoundAct) {
                        Sound.this.clip.play();
                    }
                }
            }.start();
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
