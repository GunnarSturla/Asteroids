public abstract class SpaceObject {
	public double x, y;
	public int rotation, direction;
	public double speed;
	
	
	// Notkun:	a = new SpaceObject(x, y, 0.01, 90, 0);
	// 
	public void SpaceObject(double x, double y, double spd, int dir, int rot) {
		this.x = x;
		this.y = y;
		speed = 0.1;
		this.direction = dir;
		this.rotation = rot;
	}
	
	// Notkun:	a.move();
	// Fyrir:	ekkert
	// Eftir: 	this.x
	public void move() {
		double dx = this.speed * Math.cos(Math.toRadians(direction));
		double dy = this.speed * Math.sin(Math.toRadians(direction));
		
		this.x = this.x + dx;
		this.y = this.y + dy;
		if(this.x < -1 || this.x > 1) this.x *= -1;
		if(this.y < -1 || this.y > 1) this.y *= -1;
	}

	public boolean intersects(SpaceObject b) 
	{
		return false;
	}
	
	public abstract void draw();

}