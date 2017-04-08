package main;

import java.awt.Color;
import java.awt.Graphics;

public class block
{
	int ID=0;
	int ID2=0;
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
	public void update()
	{
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
		if(mark)g.fillRect((int)((x*frame.getWIDTH()/size)+player.getPx()*frame.getWIDTH()/size), (int)((y*frame.getWIDTH()/size)+player.getPy()*frame.getWIDTH()/size), frame.getWIDTH()/size+2, frame.getWIDTH()/size+2);
	}
	public int getID2() {
		return ID2;
	}
	public void setID2(int iD2) {
		ID2 = iD2;
	}
	public void drawMinimap(Graphics g)
	{
		g.setColor(getTextureColor());
		g.fillRect(x*(minimap.size/(simulation.blocks.length/minimap.zoom)),y*(minimap.size/(simulation.blocks.length/minimap.zoom)), minimap.size/(simulation.blocks.length/minimap.zoom), minimap.size/(simulation.blocks.length/minimap.zoom));
	}
	
	public static int getSize() {
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
			System.out.println(ID+", "+ID2);
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
		if(id==0&&ID==16)
		{
			simulation.blocks[x+1][y].setLg(0);
			simulation.blocks[x-1][y].setLg(0);
			simulation.blocks[x][y+1].setLg(0);
			simulation.blocks[x][y-1].setLg(0);
		}
		
		if(id==0||(id==38 && id2==0)||(id==38 && id2==5)||(id==31&&id2==1)||(id==175&&id2==5)||id==17||id==18)
		{
			setCollision(false);
		}else 
		{
			setCollision(true);
			setBackground(false);
		}
		
		
		if((id==38 && id2==0)||(id==38 && id2==5)||(id==31&&id2==1)||(id==175&&id2==5))
		{
			if(Math.random()>0.5)
			{
				setBackground(true);
			}else 
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
			setBackground(false);
		}if(id==17||id==18)
		{
			setBackground(true);
		}if(id==17)
		{
			neededBlocks[0]=2;
			neededBlocks[1]=3;
			neededBlocks[2]=17;
			setNeedsBlock(true);
		}
		ID=id;
		ID2=id2;
		int textures=0;
		for(int x=0; x<16; x++)
		{
			System.out.println(ID+", "+ID2);
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
