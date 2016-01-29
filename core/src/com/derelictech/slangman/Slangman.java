package com.derelictech.slangman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Slangman extends ApplicationAdapter {
    SpriteBatch batch;
	BitmapFont font;
	ShapeRenderer sr;
    Alphabet alphabet;
	
	@Override
	public void create () {
        batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(0, 1, 0, 0);
		sr = new ShapeRenderer();
        alphabet = new Alphabet(10, 30, 600);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Game Logic



        // Render
        sr.begin(ShapeRenderer.ShapeType.Line);
		batch.begin();
		//TODO: ADD RENDER STEPS
        alphabet.draw(batch, font, sr);
		batch.end();
        sr.end();
	}
}
