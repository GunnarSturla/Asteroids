public class asteroid extends SpaceObject {
	private final int shape, generation;
	// rotspeed er gráður á hvern ramma (?)
	private final int rotspd;
	//private final int rotation;

	// Notkun:	a = new asteroid(x,y,generation);
	// Fyrir:	0 < gen <= 3
	// Eftir:	a er asteriod af gen kynslóð með staðsetninguna x,y og hreyfist í handahófskennda átt
	public asteroid(double x, double y, int gen) {
		//SpaceObject(double x, double y, double width, double height, double spd, double dir, double rot)
		super(x,y,(gen*0.08), (gen*0.08), 0.015/(gen), (Math.random()*360 +0.5), (Math.random()*360 +0.5));
		generation = gen;
		rotspd = 3/generation;
		
		shape = (int)(Math.random()*2); // ATH! breyta eftir því hve margar teinkingar við fáum
		

	}
	
	public void draw() {
		if(this.isVisible()) {
			double r =  this.h / 2;
			
			StdDraw.picture(x,y,"grafik/Rock-"+shape+"-"+generation+".png",this.generation*0.10,this.generation*0.10,(double)this.rotation);
			
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
		int timetilldeath = 200;
		StdDraw.setCanvasSize(800,800);
		StdDraw.setXscale(-1, 1);
		StdDraw.setYscale(-1, 1);
	
		SimpleVector a = new SimpleVector();
		// asteroid(double x, double y, int gen)
			a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,1));
			a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,2));
			a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,3));
			a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,1));
			a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,2));
			a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,3));
			
		
		while(true) {
			StdDraw.clear();

			asteroid tmp, tmp2;
			// Hreyfir öll stökin í a vectornum
			for(int i = 0; i < a.size() ;i++)
			{
				tmp = (asteroid) a.get(i);
				tmp.move();
			}
			
			//Tékkar á árekstrum
			for(int i = 0; i < a.size()-1; i++) {
				for(int j = i+1; j < a.size(); j++) {
					tmp = (asteroid)a.get(i); // temo breyta sem geymir asteriod-ið sem á að færa og teikna
					tmp2 = (asteroid)a.get(j);
					
					if(tmp.intersects(tmp2)) {
						tmp.destroy(a,i);	
					}
				}
			}
			
			// Teiknar öll stökin í a vectornum
			for(int i = 0; i < a.size() ;i++)
			{
				tmp = (asteroid)a.get(i);
				tmp.draw();
			}

			// Test sem sprengir asteroid
			/*if(timetilldeath == 0) {
				int whodies = (int)Math.random()*a.size();
				tmp = (asteroid) a.get(whodies);
				tmp.destroy(a,whodies);
				timetilldeath = 100;
			} else {
				timetilldeath--;
			}*/
			
			StdDraw.show(20);
			
		}
		
	}
}