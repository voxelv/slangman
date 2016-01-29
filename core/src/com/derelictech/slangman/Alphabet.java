package com.derelictech.slangman;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Tim on 1/29/2016.
 */
public class Alphabet {
    public static final int NUM_LETTERS = 26;
    private Vector2 pos;
    private int w;
    private Letter[] letters;

    public Alphabet(float x, float y, int width) {
        this(new Vector2(x, y), width);
    }

    public Alphabet(Vector2 position, int width) {
        this.pos = new Vector2(position);
        this.w = width;
        letters = new Letter[NUM_LETTERS];

        // Initialize Letters
        Character c = 'a';
        for(int i = 0; i < NUM_LETTERS; i++) {
            float x = this.pos.x + (i * (this.w / NUM_LETTERS));
            letters[i] = new Letter(x, this.pos.y, c.toString(), Color.GREEN);
            c++;
        }
    }

    public void draw(SpriteBatch batch, BitmapFont font, ShapeRenderer sr) {
        for(Letter l : letters) {
            l.draw(batch, font,sr);
        }
    }
}
