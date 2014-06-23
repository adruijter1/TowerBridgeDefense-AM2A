package nl.xnagames.towerbridgedefense.flame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;

import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;

public class FlameRight extends AnimatedSprite
{
	// Fields
	private Flame flame;
	private Vector2 velocity;
	
	// Properties
		
	// Constructor
	public FlameRight(Flame flame)
	{
		super(flame);
		this.flame = flame;
		this.velocity = new Vector2(flame.getSpeed(), 0);
		this.Initialize();
	}
	
	public void Initialize()
	{
		for ( AtlasRegion region : this.flame.getRegion())
		{
			if (region.isFlipX())
			{
				region.flip(true, false);
			}
		}
		this.frameSpeed = 10f/60f;
	}		
		
	// Update method
	public void update(float delta)
	{
		this.flame.setPosition(this.flame.getPosition().add(this.velocity));
		this.flame.getExhaust().setEmitterPosition(new Vector2(this.flame.getPosition().x - 133f,
															 this.flame.getPosition().y - 120f));
		this.flame.getExhaust().update(delta);
		super.update(delta);
	}
			
	// Draw method
	public void draw(float delta)
	{
		this.flame.getExhaust().draw(delta);
		super.draw(delta);
	}

}
