package nl.xnagames.towerbridgedefense.animatedsprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import nl.xnagames.towerbridgedefense.bus.Bus;

public class AnimatedSprite
{
	// Fields
	private Bus bus;
	private float timer = 0;
	private int frame = 3;
	protected boolean effect =false;
	private TextureAtlas atlas;
	
	// Properties
	
	// Constructor
	public AnimatedSprite(Bus bus)
	{
		this.bus = bus;
		this.atlas = this.bus.getGame().getAtlas();
	}
	
	
	// Update method
	public void update(float delta)
	{
		this.timer += delta;
		if (this.timer > 2f/60f)
		{
			this.frame++;
			this.timer = 0;
			if ( this.frame > 7)
			{
				this.frame = 1;
			}
		}
	}
	
	
	// Draw method
	public void draw(float delta)
	{
		if ( this.effect && !this.atlas.findRegion("bus000" + Integer.toString(this.frame)).isFlipX())
		{
			this.atlas.findRegion("bus000" + Integer.toString(this.frame)).flip(true, false);
		}
		else
		{
			if (!this.effect && this.atlas.findRegion("bus000" + Integer.toString(this.frame)).isFlipX())
			{
				this.atlas.findRegion("bus000" + Integer.toString(this.frame)).flip(true, false);
			}
		}
		
		this.bus.getGame().getSpriteBatch().
			draw(this.atlas.findRegion("bus000" + Integer.toString(this.frame)),
				 this.bus.getPosition().x, 
				 this.bus.getPosition().y,
				 this.bus.getSize()/this.bus.getScaleFactor(),
				 this.bus.getSize());
	}	
}
