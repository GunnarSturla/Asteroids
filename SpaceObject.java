public abstract class SpaceObject {
	public double x, y;
	public final int rotation;
	public final double direction, speed;
	
	
	// Notkun:	a = new SpaceObject(x, y, 0.01, 90, 0);
	// 
	public static void SpaceObject(double x, double y, double spd, double dir, int rot) {
		this.x = x;
		this.y = y;
		speed = spd;
		direction = dir % 360;
		rotation = rot % 360;
	}
	
	// Notkun:	a.move();
	// Fyrir:	ekkert
	// Eftir: 	this.x
	public void move() {
		double speed = 0.01/generation;
		double dx = speed * Math.cos(Math.toRadians(direction));
		double dy = speed * Math.sin(Math.toRadians(direction));
		
		this.x = this.x + dx;
		this.y = this.y + dy;
		if(this.x < -1 || this.x > 1) this.x *= -1;
		if(this.y < -1 || this.y > 1) this.y *= -1;
	}
	
	public boolean intersects(SpaceObject b) 
	{
	
	}
	
	public abstract void draw();

}