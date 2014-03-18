package nl.xnagames.towerbridgedefense.bus;

import com.badlogic.gdx.math.Vector2;

import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;

public class BusDriveLeft extends AnimatedSprite
{
	// Fields
	private Bus bus;
	private Vector2 velocity;
	
	// Properties
		
	// Constructor
	public BusDriveLeft(Bus bus)
	{
		super(bus);
		this.bus = bus;
		this.velocity = new Vector2(-bus.getSpeed(), 0f);
	}
	
	public void Initialize()
	{
		for (int i = 1; i <= 7; i++)
		{
			if (this.bus.getRegion().get("bus000" + Integer.toString(i)).isFlipX())
			{
				this.bus.getRegion().get("bus000" + Integer.toString(i)).flip(true, false);
			}
		}
	}
		
		
	// Update method
	public void update(float delta)
	{
		if ( this.bus.getPosition().x < 100)
		{
			this.bus.setState(this.bus.getDriveRight());
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
