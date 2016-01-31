package com.derelictech.slangman;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by Tim on 1/29/2016.
 */
public class Alphabet {
    public static final int NUM_LETTERS = 26;
    private Vector2 pos;
    private int w;
    private Letter[] letters;
    public Rectangle clickBox;

    private BitmapFont font;

    public Alphabet(float x, float y, int width) {
        this(new Vector2(x, y), width);
    }

    public Alphabet(Vector2 position, int width) {
        this.pos = new Vector2(position);
        this.w = width;
        this.letters = new Letter[NUM_LETTERS];
        this.font = new BitmapFont();
        this.font.setColor(0, 1, 0, 1);

        this.clickBox = new Rectangle(this.pos.x - 6, this.pos.y - 18, this.w - 3, this.font.getLineHeight() + 9);

        // Initialize Letters
        Character c = 'a';
        for(int i = 0; i < NUM_LETTERS; i++) {
            float x = this.pos.x + (i * (this.w / NUM_LETTERS));
            letters[i] = new Letter(x, this.pos.y, c.toString(), Color.GREEN);
            letters[i].show(true);
            c++;
        }
    }

    public void draw(SpriteBatch batch, ShapeRenderer sr) {
        for(Letter l : letters) {
            l.draw(batch, sr, this.font);
        }
        sr.setColor(Color.BLUE);
        sr.rect(this.clickBox.x, this.clickBox.y, this.clickBox.width, this.clickBox.height);
    }

    public Letter clicked(Vector2 pos) {
        return this.clicked(pos.x, pos.y);
    }
    public Letter clicked(float x, float y) {
        for(Letter l : letters) {
            if(l.clickBox.contains(x, y) && !l.isUsed()) {
                l.setUsed(true);
                System.out.println(l.val + " WAS CLICKED");
                return l;
            }
            else if(l.clickBox.contains(x, y) && l.isUsed()) {
                return null;
            }
        } // End for letters

        // Letter clicked is already used
        return null;
    }

    public void reset() {
        for(Letter l : letters) {
            l.reset();
        }
    }
}
