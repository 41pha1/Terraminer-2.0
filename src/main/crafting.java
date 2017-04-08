package main;

public class crafting 
{
	static craftingRecipie [] recipies=new craftingRecipie[256];

	crafting()
	{
		for(int i=0; i<256; i++)
		{
			recipies[i]=new craftingRecipie(0,0,0,0,0,0,false);
		}
		recipies[0]=new craftingRecipie(17,0,0,0,5,4,true);
		recipies[1]=new craftingRecipie(5,0,5,0,280,4,true);
		recipies[2]=new craftingRecipie(5,5,5,5,58,1,true);
	}
	public static int checkCount(int s1, int s2, int s3, int s4)
	{
		for(int i=0; i<16; i++)
		{
			if(recipies[i].isShaped())
			{
				if(s1==recipies[i].getS1()&&s2==recipies[i].getS2()&&s3==recipies[i].getS3()&&s4==recipies[i].getS4())return recipies[i].getC1();
			}
		}
		return 0;
	}
	public static int checkCrafting(int s1, int s2, int s3, int s4)
	{
		for(int i=0; i<16; i++)
		{
			if(recipies[i].isShaped())
			{
				if(s1==recipies[i].getS1()&&s2==recipies[i].getS2()&&s3==recipies[i].getS3()&&s4==recipies[i].getS4())return recipies[i].getR1();
			}
			else
			{
				if( s1==recipies[i].getS1()||
					s2==recipies[i].getS1()||
					s3==recipies[i].getS1()||
					s4==recipies[i].getS1()
					)
				{
					if(recipies[i].getS1()==0)
					{
						if(s1!=recipies[i].getS1())return 0;
						if(s2!=recipies[i].getS1())return 0;
						if(s3!=recipies[i].getS1())return 0;
						if(s4!=recipies[i].getS1())return 0;
					}
						if( s1==recipies[i].getS2()||
							s2==recipies[i].getS2()||
							s3==recipies[i].getS2()||
							s4==recipies[i].getS2())
						{
							if(recipies[i].getS2()==0)
							{
								if(s1!=recipies[i].getS2())return 0;
								if(s2!=recipies[i].getS2())return 0;
								if(s3!=recipies[i].getS2())return 0;
								if(s4!=recipies[i].getS2())return 0;
							}
							if( s1==recipies[i].getS3()||
								s2==recipies[i].getS3()||
								s3==recipies[i].getS3()||
								s4==recipies[i].getS3())
							{
								if(recipies[i].getS3()==0)
								{
									if(s1!=recipies[i].getS3())return 0;
									if(s2!=recipies[i].getS3())return 0;
									if(s3!=recipies[i].getS3())return 0;
									if(s4!=recipies[i].getS3())return 0;
								}
								if( s1==recipies[i].getS4()||
									s2==recipies[i].getS4()||
									s3==recipies[i].getS4()||
									s4==recipies[i].getS4())
								{
									if(recipies[i].getS4()==0)
									{
										if(s1!=recipies[i].getS4())return 0;
										if(s2!=recipies[i].getS4())return 0;
										if(s3!=recipies[i].getS4())return 0;
										if(s4!=recipies[i].getS4())return 0;
									}
									return recipies[i].getR1();
								}
							}
						}
				}
			}
		}return 0;	
	}
}

