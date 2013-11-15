public class SpaceObject {
	public double x, y;
	
	
	// Notkun:	a = new SpaceObject(x, y, 0.01, 90, 0);
	// 
	public SpaceObject(double x, double y) {
		this.x = x;
		this.y = y;
<<<<<<< HEAD
=======
		this.visible = true;
>>>>>>> b14a345c49149cafaeeac6af9732ed03e4747cd9
	}
	
	// Notkun:	a.move();
	// Fyrir:	ekkert
	// Eftir: 	this.x
	public void move(double speed, int direction) {
		double dx = speed * Math.cos(Math.toRadians(direction));
		double dy = speed * Math.sin(Math.toRadians(direction));
		
		this.x = this.x + dx;
		this.y = this.y + dy;
		if(this.x < -1 || this.x > 1) this.x *= -1;
		if(this.y < -1 || this.y > 1) this.y *= -1;
	}

	public boolean intersects(SpaceObject b) 
	{
		return false;
	}
	
<<<<<<< HEAD
	public abstract void draw();
=======
	public void hide() {
		this.visible = false;
	}
	public boolean isVisible() {
		return this.visible;
	}
	
>>>>>>> b14a345c49149cafaeeac6af9732ed03e4747cd9

}