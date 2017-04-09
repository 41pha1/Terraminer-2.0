package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class imageLoader {
	public static BufferedImage[][][] Textures = new BufferedImage[128][16][32];
	public static BufferedImage[] DestroyStage = new BufferedImage[10];
	public static BufferedImage skin,sky,mb,gui, sel, inv, crafting, oven, pb;

	public static void loadTextures() 
	{		
		saveTexture(item.STONE,0, "stone");
		saveTexture(item.GRASS,0,"grass_side");
		saveTexture(item.DIRT,0, "dirt");
		saveTexture(item.COBBLE,0, "cobblestone");
		saveTexture(item.PLANKS,0,"planks_oak");
		saveTexture(item.PLANKS,1,"planks_spruce");
		saveTexture(item.PLANKS,2,"planks_birch");
		saveTexture(item.BEDROCK,0, "bedrock");
		saveTexture(item.COAL_ORE,0, "coal_ore");
		saveTexture(item.IRON_ORE,0,"iron_ore");
		saveTexture(item.DIAMOND_ORE,0,"diamond_ore");
		saveTexture(item.REDSTONE_ORE,0,"redstone_ore");
		saveTexture(item.LAPIS_ORE,0,"lapis_ore");
		saveTexture(item.EMERALD_ORE,0,"emerald_ore");
		saveTexture(item.FLOWER,0,"flower_rose");
		saveTexture(item.FLOWER,1,"flower_tulip_orange");
		saveTexture(item.FLOWER,2,"flower_paeonia");
		saveTexture(item.TALLGRASS,0,"tallgrass");
		saveTexture(item.LOG,0,"log_oak");
		saveTexture(item.LOG,1,"log_spruce");
		saveTexture(item.LOG,2,"log_birch");
		saveTexture(item.LEAVE,0,"leaves_big_oak");
		saveTexture(item.LEAVE,1,"leaves_spruce");
		saveTexture(item.LEAVE,2,"leaves_birch");
		saveTexture(item.CRAFTING_TABLE,0,"crafting_table_side");
		saveTexture(item.SAPLING,0,"sapling_oak");
		saveTexture(item.SAPLING,1,"sapling_spruce");
		saveTexture(item.SAPLING,2,"sapling_birch");
		saveTexture(item.FURNACE,0,"furnace_front_off");
		saveTexture(item.FURNACE,1,"furnace_front_on");
		saveTexture(item.CHEST,0,"chest");
		saveTexture(item.STICK,0,"stick");
		saveTexture(item.WOOD_PICKAXE,0,"wood_pickaxe");
		saveTexture(item.WOOD_SHOVEL,0,"wood_shovel");
		saveTexture(item.WOOD_SWORD,0,"wood_sword");
		saveTexture(item.WOOD_HOE,0,"wood_hoe");
		saveTexture(item.WOOD_AXE,0,"wood_axe");
		saveTexture(item.STONE_PICKAXE,0,"stone_pickaxe");
		saveTexture(item.STONE_SHOVEL,0,"stone_shovel");
		saveTexture(item.STONE_SWORD,0,"stone_sword");
		saveTexture(item.STONE_HOE,0,"stone_hoe");
		saveTexture(item.STONE_HOE,0,"stone_axe");
		saveTexture(item.COAL,0,"coal");
		saveTexture(item.REDSTONE,0,"redstone_dust");
		saveTexture(item.DIAMOND,0,"diamond");
		saveTexture(item.EMERALD,0,"emerald");
		saveTexture(item.DYE,11,"dye_powder_blue");
		saveTexture(item.IRON,0,"iron_ingot");
		saveTexture(item.IRON_PICKAXE,0,"iron_pickaxe");
		saveTexture(item.IRON_SHOVEL,0,"iron_shovel");
		saveTexture(item.IRON_SWORD,0,"iron_sword");
		saveTexture(item.IRON_HOE,0,"iron_hoe");
		saveTexture(item.IRON_AXE,0,"iron_axe");
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
		oven=getImage("furnace");
		pb=getImage("pb");
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
			System.out.println("Failed to load "+filename+".png");
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
