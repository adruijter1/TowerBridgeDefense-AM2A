package nl.xnagames.towerbridgedefense.slug;

import nl.xnagames.towerbridgedefense.TowerBridgeDefense;
import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;
import nl.xnagames.towerbridgedefense.animation.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Slug implements Animation 
{
	// Fields
		private TowerBridgeDefense game;
		private AtlasRegion singleFrame;
		private float scaleFactor;
		private float size;
		private AnimatedSprite state;
		private float speed = 2f;
		private Vector2 position;
		private Array<AtlasRegion> region;
		private SlugWalkRight walkRight;
		private SlugWalkLeft walkLeft;
		private SlugFallRight fallRight;
		private SlugFallLeft fallLeft;
		// Name van het plaatje op de TextureAtlas
		private String name;
		
		// Properties
		public String getName()
		{
			return this.name;
		}
		public TowerBridgeDefense getGame()
		{
			return this.game;
		}	
		public float getScaleFactor()
		{
			return this.scaleFactor;
		}	
		public float getSize()
		{
			return this.size;
		}
		public float getSpeed()
		{
			return this.speed;
		}
		public Vector2 getPosition()
		{
			return this.position;
		}
		public void setPosition(Vector2 position)
		{
			this.position = position;
		}
		public void setState(AnimatedSprite state)
		{
			this.state = state;
		}
		public Array<AtlasRegion> getRegion()
		{
			return this.region;
		}
		public SlugWalkRight getWalkRight()
		{
			this.walkRight.Initialize();
			return this.walkRight;
		}
		public SlugWalkLeft getWalkLeft()
		{
			this.walkLeft.Initialize();
			return this.walkLeft;
		}
		public SlugFallRight getFallRight()
		{
			this.fallRight.Initialize();
			return this.fallRight;		
		}
		public SlugFallLeft getFallLeft()
		{
			this.fallLeft.Initialize();
			return this.fallLeft;
		}
		
		
		// Constructor
		public Slug(TowerBridgeDefense game, Vector2 position, String name)
		{
			this.game = game;
			this.position = position;
			this.name = name;
			
			
			
			// We maken een instantie van de HashMap die we koppelen aan this.region
			this.region = new Array<AtlasRegion>();		
				
			this.region = game.getAtlas().findRegions(name);
			
			
			this.singleFrame = this.region.first();
			this.scaleFactor = (float)this.singleFrame.getRegionHeight()/(float)this.singleFrame.getRegionWidth();
			this.size = 50f;
			this.walkRight = new SlugWalkRight(this);
			this.walkLeft = new SlugWalkLeft(this);
			this.fallRight = new SlugFallRight(this, 150, 200);
			this.fallLeft = new SlugFallLeft(this, -150, 200);
			this.state = this.getWalkRight();
		}
		
		// Update method
		public void update(float delta)
		{
			this.state.update(delta);
		}
		
		// Draw method
		public void draw(float delta)
		{
			this.state.draw(delta);
		}

}
