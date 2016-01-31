package com.derelictech.slangman;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Tim on 1/LEGARM_LEN/2016.
 */
public class HangmanGraphic {
    public Vector2 pos;
    Color color;

    private static final int HEAD_RADIUS = 20;
    private static final int BACK_LENGTH = 100;
    private static final int LEGARM_LEN = 50;

    float neckx, necky, groinx, groiny;

    public HangmanGraphic(float x, float y, Color c) {
        this.pos = new Vector2(x, y);
        this.neckx = x;
        this.necky = y - (HEAD_RADIUS * 2);
        this.groinx = x;
        this.groiny = y - (HEAD_RADIUS * 2) - BACK_LENGTH;

        this.color = new Color(c);
    }

    public void draw(SpriteBatch batch, ShapeRenderer sr, int score) {
        sr.set(ShapeRenderer.ShapeType.Line);
        sr.setColor(this.color);
        if(score >= 6) { drawRightLeg(batch, sr); }
        if(score >= 5) { drawLeftLeg(batch, sr); }
        if(score >= 4) { drawRightArm(batch, sr); }
        if(score >= 3) { drawLeftArm(batch, sr); }
        if(score >= 2) { drawBack(batch, sr); }
        if(score >= 1) { drawHead(batch, sr); }
    }

    private void drawRightLeg(SpriteBatch batch, ShapeRenderer sr) {
        sr.line(this.groinx, this.groiny, this.groinx + LEGARM_LEN, this.groiny - LEGARM_LEN);
    }

    private void drawLeftLeg(SpriteBatch batch, ShapeRenderer sr) {
        sr.line(this.groinx, this.groiny, this.groinx - LEGARM_LEN, this.groiny - LEGARM_LEN);
    }

    private void drawRightArm(SpriteBatch batch, ShapeRenderer sr) {
        sr.line(this.neckx, this.necky, this.neckx + LEGARM_LEN, this.necky - LEGARM_LEN);
    }

    private void drawLeftArm(SpriteBatch batch, ShapeRenderer sr) {
        sr.line(this.neckx, this.necky, this.neckx - LEGARM_LEN, this.necky - LEGARM_LEN);
    }

    private void drawBack(SpriteBatch batch, ShapeRenderer sr) {
        sr.line(this.neckx, this.necky, this.groinx, this.groiny);
    }

    private void drawHead(SpriteBatch batch, ShapeRenderer sr) {
        sr.circle(this.pos.x, this.pos.y - HEAD_RADIUS, HEAD_RADIUS);
    }
}
