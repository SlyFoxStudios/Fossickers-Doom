// 
// Decompiled by Procyon v0.5.30
// 

package com.fossickersdoom.screen;

import com.fossickersdoom.gfx.Color;
import com.fossickersdoom.gfx.Font;
import com.fossickersdoom.gfx.Screen;
import com.fossickersdoom.entity.Player;
import com.fossickersdoom.crafting.Recipe;
import java.util.List;

public class BookAntVenomMenu extends Menu
{
    public int pages;
    public int lastpage;
    
    public BookAntVenomMenu(final List<Recipe> recipes, final Player player) {
        this.pages = 0;
        this.lastpage = 12;
    }
    
    @Override
    public void tick() {
        if (this.input.menu.clicked) {
            this.game.setMenu(null);
        }
        if (this.input.left.clicked) {
            --this.pages;
        }
        if (this.input.right.clicked) {
            ++this.pages;
        }
    }
    
    @Override
    public void render(final Screen screen) {
        Font.renderFrameBook(screen, "", 14, 0, 21, 3);
        Font.renderFrameBook(screen, "", 1, 4, 34, 20);
        final int xo = 132;
        final int xe = 121;
        final int xa = 129;
        final int xu = 125;
        if (this.pages <= 9 && this.pages >= 1) {
            Font.draw(new StringBuilder().append(this.pages).toString(), screen, xo + 7, 16, Color.get(-1, 0, 0, 0));
        }
        else if (this.pages < 1) {
            Font.draw("Title", screen, xe + 4, 16, Color.get(-1, 0, 0, 0));
        }
        else if (this.pages > 9 && this.pages < 100) {
            Font.draw(new StringBuilder().append(this.pages).toString(), screen, xa + 7, 16, Color.get(-1, 0, 0, 0));
        }
        else if (this.pages > 99) {
            Font.draw(new StringBuilder().append(this.pages).toString(), screen, xu + 7, 16, Color.get(-1, 0, 0, 0));
        }
        Font.draw("Page", screen, 128, 6, Color.get(-1, 0, 0, 0));
        if (this.pages < 0) {
            this.pages = 0;
        }
        if (this.pages > this.lastpage) {
            this.pages = this.lastpage;
        }
        if (this.pages == 0) {
            Font.draw("Antidious Venomi", screen, 80, 40, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 58, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 67, Color.get(-1, 0, 0, 0));
            Font.draw("A short story by David.B", screen, 48, 76, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 85, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 94, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 103, Color.get(-1, 0, 0, 0));
            Font.draw("12 Pages", screen, 108, 112, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 121, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 130, Color.get(-1, 0, 0, 0));
            Font.draw("2012", screen, 126, 139, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 148, Color.get(-1, 0, 0, 0));
        }
        else if (this.pages == 1) {
            Font.draw("There was once a creature who", screen, 15, 40, Color.get(-1, 0, 0, 0));
            Font.draw("lived in his small home in the", screen, 15, 49, Color.get(-1, 0, 0, 0));
            Font.draw("valley. Only a few people know", screen, 15, 58, Color.get(-1, 0, 0, 0));
            Font.draw("of his existence. A being like", screen, 15, 67, Color.get(-1, 0, 0, 0));
            Font.draw("us, but not the same. He can", screen, 15, 76, Color.get(-1, 0, 0, 0));
            Font.draw("fight, talk, and solve problems.", screen, 15, 85, Color.get(-1, 0, 0, 0));
            Font.draw("But he is dangerous also. I can", screen, 15, 94, Color.get(-1, 0, 0, 0));
            Font.draw("say that people who went looking", screen, 15, 103, Color.get(-1, 0, 0, 0));
            Font.draw("for him, never came back.", screen, 15, 112, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 121, Color.get(-1, 0, 0, 0));
            Font.draw("So I set myself to find the", screen, 15, 130, Color.get(-1, 0, 0, 0));
            Font.draw("creature and record my data in", screen, 15, 139, Color.get(-1, 0, 0, 0));
            Font.draw("this journal.", screen, 15, 148, Color.get(-1, 0, 0, 0));
        }
        else if (this.pages == 2) {
            Font.draw("His valley is supposedly some-", screen, 15, 40, Color.get(-1, 0, 0, 0));
            Font.draw("where in the Golden Mountains.", screen, 15, 49, Color.get(-1, 0, 0, 0));
            Font.draw("It is a place forbidden for", screen, 15, 58, Color.get(-1, 0, 0, 0));
            Font.draw("anyone to enter. It has said", screen, 15, 67, Color.get(-1, 0, 0, 0));
            Font.draw("that the legendary golden fruit", screen, 15, 76, Color.get(-1, 0, 0, 0));
            Font.draw("grows there and that it can heal", screen, 15, 85, Color.get(-1, 0, 0, 0));
            Font.draw("any wound with one bite. That", screen, 15, 94, Color.get(-1, 0, 0, 0));
            Font.draw("is just a legend though, and I", screen, 15, 103, Color.get(-1, 0, 0, 0));
            Font.draw("am not here for it.", screen, 15, 112, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 121, Color.get(-1, 0, 0, 0));
            Font.draw("Many people have came here for", screen, 15, 130, Color.get(-1, 0, 0, 0));
            Font.draw("the fruit, and died trying. If", screen, 15, 139, Color.get(-1, 0, 0, 0));
            Font.draw("it is true, I think the creature", screen, 15, 148, Color.get(-1, 0, 0, 0));
        }
        else if (this.pages == 3) {
            Font.draw("would have gotten to it by now.", screen, 15, 40, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 49, Color.get(-1, 0, 0, 0));
            Font.draw("I enter the mountains with my", screen, 15, 58, Color.get(-1, 0, 0, 0));
            Font.draw("supplies and said my goodbies.", screen, 15, 67, Color.get(-1, 0, 0, 0));
            Font.draw("The trees have pale green leaves", screen, 15, 76, Color.get(-1, 0, 0, 0));
            Font.draw("with thick vines around them. I", screen, 15, 85, Color.get(-1, 0, 0, 0));
            Font.draw("have crossed into the forbbiden", screen, 15, 94, Color.get(-1, 0, 0, 0));
            Font.draw("zone, and this is my last chance", screen, 15, 103, Color.get(-1, 0, 0, 0));
            Font.draw("for going back. I kept my spirt", screen, 15, 112, Color.get(-1, 0, 0, 0));
            Font.draw("high and senses also. I don't", screen, 15, 121, Color.get(-1, 0, 0, 0));
            Font.draw("know what I will run into here.", screen, 15, 130, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 139, Color.get(-1, 0, 0, 0));
            Font.draw("It looks like someone left a", screen, 15, 148, Color.get(-1, 0, 0, 0));
        }
        else if (this.pages == 4) {
            Font.draw("bunch of rocks on the ground to", screen, 15, 40, Color.get(-1, 0, 0, 0));
            Font.draw("make a trail, but since the", screen, 15, 49, Color.get(-1, 0, 0, 0));
            Font.draw("ground is to mossy it's hard to ", screen, 15, 58, Color.get(-1, 0, 0, 0));
            Font.draw("make out where the trail leads.", screen, 15, 67, Color.get(-1, 0, 0, 0));
            Font.draw("I come up to what looks like a", screen, 15, 76, Color.get(-1, 0, 0, 0));
            Font.draw("camp site. It seems to have been", screen, 15, 85, Color.get(-1, 0, 0, 0));
            Font.draw("deserted for a long time. I have", screen, 15, 94, Color.get(-1, 0, 0, 0));
            Font.draw("found a book that is dated from", screen, 15, 103, Color.get(-1, 0, 0, 0));
            Font.draw("many years ago. The person who", screen, 15, 112, Color.get(-1, 0, 0, 0));
            Font.draw("wrote this was after the golden", screen, 15, 121, Color.get(-1, 0, 0, 0));
            Font.draw("fruit. It says about how he'll", screen, 15, 130, Color.get(-1, 0, 0, 0));
            Font.draw("be famous for his journy. I put", screen, 15, 139, Color.get(-1, 0, 0, 0));
            Font.draw("down the book as the sky was", screen, 15, 148, Color.get(-1, 0, 0, 0));
        }
        else if (this.pages == 5) {
            Font.draw("turning dark. I chopped some wood", screen, 15, 40, Color.get(-1, 0, 0, 0));
            Font.draw("and started a campfire. I fell", screen, 15, 49, Color.get(-1, 0, 0, 0));
            Font.draw("asleep a few hours later and woke", screen, 15, 58, Color.get(-1, 0, 0, 0));
            Font.draw("up by dawn. The clouds must have", screen, 15, 67, Color.get(-1, 0, 0, 0));
            Font.draw("dissapeared and I felt a short", screen, 15, 76, Color.get(-1, 0, 0, 0));
            Font.draw("but cold breeze in the air.", screen, 15, 85, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 94, Color.get(-1, 0, 0, 0));
            Font.draw("The lustrous sunlight came down", screen, 15, 103, Color.get(-1, 0, 0, 0));
            Font.draw("as I set off to continue my jou-", screen, 15, 112, Color.get(-1, 0, 0, 0));
            Font.draw("rney. I came across a apple tree", screen, 15, 121, Color.get(-1, 0, 0, 0));
            Font.draw("Nothing special about it, but", screen, 15, 130, Color.get(-1, 0, 0, 0));
            Font.draw("there was something behind it.", screen, 15, 139, Color.get(-1, 0, 0, 0));
            Font.draw("I couldn't believe my eyes, A", screen, 15, 148, Color.get(-1, 0, 0, 0));
        }
        else if (this.pages == 6) {
            Font.draw("large garden of fruits! I can ", screen, 15, 40, Color.get(-1, 0, 0, 0));
            Font.draw("see Apples, Bananas, Grapes,", screen, 15, 49, Color.get(-1, 0, 0, 0));
            Font.draw("Pears, Cherrys, Blueberrys, and", screen, 15, 58, Color.get(-1, 0, 0, 0));
            Font.draw("many others. This garden of eden", screen, 15, 67, Color.get(-1, 0, 0, 0));
            Font.draw("seems to be endless and somehow", screen, 15, 76, Color.get(-1, 0, 0, 0));
            Font.draw("like a maze. I can feed my kin", screen, 15, 85, Color.get(-1, 0, 0, 0));
            Font.draw("for generations with all of this", screen, 15, 94, Color.get(-1, 0, 0, 0));
            Font.draw("food. I hear footsteps behind me", screen, 15, 103, Color.get(-1, 0, 0, 0));
            Font.draw("I found some bushes to take some", screen, 15, 112, Color.get(-1, 0, 0, 0));
            Font.draw("cover. What is that thing? I've", screen, 15, 121, Color.get(-1, 0, 0, 0));
            Font.draw("never seen it before. Is it the", screen, 15, 130, Color.get(-1, 0, 0, 0));
            Font.draw("creature I'm searching for?", screen, 15, 139, Color.get(-1, 0, 0, 0));
            Font.draw("It's eyes have this cold dark", screen, 15, 148, Color.get(-1, 0, 0, 0));
        }
        else if (this.pages == 7) {
            Font.draw("brown color, his hide is only", screen, 15, 40, Color.get(-1, 0, 0, 0));
            Font.draw("partly visible on his head, the", screen, 15, 49, Color.get(-1, 0, 0, 0));
            Font.draw("rest seems to be bare. He also", screen, 15, 58, Color.get(-1, 0, 0, 0));
            Font.draw("has this strange amulet on his", screen, 15, 67, Color.get(-1, 0, 0, 0));
            Font.draw("chest. It looks fancy, it's made", screen, 15, 76, Color.get(-1, 0, 0, 0));
            Font.draw("from iron, gold, and Amethyst. I", screen, 15, 85, Color.get(-1, 0, 0, 0));
            Font.draw("can't seem to stop looking at it", screen, 15, 94, Color.get(-1, 0, 0, 0));
            Font.draw("What is happing to me? It feels", screen, 15, 103, Color.get(-1, 0, 0, 0));
            Font.draw("as though I want to move closer", screen, 15, 112, Color.get(-1, 0, 0, 0));
            Font.draw("to it. I can't, I cannot blow my", screen, 15, 121, Color.get(-1, 0, 0, 0));
            Font.draw("cover like this. It would be the", screen, 15, 130, Color.get(-1, 0, 0, 0));
            Font.draw("end of me for sure. But as soon", screen, 15, 139, Color.get(-1, 0, 0, 0));
            Font.draw("my leg lifted, the creature left", screen, 15, 148, Color.get(-1, 0, 0, 0));
        }
        else if (this.pages == 8) {
            Font.draw("with some grapefruit. I cought", screen, 15, 40, Color.get(-1, 0, 0, 0));
            Font.draw("my breath and sat down for a", screen, 15, 49, Color.get(-1, 0, 0, 0));
            Font.draw("minute. I don't know why I did", screen, 15, 58, Color.get(-1, 0, 0, 0));
            Font.draw("not leave right there and then,", screen, 15, 67, Color.get(-1, 0, 0, 0));
            Font.draw("I might have lived. But this", screen, 15, 76, Color.get(-1, 0, 0, 0));
            Font.draw("sudden urge for that amulet made", screen, 15, 85, Color.get(-1, 0, 0, 0));
            Font.draw("me continue. I caught up to the", screen, 15, 94, Color.get(-1, 0, 0, 0));
            Font.draw("creature, following closely but", screen, 15, 103, Color.get(-1, 0, 0, 0));
            Font.draw("silently. It looks like his home", screen, 15, 112, Color.get(-1, 0, 0, 0));
            Font.draw("is ahead. As he enters I go to", screen, 15, 121, Color.get(-1, 0, 0, 0));
            Font.draw("the side and peak in from a win-", screen, 15, 130, Color.get(-1, 0, 0, 0));
            Font.draw("dow. He is in the kitchen with", screen, 15, 139, Color.get(-1, 0, 0, 0));
            Font.draw("the fruit, It's not too big of", screen, 15, 148, Color.get(-1, 0, 0, 0));
        }
        else if (this.pages == 9) {
            Font.draw("a room. Some light coming from", screen, 15, 40, Color.get(-1, 0, 0, 0));
            Font.draw("the celling from a mysetrous", screen, 15, 49, Color.get(-1, 0, 0, 0));
            Font.draw("stone. From a large metal box he", screen, 15, 58, Color.get(-1, 0, 0, 0));
            Font.draw("grabs some fish and pork. Places", screen, 15, 67, Color.get(-1, 0, 0, 0));
            Font.draw("some of the fruit on his plate", screen, 15, 76, Color.get(-1, 0, 0, 0));
            Font.draw("and puts the rest in the box. I", screen, 15, 85, Color.get(-1, 0, 0, 0));
            Font.draw("noticed that the amulet from his", screen, 15, 94, Color.get(-1, 0, 0, 0));
            Font.draw("chest is gone. Creeping to the ", screen, 15, 103, Color.get(-1, 0, 0, 0));
            Font.draw("front door, I saw a horrifing", screen, 15, 112, Color.get(-1, 0, 0, 0));
            Font.draw("sight. On a fireplace I see a", screen, 15, 121, Color.get(-1, 0, 0, 0));
            Font.draw("head as a trophy piece. I went", screen, 15, 130, Color.get(-1, 0, 0, 0));
            Font.draw("back out to hurl. I don't know", screen, 15, 139, Color.get(-1, 0, 0, 0));
            Font.draw("what Monster would do such a sin", screen, 15, 148, Color.get(-1, 0, 0, 0));
        }
        else if (this.pages == 10) {
            Font.draw("The beast enters from the room,", screen, 15, 40, Color.get(-1, 0, 0, 0));
            Font.draw("I cannot enter from the front.", screen, 15, 49, Color.get(-1, 0, 0, 0));
            Font.draw("Slowly I make my way to the back", screen, 15, 58, Color.get(-1, 0, 0, 0));
            Font.draw("door. The door makes a quiet sq-", screen, 15, 67, Color.get(-1, 0, 0, 0));
            Font.draw("ueek, but the beast doesn't hear", screen, 15, 76, Color.get(-1, 0, 0, 0));
            Font.draw("it. I look around for the amulet", screen, 15, 85, Color.get(-1, 0, 0, 0));
            Font.draw("while not to make a sound. after", screen, 15, 94, Color.get(-1, 0, 0, 0));
            Font.draw("a bit of searching I come across", screen, 15, 103, Color.get(-1, 0, 0, 0));
            Font.draw("his room. He has a wood platform", screen, 15, 112, Color.get(-1, 0, 0, 0));
            Font.draw("with knobs and tiny square lines", screen, 15, 121, Color.get(-1, 0, 0, 0));
            Font.draw("and a Picture is on it. It seems", screen, 15, 130, Color.get(-1, 0, 0, 0));
            Font.draw("to be a female, probably from ", screen, 15, 139, Color.get(-1, 0, 0, 0));
            Font.draw("the same race. And a small paper", screen, 15, 148, Color.get(-1, 0, 0, 0));
        }
        else if (this.pages == 11) {
            Font.draw("at the back of it. Its his name,", screen, 15, 40, Color.get(-1, 0, 0, 0));
            Font.draw("'An-' before I could say it he ", screen, 15, 49, Color.get(-1, 0, 0, 0));
            Font.draw("comes into the room with a puzz-", screen, 15, 58, Color.get(-1, 0, 0, 0));
            Font.draw("led look on his face. Drawing a", screen, 15, 67, Color.get(-1, 0, 0, 0));
            Font.draw("blade made of Iron from his side", screen, 15, 76, Color.get(-1, 0, 0, 0));
            Font.draw("and charges. I run for my life,", screen, 15, 85, Color.get(-1, 0, 0, 0));
            Font.draw("as fast as can down the hallway,", screen, 15, 94, Color.get(-1, 0, 0, 0));
            Font.draw("and out the door.", screen, 15, 103, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 112, Color.get(-1, 0, 0, 0));
            Font.draw("This is the final minute for me", screen, 15, 121, Color.get(-1, 0, 0, 0));
            Font.draw("By the tenth step of grass I co-", screen, 15, 130, Color.get(-1, 0, 0, 0));
            Font.draw("llapsed, Bleeding to death as my", screen, 15, 139, Color.get(-1, 0, 0, 0));
            Font.draw("cow brothers did before me. With", screen, 15, 148, Color.get(-1, 0, 0, 0));
        }
        else if (this.pages == 12) {
            Font.draw("my last ounce of strength I drew", screen, 15, 40, Color.get(-1, 0, 0, 0));
            Font.draw("his name out with my blood in", screen, 15, 49, Color.get(-1, 0, 0, 0));
            Font.draw("the hopes that somebody can know", screen, 15, 58, Color.get(-1, 0, 0, 0));
            Font.draw("this terror.", screen, 15, 67, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 76, Color.get(-1, 0, 0, 0));
            Font.draw("'You can only make out a little.'", screen, 15, 85, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 94, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 103, Color.get(-1, 0, 0, 0));
            Font.draw("'Ant----- Venom-'", screen, 15, 112, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 121, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 130, Color.get(-1, 0, 0, 0));
            Font.draw("", screen, 15, 139, Color.get(-1, 0, 0, 0));
            Font.draw("                        The end", screen, 15, 148, Color.get(-1, 0, 0, 0));
        }
    }
}
