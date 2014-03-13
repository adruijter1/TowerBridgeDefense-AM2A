package nl.xnagames.towerbridgedefense.bus;

import nl.xnagames.towerbridgedefense.TowerBridgeDefense;
import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;

public class Bus 
{
	// Fields
	private TowerBridgeDefense game;
	private AtlasRegion bus;
	private float scaleFactor;
	private float size;
	private BusDriveLeft driveLeft;
	private BusDriveRight driveRight;
	private AnimatedSprite state;
	private float speed = 2;
	private Vector2 position;
	
	// Properties
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
		return this.driveLeft;
	}
	public BusDriveRight getDriveRight()
	{
		return this.driveRight;
	}
	
	
	
	// Constructor
	public Bus(TowerBridgeDefense game, Vector2 position)
	{
		this.game = game;
		this.position = position;
		this.driveLeft = new BusDriveLeft(this);
		this.driveRight = new BusDriveRight(this);
		this.bus = game.getAtlas().findRegion("bus000" + Integer.toString(3));
		this.scaleFactor = (float)this.bus.getRegionHeight()/(float)this.bus.getRegionWidth();
		this.size = 192f;
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
		//this.game.getSpriteBatch().draw(this.bus, 200f, 400f, this.size/this.scaleFactor, this.size);
		this.state.draw(delta);
	}

}
