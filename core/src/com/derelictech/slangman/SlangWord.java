package com.derelictech.slangman;

/**
 * Created by Tim on 1/30/2016.
 */
public class SlangWord {
    public String slang;
    public String def;

    public SlangWord(SlangWord inword) {
        this.slang = inword.slang;
        this.def = inword.def;
    }

    public SlangWord(String slang, String def) {
        this.slang = slang;
        this.def = def;
    }

    public void setSlang(String slang) {
        this.slang = slang;
    }

    public void setDef(String def) {
        this.def = def;
    }
}
