package com.bow.arrow;

import com.badlogic.gdx.math.Rectangle;

public class Arrow1 {
		float x,y;
		boolean remove;
		Rectangle r;
		public Arrow1(float a,float b)
		{
			x=a;
			y=b;
			remove=false;
			r=new Rectangle(a,b,64,64);
				}	
}
