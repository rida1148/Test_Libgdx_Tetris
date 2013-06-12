package com.me.tetris.map;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.me.tetris.tetrominos.Tetromino;

public class MainGrid extends Grid {
	private int tilesWidth;
	private int tilesHeight;
	
	public MainGrid(int width, int height, int tilesWidth, int tilesHeight) {
		super(width, height);
		
		this.tilesWidth = tilesWidth;
		this.tilesHeight = tilesHeight;
		
		this.arrayTiles = new MainGridTile[this.width][];//new Array<Array<Tile>>(this.width);
		for(int i = 0; i < this.width; i++) {
			Tile[] newArray = new MainGridTile[height];
			
			for(int j = 0; j < this.height; j++) {
				newArray[j] =  new MainGridTile(i, j, i*tilesWidth, j*tilesHeight, tilesWidth, tilesHeight);
			}
			
			this.arrayTiles[i] = newArray;
		}
	}
	
	public void draw(ShapeRenderer sr) {
		sr.begin(ShapeType.FilledRectangle);
		
		MainGridTile mgt;
		for(int i = 0; i < this.width; i++) {
	    	for(int j = 0; j < this.height; j++) {
	    		mgt = (MainGridTile)this.arrayTiles[i][j];
	    		
	    		sr.setColor(mgt.getColor());
	    		sr.filledRect(mgt.getxValue(), mgt.getyValue(), mgt.getWidth(), mgt.getHeight());
	    	}
	    }
		
		sr.end();
	}
	
	public void drawTetromino(ShapeRenderer sr, Tetromino t) {
		sr.begin(ShapeType.FilledRectangle);
		
		TetrominoTile tt;
		MainGridTile mgt;
		for(int i = 0; i < t.getGrid().getWidth(); i++) {
			for(int j = 0; j < t.getGrid().getHeight(); j++) {
				tt = (TetrominoTile)t.getGrid().getTileAt(i, j);
				
				if(tt.isOccupied()) {
					mgt = (MainGridTile)this.getTileAt(t.getCurrentXPosition() + i, t.getCurrentYPosition() + j);
					
					if(mgt != null) {
						sr.setColor(tt.getColor());
		    			sr.filledRect(mgt.getxValue(), mgt.getyValue(), mgt.getWidth(), mgt.getHeight());
					}
				}
			}
		}
		
		sr.end();
	}
	
	public boolean isATetrominoTrespassingTheTopOfTheScreen(Tetromino t) {
		TetrominoTile tt;
		MainGridTile mgt;
		for(int i = 0; i < t.getGrid().getWidth(); i++) {
			for(int j = 0; j < t.getGrid().getHeight(); j++) {
				tt = (TetrominoTile)t.getGrid().getTileAt(i, j);
				
				if(tt.isOccupied()) {
					mgt = (MainGridTile)this.getTileAt(t.getCurrentXPosition() + i, t.getCurrentYPosition() + j);
					
					if(mgt == null) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean canATetrominoGoDown(Tetromino t) {
		TetrominoTile tt;
		MainGridTile mgt;
		for(int i = 0; i < t.getGrid().getWidth(); i++) {
			for(int j = 0; j < t.getGrid().getHeight(); j++) {
				tt = (TetrominoTile)t.getGrid().getTileAt(i, j);
				
				if(tt.isOccupied()) {
					mgt = (MainGridTile)this.getTileAt(t.getCurrentXPosition() + i, t.getCurrentYPosition() + j - 1);
					
					if(mgt != null) {
						if(mgt.isOccupied()) {
							return false;
						}
					} else {
						if(t.getCurrentYPosition() + j - 1 >= 0)
							return true;
						else
							return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public boolean canATetrominoGoLeft(Tetromino t) {
		TetrominoTile tt;
		MainGridTile mgt;
		for(int i = 0; i < t.getGrid().getWidth(); i++) {
			for(int j = 0; j < t.getGrid().getHeight(); j++) {
				tt = (TetrominoTile)t.getGrid().getTileAt(i, j);
				
				if(tt.isOccupied()) {
					mgt = (MainGridTile)this.getTileAt(t.getCurrentXPosition() + i - 1, t.getCurrentYPosition() + j);
					
					if(mgt != null) {
						if(mgt.isOccupied()) {
							return false;
						}
					} else {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public boolean canATetrominoGoRight(Tetromino t) {
		TetrominoTile tt;
		MainGridTile mgt;
		for(int i = 0; i < t.getGrid().getWidth(); i++) {
			for(int j = 0; j < t.getGrid().getHeight(); j++) {
				tt = (TetrominoTile)t.getGrid().getTileAt(i, j);
				
				if(tt.isOccupied()) {
					mgt = (MainGridTile)this.getTileAt(t.getCurrentXPosition() + i + 1, t.getCurrentYPosition() + j);
					
					if(mgt != null) {
						if(mgt.isOccupied()) {
							return false;
						}
					} else {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public void putATetrominoInsideTheGrid(Tetromino t) {
		TetrominoTile tt;
		MainGridTile mgt;
		for(int i = 0; i < t.getGrid().getWidth(); i++) {
			for(int j = 0; j < t.getGrid().getHeight(); j++) {
				tt = (TetrominoTile)t.getGrid().getTileAt(i, j);
				
				if(tt.isOccupied()) {
					mgt = (MainGridTile)this.getTileAt(t.getCurrentXPosition() + i + 1, t.getCurrentYPosition() + j);
					
					mgt.setOccupied(true);
					mgt.setColor(tt.getColor());
				}
			}
		}
	}
	
	public int getTilesWidth() {
		return tilesWidth;
	}

	public int getTilesHeight() {
		return tilesHeight;
	}
}
