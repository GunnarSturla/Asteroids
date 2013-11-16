public class SpaceObject {
	public double x, y;
	public double speed;
	private int direction, rotation; 
	private boolean visible;
	
	// Notkun:	a = new SpaceObject(x, y, 0.01, 90, 0);
	// 
	public SpaceObject(double x, double y,double spd, int dir, int rot) {
		this.x = x;
		this.y = y;
		this.visible = true;
		this.speed = spd;
		this.direction = dir;
		this.rotation = rot;
		

	}
	
	// Notkun:	a.move();
	// Fyrir:	ekkert
	// Eftir: 	this.x
	public void move() {
		if(this.visible) {
			double dx = this.speed * Math.cos(Math.toRadians(this.direction));
			double dy = this.speed * Math.sin(Math.toRadians(this.direction));
			
			this.x = this.x + dx;
			this.y = this.y + dy;
			if(this.x < -1.15 || this.x > 1.15) this.x *= -1;
			if(this.y < -1.15 || this.y > 1.15) this.y *= -1;
		}
	}
	
	public boolean intersects(SpaceObject b) 
	{
		return false;
	}
	
	public void hide() {
		this.visible = false;
	}
	public boolean isVisible() {
		return this.visible;
	}
}