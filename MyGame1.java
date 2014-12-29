package com.bow.arrow;

import com.badlogic.gdx.Game;

public class MyGame1 extends Game {
	archery s;
	Start p;
	static int Score;
	@Override
	public void create() {
		// TODO Auto-generated method stub
		p=new Start(this);
		s=new archery(this);
		setScreen(p);
		
	}
	
	
	

}
