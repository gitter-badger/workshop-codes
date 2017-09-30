package com.codingblcoks.jeteater;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.codingblcoks.jeteater.screen.PlayScreen;

public class EaterGame extends Game {
	public static SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen());

	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
		batch.dispose();

	}
}
