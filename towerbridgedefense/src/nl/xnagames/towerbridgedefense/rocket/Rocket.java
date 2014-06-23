package nl.xnagames.towerbridgedefense.rocket;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import nl.xnagames.towerbridgedefense.TowerBridgeDefense;
import nl.xnagames.towerbridgedefense.flame.Flame;
import nl.xnagames.towerbridgedefense.image.Image;

public class Rocket extends Image
{
	private TextureRegion region;
	private Flame flame;
	
	
	
	public Rocket(TowerBridgeDefense game, Vector2 offset, Vector2 position, TextureRegion region) 
	{
		super(game, new Vector2(120f, 85f).add(position), region);
		this.flame = new Flame(game, new Vector2(-65f, 13f).add(this.position), "rocketflame");
		this.position = new Vector2(position.x + offset.x , position.y + offset.y);
		super.setScale(new Vector2(0.1f, 0.1f));
	}
	
	public void update(float delta)
	{
		this.position.x += 10f;
		this.flame.update(delta);
	}
	
	public void draw(float delta)
	{
		super.draw(delta);
		this.flame.draw(delta);
	}	
}
