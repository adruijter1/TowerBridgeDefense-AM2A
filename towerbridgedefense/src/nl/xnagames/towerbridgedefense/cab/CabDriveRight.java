package nl.xnagames.towerbridgedefense.cab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;

import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;

public class CabDriveRight extends AnimatedSprite
{
	// Fields
	private Cab cab;
	private Vector2 velocity;
	private Vector2 offset;
	
	
	// Properties
		
	// Constructor
	public CabDriveRight(Cab cab)
	{
		super(cab);
		this.cab = cab;
		this.velocity = new Vector2(cab.getSpeed(), 0);
		this.offset = new Vector2(-130f,-100f);
		this.Initialize();
	}
	
	public void Initialize()
	{		
		for ( AtlasRegion region : this.cab.getRegion())
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
		if ( this.cab.getPosition().x > Gdx.graphics.getWidth() - 100)
		{
			this.cab.setState(this.cab.getDriveLeft());
		}
		this.cab.setPosition(this.cab.getPosition().add(this.velocity));
		this.cab.getExhaust().setEmitterPosition(new Vector2(this.cab.getPosition().x + this.offset.x,
															 this.cab.getPosition().y + this.offset.y));
		this.cab.getExhaust().update(delta);
		super.update(delta);
	}
			
	// Draw method
	public void draw(float delta)
	{
		super.draw(delta);
		this.cab.getExhaust().draw(delta);
	}

}
