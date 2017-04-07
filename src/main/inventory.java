package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.ObjectInputStream.GetField;

public class inventory 
{
	public static slot[] slots =new slot[36];
	public static byte selected=0;
	public static boolean open=false;
	public static boolean isOpen() {
		return open;
	}
	public static void updateKeys()
	{
		for(int x=0; x<36; x++)
		{
			if(slots[x].getCount()<1)
			{
				slots[x].setID(0);
				slots[x].setCount(0);
			}
		}
		if(keyboard.k1)inventory.setSelected((byte) 0);
		if(keyboard.k2)inventory.setSelected((byte) 1);
		if(keyboard.k3)inventory.setSelected((byte) 2);
		if(keyboard.k4)inventory.setSelected((byte) 3);
		if(keyboard.k5)inventory.setSelected((byte) 4);
		if(keyboard.k6)inventory.setSelected((byte) 5);
		if(keyboard.k7)inventory.setSelected((byte) 6);
		if(keyboard.k8)inventory.setSelected((byte) 7);
		if(keyboard.k9)inventory.setSelected((byte) 8);
		if(keyboard.e)
		{
			if(inventory.isOpen())
			{
				inventory.setOpen(false);
			}else 
			{
				inventory.setOpen(true);
			}
			keyboard.setE(false);
		}
	}
	public static void setOpen(boolean open) {
		inventory.open = open;
	}
	inventory()
	{
		for(int x=0; x<36; x++)
		{	
			slots[x]=new slot(0,0);
		}
	}
	public static void draw(Graphics g)
	{
		g.setFont(new Font("ComicSans", Font.PLAIN, 10));
		g.setColor(Color.white);

		
		if(open)
		{
			g.drawImage(imageLoader.inv, frame.getWIDTH()/2-imageLoader.inv.getWidth()/4,frame.getRHEIGHT()/2-imageLoader.inv.getHeight()/4,imageLoader.inv.getWidth()/2, imageLoader.inv.getHeight()/2, null);
			g.drawImage(imageLoader.skin, frame.getWIDTH()/2-imageLoader.inv.getWidth()/4+(int)(1000/15),frame.getRHEIGHT()/2-imageLoader.inv.getHeight()/4+(int)(frame.getRHEIGHT()/23),imageLoader.skin.getWidth()/4, imageLoader.skin.getHeight()/4, null);
			for(int x=0; x<36; x++)
			{
				g.drawImage(imageLoader.getTextures()[slots[x].getID()][0], getDrawPosX(x), getDrawPosY(x), frame.getWIDTH()/35, frame.getWIDTH()/35, null);
				if(slots[x].getCount()!=0&&slots[x].getCount()!=1)
				{
					g.drawString(""+slots[x].getCount(), getDrawPosX(x), getDrawPosY(x));
				}
			}
		}
		g.drawImage(imageLoader.gui, frame.getWIDTH()/4, frame.getRHEIGHT()-frame.getRHEIGHT()/8, frame.getWIDTH()/2, frame.getWIDTH()/20, null);
		for(int x=0; x<9; x++)
		{
			g.drawImage(imageLoader.getTextures()[slots[x].getID()][0], x*(int)(frame.getWIDTH()/18.13)+(int)(frame.getWIDTH()/3.75), (frame.getRHEIGHT()-(int)(frame.getRHEIGHT()/8)+(int)(frame.getWIDTH()/80)), frame.getWIDTH()/35, frame.getWIDTH()/35 ,null);
			if(slots[x].getCount()!=0&&slots[x].getCount()!=1)
			{
				g.drawString(""+slots[x].getCount(), x*(int)(frame.getWIDTH()/18.13)+(int)(frame.getWIDTH()/3.75), (frame.getRHEIGHT()-(int)(frame.getRHEIGHT()/8)+(int)(frame.getWIDTH()/80)));
			}
		}
		g.drawImage(imageLoader.sel, (selected)*frame.getWIDTH()/18+(int)(frame.getWIDTH()/3.75), (frame.getRHEIGHT()-(int)(frame.getRHEIGHT()/8)+(int)(frame.getWIDTH()/80)), frame.getWIDTH()/25, frame.getWIDTH()/25 ,null);
	}
	public static byte getSelected() {
		return selected;
	}
	public static int getDrawPosX(int slot)
	{
		if(slot<9)
		{
			return frame.getWIDTH()/2-imageLoader.inv.getWidth()/4+24+slot*35;
		}
		if(slot<18)
		{
			return frame.getWIDTH()/2-imageLoader.inv.getWidth()/4+24+(slot-9)*35;
		}
		if(slot<27)
		{
			return frame.getWIDTH()/2-imageLoader.inv.getWidth()/4+24+(slot-18)*35;
		}
		if(slot<36)
		{
			return frame.getWIDTH()/2-imageLoader.inv.getWidth()/4+24+(slot-27)*35;
		}
		return 0;
	}
	public static int getDrawPosY(int slot)
	{
		if(slot<9)
		{
			return frame.getRHEIGHT()/2-imageLoader.inv.getHeight()/4+287;
		}
		if(slot<18)
		{
			return frame.getRHEIGHT()/2-imageLoader.inv.getHeight()/4+174;
		}
		if(slot<27)
		{
			return frame.getRHEIGHT()/2-imageLoader.inv.getHeight()/4+209;
		}
		if(slot<36)
		{
			return frame.getRHEIGHT()/2-imageLoader.inv.getHeight()/4+244;
		}
		return 0;
	}
	public static void setSelected(byte selected) {
		inventory.selected = selected;
	}
	public static int getHandItem()
	{
		return slots[selected].getID();
	}
	public static void collectItem(int iD) 
	{
		int ffs=getFirstSlot(iD);
		slots[ffs].setCount(slots[ffs].getCount()+1);
		slots[ffs].setID(iD);
	}
	public static int getFirstSlot(int ID)
	{
		for(int x=0; x<36; x++)
		{
			if(slots[x].getID()==ID)
			{
				if(slots[x].getCount()<=63)
				{
					return  x;
				}
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
