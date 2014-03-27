package nl.xnagames.towerbridgedefense.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;

import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;

public class EntityMoveRight extends AnimatedSprite
{
	// Fields
	private Entity entity;
	private Vector2 velocity;
	
	// Properties
		
	// Constructor
	public EntityMoveRight(Entity entity)
	{
		super(entity);
		this.entity = entity;
		this.velocity = new Vector2(entity.getSpeed(), 0);
		this.frameSpeed = entity.getFrameSpeed();
		this.Initialize();
	}
	
	public void Initialize()
	{
		for ( AtlasRegion region : this.entity.getRegion())
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
		if ( this.entity.getPosition().x > Gdx.graphics.getWidth() + 200)
		{
			this.entity.setState(this.entity.getMoveLeft());
		}
		this.entity.setPosition(this.entity.getPosition().add(this.velocity));
		super.update(delta);
	}
			
	// Draw method
	public void draw(float delta)
	{
		super.draw(delta);
	}

}

