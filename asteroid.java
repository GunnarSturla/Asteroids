public class asteroid extends SpaceObject {
	private final int shape, generation;
	// rotspeed er gráður á hvern ramma (?)
	private final int rotspd;
	//private final int rotation;

	// Notkun:	a1 = new asteroid(generation,degrees);
	// Fyrir:	0 < gen <= 3
	// Eftir:	a1 er asteriod af gen kynslóð sem hreyfist í deg átt
	public asteroid(double x, double y, int gen) {
		super(x,y,0.01/(gen*gen),(int)(Math.random()*360 +0.5),(int)(Math.random()*360 +0.5));
		generation = gen;
		rotspd = 1;
		
		shape = (int)(Math.random()*3 +0.5); // ATH! breyta eftir því hve margar teinkingar við fáum
		

	}
	
	public void draw() {
		if(this.isVisible()) {
			double r =  this.generation*0.05;
			StdDraw.circle(super.x, super.y, r);
		}
	}


	public void destroy(SimpleVector a, int i) {
		if(this.generation > 1) {
			a.replace(i, new asteroid(this.x, this.y, this.generation-1));
			a.add(new asteroid(this.x, this.y, this.generation-1));
		}
	}


	
	public static void main(String[] args) {
		int timetilldeath = 100;
		StdDraw.setXscale(-1, 1);
		StdDraw.setYscale(-1, 1);
	
		SimpleVector a = new SimpleVector();
			a.add(new asteroid(0.5,0.5,1));
			a.add(new asteroid(0.0,0.0,2));
			a.add(new asteroid(0.0,0.0,3));
			
		
		while(true) {
			StdDraw.clear();

			asteroid tmp; // temo breyta sem geymir asteriod-ið sem á að færa og teikna
			for(int i = 0; i < a.size() ;i++)
			{
				tmp = (asteroid) a.get(i);
				tmp.move();
			}
			for(int i = 0; i < a.size() ;i++)
			{
				tmp = (asteroid)a.get(i);
				tmp.draw();
			}

			if(timetilldeath == 0) {
				tmp = (asteroid) a.get(2);
				tmp.destroy(a,2);
				timetilldeath = 200;
			} else {
				timetilldeath--;
			}
			
			StdDraw.show(20);
			
		}
		
	}
}