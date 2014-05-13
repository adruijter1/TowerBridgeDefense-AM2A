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
	private Vector2 position;
	private float random;
	private int emitLeftOrRight = 0;
	
	// Constructor	
	public SlugEmitter(TowerBridgeDefense game, Vector2 position)
	{
		this.game = game;
		this.position = position;
		this.slugs = new ArrayList<Slug>();
	}
	
	// update method
	public void update(float delta)
	{
		if ( this.timer > this.random)
		{
			this.slugs.add(this.generateSlug());
			this.timer = 0f;
			this.random = 4 + (float)MathUtils.random(-3f,3f);
		}
		else
		{
			this.timer += 1f/60f;
		}
		
		if (this.slugs.size() != 0)
		{
			for (Slug slug : this.slugs)
			{
				slug.update(delta);
			}
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
		Slug slug = new Slug(this.game, this.position, "slug");		
		switch (this.emitLeftOrRight)
		{
			case 0:
				slug.setState(slug.getFallLeft());
				break;
			case 1:
				slug.setState(slug.getFallRight());
				break;
		}
		this.emitLeftOrRight = MathUtils.random(1);
		return slug;
	}
}
