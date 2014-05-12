package nl.xnagames.towerbridgedefense.slug;

import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;

public class SlugWalkRight extends AnimatedSprite 
{
	// Fields
	private Slug slug;
	private Vector2 velocity;
	
	// Properties
		
	// Constructor
	public SlugWalkRight(Slug slug)
	{
		super(slug);
		this.slug = slug;
		this.velocity = new Vector2(slug.getSpeed(), 0);
		this.Initialize();
	}
	
	public void Initialize()
	{
		this.frameSpeed = 2/60f;
		for ( AtlasRegion region : this.slug.getRegion())
		{
			if (region.isFlipX())
			{
				region.flip(true, false);
			}
		}
	}		
		
	// Update method
	public void update(float delta)
	{
		/*
		if (!Gdx.input.isKeyPressed(Keys.RIGHT))
		{
			//this.slug.setState(this.beanman.getIdleRight());
		}
		else
		*/
		if (Gdx.input.isKeyPressed(Keys.R))
		{
			this.slug.setState(this.slug.getFallRight());   
		}
		this.slug.setPosition(this.slug.getPosition().add(this.velocity));
		super.update(delta);
	}
			
	// Draw method
	public void draw(float delta)
	{
		super.draw(delta);
	}


}
