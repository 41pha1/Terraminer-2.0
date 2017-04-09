package main;

public class crafting 
{
	static craftingRecipie [] recipies2x2=new craftingRecipie[256];
	static craftingRecipie [] recipies3x3=new craftingRecipie[256];


	crafting()
	{
		for(int i=0; i<256; i++)
		{
			recipies2x2[i]=new craftingRecipie(0,0,0,0,0,0,false);
		}
		for(int i=0; i<256; i++)
		{
			recipies3x3[i]=new craftingRecipie(0,0,0,0,0,0,false);
		}
		recipies3x3[0]=new craftingRecipie(5,5,5,0,100, 0, 0, 100, 0, 101, 1,true);
		recipies3x3[1]=new craftingRecipie(0,5,0,0,100, 0, 0, 100, 0, 102, 1,true);
		recipies3x3[2]=new craftingRecipie(0,5,0,0,5, 0, 0, 100, 0, 103, 1,true);
		recipies3x3[3]=new craftingRecipie(5,5,0,0,100, 0, 0, 100, 0, 104, 1,true);
		recipies3x3[4]=new craftingRecipie(5,5,0,5,100, 0, 0, 100, 0, 105, 1,true);
		recipies3x3[5]=new craftingRecipie(4,4,4,0,100, 0, 0, 100, 0, 106, 1,true);
		recipies3x3[6]=new craftingRecipie(0,4,0,0,100, 0, 0, 100, 0, 107, 1,true);
		recipies3x3[7]=new craftingRecipie(0,4,0,0,4, 0, 0, 100, 0, 108, 1,true);
		recipies3x3[8]=new craftingRecipie(4,4,0,0,100, 0, 0, 100, 0, 109, 1,true);
		recipies3x3[9]=new craftingRecipie(4,4,0,4,100, 0, 0, 100, 0, 110, 1,true);
		recipies3x3[10]=new craftingRecipie(4,4,4,4,0, 4, 4, 4, 4, 20, 1,true);
		recipies2x2[0]=new craftingRecipie(16,0,0,0,5,4,true);
		recipies2x2[1]=new craftingRecipie(0,16,0,0,5,4,true);
		recipies2x2[2]=new craftingRecipie(0,0,16,0,5,4,true);
		recipies2x2[3]=new craftingRecipie(0,0,0,16,5,4,true);
		recipies2x2[4]=new craftingRecipie(5,0,5,0,100,4,true);
		recipies2x2[5]=new craftingRecipie(0,5,0,5,100,4,true);
		recipies2x2[6]=new craftingRecipie(5,5,5,5,18,1,true);
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
					if(s1==recipies2x2[i].getS1()&&s2==recipies2x2[i].getS2()&&s4==recipies2x2[i].getS3()&&s5==recipies2x2[i].getS4())return recipies2x2[i].getC1();
					if(s2==recipies2x2[i].getS1()&&s3==recipies2x2[i].getS2()&&s5==recipies2x2[i].getS3()&&s6==recipies2x2[i].getS4())return recipies2x2[i].getC1();
					if(s4==recipies2x2[i].getS1()&&s5==recipies2x2[i].getS2()&&s7==recipies2x2[i].getS3()&&s8==recipies2x2[i].getS4())return recipies2x2[i].getC1();
					if(s5==recipies2x2[i].getS1()&&s6==recipies2x2[i].getS2()&&s8==recipies2x2[i].getS3()&&s9==recipies2x2[i].getS4())return recipies2x2[i].getC1();
					if(s1==recipies3x3[i].getS1()&&s2==recipies3x3[i].getS2()&&s3==recipies3x3[i].getS3()&&s4==recipies3x3[i].getS4()&&s5==recipies3x3[i].getS5()&&s6==recipies3x3[i].getS6()&&s7==recipies3x3[i].getS7()&&s8==recipies3x3[i].getS8()&&s9==recipies3x3[i].getS9())return recipies3x3[i].getC1();
				}
			}
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
					if(s1==recipies2x2[i].getS1()&&s2==recipies2x2[i].getS2()&&s4==recipies2x2[i].getS3()&&s5==recipies2x2[i].getS4())return recipies2x2[i].getR1();
					if(s2==recipies2x2[i].getS1()&&s3==recipies2x2[i].getS2()&&s5==recipies2x2[i].getS3()&&s6==recipies2x2[i].getS4())return recipies2x2[i].getR1();
					if(s4==recipies2x2[i].getS1()&&s5==recipies2x2[i].getS2()&&s7==recipies2x2[i].getS3()&&s8==recipies2x2[i].getS4())return recipies2x2[i].getR1();
					if(s5==recipies2x2[i].getS1()&&s6==recipies2x2[i].getS2()&&s8==recipies2x2[i].getS3()&&s9==recipies2x2[i].getS4())return recipies2x2[i].getR1();
					if(s1==recipies3x3[i].getS1()&&s2==recipies3x3[i].getS2()&&s3==recipies3x3[i].getS3()&&s4==recipies3x3[i].getS4()&&s5==recipies3x3[i].getS5()&&s6==recipies3x3[i].getS6()&&s7==recipies3x3[i].getS7()&&s8==recipies3x3[i].getS8()&&s9==recipies3x3[i].getS9())return recipies3x3[i].getR1();
				}
			}
		}
		return 0;
	}
}

