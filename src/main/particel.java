package main;

import java.awt.Color;
import java.awt.Graphics;

public class particel 
{
	public boolean alive;
	public boolean gravity=true;
	public double speedX=1.1;
	public double speed=10;
	public double speedY=1.1;
	public void create(int ID, int x1, int y1)
	{
		if(ID==1)
		{
			setAlive(true);
			setC(simulation.blocks[x1][y1].getRandomTextureColor());
			setVelocityX((Math.random()-0.5)*2);
			setVelocityY((Math.random()-0.5)*2);
			setX(x1+Math.random());
			setY(y1+Math.random());
			setSize((int)(Math.random()*7)+5);
			setGeneration((int)(Math.random()*50));
		}
		if(ID==2)
		{
			setAlive(true);
			setC(simulation.blocks[x1][y1].getRandomTextureColor());
			setVelocityX((Math.random()-0.5)*2);
			setVelocityY((Math.random()-0.5)*2);
			setX(x1+Math.random());
			setY(y1+Math.random());
			setSize((int)(Math.random()*2)+3);
			setGeneration((int)(Math.random()*50));
		}
		if(ID==3)
		{
			setAlive(true);
			setC(simulation.blocks[x1][y1].getRandomTextureColor());
			setVelocityX((Math.random()-0.5)*2);
			setVelocityY((Math.random()-0.5)*2);
			setX(x1+Math.random());
			setY(y1+Math.random());
			setSize((int)(Math.random()*15)+5);
			setGravity(false);
			setGeneration((int)(Math.random()*50));
		}
		if(ID==4)
		{
			setAlive(true);
			setC(simulation.blocks[x1][y1].getRandomTextureColor());
			setVelocityX((Math.random()-0.5)*4);
			setVelocityY((Math.random()-0.5)*4);
			setX(x1+Math.random());
			setY(y1+Math.random());
			setSize((int)(Math.random()*7)+5);
			setGravity(false);
			setSpeedX(1);
			setSpeedY(1);
			setGeneration((int)(Math.random()*50));
		}
		if(ID==5)
		{
			setAlive(true);
			setC(simulation.blocks[x1][y1].getRandomTextureColor());
			setVelocityX((Math.random()-0.5)*2);
			setVelocityY((Math.random()-1)*8);
			setX(x1+Math.random());
			setY(y1+Math.random());
			setSize((int)(Math.random()*5)+5);
			setGravity(false);
			setSpeedY(0.5);
			setGeneration((int)(Math.random()*50));
		}
		if(ID==6)
		{
			setAlive(true);
			setC(simulation.blocks[x1][y1].getRandomTextureColor());
			setVelocityX((Math.random()-0.5)/4);
			setVelocityY(((Math.random()-1)));
			setX(x1+0.5);
			setY(y1+0.5);
			setSize((int)(Math.random()*15)+5);
			setGravity(true);
			setSpeed(1.2);
			
			setSpeedX(1.05);
			setGeneration((int)(Math.random()*50));
		}
		if(ID==7)
		{
			setAlive(true);
			setC(simulation.blocks[x1][y1].getRandomTextureColor());
			setVelocityX((Math.random()-0.5)/2);
			setVelocityY(((Math.random()-1)*16));
			setX(x1+Math.random());
			setY(y1+Math.random());
			setSize((int)(Math.random()*15)+5);
			setGravity(false);
			setSpeedY(0.5);
			setSpeedX(0.5);
			setGeneration((int)(Math.random()*50));
		}
		if(ID==8)
		{
			setAlive(true);
			setC(simulation.blocks[x1][y1].getRandomTextureColor());
			setVelocityX((Math.random()-0.5)/8);
			setVelocityY(((Math.random()-0.5)/8));
			setX(x1+Math.random());
			setY(y1+Math.random());
			setSize((int)(Math.random()*15)+5);
			setGravity(false);
			setSpeedY(0.9);
			setSpeedX(0.9);
			setGeneration((int)(Math.random()*50));
		}
		if(ID==9)
		{
			setAlive(true);
			setC(simulation.blocks[x1][y1].getTextureColor());
			setVelocityX((Math.random()-0.5)*2);
			setVelocityY((Math.random()-0.5)*2);
			setX(x1+Math.random());
			setY(y1+Math.random());
			setSize((int)(Math.random()*15)+5);
			setGravity(false);
			setGeneration((int)(Math.random()*50));
		}
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getSpeedX() {
		return speedX;
	}
	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}
	public double getSpeedY() {
		return speedY;
	}
	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}
	public boolean isGravity() {
		return gravity;
	}
	public void setGravity(boolean gravity) {
		this.gravity = gravity;
	}
	public Color c;
	public double xpos, ypos;
	public double size;
	public int generation;
	public int getGeneration() {
		return generation;
	}
	public void setGeneration(int generation) {
		this.generation = generation;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}
	public double getX() {
		return xpos;
	}
	public void setX(double d) {
		this.xpos = d;
	}
	public double getY() {
		return ypos;
	}
	public void setY(double d) {
		this.ypos = d;
	}
	public double getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public double getAccelarationY() {
		return accelarationY;
	}
	public void setAccelarationY(double accelarationY) {
		this.accelarationY = accelarationY;
	}
	public double getAccelarationX() {
		return accelarationX;
	}
	public void setAccelarationX(double accelarationX) {
		this.accelarationX = accelarationX;
	}
	public double getVelocityY() {
		return velocityY;
	}
	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}
	public double getVelocityX() {
		return velocityX;
	}
	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}
	public double accelarationY, accelarationX;
	public double velocityY, velocityX;
	public void update()
	{
		if (generation>100)alive=false;
		velocityX/=speedX;
		velocityY/=speedY;
		xpos+=velocityX/speed;
		ypos+=velocityY/speed;
		if(gravity)
		{
			ypos+=simulation.speed;
		}
		generation+=1;
	}
	public void draw(Graphics g)
	{
		double px,py;
		if(player.getPx()>0){
			px=0;
		}else px= player.getPx();
		if(player.getPy()<-246){
			py=-246;
		}else py= player.getPy();
		
		g.setColor(c);
		g.fillRect((int)((xpos*frame.getWIDTH()/block.getSize())+px*frame.getWIDTH()/block.getSize()), (int)((ypos*frame.getWIDTH()/block.getSize())+py*frame.getWIDTH()/block.getSize()), (int)(size/1000*frame.getWIDTH()), (int)(size/1000*frame.getWIDTH()));
		
	}
}
