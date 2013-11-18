public class Ship extends SpaceObject
{
<<<<<<< HEAD
	public double x, y, direction, speed, rotation;
	private final double w, h;
	private double lives;
	private boolean alive;
    //super(x,y,a,w,h,direction);
	
	public Ship (double x, double y, double w, double h, double speed, double rotation, double direction)
=======
	private int shotInterval, jumpInterval;
	private double maxspeed;
	private boolean accel = false;


	public Ship(double x, double y, double spd, double direction, int rot)
>>>>>>> 218066591cd36d5a78134d41300b249873e2d011
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
        this.speed = speed;
        this.rotation = rotation;
		this.direction = direction;
    }

	//private int shotInterval, jumpInterval, maxspeed;

	//public Ship(double x, double y, double spd, double direction, int rot)
	//{
		// SpaceObject(double x, double y, double w, double h, double spd, double dir, int rot)
<<<<<<< HEAD
		super(x, y, 0.1, 0.1, spd, direction, rot);
=======
<<<<<<< HEAD
	//	super(x, y, 0.05, 0.08, spd, direction, rot);

	//}
	
	//public void turn(int i) {
	//	this.direction = (this.direction + i*5)%360;
	//}
	
	//public void accelerate() {
	//	if(this.speed < maxspeed) this.speed += 0.01;
	//}
	
	//public void shoot() {
	
	//}
//	public boolean intersects(asteroid o)
//	{
//   		Rectangle d = this.getBoundingBox();
//    	return o.intersects(d);
//	}
    public double getSpeed()
    {
        return this.speed;
    }
    public void setSpeed(double k)
    {
        this.speed += k;
    }
    public void shipLeft()
    {
        this.rotation++;
    }
    public void shipRight()
    {
        this.rotation--;
    }
	//public boolean intersects(asteroid o)
	//{
   //		Rectangle d = this.getBoundingBox();
   // 	return o.intersects(d);
	//}
	public double getX()
    {
    	return this.x;
    }
    public void setX()
    {
        return this.x;
        //if(this.x < -1.15 || this.x > 1.15) this.x *= -1;
    } 
   // public void changeX(double k)
    //{
    //	this.x += k;
    //}
   //  public void changeY(double k)
    //{
    //	this.y += k;
    //}
    public double getY()
    {
    	return this.y;
    }
     public void setY(double k)
    {
        this.y += k;
        //if(this.y < -1.15 || this.y > 1.15) this.y *= -1;
    }
    public void draw()
    {
        StdDraw.picture(this.getX(), this.getY(), "S.png", this.getHeight(), this.getWidth(), this.getRotation());
    }
	public double getWidth()
    {
    	return this.w;
    }
    public double getHeight()
    {
        return this.h;
    }
    public double getRotation()
    {
        return this.rotation;
    }
    public double getLives()
    {
    	return this.lives;
    }
    public void setLives(int l)
    {
    	this.lives = l;
    }
    public boolean isAlive()
    {
        return this.alive;
    }
    public void getImage()
    {

    }
    /*public static void main(String[] args)
    {
        Ship s = new Ship (0.0, 0.0, 0.0, 0.1, 0.2, 90.0, 0.0);
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
       // s.draw();
    }*/
=======
		super(x, y, 0.114, 0.1, spd, direction, rot);
>>>>>>> 5406131b2c0d780589f5df89a6026d82efc225fd
	maxspeed = 0.05;
	}
	
	public void draw() {
			if(this.accel) StdDraw.picture(x,y,"grafik/Fire2.png",super.w*2.04,super.h*2,(double)this.rotation);
			StdDraw.picture(x,y,"grafik/ship1.png",super.w*2.04,super.h*2,(double)this.rotation);
			//(double x, double y, double halfWidth, double halfHeight)
			//StdDraw.rectangle(super.x, super.y, (super.w / 2), (super.h/2));
			this.accel = false;
			shotInterval--;
			jumpInterval--;
			this.speed = this.speed * 0.995;
	}
	
	public void turn(int i) {
		this.rotation = (this.rotation + i*7);
	}
	
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
	
	public void shoot(Bullet[] b, int nextSeat) {
			b[nextSeat] = new Bullet(this.x,this.y,this.rotation);
			
			this.shotInterval = 10;
	}
	public int getShotInterval() {
		return this.shotInterval;
	}
	
>>>>>>> 218066591cd36d5a78134d41300b249873e2d011
    
    /*public static void main(String[] args) {
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
    }*/


}