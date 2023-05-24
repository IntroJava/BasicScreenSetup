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
		if(this.getx() >= 0 && this.getx() + this.getwidth() <= 700) {
			this.setx(this.getx()+ distance);
		}
		else if (this.getx() < 0){
			this.setx(1);
		}
		else {
			this.setx(650);
		}
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
	
	public boolean isIntersecting(Enemy s) { //check for intersection between two sprites
		if(this.getx() <= s.getx() + 50 && this.getx() >= s.getx()) {
			if(this.gety() + 25 >= s.gety() && this.gety() + 25 <= s.gety() + 50) {
				s.setTouched(true); 
				return true;
			}
		}
		return false;
		
	}
	
	public boolean isIntersecting(Treasure s) { //check for intersection between two sprites
		if(this.getx() <= s.getx() + 50 && this.getx() >= s.getx()) {
			if(this.gety() + 25 >= s.gety() && this.gety() + 25 <= s.gety() + 50) {
				return true;
			}
		}
		return false;
		
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