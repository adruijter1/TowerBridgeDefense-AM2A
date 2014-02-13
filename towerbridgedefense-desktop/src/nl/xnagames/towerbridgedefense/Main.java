package nl.xnagames.towerbridgedefense;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "TowerBridge Defense";
		cfg.useGL20 = true;
		cfg.width = 1024;
		cfg.height = 600;
		
		new LwjglApplication(new TowerBridgeDefense(), cfg);
	}
}
