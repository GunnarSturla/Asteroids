public class Ship extends SpaceObject
{
	private int shotInterval, jumpInterval, maxspeed;

	public Ship(double x, double y, double spd, double direction, int rot)
	{
		// SpaceObject(double x, double y, double w, double h, double spd, double dir, int rot)
		super(x, y, 0.05, 0.08, spd, direction, rot);

	}
	
	public void draw() {
			
			//StdDraw.picture(x,y,"grjot-3-"+this.shape+".png",this.generation*0.10,this.generation*0.10,(double)this.rotation);
			
			//(double x, double y, double halfWidth, double halfHeight)
			StdDraw.rectangle(super.x, super.y, (super.w / 2), (super.h/2));
	}
	
	public void turn(int i) {
		this.direction = (this.direction + i*5)%360;
	}
	
	public void accelerate() {
		if(this.speed < maxspeed) this.speed += 0.01;
	}
	
	public void shoot() {
	
	}
	/*public boolean intersects(asteroid o)
	{
   		Rectangle d = this.getBoundingBox();
    	return o.intersects(d);
	}
	public double getX()
    {
    	return this.x;
    }
    public void setX(double k)
    {
    	this.x = k;
    }
     public void setY(double k)
    {
    	this.y = k;
    }
    public double getY()
    {
    	return this.y;
    }
	public double getWidth()
    {
    	return this.w;
    }
    // Notkun: c = s.GetHeight()
    // Fyrir: ekkert
    // Eftir: c = this.height
    public double getHeight()
    {
        return this.h;
    }
    // Notkun: c = s.SetWidth()
    // Fyrir: ekkert
    // Eftir: c = this.width
    public void setWidth(double k)
    {
        this.w = k;
    }
    // Notkun: c = s.SetHeight()
    // Fyrir: ekkert
    // Eftir: c = this.height
    public void setHeight(double k)
    {
        this.h = k;
    }
    public int getLives()
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

    }*/
    
    public static void main(String[] args) {
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
    }


}