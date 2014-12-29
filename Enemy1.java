package com.bow.arrow;

import com.badlogic.gdx.math.Rectangle;

public class Enemy1 {
	float x,y;
	boolean remove;
	Rectangle r;
	public Enemy1(float a,float b)
	{
		x=a;
		y=b;
				remove=false;
				r=new  Rectangle(a,b,140,166);
	}

}
