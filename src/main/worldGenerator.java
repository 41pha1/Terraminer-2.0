package main;

import java.util.Random;

public class worldGenerator 
{
	public static void generateTerrain()
	{
		for(int x=0; x<1000; x++)
		{	
			for(int y=0; y<256; y++)
			{
				simulation.blocks[x][y] = new block();
				simulation.blocks[x][y].setX(x);
				simulation.blocks[x][y].setY(y);
				simulation.blocks[x][y].setID(0,0);
				if(y>10) {
					simulation.blocks[x][y].setID(2,0);
				}
				if(y>11) {
					simulation.blocks[x][y].setID(3,0);
				}
				if(y>14) {
					simulation.blocks[x][y].setID(1,0);
				}
				if(y>253) {
					simulation.blocks[x][y].setID(7,0);
				}
			}
		}
	}
	public static void generateOres()
	{
		for(int x=0; x<1000; x++)
		{	
			for(int y=0; y<256; y++)
			{
				if(rnd(y, 10, 80, 120)&&simulation.blocks[x][y].getID()==1)
				{
					simulation.blocks[x][y].setID(8,0);
				}
				if(rnd(y, 3, 40, 160)&&simulation.blocks[x][y].getID()==1)
				{
					simulation.blocks[x][y].setID(9,0);
				}
				if(rnd(y, 1, 30, 200)&&simulation.blocks[x][y].getID()==1)
				{
					simulation.blocks[x][y].setID(11,0);
				}
				if(rnd(y, 0.2, 30, 200)&&simulation.blocks[x][y].getID()==1)
				{
					simulation.blocks[x][y].setID(10,0);
				}
				if(rnd(y, 1, 50, 120)&&simulation.blocks[x][y].getID()==1)
				{
					simulation.blocks[x][y].setID(12,0);
				}
				if(rnd(y, 1, 90, 200)&&simulation.blocks[x][y].getID()==1)
				{
					simulation.blocks[x][y].setID(13,0);
				}
			}
		}
	}
	public static void generateCaves()
	{
		
	}
	public static void generateOverworld()
	{
		generatePlants();
		generateTrees();
	}
	public static void generateTrees()
	{
		for(int x=1; x<255; x++)
		{
			if(rnd(getFirstBlock(x, 1),1,5,getFirstBlock(x, 1)))
			{
				simulation.blocks[x][getFirstBlock(x, 2)-1].setID(16,0);
				simulation.blocks[x][getFirstBlock(x, 2)-2].setID(16,0);
				simulation.blocks[x][getFirstBlock(x, 2)-3].setID(16,0);
				simulation.blocks[x][getFirstBlock(x, 2)-4].setID(17,0);
				simulation.blocks[x+1][getFirstBlock(x, 2)-3].setID(17,0);
				simulation.blocks[x-1][getFirstBlock(x, 2)-3].setID(17,0);
				x++;
			}
		}
	}
	public static void generatePlants()
	{
		for(int x=0; x<255; x++)
		{
			if(rnd(getFirstBlock(x, 1),1,5,getFirstBlock(x, 1)))
			{
				if(simulation.blocks[x][getFirstBlock(x, 2)-1].getID()==0)
				{
					simulation.blocks[x][getFirstBlock(x, 2)-1].setID(14,0);
				}
			}
			if(rnd(getFirstBlock(x, 1),1,5,getFirstBlock(x, 1)))
			{
				if(simulation.blocks[x][getFirstBlock(x, 2)-1].getID()==0)
				{
					simulation.blocks[x][getFirstBlock(x, 2)-1].setID(14,1);
				}
			}
			if(rnd(getFirstBlock(x, 1),1,5,getFirstBlock(x, 1)))
			{
				if(simulation.blocks[x][getFirstBlock(x, 2)-1].getID()==0)
				{
					simulation.blocks[x][getFirstBlock(x, 2)-1].setID(14,2);
				}
			}
			if(rnd(getFirstBlock(x, 1),1,5,getFirstBlock(x, 1)))
			{
				if(simulation.blocks[x][getFirstBlock(x, 2)-1].getID()==0)
				{
					simulation.blocks[x][getFirstBlock(x, 2)-1].setID(15,0);
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
		for(int y=0; y<256; y++)
		{
			if(simulation.blocks[x][y].getID()==id)
			{
				return y;
			}
		}
		return 0;
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
