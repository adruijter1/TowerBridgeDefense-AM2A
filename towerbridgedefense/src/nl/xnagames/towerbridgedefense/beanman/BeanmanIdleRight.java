package nl.xnagames.towerbridgedefense.beanman;

import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;
import nl.xnagames.towerbridgedefense.bus.Bus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;

public class BeanmanIdleRight extends AnimatedSprite
{
	// Fields
		private Beanman beanman;
		private Vector2 velocity;
		
		// Properties
			
		// Constructor
		public BeanmanIdleRight(Beanman beanman)
		{
			super(beanman);
			this.beanman = beanman;
			this.velocity = new Vector2(beanman.getSpeed(), 0);
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
			if (Gdx.input.isKeyPressed(Keys.RIGHT))
			{
				this.beanman.setState(this.beanman.getWalkRight());
			}
			else if (Gdx.input.isKeyPressed(Keys.LEFT))
			{
				this.beanman.setState(this.beanman.getWalkLeft());
			}
			
			//super.update(delta);
		}
				
		// Draw method
		public void draw(float delta)
		{
			super.draw(delta);
		}

}
