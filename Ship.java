public class Ship extends SpaceObject
{
	public double x, y, direction, speed, rotation;
	private final double w, h;
	private double lives;
	private boolean alive;
    //super(x,y,a,w,h,direction);
	
	public Ship (double x, double y, double w, double h, double speed, double rotation, double direction)
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
    
    /*public static void main(String[] args) {
    	StdDraw.setCanvasSize(800,800);
		StdDraw.setXscale(-1, 1);
		StdDraw.setYscale(-1, 1);
    	//Ship(double x, double y, double spd, double direction, int rot)
    	Ship s = new Ship(0.0, 0.0, 0.0, 90.0, 90);
    	while(true) {
    		
    		// left arrow || a
    		if(StdDraw.isKeyPressed(KeyCode.VK_A) || StdDraw.isKeyPressed(a)) s.turn(-1);
    		// right arrow || d
    		if(StdDraw.isKeyPressed(39) || StdDraw.isKeyPressed(w)) s.turn(1);
    		// Up arrow || w
    		if(StdDraw.isKeyPressed(38) || StdDraw.isKeyPressed(KeyCode.VK_W)) s.accelerate();
    		// spacebar || enter
    		if(StdDraw.isKeyPressed(32) || StdDraw.isKeyPressed(13)) s.shoot();
    		
    		
			StdDraw.clear();

			s.move();
			s.draw();
	
			StdDraw.show(20);
			
		}
    }*/


}