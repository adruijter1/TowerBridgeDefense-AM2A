package nl.xnagames.towerbridgedefense.beanman;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;

public class BeanmanJumpLeft extends AnimatedSprite
{
	// Fields
	private Beanman beanman;
	private int init_h, init_k, h, k;
	private float start_x, start_y, a;
	private Vector2 translation;
	private float regionWidth, canvasWidth;
	
	// Properties
	
	// Constructor
	// h geeft de x-waarde van de symmetrie-as en k is de hoogte die bereikt wordt
	// voor x = h.
	public BeanmanJumpLeft(Beanman beanman, int h, int k)
	{
		super(beanman);
		this.beanman = beanman;
		this.frameSpeed = 1f/120f;
		this.init_h = h;
		this.init_k = k;
		this.translation = new Vector2(-this.beanman.getSpeed(), 0f);
		this.regionWidth = 1920f; //this.beanman.getGame().getGameScreen().getTextureRegion().getRegionWidth();
		this.canvasWidth = (float)Gdx.graphics.getWidth();
		this.Initialize();
		
	}
	
	// Initialize
	public void Initialize()
	{
		this.start_x = beanman.getPosition().x;
		this.start_y = beanman.getPosition().y;
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
		float x = this.beanman.getPosition().x - this.beanman.getSpeed();
		float y = this.a * (float)Math.pow((x - this.h), 2d) + this.k;
		
		if ( y < this.start_y)
		{
			this.beanman.setPosition(new Vector2(x, this.start_y));		
			this.beanman.setState(this.beanman.getIdleLeft());
		}
		else
		{	
			this.beanman.setPosition(new Vector2(x, y));	
		}
		
		if ( this.beanman.getPosition().x < 0.9f * this.regionWidth) //2f/3f * 1920f)
		{
			if (this.beanman.getCam().position.x > this.canvasWidth/2)  //918
			{
				this.beanman.getCam().translate(this.translation);
				this.beanman.getCam().update();
			}
		}
		super.update(delta);
	}
	
	
	// Draw
	public void draw(float delta)
	{
		super.draw(delta);
	}
}
