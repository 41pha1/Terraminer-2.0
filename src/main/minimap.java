package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class minimap 
{
	public static BufferedImage map;
	public static int zoom=16;
	public static float[][] noise;
	public final static int size=400;
	public minimap()
	{
		map=new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
	}
	public static void draw(Graphics g, int x, int y)
	{
		g.drawImage(map, x/14, y/14, x, y, null);
		g.drawImage(imageLoader.mb, 0, 0, x+x/7, y+y/7, 0, 0, 16, 16, null);
	}
	public static Color getColor(float val)
	{
		return(new Color((int)((val+1)*100),(int)((val+1)*100),(int)((val+1)*100)));
	}
	public static void createMap()
	{
		map=new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
		Graphics g= map.getGraphics();
		noise=simplexNoise.generateNoise(400, 1);
		
		for(int x=0; x<400; x++)
		{
			for(int y=0; y<1; y++)
			{
				g.setColor(getColor(noise[x][y]));
				g.fillRect(x, y, 1, 400);
			}
		}
//		int x1=simulation.DisplayXtoBlockX(frame.getWIDTH()/2)-30, 
//				x2=simulation.DisplayXtoBlockX(frame.getWIDTH()/2)+30, 
//					
//				y1=simulation.DisplayYtoBlockY(frame.getWIDTH()/2)-30, 
//				y2=simulation.DisplayYtoBlockY(frame.getWIDTH()/2)+30;
//				
//				
//				if(x1<0)x1=0;
//				if(x2>255)x2=255;
//				if(y1<0)y1=0;
//				if(y2>255)y2=255;
//				
//				for(int x=0; x<x2; x++)
//				{
//					for(int y=0; y<y2; y++)
//					{
//						if(y<simulation.blocks[x].length)
//						simulation.getBlocks()[x][y].drawMinimap(g, x1, y1);
//					}
//				}
	}
	public static int getZoom() {
		return zoom;
	}
	public static void setZoom(double d) {
		zoom= (int) d;
	}
	public static BufferedImage getMap() {
		return map;
	}
	public static void setMap(BufferedImage map) {
		minimap.map = map;
	}
}

