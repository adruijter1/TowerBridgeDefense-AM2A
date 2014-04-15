package nl.xnagames.towerbridgedefense.beanman;

import nl.xnagames.towerbridgedefense.TowerBridgeDefense;
import nl.xnagames.towerbridgedefense.animatedsprite.AnimatedSprite;
import nl.xnagames.towerbridgedefense.animation.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Beanman implements Animation 
{
	// Fields
		private TowerBridgeDefense game;
		private AtlasRegion singleFrame;
		private float scaleFactor;
		private float size;
		private AnimatedSprite state;
		private float speed = 3f;
		private Vector2 position;
		private Array<AtlasRegion> region;
		private BeanmanIdleRight idleRight;
		private BeanmanWalkRight walkRight;
		private BeanmanWalkLeft walkLeft;
		private BeanmanIdleLeft idleLeft;
		private BeanmanJumpRight jumpRight;
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
		public BeanmanWalkRight getWalkRight()
		{
			this.walkRight.Initialize();
			return this.walkRight;
		}
		public BeanmanIdleRight getIdleRight()
		{
			this.idleRight.Initialize();
			return this.idleRight;
		}
		public BeanmanIdleLeft getIdleLeft()
		{
			this.idleLeft.Initialize();
			return this.idleLeft;
		}
		public BeanmanWalkLeft getWalkLeft()
		{
			this.walkLeft.Initialize();
			return this.walkLeft;
		}
		public BeanmanJumpRight getJumpRight()
		{
			this.jumpRight.Initialize();
			return this.jumpRight;		
		}
		
		
		// Constructor
		public Beanman(TowerBridgeDefense game, Vector2 position, String name)
		{
			this.game = game;
			this.position = position;
			this.name = name;
			
			
			
			// We maken een instantie van de HashMap die we koppelen aan this.region
			this.region = new Array<AtlasRegion>();		
				
			this.region = game.getAtlas().findRegions(name);
			
			
			this.singleFrame = this.region.first();
			this.scaleFactor = (float)this.singleFrame.getRegionHeight()/(float)this.singleFrame.getRegionWidth();
			this.size = 100f;
			this.idleRight = new BeanmanIdleRight(this);
			this.walkRight = new BeanmanWalkRight(this);
			this.idleLeft = new BeanmanIdleLeft(this);
			this.walkLeft = new BeanmanWalkLeft(this);
			this.jumpRight = new BeanmanJumpRight(this);
			this.state = this.getIdleRight();
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
