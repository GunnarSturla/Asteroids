public class asteroid extends SpaceObject {
	private final int shape, generation;
	// rotspeed er gráður á hvern ramma (?)
	private final int rotspd;
	//private final int rotation;

	// Notkun:	a = new asteroid(x,y,generation);
	// Fyrir:	0 < gen <= 3
	// Eftir:	a er asteriod af gen kynslóð með staðsetninguna x,y og hreyfist í handahófskennda átt
	public asteroid(double x, double y, int gen) {
		super(x,y,0.01/(gen*gen),(int)(Math.random()*360 +0.5),(int)(Math.random()*360 +0.5));
		generation = gen;
		rotspd = 3/generation;
		
		shape = (int)(Math.random()*4 +0.5); // ATH! breyta eftir því hve margar teinkingar við fáum
		

	}
	
	public void draw() {
		if(this.isVisible()) {
			double r =  this.generation*0.05;
			
			StdDraw.picture(x,y,"rock-3-"+this.shape+".png",this.generation*0.10,this.generation*0.10,(double)this.rotation);
			
			this.rotation = this.rotation + rotspd;
			//StdDraw.circle(super.x, super.y, r);
		}
	}

	
	public void destroy(SimpleVector a, int i) {
		if(this.generation > 1) {
			a.replace(i, new asteroid(this.x, this.y, this.generation-1));
			a.add(new asteroid(this.x, this.y, this.generation-1));
		} else {
			this.hide();
		}
	}


	
	public static void main(String[] args) {
		int timetilldeath = 100;
		StdDraw.setCanvasSize(800,800);
		StdDraw.setXscale(-1, 1);
		StdDraw.setYscale(-1, 1);
	
		SimpleVector a = new SimpleVector();
			a.add(new asteroid(0.5,0.5,1));
			a.add(new asteroid(0.0,0.0,2));
			a.add(new asteroid(0.0,0.0,3));
			
		
		while(true) {
			StdDraw.clear();

			asteroid tmp; // temo breyta sem geymir asteriod-ið sem á að færa og teikna
			
			// Hreyfir öll stökin í a vectornum
			for(int i = 0; i < a.size() ;i++)
			{
				tmp = (asteroid) a.get(i);
				tmp.move();
			}
			
			// Teiknar öll stökin í a vectornum
			for(int i = 0; i < a.size() ;i++)
			{
				tmp = (asteroid)a.get(i);
				tmp.draw();
			}

			// Test sem sprengir asteroid
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