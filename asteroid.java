public class asteroid extends SpaceObject {
	private final int shape, generation;
	// rotspeed er gráður á hvern ramma (?)
	private final int rotspd;
	private final int rotation;
	private final double direction, speed;

	// Notkun:	a1 = new asteroid(generation,degrees);
	// Fyrir:	0 < gen <= 3
	// Eftir:	a1 er asteriod af gen kynslóð sem hreyfist í deg átt
	public asteroid(double x, double y, int gen) {
		generation = gen;
		direction = (int)(Math.random()*360 +0.5);
		rotation = (int)(Math.random()*360 +0.5);
		
		super.x = x;
		super.y = y;
		super.direction = this.direction;
		super.rotation = this.rotation;
		
		
		rotspd = (int)(Math.random()*3 +0.5);
		shape = (int)(Math.random()*3 +0.5); // ATH! breyta eftir því hve margar teinkingar við fáum
	}

	public void draw() {
		double r =  this.generation*0.05;
		StdDraw.circle(super.x, super.y, r);
	}

	
	public static void main(String[] args) {
	
		StdDraw.setXscale(-1, 1);
		StdDraw.setYscale(-1, 1);
		asteroid a1 = new asteroid(0.5,0.5,1);
		asteroid a2 = new asteroid(0.0,0.0,2);
		asteroid a3 = new asteroid(0.0,0.0,3);
		while(true) {
			StdDraw.clear();
			a1.move();
			a2.move();
			a3.move();
			a1.draw();
			a2.draw();
			a3.draw();
			StdDraw.show(20);
			
		}
		
	}
}