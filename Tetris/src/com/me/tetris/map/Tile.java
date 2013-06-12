package com.me.tetris.map;

import com.badlogic.gdx.graphics.Color;

public class Tile {
	protected int x;
	protected int y;
	
	protected boolean occupied;
	
	protected Color color;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y =y;
		
		this.occupied = false;
		
		this.color = Color.WHITE;
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
}
