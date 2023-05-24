package Sprites;

public class Enemy extends Sprite{
	
	private int yVelocity;
	private int GRAVITY_CONSTANT;
	private boolean isTouched;
	
	public Enemy(float x, float y, double width, double height, String img) {
		super(x, y, width, height, img);
		yVelocity = 0;
		GRAVITY_CONSTANT = 2;
		isTouched = false;
		
		// TODO Auto-generated constructor stub
	}
	
	public void move(int speed) {
		if(this.getx() < 650) {
			this.setx(this.getx() + speed);
		}
		else {
			this.setx(650);
		}
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
	
	public void setTouched(boolean b) {
		isTouched = b;
	}
	public boolean getTouched() {
		return isTouched;
	}

}
