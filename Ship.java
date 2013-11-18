public class Ship extends SpaceObject
{
	private double x, y, direction, speed, rotation;
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
    public void shipLeft()
    {
        this.rotation++;
    }
    public void shipRight()
    {
        this.rotation--;
    }
    public void shipForward()
    {
        this.speed +=0.01;
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
    public void changeX(double k)
    {
    	this.x += k;
    }
     public void changeY(double k)
    {
    	this.y += k;
    }
    public double getY()
    {
    	return this.y;
    }
    public void draw() {
        if(this.isVisible()) {
            StdDraw.picture(this.getX(), this.getY(), "s.png", this.getHeight(), this.getWidth(), this.getRotation());
        }
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
    public double getRotation()
    {
        return this.rotation;
    }
    // Notkun: c = s.SetWidth()
    // Fyrir: ekkert
    // Eftir: c = this.width
    //public void setWidth(double k)
    //{
    //    this.w = k;
    //}
    // Notkun: c = s.SetHeight()
    // Fyrir: ekkert
    // Eftir: c = this.height
    //public void setHeight(double k)
    //{
    //    this.h = k;
    //}
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


}