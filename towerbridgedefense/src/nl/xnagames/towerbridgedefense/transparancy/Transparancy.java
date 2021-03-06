package nl.xnagames.towerbridgedefense.transparancy;

public class Transparancy {
	
	// Fields
	private float timer = 0f;
	private float equilibrium;
	private float amplitude;
	private float period;
	private float periodShift;
	
	
	public Transparancy(float equilibrium, float amplitude, float period, float periodShift)
	{
		// Dit is de evenwichtstoestand van de sinusgolf
		this.equilibrium = equilibrium;
		
		// Dit is de apmplitude van de sinusgolf
		this.amplitude = amplitude;
		
		// Dit is de periode van de sinusgolf
		this.period = period;
		
		// Dit is de periode verschuiving van de sinusgolf
		this.periodShift = periodShift;
	}
	
	public void Update()
	{
		// De timer wordt opgehoogd..
		this.timer += 1/60f;
		
		// Als de periode groter wordt dan de periode moet de timer weer
		// op nul worden gezet
		if ( this.timer >= this.period)
		{
			this.timer = 0f;
		}
	}
	
	public float sinusWave()
	{
		return  this.equilibrium + this.amplitude * 
						(float)Math.sin(2d * Math.PI / this.period * 
						    (this.timer - this.periodShift * (float)Math.PI));
	}
}
