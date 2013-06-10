package com.me.tetris.map;

import com.badlogic.gdx.graphics.Color;

public class Tile {
	private int x;
	private int y;
	
	private int width;
	private int height;
	
	private boolean occupied;
	
	private Color color;
	
	public Tile(int x, int y, int width, int height) {
		this.x = x;
		this.y =y;
		
		this.width = width;
		this.height = height;
		
		this.occupied = false;
		
		this.color = Color.WHITE;
	}
	
	public Tile(int x, int y) {
		this.x = x;
		this.y =y;
		
		this.occupied = false;
		
		this.color = Color.WHITE;
	}
	
	public Tile(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y =y;
		
		this.width = width;
		this.height = height;
		
		this.occupied = true;
		
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	
}
