package nl.xnagames.towerbridgedefense.cab;

import java.util.HashMap;

import nl.xnagames.towerbridgedefense.TowerBridgeDefense;
import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;
import nl.xnagames.towerbridgedefense.animation.Animation;


import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;

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
	// HashMap koppelt een String aan een AtlasRegion
	private HashMap<String, AtlasRegion> region;
	
	// Name bevat de naam van het plaatje op de TextureAtlas
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
	public HashMap<String, AtlasRegion> getRegion()
	{
		return this.region;
	}
	
	
	
	// Constructor
	public Cab(TowerBridgeDefense game, Vector2 position, String name)
	{
		this.game = game;
		this.position = position;
		this.name = name;
		
		// We maken een instantie van de HashMap die we koppelen aan this.region
		this.region = new HashMap<String, AtlasRegion>();
		
		// We vullen de HashMap met de naam en region van elk frame
		for (int i = 1; i <= 7; i++)
		{
			this.region.put(game.getAtlas().findRegion(name + Integer.toString(i)).name,
							game.getAtlas().findRegion(name + Integer.toString(i)));
		}
		
		this.driveLeft = new CabDriveLeft(this);
		this.driveRight = new CabDriveRight(this);
		this.singleFrame = game.getAtlas().findRegion(name + Integer.toString(3));
		this.scaleFactor = (float)this.singleFrame.getRegionHeight()/(float)this.singleFrame.getRegionWidth();
		this.size = 140f;
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

