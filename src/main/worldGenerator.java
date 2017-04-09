package main;

import java.util.Random;

public class worldGenerator 
{
	public static float[][]noise1;
	public static float[][]noise;
	
	public static void generateTerrain()
	{
		noise1=simplexNoise.generateNoise(256,5,0.5f);
		for(int x=0; x<256; x++)
		{	
			for(int y=0; y<256; y++)
			{
				simulation.blocks[x][y] = new block();
				simulation.blocks[x][y].setX(x);
				simulation.blocks[x][y].setY(y);
				simulation.blocks[x][y].setID(item.AIR,0);
				
				if(y>(int)((noise1[x][0]+1)*10)+50) {
					simulation.blocks[x][y].setID(item.GRASS,0);
				}
				if(y>(int)((noise1[x][0]+1)*10)+51) {
					simulation.blocks[x][y].setID(item.DIRT,0);
				}
				if(y>(int)((noise1[x][4]+1)*10)+54) {
					simulation.blocks[x][y].setID(item.STONE,0);
				}
				if(y>253) {
					simulation.blocks[x][y].setID(item.BEDROCK,0);
				}
			}
		}
	}
	public static void generateOres()
	{
		for(int x=0; x<256; x++)
		{	
			for(int y=0; y<256; y++)
			{
				if(rnd(y, 10, 80, 120)&&simulation.blocks[x][y].getID()==item.STONE)
				{
					simulation.blocks[x][y].setID(item.COAL_ORE,0);
				}
				if(rnd(y, 3, 40, 160)&&simulation.blocks[x][y].getID()==item.STONE)
				{
					simulation.blocks[x][y].setID(item.IRON_ORE,0);
				}
				if(rnd(y, 1, 30, 200)&&simulation.blocks[x][y].getID()==item.STONE)
				{
					simulation.blocks[x][y].setID(item.REDSTONE_ORE,0);
				}
				if(rnd(y, 0.2, 30, 200)&&simulation.blocks[x][y].getID()==item.STONE)
				{
					simulation.blocks[x][y].setID(item.DIAMOND_ORE,0);
				}
				if(rnd(y, 1, 50, 120)&&simulation.blocks[x][y].getID()==item.STONE)
				{
					simulation.blocks[x][y].setID(item.LAPIS_ORE,0);
				}
				if(rnd(y, 1, 90, 200)&&simulation.blocks[x][y].getID()==item.STONE)
				{
					simulation.blocks[x][y].setID(item.LAPIS_ORE,0);
				}
			}
		}
	}
	public static void generateCaves()
	{
		noise=simplexNoise.generateNoise(256,1,0.5f);
		for(int x=0; x<256; x++)
		{
			simulation.blocks[x][(int)((noise[x][0]+1)*50)+50].setID(item.AIR,0);
			simulation.blocks[x][(int)((noise[x][0]+1)*50)+51].setID(item.AIR,0);
			simulation.blocks[x][(int)((noise[x][0]+1)*50)+52].setID(item.AIR,0);
			simulation.blocks[x][(int)((noise[x][0]+1)*50)+53].setID(item.AIR,0);
		}
	}
	public static void generateOverworld()
	{
		generateTrees();
		generatePlants();
	}
	public static void generateTrees()
	{
		for(int x=1; x<255; x++)
		{
			if(rnd(getFirstBlock(x, item.AIR),2,5,getFirstBlock(x, item.AIR)))
			{
				generateTree(x, getFirstBlock(x, 2), (int)((Math.random()*3)));
				x++;
			}
		}
	}
	public static void generateTree(int x, int y, int id2)
	{
		simulation.blocks[x][y-1].setID(item.LOG,id2);
		simulation.blocks[x][y-2].setID(item.LOG,id2);
		simulation.blocks[x][y-3].setID(item.LOG,id2);
		simulation.blocks[x][y-4].setID(item.LEAVE,id2);
		simulation.blocks[x+1][y-3].setID(item.LEAVE,id2);
		simulation.blocks[x-1][y-3].setID(item.LEAVE,id2);
	}
	public static void generatePlants()
	{
		for(int x=0; x<255; x++)
		{
			if(rnd(getFirstBlock(x, item.AIR),1,5,getFirstBlock(x, item.AIR)))
			{
				if(simulation.blocks[x][getFirstBlock(x, item.AIR)].getID()==item.GRASS||simulation.blocks[x][getFirstBlock(x, item.AIR)].getID()==item.DIRT)
				{
					simulation.blocks[x][getFirstBlock(x, item.AIR)-1].setID(item.FLOWER,0);
				}
			}
			if(rnd(getFirstBlock(x, item.AIR),1,5,getFirstBlock(x, item.AIR)))
			{
				if(simulation.blocks[x][getFirstBlock(x, item.AIR)].getID()==item.GRASS||simulation.blocks[x][getFirstBlock(x, item.AIR)].getID()==item.DIRT)
				{
					simulation.blocks[x][getFirstBlock(x, item.AIR)-1].setID(item.FLOWER,1);
				}
			}
			if(rnd(getFirstBlock(x, item.AIR),1,5,getFirstBlock(x, item.AIR)))
			{
				if(simulation.blocks[x][getFirstBlock(x, item.AIR)].getID()==item.GRASS||simulation.blocks[x][getFirstBlock(x, item.AIR)].getID()==item.DIRT)
				{
					simulation.blocks[x][getFirstBlock(x, item.AIR)-1].setID(item.FLOWER,2);
				}
			}
			if(rnd(getFirstBlock(x, item.AIR),1,5,getFirstBlock(x, item.AIR)))
			{
				if(simulation.blocks[x][getFirstBlock(x, item.AIR)].getID()==item.GRASS||simulation.blocks[x][getFirstBlock(x, item.AIR)].getID()==item.DIRT)
				{
					simulation.blocks[x][getFirstBlock(x, item.AIR)-1].setID(item.TALLGRASS,0);
				}
			}
		}
	}
	public static void generateWorld()
	{
		generateTerrain();
		generateOverworld();
		generateOres();
		generateCaves();
		
	}
	public static int getFirstBlock(int x, int id)
	{	
		if(id==item.AIR)
		{
			for(int y=0; y<256; y++)
			{
				if(simulation.blocks[x][y].getID()!=item.AIR)
				{
					return y;
				}
			}
		}
		for(int y=0; y<256; y++)
		{
			if(simulation.blocks[x][y].getID()==id)
			{
				return y;
			}
		}
		return 1;
	}
	public static boolean rnd(int y, double n, int s, int py)
	{
		boolean match=false;
		for(int x=0; x<n; x++)
		{
			Random r=new Random();
			if(n<1)
			{
				if((int)(r.nextGaussian()*s*(1/n)+py*(1/n))==(int)(y*(1/n)))
				{
					match=true;
				}
			}else 
			{
				if((int)(r.nextGaussian()*s+py)==y)
					match=true;
			}	
		}return match;
	}
}
