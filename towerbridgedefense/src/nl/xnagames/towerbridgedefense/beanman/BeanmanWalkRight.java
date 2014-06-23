package nl.xnagames.towerbridgedefense.beanman;

import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;
import nl.xnagames.towerbridgedefense.rocket.Rocket;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;

public class BeanmanWalkRight extends AnimatedSprite 
{
	// Fields
	private Beanman beanman;
	private Vector2 velocity;
	private float regionWidth, canvasWidth;
	private boolean ks, oks = false;
	
	// Properties
		
	// Constructor
	public BeanmanWalkRight(Beanman beanman)
	{
		super(beanman);
		this.beanman = beanman;
		this.velocity = new Vector2(beanman.getSpeed(), 0);
		this.regionWidth = 1920f; 
		this.canvasWidth = (float)Gdx.graphics.getWidth();
		this.Initialize();
	}
	
	public void Initialize()
	{
		this.frameSpeed = 1f/120f;
		for ( AtlasRegion region : this.beanman.getRegion())
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
		ks = Gdx.input.isKeyPressed(Keys.R);
		if (!Gdx.input.isKeyPressed(Keys.RIGHT))
		{
			this.beanman.setState(this.beanman.getIdleRight());
		}
		else if (Gdx.input.isKeyPressed(Keys.SPACE))
		{
			this.beanman.setState(this.beanman.getJumpRight());   
		}
		this.beanman.setPosition(this.beanman.getPosition().add(this.velocity));
		if ( this.beanman.getPosition().x > 0.1f * this.regionWidth) 
		{
			if (this.beanman.getCam().position.x < this.regionWidth - this.canvasWidth/2)
			{
				this.beanman.getCam().translate(this.velocity);
				this.beanman.getCam().update();
			}
		}
		if (this.ks && !this.oks)
		{
			this.beanman.getRocketList().add(new Rocket(this.beanman.getGame(),
											 this.beanman.getOffsetRight(),
											 this.beanman.getPosition(),
											 this.beanman.getGame().getAtlas().findRegion("part_rocket")));
		}
		
		for (Rocket rocket : this.beanman.getRocketList())
		{
			rocket.update(delta);
		}
		
		oks = ks;
		super.update(delta);
	}
			
	// Draw method
	public void draw(float delta)
	{
		super.draw(delta);
		for (Rocket rocket : this.beanman.getRocketList())
		{
			rocket.draw(delta);
		}
		
	}


}
