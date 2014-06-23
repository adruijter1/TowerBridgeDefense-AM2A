package nl.xnagames.towerbridgedefense.image;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import nl.xnagames.towerbridgedefense.TowerBridgeDefense;

public class Image 
{
	private TowerBridgeDefense game;
	private Rectangle rectangle;
	protected Vector2 position;
	private TextureRegion region;
	private Vector2 scale = new Vector2(1f, 1f);
	
	public void setScale(Vector2 scale)
	{
		this.scale = scale;
	}

	public Image(TowerBridgeDefense game, Vector2 position, TextureRegion region)
	{
		this.game = game;
		this.position = new Vector2(position.x, position.y);
		this.region = region;
		this.rectangle = new Rectangle((int)this.position.x,
									   (int)this.position.y,
									   this.region.getRegionWidth(),
									   this.region.getRegionHeight());
	}
	
	public void update(float delta)
	{
		
	}
	
	public void draw(float delta)
	{
		this.game.getSpriteBatch().draw(this.region,
										this.position.x,
										this.position.y,
										0f,
										0f,
										this.region.getRegionWidth(),
										this.region.getRegionHeight(),
										this.scale.x,
										this.scale.y,
										0f);
	}
}
