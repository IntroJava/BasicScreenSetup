package windows;
import java.awt.Color;

import displays.MainDisplay;
import processing.core.PApplet;

public class DrawingSurface extends PApplet{
	
	private MainDisplay display;
	
	//INITIALIZE ALL VARIABLES
	public DrawingSurface() {
		display = new MainDisplay(0, 0, 700, 500, Color.white);
	}
	
	//FRAMES
	public void setup() {
		frameRate(30);
	}

	//DRAW ALL COMPONENTS HERE
	public void draw() {
		display.draw(this);
	}
	
	
	//USER INTERACTION
	public void keyPressed() {
		
	}
	
	public void keyReleased() {
		
	}
	
	public void mousePressed() {
		
	}
}
