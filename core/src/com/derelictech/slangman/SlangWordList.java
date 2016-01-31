package com.derelictech.slangman;

import java.util.ArrayList;

/**
 * Created by Tim on 1/30/2016.
 */
public class SlangWordList extends ArrayList<SlangWord> {
    public SlangWordList() {
        this.add("brb",      "Be Right Back");
        this.add("bbiab",    "Be Back In A Bit");
        this.add("bbl",      "Be Back Later");
        this.add("ttfn",     "Ta Ta For Now");
        this.add("bbs",      "Be Back Soon");
        this.add("btw",      "By The Way");
        this.add("kiss",     "Keep It Simple Stupid");
        this.add("kit",      "Keep In Touch");
        this.add("gg",       "Good Game");
        this.add("pm",       "Private Message");
        this.add("ttyl",     "Talk To You Later");
        this.add("ltns",     "Long Time No See");
        this.add("idk",      "I Don't Know");
        this.add("lol",      "Laugh Out Loud");
        this.add("rofl",     "Rolling On Floor Laughing");
        this.add("ty",       "Thank You");
        this.add("doa",      "Dead On Arrival");
        this.add("asap",     "As Soon As Possible");
        this.add("fyi",      "For Your Information");
        this.add("ttyl",     "Talk To You Later");
        this.add("jicyww",   "Just In Case You Were Wondering");
        this.add("glhf",     "Good Luck, Have Fun");
        this.add("tldr",     "Too Long, Didn't Read");
        this.add("noob",     "New Person");
        this.add("derp",     "That was silly, or Nothing to say");
        this.add("facepalm", "Something suddenly became obvious");
        this.add("irl",      "In Real Life");
        this.add("yolo",     "You Only Live Once");
        this.add("afaik",    "As Far As I Know");
        this.add("dunno",    "I don't know");
        this.add("gonna",    "Going to");
        this.add("ima",      "I'm going to");
        this.add("srsly",    "Seriously");
        this.add("imo",      "In My Opinion");
        this.add("imho",     "In My Humble Opinion, In My Honest Opinion");
    }

    public boolean add(String word, String def) {
        super.add(new SlangWord(word, def));
        return true;
    }
}
