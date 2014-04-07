package nl.xnagames.towerbridgedefense.particleengine;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import nl.xnagames.towerbridgedefense.TowerBridgeDefense;

public class ParticleEngine 
{
	// Fields
	private TowerBridgeDefense game;
	private Array<AtlasRegion> textures;
	private Vector2 emitterPosition;
	private ArrayList<Particle> particles;
	private float speed = 0.3f;
		
	
	// Properties
	public Vector2 getEmitterPosition()
	{
		return this.emitterPosition;
	}
	public void setEmitterPosition(Vector2 emitterPosition)
	{
		this.emitterPosition = emitterPosition;
	}
	
	
	// Constructor 
	public ParticleEngine(TowerBridgeDefense game, Vector2 emitterPosition)
	{
		this.game = game;
		this.textures = game.getAtlas().findRegions("puffs");
		
		this.emitterPosition = new Vector2(emitterPosition.x, emitterPosition.y);
		
		this.particles = new ArrayList<Particle>();		
	}
	
	
	// Update
	public void update(float delta)
	{
		
		int amountOfParticles = 1;
		
		for (int i = 0; i < amountOfParticles; i++)
		{
			this.particles.add(this.generateParticle());
		}			
		
		if ( this.particles.size() != 0)
		{
			for (Particle particle : this.particles)
			{
				particle.update(delta);
			}
						
			for (Particle particle : this.particles)
			{
				if ( particle.getTimeToLive() <= 0 )
				{
					this.particles.remove(particle);
					break;
				}
			}
		}
		this.emitterPosition.add(new Vector2(2f, 0f));
	}
	
	private Particle generateParticle()
	{
		return new Particle(   this.game,
							   // Afwisselen van de AtlasRegions
				   			   this.textures.get(MathUtils.random(0,3)),
				   			   // Startpositie van de particles
				   			   this.emitterPosition,
				   			   // Snelheid waarmee de particles zich voortbewegen
				   			   new Vector2(this.speed * (MathUtils.random() * 2f - 1f),
				   					   	   this.speed * (MathUtils.random() * 2f - 1f)),
				   			   // Starthoek van de afzonderlijke AtlasRegions
				   			   0f ,
				   			   // Draaien van de AtlasRegions
				   			   3f * (float)MathUtils.PI/2,
				   			   // Schaal/grootte van de AtlasRegions
				   			   0.1f,
				   			   // Tijd dat een particle leeft
				   			   40);		
	}
	
	
	// Draw
	public void draw(float delta)
	{
		if ( this.particles.size() != 0)
		{
			for (Particle particle : this.particles)
			{
				particle.draw(delta);
			}
		}
	}
}
