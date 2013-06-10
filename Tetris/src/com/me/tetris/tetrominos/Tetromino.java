package com.me.tetris.tetrominos;

import com.badlogic.gdx.graphics.Color;
import com.me.tetris.map.Grid;
import com.me.tetris.map.Tile;

public class Tetromino {

	protected Grid grid;
	protected Color color;
	
	public static enum RotationDirection {RIGHT, LEFT};
	public static enum CurrentRotationPosition {NORMAL, RIGHT, REVERSED, LEFT};
	public static enum ListTetrominosTypes {O, I, T, L, J, S, Z};
	
	private CurrentRotationPosition CurrentRotation = CurrentRotationPosition.NORMAL;

	protected void setInitialGrid() {
		//To override
	}
	
	public void rotateGrid(RotationDirection rd) {
		Grid newGrid = new Grid(this.grid.getHeight(), this.grid.getWidth(), this.grid.getTilesWidth(), this.grid.getTilesHeight());
		
		//Put the setOccupied tiles and the colors
		Tile inspectedTile;
		for(int i = 0; i < this.grid.getWidth(); i++) {
			for(int j = 0; j < this.grid.getHeight(); j++) {
				inspectedTile = this.grid.getTileAt(i, j);
				
				if(inspectedTile.isOccupied()) {
					int newX;
					int newY;
					
					if(rd == RotationDirection.RIGHT) {
						newX = inspectedTile.getY();
						newY = this.grid.getWidth() - 1 - inspectedTile.getX();
					} else {
						newX = this.grid.getHeight() - 1 - inspectedTile.getY();
						newY = inspectedTile.getX();
					}
					
					newGrid.getTileAt(newX, newY).setOccupied(true);
					newGrid.getTileAt(newX, newY).setColor(this.color);
				}
			}
		}
		
		//Change the CurrentRotationPosition
		switch(this.CurrentRotation) {
		case NORMAL: 
			if(rd == RotationDirection.RIGHT) {
				this.CurrentRotation = CurrentRotationPosition.RIGHT;
			} else {
				this.CurrentRotation = CurrentRotationPosition.LEFT;
			}
			break;
		case RIGHT:
			if(rd == RotationDirection.RIGHT) {
				this.CurrentRotation = CurrentRotationPosition.REVERSED;
			} else {
				this.CurrentRotation = CurrentRotationPosition.NORMAL;
			}
			break;
		case REVERSED:
			if(rd == RotationDirection.RIGHT) {
				this.CurrentRotation = CurrentRotationPosition.LEFT;
			} else {
				this.CurrentRotation = CurrentRotationPosition.RIGHT;
			}
			break;
		case LEFT:
			if(rd == RotationDirection.RIGHT) {
				this.CurrentRotation = CurrentRotationPosition.NORMAL;
			} else {
				this.CurrentRotation = CurrentRotationPosition.REVERSED;
			}
			break;
		}
		
		
		this.grid = newGrid;
	}
}
