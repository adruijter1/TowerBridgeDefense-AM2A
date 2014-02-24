package nl.xnagames.towerbridgedefense;

import nl.xnagames.towerbridgedefense.screens.GameScreen;
import nl.xnagames.towerbridgedefense.screens.SplashScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

public class TowerBridgeDefense extends Game
{
	// Fields
	// Maak voor elke screen een variabele.
	private SplashScreen splashScreen;
	private GameScreen gameScreen;
	
	// Properties
	public GameScreen getGameScreen()
	{
		return this.gameScreen;
	}
	
	
	@Override
	public void create() 
	{		
		// Ken aan iedere screen-variabele een instantie toe
		this.splashScreen = new SplashScreen(this);
		this.gameScreen = new GameScreen(this);
		
		// Maak een van de screens actief
		this.setScreen(this.splashScreen);
	}

	@Override
	public void dispose() 
	{
		super.dispose();
		this.splashScreen.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(0.84f, 0.19f, 0.19f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		super.render();
	}

	@Override
	public void resize(int width, int height) 
	{
		super.resize(width, height);
	}

	@Override
	public void pause() 
	{
		super.pause();
	}

	@Override
	public void resume() 
	{
		super.resume();
	}
}