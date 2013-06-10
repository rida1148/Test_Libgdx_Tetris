package com.me.tetris.tetrominos;

import com.badlogic.gdx.graphics.Color;
import com.me.tetris.map.Grid;

public class I_Tetromino extends Tetromino {
	public I_Tetromino() {
		this.setInitialGrid();
	}
	
	@Override
	protected void setInitialGrid() {
		this.color = Color.BLACK;
		this.grid = new Grid(1, 4);
		
		this.grid.getTileAt(0, 0).setOccupied(true);
		this.grid.getTileAt(0, 0).setColor(this.color);
		
		this.grid.getTileAt(0, 1).setOccupied(true);
		this.grid.getTileAt(0, 1).setColor(this.color);
		
		this.grid.getTileAt(0, 2).setOccupied(true);
		this.grid.getTileAt(0, 2).setColor(this.color);
		
		this.grid.getTileAt(0, 3).setOccupied(true);
		this.grid.getTileAt(0, 3).setColor(this.color);
	}
}
