package nl.xnagames.towerbridgedefense.swan;


import nl.xnagames.towerbridgedefense.TowerBridgeDefense;
import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;
import nl.xnagames.towerbridgedefense.animation.Animation;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Swan implements Animation
{
	// Fields
	private TowerBridgeDefense game;
	private AtlasRegion singleFrame;
	private float scaleFactor;
	private float size;
	private SwanFlyLeft flyLeft;
	private SwanFlyRight flyRight;
	private AnimatedSprite state;
	private float speed = 2;
	private float frameSpeed;
	private Vector2 position;
	// HashMap koppelt een String aan een AtlasRegion
	private Array<AtlasRegion> region;
	
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
	public float getFrameSpeed()
	{
		return this.frameSpeed;
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
	public SwanFlyLeft getFlyLeft()
	{
		this.flyLeft.Initialize();
		return this.flyLeft;
	}
	public SwanFlyRight getFlyRight()
	{
		this.flyRight.Initialize();
		return this.flyRight;
	}
	public Array<AtlasRegion> getRegion()
	{
		return this.region;
	}
	
	
	
	// Constructor
	public Swan(TowerBridgeDefense game, Vector2 position, String name, float frameSpeed)
	{
		this.game = game;
		this.position = position;
		this.name = name;
		this.frameSpeed = frameSpeed;
		
		// We maken een instantie van de HashMap die we koppelen aan this.region
		this.region = new Array<AtlasRegion>();		
			
		this.region = game.getAtlas().findRegions(name);
		
		this.flyLeft = new SwanFlyLeft(this);
		this.flyRight = new SwanFlyRight(this);
		this.singleFrame = this.region.first();
		this.scaleFactor = (float)this.singleFrame.getRegionHeight()/(float)this.singleFrame.getRegionWidth();
		this.size = 100f;
		this.state = this.flyRight;
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

