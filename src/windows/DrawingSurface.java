package windows;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Sprites.Enemy;
import Sprites.Player;
import Sprites.Treasure;
import displays.MainDisplay;
import javafx.scene.shape.Line;
import processing.core.PApplet;

public class DrawingSurface extends PApplet{
	
	private MainDisplay display;
	private Player player; 
	private int direction; //none = 0, right = 1, left = 2
	private boolean keyPressed ;
	
	//INITIALIZE ALL VARIABLES
	public DrawingSurface() {
		display = new MainDisplay(0, 0, 700, 500, Color.white);
		player = new Player(650,450,50,50,"sprites/player.png");
		player.setGround(100);
		keyPressed = false;
		direction = 1;
	}
	
	//FRAMES
	public void setup() {
		frameRate(30);
	}

	//DRAW ALL COMPONENTS HERE
	public void draw() {
		display.draw(this);
		player.draw(this);
		
		
//		ArrayList<Line> platforms = display.getPlatforms();
//		for(Line l:platforms) {
//			if(player.isOnPlatform((float)l.getStartX(), (float)l.getStartY(), (int)(l.getEndX()-l.getStartX()))) {
//				player.setGround((float)l.getStartY());
//				break;
//			}
//			player.setGround(500);
//		}
//		
	
		
		//Check intersections
		ArrayList<Line>  platforms = display.getPlatforms();
		for(Line l: platforms) {
			if(player.isOnPlatform((float)(l.getStartX()), (float)(l.getStartY()), (int)(l.getEndX()-l.getStartX()))) {
				player.setGround((float)l.getStartY());
				break;
			}
			player.setGround(500);
		}
		boolean isTouching = false;
		ArrayList<Enemy> enemies = display.getEnemies();
		for(Enemy e: enemies) {
			if(player.isIntersecting(e)) {
				System.out.println("DEAD");
				isTouching = true;
			}
		}
		Treasure t = display.getTreasure();
		if(player.isIntersecting(t)) {
			System.out.println("YOU WIN");
			isTouching = true;
		}
		if(!isTouching) {
			//Y direction moving
			player.moveY();
			//X direction moving
			if(direction == 1 && keyPressed) player.moveX(10);
			else if(direction == 2 && keyPressed) player.moveX(-10);
		}
			
		
	}
	
	//USER INTERACTION
	public void keyPressed() {
		if(keyCode == KeyEvent.VK_LEFT) {
			//player.moveX(-10);
			direction = 2;
			player.setDirection(2);
			keyPressed = true;
		}
		else if(keyCode == KeyEvent.VK_RIGHT) {
			//player.moveX(10);
			direction = 1;
			player.setDirection(1);
			keyPressed = true;
		}
		else if(keyCode == KeyEvent.VK_SPACE) {
			player.jump(15);
		}
	}
	
	public void keyReleased() {
		if(keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT) {
			keyPressed = false;
		}
	}
	
	public void mousePressed() {
		
	}
}
