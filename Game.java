public class Game
{
<<<<<<< HEAD
	public static void main(String[] args)
	{
		StdDraw.setCanvasSize(800,800);
	//int N = 20;
	Ship s = new Ship (0.0, 0.0, 0.1, 0.2, 0.0, 90.0, 90.0);
=======
>>>>>>> 218066591cd36d5a78134d41300b249873e2d011
	//Astroid[] a = new astroid[N];
	/*for (int i = 0; i < N; i++)
	{
		a[i] = Math.random(), Math.random(), 1;

	}*/
<<<<<<< HEAD
	
	
	/*	SimpleVector a = new SimpleVector();
			a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,1));
			a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,2));
			a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,3));
			a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,1));
			a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,2));
			a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,3));
		asteroid tmp, tmp2;*/
			
		

	while (true)
	{
		StdDraw.setXscale(-1, 1);
		StdDraw.setYscale(-1, 1);

		if (StdDraw.isKeyPressed(38)||StdDraw.isKeyPressed(87))
        {
        	s.setSpeed(0.01);
        }
        if (StdDraw.isKeyPressed(37)||StdDraw.isKeyPressed(65))
        {
            s.shipLeft();
        }
        if (StdDraw.isKeyPressed(39)||StdDraw.isKeyPressed(68))
        {
            s.shipRight();
        }
		StdDraw.clear();
		s.move();
		s.draw();
		//skipið
		
		/*for(int i = 0; i < a.size() ;i++)
=======
	public static void main(String[] args) {
		int timetilldeath = 200;
		StdDraw.setCanvasSize(800,800);
		StdDraw.setXscale(-1, 1);
		StdDraw.setYscale(-1, 1);
	
		SimpleVector a = new SimpleVector();
			a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,3));
			a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,3));
		
		Bullet b[] = new Bullet[25];
		int noBullets = 0;
		int nextSeat = 0;
		
    	//Ship(double x, double y, double spd, double direction, int rot)
    	Ship s = new Ship(0.0, 0.0, 0.0, 90.0, 90);
		// Game loop
		while(true) {
		    // left arrow || a
    		if(StdDraw.isKeyPressed(37) || StdDraw.isKeyPressed(83)) s.turn(1);
    		// right arrow || d
    		if(StdDraw.isKeyPressed(39) || StdDraw.isKeyPressed(68)) s.turn(-1);
    		// Up arrow || w
    		if(StdDraw.isKeyPressed(38) || StdDraw.isKeyPressed(87)) s.accelerate();
    		// spacebar || enter
    		if((StdDraw.isKeyPressed(32) || StdDraw.isKeyPressed(13)) && s.getShotInterval() <= 0)
    		{
	    		if(noBullets < 25) noBullets++;
	    		s.shoot(b, nextSeat);
	    		nextSeat = (nextSeat + 1) % 25;
    		}
    		
			StdDraw.clear();

			asteroid tmp;
			// Hreyfir öll asteroid-in í a vectornum
			for(int i = 0; i < a.size() ;i++)
>>>>>>> 218066591cd36d5a78134d41300b249873e2d011
			{
				tmp = (asteroid) a.get(i);
				tmp.move();
			}
			
<<<<<<< HEAD
			//Tékkar á árekstrum
			for(int i = 0; i < a.size()-1; i++) {
				for(int j = i+1; j < a.size(); j++) {
					tmp = (asteroid)a.get(i); // temo breyta sem geymir asteriod-ið sem á að færa og teikna
					tmp2 = (asteroid)a.get(j);
					
					if(tmp.intersects(tmp2)) {
						tmp.destroy(a,i);	
					}
				}
=======
			// hreyfa skipið
			s.move();
			
			
			for(int i = 0; i < noBullets; i++)
			{
				b[i].move();
				b[i].draw();
			}
	
			s.draw();
			
			//Tékkar á árekstrum
			for(int i = 0; i < a.size(); i++) {
				tmp = (asteroid)a.get(i); // temo breyta sem geymir asteriod-ið sem á að færa og teikna
				for(int j = 0; j < noBullets; j++) {
					
					if(tmp.intersects(b[j])) {
						tmp.destroy(a,i);
						b[j].hide();	
					}
				}
				if(tmp.intersects(s)) {
					b[26] = new Bullet(0.0,0.0,(int)(Math.random()*360));
				}
>>>>>>> 218066591cd36d5a78134d41300b249873e2d011
			}
			
			// Teiknar öll stökin í a vectornum
			for(int i = 0; i < a.size() ;i++)
			{
				tmp = (asteroid)a.get(i);
				tmp.draw();
<<<<<<< HEAD
			}*/
		StdDraw.show(20);
=======
			}
			
			StdDraw.show(20);
>>>>>>> 218066591cd36d5a78134d41300b249873e2d011
	}

	}
}