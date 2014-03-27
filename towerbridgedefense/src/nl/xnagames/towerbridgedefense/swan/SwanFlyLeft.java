package nl.xnagames.towerbridgedefense.swan;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;

import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;

public class SwanFlyLeft extends AnimatedSprite
{
	// Fields
	private Swan swan;
	private Vector2 velocity;
	
	// Properties
		
	// Constructor
	public SwanFlyLeft(Swan swan)
	{
		super(swan);
		this.swan = swan;
		this.velocity = new Vector2(-swan.getSpeed(), 0f);
		this.frameSpeed = swan.getFrameSpeed();
	}
	
	public void Initialize()
	{
		for ( AtlasRegion region : this.swan.getRegion())
		{
			if ( region.isFlipX())
			{
				region.flip(true, false);
			}
		}
	}
		
		
	// Update method
	public void update(float delta)
	{
		if ( this.swan.getPosition().x < -200)
		{
			this.swan.setState(this.swan.getFlyRight());
		}
		this.swan.setPosition(this.swan.getPosition().add(this.velocity));
		super.update(delta);
	}
			
	// Draw method
	public void draw(float delta)
	{
		super.draw(delta);
	}
}
