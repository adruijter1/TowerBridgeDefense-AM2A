package nl.xnagames.towerbridgedefense.flame;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;

import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;

public class FlameLeft extends AnimatedSprite
{
	// Fields
	private Flame flame;
	private Vector2 velocity;
	
	// Properties
		
	// Constructor
	public FlameLeft(Flame flame)
	{
		super(flame);
		this.flame = flame;
		this.velocity = new Vector2(-flame.getSpeed(), 0f);
		this.Initialize();
	}
	
	public void Initialize()
	{
		for ( AtlasRegion region : this.flame.getRegion())
		{
			if ( !region.isFlipX())
			{
				region.flip(true, false);
			}
		}		
	}
		
		
	// Update method
	public void update(float delta)
	{
		this.flame.setPosition(this.flame.getPosition().add(this.velocity));
		this.flame.getExhaust().setEmitterPosition(new Vector2(this.flame.getPosition().x + 9f,
															 this.flame.getPosition().y - 100f));
		this.flame.getExhaust().update(delta);
		super.update(delta);
	}
			
	// Draw method
	public void draw(float delta)
	{
		super.draw(delta);
		this.flame.getExhaust().draw(delta);
	}
}
