public class Game
{
	//Astroid[] a = new astroid[N];
	/*for (int i = 0; i < N; i++)
	{
		a[i] = Math.random(), Math.random(), 1;

	}*/
	public static void main(String[] args)
	{
		int timetilldeath = 200;
		StdDraw.setCanvasSize(800,800);
		StdDraw.setXscale(-1, 1);
		StdDraw.setYscale(-1, 1);
		StdDraw.setFont();
		SimpleVector a = new SimpleVector();
		a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,3));
		a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,3));
		Bullet b[] = new Bullet[25];
		int noBullets = 0;
		int nextSeat = 0;
		//int score = 0;
		//int lives = 3;
		
    	//Ship(double x, double y, double spd, double direction, int rot)
    	Ship s = new Ship(0.0, 0.0, 0.0, 90.0, 90);
		// Game loop
    	boolean menu = true;
    	boolean mute = false;
    	StdAudio.play("216 9 Samurai Quarta 330 Rmx.wav");
		while(true)
		{
			if (menu)
			{
				// Start Menu
				StdDraw.picture(0.0, 0.0, "start.jpg", 2.2, 2.2, 0.0);
				if(StdDraw.isKeyPressed(32))
				{
					menu = false;
					StdAudio.play("startupsound.wav");
				}
			}
			if (!menu)
			{
				// Pásu takkinn
				if(StdDraw.isKeyPressed(80))
				{
					menu = true;
				}
				// Þagga niður í hljóðum
				if(StdDraw.isKeyPressed(77))
				{
					mute = true;
				}
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
	    			if (!mute) StdAudio.play("sfx.wav"); // skothljóð - leikurinn virðist frjósa eftir að ég setti þetta inn
    			}
    			//String scoretable = "stig" + score;
    			//StdDraw.text(-0.9, 0.9, scoretable);
				StdDraw.clear();
	
				asteroid tmp;
				// Hreyfir öll asteroid-in í a vectornum
				for(int i = 0; i < a.size() ;i++)
				{
					tmp = (asteroid) a.get(i);
					tmp.move();
				}
			
				// hreyfa skipið
				s.move();
			
			
				for(int i = 0; i < noBullets; i++)
				{
					b[i].move();
					b[i].draw();
				}
	
				s.draw();
				
				//Tékkar á árekstrum
				for(int i = 0; i < a.size(); i++)
				{
					tmp = (asteroid)a.get(i); // temo breyta sem geymir asteriod-ið sem á að færa og teikna
					for(int j = 0; j < noBullets; j++)
					{
						if(tmp.intersects(b[j]))
						{
							if(b[j].isVisible()) tmp.destroy(a,i);
							b[j].hide();
							//score++;	
						}
					}
					if(tmp.intersects(s))
					{
						b[26] = new Bullet(0.0,0.0,(int)(Math.random()*360));
						//lives--;
					}
				}
			
				// Teiknar öll stökin í a vectornum
				for(int i = 0; i < a.size() ;i++)
				{
				tmp = (asteroid)a.get(i);
					tmp.draw();
				}
				StdDraw.show(20);
			}
		}		
	}
}