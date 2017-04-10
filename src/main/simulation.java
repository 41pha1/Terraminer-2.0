package main;

import java.awt.Graphics;
import java.io.DataInputStream;

import javax.swing.JOptionPane;

public class simulation {
	static int mapsize=255;
	static block[][] blocks = new block[mapsize+1][256];
	static byte[] b=new byte[mapsize*256];
	static byte[] b2=new byte[mapsize*256];
	static particel[] particels = new particel[100000];
	static item[] items = new item[1000];
	minimap m= new minimap();
	static inventory i=new inventory();
	boolean collide;
	boolean load=false;
	static double lastposX=0;
	static double lastposY=-6;
	private static int mu=0;
	private static int particleType=1;
	private static int particleNumber=50;
	static double acceleration=0.005;
	static double velocity;
	boolean la=false,ls=false,lw=false,ld=false;
	static double speed = 0.12;
	simulation() 
	{
		int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Load your Previous World?");
		if(dialogResult == JOptionPane.YES_OPTION)load=true;
		if(dialogResult == JOptionPane.CANCEL_OPTION)System.exit(0);
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
		if(load)load();
		else worldGenerator.generateWorld();
		
		while(!checkCollision())
		{
			player.setPy(player.getPy()-1);
		}
		minimap.createMap();
		
	}
	public void load()
	  {
     try
    {
    	DataInputStream dis = new DataInputStream(new java.util.zip.GZIPInputStream(new java.io.FileInputStream(new java.io.File("level.dat"))));
   		dis.readFully(b);
   		dis.close();
   		DataInputStream dis2 = new DataInputStream(new java.util.zip.GZIPInputStream(new java.io.FileInputStream(new java.io.File("level2.dat"))));
   		dis2.readFully(b2);
   		dis2.close();
    }
     catch (Exception e)
   {
       e.printStackTrace();
		}
     for(int x=0; x<mapsize; x++)
		{
			for(int y=0; y<256+1; y++)
			{
				blocks[x][y]=new block();
				blocks[x][y].setX(x);
				blocks[x][y].setY(y);
				blocks[x][y].setID(0,0);
			}
		}
		
		for(int x=0; x<mapsize; x++)
		{
			for(int y=0; y<256; y++)
			{
				blocks[x][y].setID(b[x * 256 +y], 0);
				blocks[x][y].setID2(b2[x * 256 +y]);
			}
		}
   }
	public static void save()
	{
		for (int i = 0; i < mapsize; i++) {
	        for (int j = 0; j < 256; j++) { 
	            b[i * 256 + j]=(byte) (blocks[i][j].getID()); 
	            b2[i * 256 + j]=(byte) (blocks[i][j].getID2()); 
	        }
	    }
	   try    
	   {
	       java.io.DataOutputStream dos = new java.io.DataOutputStream(new java.util.zip.GZIPOutputStream(new java.io.FileOutputStream(new java.io.File("level.dat"))));
	       dos.write(b);
		   dos.close();
	       java.io.DataOutputStream dos2 = new java.io.DataOutputStream(new java.util.zip.GZIPOutputStream(new java.io.FileOutputStream(new java.io.File("level2.dat"))));
	       dos2.write(b2);
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
		if(x2>mapsize)x2=mapsize;
		if(y1<0)y1=0;
		if(y2>mapsize)y2=mapsize;
		
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
				if(x<0||x>mapsize)
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
		
		for(int x=-1; x<mapsize; x++)
		{
			for(int y=0; y<255; y++)
			{
				
				if(x<0||x>mapsize)
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
		if(blocks[x1][y1].getDrop()!=0)
		{
			p=0;
			i=0;
			while(p<1 && i<1000)
			{
				i++;
				if(!items[i].isAlive())
				{
					System.out.println(blocks[x1][y1].getDrop());
					items[i].drop(blocks[x1][y1].getDrop(), blocks[x1][y1].getDrop2(), x1+0.5, y1+0.5);
					items[i].setVelocityX((Math.random()-0.5)/2);
					items[i].setVelocityY(-0.25);
					items[i].setAccelarationX(1.1);
					items[i].setAccelarationY(1.1);
					p++;
				}
			}
		}
		blocks[x1][y1].setID(item.AIR,0);	
		blocks[x1][y1].setDestroyed(0);
	}	
	public static void updateMouse()
	{
		inventory.setSelected((byte)(inventory.getSelected()+keyboard.getSa()/8));
		if(inventory.getSelected()>8)inventory.setSelected((byte) 0);
		if(inventory.getSelected()<0)inventory.setSelected((byte) 8);
		keyboard.setSa(0);
		int x1=DisplayXtoBlockX(keyboard.getMx());
		int y1=DisplayYtoBlockY(keyboard.getMy()-(frame.getWIDTH()/block.size)/2);
		if(keyboard.isRbutton())
		{
			if(x1>=0&&y1>=0)
			{
				if(blocks[x1][y1].getID()==item.AIR)
				{
					if(inventory.slots[inventory.selected].getID()!=item.AIR)
					{
						if(!checkCollision(x1, y1, inventory.slots[inventory.selected].getID()))
						{
							blocks[x1][y1].setID(inventory.getHandItem(),inventory.getHandItem2());		
							inventory.slots[inventory.selected].setCount(inventory.slots[inventory.selected].getCount()-1);
						}
					}
				}
				blocks[x1][y1].isRightClicked();
			}
		}
		for(int x=0; x<mapsize; x++)
		{
			for(int y=0; y<256; y++)
			{
				if(x!=x1||y!=y1)
				{
					blocks[x][y].setDestroyed(0);
				}
			}
		}
		if(keyboard.isLbutton())
		{
			if(x1>=0&&y1>=0)
			{
				if(blocks[x1][y1].getID()!=item.AIR)
				{
					if(blocks[x1][y1].getID()!=item.BEDROCK)
					{
						if(blocks[x1][y1].getDestroyTime(inventory.getHandItem())==0)
						{
							breackBlock(x1,y1);
						}else
						{
							if((System.nanoTime()-blocks[x1][y1].getTime())>blocks[x1][y1].getDestroyTime(inventory.getHandItem()))
							{
								blocks[x1][y1].setTime(System.nanoTime());
								blocks[x1][y1].setDestroyed(blocks[x1][y1].getDestroyed()+1);
							}
							if(blocks[x1][y1].getDestroyed()>9)
							{
								breackBlock(x1, y1);
							}
						}
					}
				}
			}
		}else 
		{
			for(int x=0; x<mapsize; x++)
			{
				for(int y=0; y<256; y++)
				{
					blocks[x][y].setDestroyed(0);
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
		for(int x=0; x<mapsize; x++)
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
