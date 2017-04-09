package main;

import java.awt.Color;
import java.awt.Graphics;

public class block
{
    int ID=0;
	int ID2=0;
	int destroyed=0;
	int destroyTime=0;
	int effectiveTool=0;
	long time=System.nanoTime();
	public long getDestroyTime(int tool)
	{
		if(effectiveTool==1)
		{
			if(tool==101)
			{
				return destroyTime/3;
			}if(tool==106)
			{
				return destroyTime/5;
			}
		}
		if(effectiveTool==2)
		{
			if(tool==102)
			{
				return destroyTime/3;
			}
		}
		if(effectiveTool==3)
		{
			if(tool==105)
			{
				return destroyTime/2;
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
	public int getDrop()
	{
		if(ID==2)return 3;
		if(ID==1)return 4;
		if(ID==8)return 111;
		if(ID==10)return 113;
		if(ID==11)return 112;
		if(ID==13)return 114;
		if(ID==12)return 115;
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
		return ID2;
	}
	public void update()
	{
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
		}else px= player.getPx();
		if(player.getPy()<-246){
			py=-246;
		}else py= player.getPy();
		g.drawImage(imageLoader.getTextures()[ID][rnd[ID]][ID2], (int)((x*frame.getWIDTH()/size)+px*frame.getWIDTH()/size), (int)((y*frame.getWIDTH()/size)+py*frame.getWIDTH()/size), frame.getWIDTH()/size+2, frame.getWIDTH()/size+2,null);
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
		g.fillRect((x-x1+30)*(minimap.size/(simulation.blocks.length/minimap.zoom)),(y-y1+15)*(minimap.size/(simulation.blocks.length/minimap.zoom)), minimap.size/(simulation.blocks.length/minimap.zoom), minimap.size/(simulation.blocks.length/minimap.zoom));
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
				Color c = new Color(imageLoader.getTextures()[ID][0][ID2].getRGB((int)(Math.random()*64), (int)(Math.random()*64)));
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
		if(id==1||id==4||id==8||id==10||id==11||id==12||id==13)
		{
			destroyTime=500000000;
			effectiveTool=1;
		}
		if(id==2||id==3)
		{
			destroyTime=100000000;
			effectiveTool=2;
		}
		if(id==14||id==15)
		{
			destroyTime=0;
			effectiveTool=0;
		}
		if(id==16||id==5||id==18)
		{
			destroyTime=300000000;
			effectiveTool=3;
		}
		
		
		
		
		if(id==0&&ID==16)
		{
			simulation.blocks[x+1][y].setLg(0);
			simulation.blocks[x-1][y].setLg(0);
			simulation.blocks[x][y+1].setLg(0);
			simulation.blocks[x][y-1].setLg(0);
		}
		
		if(id==0||id==19||id==14||id==15||id==16||id==17||id==18||id==20)
		{
			setCollision(false);
			setBackground(true);
		}else 
		{
			setCollision(true);
			setBackground(false);
		}
		
		
		if((id==14 && id2==0)||id==19||(id==14 && id2==1)||(id==14&&id2==2)||(id==15&&id2==0))
		{
			if(Math.random()>0.5)
			{
				setBackground(true);
			}
			else 
			{
				setBackground(false);
			}
			neededBlocks[0]=2;
			neededBlocks[1]=3;
			neededBlocks[2]=3;
			setNeedsBlock(true);
			
		}else
		{
			setNeedsBlock(false);
		}if(id==16||id==17)
		{
			setBackground(true);
		}if(id==16)
		{
			neededBlocks[0]=2;
			neededBlocks[1]=3;
			neededBlocks[2]=16;
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
