package nl.xnagames.towerbridgedefense.beanman;

import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;

public class BeanmanJumpRight extends AnimatedSprite
{
	// Fields
	private Beanman beanman;
	
	// Properties
	
	// Constructor
	public BeanmanJumpRight(Beanman beanman)
	{
		super(beanman);
		this.beanman = beanman;
		this.frameSpeed = 1f/120f;		
		this.Initialize();
	}
	
	// Initialize
	public void Initialize()
	{
		
	}
	
	// Update
	public void update(float delta)
	{
		super.update(delta);
	}
	
	
	// Draw
	public void draw(float delta)
	{
		super.draw(delta);
	}
}
