package com.me.tetris.tetrominos;

import com.badlogic.gdx.graphics.Color;
import com.me.tetris.map.Grid;

public class L_Tetromino extends Tetromino {
	public L_Tetromino() {
		this.setInitialGrid();
	}
	
	@Override
	protected void setInitialGrid() {
		this.color = Color.GREEN;
		this.grid = new Grid(2, 3);
		
		this.grid.getTileAt(0, 0).setOccupied(true);
		this.grid.getTileAt(0, 0).setColor(this.color);
		
		this.grid.getTileAt(1, 0).setOccupied(true);
		this.grid.getTileAt(1, 0).setColor(this.color);
		
		this.grid.getTileAt(0, 1).setOccupied(true);
		this.grid.getTileAt(0, 1).setColor(this.color);
		
		this.grid.getTileAt(0, 2).setOccupied(true);
		this.grid.getTileAt(0, 2).setColor(this.color);
	}
}