public class Ship extends SpaceObject
{
	private int shotInterval, jumpInterval, immortalTime;
	private double maxspeed;
	private boolean accel = false;

	// Notkun: s = new Ship (x, y, spd, direction, rot)
	// Fyrir: -1 < x,y < 1,
	// Eftir: s er skip með miðju í x,y hraða spd, stefnu direction og snúning rot
	public Ship(double x, double y, double spd, double direction, int rot)
	{
		// SpaceObject(double x, double y, double w, double h, double spd, double dir, int rot)
		super(x, y, 0.1, 0.1, spd, direction, rot);
		maxspeed = 0.05;
		immortalTime = 20;
	}
	
	// Notkun: s.draw()
   	// Fyrir: ekkert
    // Eftir: s (skipið) er teiknað
	public void draw() {
			if(this.accel) StdDraw.picture(x,y,"grafik/Fire2.png",super.w*2.04,super.h*2,(double)this.rotation);
			StdDraw.picture(x,y,"grafik/ship1.png",super.w*2.04,super.h*2,(double)this.rotation);
			if(immortalTime > 0 && (immortalTime % 2 == 0)) StdDraw.circle(x,y,h);
			//(double x, double y, double halfWidth, double halfHeight)
			//StdDraw.rectangle(super.x, super.y, (super.w / 2), (super.h/2));
			this.accel = false;
			shotInterval--;
			jumpInterval--;
			immortalTime--;
			this.speed = this.speed * 0.995;
	}
	
		// Notkun: s.turn(i)
    	// Fyrir:  ekkert
    	// Eftir:  i*7 bætist við rotation
	public void turn(int i) {
		this.rotation = (this.rotation + i*7);
	}
	
		// Notkun: s.accelerate()
    	// Fyrir:  ekkert
    	// Eftir:  s (skipið) fær nýja stefnu út frá því hvernig það snýr og í hvaða átt það stefnir
	public void accelerate() {
		//if(super.speed < maxspeed) super.speed = super.speed + 0.001;
		
			double dx = this.speed * Math.cos(Math.toRadians(this.direction));
			double dy = this.speed * Math.sin(Math.toRadians(this.direction));
			
			dx = dx + 0.001 * Math.cos(Math.toRadians(this.rotation));
			dy = dy + 0.001 * Math.sin(Math.toRadians(this.rotation));
			
			this.speed = Math.sqrt(dx*dx + dy*dy);
			if(dy < 0) {
				this.speed *= -1;
			}
			
			this.direction = Math.toDegrees(Math.acos(dx/speed));
			
			this.speed = Math.min(maxspeed,this.speed);
			this.accel = true;
		
		
	}
	
		// Notkun: s.shoot(b, nextSeat)
    	// Fyrir:  ekkert
    	// Eftir:  s (skipið) skýtur kúlum
	public void shoot(Bullet[] b, int nextSeat) {
			b[nextSeat] = new Bullet(this.x,this.y,this.rotation);
			
			this.shotInterval = 5;
	}
	public int getShotInterval() {
		return this.shotInterval;
	}
	
		// Notkun: s.isImmortal()
    	// Fyrir:  ekkert
    	// Eftir:  s (skipið) er ódauðlegt í ákveðinn tíma
	public boolean isImmortal()
	{
		return (immortalTime <= 0);
	}
	
	// Notkun: s.ReLaunch()
    	// Fyrir:  ekkert
    	// Eftir:  s (skipið) breyturnar x,y,direction,rotation,speed eru upphafsstilltar immortalTime fær 	upphafstímann 20	
	public void ReLaunch() {
		this.x = 0.0;
		this.y = 0.0;
		this.direction = 90.0;
		this.rotation = 90.0;
		this.speed = 0.0;
		this.immortalTime = 20;
	}
    
    public static void main(String[] args) {
    	StdDraw.setCanvasSize(800,800);
		StdDraw.setXscale(-1, 1);
		StdDraw.setYscale(-1, 1);
		
		Bullet b[] = new Bullet[25];
		int noBullets = 0;
		int nextSeat = 0;
		
    	//Ship(double x, double y, double spd, double direction, int rot)
    	Ship s = new Ship(0.0, 0.0, 0.0, 90.0, 90);
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

			s.move();
			for(int i = 0; i < noBullets; i++)
			{
				b[i].move();
				b[i].draw();
			}
	
			s.draw();

			StdDraw.show(20);
			
		}
    }


}