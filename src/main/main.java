package main;

import javax.swing.WindowConstants;

public class main 
{
	static simulation s = new simulation();
	static frame f = new frame();
	
	static long lastime = System.nanoTime();
	static long lf = System.nanoTime();
	static long tf = System.nanoTime();
	static final double ticks = 60;
	static double ns = 1000000000 / ticks;    
	static double delta = 0;
	static int fpsc=0;
	static int fps;
	static double ft;
	public static void main(String[] args)
	{
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setResizable(true);
		f.setSize(frame.getWIDTH(),frame.getHEIGHT());
		f.setVisible(true);
		f.setTitle("Terraminer-2.0");
		f.makestrat();
		while (true)
		{
			long now = System.nanoTime();
			delta-=(lastime-now)/ns;
			lastime = now;
			if(delta>=1) 
			{
				f.update();
				f.repaint();
				delta--;
				tf=System.nanoTime();
				fpsc+=1;
				if(tf-lf>1000000000)
				{
					lf=System.nanoTime();
					ft-=1000000000;
					fps=fpsc;
					fpsc=0;
					System.out.println("FPS: "+fps);
				}
			}
		}
	}
}
