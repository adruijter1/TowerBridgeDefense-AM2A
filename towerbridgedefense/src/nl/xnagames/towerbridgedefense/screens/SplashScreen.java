package nl.xnagames.towerbridgedefense.screens;

import nl.xnagames.towerbridgedefense.TowerBridgeDefense;
import nl.xnagames.towerbridgedefense.bus.Bus;
import nl.xnagames.towerbridgedefense.cab.Cab;
import nl.xnagames.towerbridgedefense.transparancy.Transparancy;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;

public class SplashScreen implements Screen
{
	// Fields
	private TowerBridgeDefense game;
	
	// Bitmapfont die gegenereerd is met behulp van BMfont
	// en werkt voor alle platformen, dus ook voor HTML
	private BitmapFont font32, font120, font180;
	
	// BitmapGenerator voor Android en desktop project. Niet geschikt voor
	// Html project
	private FreeTypeFontGenerator generator;
	
	// Afspelen van een lange muziekfile doe je met een music object
	private Music towerBell;
	
	// Maak een variabele voor het maken van een object van de class transparancy
	private Transparancy transparancyTB, transparancyD;
	
	// Maak een variabele aan die een businstantie kan bevatten
	private Bus bus;
	
	// Maak een variabele aan die een cabinstantie kan bevatten
	private Cab cab;
		
	// Properties
	
	
	
	// Constructor
	public SplashScreen(TowerBridgeDefense game)
	{
		this.game = game;
		
		// Maak een music object
		this.towerBell = Gdx.audio.newMusic(Gdx.files.internal("music/tower_bell_clock.ogg"));
		this.towerBell.play();
		
		// Maak een freetypefontgenerator object
		this.generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/BradBunR.ttf"));
		
		// Maak nu met de generator je BitmapFonts
		this.font120 = this.generator.generateFont(120);
		
		// We maken nu met de generaor een object aan genaamd font200 met pixelgrootte 200
		this.font180 = this.generator.generateFont(180);
		
		this.generator.dispose();
		
		// We maken nu een object aan font32 genaamd
		this.font32 = new BitmapFont(Gdx.files.internal("fonts/tbd_bitmap.fnt"));
		
		// We maken een object aan van de class Transparancy
		this.transparancyTB = new Transparancy(0.5f, 0.5f, 3.9f, -0.1f);
		this.transparancyD = new Transparancy(0.5f, 0.5f, 3.9f, 0.1f);
		
		// Maak een instantie aan van de bus
		this.bus = new Bus(this.game, new Vector2(0f, 200f), "bus000");
		
		// Maak een instantie aan van de bus
		this.cab = new Cab(this.game, new Vector2(400f, 200f), "Cab000");
	}
	
	
	@Override
	public void render(float delta)
	{
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		this.transparancyTB.Update();
		this.transparancyD.Update();
		
		// Door het indrukken van de spatiebalk ga je naar de gameScreen toestand
		if ( Gdx.input.isKeyPressed(Keys.SPACE) || Gdx.input.isTouched())
		{
			//this.game.setScreen(this.game.getGameScreen());			
		}
		
		this.bus.update(delta);
		this.cab.update(delta);
		
		// Hier wordt de begin() method aangeroepen van de this.game.getSpriteBatch()
		// Alle draw methods moeten tussen de begin() en end() method zitten van 
		// this.game.getSpriteBatch()
		this.game.getSpriteBatch().begin();
		
		// Definieer eerst je tekst
		String text = "@leadprogrammer: Arjan de Ruijter";
		
		// Definieer de grootte van je standaard lettertype
		this.font32.setScale(0.4f);
		
		// Maak de kleur rood, zet de transparancy op 40%
		// this.font32.setColor(1f, 0f, 0f, 0.4f);
		
		this.font32.draw(this.game.getSpriteBatch(),
						 text, 
						 Gdx.graphics.getWidth()/2 - this.font32.getBounds(text).width/2,
						 100f);
		
		// Maak de tekst Tower Bridge
		String text180 = "Tower Bridge";
		this.font180.setColor(1f, 1f, 1f, this.transparancyTB.sinusWave());
		
		this.font180.draw(this.game.getSpriteBatch(),
						  text180,
						  Gdx.graphics.getWidth()/2 - this.font180.getBounds(text180).width/2,
						  Gdx.graphics.getHeight() * 2/3);
		String text120 = "Defense";
		this.font120.setColor(1f,  1f,  1f, this.transparancyD.sinusWave());
		this.font120.draw(this.game.getSpriteBatch(),
						  text120, 
						  Gdx.graphics.getWidth()/2 - this.font120.getBounds(text120).width/2,
						  Gdx.graphics.getHeight() * 2/3 - this.font180.getBounds(text180).height * 7/5);
		
		// Teken de bus instantie
		
		this.bus.draw(delta);
		
		// Teken de cab instantie
		
		this.cab.draw(delta);
		
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
		this.font120.dispose();
		this.font180.dispose();
		this.font32.dispose();		
	}
	
}
