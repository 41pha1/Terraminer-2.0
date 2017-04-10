package main;

public class crafting 
{
	static craftingRecipie [] recipies2x2=new craftingRecipie[256];
	static craftingRecipie [] recipies3x3=new craftingRecipie[256];
	static craftingRecipie [] furnace=new craftingRecipie[256];


	crafting()
	{
		for(int i=0; i<256; i++)
		{
			furnace[i]=new craftingRecipie(0,0,0,0,0,0,false);
		}
		for(int i=0; i<256; i++)
		{
			recipies2x2[i]=new craftingRecipie(0,0,0,0,0,0,false);
		}
		for(int i=0; i<256; i++)
		{
			recipies3x3[i]=new craftingRecipie(0,0,0,0,0,0,false);
		}
		furnace[0]=new craftingRecipie(item.COBBLE, item.STONE, 1);
		furnace[1]=new craftingRecipie(item.IRON_ORE, item.IRON, 1);
		recipies3x3[0]=new craftingRecipie(5,5,5,0,100, 0, 0, 100, 0, 101, 1,true);
		recipies3x3[1]=new craftingRecipie(item.AIR,  item.PLANKS,   item.AIR,  item.AIR,  item.STICK,   item.AIR,  item.AIR,  item.STICK,   item.AIR,  item.WOOD_SHOVEL, 1,true);
		recipies3x3[2]=new craftingRecipie(item.AIR,  item.PLANKS,   item.AIR,  item.AIR,  item.PLANKS,    item.AIR,  item.AIR,  item.STICK,   item.AIR,  item.WOOD_SWORD, 1,true);
		recipies3x3[3]=new craftingRecipie(item.PLANKS,   item.PLANKS,   item.AIR,  item.AIR,  item.STICK,   item.AIR,  item.AIR,  item.STICK,   item.AIR, item.WOOD_HOE,   1,true);
		recipies3x3[4]=new craftingRecipie(item.PLANKS,   item.PLANKS,   item.AIR,  item.PLANKS,   item.STICK,   item.AIR,  item.AIR,  item.STICK,   item.AIR, item.WOOD_AXE, 1,true);
		recipies3x3[5]=new craftingRecipie(item.COBBLE,  item.COBBLE,  item.COBBLE,  item.AIR,  item.STICK,   item.AIR,  item.AIR,  item.STICK,   item.AIR,  item.STONE_PICKAXE, 1,true);
		recipies3x3[6]=new craftingRecipie(item.AIR,  item.COBBLE,  item.AIR,  item.AIR,  item.STICK,   item.AIR,  item.AIR,  item.STICK,   item.AIR,  item.STONE_SHOVEL, 1,true);
		recipies3x3[7]=new craftingRecipie(item.AIR,  item.COBBLE,  item.AIR,  item.AIR,  item.COBBLE,   item.AIR,  item.AIR,  item.STICK,   item.AIR,  item.STONE_SWORD, 1,true);
		recipies3x3[8]=new craftingRecipie(item.COBBLE,  item.COBBLE,  item.AIR,  item.AIR,  item.STICK,   item.AIR,  item.AIR,  item.STICK,   item.AIR,  item.STONE_HOE, 1,true);
        recipies3x3[9]=new craftingRecipie(item.COBBLE,  item.COBBLE,  item.AIR,  item.COBBLE,  item.STICK,   item.AIR,  item.AIR,  item.STICK,   item.AIR,  item.STONE_AXE,  1,true);
        recipies3x3[10]=new craftingRecipie(item.COBBLE,  item.COBBLE,  item.COBBLE,  item.COBBLE,  item.AIR,  item.COBBLE,   item.COBBLE,   item.COBBLE,   item.COBBLE,   item.FURNACE,  1,true);
		recipies3x3[11]=new craftingRecipie(item.IRON,  item.IRON,  item.IRON,  item.AIR,  item.STICK,   item.AIR,  item.AIR,  item.STICK,   item.AIR,  item.IRON_PICKAXE, 1,true);
		recipies3x3[12]=new craftingRecipie(item.AIR,  item.IRON,  item.AIR,  item.AIR,  item.STICK,   item.AIR,  item.AIR,  item.STICK,   item.AIR,  item.IRON_SHOVEL, 1,true);
		recipies3x3[13]=new craftingRecipie(item.AIR,  item.IRON,  item.AIR,  item.AIR,  item.IRON,   item.AIR,  item.AIR,  item.STICK,   item.AIR,  item.IRON_SWORD, 1,true);
		recipies3x3[14]=new craftingRecipie(item.IRON,  item.IRON,  item.AIR,  item.AIR,  item.STICK,   item.AIR,  item.AIR,  item.STICK,   item.AIR,  item.IRON_HOE, 1,true);
		recipies3x3[15]=new craftingRecipie(item.IRON,  item.IRON,  item.AIR,  item.IRON,  item.STICK,   item.AIR,  item.AIR,  item.STICK,   item.AIR,  item.IRON_AXE,  1,true);
		recipies3x3[15]=new craftingRecipie(item.PLANKS,  item.PLANKS,  item.PLANKS,  item.PLANKS,  item.AIR,   item.PLANKS,  item.PLANKS,  item.PLANKS,   item.PLANKS,  item.CHEST,  1,true);
        recipies2x2[0]=new craftingRecipie(item.LOG,  item.AIR,  item.AIR,  item.AIR,  item.PLANKS,   4,  true);
		recipies2x2[1]=new craftingRecipie(item.AIR,  item.LOG,  item.AIR,  item.AIR,  item.PLANKS,   4,  true);
		recipies2x2[2]=new craftingRecipie(item.AIR,  item.AIR,  item.LOG,  item.AIR,  item.PLANKS,   4,  true);
		recipies2x2[3]=new craftingRecipie(item.AIR,  item.AIR,  item.AIR,  item.LOG,  item.PLANKS,   4,  true);
		recipies2x2[4]=new craftingRecipie(item.PLANKS,   item.AIR,  item.PLANKS,   item.AIR,  item.STICK,  4,  true);
		recipies2x2[5]=new craftingRecipie(item.AIR,  item.PLANKS,   item.AIR,  item.PLANKS,   item.STICK,  4,  true);
		recipies2x2[6]=new craftingRecipie(item.PLANKS,   item.PLANKS,   item.PLANKS,   item.PLANKS,   item.CRAFTING_TABLE, 1, true);
	}
	public static int checkCount(int s1, int s2, int s3, int s4, int s5, int s6, int s7, int s8, int s9, int container)
	{
		if(container==0)
		{
			for(int i=0; i<256; i++)
			{
				if(recipies2x2[i].isShaped())
				{
					if(s1==recipies2x2[i].getS1()&&s2==recipies2x2[i].getS2()&&s3==recipies2x2[i].getS3()&&s4==recipies2x2[i].getS4())return recipies2x2[i].getC1();
				}
			}
		}
		else if(container==1)
		{
			for(int i=0; i<256; i++)
			{
				if(recipies3x3[i].isShaped())
				{
					if(s1==recipies2x2[i].getS1()&&s2==recipies2x2[i].getS2()&&s3==0&&s4==recipies2x2[i].getS3()&&s5==recipies2x2[i].getS4()&&s6==0&&s7==0&&s8==0&&s9==0)return recipies2x2[i].getC1();
					if(s1==0&&s2==recipies2x2[i].getS1()&&s3==recipies2x2[i].getS2()&&s4==0&&s5==recipies2x2[i].getS3()&&s6==recipies2x2[i].getS4()&&s7==0&&s8==0&&s9==0)return recipies2x2[i].getC1();
					if(s1==0&&s2==0&&s3==0&&s4==recipies2x2[i].getS1()&&s5==recipies2x2[i].getS2()&&s6==0&&s7==recipies2x2[i].getS3()&&s8==recipies2x2[i].getS4()&&s9==0)return recipies2x2[i].getC1();
					if(s1==0&&s2==0&&s3==0&&s4==0&&s5==recipies2x2[i].getS1()&&s6==recipies2x2[i].getS2()&&s7==0&&s8==recipies2x2[i].getS3()&&s9==recipies2x2[i].getS4())return recipies2x2[i].getC1();
					if(s1==recipies3x3[i].getS1()&&s2==recipies3x3[i].getS2()&&s3==recipies3x3[i].getS3()&&s4==recipies3x3[i].getS4()&&s5==recipies3x3[i].getS5()&&s6==recipies3x3[i].getS6()&&s7==recipies3x3[i].getS7()&&s8==recipies3x3[i].getS8()&&s9==recipies3x3[i].getS9())return recipies3x3[i].getC1();
				}
			}
		}
		if(container==2)
		{
			for(int i=0; i<256; i++)
			{
				if(s1==furnace[i].getS1())return furnace[i].getC1();
			}return 0;	
		}
		return 0;
	}
	public static int checkCrafting(int s1, int s2, int s3, int s4, int s5, int s6, int s7, int s8, int s9, int container)
	{
		if(container==0)
		{
			for(int i=0; i<256; i++)
			{
				if(recipies2x2[i].isShaped())
				{
					if(s1==recipies2x2[i].getS1()&&s2==recipies2x2[i].getS2()&&s3==recipies2x2[i].getS3()&&s4==recipies2x2[i].getS4())return recipies2x2[i].getR1();
				}
				else
				{
					
				}
			}return 0;	
		}else if(container==1)
		{
			for(int i=0; i<256; i++)
			{
				if(recipies3x3[i].isShaped())
				{
					if(s1==recipies2x2[i].getS1()&&s2==recipies2x2[i].getS2()&&s3==0&&s4==recipies2x2[i].getS3()&&s5==recipies2x2[i].getS4()&&s6==0&&s7==0&&s8==0&&s9==0)return recipies2x2[i].getR1();
					if(s1==0&&s2==recipies2x2[i].getS1()&&s3==recipies2x2[i].getS2()&&s4==0&&s5==recipies2x2[i].getS3()&&s6==recipies2x2[i].getS4()&&s7==0&&s8==0&&s9==0)return recipies2x2[i].getR1();
					if(s1==0&&s2==0&&s3==0&&s4==recipies2x2[i].getS1()&&s5==recipies2x2[i].getS2()&&s6==0&&s7==recipies2x2[i].getS3()&&s8==recipies2x2[i].getS4()&&s9==0)return recipies2x2[i].getR1();
					if(s1==0&&s2==0&&s3==0&&s4==0&&s5==recipies2x2[i].getS1()&&s6==recipies2x2[i].getS2()&&s7==0&&s8==recipies2x2[i].getS3()&&s9==recipies2x2[i].getS4())return recipies2x2[i].getR1();
					if(s1==recipies3x3[i].getS1()&&s2==recipies3x3[i].getS2()&&s3==recipies3x3[i].getS3()&&s4==recipies3x3[i].getS4()&&s5==recipies3x3[i].getS5()&&s6==recipies3x3[i].getS6()&&s7==recipies3x3[i].getS7()&&s8==recipies3x3[i].getS8()&&s9==recipies3x3[i].getS9())return recipies3x3[i].getR1();
				}
			}
		}if(container==2)
		{
			if(item.getBurnable(s2))
			{
				for(int i=0; i<256; i++)
				{
					if(s1==furnace[i].getS1())return furnace[i].getR1();
				}return 0;
			}
		}
		return 0;
	}
}

