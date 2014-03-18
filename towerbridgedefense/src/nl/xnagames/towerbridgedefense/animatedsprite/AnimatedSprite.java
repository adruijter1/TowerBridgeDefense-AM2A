package nl.xnagames.towerbridgedefense.animatedsprite;

import nl.xnagames.towerbridgedefense.animation.Animation;

public class AnimatedSprite
{
	// Fields
	private Animation animation;
	private float timer = 0;
	private int frame = 1;
	
	// Properties
	
	// Constructor
	public AnimatedSprite(Animation animation)
	{
		this.animation = animation;
	}	
	
	// Update method
	public void update(float delta)
	{
		this.timer += delta;
		if (this.timer > 2f/60f)
		{
			this.frame++;
			this.timer = 0;
			if ( this.frame >= 7)
			{
				this.frame = 1;
			}
		}
	}	
	
	// Draw method
	public void draw(float delta)
	{
		this.animation.getGame().getSpriteBatch().
			draw(this.animation.getRegion().get(this.animation.getName() + Integer.toString(this.frame)),
				 this.animation.getPosition().x, 
				 this.animation.getPosition().y,
				 this.animation.getSize()/this.animation.getScaleFactor(),
				 this.animation.getSize());
	}	
}
