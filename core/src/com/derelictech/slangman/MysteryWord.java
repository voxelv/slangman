package com.derelictech.slangman;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Tim on 1/30/2016.
 */
public class MysteryWord extends ArrayList<Letter> {
    Vector2 pos;
    SlangWord slangWord;
    BitmapFont font;

    public MysteryWord(float x, float y, SlangWord word) {
        pos = new Vector2(x, y);
        slangWord = new SlangWord(word);
        font = new BitmapFont();
        font.setColor(Color.WHITE);

        // Create Leters
        for(int i = 0; i < slangWord.slang.length(); i++) {
            this.add(new Letter(this.pos.x + (i * 30), this.pos.y, Character.toString(slangWord.slang.charAt(i)), Color.WHITE));
        }
    }

    public MysteryWord(Vector2 position, SlangWord word) {
        this(position.x, position.y, word);
    }

    //TODO: Draw Leters
    public void draw(SpriteBatch batch, ShapeRenderer sr) {
        for(Letter l : this) {
            l.draw(batch, sr, this.font);
        }
    }

    public void setSlangWord(SlangWord word) {
        slangWord = new SlangWord(word);

        this.clear();

        // Recreate Leters
        for(int i = 0; i < slangWord.slang.length(); i++) {
            this.add(new Letter(this.pos.x + (i * 30), this.pos.y, Character.toString(slangWord.slang.charAt(i)), Color.WHITE));
        }
    }
}
