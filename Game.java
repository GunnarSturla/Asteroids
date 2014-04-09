public class Game
{

	private int noBullets, nextSeat, score, lives, noHiddenAsts, highScore;
	private SimpleVector a = new SimpleVector();
	private boolean menu = true;
	private boolean mute = false;
	private Bullet b[] = new Bullet[25];
	
	public void play() {
		this.play(1);
		this.noBullets = 0;
		this.nextSeat = 0;
		this.score = 0;
		this.lives = 3;
		this.noHiddenAsts = 0;
	}
	public void play(int level)
	{
		this.a = new SimpleVector();
		this.a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,3));
		this.a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,3));
		for(int i = 1; i < level; i++)
		{
			this.a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,3));
		}



	public static void main(String[] args)
	{
		int timetilldeath = 200;
		StdDraw.setCanvasSize(800,800);
		StdDraw.setXscale(-1, 1);
		StdDraw.setYscale(-1, 1);
		//StdDraw.setFont("Monospaced");
		SimpleVector a = new SimpleVector();
		a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,3));
		a.add(new asteroid(Math.random()*2-1,Math.random()*2-1,3));
		Bullet b[] = new Bullet[25];
		int noBullets = 0;
		int nextSeat = 0;
		int score = 0;
		int lives = 3;
		
    	//Ship(double x, double y, double spd, double direction, int rot)
    	Ship s = new Ship(0.0, 0.0, 0.0, 90.0, 90);
    			// Game loop
    	//StdAudio.play("216 9 Samurai Quarta 330 Rmx.wav");
		while(lives > 0)
		{
			this.noHiddenAsts = 0;
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
				if(tmp.isVisible())
				{
					tmp.move();
				} else {
					this.noHiddenAsts++;
				}
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
						score = score+level;
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
	    			//if (!mute) StdAudio.play("sfx.wav"); // skothljóð - leikurinn virðist frjósa eftir að ég setti þetta inn
    			}
				StdDraw.clear();
				//StdDraw.picture(0.0,0.0,"grafik/bg.png");
				if (lives >= 2)
				{
					StdDraw.picture(-0.9, 1, "grafik/ship1.png", 0.15, 0.15, 92);
				}
				if (lives > 2)
				{
					StdDraw.picture(-0.8, 1, "grafik/ship1.png", 0.15, 0.15, 92);
				}
				String scoretable = " " + score;
    			StdDraw.text(-1, 1, scoretable);
				if (lives == 0)
				{
					StdDraw.clear();
					menu = true;
					StdDraw.picture(0.0, 0.0, "start.jpg", 2.2, 2.2, 0.0);
					
    				if(StdDraw.isKeyPressed(32))
					{
						menu = false;
						StdAudio.play("startupsound.wav");
						lives = 3;
						score = 0;
					}

					/*SecurityManager sm = System.getSecurityManager();
					if (sm != null) {
    				sm.checkPermission(
        			new HighScorePermission(gameName));*/

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
				if(b[i].isVisible()) b[i].draw();
			}
			//teiknar lífin og stigatöfluna
			this.drawLives();

			StdDraw.show(20);
			
			// Kallar á næsta borð ef engin asteroids eru eftir
			if(this.noHiddenAsts == this.a.size())
			{
				for(int i = 0; i < this.noBullets; i++)
				{
					b[i].hide();
				}
				play(level+1);
			}
		}
				//System.out.println(score);
		this.highScore = Math.max(score,this.highScore);
	}
	
	
	public void drawLives() {
		if (lives >= 2)
		{
			StdDraw.picture(-0.9, 1, "grafik/ship1.png", 0.15, 0.15, 95);
		}
		if (lives > 2)
		{
			StdDraw.picture(-0.8, 1, "grafik/ship1.png", 0.15, 0.15, 95);
		}
		String scoretable = " " + score;
		StdDraw.text(-1, 1, scoretable);
		/*if (lives == 0)
		{
			StdDraw.clear();
			menu = true;
			StdDraw.picture(0.0, 0.0, "start.jpg", 2.2, 2.2, 0.0);
			
			if(StdDraw.isKeyPressed(32))
			{
				menu = false;
				StdAudio.play("startupsound.wav");
				lives = 3;
				score = 0;
			}
		}*/
	}
	public void menu()
	{
		while(true) {
			StdDraw.clear();
			// Start Menu
			StdDraw.picture(0.0, 0.0, "grafik/start.jpg", 2.2, 2.2, 0.0);
			if(StdDraw.isKeyPressed(32))
			{
				StdAudio.play("sounds/startupsound.wav");
				this.play();
			}

			String scoretable = " Highscore: " + this.highScore;
			StdDraw.text(-0.65, 1, scoretable);
			
			StdDraw.show(20);
		}
	}

	public static void main(String[] args)
	{
		StdDraw.setCanvasSize(800,800);
		StdDraw.setXscale(-1, 1);
		StdDraw.setYscale(-1, 1);
		Game game = new Game();
		game.menu();
		//StdDraw.setFont();
		//int gb = this.Game();
		
		

	}
}