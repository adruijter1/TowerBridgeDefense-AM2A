package nl.xnagames.towerbridgedefense.animation;

import nl.xnagames.towerbridgedefense.TowerBridgeDefense;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public interface Animation 
{
	public Array<AtlasRegion> getRegion();
	
	public Vector2 getPosition();
	
	public float getSize();	
	
	public float getScaleFactor();
	
	public TowerBridgeDefense getGame();
	
	public String getName();
}
