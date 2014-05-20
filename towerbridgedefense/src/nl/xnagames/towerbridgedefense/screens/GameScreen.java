package nl.xnagames.towerbridgedefense.screens;

import nl.xnagames.towerbridgedefense.TowerBridgeDefense;
import nl.xnagames.towerbridgedefense.beanman.Beanman;
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
	private float ratio, yzoom = 1080;
	private Beanman beanman;
	
	
	// Properties
	
	
	
	// Constructor
	public GameScreen(TowerBridgeDefense game)
	{
		this.game = game;
		this.texture = new Texture(Gdx.files.internal("data/achtergrond.png"));
		this.textureRegion = new TextureRegion(this.texture,0,0, 1920, 1080);
		this.background = new Image(this.game, Vector2.Zero, this.textureRegion);
		this.ratio = (float)Gdx.graphics.getWidth()/(float)Gdx.graphics.getHeight();
		this.cam = new OrthographicCamera();
		this.beanman = new Beanman(this.game, new Vector2(this.ratio * this.yzoom/4, this.yzoom/2), "beanman", this.cam);		
		this.cam.setToOrtho(false, this.ratio * this.yzoom, this.yzoom);
		this.cam.position.set(this.ratio * this.yzoom/2, this.yzoom/2, 0);
		this.cam.update();
	
	}
	
	
	
	@Override
	public void render(float delta) 
	{	
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		this.beanman.update(delta);
		

		this.cam.translate(Vector2.Zero);
		this.cam.update();
		this.game.getSpriteBatch().setProjectionMatrix(this.cam.combined);
		this.game.getSpriteBatch().begin();
		this.background.draw(delta);
		this.beanman.draw(delta);
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
