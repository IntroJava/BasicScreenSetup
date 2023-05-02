package Sprites;
import displays.MainDisplay;
import processing.core.PApplet;

public class Player extends Sprite{

	private float yVelocity;
	private final int GRAVITY_CONSTANT;
	
	public Player(float x, float y, double width, double height, String img) {
		super(x, y, width, height, img);
		// TODO Auto-generated constructor stub
		yVelocity = 0;
		GRAVITY_CONSTANT = 2;
	}
	
	public void moveX(int distance) {
		this.setx(this.getx()+ distance);
	}
	
	public void jump(int velocity) {
		this.yVelocity += velocity;
	}
	
	public void moveY() { //constantly running
		if(yVelocity != 0 || this.gety() != this.getGround()) { //if moving
			this.sety(this.gety() - yVelocity);
			gravity();
		}		
	}
	
	private void gravity() {
		if(this.gety() + this.getheight() <= this.getGround()) //if on or above ground
			yVelocity -= GRAVITY_CONSTANT;
		else if(this.gety() + this.getheight() > this.getGround()) {
			this.sety((float)(this.getGround() - this.getheight()));
			yVelocity = 0;
		}
	}
}