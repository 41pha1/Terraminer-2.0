package main;

import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ImageGenarator extends JFrame 
{
	static frame f = new frame();
	static long lastime = System.nanoTime();
	static final double ticks = 60;
	static double ns = 1000000000 / ticks;    
	static double delta = 0;
	
	public static void main(String[] args) 
	{
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setResizable(true);
		f.setSize(750,750);
		f.setVisible(true);
		f.makestrat();
		f.setTitle("ImageGenarator");
		
		while(true)
		{
			long now = System.nanoTime();
			delta-=(lastime-now)/ns;
			lastime = now;
			if(delta>=1) 
			{
				f.repaint();
				delta--;
			}
		}
	}
}
