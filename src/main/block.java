package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class block
{
	int ID=0;
	int ID2=0;
	int Biome=0;
	public int getBiome() {
		return Biome;
	}
	public void setBiome(int biome) {
		Biome = biome;
	}
	double seq=0;
	int destroyed=0;
	double pb=0;
	int destroyTime=0;
	int effectiveTool=0;
	long time=System.nanoTime();
	public long getDestroyTime(int tool)
	{
		if(effectiveTool==1)
		{
			if(tool==item.WOOD_PICKAXE)
			{
				return destroyTime/3;
			}if(tool==item.STONE_PICKAXE)
			{
				return destroyTime/5;
			}
			if(tool==item.IRON_PICKAXE)
			{
				return destroyTime/7;
			}
		}
		if(effectiveTool==2)
		{
			if(tool==item.WOOD_SHOVEL)
			{
				return destroyTime/2;
			}
			if(tool==item.STONE_SHOVEL)
			{
				return destroyTime/3;
			}
			if(tool==item.IRON_SHOVEL)
			{
				return destroyTime/4;
			}
		}
		if(effectiveTool==3)
		{
			if(tool==item.WOOD_AXE)
			{
				return destroyTime/2;
			}
			if(tool==item.STONE_AXE)
			{
				return destroyTime/3;
			}
			if(tool==item.IRON_AXE)
			{
				return destroyTime/4;
			}
		}
		return destroyTime;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public void isRightClicked()
	{
		keyboard.setRbuttonr(false);
		if(ID==item.DOOR)
		{
			if(collision)
			{
				collision=false;
				if(ID2==2)
				{
					simulation.blocks[x][y+1].setCollision(false);
				}else if(ID2==1)
				{
					simulation.blocks[x][y-1].setCollision(false);
				}
			}
			else 
			{
				collision=true;
				if(ID2==2)
				{
					simulation.blocks[x][y+1].setCollision(true);
				}else if(ID2==1)
				{
					simulation.blocks[x][y-1].setCollision(true);
				}
			}
		}
		if(ID==item.CRAFTING_TABLE)
		{
			inventory.open=true;
			inventory.container=1;
			inventory.x=x;
			inventory.y=y;
		}
		if(ID==item.CHEST)
		{
			inventory.open=true;
			inventory.container=3;
			inventory.x=x;
			inventory.y=y;
			for(int i=0; i<27; i++)
			{
				inventory.slots[i+47].setID(simulation.blocks[x][y].getSlotID(i));
				inventory.slots[i+47].setCount(simulation.blocks[x][y].getSlotCount(i));
				inventory.slots[i+47].setID2(simulation.blocks[x][y].getSlotID2(i));
			}
		}
		if(ID==item.FURNACE)
		{
			inventory.open=true;
			inventory.container=2;
			inventory.x=x;
			inventory.y=y;
			inventory.slots[37].setID(simulation.blocks[x][y].getSlotID(0));
			inventory.slots[37].setCount(simulation.blocks[x][y].getSlotCount(0));
			inventory.slots[37].setID2(simulation.blocks[x][y].getSlotID2(0));
			inventory.slots[38].setID(simulation.blocks[x][y].getSlotID(1));
			inventory.slots[38].setCount(simulation.blocks[x][y].getSlotCount(1));
			inventory.slots[38].setID2(simulation.blocks[x][y].getSlotID2(1));
			inventory.slots[46].setID(simulation.blocks[x][y].getSlotID(2));
			inventory.slots[46].setCount(simulation.blocks[x][y].getSlotCount(2));
			inventory.slots[46].setID2(simulation.blocks[x][y].getSlotID2(2));
		}
	}
	public int getDestroyed() {
		return destroyed;
	}
	public void setDestroyed(int destroyed) {
		this.destroyed = destroyed;
	}
	int lg=1;
	int neededBlocks[]=new int[8];
	static int size=15;
	int [] rnd=new int[500];
	boolean mark=false;
	boolean collision=true;
	boolean needsBlock=false;
	boolean background=false;
	public boolean isBackground() {
		return background;
	}
	public void setBackground(boolean background) {
		this.background = background;
	}
	public boolean isCollision() {
		return collision;
	}
	public void setCollision(boolean collision) {
		this.collision = collision;
	}
	int x, y;
	slot[] slots =new slot[27];
    public int getSlotID(int n) 
    {
		return slots[n].getID();
	}
    public int getSlotID2(int n) 
    {
		return slots[n].getID2();
	}
    public int getSlotCount(int n) 
    {
		return slots[n].getCount();
	}
	public void setSlots(int n, int id, int id2, int c) {
		slots[n].setID(id);
		slots[n].setID2(id2);
		slots[n].setCount(c);
	}
	public int getDrop()
	{
		if(ID==2)return 3;
		if(ID==1)return 4;
		if(ID==8)return 111;
		if(ID==10)return 113;
		if(ID==11)return 112;
		if(ID==13)return 114;
		if(ID==12)return 115;
		if(ID==item.DOOR&&ID2==2)return 0;
		if(ID==17)
		{
			if(Math.random()>0.5)return 19;
			return 0;
		}
		return ID;
	}
	public int getDrop2()
	{
		if(ID==12)return 11;
		if(ID==20)return 0;
		if(ID==item.DOOR)return 0;
		return ID2;
	}
	public void update()
	{
		if(ID==item.FURNACE)
		{
			if(0!=crafting.checkCrafting(slots[0].getID(), slots[1].getID(), 0, 0, 0, 0, 0, 0, 0, 2))
			{
				simulation.blocks[x][y].setID2(1);
				simulation.blocks[x][y].setPb(simulation.blocks[x][y].getPb()+0.2);
				if(simulation.blocks[x][y].getPb()>90)
				{
					simulation.blocks[x][y].setPb(0);
					slots[0].setCount(slots[0].getCount()-1);
					slots[2].setID(crafting.checkCrafting(slots[0].getID(), slots[1].getID(), 0, 0, 0, 0, 0, 0, 0, 2));
					slots[2].setCount(slots[2].getCount()+1);
					if(inventory.isOpen()&&inventory.container==2)
					{
						inventory.slots[37].setCount(inventory.slots[37].getCount()-1);
						inventory.slots[46].setID(crafting.checkCrafting(slots[0].getID(), slots[1].getID(), 0, 0, 0, 0, 0, 0, 0, 2));
						inventory.slots[46].setCount(inventory.slots[46].getCount()+1);
					}
				}	
			}
			else 
			{
				simulation.blocks[x][y].setID2(0);
				simulation.blocks[x][y].setPb(0);
			}
		}
		seq+=0.2;
		if(seq>=8)seq=0;
		if(ID==19)
		{
			if(Math.random()>0.9995)
			{
				worldGenerator.generateTree(x,y+1,ID2);
			}
		}
		if(ID==17)
		{
			if(Math.random()>0.9995)
			{
				if(lg==0)simulation.breackBlock(x, y);
			}
		}
		
		
		if(needsBlock)
		{
			if((neededBlocks[0]!=simulation.blocks[x][y+1].getID()))
			{
				if((neededBlocks[1]!=simulation.blocks[x][y+1].getID()))
				{
					if((neededBlocks[2]!=simulation.blocks[x][y+1].getID()))
					{
						simulation.breackBlock(x, y);
					}
				}
			}
		}		
	}
	public double getPb() {
		return pb;
	}
	public void setPb(double pb) {
		this.pb = pb;
	}
	public int getLg() {
		return lg;
	}
	public void setLg(int lg) {
		this.lg = lg;
	}
	public int[] getNeededBlocks() {
		return neededBlocks;
	}
	public void setNeededBlocks(int[] neededBlocks) {
		this.neededBlocks = neededBlocks;
	}
	public void draw(Graphics g)
	{
		double px,py;
		if(player.getPx()>0){
			px=0;
		}
		else px= player.getPx();
		if(player.getPy()<-246){
			py=-246;
		}
		else py= player.getPy();
		if(ID==item.FURNACE&&ID2==1)
		{
			BufferedImage dst = new BufferedImage(64, 64, BufferedImage.TYPE_INT_RGB);    
			dst=imageLoader.getTextures()[ID][rnd[ID]][ID2];
			dst=dst.getSubimage(0, (int)(seq-0.5)*64, 64, 64);
			g.drawImage(dst, (int)((x*frame.getWIDTH()/size)+px*frame.getWIDTH()/size), (int)((y*frame.getWIDTH()/size)+py*frame.getWIDTH()/size), frame.getWIDTH()/size+2, frame.getWIDTH()/size+2,null);
		}else g.drawImage(imageLoader.getTextures()[ID][rnd[ID]][ID2], (int)((x*frame.getWIDTH()/size)+px*frame.getWIDTH()/size), (int)((y*frame.getWIDTH()/size)+py*frame.getWIDTH()/size), frame.getWIDTH()/size+2, frame.getWIDTH()/size+2,null);
		if(destroyed!=0)g.drawImage(imageLoader.DestroyStage[destroyed-1], (int)((x*frame.getWIDTH()/size)+px*frame.getWIDTH()/size), (int)((y*frame.getWIDTH()/size)+py*frame.getWIDTH()/size), frame.getWIDTH()/size+2, frame.getWIDTH()/size+2,null);
		if(mark)g.fillRect((int)((x*frame.getWIDTH()/size)+player.getPx()*frame.getWIDTH()/size), (int)((y*frame.getWIDTH()/size)+player.getPy()*frame.getWIDTH()/size), frame.getWIDTH()/size+2, frame.getWIDTH()/size+2);
	}
	public int getID2() {
		return ID2;
	}
	public void setID2(int iD2) {
		ID2 = iD2;
	}
	public void drawMinimap(Graphics g, int x1, int y1)
	{
		g.setColor(getTextureColor());
//		g.fillRect((x-x1+30)*(minimap.size/(simulation.blocks.length/minimap.zoom)),(y-y1+15)*(minimap.size/(simulation.blocks.length/minimap.zoom)), minimap.size/(simulation.blocks.length/minimap.zoom), minimap.size/(simulation.blocks.length/minimap.zoom));
		g.fillRect(x,y,1,1);
		
	}
	public static int getSize(){
		return size;
	}
	public Color getRandomTextureColor()
	{
		if(ID!=0)
		{
			for(int i=0; i<100; i++)
			{
				Color c;
				if(ID==item.CHEST)
				{
					c=new Color(imageLoader.getTextures()[item.LOG][0][0].getRGB((int)(Math.random()*64), (int)(Math.random()*64)));
				}
				else c = new Color(imageLoader.getTextures()[ID][0][ID2].getRGB((int)(Math.random()*64), (int)(Math.random()*64)));
				if(ID==17)
				{
					
				}
				if(c.getRed()!=0&&c.getBlue()!=0&&c.getGreen()!=0)
				{
					return c;
				}
			}
		}
		return null;
	}
	public Color getTextureColor()
	{
		if(ID!=0)
		{
		Color c = new Color(imageLoader.getTextures()[ID][0][ID2].getRGB(1,1));
		return c;
		}return Color.WHITE;
	}
	public static void setSize(int size) {
		block.size = size;
	}
	public boolean isMark() {
		return mark;
	}
	public void setMark(boolean mark) {
		this.mark = mark;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getID()
	{
		return ID;
	}
	public void setID(int id, int id2)
	{
		needsBlock=false;
		background=false;
		pb=0;
		for(int x=0; x<27; x++)
		{
			if(slots[x]==null)
			slots[x]=new slot(0, 0);
		}
		if(id==item.AIR)
		{
			if(ID==item.DOOR&&ID2==2)
			{
				simulation.breackBlock(x,y+1);
			}
			for(int i=0; i<27; i++)
			{
				inventory.drop(slots[i].getID(), slots[i].getID2(), slots[i].getCount(),x,y);
				slots[i].setID(0);
				slots[i].setCount(0);
			}
		}
		if(id==item.DOOR)
		{
			background=true;
			if(id2==0)
			{
				id2=1;
				simulation.blocks[x][y-1].setID(item.DOOR, 2);
			}
			if(id2==2)
			{
				neededBlocks[0]=item.DOOR;
				neededBlocks[1]=item.DOOR;
				neededBlocks[2]=item.DOOR;
				setNeedsBlock(true);
			}
		}
		
		
		if(id==item.STONE||id==item.COBBLE||id==item.COAL_ORE||id==item.IRON_ORE||id==item.REDSTONE_ORE||id==item.DIAMOND_ORE||id==item.EMERALD_ORE||id==item.LAPIS_ORE||id==item.FURNACE)
		{
			destroyTime=500000000;
			effectiveTool=1;
		}
		if(id==item.GRASS||id==item.DIRT)
		{
			destroyTime=100000000;
			effectiveTool=2;
		}
		if(id==item.FLOWER||id==item.TALLGRASS||id==item.LEAVE)
		{
			destroyTime=0;
			effectiveTool=0;
		}
		if(id==item.LOG||id==item.PLANKS||id==item.CRAFTING_TABLE||id==item.CHEST||id==item.DOOR)
		{
			destroyTime=300000000;
			effectiveTool=3;
		}
		
		
		
		
		if(id==item.AIR&&ID==item.LOG)
		{
			simulation.blocks[x+1][y].setLg(0);
			simulation.blocks[x-1][y].setLg(0);
			simulation.blocks[x][y+1].setLg(0);
			simulation.blocks[x][y-1].setLg(0);
		}
		
		if(id==item.AIR||id==item.SAPLING||id==item.FLOWER||id==item.TALLGRASS||id==item.LOG||id==item.LEAVE||id==item.CRAFTING_TABLE||id==item.FURNACE)
		{
			setCollision(false);
			setBackground(true);
		}else 
		{
			setCollision(true);
		}
		
		
		if((id==item.FLOWER && id2==item.AIR)||id==item.SAPLING||id==item.FLOWER||id==item.TALLGRASS)
		{
			if(Math.random()>0.5)
			{
				setBackground(true);
			}
			neededBlocks[0]=item.GRASS;
			neededBlocks[1]=item.DIRT;
			neededBlocks[2]=item.DIRT;
			setNeedsBlock(true);
			
		}
		if(id==item.LOG)
		{
			neededBlocks[0]=item.GRASS;
			neededBlocks[1]=item.DIRT;
			neededBlocks[2]=item.LOG;
			setNeedsBlock(true);
		}
		ID=id;
		ID2=id2;
		int textures=0;
		for(int x=0; x<16; x++)
		{
			if(imageLoader.getTextures()[ID][x][ID2]!=null)
			{
				textures+=1;
			}
		}
		rnd[ID]=(int)((Math.random()*(textures-1)));
	}
	public boolean isNeedsBlock() {
		return needsBlock;
	}
	public void setNeedsBlock(boolean needsBlock) {
		this.needsBlock = needsBlock;
	}
}
