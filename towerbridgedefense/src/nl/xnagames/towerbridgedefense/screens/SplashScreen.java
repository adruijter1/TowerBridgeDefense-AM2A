package nl.xnagames.towerbridgedefense.screens;

import nl.xnagames.towerbridgedefense.TowerBridgeDefense;
import nl.xnagames.towerbridgedefense.beanman.Beanman;
import nl.xnagames.towerbridgedefense.bus.Bus;
import nl.xnagames.towerbridgedefense.cab.Cab;
import nl.xnagames.towerbridgedefense.entity.Entity;
import nl.xnagames.towerbridgedefense.particleengine.ParticleEngine;
import nl.xnagames.towerbridgedefense.particleengine.SlugEmitter;
import nl.xnagames.towerbridgedefense.swan.Swan;
import nl.xnagames.towerbridgedefense.transparancy.Transparancy;
import nl.xnagames.towerbridgedefense.slug.Slug;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
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
	//private Music towerBell;
	
	// Maak een variabele voor het maken van een object van de class transparancy
	private Transparancy transparancyTB, transparancyD;
	
	// Maak een variabele aan die een businstantie kan bevatten
	private Bus bus;
	
	// Maak een variabele aan die een cabinstantie kan bevatten
	private Cab cab;
	
	// Maak een variabele aan die een swaninstantie kan bevatten
	private Swan swan;
		
	// Maak een variabele aan die een swaninstantie kan bevatten
	private Entity swan1;
	
	// Maak een variabele aan die een swaninstantie kan bevatten
	private Entity bus1;
	
	// Maak een variabele aan die een swaninstantie kan bevatten
	private Entity medic;
	// Properties
	
	// Maak een object aan van het gegevenstype particleEngine
	private ParticleEngine particleEngine;
	
	// Beanman object
	private Beanman beanman;
	
	// Slug object
	private Slug slug;
	
	// SlugEmitter
	private SlugEmitter slugEmitter;
	
	
	
	// Constructor
	public SplashScreen(TowerBridgeDefense game)
	{
		this.game = game;
		
		// Maak een music object
		
		
		
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
		this.bus = new Bus(this.game, new Vector2(0f, 200f), "bus");
		
		// Maak een instantie aan van de bus
		this.cab = new Cab(this.game, new Vector2(400f, 200f), "cab");
		
		// Maak een instantie aan van de swan
		this.swan = new Swan(this.game, new Vector2(400f, 400f), "swan", 10f/60f);
		
		// Maak een instantie aan van de swan
		this.swan1 = new Entity(this.game, new Vector2(200f, 400f), "swan", 10f/60f, 100f);
		
		// Maak een instantie aan van de bus
		this.bus1 = new Entity(this.game, new Vector2(200f, 200f), "bus", 2f/60f, 120f);
		
		this.medic = new Entity(this.game, new Vector2(300f, 300f), "parachute-medic", 5f/60f, 200f);
	
		this.particleEngine = new ParticleEngine(game, new Vector2(200f, 300f));
		
		// Maak een object van de beanman
		this.beanman = new Beanman(game, new Vector2(100f, 100f), "beanman", null);
		
		// Maak een object van de slug
		this.slug = new Slug(this.game, new Vector2(100f, 150f), "slug");
		
		// Maak een slugEmitter object aan
		this.slugEmitter = new SlugEmitter(this.game, new Vector2(500f, 600f));
	}
	
	
	@Override
	public void render(float delta)
	{
		Gdx.gl.glClearColor(0.06f, 0.06f, 0.06f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		this.transparancyTB.Update();
		this.transparancyD.Update();
		
		// Door het indrukken van de spatiebalk ga je naar de gameScreen toestand
		if ( Gdx.input.isKeyPressed(Keys.SPACE) || Gdx.input.isTouched())
		{
			//this.game.setScreen(this.game.getGameScreen());			
		}
		
		this.bus.update(delta);
		this.cab.update(delta);
		this.swan.update(delta);
		this.swan1.update(delta);
		this.bus1.update(delta);
		this.medic.update(delta);
		this.beanman.update(delta);
		this.slug.update(delta);
		this.slugEmitter.update(delta);
		
		
		
		this.particleEngine.update(delta);
		
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
		
		// Teken de swan instantie		
		this.swan.draw(delta);
		
		// Teken de swan instantie		
		this.swan1.draw(delta);
		
		// Teken de swan instantie		
		this.bus1.draw(delta);
		
		// Teken de swan instantie		
		this.medic.draw(delta);
		
		this.particleEngine.draw(delta);
		
		// Teken beanman
		this.beanman.draw(delta);
		
		// Teken de slug
		this.slug.draw(delta);
		
		// Teken de slugEmitter
		this.slugEmitter.draw(delta);
		
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
		this.game.TowerBell().play();
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
