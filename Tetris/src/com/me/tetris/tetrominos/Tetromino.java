package com.me.tetris.tetrominos;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.me.tetris.map.TetrominoGrid;
import com.me.tetris.map.Tile;

public class Tetromino {

	protected TetrominoGrid grid;
	protected Color color;
	
	public enum RotationDirection {RIGHT, LEFT};
	public enum CurrentRotationPosition {NORMAL, RIGHT, REVERSED, LEFT};
	public enum ListTetrominosTypes {O, I, T, L, J, S, Z}
	
	private int currentXPosition;
	private int currentYPosition;
	
	public int getCurrentXPosition() {
		return currentXPosition;
	}

	public void setCurrentXPosition(int currentXPosition) {
		this.currentXPosition = currentXPosition;
	}

	public int getCurrentYPosition() {
		return currentYPosition;
	}

	public void setCurrentYPosition(int currentYPosition) {
		this.currentYPosition = currentYPosition;
	}

	public TetrominoGrid getGrid() {
		return grid;
	}

	public Color getColor() {
		return color;
	}
	
	public static Tetromino getARandomTetrominoInstance() {
		int value = MathUtils.random(ListTetrominosTypes.class.getEnumConstants().length - 1);
		ListTetrominosTypes type = ListTetrominosTypes.class.getEnumConstants()[value];
		
		switch(type) {
			case O: return new O_Tetromino();
			case I: return new I_Tetromino();
			case T: return new T_Tetromino();
			case L: return new L_Tetromino();
			case J: return new J_Tetromino();
			case S: return new S_Tetromino();
			case Z: return new Z_Tetromino();
			default: return null;
		}
	}

	private CurrentRotationPosition CurrentRotation = CurrentRotationPosition.NORMAL;

	protected void setInitialGrid() {
		//To override
	}
	
	public void goDown() {
		this.currentYPosition--;
	}
	
	public void rotateGrid(RotationDirection rd) {
		TetrominoGrid newGrid = new TetrominoGrid(this.grid.getHeight(), this.grid.getWidth());
		
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
