// 
// Decompiled by Procyon v0.5.30
// 

package com.mojang.ld22;

import java.io.OutputStream;
import java.net.URLConnection;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.applet.Applet;

public class GameApplet extends Applet
{
    private static final long serialVersionUID = 1L;
    private Game game;
    URL location;
    public static boolean isApplet;
    public static String username;
    
    static {
        GameApplet.isApplet = false;
        GameApplet.username = "Guest";
    }
    
    public GameApplet() {
        this.game = new Game();
    }
    
    @Override
    public void init() {
        this.location = this.getDocumentBase();
        try {
            this.location = new URL("http://playminicraft.com/mod.php?m=minicraft-plus");
        }
        catch (MalformedURLException e1) {
            e1.printStackTrace();
        }
        GameApplet.isApplet = true;
        this.setLayout(new BorderLayout());
        this.setSize(288 * 3 + 20, 192 * 3 + 20);
        this.add(this.game, "Center");
        try {
            final URLConnection yc = this.location.openConnection();
            yc.setDoOutput(true);
            yc.setDoInput(true);
            yc.setUseCaches(false);
            yc.setAllowUserInteraction(false);
            yc.setRequestProperty("Content-type", "text/xml; charset=UTF-8");
            final OutputStream out = yc.getOutputStream();
            final BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (this.location.toString().startsWith("http") && inputLine.contains("nme=")) {
                    GameApplet.username = inputLine.substring(inputLine.indexOf("nm") + 4, inputLine.lastIndexOf("&amp;"));
                    if (GameApplet.username.length() != 0) {
                        continue;
                    }
                    GameApplet.username = "Guest";
                }
            }
            in.close();
            out.close();
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
    }
    
    @Override
    public void start() {
        this.game.start();
    }
    
    @Override
    public void stop() {
        this.game.stop();
    }
}
