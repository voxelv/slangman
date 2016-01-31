package com.derelictech.slangman;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Tim on 1/30/2016.
 */
public class Gallows {
    Vector2 pos;
    Color color;

    public Gallows(Vector2 pos, Color c) {
        this(pos.x, pos.y, c);
    }

    public Gallows(float x, float y, Color c) {
        pos = new Vector2(x, y);
        color = new Color(c);
    }

    public void draw(SpriteBatch batch, ShapeRenderer sr) {
        sr.setColor(color);
        sr.set(ShapeRenderer.ShapeType.Line);
        sr.line(this.pos.x, this.pos.y, this.pos.x, this.pos.y + 20);
        sr.line(this.pos.x, this.pos.y + 20, this.pos.x - 100, this.pos.y + 20);
        sr.line(this.pos.x - 50, this.pos.y + 20, this.pos.x - 100, this.pos.y - 30);
        sr.line(this.pos.x - 100, this.pos.y + 20, this.pos.x - 100, this.pos.y - 220);
        sr.line(this.pos.x - 200, this.pos.y - 220, this.pos.x + 100, this.pos.y - 220);
    }
}
