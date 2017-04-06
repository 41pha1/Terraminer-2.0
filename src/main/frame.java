package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


public class frame extends JFrame {
	private static final long serialVersionUID = 1L;
	private BufferStrategy strat;
	private GeneralPath path = new GeneralPath();
	private BufferedImage img=new BufferedImage(25,25,BufferedImage.TYPE_INT_RGB);
	double zoom =1;
	double zoomX=1;
	public static int WIDTH;
	public static int HEIGHT;
	
	
	public frame() {
		WIDTH=1000;
		HEIGHT=600;
		addKeyListener(new keyboard());
		addMouseListener(new keyboard());
		addMouseMotionListener(new keyboard());
		addMouseWheelListener(new keyboard());
		
		setLayout(new BorderLayout());
		
	}
	public void makestrat()
	{
		createBufferStrategy(2);
		strat= getBufferStrategy();
	}
	
	public static int getWIDTH() {
		return WIDTH;
	}

	public static void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	public static int getHEIGHT() {
		return HEIGHT;
	}

	public static void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}
	public void repaint()
	{
		Graphics g=strat.getDrawGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 20000, 20000);
		draw(g);
//		drawFunction(g);
		g.dispose();
		strat.show();
	}

	
	public void draw(Graphics g) 
	{
		simulation.draw(g);
	}
	public void drawFunction(Graphics g) 
	{
//		int min=-7500;
//		int max=7500;
//		if(keyboard.getSa()!=0)
//		{
//			System.out.println(zoom+" lol");
//			zoom+=zoom*zoom*1/zoom*(keyboard.getSa()/10);
//		}
//		keyboard.setSa(0);
//		if(keyboard.isPlus())
//		{
//			zoomX/=0.1;
//		}
//		if(keyboard.isMinus())
//		{
//			zoomX*=0.1;
//		}
//	for(int x=min; x<max; x++)
//		{
//			
//			
//			double formular= 
			/*--------------*/	
//					x
//					Math.sin(x);
//					Math.sin(Math.toRadians(x))
//					-1*(x+1000)*(x-300)
//					Math.tan(Math.toDegrees(x));
//					Math.tan(x);
//					Math.tan(Math.random())
//					Math.pow(x, 4);
//					(Math.sin(Math.toRadians(x))/(2*((Math.pow(x, x)-(Math.PI/2)))/Math.PI))*(Math.sin(Math.toRadians(x))/(2*((Math.pow(x, x)-(Math.PI/2)))/Math.PI))
//					Math.cos(Math.toRadians(26*x))
					
					
			/*--------------*/		
					;
			
			
//			double rx=x, ry=formular;
//			double t=formular, r=x;
//			boolean polar=false;
//			
//			if(polar)
//			{
//				System.out.println(ry+", "+rx);
//				rx=Math.tan(Math.toRadians(t))*r;
//				ry=r;
//				
//			}
//			double dx=((rx*(zoomX)+7500)/20);
//			
//			double y=ry*zoom;
//			double dy=-1*(y+min)/20;
//			
//			g.setColor(Color.BLACK);
					Graphics2D g2d = (Graphics2D) g;
					
			g.drawLine(375, 0, 375, 750);
			g.drawLine(0, 375, 750, 375);
//			g.fillRect((int) dx,(int) dy,4,4);
			
			double dt = Math.PI / 180;
	        int w = getWidth() / 2;
	        int h = getHeight() / 2;
	        
	        path.reset();
	        path.moveTo(w, h);
	        
	        for (double t = 0; t < 2 * Math.PI; t += dt) {
	            double x = w * Math.sin(50 * t) + w;
	            double y = h * Math.sin(4 * t) + h;
	            path.lineTo(x, y);
	        }
	        
	        g2d.setColor(Color.blue);
	        g2d.draw(path);
	}

	public void update() {
		WIDTH=this.getWidth();
		HEIGHT=WIDTH/2;
		simulation.update();
	}
}
