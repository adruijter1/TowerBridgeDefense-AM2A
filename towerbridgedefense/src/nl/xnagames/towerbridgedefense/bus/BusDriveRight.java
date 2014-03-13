package nl.xnagames.towerbridgedefense.bus;

import com.badlogic.gdx.Gdx;
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
		this.effect = true;
		this.velocity = new Vector2(bus.getSpeed(), 0);
	}
		
		
	// Update method
	public void update(float delta)
	{
		if ( this.bus.getPosition().x > Gdx.graphics.getWidth() + 300)
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
