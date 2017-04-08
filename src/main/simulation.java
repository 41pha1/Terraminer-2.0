package main;

import java.awt.Graphics;
import java.io.DataInputStream;

import javax.swing.JOptionPane;

public class simulation {
	static block[][] blocks = new block[1000][256];
	static byte[] b=new byte[1000*256];
	static byte[] b2=new byte[1000*256];
	static particel[] particels = new particel[100000];
	static item[] items = new item[1000];
	minimap m= new minimap();
	static inventory i=new inventory();
	boolean collide;
	boolean load=false;
	static double lastposX=0;
	static double lastposY=-6;
	private static int mu=0;
	private static int particleType=8;
	private static int particleNumber=100;
	static double acceleration=0.005;
	static double velocity;
	boolean la=false,ls=false,lw=false,ld=false;
	static double speed = 0.12;
	simulation() {
		int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Load your Previous World?");
		if(dialogResult == JOptionPane.YES_OPTION)
		{
			load=true;
		}
		if(dialogResult == JOptionPane.CANCEL_OPTION)
		{
			System.exit(0);
		}
		imageLoader.loadTextures();
		player.setPy(-5);
		player.setPx(0);
		
		for(int i=0; i<100000; i++)
		{
		particels[i] = new particel();
		}
		for(int i=0; i<1000; i++)
		{
			items[i] = new item();
			items[i].setAlive(false);
		}
		
		if(load)
		{
			for(int x=0; x<1000; x++)
			{
				for(int y=0; y<256; y++)
				{
					blocks[x][y]=new block();
					blocks[x][y].setX(x);
					blocks[x][y].setY(y);
					blocks[x][y].setID(0,0);
				}
			}
			
			load();
			
			for(int x=0; x<333; x++)
			{
				for(int y=0; y<75; y++)
				{
//					blocks[x][y].setID(b[x*3 * 75 +y*3]);
//					blocks[x][y].setID(b[x*y]);
					blocks[x][y].setID(b[x * 256 +y],b2[x * 256 +y]);
				}
			}
		}else worldGenerator.generateWorld();
		
		minimap.createMap();
		
	}
	public void load()
	  {
     try
    {
    	DataInputStream dis = new DataInputStream(new java.util.zip.GZIPInputStream(new java.io.FileInputStream(new java.io.File("level.dat"))));
   		dis.readFully(b);
   		DataInputStream dis2 = new DataInputStream(new java.util.zip.GZIPInputStream(new java.io.FileInputStream(new java.io.File("level2.dat"))));
   		dis2.readFully(b2);
   		dis.close();
   		dis2.close();
    }
     catch (Exception e)
   {
       e.printStackTrace();
		}
   }
	public static void save()
	  {
	   try    
	   {
	      java.io.DataOutputStream dos = new java.io.DataOutputStream(new java.util.zip.GZIPOutputStream(new java.io.FileOutputStream(new java.io.File("level.dat"))));
	       dos.write(b);
	       java.io.DataOutputStream dos2 = new java.io.DataOutputStream(new java.util.zip.GZIPOutputStream(new java.io.FileOutputStream(new java.io.File("level2.dat"))));
	       dos2.write(b2);
	      dos.close();
	      dos2.close();
	     }
	    catch (Exception e)
	   {
	      e.printStackTrace();
	    }
	 }
	public static int DisplayXtoBlockX(float X)
	{
		double px;
		if(player.getPx()>0)
		{
			px=0;
			return (int) ((X/(frame.getWIDTH()/block.size))+px*frame.getWIDTH()/block.getSize());
		}
		else 
		{
			px= player.getPx();
			return (int) ((X/(frame.getWIDTH()/block.size))-player.getPx());
		}
	}
	public static int DisplayYtoBlockY(float Y)
	{
		double py;
		if(player.getPy()<-246){
			py=-246;
			return  (int) (((Y/(frame.getWIDTH()/block.size))-py));
		}
		else 
		{
		py= player.getPy();
		return  (int) (((Y/(frame.getWIDTH()/block.size))-py+0.5));
		}
		
	}
	public static void draw(Graphics g)
	{
		
		if(mu>10){
			mu=0;
			minimap.createMap();
		}mu++;
		
		g.drawImage(imageLoader.sky, 0, 0, frame.getWIDTH(), frame.getHEIGHT(), null);
		
		
		int x1=DisplayXtoBlockX(frame.getWIDTH()/2)-15, 
			x2=DisplayXtoBlockX(frame.getWIDTH()/2)+15, 
			y1=0, 
			y2=255;
		
		
		if(x1<0)x1=0;
		if(x2>255)x2=255;
		if(y1<0)y1=0;
		if(y2>255)y2=255;
		
		for(int x=x1; x<x2; x++)
		{
			for(int y=y1; y<y2; y++)
			{
				if(blocks[x][y].isBackground())
				{
					blocks[x][y].draw(g);
				}
			}
		}
		
		entity.draw(g);
		
		for(int x=x1; x<x2; x++)
		{
			for(int y=y1; y<y2; y++)
			{
				if(!blocks[x][y].isBackground())
				{
					blocks[x][y].draw(g);
				}
			}
		}
		
		for(int x=0; x<1000; x++)
		{
			if(items[x].isAlive())
			{
				items[x].draw(g);
			}
		}
		
		
		for(int x=0; x<10000; x++)
		{
			if(particels[x].isAlive())
			{
				particels[x].draw(g);
			}
		}
		inventory.draw(g);
		minimap.draw(g,100,100);
	}
	public static block[][] getBlocks() {
		return blocks;
	}
	public static void setBlocks(block[][] blocks) {
		simulation.blocks = blocks;
	}
	public static void updateKollision()
	{	
		if(!checkCollision())
		{
			lastposX=player.getPx();
			lastposY=player.getPy();
		}
		else
		{
			if(!checkCollision(lastposX, player.getPy()))
			{
				player.setPx(lastposX);
				lastposX=player.getPx();
				lastposY=player.getPy();
			}
			else if(!checkCollision(player.getPx(), lastposY))
			{
				player.setPy(lastposY);
				lastposX=player.getPx();
				lastposY=player.getPy();
				velocity=0;
			}
			else 
			{
				player.setPx(lastposX);
				player.setPy(lastposY);
				velocity=0;
			}
		}
	}
	public static boolean checkCollision(double lx, double ly)
	{
		for(int x=(int) ((-1*lx)+5); x<(-1*lx)+9; x++)
		{
			for(int y=0; y<255; y++)
			{
				if(x<0||x>255)
				{
					double x1,x2,y1,y2,w1,w2,h1,h2;
					x1=(-1*lx)+7.4;
					y1=(-1*ly)+3.75;
					w1=x1+player.hitboxX;
					h1=y1+player.hitboxY;
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
					
					if(blocks[x][y].isCollision())
					{	
						double x1,x2,y1,y2,w1,w2,h1,h2;
						x1=(-1*lx)+7.4;
						y1=(-1*ly)+3.75;
						w1=x1+player.hitboxX;
						h1=y1+player.hitboxY;
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
	public static boolean checkCollision()
	{
		
		for(int x=-1; x<256; x++)
		{
			for(int y=0; y<255; y++)
			{
				
				if(x<0||x>255)
				{
					double x1,x2,y1,y2,w1,w2,h1,h2;
					x1=(-1*player.getPx())+7.4;
					y1=(-1*player.getPy())+3.75;
					w1=x1+player.hitboxX;
					h1=y1+player.hitboxY;
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
					if(blocks[x][y].isCollision())
					{	
						double x1,x2,y1,y2,w1,w2,h1,h2;
						x1=(-1*player.getPx())+7.4;
						y1=(-1*player.getPy())+3.75;
						w1=x1+player.hitboxX;
						h1=y1+player.hitboxY;
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
	public static boolean checkCollision(int x, int y, int id)
	{
		double x1,x2,y1,y2,w1,w2,h1,h2;
		x1=(-1*player.getPx())+7.4;
		y1=(-1*player.getPy())+3.75;
		w1=x1+player.hitboxX;
		h1=y1+player.hitboxY;
		x2=x;
		y2=y;
		w2=x2+1;
		h2=y2+1;
					
		if(((x2<=x1 && x1<=w2) || (x2<=w1 && w1<=w2)) && ((y2<=y1 && y1<=h2) || (y2<=h1 && h1<=h2)))
		{
			return true;
		}
		return false;
	}
	public static void updateMovement()
	{
		
		velocity+=acceleration;
		
		if(keyboard.isEsc())
		{
			for (int i = 0; i < 1000; i++) {
		        for (int j = 0; j < 256; j++) { 
		            b[i * 256 + j]=(byte) (blocks[i][j].getID()); 
		            b2[i * 256 + j]=(byte) (blocks[i][j].getID2()); 
		        }
		    }
			
			save();
			
			System.exit(0);
		}
		if(!inventory.isOpen())
		{
			if(keyboard.isW()) {
				player.setPy(player.getPy()+speed);
			}
			if(keyboard.isA()) {
				player.setPx(player.getPx()+speed);
			}
			if(keyboard.isS()) {
				player.setPy(player.getPy()-speed);
			}
			if(keyboard.isD()) {
				player.setPx(player.getPx()-speed);
			}
		}
		player.setPy(player.getPy()-velocity);
	}
	public static void breackBlock(int x1, int y1)
	{
		int p=0;
		int i=0;
		while(p<particleNumber && i<1000000)
		{
			i++;
			if(!particels[i].isAlive())
			{
				particels[i].create(particleType, x1, y1);
				p++;
			}
		}
		p=0;
		i=0;
		while(p<1 && i<1000)
		{
			i++;
			if(!items[i].isAlive())
			{
				items[i].drop(blocks[x1][y1].getID(), x1+0.5, y1+0.5);
				items[i].setVelocityX((Math.random()-0.5)/2);
				items[i].setVelocityY(-0.25);
				items[i].setAccelarationX(1.1);
				items[i].setAccelarationY(1.1);
				p++;
			}
		}
		blocks[x1][y1].setID(0,0);	
	}	
	public static void updateMouse()
	{
		inventory.setSelected((byte)(inventory.getSelected()+keyboard.getSa()/8));
		if(inventory.getSelected()>8)inventory.setSelected((byte) 0);
		if(inventory.getSelected()<0)inventory.setSelected((byte) 8);
		keyboard.setSa(0);
		if(keyboard.isRbutton())
		{
			int x1=DisplayXtoBlockX(keyboard.getMx());
			int y1=DisplayYtoBlockY(keyboard.getMy()-(frame.getWIDTH()/block.size)/2);
			if(x1>=0&&y1>=0)
			{
				if(blocks[x1][y1].getID()==0)
				{
					if(inventory.slots[inventory.selected].getID()!=0)
					{
						if(!checkCollision(x1, y1, inventory.slots[inventory.selected].getID()))
						{
							blocks[x1][y1].setID(inventory.getHandItem(),0);	
							inventory.slots[inventory.selected].setCount(inventory.slots[inventory.selected].getCount()-1);
						}
					}
				}
			}
		}
		if(keyboard.isLbutton())
		{
			int x1=DisplayXtoBlockX(keyboard.getMx());
			int y1=DisplayYtoBlockY(keyboard.getMy()-(frame.getWIDTH()/block.size)/2);
			if(x1>=0&&y1>=0)
			{
				if(blocks[x1][y1].getID()!=0)
				{
					if(blocks[x1][y1].getID()!=4)
					{
						breackBlock(x1, y1);
					}
				}
			}
		}
	}
	public static void updateKeyboard()
	{
		inventory.update();
		updateMovement();
		
		if(!inventory.isOpen())
		{
			updateMouse();
		}
	}
	public static void update() 
	{
		for(int x=0; x<255; x++)
		{
			for(int y=0; y<255; y++)
			{
				blocks[x][y].update();
			}
		}
		for(int i=0; i<10000; i++)
		{
			if(particels[i].isAlive()) particels[i].update();
		}
		for(int i=0; i<1000; i++)
		{
			if(items[i].isAlive()) items[i].update();
		}
		updateKeyboard();
		updateKollision();
	}
}
