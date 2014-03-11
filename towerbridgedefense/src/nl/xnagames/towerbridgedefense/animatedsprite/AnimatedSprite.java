package nl.xnagames.towerbridgedefense.animatedsprite;

import nl.xnagames.towerbridgedefense.bus.Bus;

public class AnimatedSprite
{
	// Fields
	private Bus bus;
	private float timer = 0;
	private int frame = 0;
	
	// Properties
	
	// Constructor
	public AnimatedSprite(Bus bus)
	{
		this.bus = bus;
	}
	
	
	// Update method
	public void update(float delta)
	{
		this.timer += delta;
		if (this.timer > 5f/60f)
		{
			this.frame++;
			this.timer = 0;
			if ( this.frame > 7)
			{
				this.frame = 0;
			}
		}
	}
	
	
	// Draw method
	public void draw(float delta)
	{
		this.bus.getGame().getSpriteBatch().
			draw(this.bus.getGame().getAtlas().findRegion("bus000" + Integer.toString(this.frame)),
				 200f, 
				 400f);
	}	
}
