package displays;
import java.util.ArrayList;

import javafx.scene.shape.Line;
import java.awt.Color;
import processing.core.PApplet;

public class MainDisplay {
	private double x, y, width, height;
	private Color fillColor;
	private int r,g,b;
	private ArrayList<Line> platforms;
	
	public MainDisplay(double x, double y, double width, double height, Color fillColor) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.fillColor = fillColor;
		this.r = fillColor.getRed();
		this.g = fillColor.getGreen();
		this.b = fillColor.getBlue();
		
		platforms = new ArrayList<Line>();
		platforms.add(new Line(0,100,100,100));
		platforms.add(new Line(200,200,300,200));
	}
	
	public void draw(PApplet papp){
		papp.background(r,g,b);
		
		papp.strokeWeight(5);
		
		for(Line l: platforms) {
			this.drawPlatform(papp, (float)l.getStartX(), (float)l.getStartY(), (int)(l.getEndX()-l.getStartX()));
		}
		
	}
	
	//Alternative line drawing using angles and lengths
	public void drawLine(PApplet papp, float x, float y, double degree, int length) {
		double topX, topY;
		degree *= Math.PI/180;
		topX = x + length*Math.cos(degree);
		topY = y - length*Math.sin(degree);

		papp.line(x, y, (float)topX, (float)topY);
	}
	
	public void drawPlatform(PApplet papp, float x, float y, int length) {
		drawLine(papp, x, y, 0, length);
	}
	public ArrayList<Line> getPlatforms(){
		return platforms;
	}
	public double getwidth() {
		return width;
	}
	public double getheight() {
		return height;
	}
	public float getx() {
		return (float)x;
	}
	public float gety() {
		return (float)y;
	}
	public int getRed() {
		return r;
	}
	public int getBlue() {
		return b;
	}
	public int getGreen() {
		return g;
	}
}
