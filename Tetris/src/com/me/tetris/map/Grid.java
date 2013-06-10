package com.me.tetris.map;

import com.badlogic.gdx.utils.Array;

public class Grid {
	private int width;
	private int height;
	
	private int tilesWidth;
	private int tilesHeight;
	
	private Array<Array<Tile>> arrayTiles;
	
	public Grid(int width, int height, int tilesWidth, int tilesHeight) {
		this.width = width;
		this.height = height;
		
		this.tilesWidth = tilesWidth;
		this.tilesHeight = tilesHeight;
		
		this.arrayTiles = new Array<Array<Tile>>(this.width);
		for(int i = 0; i < this.width; i++) {
			Array<Tile> newArray = new Array<Tile>(height);
			
			for(int j = 0; j < this.height; j++) {
				newArray.set(j, new Tile(i, j, this.tilesWidth, this.tilesHeight));
			}
			
			this.arrayTiles.set(i, newArray);
		}
	}
	
	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
		
		this.arrayTiles = new Array<Array<Tile>>(this.width);
		for(int i = 0; i < this.width; i++) {
			Array<Tile> newArray = new Array<Tile>(height);
			
			for(int j = 0; j < this.height; j++) {
				newArray.set(j, new Tile(i, j));
			}
			
			this.arrayTiles.set(i, newArray);
		}
	}
	
	public Tile getTileAt(int x, int y) {
		return this.arrayTiles.get(x).get(y);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getTilesWidth() {
		return tilesWidth;
	}

	public int getTilesHeight() {
		return tilesHeight;
	}

	public Array<Array<Tile>> getArrayTiles() {
		return arrayTiles;
	}
}
