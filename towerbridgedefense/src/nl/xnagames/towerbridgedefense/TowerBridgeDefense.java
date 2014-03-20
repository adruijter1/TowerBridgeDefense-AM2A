package nl.xnagames.towerbridgedefense;

import nl.xnagames.towerbridgedefense.screens.GameScreen;
import nl.xnagames.towerbridgedefense.screens.SplashScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class TowerBridgeDefense extends Game
{
	// Fields
	// Maak voor elke screen een variabele.
	private SplashScreen splashScreen;
	private GameScreen gameScreen;
	private SpriteBatch spriteBatch;
	private TextureAtlas atlas;
	
	// Properties
	public GameScreen getGameScreen()
	{
		return this.gameScreen;
	}
	
	public SpriteBatch getSpriteBatch()
	{
		return this.spriteBatch;
	}
	
	public TextureAtlas getAtlas()
	{
		return this.atlas;
	}
	
	
	
	@Override
	public void create() 
	{		
		// Maak een SpriteBatch object en ken deze toe aan de variabele spriteBatch
		this.spriteBatch = new SpriteBatch();
		
		// Maak een instantie van de TextureAtlas class
		this.atlas = new TextureAtlas(Gdx.files.internal("data/textureAtlas.pack"));
		
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
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
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
