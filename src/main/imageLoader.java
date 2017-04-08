package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class imageLoader {
	public static BufferedImage[][][] Textures = new BufferedImage[500][16][32];
	public static BufferedImage skin,sky,mb,gui, sel, inv;

	public static void loadTextures() 
	{
		saveTexture(2,0,"grass_side");
		saveTexture(3,0, "dirt");
		saveTexture(1,0, "stone");
		saveTexture(7,0, "bedrock");
		saveTexture(16,0, "coal_ore");
		saveTexture(4,0, "cobblestone");
		saveTexture(15,0,"iron_ore");
		saveTexture(56,0,"diamond_ore");
		saveTexture(73,0,"redstone_ore");
		saveTexture(21,0,"lapis_ore");
		saveTexture(129,0,"emerald_ore");
		saveTexture(38,0,"flower_rose");
		saveTexture(38,5,"flower_tulip_orange");
		saveTexture(175,5,"flower_paeonia");
		saveTexture(31,1,"tallgrass");
		saveTexture(17,0,"log_oak");
		saveTexture(18,0,"leaves_big_oak");
		saveTexture(5,0,"planks_oak");
		saveTexture(58,0,"crafting_table_side");
		saveTexture(280,0,"stick");
		skin=getImage("skin");	
		sky=getImage("sky");
		mb=getImage("mb");
		gui=getImage("gui");
		sel=getImage("selected");
		inv=getImage("inventory");
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
	private static void saveTexture(int id, int id2, String filename)
	{
		Textures[id][0][id2]=getImage(filename);
		
		int x=1;
		boolean go=true;
		while(go)
		{
			if(x>9)
			{
				if(getImage("bdc_"+filename+""+x)!=null)
				{
					Textures[id][x][id2]=getImage("bdc_"+filename+"0"+x);
				}else go=false;
			}else 
			{
				if(getImage("bdc_"+filename+"0"+x)!=null)
				{
					Textures[id][x][id2]=getImage("bdc_"+filename+"0"+x);
				}else go=false;
			}
			x++;
		}
		if(id==18||id==31&&id2==1)
		{
			Textures[id][0][id2]=color(Textures[id][0][id2]);
		}
	}
	private static BufferedImage getImage(String filename) {
		try 
		{
			BufferedImage texture= ImageIO.read(imageLoader.class.getClassLoader().getResourceAsStream("gfx/"+filename+".png"));
			return texture;
		} catch (java.lang.IllegalArgumentException | IOException e) 
		{
			return null;
		}
	}
	public static BufferedImage[][][] getTextures() {
		return Textures;
	}
	public static void setTextures(BufferedImage[][][] textures) {
		Textures = textures;
	}
}
