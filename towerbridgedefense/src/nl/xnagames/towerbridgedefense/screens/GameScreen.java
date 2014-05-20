package nl.xnagames.towerbridgedefense.screens;

import nl.xnagames.towerbridgedefense.TowerBridgeDefense;
import nl.xnagames.towerbridgedefense.image.Image;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class GameScreen implements Screen
{
	// Fields
	private TowerBridgeDefense game;
	private Image background;
	private Texture texture;
	private TextureRegion textureRegion;
	private OrthographicCamera cam;
	
	// Properties
	
	
	
	// Constructor
	public GameScreen(TowerBridgeDefense game)
	{
		this.game = game;
		this.texture = new Texture(Gdx.files.internal("data/achtergrond.png"));
		this.textureRegion = new TextureRegion(this.texture,0,0, 1920, 1080);
		this.background = new Image(this.game, Vector2.Zero, this.textureRegion);
		this.cam = new OrthographicCamera();
		this.cam.setToOrtho(false, 1920*2, 1080*2);
		this.cam.position.set(810, 200, 0);
		this.cam.update();
	
	}
	
	
	
	@Override
	public void render(float delta) 
	{	
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		this.game.getSpriteBatch().setProjectionMatrix(this.cam.combined);
		this.game.getSpriteBatch().begin();
		this.background.draw(delta);
		this.game.getSpriteBatch().end();
	}

	@Override
	public void resize(int width, int height)
	{		
	}

	@Override
	public void show() 
	{		
	}

	@Override
	public void hide() 
	{		
	}

	@Override
	public void pause()
	{		
	}

	@Override
	public void resume() 
	{		
	}

	@Override
	public void dispose() 
	{		
	}
}
