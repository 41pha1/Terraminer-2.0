package main;

import java.awt.Graphics;

public class entity {
	static player p = new player();
	
	public static void draw(Graphics g) {
		player.draw(g);
	}
}
