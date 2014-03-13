package nl.xnagames.towerbridgedefense.bus;

import com.badlogic.gdx.Gdx;
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
		
		
	// Update method
	public void update(float delta)
	{
		if ( this.bus.getPosition().x < -300)
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
