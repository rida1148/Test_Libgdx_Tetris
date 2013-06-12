package com.me.tetris.tetrominos;

import com.badlogic.gdx.graphics.Color;
import com.me.tetris.map.TetrominoGrid;

public class Z_Tetromino extends Tetromino {
	public Z_Tetromino() {
		this.setInitialGrid();
	}
	
	@Override
	protected void setInitialGrid() {
		this.color = Color.RED;
		this.grid = new TetrominoGrid(3, 2);
		
		this.grid.getTileAt(1, 0).setOccupied(true);
		this.grid.getTileAt(1, 0).setColor(this.color);
		
		this.grid.getTileAt(2, 0).setOccupied(true);
		this.grid.getTileAt(2, 0).setColor(this.color);
		
		this.grid.getTileAt(0, 1).setOccupied(true);
		this.grid.getTileAt(0, 1).setColor(this.color);
		
		this.grid.getTileAt(1, 1).setOccupied(true);
		this.grid.getTileAt(1, 1).setColor(this.color);
	}
}
