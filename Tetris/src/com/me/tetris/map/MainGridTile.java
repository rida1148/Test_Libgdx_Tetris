package com.me.tetris.map;

public class MainGridTile extends Tile {
	
	private int xValue;
	private int yValue;
	
	private int width;
	private int height;

	public MainGridTile(int x, int y, int xValue, int yValue, int width, int height) {
		super(x, y);
		
		this.xValue = xValue;
		this.yValue = yValue;
		
		this.width = width;
		this.height = height;
	}
	
	public int getxValue() {
		return xValue;
	}
	
	public void setxValue(int xValue) {
		this.xValue = xValue;
	}
	
	public int getyValue() {
		return yValue;
	}
	
	public void setyValue(int yValue) {
		this.yValue = yValue;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
