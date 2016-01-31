package com.derelictech.slangman;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Tim on 1/29/2016.
 */
public class Letter {
    private Vector2 pos;
    public String val;
    private Color color;
    private boolean used;
    private boolean show;

    public Rectangle clickBox;

    public Letter(float x, float y, String letter, Color color) {
        this(new Vector2(x, y), letter, color);
    }

    public Letter(Vector2 position, String letter, Color color) {
        this.pos = new Vector2(position);
        this.val = letter;
        this.color = new Color(color);
        this.clickBox = new Rectangle(this.pos.x, this.pos.y, 20, 20);
        this.clickBox.setPosition(clickBox.x - 5, clickBox.y - 17);
    }

    public void setColor(Color c) {
        this.color.set(c);
    }

    public void draw(SpriteBatch batch, ShapeRenderer sr, BitmapFont font) {
        font.setColor(this.color);
        if(show) {
            font.draw(batch, this.val, this.pos.x, this.pos.y);
        }
        else {
            font.draw(batch, "_", this.pos.x, this.pos.y);
        }

        sr.set(ShapeRenderer.ShapeType.Line);
        sr.setColor(this.color);
        sr.rect(clickBox.x, clickBox.y, clickBox.width, clickBox.height);
    }

    public void setUsed(boolean b) {
        this.used = b;
    }
    public boolean isUsed() {
        return used;
    }
    public void show(boolean b) {
        this.show = b;
    }
}
