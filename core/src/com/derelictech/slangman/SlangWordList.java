package com.derelictech.slangman;

import java.util.ArrayList;

/**
 * Created by Tim on 1/30/2016.
 */
public class SlangWordList extends ArrayList<SlangWord> {
    public SlangWordList() {
        this.add("ddos", "Dynamic Denial Of Service");
        this.add("lol", "Laugh out Loud, or Lots of Laughs");
        this.add("rofl", "Rolling On Floor Laughing");
        this.add("afk", "Away From Keyboard");
        this.add("cya", "See Ya, a derivative of \"See you later\"");
        this.add("kk", "Ok");
    }

    public boolean add(String word, String def) {
        super.add(new SlangWord(word, def));
        return true;
    }
}
