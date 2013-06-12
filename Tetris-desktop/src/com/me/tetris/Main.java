package com.me.tetris;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Tetris";
		cfg.width = 400;
		cfg.height = 800;
		
		new LwjglApplication(new Tetris(), cfg);
	}
}
