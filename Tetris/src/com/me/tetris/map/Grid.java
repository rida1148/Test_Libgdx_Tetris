package com.me.tetris.map;

public class Grid {
	protected int width;
	protected int height;
	
	protected Tile[][] arrayTiles;
	
	
	
	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public Tile getTileAt(int x, int y) {
		try {
		return this.arrayTiles[x][y];
		} catch(ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Tile[][] getArrayTiles() {
		return arrayTiles;
	}
}
