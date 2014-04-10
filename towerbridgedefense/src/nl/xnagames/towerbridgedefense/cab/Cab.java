package nl.xnagames.towerbridgedefense.cab;

import java.util.HashMap;

import nl.xnagames.towerbridgedefense.TowerBridgeDefense;
import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;
import nl.xnagames.towerbridgedefense.animation.Animation;
import nl.xnagames.towerbridgedefense.particleengine.ParticleEngine;


import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Cab implements Animation
{
	// Fields
	private TowerBridgeDefense game;
	private AtlasRegion singleFrame;
	private float scaleFactor;
	private float size;
	private CabDriveLeft driveLeft;
	private CabDriveRight driveRight;
	private AnimatedSprite state;
	private float speed = 3;
	private Vector2 position;
	private Array<AtlasRegion> region;
	private ParticleEngine exhaust;
	
	// Name bevat de naam van het plaatje op de TextureAtlas
	private String name;
	
	// Properties
	public ParticleEngine getExhaust()
	{
		return this.exhaust;
	}
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
	public CabDriveLeft getDriveLeft()
	{
		this.driveLeft.Initialize();
		return this.driveLeft;
	}
	public CabDriveRight getDriveRight()
	{
		this.driveRight.Initialize();
		return this.driveRight;
	}
	public Array<AtlasRegion> getRegion()
	{
		return this.region;
	}
	
	
	
	// Constructor
	public Cab(TowerBridgeDefense game, Vector2 position, String name)
	{
		this.game = game;
		this.position = position;
		this.name = name;
		
		this.exhaust = new ParticleEngine(game, this.position);
		
		// We maken een instantie van de HashMap die we koppelen aan this.region
		this.region = new Array<AtlasRegion>();
		
		this.region = game.getAtlas().findRegions(name);
		
		this.driveLeft = new CabDriveLeft(this);
		this.driveRight = new CabDriveRight(this);
		this.singleFrame = this.region.first();
		this.scaleFactor = (float)this.singleFrame.getRegionHeight()/(float)this.singleFrame.getRegionWidth();
		this.size = 100f;
		this.state = this.driveRight;
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

