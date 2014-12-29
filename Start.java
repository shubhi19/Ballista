package com.bow.arrow;

import java.awt.Color;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Start implements Screen {
	SpriteBatch batch;
	BitmapFont font;
	Texture img;
	MyGame1 g1;
	Start(MyGame1 g1)
	{
		this.g1=g1;
		init();
	}
	public void init()
	{
		batch = new SpriteBatch();
		img = new Texture(Gdx.files.internal("assets/cover.png"));
		font=new BitmapFont();
		font.setScale(1);
		
		
	}
	public void render(float delta) {
		// TODO Auto-generated method stub
		 if (Gdx.input.justTouched()) // use your own criterion here
             g1.setScreen(g1.s);

		batch.begin();
		batch.draw(img,0,0);
		font.draw(batch, "press up and down arrow keys to move archer and space to shoot arrows",0, 20);
		
		batch.end();
		
	
	}
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	

}
