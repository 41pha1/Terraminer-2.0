package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class minimap 
{
	public static BufferedImage map;
	public static int zoom=16;
	public final static int size=1000;
	public minimap()
	{
		map=new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
	}
	public static void draw(Graphics g, int x, int y)
	{
		g.drawImage(map, x/14, y/14, x, y, null);
		g.drawImage(imageLoader.mb, 0, 0, x+x/7, y+y/7, 0, 0, 16, 16, null);
	}
	public static void createMap()
	{
		map=new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
		Graphics g= map.getGraphics();
		
		for(int x=0; x<simulation.blocks.length/zoom; x++)
		{
			for(int y=0; y<simulation.blocks.length/zoom; y++)
			{
				if(y<simulation.blocks[x].length)
				simulation.getBlocks()[x][y].drawMinimap(g);
			}
		}
		
//		map=imageLoader.scale(map, size, size);
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

