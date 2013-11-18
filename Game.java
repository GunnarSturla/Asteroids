public class Game
{
	public static void main(String[] args)
	{
		StdDraw.setCanvasSize(800,800);
	//int N = 20;
	Ship s = new Ship (0.0, 0.0, 0.1, 0.2, 0.0, 90.0, 90.0);
	//Astroid[] a = new astroid[N];
	/*for (int i = 0; i < N; i++)
	{
		a[i] = Math.random(), Math.random(), 1;

	}*/
	
	
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
			}*/
		StdDraw.show(20);
	}

	}
}