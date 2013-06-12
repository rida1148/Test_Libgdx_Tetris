package com.me.tetris.tetrominos;

import com.badlogic.gdx.graphics.Color;
import com.me.tetris.map.TetrominoGrid;

public class J_Tetromino extends Tetromino {
	public J_Tetromino() {
		this.setInitialGrid();
	}
	
	@Override
	protected void setInitialGrid() {
		this.color = Color.ORANGE;
		this.grid = new TetrominoGrid(2, 3);
		
		this.grid.getTileAt(0, 0).setOccupied(true);
		this.grid.getTileAt(0, 0).setColor(this.color);
		
		this.grid.getTileAt(1, 0).setOccupied(true);
		this.grid.getTileAt(1, 0).setColor(this.color);
		
		this.grid.getTileAt(1, 1).setOccupied(true);
		this.grid.getTileAt(1, 1).setColor(this.color);
		
		this.grid.getTileAt(1, 2).setOccupied(true);
		this.grid.getTileAt(1, 2).setColor(this.color);
	}
}
