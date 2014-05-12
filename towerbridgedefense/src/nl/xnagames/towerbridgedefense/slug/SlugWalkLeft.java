package nl.xnagames.towerbridgedefense.slug;

import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;

public class SlugWalkLeft extends AnimatedSprite 
{
	// Fields
	private Slug slug;
	private Vector2 velocity;
	
	// Properties
		
	// Constructor
	public SlugWalkLeft(Slug slug)
	{
		super(slug);
		this.slug = slug;
		this.velocity = new Vector2(-slug.getSpeed(), 0);
		this.Initialize();
	}
	
	public void Initialize()
	{
		this.frameSpeed = 2f/60f;
		for ( AtlasRegion region : this.slug.getRegion())
		{
			if (!region.isFlipX())
			{
				region.flip(true, false);
			}
		}
	}		
		
	// Update method
	public void update(float delta)
	{
		/*
		if (!Gdx.input.isKeyPressed(Keys.LEFT))
		{
			//this.beanman.setState(this.beanman.getIdleLeft());
		}
		else */
		if (Gdx.input.isKeyPressed(Keys.L))
		{
			this.slug.setState(this.slug.getFallLeft());   
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
