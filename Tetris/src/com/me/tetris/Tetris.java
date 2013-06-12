package com.me.tetris;


import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.me.tetris.game.GameHandler;
import com.me.tetris.map.MainGrid;
import com.me.tetris.tetrominos.O_Tetromino;
import com.me.tetris.tetrominos.Tetromino;

public class Tetris implements ApplicationListener {
	private MainGrid mainGrid;
	private Tetromino tetromino;
	
	private GameHandler gh;
	
	private final int applicationWidth = 400;
	private final int applicationHeight = 800;
	
	private final int rectanglesWidth = 40;
	private final int rectanglesHeight = 40;
	
	private final int numberRectanglesWidth = 10;
	private final int numberRectanglesHeight = 20;
	
	private ShapeRenderer shapeRenderer;
	
	OrthographicCamera camera;
	
	@Override
	public void create() {
		camera = new OrthographicCamera();
	    camera.setToOrtho(false, 400, 800);
	    
	    shapeRenderer = new ShapeRenderer();
	    
	    mainGrid = new MainGrid(numberRectanglesWidth, numberRectanglesHeight, rectanglesWidth, rectanglesHeight);
	    
	    gh = new GameHandler(this);
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
	    Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	    
	    camera.update();
	    
	    shapeRenderer.setProjectionMatrix(camera.combined);
	    
	    mainGrid.draw(shapeRenderer);
	    
	    mainGrid.drawTetromino(shapeRenderer, tetromino);
	    
	}

	public MainGrid getMainGrid() {
		return mainGrid;
	}

	public Tetromino getTetromino() {
		return tetromino;
	}
	
	public void setTetromino(Tetromino tetromino) {
		this.tetromino = tetromino;
	}
	
	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
