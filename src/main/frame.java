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
	public static int HEIGHT, RHEIGHT;
	
	
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
		g.dispose();
		strat.show();
	}
	public void draw(Graphics g) 
	{
		simulation.draw(g);
	}
	public void update() {
		WIDTH=this.getWidth();
		
		HEIGHT=WIDTH/2;
		RHEIGHT=this.getHeight();
		simulation.update();
	}
	public static int getRHEIGHT() {
		return RHEIGHT;
	}
	public static void setRHEIGHT(int rHEIGHT) {
		RHEIGHT = rHEIGHT;
	}
}
