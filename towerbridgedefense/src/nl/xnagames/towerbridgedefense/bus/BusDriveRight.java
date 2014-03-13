package nl.xnagames.towerbridgedefense.bus;

import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;

public class BusDriveRight extends AnimatedSprite
{
	// Fields
	private Bus bus;
	
	// Properties
		
	// Constructor
	public BusDriveRight(Bus bus)
	{
		super(bus);
		this.bus = bus;
		this.effect = true;
	}
		
		
	// Update method
	public void update(float delta)
	{
		super.update(delta);
	}
			
	// Draw method
	public void draw(float delta)
	{
		super.draw(delta);
	}

}
