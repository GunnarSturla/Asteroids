public class Game
{
	private int noBullets, nextSeat, score, lives;
	SimpleVector a = new SimpleVector();
	boolean menu = true;
	boolean mute = false;
	
	public void play()
	{
		this.a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,3));
		this.a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,3));
		
		Bullet b[] = new Bullet[25];
		this.noBullets = 0;
		this.nextSeat = 0;
		this.score = 0;
		this.lives = 3;
		
    	//Ship(double x, double y, double spd, double direction, int rot)
    	Ship s = new Ship(0.0, 0.0, 0.0, 90.0, 90);
    			// Game loop
    	//StdAudio.play("216 9 Samurai Quarta 330 Rmx.wav");
		while(lives > 1)
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
    			if(noBullets < 25) this.noBullets++;
    			s.shoot(b, nextSeat);
    			this.nextSeat = (nextSeat + 1) % 25;
    			//if (!mute) StdAudio.play("sfx.wav"); // skothljóð - leikurinn virðist frjósa eftir að ég setti þetta inn
			}
			//String scoretable = "stig" + score;
			//StdDraw.text(-0.9, 0.9, scoretable);
			StdDraw.clear();
			StdDraw.picture(0.0,0.0,"grafik/bakgrunnur.jpg",2.2,2.2);
			
		
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
			}

			
			//Tékkar á árekstrum
			for(int i = 0; i < a.size(); i++)
			{
				tmp = (asteroid)a.get(i); // temo breyta sem geymir asteriod-ið sem á að færa og teikna
				for(int j = 0; j < noBullets; j++)
				{
					if(tmp.intersects(b[j]) && b[j].isVisible())
					{
						tmp.destroy(a,i);
						b[j].hide();
						score++;
					}
				}
				if(s.isImmortal() && s.intersects(tmp))
				{
					//b[26] = new Bullet(0.0,0.0,(int)(Math.random()*360));
					s.ReLaunch();
					
					lives--;
				}
			}
		
			// Teiknar öll stökin í a vectornum
			for(int i = 0; i < a.size() ;i++)
			{
				tmp = (asteroid)a.get(i);
				tmp.draw();
			}
			
			// Teiknar skipið
			s.draw();
			// Teiknar byssukúlur
			for(int i = 0; i < noBullets; i++)
			{
				b[i].draw();
			}

			StdDraw.show(20);
		}
				//System.out.println(score);


	}
	
	public void menu()
	{
	
	}
	
	public void Game()
	{

		while(true) {
			StdDraw.clear();
			// Start Menu
			StdDraw.picture(0.0, 0.0, "start.jpg", 2.2, 2.2, 0.0);
			if(StdDraw.isKeyPressed(32))
			{
				this.play();
				StdAudio.play("startupsound.wav");
			}
		}
	}
	public static void main(String[] args)
	{
		StdDraw.setCanvasSize(800,800);
		StdDraw.setXscale(-1, 1);
		StdDraw.setYscale(-1, 1);
		Game game = new Game();
		game.play();
		//StdDraw.setFont();
		//int gb = this.Game();
		
		

	}
}