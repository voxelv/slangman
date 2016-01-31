package com.derelictech.slangman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

public class Slangman extends ApplicationAdapter {

    Random random;

    SpriteBatch batch;
	ShapeRenderer sr;
    Alphabet alphabet;

    SlangWordList slanglist;
    MysteryWord mword;

	
	@Override
	public void create () {
        random = new Random(0x01234567L);
        batch = new SpriteBatch();
		sr = new ShapeRenderer();
        alphabet = new Alphabet(10, 30, 600);

        slanglist = new SlangWordList();
        mword = new MysteryWord(10, 70, slanglist.get(random.nextInt(slanglist.size())));


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

                Letter letter = null;
                System.out.println("CLICKED: " + screenX +", "+ screenY);
                if(alphabet.clickBox.contains(screenX, screenY))
                {
                    letter = alphabet.clicked(screenX, screenY);
                }

                if(letter != null)
                {
                    //TODO: Process new clicked letter
                    System.out.println("Got: " + letter.val);
                    for(Letter l : mword) {
                        if(l.val.charAt(0) == letter.val.charAt(0)) {
                            l.show(true);
                        }
                    }
                }
                else {
                    System.out.println("Clicked letter was already used.");
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
        mword.draw(batch, sr);
        alphabet.draw(batch, sr);
		batch.end();
        sr.end();
	}
}
