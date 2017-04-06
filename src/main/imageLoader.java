package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class imageLoader {
	public static BufferedImage[][] Textures = new BufferedImage[32][16];
	public static BufferedImage skin,sky,mb;

	public static void loadTextures() 
	{
		saveTexture(1,"grass_side");
		saveTexture(2, "dirt");
		saveTexture(3, "stone");
		saveTexture(4, "bedrock");
		saveTexture(5, "coal_ore");
		saveTexture(6, "cobblestone");
		saveTexture(7,"iron_ore");
		saveTexture(8,"diamond_ore");
		saveTexture(9,"redstone_ore");
		saveTexture(10,"lapis_ore");
		saveTexture(11,"emerald_ore");
		saveTexture(12,"flower_rose");
		saveTexture(13,"flower_tulip_orange");
		saveTexture(14,"flower_paeonia");
		saveTexture(15,"tallgrass");
		saveTexture(16,"log_oak");
		saveTexture(17,"leaves_big_oak");
		skin=getImage("skin");	
		sky=getImage("sky");
		mb=getImage("mb");
	}
	public static BufferedImage color(BufferedImage i)
	{
		BufferedImage o=new BufferedImage(i.getWidth(), i.getHeight(), BufferedImage.TYPE_INT_ARGB);
		for(int x=0; x<i.getWidth(); x++)
		{
			Color a;
			for(int y=0; y<i.getHeight(); y++)
			{
				Color c= new Color(i.getRGB(x, y));
				int r=5;
				int b=5;
				int g=c.getGreen();
				if(g==0)
				{
					o.setRGB(x, y, 0);
				}else 
				{
				a=new Color(r,g,b);
				o.setRGB(x, y, a.getRGB());
				}
				
			}
		}
		return o;
	}
	public static BufferedImage scale(BufferedImage map, int x, int y)
	{
		BufferedImage scaled= new BufferedImage(x, y, map.getType());
		Graphics g=map.getGraphics();
		g.drawImage(map, 0, 0, x, y, null);
		return scaled;
	}
	private static void saveTexture(int id, String filename)
	{
		Textures[id][0]=getImage(filename);
		
		int x=1;
		boolean go=true;
		while(go)
		{
			if(x>9)
			{
				if(getImage("bdc_"+filename+""+x)!=null)
				{
					Textures[id][x]=getImage("bdc_"+filename+"0"+x);
				}else go=false;
			}else 
			{
				if(getImage("bdc_"+filename+"0"+x)!=null)
				{
					Textures[id][x]=getImage("bdc_"+filename+"0"+x);
				}else go=false;
			}
			x++;
		}
		if(id==17||id==15)
		{
			Textures[id][0]=color(Textures[id][0]);
		}
	}
	private static BufferedImage getImage(String filename) {
		try {
			BufferedImage texture= ImageIO.read(imageLoader.class.getClassLoader().getResourceAsStream("gfx/"+filename+".png"));
//			System.out.println("Succesfully loaded  "+filename+".png");
			return texture;
		} catch (java.lang.IllegalArgumentException | IOException e) 
		{
//			System.out.println("Image "+filename+".png not found, Texture not loaded");
			return null;
		}
	}
	public static BufferedImage[][] getTextures() {
		return Textures;
	}
	public static void setTextures(BufferedImage[][] textures) {
		Textures = textures;
	}
}
