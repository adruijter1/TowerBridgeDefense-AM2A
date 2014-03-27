package nl.xnagames.towerbridgedefense.swan;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;

import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;

public class SwanFlyRight extends AnimatedSprite
{
	// Fields
	private Swan swan;
	private Vector2 velocity;
	
	// Properties
		
	// Constructor
	public SwanFlyRight(Swan swan)
	{
		super(swan);
		this.swan = swan;
		this.velocity = new Vector2(swan.getSpeed(), 0);
		this.frameSpeed = swan.getFrameSpeed();
		this.Initialize();
	}
	
	public void Initialize()
	{
		for ( AtlasRegion region : this.swan.getRegion())
		{
			if (!region.isFlipX())
			{
				region.flip(true, false);
			}
		}
	}		
		
	// Update method
	public void update(float delta)
	{
		if ( this.swan.getPosition().x > Gdx.graphics.getWidth() + 200)
		{
			this.swan.setState(this.swan.getFlyLeft());
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
