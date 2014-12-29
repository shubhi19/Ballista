package com.bow.arrow;


import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EndScreen1 implements Screen
{
MyGame1 g;
BitmapFont font;
SpriteBatch batch;
EndScreen1(MyGame1 g)
{
	this.g=g;
	init();
}
public void init()
{	 batch=new SpriteBatch();
		font=new BitmapFont();
		font.setColor(Color.PINK);
		font.setScale(3);
}
@Override
public void render(float delta) {
	// TODO Auto-generated method stub
	batch.begin();
	font.draw(batch,"Game Over",300,350);
	font.draw(batch, "your score :"+MyGame1.Score, 300, 300);
	
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