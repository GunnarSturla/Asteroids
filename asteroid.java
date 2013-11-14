public class asteroid extends SpaceObject {
	private final int shape, generation, direction;
	public final double speed;
	// rotspeed er gráður á hvern ramma (?)
	private final int rotspd;
	//private final int rotation;

	// Notkun:	a1 = new asteroid(generation,degrees);
	// Fyrir:	0 < gen <= 3
	// Eftir:	a1 er asteriod af gen kynslóð sem hreyfist í deg átt
	public asteroid(double x, double y, double spd, int dir, int rot,int gen) {
		generation = gen;
		direction = dir;
		speed = 0.1;
		
		rotspd = (int)(Math.random()*3 +0.5);
		shape = (int)(Math.random()*3 +0.5); // ATH! breyta eftir því hve margar teinkingar við fáum
	}
	
	public void draw() {
		double r =  this.generation*0.05;
		StdDraw.circle(super.x, super.y, r);
	}
	/*public void move() {
		double dx = super.speed * Math.cos(Math.toRadians(super.direction));
		double dy = super.speed * Math.sin(Math.toRadians(super.direction));
		
		super.x = super.x + dx;
		super.y = super.y + dy;
		if(super.x < -1 || super.x > 1) this.x *= -1;
		if(super.y < -1 || super.y > 1) this.y *= -1;
	}*/

	
	public static void main(String[] args) {
	
		StdDraw.setXscale(-1, 1);
		StdDraw.setYscale(-1, 1);
		asteroid a1 = new asteroid(0.5,0.5,0.01,(int)(Math.random()*360 +0.5),(int)(Math.random()*360 +0.5),1);
	//	asteroid a2 = new asteroid(0.0,0.0,2);
	//	asteroid a3 = new asteroid(0.0,0.0,3);
		while(true) {
			StdDraw.clear();
			a1.move();
	//		a2.move();
	//		a3.move();
			a1.draw();
	//		a2.draw();
	//		a3.draw();
			StdDraw.show(20);
			
		}
		
	}
}