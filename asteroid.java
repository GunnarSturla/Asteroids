public class asteroid {
	private double x, y;
	private final int generation, shape;
	private final double direction;
	// rotspeed er gráður á hvern ramma (?)
	private final int rotspd;
	
	// Notkun:	a1 = new asteroid(generation,degrees);
	// Fyrir:	0 < gen <= 3
	// Eftir:	a1 er asteriod af gen kynslóð sem hreyfist í deg átt
	public asteroid(double x, double y, int gen) {
		generation = gen;
		direction = (int)(Math.random()*360 +0,5);
		shape = (int)(Math.random()*3 +0,5); // ATH! breyta eftir því hve margar teinkingar við fáum
		rotation = (int)(Math.random()*360 +0,5);
		rotspd = (int)(Math.random()*3 +0,5);
	}

	public void draw() {
		//std.draw picture(....);
	}
	
	public static void main(String[] args) {
		int startlevel = 1;
		int startlives = 3;
	}
}