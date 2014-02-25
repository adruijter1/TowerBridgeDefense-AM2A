package nl.xnagames.towerbridgedefense.screens;

import nl.xnagames.towerbridgedefense.TowerBridgeDefense;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class SplashScreen implements Screen
{
	// Fields
	private TowerBridgeDefense game;
	
	// Bitmapfont die gegenereerd is met behulp van BMfont
	// en werkt voor alle platformen, dus ook voor HTML
	private BitmapFont font32, font120, font200;
	
	// BitmapGenerator voor Android en desktop project. Niet geschikt voor
	// Html project
	private FreeTypeFontGenerator generator;
	
	// Properties
	
	
	
	// Constructor
	public SplashScreen(TowerBridgeDefense game)
	{
		this.game = game;
		
		// Maak een freetypefontgenerator object
		this.generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/BradBunR.ttf"));
		
		// Maak nu met de generator je BitmapFonts
		this.font120 = this.generator.generateFont(120);
		
		// We maken nu met de generaor een object aan genaamd font200 met pixelgrootte 200
		this.font200 = this.generator.generateFont(200);		
		
		// We maken nu een object aan font32 genaamd
		this.font32 = new BitmapFont(Gdx.files.internal("fonts/tbd_bitmap.fnt"));
		
	}
	
	
	@Override
	public void render(float delta)
	{
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		// Door het indrukken van de spatiebalk ga je naar de gameScreen toestand
		if ( Gdx.input.isKeyPressed(Keys.SPACE) || Gdx.input.isTouched())
		{
			this.game.setScreen(this.game.getGameScreen());			
		}
		
		// Hier wordt de begin() method aangeroepen van de this.game.getSpriteBatch()
		// Alle draw methods moeten tussen de begin() en end() method zitten van 
		// this.game.getSpriteBatch()
		this.game.getSpriteBatch().begin();
		
		// Definieer eerst je tekst
		String text = "@leadprogrammer: Arjan de Ruijter, Hans Odijk";
		
		// Definieer de grootte van je standaard lettertype
		this.font32.setScale(0.4f);
		
		// Maak de kleur rood, zet de transparancy op 40%
		// this.font32.setColor(1f, 0f, 0f, 0.4f);
		
		this.font32.draw(this.game.getSpriteBatch(),
						 text, 
						 Gdx.graphics.getWidth()/2 - this.font32.getBounds(text).width/2,
						 100f);
		
		this.font120.draw(this.game.getSpriteBatch(), "Het werkt", 500f, 400f);
		
		this.font200.draw(this.game.getSpriteBatch(), "Weer een test", 0f, 100f);
		
		//Hier wordt de end() method aangeroepen van this.game.getSpriteBatch()
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
