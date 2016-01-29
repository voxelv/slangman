package com.derelictech.slangman;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by Tim on 1/29/2016.
 */
public class Letter extends Actor {
    private Vector2 pos;
    private String val;
    private Color color;

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

    public void draw(SpriteBatch batch, BitmapFont font, ShapeRenderer sr) {
        font.setColor(this.color);
        font.draw(batch, this.val, this.pos.x, this.pos.y);

        sr.set(ShapeRenderer.ShapeType.Line);
        sr.setColor(this.color);
        sr.rect(clickBox.x, clickBox.y, clickBox.width, clickBox.height);
    }
}
