package nl.xnagames.towerbridgedefense.bus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;

import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;

public class BusDriveRight extends AnimatedSprite
{
	// Fields
	private Bus bus;
	private Vector2 velocity;
	
	// Properties
		
	// Constructor
	public BusDriveRight(Bus bus)
	{
		super(bus);
		this.bus = bus;
		this.velocity = new Vector2(bus.getSpeed(), 0);
		this.Initialize();
	}
	
	public void Initialize()
	{
		for ( AtlasRegion region : this.bus.getRegion())
		{
			if (!region.isFlipX())
			{
				region.flip(true, false);
			}
		}		
		/*
		for (int i = 1; i <= 7; i++)
		{
			if (!this.bus.getRegion().get(this.bus.getName() + Integer.toString(i)).isFlipX())
			{
				this.bus.getRegion().get(this.bus.getName() + Integer.toString(i)).flip(true, false);
			}
		}*/
	}		
		
	// Update method
	public void update(float delta)
	{
		if ( this.bus.getPosition().x > Gdx.graphics.getWidth() - 300)
		{
			this.bus.setState(this.bus.getDriveLeft());
		}
		this.bus.setPosition(this.bus.getPosition().add(this.velocity));
		super.update(delta);
	}
			
	// Draw method
	public void draw(float delta)
	{
		super.draw(delta);
	}

}
