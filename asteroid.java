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


	public void destroy() {
		this.hide();
		
	}


	
	public static void main(String[] args) {
		int timetilldeath = 100;
		StdDraw.setXscale(-1, 1);
		StdDraw.setYscale(-1, 1);
//		asteroid a1 = new asteroid(0.5,0.5,1);
//		asteroid a2 = new asteroid(0.0,0.0,2);
//		asteroid a3 = new asteroid(0.0,0.0,3);
		
		SimpleVector a = new SimpleVector();
			a.add(new asteroid(0.5,0.5,1));
			a.add(new asteroid(0.0,0.0,2));
			a.add(new asteroid(0.0,0.0,3));
			
	/*	asteroid a[] = new asteroid[3];
		a[0] = new asteroid(0.5,0.5,1);
		a[1] = new asteroid(0.0,0.0,2);
		a[2] = new asteroid(0.0,0.0,3);*/
		
		while(true) {
			StdDraw.clear();
	/*		a1.move();
			a2.move();
			a3.move();
			a1.draw();
			a2.draw();
			a3.draw();
			StdDraw.show(20);
			if(timetilldeath == 0) {
				a3.destroy();
			} else {
				timetilldeath--;
			}*/
			/*for(int i = 0; i < a.length;i++)
			{
				a[i].move();
			}
			for(int i = 0; i < a.length;i++)
			{
				a[i].draw();
			}*/
			asteroid tmp;
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
			
			StdDraw.show(20);
			
		}
		
	}
}