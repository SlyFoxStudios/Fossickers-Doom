package com.fossickersdoom.level.levelgen;

import com.fossickersdoom.level.tile.Tile;
import com.fossickersdoom.screen.WorldGenMenu;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LevelGen {

    private static final Random random = new Random();
    public double[] values;
    private int w;
    private int h;


    public LevelGen(int w, int h, int featureSize) {
        this.w = w;
        this.h = h;
        this.values = new double[w * h];

        int stepSize;
        for(stepSize = 0; stepSize < w; stepSize += featureSize) {
            for(int scale = 0; scale < w; scale += featureSize) {
                this.setSample(scale, stepSize, (double)(random.nextFloat() * 2.0F - 1.0F));
            }
        }

        stepSize = featureSize;
        double scale1 = (double)(2 / w);
        double scaleMod = 1.0D;

        do {
            int halfStep = stepSize / 2;

            int y;
            int x;
            double a;
            double b;
            double c;
            double d;
            double e;
            for(y = 0; y < w; y += stepSize) {
                for(x = 0; x < w; x += stepSize) {
                    a = this.sample(x, y);
                    b = this.sample(x + stepSize, y);
                    c = this.sample(x, y + stepSize);
                    d = this.sample(x + stepSize, y + stepSize);
                    e = (a + b + c + d) / 4.0D + (double)((random.nextFloat() * 2.0F - 1.0F) * (float)stepSize) * scale1;
                    this.setSample(x + halfStep, y + halfStep, e);
                }
            }

            for(y = 0; y < w; y += stepSize) {
                for(x = 0; x < w; x += stepSize) {
                    a = this.sample(x, y);
                    b = this.sample(x + stepSize, y);
                    c = this.sample(x, y + stepSize);
                    d = this.sample(x + halfStep, y + halfStep);
                    e = this.sample(x + halfStep, y - halfStep);
                    double f = this.sample(x - halfStep, y + halfStep);
                    double H = (a + b + d + e) / 4.0D + (double)((random.nextFloat() * 2.0F - 1.0F) * (float)stepSize) * scale1 * 0.5D;
                    double g = (a + c + d + f) / 4.0D + (double)((random.nextFloat() * 2.0F - 1.0F) * (float)stepSize) * scale1 * 0.5D;
                    this.setSample(x + halfStep, y, H);
                    this.setSample(x, y + halfStep, g);
                }
            }

            stepSize /= 2;
            scale1 *= scaleMod + 0.8D;
            scaleMod *= 0.3D;
        } while(stepSize > 1);

    }

    private double sample(int x, int y) {
        return this.values[(x & this.w - 1) + (y & this.h - 1) * this.w];
    }

    private void setSample(int x, int y, double value) {
        this.values[(x & this.w - 1) + (y & this.h - 1) * this.w] = value;
    }

    public static short[][] createAndValidateTopMap(int w, int h) {
        boolean attempt = false;

        short[][] result;
        while(true) {
            int[] count;
            do {
                do {
                    do {
                        do {
                            result = createTopMap(w, h);
                            count = new int[256];

                            for(int i = 0; i < w * h; ++i) {
                                ++count[result[0][i] & 255];
                            }
                        } while(count[Tile.rock.id & 255] < 100);
                    } while(count[Tile.sand.id & 255] < 100);
                } while(count[Tile.grass.id & 255] < 100);
            } while(count[Tile.tree.id & 255] < 100);

            if(WorldGenMenu.sized == 128) {
                if(count[Tile.stairsDown.id & 255] < 6) {
                    continue;
                }
            } else if(WorldGenMenu.sized == 256) {
                if(count[Tile.stairsDown.id & 255] < 8) {
                    continue;
                }
            } else if(count[Tile.stairsDown.id & 255] < 10) {
                continue;
            }
            break;
        }

        return result;
    }

    public static short[][] createAndValidateUndergroundMap(int w, int h, int depth) {
        while(true) {
            short[][] result = createUndergroundMap(w, h, depth);
            int[] count = new int[256];

            for(int i = 0; i < w * h; ++i) {
                ++count[result[0][i] & 255];
            }

            if(count[Tile.rock.id & 255] >= 100 && count[Tile.dirt.id & 255] >= 100 && count[(Tile.ironOre.id & 255) + depth - 1] >= 20) {
                if(WorldGenMenu.sized == 128) {
                    if(depth < 3 && count[Tile.stairsDown.id & 255] < 6) {
                        continue;
                    }
                } else if(WorldGenMenu.sized == 256) {
                    if(depth < 3 && count[Tile.stairsDown.id & 255] < 8) {
                        continue;
                    }
                } else if(depth < 3 && count[Tile.stairsDown.id & 255] < 10) {
                    continue;
                }

                return result;
            }
        }
    }

    public static short[][] createAndValidateDungeon(int w, int h) {
        boolean attempt = false;

        short[][] result;
        int[] count;
        do {
            result = createDungeon(w, h);
            count = new int[256];

            for(int i = 0; i < w * h; ++i) {
                ++count[result[0][i] & 255];
            }
        } while(count[Tile.o.id & 255] < 100 || count[Tile.ow.id & 255] < 100);

        return result;
    }

    public static short[][] createAndValidateSkyMap(int w, int h) {
        boolean attempt = false;

        short[][] result;
        int[] count;
        do {
            result = createSkyMap(w, h);
            count = new int[256];

            for(int i = 0; i < w * h; ++i) {
                ++count[result[0][i] & 255];
            }
        } while(count[Tile.cloud.id & 255] < 2000 || count[Tile.stairsDown.id & 255] < 2);

        return result;
    }

    private static short[][] createTopMap(int w, int h) {
        LevelGen mnoise1 = new LevelGen(w, h, 16);
        LevelGen mnoise2 = new LevelGen(w, h, 16);
        LevelGen mnoise3 = new LevelGen(w, h, 16);
        LevelGen noise1 = new LevelGen(w, h, 32);
        LevelGen noise2 = new LevelGen(w, h, 32);
        short[] map = new short[w * h];
        short[] data = new short[w * h];

        int count;
        int i;
        int x;
        for(count = 0; count < h; ++count) {
            for(i = 0; i < w; ++i) {
                x = i + count * w;
                double y = Math.abs(noise1.values[x] - noise2.values[x]) * 3.0D - 2.0D;
                double xx = Math.abs(mnoise1.values[x] - mnoise2.values[x]);
                xx = Math.abs(xx - mnoise3.values[x]) * 3.0D - 2.0D;
                double xo = (double)i / ((double)w - 1.0D) * 2.0D - 1.0D;
                double yy2 = (double)count / ((double)h - 1.0D) * 2.0D - 1.0D;
                if(xo < 0.0D) {
                    xo = -xo;
                }

                if(yy2 < 0.0D) {
                    yy2 = -yy2;
                }

                double dist = xo >= yy2?xo:yy2;
                dist = dist * dist * dist * dist;
                dist = dist * dist * dist * dist;
                y = y + 1.0D - dist * 20.0D;
                if(WorldGenMenu.type == WorldGenMenu.island) {
                    if(y < -0.5D) {
                        if(WorldGenMenu.theme == WorldGenMenu.hell) {
                            map[x] = Tile.lava.id;
                        }

                        if(WorldGenMenu.theme != WorldGenMenu.hell) {
                            map[x] = Tile.water.id;
                        }
                    } else if(y > 0.5D && xx < -1.5D) {
                        map[x] = Tile.rock.id;
                    } else {
                        map[x] = Tile.grass.id;
                    }
                } else if(WorldGenMenu.type == WorldGenMenu.box) {
                    if(y < -1.5D) {
                        if(WorldGenMenu.theme == WorldGenMenu.hell) {
                            map[x] = Tile.lava.id;
                        }

                        if(WorldGenMenu.theme != WorldGenMenu.hell) {
                            map[x] = Tile.water.id;
                        }
                    } else if(y > 0.5D && xx < -1.5D) {
                        map[x] = Tile.rock.id;
                    } else {
                        map[x] = Tile.grass.id;
                    }
                } else if(WorldGenMenu.type == WorldGenMenu.mount) {
                    if(y < -0.4D) {
                        map[x] = Tile.grass.id;
                    } else if(y > 0.5D && xx < -1.5D) {
                        if(WorldGenMenu.theme != WorldGenMenu.hell) {
                            map[x] = Tile.water.id;
                        }

                        if(WorldGenMenu.theme == WorldGenMenu.hell) {
                            map[x] = Tile.lava.id;
                        }
                    } else {
                        map[x] = Tile.rock.id;
                    }
                }

                if(WorldGenMenu.type == WorldGenMenu.irreg) {
                    if(y < -0.5D && xx < -0.5D) {
                        if(WorldGenMenu.theme == WorldGenMenu.hell) {
                            map[x] = Tile.lava.id;
                        }

                        if(WorldGenMenu.theme != WorldGenMenu.hell) {
                            map[x] = Tile.water.id;
                        }
                    } else if(y > 0.5D && xx < -1.5D) {
                        map[x] = Tile.rock.id;
                    } else {
                        map[x] = Tile.grass.id;
                    }
                }
            }
        }

        int yy;
        int yy1;
        int yo;
        int xx1;
        int var22;
        int var23;
        int var24;
        int var25;
        if(WorldGenMenu.theme == WorldGenMenu.desert) {
            for(count = 0; count < w * h / 200; ++count) {
                i = random.nextInt(w);
                x = random.nextInt(h);

                for(var22 = 0; var22 < 10; ++var22) {
                    yy = i + random.nextInt(21) - 10;
                    var23 = x + random.nextInt(21) - 10;

                    for(yy1 = 0; yy1 < 100; ++yy1) {
                        var24 = yy + random.nextInt(5) - random.nextInt(5);
                        yo = var23 + random.nextInt(5) - random.nextInt(5);

                        for(var25 = yo - 1; var25 <= yo + 1; ++var25) {
                            for(xx1 = var24 - 1; xx1 <= var24 + 1; ++xx1) {
                                if(xx1 >= 0 && var25 >= 0 && xx1 < w && var25 < h && map[xx1 + var25 * w] == Tile.grass.id) {
                                    map[xx1 + var25 * w] = Tile.sand.id;
                                }
                            }
                        }
                    }
                }
            }
        }

        if(WorldGenMenu.theme != WorldGenMenu.desert) {
            for(count = 0; count < w * h / 2800; ++count) {
                i = random.nextInt(w);
                x = random.nextInt(h);

                for(var22 = 0; var22 < 10; ++var22) {
                    yy = i + random.nextInt(21) - 10;
                    var23 = x + random.nextInt(21) - 10;

                    for(yy1 = 0; yy1 < 100; ++yy1) {
                        var24 = yy + random.nextInt(5) - random.nextInt(5);
                        yo = var23 + random.nextInt(5) - random.nextInt(5);

                        for(var25 = yo - 1; var25 <= yo + 1; ++var25) {
                            for(xx1 = var24 - 1; xx1 <= var24 + 1; ++xx1) {
                                if(xx1 >= 0 && var25 >= 0 && xx1 < w && var25 < h && map[xx1 + var25 * w] == Tile.grass.id) {
                                    map[xx1 + var25 * w] = Tile.sand.id;
                                }
                            }
                        }
                    }
                }
            }
        }

        if(WorldGenMenu.theme == WorldGenMenu.forest) {
            for(count = 0; count < w * h / 200; ++count) {
                i = random.nextInt(w);
                x = random.nextInt(h);

                for(var22 = 0; var22 < 200; ++var22) {
                    yy = i + random.nextInt(15) - random.nextInt(15);
                    var23 = x + random.nextInt(15) - random.nextInt(15);
                    if(yy >= 0 && var23 >= 0 && yy < w && var23 < h && map[yy + var23 * w] == Tile.grass.id) {
                        map[yy + var23 * w] = Tile.tree.id;
                    }
                }
            }
        }

        if(WorldGenMenu.theme != WorldGenMenu.forest && WorldGenMenu.theme != WorldGenMenu.plain) {
            for(count = 0; count < w * h / 1200; ++count) {
                i = random.nextInt(w);
                x = random.nextInt(h);

                for(var22 = 0; var22 < 200; ++var22) {
                    yy = i + random.nextInt(15) - random.nextInt(15);
                    var23 = x + random.nextInt(15) - random.nextInt(15);
                    if(yy >= 0 && var23 >= 0 && yy < w && var23 < h && map[yy + var23 * w] == Tile.grass.id) {
                        map[yy + var23 * w] = Tile.tree.id;
                    }
                }
            }
        }

        if(WorldGenMenu.theme == WorldGenMenu.plain) {
            for(count = 0; count < w * h / 2800; ++count) {
                i = random.nextInt(w);
                x = random.nextInt(h);

                for(var22 = 0; var22 < 200; ++var22) {
                    yy = i + random.nextInt(15) - random.nextInt(15);
                    var23 = x + random.nextInt(15) - random.nextInt(15);
                    if(yy >= 0 && var23 >= 0 && yy < w && var23 < h && map[yy + var23 * w] == Tile.grass.id) {
                        map[yy + var23 * w] = Tile.tree.id;
                    }
                }
            }
        }

        if(WorldGenMenu.theme != WorldGenMenu.plain) {
            for(count = 0; count < w * h / 400; ++count) {
                i = random.nextInt(w);
                x = random.nextInt(h);

                for(var22 = 0; var22 < 200; ++var22) {
                    yy = i + random.nextInt(15) - random.nextInt(15);
                    var23 = x + random.nextInt(15) - random.nextInt(15);
                    if(yy >= 0 && var23 >= 0 && yy < w && var23 < h && map[yy + var23 * w] == Tile.grass.id) {
                        map[yy + var23 * w] = Tile.tree.id;
                    }
                }
            }
        }

        for(count = 0; count < w * h / 400; ++count) {
            i = random.nextInt(w);
            x = random.nextInt(h);
            var22 = random.nextInt(4);

            for(yy = 0; yy < 30; ++yy) {
                var23 = i + random.nextInt(5) - random.nextInt(5);
                yy1 = x + random.nextInt(5) - random.nextInt(5);
                if(var23 >= 0 && yy1 >= 0 && var23 < w && yy1 < h && map[var23 + yy1 * w] == Tile.grass.id) {
                    map[var23 + yy1 * w] = Tile.flower.id;
                    data[var23 + yy1 * w] = (short)(var22 + random.nextInt(4) * 16);
                }
            }
            for(yy = 0; yy < 30; ++yy) {
                var23 = i + random.nextInt(5) - random.nextInt(5);
                yy1 = x + random.nextInt(5) - random.nextInt(5);
                if(var23 >= 0 && yy1 >= 0 && var23 < w && yy1 < h && map[var23 + yy1 * w] == Tile.grass.id) {
                    map[var23 + yy1 * w] = Tile.salvia.id;
                    data[var23 + yy1 * w] = (short)(var22 + random.nextInt(4) * 16);
                }
            }
            for(yy = 0; yy < 30; ++yy) {
                var23 = i + random.nextInt(5) - random.nextInt(5);
                yy1 = x + random.nextInt(5) - random.nextInt(5);
                if(var23 >= 0 && yy1 >= 0 && var23 < w && yy1 < h && map[var23 + yy1 * w] == Tile.grass.id) {
                    map[var23 + yy1 * w] = Tile.brose.id;
                    data[var23 + yy1 * w] = (short)(var22 + random.nextInt(4) * 16);
                }
            }
        }

        for(count = 0; count < w * h / 100; ++count) {
            i = random.nextInt(w);
            x = random.nextInt(h);
            if(i >= 0 && x >= 0 && i < w && x < h && map[i + x * w] == Tile.sand.id) {
                map[i + x * w] = Tile.cactus.id;
            }
        }

        count = 0;

        label278:
        for(i = 0; i < w * h / 100; ++i) {
            x = random.nextInt(w - 2) + 1;
            var22 = random.nextInt(h - 2) + 1;

            for(yy = var22 - 1; yy <= var22 + 1; ++yy) {
                for(var23 = x - 1; var23 <= x + 1; ++var23) {
                    if(map[var23 + yy * w] != Tile.rock.id) {
                        continue label278;
                    }
                }
            }

            map[x + var22 * w] = Tile.stairsDown.id;
            ++count;
            if(WorldGenMenu.sized == 128) {
                if(count == 6) {
                    break;
                }
            } else if(WorldGenMenu.sized == 25) {
                if(count == 8) {
                    break;
                }
            } else if(count == 10) {
                break;
            }
        }

        return new short[][]{map, data};
    }

    private static short[][] createDungeon(int w, int h) {
        LevelGen noise1 = new LevelGen(w, h, 8);
        LevelGen noise2 = new LevelGen(w, h, 8);
        short[] map = new short[w * h];
        short[] data = new short[w * h];

        int count;
        int i;
        int x;
        for(count = 0; count < h; ++count) {
            for(i = 0; i < w; ++i) {
                x = i + count * w;
                double y = Math.abs(noise1.values[x] - noise2.values[x]) * 3.0D - 2.0D;
                double xx = (double)i / ((double)w - 1.1D) * 2.0D - 1.0D;
                double yd = (double)count / ((double)h - 1.1D) * 2.0D - 1.0D;
                if(xx < 0.0D) {
                    xx = -xx;
                }

                if(yd < 0.0D) {
                    yd = -yd;
                }

                double dist = xx >= yd?xx:yd;
                dist = dist * dist * dist * dist;
                dist = dist * dist * dist * dist;
                y = -y * 1.0D - 2.2D;
                y = y + 1.0D - dist * 2.0D;
                if(y < -0.35D) {
                    map[x] = Tile.ow.id;
                } else {
                    map[x] = Tile.o.id;
                }
            }
        }

        count = 0;

        int yy;
        int var17;
        while(count < w * h / 450) {
            i = random.nextInt(w - 2) + 1;
            x = random.nextInt(h - 2) + 1;
            var17 = x - 1;

            label85:
            while(true) {
                if(var17 > x + 1) {
                    map[i + x * w] = Tile.lava.id;
                    map[i + (x + 1) * w] = Tile.lava.id;
                    map[i + 1 + (x + 1) * w] = Tile.lava.id;
                    map[i + 1 + x * w] = Tile.lava.id;
                } else {
                    yy = i - 1;

                    while(true) {
                        if(yy > i + 1) {
                            ++var17;
                            continue label85;
                        }

                        if(map[yy + var17 * w] != Tile.ow.id) {
                            break;
                        }

                        ++yy;
                    }
                }

                ++count;
                break;
            }
        }

        count = 0;

        label70:
        for(i = 0; i < w * h; ++i) {
            x = random.nextInt(w - 2) + 1;
            var17 = random.nextInt(h - 2) + 1;

            for(yy = var17 - 1; yy <= var17 + 1; ++yy) {
                for(int var18 = x - 1; var18 <= x + 1; ++var18) {
                    if(map[var18 + yy * w] != Tile.ow.id) {
                        continue label70;
                    }
                }
            }

            map[x + var17 * w] = Tile.ow.id;
            ++count;
            if(count == 2) {
                break;
            }
        }

        return new short[][]{map, data};
    }

    private static short[][] createUndergroundMap(int w, int h, int depth) {
        LevelGen mnoise1 = new LevelGen(w, h, 16);
        LevelGen mnoise2 = new LevelGen(w, h, 16);
        LevelGen mnoise3 = new LevelGen(w, h, 16);
        LevelGen nnoise1 = new LevelGen(w, h, 16);
        LevelGen nnoise2 = new LevelGen(w, h, 16);
        LevelGen nnoise3 = new LevelGen(w, h, 16);
        LevelGen wnoise1 = new LevelGen(w, h, 16);
        LevelGen wnoise2 = new LevelGen(w, h, 16);
        LevelGen wnoise3 = new LevelGen(w, h, 16);
        LevelGen noise1 = new LevelGen(w, h, 32);
        LevelGen noise2 = new LevelGen(w, h, 32);
        short[] map = new short[w * h];
        short[] data = new short[w * h];

        int count;
        int i;
        int x;
        for(count = 0; count < h; ++count) {
            for(i = 0; i < w; ++i) {
                x = i + count * w;
                double y = Math.abs(noise1.values[x] - noise2.values[x]) * 3.0D - 2.0D;
                double xx = Math.abs(mnoise1.values[x] - mnoise2.values[x]);
                xx = Math.abs(xx - mnoise3.values[x]) * 3.0D - 2.0D;
                double nval = Math.abs(nnoise1.values[x] - nnoise2.values[x]);
                nval = Math.abs(nval - nnoise3.values[x]) * 3.0D - 2.0D;
                double wval = Math.abs(wnoise1.values[x] - wnoise2.values[x]);
                wval = Math.abs(nval - wnoise3.values[x]) * 3.0D - 2.0D;
                double xd = (double)i / ((double)w - 1.0D) * 2.0D - 1.0D;
                double yd = (double)count / ((double)h - 1.0D) * 2.0D - 1.0D;
                if(xd < 0.0D) {
                    xd = -xd;
                }

                if(yd < 0.0D) {
                    yd = -yd;
                }

                double dist = xd >= yd?xd:yd;
                dist = dist * dist * dist * dist;
                dist = dist * dist * dist * dist;
                y = y + 1.0D - dist * 20.0D;
                if(y > -1.0D && wval < (double)(-1 + depth / 2 * 3)) {
                    if(depth == 3) {
                        map[x] = Tile.lava.id;
                    } else if(depth == 1) {
                        map[x] = Tile.dirt.id;
                    } else {
                        map[x] = Tile.water.id;
                    }
                } else if(y > -2.0D && (xx < -1.7D || nval < -1.4D)) {
                    map[x] = Tile.dirt.id;
                } else {
                    map[x] = Tile.rock.id;
                }
            }
        }

        short var33 = 2;
        int yy;
        int yy1;
        int var34;
        int var36;
        if(WorldGenMenu.type == WorldGenMenu.mount) {
            for(i = 0; i < w * h / 150; ++i) {
                x = random.nextInt(w);
                var34 = random.nextInt(h);

                for(yy = 0; yy < 30; ++yy) {
                    var36 = x + random.nextInt(5) - random.nextInt(5);
                    yy1 = var34 + random.nextInt(5) - random.nextInt(5);
                    if(var36 >= var33 && yy1 >= var33 && var36 < w - var33 && yy1 < h - var33 && map[var36 + yy1 * w] == Tile.rock.id) {
                        map[var36 + yy1 * w] = (short)((Tile.ironOre.id & 255) + depth - 1);
                    }
                }

                for(yy = 0; yy < 7; ++yy) {
                    var36 = x + random.nextInt(3) - random.nextInt(2);
                    yy1 = var34 + random.nextInt(3) - random.nextInt(2);
                    if(var36 >= var33 && yy1 >= var33 && var36 < w - var33 && yy1 < h - var33 && map[var36 + yy1 * w] == Tile.rock.id) {
                        map[var36 + yy1 * w] = (short)(Tile.lapisOre.id & 255);
                    }
                }
            }
        } else {
            for(i = 0; i < w * h / 400; ++i) {
                x = random.nextInt(w);
                var34 = random.nextInt(h);

                for(yy = 0; yy < 30; ++yy) {
                    var36 = x + random.nextInt(5) - random.nextInt(5);
                    yy1 = var34 + random.nextInt(5) - random.nextInt(5);
                    if(var36 >= var33 && yy1 >= var33 && var36 < w - var33 && yy1 < h - var33 && map[var36 + yy1 * w] == Tile.rock.id) {
                        map[var36 + yy1 * w] = (short)((Tile.ironOre.id & 255) + depth - 1);
                    }
                }

                for(yy = 0; yy < 10; ++yy) {
                    var36 = x + random.nextInt(3) - random.nextInt(2);
                    yy1 = var34 + random.nextInt(3) - random.nextInt(2);
                    if(var36 >= var33 && yy1 >= var33 && var36 < w - var33 && yy1 < h - var33 && map[var36 + yy1 * w] == Tile.rock.id) {
                        map[var36 + yy1 * w] = (short)(Tile.lapisOre.id & 255);
                    }
                }
            }
        }

        if(depth > 2) {
            var33 = 1;

            for(i = 0; i < w * h / 380; ++i) {
                for(x = 0; x < 10; ++x) {
                    short var35 = 60;
                    short var37 = 60;
                    if(var35 >= var33 && var37 >= var33 && var35 < w - var33 && var37 < h - var33) {
                        map[var35 + var37 * w] = (short)(Tile.ow.id & 255);
                        map[var35 + 1 + var37 * w] = (short)(Tile.ow.id & 255);
                        map[var35 + (var37 + 1) * w] = (short)(Tile.ow.id & 255);
                        map[var35 + 2 + var37 * w] = (short)(Tile.ow.id & 255);
                        map[var35 + (var37 + 2) * w] = (short)(Tile.ow.id & 255);
                        map[var35 + 3 + var37 * w] = (short)(Tile.ow.id & 255);
                        map[var35 + (var37 + 3) * w] = (short)(Tile.ow.id & 255);
                        map[var35 + 4 + var37 * w] = (short)(Tile.ow.id & 255);
                        map[var35 + (var37 + 4) * w] = (short)(Tile.ow.id & 255);
                        map[var35 + 4 + (var37 + 1) * w] = (short)(Tile.ow.id & 255);
                        map[var35 + 4 + (var37 + 2) * w] = (short)(Tile.ow.id & 255);
                        map[var35 + 4 + (var37 + 3) * w] = (short)(Tile.ow.id & 255);
                        map[var35 + 4 + (var37 + 4) * w] = (short)(Tile.ow.id & 255);
                        map[var35 + 3 + (var37 + 1) * w] = (short)(Tile.o.id & 255);
                        map[var35 + 3 + (var37 + 2) * w] = (short)(Tile.o.id & 255);
                        map[var35 + 3 + (var37 + 3) * w] = (short)(Tile.o.id & 255);
                        map[var35 + 3 + (var37 + 4) * w] = (short)(Tile.ow.id & 255);
                        map[var35 + 2 + (var37 + 1) * w] = (short)(Tile.o.id & 255);
                        map[var35 + 2 + (var37 + 2) * w] = (short)(Tile.stairsDown.id & 255);
                        map[var35 + 2 + (var37 + 3) * w] = (short)(Tile.o.id & 255);
                        map[var35 + 2 + (var37 + 4) * w] = (short)(Tile.ow.id & 255);
                        map[var35 + 1 + (var37 + 1) * w] = (short)(Tile.o.id & 255);
                        map[var35 + 1 + (var37 + 2) * w] = (short)(Tile.o.id & 255);
                        map[var35 + 1 + (var37 + 3) * w] = (short)(Tile.o.id & 255);
                        map[var35 + 1 + (var37 + 4) * w] = (short)(Tile.ow.id & 255);
                    }
                }
            }
        }

        if(depth < 3) {
            count = 0;

            label159:
            for(i = 0; i < w * h / 100; ++i) {
                x = random.nextInt(w - 20) + 10;
                var34 = random.nextInt(h - 20) + 10;

                for(yy = var34 - 1; yy <= var34 + 1; ++yy) {
                    for(var36 = x - 1; var36 <= x + 1; ++var36) {
                        if(map[var36 + yy * w] != Tile.rock.id) {
                            continue label159;
                        }
                    }
                }

                map[x + var34 * w] = Tile.stairsDown.id;
                ++count;
                if(WorldGenMenu.sized == 128) {
                    if(count == 6) {
                        break;
                    }
                } else if(WorldGenMenu.sized == 25) {
                    if(count == 8) {
                        break;
                    }
                } else if(count == 10) {
                    break;
                }
            }
        }

        return new short[][]{map, data};
    }

    private static short[][] createSkyMap(int w, int h) {
        LevelGen noise1 = new LevelGen(w, h, 8);
        LevelGen noise2 = new LevelGen(w, h, 8);
        short[] map = new short[w * h];
        short[] data = new short[w * h];

        int count;
        int i;
        int x;
        for(count = 0; count < h; ++count) {
            for(i = 0; i < w; ++i) {
                x = i + count * w;
                double y = Math.abs(noise1.values[x] - noise2.values[x]) * 3.0D - 2.0D;
                double xx = (double)i / ((double)w - 1.0D) * 2.0D - 1.0D;
                double yd = (double)count / ((double)h - 1.0D) * 2.0D - 1.0D;
                if(xx < 0.0D) {
                    xx = -xx;
                }

                if(yd < 0.0D) {
                    yd = -yd;
                }

                double dist = xx >= yd?xx:yd;
                dist = dist * dist * dist * dist;
                dist = dist * dist * dist * dist;
                y = -y * 1.0D - 2.2D;
                y = y + 1.0D - dist * 20.0D;
                if(y < -0.25D) {
                    map[x] = Tile.infiniteFall.id;
                } else {
                    map[x] = Tile.cloud.id;
                }
            }
        }

        count = 0;

        int yy;
        int var17;
        while(count < w * h / 50) {
            i = random.nextInt(w - 2) + 1;
            x = random.nextInt(h - 2) + 1;
            var17 = x - 1;

            label85:
            while(true) {
                if(var17 > x + 1) {
                    map[i + x * w] = Tile.cloudCactus.id;
                } else {
                    yy = i - 1;

                    while(true) {
                        if(yy > i + 1) {
                            ++var17;
                            continue label85;
                        }

                        if(map[yy + var17 * w] != Tile.cloud.id) {
                            break;
                        }

                        ++yy;
                    }
                }

                ++count;
                break;
            }
        }

        count = 0;

        label70:
        for(i = 0; i < w * h; ++i) {
            x = random.nextInt(w - 2) + 1;
            var17 = random.nextInt(h - 2) + 1;

            for(yy = var17 - 1; yy <= var17 + 1; ++yy) {
                for(int var18 = x - 1; var18 <= x + 1; ++var18) {
                    if(map[var18 + yy * w] != Tile.cloud.id) {
                        continue label70;
                    }
                }
            }

            map[x + var17 * w] = Tile.stairsDown.id;
            ++count;
            if(count == 2) {
                break;
            }
        }

        return new short[][]{map, data};
    }

    public static void main(String[] args) {
        int d = 0;

        while(true) {
            short w = 128;
            short h = w;
            short[] map = createAndValidateUndergroundMap(w, w, d++ % 3 + 1)[0];
            BufferedImage img = new BufferedImage(w, w, 1);
            int[] pixels = new int[w * w];

            for(int y = 0; y < h; ++y) {
                for(int x = 0; x < w; ++x) {
                    int i = x + y * w;
                    if(map[i] == Tile.water.id) {
                        pixels[i] = 128;
                    }

                    if(map[i] == Tile.ironOre.id) {
                        pixels[i] = 12288;
                    }

                    if(map[i] == Tile.goldOre.id) {
                        pixels[i] = 12288;
                    }

                    if(map[i] == Tile.gemOre.id) {
                        pixels[i] = 12288;
                    }

                    if(map[i] == Tile.lapisOre.id) {
                        pixels[i] = 16777200;
                    }

                    if(map[i] == Tile.grass.id) {
                        pixels[i] = 2129952;
                    }

                    if(map[i] == Tile.rock.id) {
                        pixels[i] = 10526880;
                    }

                    if(map[i] == Tile.dirt.id) {
                        pixels[i] = 6307904;
                    }

                    if(map[i] == Tile.sand.id) {
                        pixels[i] = 10526784;
                    }

                    if(map[i] == Tile.sbrick.id) {
                        pixels[i] = 10526784;
                    }

                    if(map[i] == Tile.tree.id) {
                        pixels[i] = 12288;
                    }

                    if(map[i] == Tile.ow.id) {
                        pixels[i] = 696480;
                    }

                    if(map[i] == Tile.o.id) {
                        pixels[i] = 0;
                    }

                    if(map[i] == Tile.lava.id) {
                        pixels[i] = 16719904;
                    }

                    if(map[i] == Tile.cloud.id) {
                        pixels[i] = 10526880;
                    }

                    if(map[i] == Tile.stairsDown.id) {
                        pixels[i] = 16777215;
                    }

                    if(map[i] == Tile.stairsUp.id) {
                        pixels[i] = 16777215;
                    }

                    if(map[i] == Tile.cloudCactus.id) {
                        pixels[i] = 16711935;
                    }
                }
            }

            img.setRGB(0, 0, w, h, pixels, 0, w);
            JOptionPane.showMessageDialog((Component)null, (Object)null, "Another", 0, new ImageIcon(img.getScaledInstance(w * 2, h * 2, 16)));
        }
    }
}