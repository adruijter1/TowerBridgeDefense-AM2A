package nl.xnagames.towerbridgedefense.screens;

import nl.xnagames.towerbridgedefense.TowerBridgeDefense;
import nl.xnagames.towerbridgedefense.beanman.Beanman;
import nl.xnagames.towerbridgedefense.image.Image;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameScreen implements Screen
{
	
	// Fields
	private TowerBridgeDefense game;
	private Image background;
	private Texture texture;
	private TextureRegion textureRegion;
	private OrthographicCamera cam;
	private Beanman beanman;	
	private Rectangle glViewport;
	private float canvasWidth;
	private float canvasHeight;
	
	
	// Properties
	public float getCanvasWidth()
	{
		return this.canvasWidth;
	}
	
	public float getCanvasHeight()
	{
		return this.canvasHeight;
	}
	
	public TextureRegion getTextureRegion()
	{
		return this.textureRegion;
	}
	
	
	
	
	// Constructor
	public GameScreen(TowerBridgeDefense game)
	{
		this.game = game;
		this.texture = new Texture(Gdx.files.internal("data/achtergrond.png"));
		this.textureRegion = new TextureRegion(this.texture,0,0, 1920, 1080);
		this.background = new Image(this.game, Vector2.Zero, this.textureRegion);
		this.canvasWidth = (float)Gdx.graphics.getWidth();
		this.canvasHeight = (float)Gdx.graphics.getHeight();
		this.cam = new OrthographicCamera(this.canvasWidth, this.canvasHeight);
		this.beanman = new Beanman(this.game, new Vector2(this.canvasWidth/2, this.canvasHeight/2), "beanman", this.cam);	
		this.cam.position.set(this.canvasWidth/2, this.canvasHeight/2, 0);
		this.glViewport = new Rectangle(0,
										0,
										this.canvasWidth,
										this.canvasHeight);
		this.cam.update();
	
	}
	
	
	
	@Override
	public void render(float delta) 
	{	
		Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glViewport((int)this.glViewport.x,
						  (int)this.glViewport.y,
						  (int)this.glViewport.getWidth(),
						  (int)this.glViewport.getHeight());
		this.beanman.update(delta);
		
		if ( Gdx.input.isKeyPressed(Keys.A))
		{
			this.cam.translate(-2f, 0f, 0f);
		}
		if ( Gdx.input.isKeyPressed(Keys.D))
		{
			this.cam.translate(2f, 0f, 0f);
		}
		if ( Gdx.input.isKeyPressed(Keys.W))
		{
			this.cam.translate(0f, 2f, 0f);
		}
		if ( Gdx.input.isKeyPressed(Keys.S))
		{
			this.cam.translate(0f, -2f, 0f);
		}
		if ( Gdx.input.isKeyPressed(Keys.O))
		{
			if (this.glViewport.getHeight() < 800)
			{
				this.cam.zoom += 0.01;
				Gdx.app.log("glviewport", Float.toString(this.cam.zoom));
			}
			//this.cam.position.set(this.getCanvasWidth()/2, this.getCanvasHeight()/2, 0f);
		}
		if ( Gdx.input.isKeyPressed(Keys.I))
		{
			this.cam.zoom -= 0.01;
			//this.cam.position.set(this.getCanvasWidth()/2, this.getCanvasHeight()/2, 0f);
		}
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
