package com.derelictech.slangman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Slangman extends ApplicationAdapter {
    SpriteBatch batch;
	ShapeRenderer sr;
    Alphabet alphabet;
	
	@Override
	public void create () {
        batch = new SpriteBatch();
		sr = new ShapeRenderer();
        alphabet = new Alphabet(10, 30, 600);

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                screenY = Gdx.graphics.getHeight() - screenY;

                System.out.println(screenX +", "+ screenY);

                return true;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                screenY = Gdx.graphics.getHeight() - screenY;
                System.out.println("CLICKED: " + screenX +", "+ screenY);
                if(alphabet.clickBox.contains(screenX, screenY))
                {
                    alphabet.clicked(screenX, screenY);
                }

                return true;
            }
        });
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
        alphabet.draw(batch, sr);
		batch.end();
        sr.end();
	}
}
