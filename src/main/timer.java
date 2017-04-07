package main;

public class timer 
{
	public static long time=System.nanoTime();
	
	public static void time(String txt)
	{
		long timed=System.nanoTime()-time;
		System.out.println(txt+" "+timed/1000000f+" millisecs");
		time=System.nanoTime();
	}
}
