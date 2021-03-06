// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.gfx;

public class Font
{
    private static String chars;
    
    static {
        Font.chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ      0123456789.,!?'\"-+=/\\%()<>:;^@bcdefghijklmnopqrstuvwxyz";
    }
    
    public static void draw(String msg, final Screen screen, final int x, final int y, final int col) {
        msg = msg.toUpperCase();
        for (int i = 0; i < msg.length(); ++i) {
            final int ix = Font.chars.indexOf(msg.charAt(i));
            if (ix >= 0) {
                screen.render(x + i * 8, y, ix + 960, col, 0);
            }
        }
    }
    
    public static void renderFrame(final Screen screen, final String title, final int x0, final int y0, final int x1, final int y1) {
        for (int y2 = y0; y2 <= y1; ++y2) {
            for (int x2 = x0; x2 <= x1; ++x2) {
                if (x2 == x0 && y2 == y0) {
                    screen.render(x2 * 8, y2 * 8, 416, Color.get(-1, 1, 5, 555), 0);
                }
                else if (x2 == x1 && y2 == y0) {
                    screen.render(x2 * 8, y2 * 8, 416, Color.get(-1, 1, 5, 445), 1);
                }
                else if (x2 == x0 && y2 == y1) {
                    screen.render(x2 * 8, y2 * 8, 416, Color.get(-1, 1, 5, 445), 2);
                }
                else if (x2 == x1 && y2 == y1) {
                    screen.render(x2 * 8, y2 * 8, 416, Color.get(-1, 1, 5, 445), 3);
                }
                else if (y2 == y0) {
                    screen.render(x2 * 8, y2 * 8, 417, Color.get(-1, 1, 5, 445), 0);
                }
                else if (y2 == y1) {
                    screen.render(x2 * 8, y2 * 8, 417, Color.get(-1, 1, 5, 445), 2);
                }
                else if (x2 == x0) {
                    screen.render(x2 * 8, y2 * 8, 418, Color.get(-1, 1, 5, 445), 0);
                }
                else if (x2 == x1) {
                    screen.render(x2 * 8, y2 * 8, 418, Color.get(-1, 1, 5, 445), 1);
                }
                else {
                    screen.render(x2 * 8, y2 * 8, 418, Color.get(5, 5, 5, 5), 1);
                }
            }
        }
        draw(title, screen, x0 * 8 + 8, y0 * 8, Color.get(5, 5, 5, 550));
    }
    
    public static void rendercraftFrame(final Screen screen, final String title, final int x0, final int y0, final int x1, final int y1) {
        for (int y2 = y0; y2 <= y1; ++y2) {
            for (int x2 = x0; x2 <= x1; ++x2) {
                if (x2 == x0 && y2 == y0) {
                    screen.render(x2 * 8, y2 * 8, 416, Color.get(-1, 1, 300, 400), 0);
                }
                else if (x2 == x1 && y2 == y0) {
                    screen.render(x2 * 8, y2 * 8, 416, Color.get(-1, 1, 300, 400), 1);
                }
                else if (x2 == x0 && y2 == y1) {
                    screen.render(x2 * 8, y2 * 8, 416, Color.get(-1, 1, 300, 400), 2);
                }
                else if (x2 == x1 && y2 == y1) {
                    screen.render(x2 * 8, y2 * 8, 416, Color.get(-1, 1, 300, 400), 3);
                }
                else if (y2 == y0) {
                    screen.render(x2 * 8, y2 * 8, 417, Color.get(-1, 1, 300, 400), 0);
                }
                else if (y2 == y1) {
                    screen.render(x2 * 8, y2 * 8, 417, Color.get(-1, 1, 300, 400), 2);
                }
                else if (x2 == x0) {
                    screen.render(x2 * 8, y2 * 8, 418, Color.get(-1, 1, 300, 400), 0);
                }
                else if (x2 == x1) {
                    screen.render(x2 * 8, y2 * 8, 418, Color.get(-1, 1, 300, 400), 1);
                }
                else {
                    screen.render(x2 * 8, y2 * 8, 418, Color.get(300, 300, 300, 300), 1);
                }
            }
        }
        draw(title, screen, x0 * 8 + 8, y0 * 8, Color.get(300, 300, 300, 555));
    }
    
    public static void renderFrameBook(final Screen screen, final String title, final int x0, final int y0, final int x1, final int y1) {
        for (int y2 = y0; y2 <= y1; ++y2) {
            for (int x2 = x0; x2 <= x1; ++x2) {
                if (x2 == x0 && y2 == y0) {
                    screen.render(x2 * 8, y2 * 8, 416, Color.get(-1, 1, 554, 554), 0);
                }
                else if (x2 == x1 && y2 == y0) {
                    screen.render(x2 * 8, y2 * 8, 416, Color.get(-1, 1, 554, 554), 1);
                }
                else if (x2 == x0 && y2 == y1) {
                    screen.render(x2 * 8, y2 * 8, 416, Color.get(-1, 1, 554, 554), 2);
                }
                else if (x2 == x1 && y2 == y1) {
                    screen.render(x2 * 8, y2 * 8, 416, Color.get(-1, 1, 554, 554), 3);
                }
                else if (y2 == y0) {
                    screen.render(x2 * 8, y2 * 8, 417, Color.get(-1, 1, 554, 554), 0);
                }
                else if (y2 == y1) {
                    screen.render(x2 * 8, y2 * 8, 417, Color.get(-1, 1, 554, 554), 2);
                }
                else if (x2 == x0) {
                    screen.render(x2 * 8, y2 * 8, 418, Color.get(-1, 1, 554, 554), 0);
                }
                else if (x2 == x1) {
                    screen.render(x2 * 8, y2 * 8, 418, Color.get(-1, 1, 554, 554), 1);
                }
                else {
                    screen.render(x2 * 8, y2 * 8, 418, Color.get(554, 554, 554, 554), 1);
                }
            }
            draw(title, screen, x0 * 8 + 8, y0 * 8, Color.get(-1, 222, 222, 222));
        }
    }
}
