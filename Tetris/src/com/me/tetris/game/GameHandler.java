package com.me.tetris.game;

import com.me.tetris.Tetris;
import com.me.tetris.tetrominos.Tetromino;

public class GameHandler {
	
	private Tetris tetris;
	
	private boolean stop;
	
	public GameHandler(Tetris tetris) {
		this.tetris = tetris;
		
		this.stop = false;
		
		this.createNewTetromino();
		
		new Thread(new Runnable() 
	    { 
	      public void run() 
	      { 
	    	  while(!isStopped()) {
		          mainLoop();
		          try {
		        	  Thread.sleep(100);
		          } catch(Exception e) {
		        	  
		          }
	    	  }
	      } 
	    }).start();
	}
	
	public boolean isStopped() {
		return this.stop;
	}
	
	private void mainLoop() {
		//Can the tetromino go down ?
		if(this.tetris.getMainGrid().canATetrominoGoDown(this.tetris.getTetromino())) {
			//Yes -> go down
			this.tetris.getTetromino().goDown();
		} else {
			//No -> Stop it 
			
			//if the tetromino is stopped outside the screen, stop the game
			if(this.tetris.getMainGrid().isATetrominoTrespassingTheTopOfTheScreen(this.tetris.getTetromino())) {
				//GAME OVER
				this.stop = true;
			} else {
				//else stop it(put it inside the MainGrid), create a new Tetromino over the screen and start the loop again
				//Put the Tetromino in the MainGrid
				this.tetris.getMainGrid().putATetrominoInsideTheGrid(this.tetris.getTetromino());
				
				//Create a new Tetromino
				this.createNewTetromino();
				
				this.mainLoop();
			}
		}
		
		
	}
	
	public void createNewTetromino(){
		this.tetris.setTetromino(Tetromino.getARandomTetrominoInstance());
		this.tetris.getTetromino().setCurrentXPosition(this.tetris.getMainGrid().getWidth()/2);
		this.tetris.getTetromino().setCurrentYPosition(this.tetris.getMainGrid().getHeight());
	}
}
