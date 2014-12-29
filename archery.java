package com.bow.arrow;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.TimeUtils;
import com.bow.arrow.Enemy1;
import com.bow.arrow.Arrow1;
import com.bow.arrow.EndScreen1;



public class archery implements Screen,InputProcessor {
	SpriteBatch batch,z;	
	BitmapFont k;
    Texture img,arc,balon,arrow;
	Sprite balon1,arrow1,arc1,s1;
	Rectangle arche;
	int x,y,movex,movey;
	ArrayList<Enemy1>bal;
	ArrayList<Arrow1>arr;
	long timer;
	MyGame1 g;
	
	float at;
	EndScreen1 end;
	Start start;
	Sound xyz=Gdx.audio.newSound(Gdx.files.internal("assets/blast.mp3"));
	Music music = Gdx.audio.newMusic(Gdx.files.internal("assets/shubhi.mp3"));
	public archery(MyGame1 g1)
	{
		g=g1;
		init();
	}
	public void init () {
		x=-60;
		y=250;
		movex=0;
		at=0;
		movey=0;
		MyGame1.Score=0;
		music.play();
		music.setLooping(true);
		batch = new SpriteBatch();
		z = new SpriteBatch();
		img = new Texture(Gdx.files.internal("assets/dik.jpg"));
		balon = new Texture(Gdx.files.internal("assets/skull1.png"));
		arrow = new Texture(Gdx.files.internal("assets/abc.png"));
		arc = new Texture(Gdx.files.internal("assets/ar2.png"));
		balon1=new Sprite(balon);
		arrow1= new Sprite(arrow);
		arche= new Rectangle(x,y,64,64);
		arc1= new Sprite(arc);
		arc1.setPosition(x, y);
		k=new BitmapFont();
		k.setColor(Color.CYAN);
		k.setScale(2);		
		bal=new ArrayList<Enemy1>();
		arr=new ArrayList<Arrow1>();		
		timer=TimeUtils.nanoTime();	
			
		end=new EndScreen1(g);
		start=new Start(g);
		Gdx.input.setInputProcessor(this);
		
	
		}
	
	 public void render (float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);	
		at+=Gdx.graphics.getDeltaTime();
			
		if(movey==1)
		{
			y+=5;
			arche.y+=5;
		}
		else if(movey==-1)
		{
			y-=5;
			arche.y-=5;
		}
		if(y<-30)
			y=-30;
		else if(y>290)
			y=290;
		arc1.setPosition(x, y);		
		for(Enemy1 a:bal)
		{
			if(a.r.y<-40)
			{
				music.stop();
				g.setScreen(end);
			}
		}
		batch.begin();			
		batch.draw(img, 0, 0);
		arc1.draw(batch);	
		k.draw(batch, "Score:"+MyGame1.Score,5, 480);
			
		for(Arrow1 b:arr)
		{
			arrow1.draw(batch);
			b.x+=5;
			b.r.x+=5;
			arrow1.setPosition(b.x,b.y);
			if(b.x>800)
				b.remove=true;
			arrow1.setPosition(b.x,b.y);
			
		}
		for(Enemy1 e:bal)
		{
			balon1.draw(batch);
			e.y-=2;
			e.r.y-=2;
			balon1.setPosition(e.x,e.y);
			
		}
		batch.end();
		
	for(int i=0;i<arr.size();i++)
				{
					Arrow1 b=arr.get(i);
					if(b.remove)
					{
						arr.remove(i);
					}
					
				}
	for(int i=0;i<bal.size();i++)
	{
		Enemy1 e=bal.get(i);
		if(e.remove)
		{
			xyz.play(5.05f);
			
			bal.remove(i);
		}
			
	}
				if(TimeUtils.timeSinceNanos(timer)>2000000000)
				{
					spawnEnemy();
					timer=TimeUtils.nanoTime();
				}

				for(Enemy1 e:bal)
				{
					for(Arrow1 b:arr)
					{
						if(b.r.overlaps(e.r))
						{
							e.remove=true;
							b.remove=true;
						g.Score++;
						}
					}
				}
	}
	 void spawnArrow()
		{
			Arrow1 b=new Arrow1(x+250,y+125);
			arr.add(b);
		}
	void spawnEnemy()
	{
		float y=510;
		float x=MathUtils.random(10,30)*20;
		balon1.setPosition(x,y);
		Enemy1 e=new Enemy1(x,y);
		bal.add(e);
	}
	@Override
	public boolean keyDown(int keycode) {	
		
		if(keycode==Input.Keys.UP)	
			movey=1;				
		else if(keycode==Input.Keys.DOWN)		
			movey=-1;		
		if(keycode==Input.Keys.SPACE)
			spawnArrow();
			return false;
			}
	@Override
	public void resize(int width, int height) {
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



	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		if((keycode==Input.Keys.UP)||(keycode==Input.Keys.DOWN))
			movey=0;
			
		return false;
	}


	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	



	
}
