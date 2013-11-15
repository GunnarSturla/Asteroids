public class Ship extends SpaceObject
{
	private double x, y;
	private final double w, h;
	private int lives, direction;
	private boolean alive; 
	
	public Ship (double x, double y, double, w, double h, int lives, int direction, boolean alive)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.lives = lives;
		this.direction = direction;
		this.alive = alive;
	}
	public boolean intersects(asteroid o)
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


}