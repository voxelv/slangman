package com.derelictech.slangman;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Tim on 1/30/2016.
 */
public class Button extends Rectangle{
    private String text;
    private Color color;
    BitmapFont font;

    public Button(float x, float y, String text, Color c) {
        super(x, y, 100, 30);
        this.text = text;
        color = new Color(c);
        font = new BitmapFont();
        font.setColor(c);
    }

    public void draw(SpriteBatch batch, ShapeRenderer sr) {
        font.draw(batch, text, this.x + 10, this.y + 20);
        sr.setColor(this.color);
        sr.rect(this.x, this.y, this.width, this.height);
    }
}
