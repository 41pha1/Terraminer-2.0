package main;

import java.awt.Graphics;


public class item 
{
	int ID;
	int ID2=0;
	double xpos,ypos;
	double floating=-0.1;
	double velocityX, velocityY, velocityF=0.01;
	double accelarationX, accelarationY, accelarationF=0.001;
	double lastposX, lastposY;
	double cantcollect;
	public static final int AIR=0, STONE=1, GRASS=2, DIRT=3, COBBLE=4, 
		PLANKS=5, BEDROCK=7, COAL_ORE=8, IRON_ORE=9, DIAMOND_ORE=10, REDSTONE_ORE=11, 
		LAPIS_ORE=12, EMERALD_ORE=13, FLOWER=14, TALLGRASS=15, LOG=16, LEAVE=17, 
		CRAFTING_TABLE=18, SAPLING=19, FURNACE=20, CHEST=21, STICK=100, WOOD_PICKAXE=101, 
		WOOD_SHOVEL=102, WOOD_SWORD=103, WOOD_HOE=104, WOOD_AXE=105, STONE_PICKAXE=106, 
		STONE_SHOVEL=107, STONE_SWORD=108, STONE_HOE=109, STONE_AXE=110, COAL=111, REDSTONE=112, 
		DIAMOND=113, EMERALD=114, DYE=115, IRON=116, IRON_PICKAXE=117, IRON_SHOVEL=118, 
		IRON_SWORD=119, IRON_HOE=120, IRON_AXE=121;
	
	public double getCantcollect() {
		return cantcollect;
	}
	public static boolean getBurnable(int id) 
	{
		if(id==COAL||id==LOG||id==PLANKS)return true; 
		return false;
	}
	public void setCantcollect(double cantcollect) {
		this.cantcollect = cantcollect;
	}
	boolean alive=false;

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public double getXpos() {
		return xpos;
	}
	public void setXpos(double xpos) {
		this.xpos = xpos;
	}
	public double getYpos() {
		return ypos;
	}
	public void setYpos(double ypos) {
		this.ypos = ypos;
	}
	public boolean isAlive() {
		return alive;
	}
	public void drop(int id, int id2, double xpos, double ypos) 
	{
		this.ID=id;
		this.ID2=id2;
		this.xpos=xpos;
		this.ypos=ypos;
		lastposX=xpos;
		lastposY=ypos;
		alive=true;
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
		
		g.drawImage(imageLoader.getTextures()[ID][0][ID2], (int)((xpos*frame.getWIDTH()/block.size)+px*frame.getWIDTH()/block.size), (int)((ypos*frame.getWIDTH()/block.size)+floating*frame.getWIDTH()/block.size+py*frame.getWIDTH()/block.size), frame.getWIDTH()/(block.size*4), frame.getWIDTH()/(block.size*4),null);
	}
	public boolean checkCollision(double lx, double ly)
	{
		for(int x=(int) (xpos-2); x<(int) (xpos+2); x++)
		{
			for(int y=(int) (ypos-2); y<(int) (ypos+2); y++)
			{
				if(x<0||x>simulation.mapsize)
				{
					double x1,x2,y1,y2,w1,w2,h1,h2;
					x1=lx;
					y1=ly;
					w1=x1+0.25;
					h1=y1+0.25;
					x2=x;
					y2=y;
					w2=x2+1;
					h2=y2+1;
					
					
					if(((x2<=x1 && x1<=w2) || (x2<=w1 && w1<=w2)) && ((y2<=y1 && y1<=h2) || (y2<=h1 && h1<=h2)))
					{
						return true;
					}
				}
				else
				{
					if(simulation.blocks[x][y].isCollision())
					{	
						double x1,x2,y1,y2,w1,w2,h1,h2;
						x1=lx;
						y1=ly;
						w1=x1+0.25;
						h1=y1+0.25;
						x2=x;
						y2=y;
						w2=x2+1;
						h2=y2+1;
				
						if(((x2<=x1 && x1<=w2) || (x2<=w1 && w1<=w2)) && ((y2<=y1 && y1<=h2) || (y2<=h1 && h1<=h2)))
						{
							return true;
						}
					}
				}
			}
		}return false;
	}
	public void updateCollision()
	{
		if(!checkCollision(xpos,ypos))
		{
			lastposX=xpos;
			lastposY=ypos;
		}
		else
		{
			if(!checkCollision(lastposX, ypos))
			{
				xpos=lastposX;
				lastposX=xpos;
				lastposY=ypos;
			}
			else if(!checkCollision(xpos, lastposY))
			{
				ypos=lastposY;
				lastposX=xpos;
				lastposY=ypos;
			}
			else 
			{
				xpos=lastposX;
				ypos=lastposY;
				lastposX=xpos;
				lastposY=ypos;	
			}
		}
	}
	public void updateCollect()
	{
		if(cantcollect==0)
		{
			if(-1*player.getPx()+6.5<xpos&&-1*player.getPx()+8.5>xpos)
			{
				if(-1*player.getPy()+3<ypos&&-1*player.getPy()+5>ypos)
				{
					if(inventory.getFirstSlot(ID, ID2)!=inventory.FULL)
					{
						inventory.collectItem(ID, ID2);
						alive=false;
					}
				}
			}
		}
	}
	public void update()
	{
		if(ID==0)alive=false;
		if(cantcollect>0)cantcollect--;
		floating+=velocityF;
		ypos+=velocityY;
		xpos+=velocityX;
		velocityY/=accelarationY;
		velocityX/=accelarationX;
		velocityF-=accelarationF;
		if(velocityF<-0.01)accelarationF=-1*accelarationF;
		if(velocityF>0.01)accelarationF=-1*accelarationF;
		updateCollision();
		updateCollect();
		ypos+=simulation.speed;
		if(ypos>255)alive=false;
	}
	public double getVelocityX() {
		return velocityX;
	}
	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}
	public double getVelocityY() {
		return velocityY;
	}
	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}
	public double getAccelarationX() {
		return accelarationX;
	}
	public void setAccelarationX(double accelarationX) {
		this.accelarationX = accelarationX;
	}
	public double getAccelarationY() {
		return accelarationY;
	}
	public void setAccelarationY(double accelarationY) {
		this.accelarationY = accelarationY;
	}
	public int getID2() {
		return ID2;
	}
	public void setID2(int iD2) {
		ID2 = iD2;
	}
}
