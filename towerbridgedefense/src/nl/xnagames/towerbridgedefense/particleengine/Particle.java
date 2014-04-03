package nl.xnagames.towerbridgedefense.particleengine;

import nl.xnagames.towerbridgedefense.TowerBridgeDefense;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;

public class Particle 
{
	// Fields
	private AtlasRegion region;
	private Vector2 position;
	private Vector2 velocity;
	private float angle;
	private float angularVelocity;
	private float size;
	private int timeToLive;
	private SpriteBatch batch;	
	
	// Properties
	public int getTimeToLive()
	{
		return this.timeToLive;
	}
	
	// Constructor
	public Particle(TowerBridgeDefense game, AtlasRegion region, Vector2 position, 
						Vector2 velocity, float angle, float angularVelocity,
							float size, int timeToLive)
	{
		this.batch = game.getSpriteBatch();
		this.region = region;
		
		// Belangrijke wijziging!!!
		this.position = new Vector2(position.x, position.y);
		
		this.velocity = velocity;
		this.angle = angle;
		this.angularVelocity = angularVelocity;
		this.size = size;
		this.timeToLive = timeToLive;
		
	}
	
	
	// Update 
	public void update(float delta)
	{
		this.timeToLive--;
		this.position.add(this.velocity);
		this.angle += this.angularVelocity;		
	}
	
	
	// Draw
	public void draw(float delta)
	{
		batch.draw(this.region,
				   this.position.x, 
				   this.position.y, 
				   this.region.getRegionWidth()/2, 
				   this.region.getRegionHeight()/2,
				   this.region.getRegionWidth(),
				   this.region.getRegionHeight(), 
				   this.size,
				   this.size,
				   this.angle);
	}
}
