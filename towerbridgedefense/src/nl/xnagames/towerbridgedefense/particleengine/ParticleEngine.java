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
	private float timer = 0f;
		
	
	// Properties
	
	
	// Constructor 
	public ParticleEngine(TowerBridgeDefense game, Vector2 emitterPosition)
	{
		this.game = game;
		this.textures = game.getAtlas().findRegions("puffs");
		this.emitterPosition = emitterPosition;
		this.particles = new ArrayList<Particle>();
		
		
	}
	
	
	// Update
	public void update(float delta)
	{
		/*
		int amountOfParticles = 1;
		
		for (int i = 0; i < amountOfParticles; i++)
		{
			this.particles.add(this.generateParticles());
		}*/
		this.timer += 1f/60f;
		if ( this.timer > 1)
		{
			this.particles.add(new Particle(this.game,
				   			   this.textures.get(0),
				   			   new Vector2(100f,200f),
				   			   new Vector2(-1f,0f),
				   			   2f ,
				   			   0.014f,
				   			   1f,
				   			   580));
			this.timer = 0f;
		}
		
		
		if ( this.particles.size() != 0)
		{
			for (Particle particle : this.particles)
			{
				particle.update(delta);
			}
			
			//particles.get(1).update(delta);
			//particles.get(0).update(delta);
			
			for (Particle particle : this.particles)
			{
				if ( particle.getTimeToLive() <= 0 )
				{
					this.particles.remove(particle);
					break;
				}
			}
		}		
	}
	
	private Particle generateParticles()
	{
		/*
		Gdx.app.log("tes", this.emitterPosition.toString());
		return new Particle(this.game,
   				this.textures.get(MathUtils.random(0, 3)),
   				this.emitterPosition,
   				new Vector2(this.speed * (MathUtils.random() * 2 - 1),
   						    this.speed * (MathUtils.random()* 2 -1)),
   				2f ,
   				0.014f,
   				1f,
   				60);*/
		Gdx.app.log("tes", this.emitterPosition.toString());
		return new Particle(this.game,
   				this.textures.get(3),
   				this.emitterPosition,
   				new Vector2(0.01f,0.01f),
   				2f ,
   				0.014f,
   				1f,
   				60);
		
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
