package nl.xnagames.towerbridgedefense.cab;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;

import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;

public class CabDriveLeft extends AnimatedSprite
{
	// Fields
	private Cab cab;
	private Vector2 velocity;
	
	// Properties
		
	// Constructor
	public CabDriveLeft(Cab cab)
	{
		super(cab);
		this.cab = cab;
		this.velocity = new Vector2(-cab.getSpeed(), 0f);
		this.Initialize();
	}
	
	public void Initialize()
	{
		for (AtlasRegion region : this.cab.getRegion())
		{
			if (region.isFlipX())
			{
				region.flip(true, false);
			}
		}
	}
		
		
	// Update method
	public void update(float delta)
	{
		if ( this.cab.getPosition().x < 100)
		{
			this.cab.setState(this.cab.getDriveRight());
		}
		this.cab.setPosition(this.cab.getPosition().add(this.velocity));
		super.update(delta);
	}
			
	// Draw method
	public void draw(float delta)
	{
		super.draw(delta);
	}
}
