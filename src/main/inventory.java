package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class inventory 
{
	public static slot[] slots =new slot[42];
	public static crafting c=new crafting();
	public static byte selected=0;
	public static boolean open=false, pickedUp=false;
	public final static int FULL=-1, NO_SLOT_SELECTED=-1;
	public static boolean isOpen() {
		return open;
	}
	public static void pickUp(int slot)
	{
		if(getSlotFromMouse(keyboard.mx, keyboard.my)!=NO_SLOT_SELECTED)
		{
			if(pickedUp)
			{
				int oldID, oldCount;
				oldID=slots[slot].getID();
				oldCount=slots[slot].getCount();	
				slots[slot].setID(slots[36].getID());
				slots[36].setID(oldID);
				slots[slot].setCount(slots[36].getCount());
				slots[36].setCount(oldCount);
				pickedUp=false;
			}
			else 
			{
				int oldID, oldCount;
				oldID=slots[36].getID();
				oldCount=slots[36].getCount();
				slots[36].setID(slots[slot].getID());
				slots[slot].setID(oldID);
				slots[36].setCount(slots[slot].getCount());
				slots[slot].setCount(oldCount);
				pickedUp=true;
			} keyboard.setLbutton(false);
		}
		if(slot==-1)
		{
			drop(slots[36].getID(), slots[36].getCount());
			slots[36].setID(0);
			slots[36].setCount(0);
			pickedUp=false;
		}
	}
	public static void updateKeys()
	{
		if(open)
		{
			if(keyboard.lbutton)
			{	
				pickUp(getSlotFromMouse(keyboard.mx, keyboard.my));
			}
		}
		for(int x=0; x<36; x++)
		{
			if(slots[x].getCount()<1)
			{
				slots[x].setID(0);
				slots[x].setCount(0);
			}
		}
		
		updateCrafting();
		
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
				open=false;
				for(int i=36; i<41; i++)
				{
					drop(slots[i].getID(), slots[i].getCount());
					slots[i].setID(0);
					slots[i].setCount(0);
				}
			}else 
			{
				open=true;
			}
			keyboard.setE(false);
		}
	}
	inventory()
	{
		for(int x=0; x<42; x++)
		{	
			slots[x]=new slot(0,0);
		}
	}
	public static void updateCrafting()
	{
		if(crafting.checkCrafting(slots[37].getID(), slots[38].getID(), slots[39].getID(), slots[40].getID())!=0)
		{
			slots[41].setID(crafting.checkCrafting(slots[37].getID(), slots[38].getID(), slots[39].getID(), slots[40].getID()));
			slots[41].setCount(1);
		}
	}
	public static void drop(int id, int count)
	{
		double rand=((Math.random()-0.5)/2);
		int p=0;
		int i=0;
		while(p<count && i<1000)
		{
			i++;
			if(!simulation.items[i].isAlive())
			{
				simulation.items[i].drop(id, (-1*player.getPx())+7.4, (-1*player.getPy())+3.75);
				simulation.items[i].setVelocityX(rand);
				simulation.items[i].setVelocityY(-0.25);
				simulation.items[i].setAccelarationX(1.1);
				simulation.items[i].setAccelarationY(1.1);
				simulation.items[i].setCantcollect(100);
				p++;
			}
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
			for(int x=0; x<42; x++)
			{
				if(x!=36)
				{
					g.drawImage(imageLoader.getTextures()[slots[x].getID()][0], getDrawPosX(x), getDrawPosY(x), 28, 28, null);
					if(slots[x].getCount()!=0&&slots[x].getCount()!=1)
					{
						g.drawString(""+slots[x].getCount(), getDrawPosX(x), getDrawPosY(x));
					}
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
		g.drawImage(imageLoader.sel, (selected)*frame.getWIDTH()/18+(int)(frame.getWIDTH()/3.85), (frame.getRHEIGHT()-(int)(frame.getRHEIGHT()/8)+(int)(frame.getWIDTH()/130)), frame.getWIDTH()/25, frame.getWIDTH()/25 ,null);
		if(slots[36].getCount()!=0&&slots[36].getCount()!=1)
		{
			g.drawString(""+slots[36].getCount(), keyboard.getMx(), keyboard.getMy());
		}
		g.drawImage(imageLoader.getTextures()[slots[36].getID()][0], keyboard.getMx(), keyboard.getMy(), 28, 28, null);
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
		if(slot<39)
		{
			return frame.getWIDTH()/2-imageLoader.inv.getWidth()/4+24+(slot-32)*35;
		}
		if(slot<41)
		{
			return frame.getWIDTH()/2-imageLoader.inv.getWidth()/4+24+(slot-34)*35;
		}
		if(slot<42)
		{
			return frame.getWIDTH()/2-imageLoader.inv.getWidth()/4+24+(slot-32)*35;
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
		if(slot<39)
		{
			return frame.getRHEIGHT()/2-imageLoader.inv.getHeight()/4+40;
		}
		if(slot<41)
		{
			return frame.getRHEIGHT()/2-imageLoader.inv.getHeight()/4+75;
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
	public static int getSlotFromMouse(int x, int y)
	{
		int slot=NO_SLOT_SELECTED;
		
		for(int i=0; i<42; i++)
		{
			double x2,y2,w2,h2;
			x2=getDrawPosX(i);
			y2=getDrawPosY(i);
			w2=getDrawPosX(i)+32;
			h2=getDrawPosY(i)+32;
			
			if(x2<=x && x<=w2 && y2<=y && y<=h2)
			{
				slot=i;
			}
		}
		return slot;
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
		}return FULL;
	}
}
