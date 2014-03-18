package nl.xnagames.towerbridgedefense.cab;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;

public class CabDriveRight extends AnimatedSprite
{
	// Fields
	private Cab cab;
	private Vector2 velocity;
	
	// Properties
		
	// Constructor
	public CabDriveRight(Cab cab)
	{
		super(cab);
		this.cab = cab;
		this.velocity = new Vector2(cab.getSpeed(), 0);
		this.Initialize();
	}
	
	public void Initialize()
	{
		for (int i = 1; i <= 7; i++)
		{
			if (!this.cab.getRegion().get(this.cab.getName() + Integer.toString(i)).isFlipX())
			{
				this.cab.getRegion().get(this.cab.getName() + Integer.toString(i)).flip(true, false);
			}
		}
	}		
		
	// Update method
	public void update(float delta)
	{
		if ( this.cab.getPosition().x > Gdx.graphics.getWidth() - 300)
		{
			this.cab.setState(this.cab.getDriveLeft());
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
