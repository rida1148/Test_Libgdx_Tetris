package com.me.tetris.map;

public class TetrominoGrid extends Grid {
	public TetrominoGrid(int width, int height) {
		super(width, height);
		
		this.arrayTiles = new TetrominoTile[this.width][];
		for(int i = 0; i < this.width; i++) {
			TetrominoTile[] newArray = new TetrominoTile[height];
			
			for(int j = 0; j < this.height; j++) {
				newArray[j] =  new TetrominoTile(i, j);
			}
			
			this.arrayTiles[i] = newArray;
		}
	}
}
