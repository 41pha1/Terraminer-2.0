package main;

import java.awt.Graphics;
import java.io.ObjectInputStream.GetField;

public class inventory 
{
	public static slot[] slots =new slot[36];
	inventory()
	{
		for(int x=0; x<36; x++)
		{	
			slots[x]=new slot(0,0);
		}
	}
	public static void draw(Graphics g)
	{
		g.drawImage(imageLoader.gui, frame.getWIDTH()/4, frame.getRHEIGHT()-frame.getRHEIGHT()/8, frame.getWIDTH()/2, frame.getWIDTH()/20, null);
		
		for(int x=0; x<9; x++)
		{
			g.drawImage(imageLoader.getTextures()[slots[x].getID()][0], x*frame.getWIDTH()/18+frame.getWIDTH()/4, frame.getRHEIGHT()-frame.getRHEIGHT()/8, 64, 64,null);
		}
	}
	public static void collectItem(int iD) 
	{
		slots[getFirstSlot(iD)].setID(iD);
	}
	public static int getFirstSlot(int ID)
	{
		for(int x=0; x<36; x++)
		{
			if(slots[x].getID()==ID)
			{
				return  x;
			}
		}
		for(int x=0; x<36; x++)
		{
			if(slots[x].getID()==0)
			{
				return x;
			}
		}return (Integer) null;
	}
}
