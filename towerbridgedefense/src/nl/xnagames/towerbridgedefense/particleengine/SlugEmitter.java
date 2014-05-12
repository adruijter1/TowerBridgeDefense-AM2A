package nl.xnagames.towerbridgedefense.particleengine;

import java.util.ArrayList;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import nl.xnagames.towerbridgedefense.TowerBridgeDefense;
import nl.xnagames.towerbridgedefense.slug.Slug;

public class SlugEmitter 
{
	// Fields
	private TowerBridgeDefense game;
	private ArrayList<Slug> slugs;
	private float timer = 0f;
	
	// Constructor	
	public SlugEmitter(TowerBridgeDefense game, Vector2 position)
	{
		this.game = game;
		
		this.slugs = new ArrayList<Slug>();
	}
	
	// update method
	public void update(float delta)
	{
		if ( this.timer > 120f)
		{
			this.slugs.add(this.generateSlug());
			this.timer = 0f;
		}
		else
		{
			this.timer += 1f/60f;
		}
	}
	
	// draw method
	public void draw(float delta)
	{
		if ( this.slugs.size() != 0)
		{
			for (Slug slug : this.slugs)
			{
				slug.draw(delta);
			}
		}
	}
	
	private Slug generateSlug()
	{
		return new Slug(this.game, new Vector2(320f, 240f), "slug");
	}
}
