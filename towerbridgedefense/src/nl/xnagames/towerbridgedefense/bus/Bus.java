package nl.xnagames.towerbridgedefense.bus;

import nl.xnagames.towerbridgedefense.TowerBridgeDefense;
import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class Bus 
{
	// Fields
	private TowerBridgeDefense game;
	private AtlasRegion bus;
	private float scaleFactor;
	private float size;
	private BusDriveLeft driveLeft;
	private AnimatedSprite state;
	
	// Properties
	public TowerBridgeDefense getGame()
	{
		return this.game;
	}
	
	
	
	// Constructor
	public Bus(TowerBridgeDefense game)
	{
		this.game = game;
		this.driveLeft = new BusDriveLeft(this);
		this.bus = game.getAtlas().findRegion("bus000" + Integer.toString(3));
		this.scaleFactor = (float)this.bus.getRegionHeight()/(float)this.bus.getRegionWidth();
		this.size = 192f;
		this.state = this.driveLeft;
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
