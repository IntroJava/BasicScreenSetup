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
	
	//x = x0 + vt + 0.5at^2
	public void moveY() { //constantly running
		if(yVelocity != 0) { //if moving
			this.sety(this.gety() - yVelocity);
			gravity();
		}		
	}
	
	//vx = vx0 + at
	private void gravity() {
		if(this.gety() <= this.getGround()) //if on or above ground
			yVelocity -= GRAVITY_CONSTANT;
		else if(this.gety() > this.getGround()) {
			this.sety(this.getGround());
			yVelocity = 0;
		}
	}
}