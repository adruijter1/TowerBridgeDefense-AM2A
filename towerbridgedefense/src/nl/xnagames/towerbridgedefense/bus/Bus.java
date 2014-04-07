package nl.xnagames.towerbridgedefense.bus;


import nl.xnagames.towerbridgedefense.TowerBridgeDefense;
import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;
import nl.xnagames.towerbridgedefense.animation.Animation;
import nl.xnagames.towerbridgedefense.particleengine.ParticleEngine;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Bus implements Animation
{
	// Fields
	private TowerBridgeDefense game;
	private AtlasRegion singleFrame;
	private float scaleFactor;
	private float size;
	private BusDriveLeft driveLeft;
	private BusDriveRight driveRight;
	private AnimatedSprite state;
	private float speed = 2;
	private Vector2 position;
	// HashMap koppelt een String aan een AtlasRegion
	private Array<AtlasRegion> region;
	private ParticleEngine exhaust;
	
	
	
	// Name van het plaatje op de TextureAtlas
	private String name;
	
	// Properties
	public String getName()
	{
		return this.name;
	}
	public TowerBridgeDefense getGame()
	{
		return this.game;
	}	
	public float getScaleFactor()
	{
		return this.scaleFactor;
	}	
	public float getSize()
	{
		return this.size;
	}
	public float getSpeed()
	{
		return this.speed;
	}
	public Vector2 getPosition()
	{
		return this.position;
	}
	public void setPosition(Vector2 position)
	{
		this.position = position;
	}
	public void setState(AnimatedSprite state)
	{
		this.state = state;
	}
	public BusDriveLeft getDriveLeft()
	{
		this.driveLeft.Initialize();
		return this.driveLeft;
	}
	public BusDriveRight getDriveRight()
	{
		this.driveRight.Initialize();
		return this.driveRight;
	}
	public Array<AtlasRegion> getRegion()
	{
		return this.region;
	}
	public ParticleEngine getExhaust()
	{
		return this.exhaust;
	}
	public void setParticleEngine(ParticleEngine exhaust)
	{
		this.exhaust = exhaust;
	}
	
	
	
	
	// Constructor
	public Bus(TowerBridgeDefense game, Vector2 position, String name)
	{
		this.game = game;
		this.position = position;
		this.name = name;
		
		this.exhaust = new ParticleEngine(game, this.position);
		
		// We maken een instantie van de HashMap die we koppelen aan this.region
		this.region = new Array<AtlasRegion>();		
			
		this.region = game.getAtlas().findRegions(name);
		
		this.driveLeft = new BusDriveLeft(this);
		this.driveRight = new BusDriveRight(this);
		this.singleFrame = this.region.first();
		this.scaleFactor = (float)this.singleFrame.getRegionHeight()/(float)this.singleFrame.getRegionWidth();
		this.size = 120f;		
		this.state = this.getDriveLeft();
	}
	
	// Update method
	public void update(float delta)
	{
		this.state.update(delta);
	}
	
	// Draw method
	public void draw(float delta)
	{
		this.state.draw(delta);
	}
}
