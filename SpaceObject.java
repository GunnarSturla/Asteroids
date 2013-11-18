public class SpaceObject {
	public double x, y, w, h;
	public double speed, direction, rotation;
	private boolean visible;
	
	// Notkun:	a = new SpaceObject(x, y, 0.01, 90, 0);
	// 
	public SpaceObject(double x, double y, double w, double h, double spd, double dir, double rot) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		//this.visible = true;
		this.speed = spd;
		this.direction = dir;
		this.rotation = rot;
		

	}
	
	// Notkun:	a.move();
	// Fyrir:	ekkert
	// Eftir: 	a fær nýja staðsetningu, hreyfist samkvæmt speed í direction átt, birtist hinum megin ef hann fer út fyrir rammann.
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
	
	// Notkun: r = s.getBoundingBox()
	// Fyrir:  ekkert
	// Eftir:  r er minnsti ferhyrningur sem passar utan um s
	/*public Rectangle getBoundingBox()
	{
		return new Rectangle(x, y, r*2, r*2);
	}*/
	
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
	public double getDirection() {
		return this.direction;
	}
}