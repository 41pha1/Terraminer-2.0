package main;

import java.awt.Graphics;


public class item 
{
	int ID;
	double xpos,ypos;
	double floating=-0.1;
	double velocityX, velocityY, velocityF=0.01;
	double accelarationX, accelarationY, accelarationF=0.001;
	double lastposX, lastposY;
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
	public void drop(int id, double xpos, double ypos) 
	{
		this.ID=id;
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
		
		g.drawImage(imageLoader.getTextures()[ID][0], (int)((xpos*frame.getWIDTH()/block.size)+px*frame.getWIDTH()/block.size), (int)((ypos*frame.getWIDTH()/block.size)+floating*frame.getWIDTH()/block.size+py*frame.getWIDTH()/block.size), frame.getWIDTH()/(block.size*4), frame.getWIDTH()/(block.size*4),null);
	}
	public boolean checkCollision(double lx, double ly)
	{
		for(int x=(int) (xpos-2); x<(int) (xpos+2); x++)
		{
			for(int y=(int) (ypos-2); y<(int) (ypos+2); y++)
			{
				if(x<0||x>255)
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
		if(-1*player.getPx()+6.5<xpos&&-1*player.getPx()+8.5>xpos)
		{
			if(-1*player.getPy()+3<ypos&&-1*player.getPy()+5>ypos)
			{
				if(inventory.getFirstSlot(ID)!=inventory.FULL)
				{
					inventory.collectItem(ID);
					alive=false;
				}
			}
		}
	}
	public void update()
	{
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
}
