package com.codingblcoks.jeteater.screen;

import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.codingblcoks.jeteater.EaterGame;
import com.codingblcoks.jeteater.scene.HUD;
import com.codingblcoks.jeteater.sprite.Bomb;
import com.codingblcoks.jeteater.sprite.Coin;
import com.codingblcoks.jeteater.sprite.Jet;

public class PlayScreen implements Screen {

    private Jet jet;
    private HUD hud;

    private LinkedList<Coin> coins = new LinkedList<Coin>();
    private LinkedList<Bomb> bombs = new LinkedList<Bomb>();

    public PlayScreen() {
        jet = new Jet();
        hud = new HUD();

        for (int i = 0; i < 4; i++) {
            coins.add(new Coin());
        }

        for (int i = 0; i < 4; i++) {
            bombs.add(new Bomb());
        }

    }

    @Override public void show() {

    }

    @Override public void render(float delta) {
        update();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        EaterGame.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();

        EaterGame.batch.begin();

        for (Bomb bomb: bombs) {
            bomb.draw(EaterGame.batch);
        }

        for (Coin coin: coins) {
            coin.draw(EaterGame.batch);
        }

        jet.draw(EaterGame.batch);

        EaterGame.batch.end();
    }

    private void update() {
        handleInput();
        handleEvent();
    }

    private void handleEvent() {
        for (Bomb bomb: bombs) {
            if (bomb.checkHit(jet)){
                hud.kill();
            }
        }

        for (Coin coin: coins) {
            if(coin.checkHit(jet)) {
               hud.addScore(10);
            }
        }
    }

    private void handleInput() {
        int x = Gdx.input.getX();
        int y = Gdx.graphics.getHeight() - Gdx.input.getY();

        jet.setGoal(x, y);
    }

    @Override public void resize(int width, int height) {

    }

    @Override public void pause() {

    }

    @Override public void resume() {

    }

    @Override public void hide() {

    }

    @Override public void dispose() {

    }
}
