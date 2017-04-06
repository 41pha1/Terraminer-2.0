package main;

import java.awt.Graphics;

public class player{
	public static double px, py;
	public static int size=15;
	public static double hitboxX=0.5, hitboxY=0.9;

	public static double getPx() {
		return px;
	}

	public static void setPx(double px) {
		player.px = px;
	}

	public static double getPy() {
		return py;
	}

	public static void setPy(double py) {
		player.py = py;
	}
	public static void draw(Graphics g) 
	{
		double x1, y1, w1, h1;
		x1=(-1*player.getPx())+8;
		y1=(-1*player.getPy())+4;
		w1=x1+player.hitboxX;
		h1=y1+player.hitboxY;
		
		if(py<-246&&px>0)
		{
			g.drawImage(imageLoader.skin, (int)(frame.WIDTH/2-hitboxY/2-px*frame.getWIDTH()/size), (int)(frame.HEIGHT/2-hitboxX/2-(246+py)*frame.getWIDTH()/size), (int)(frame.getWIDTH()/(size/hitboxX)), (int)(frame.getWIDTH()/(size/hitboxY)), null);
		}
		else
		if(py<-246)
		{
			g.drawImage(imageLoader.skin, (int)(frame.WIDTH/2-hitboxY/2), (int)(frame.HEIGHT/2-hitboxX/2-(246+py)*frame.getWIDTH()/size), (int)(frame.getWIDTH()/(size/hitboxX)), (int)(frame.getWIDTH()/(size/hitboxY)), null);			}
			else
		if(px>0)
		{
			g.drawImage(imageLoader.skin, (int)(frame.WIDTH/2-hitboxY/2-px*frame.getWIDTH()/size), (int)(frame.HEIGHT/2-hitboxX/2), (int)(frame.getWIDTH()/(size/hitboxX)), (int)(frame.getWIDTH()/(size/hitboxY)), null);
		}
		else 
		g.drawImage(imageLoader.skin, (int)(frame.WIDTH/2-hitboxY/2), (int)(frame.HEIGHT/2-hitboxX/2), (int)(frame.getWIDTH()/(size/hitboxX)), (int)(frame.getWIDTH()/(size/hitboxY)), null);
	}
}
