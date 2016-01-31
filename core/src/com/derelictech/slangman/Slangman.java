package com.derelictech.slangman;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Slangman extends ApplicationAdapter {

    Random random;

    SpriteBatch batch;
	ShapeRenderer sr;
    BitmapFont font;

    Alphabet alphabet;
    SlangWordList slanglist;
    MysteryWord mword;

    HangmanGraphic hmgraphic;
    private int score = 0;

    Button playAgainButton;
    Button quitButton;

    boolean win = false;
    boolean loose = false;

    Vector2 hmanPos;
    Gallows gallows;

    @Override
	public void create () {
        random = new Random(0x01234567L);
        batch = new SpriteBatch();
		sr = new ShapeRenderer();
        font = new BitmapFont();
        font.setColor(Color.WHITE);

        alphabet = new Alphabet(10, 30, 600);
        slanglist = new SlangWordList();
        mword = new MysteryWord(120, 100, slanglist.get(random.nextInt(slanglist.size())));

        hmanPos = new Vector2(Gdx.graphics.getWidth() / 2, 350);
        hmgraphic = new HangmanGraphic(hmanPos.x, hmanPos.y, Color.RED);
        gallows = new Gallows(hmanPos, Color.BROWN);

        playAgainButton = new Button(400, 10, "Play Again", Color.GREEN);
        quitButton = new Button(530, 10, "Quit", Color.RED);

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                screenY = Gdx.graphics.getHeight() - screenY;
                System.out.println("CLICKED: " + screenX + ", " + screenY);

                if (!(win || loose)) {

                    Letter letter = null;
                    if (alphabet.clickBox.contains(screenX, screenY)) {
                        letter = alphabet.clicked(screenX, screenY);
                    }

                    if (letter != null) {
                        //TODO: Process new clicked letter
                        System.out.println("Got: " + letter.val);

                        boolean letterInWord = false;
                        boolean wordComplete = true;
                        for (Letter l : mword) {
                            if (l.val.charAt(0) == letter.val.charAt(0)) {
                                l.show(true);
                                letterInWord = true;
                            }

                            if (!l.isShown()) {
                                wordComplete = false;
                            }
                        } // End for letters in mword

                        if (!letterInWord) {
                            score++;
                            if (score >= 6) {
                                loose = true;
                            }
                        }

                        if (wordComplete) {
                            //TODO: Win!
                            System.out.println("YOU WON!");

                            win = true;
                        }
                    } else {
                        System.out.println("Clicked letter was already used.");
                    }
                }
                else {
                    System.out.println("Click on Win or Loose Screen");
                    if(playAgainButton.contains(screenX, screenY)) {
                        System.out.println("Clicked Play Again");
                        win = false;
                        loose = false;
                        alphabet.reset();
                        mword.setSlangWord(new SlangWord(slanglist.get(random.nextInt(slanglist.size()))));
                        score = 0;
                    }
                    else if(quitButton.contains(screenX, screenY)) {
                        System.out.println("Clicked Play Again");
                        dispose();
                        win = false;
                        loose = false;
                        System.exit(0);
                    }
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


        sr.begin(ShapeRenderer.ShapeType.Line);
        batch.begin();
        mword.draw(batch, sr);
        gallows.draw(batch, sr);
        hmgraphic.draw(batch, sr, this.score);
        if(!(win || loose)) {
            // Render
            alphabet.draw(batch, sr);
        }
        else if(win) {
            // Render
            font.draw(batch, "YOU WON!", 300, 30);
            font.draw(batch, "The slang was: \"" + mword.slangWord.slang + "\"", 20, Gdx.graphics.getHeight() - 20);
            font.draw(batch, "Its definition is: \"" + mword.slangWord.def + "\"", 20, Gdx.graphics.getHeight() - 40);
            playAgainButton.draw(batch, sr);
            quitButton.draw(batch, sr);
        }
        else {
            // Render
            font.draw(batch, "YOU LOST!", 300, 30);
            font.draw(batch, "The slang was: \"" + mword.slangWord.slang + "\"", 20, Gdx.graphics.getHeight() - 20);
            font.draw(batch, "Its definition is: \"" + mword.slangWord.def + "\"", 20, Gdx.graphics.getHeight() - 40);
            playAgainButton.draw(batch, sr);
            quitButton.draw(batch, sr);
        }
        batch.end();
        sr.end();
	}

    @Override
    public void dispose() {
        batch.dispose();
        sr.dispose();
        font.dispose();
        super.dispose();
    }
}
