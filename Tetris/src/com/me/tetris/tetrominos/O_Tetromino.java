package com.me.tetris.tetrominos;

import com.badlogic.gdx.graphics.Color;
import com.me.tetris.map.TetrominoGrid;

public class O_Tetromino extends Tetromino {

	public O_Tetromino() {
		this.setInitialGrid();
	}
	
	@Override
	protected void setInitialGrid() {
		this.color = Color.CYAN;
		this.grid = new TetrominoGrid(2, 2);
		
		this.grid.getTileAt(0, 0).setOccupied(true);
		this.grid.getTileAt(0, 0).setColor(this.color);
		
		this.grid.getTileAt(1, 0).setOccupied(true);
		this.grid.getTileAt(1, 0).setColor(this.color);
		
		this.grid.getTileAt(0, 1).setOccupied(true);
		this.grid.getTileAt(0, 1).setColor(this.color);
		
		this.grid.getTileAt(1, 1).setOccupied(true);
		this.grid.getTileAt(1, 1).setColor(this.color);
	}
}
