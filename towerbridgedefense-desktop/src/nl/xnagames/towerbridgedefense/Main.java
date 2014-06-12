package nl.xnagames.towerbridgedefense;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.initialBackgroundColor = Color.BLACK;
		cfg.title = "TowerBridge Defense";
		cfg.useGL20 = true;
		cfg.width = 800; //1024;
		cfg.height = 500; //600;
		cfg.addIcon("Icons/bus32x32.png", Files.FileType.Internal);	
		
		new LwjglApplication(new TowerBridgeDefense(), cfg);
	}
}
