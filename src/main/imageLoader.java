package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class imageLoader {
	public static BufferedImage[][][] Textures = new BufferedImage[128][16][32];
	public static BufferedImage[] DestroyStage = new BufferedImage[10];
	public static BufferedImage skin,sky,mb,gui, sel, inv, crafting;

	public static void loadTextures() 
	{		
		saveTexture(1,0, "stone");
		saveTexture(2,0,"grass_side");
		saveTexture(3,0, "dirt");
		saveTexture(4,0, "cobblestone");
		saveTexture(5,0,"planks_oak");
		saveTexture(7,0, "bedrock");
		saveTexture(8,0, "coal_ore");
		saveTexture(9,0,"iron_ore");
		saveTexture(10,0,"diamond_ore");
		saveTexture(11,0,"redstone_ore");
		saveTexture(12,0,"lapis_ore");
		saveTexture(13,0,"emerald_ore");
		saveTexture(14,0,"flower_rose");
		saveTexture(14,1,"flower_tulip_orange");
		saveTexture(14,2,"flower_paeonia");
		saveTexture(15,0,"tallgrass");
		saveTexture(16,0,"log_oak");
		saveTexture(17,0,"leaves_big_oak");
		saveTexture(18,0,"crafting_table_side");
		saveTexture(19,0,"sapling_oak");
		saveTexture(100,0,"stick");
		saveTexture(101,0,"wood_pickaxe");
		saveTexture(102,0,"wood_shovel");
		saveTexture(103,0,"wood_sword");
		saveTexture(104,0,"wood_hoe");
		saveTexture(105,0,"wood_axe");
		saveTexture(106,0,"stone_pickaxe");
		saveTexture(107,0,"stone_shovel");
		saveTexture(108,0,"stone_sword");
		saveTexture(109,0,"stone_hoe");
		saveTexture(110,0,"stone_axe");
		DestroyStage[0]=getImage("destroy_stage_0");
		DestroyStage[1]=getImage("destroy_stage_1");
		DestroyStage[2]=getImage("destroy_stage_2");
		DestroyStage[3]=getImage("destroy_stage_3");
		DestroyStage[4]=getImage("destroy_stage_4");
		DestroyStage[5]=getImage("destroy_stage_5");
		DestroyStage[6]=getImage("destroy_stage_6");
		DestroyStage[7]=getImage("destroy_stage_7");
		DestroyStage[8]=getImage("destroy_stage_8");
		DestroyStage[9]=getImage("destroy_stage_9");
		skin=getImage("skin");	
		sky=getImage("sky");
		mb=getImage("mb");
		gui=getImage("gui");
		sel=getImage("selected");
		inv=getImage("inventory");
		crafting=getImage("crafting");
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
		if(id==17||id==15&&id2==0)
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
