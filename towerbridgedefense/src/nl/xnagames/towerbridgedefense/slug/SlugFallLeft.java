package nl.xnagames.towerbridgedefense.slug;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;

import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;

public class SlugFallLeft extends AnimatedSprite
{
	// Fields
	private Slug slug;
	private int init_h, init_k, h, k;
	private float start_x, start_y, a;
	
	// Properties
	
	// Constructor
	// h geeft de x-waarde van de symmetrie-as en k is de hoogte die bereikt wordt
	// voor x = h.
	public SlugFallLeft(Slug slug, int h, int k)
	{
		super(slug);
		this.slug = slug;
		this.init_h = h;
		this.init_k = k;		
		this.Initialize();
		
	}
	
	// Initialize
	public void Initialize()
	{
		for ( AtlasRegion region : this.slug.getRegion())
		{
			if (!region.isFlipX())
			{
				region.flip(true, false);
			}
		}
		this.frameSpeed = 2f/60f;
		this.start_x = slug.getPosition().x;
		this.start_y = slug.getPosition().y;
		this.h = (int)(this.start_x + this.init_h);
		this.k = (int)(this.start_y + this.init_k);
		this.calculateA();
	}
	
	private void calculateA()
	{
		this.a = (this.start_y - this.k)/(float)Math.pow((this.start_x - this.h), 2d);
	}
	
	// Update
	public void update(float delta)
	{		
		float x = this.slug.getPosition().x -  2 * this.slug.getSpeed();
		float y = this.a * (float)Math.pow((x - this.h), 2d) + this.k;
		
		if ( y < 100f)
		{
			this.slug.setPosition(new Vector2(x, 100f));		
			this.slug.setState(this.slug.getWalkLeft());
		}
		else
		{	
			this.slug.setPosition(new Vector2(x, y));	
		}
		super.update(delta);
	}
	
	
	// Draw
	public void draw(float delta)
	{
		super.draw(delta);
	}
}
