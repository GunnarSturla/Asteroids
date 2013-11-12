public class Rectangle extends Shape
{
	// Viðfangsbreytur
	private double x;
	private double y;
	private double width;
	private double height;

	// Notkun: r = new Rectangle (x, y, width, height)
	// Fyrir: 0 < width, 0 < height
	// Eftir: r er ferhyrningur með miðju í x,y breidd width og hæð height
	public Rectangle(double x, double y, double width, double height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	// Notkun: p = s.getCenter()
    // Fyrir:  ekkert
    // Eftir:  p er miðjan á s
    public Point2D getCenter()
    {
    	return new Point2D(x,y);
    }
    // Notkun: r = s.getBoundingBox()
    // Fyrir:  ekkert
    // Eftir:  r er minnsti ferhyrningur sem passar utan um s
    public Rectangle getBoundingBox()
    {
    	return new Rectangle(x, y, height, width);
    }
    // Notkun: c = s.intersects(o)
    // Fyrir:  ekkert
    // Eftir:  c er true of s og o skarast
    public boolean intersects(Shape o)
    {
   		Rectangle z = o.getBoundingBox();
    	return ((this.width+z.width)/2 > Math.abs(this.x-z.x)) && ((this.height+z.height)/2 > Math.abs(this.y-z.y));
    }
    // Notkun: s.scale(f)
    // Fyrir:  f > 0
    // Eftir:  s er f-sinnum stærra og miðjan er óbreytt
    public void scale(double f)
    {
    	this.width = this.width * f;
        this.height = this.height * f;
    }
    // Notkun: c = s.GetWidth()
    // Fyrir: ekkert
    // Eftir: c = this.width
    public double getWidth()
    {
    	return this.width;
    }
    // Notkun: c = s.GetHeight()
    // Fyrir: ekkert
    // Eftir: c = this.height
    public double getHeight()
    {
        return this.height;
    }
    // Notkun: c = s.SetWidth()
    // Fyrir: ekkert
    // Eftir: c = this.width
    public void setWidth(double k)
    {
        this.width = k;
    }
    // Notkun: c = s.SetHeight()
    // Fyrir: ekkert
    // Eftir: c = this.height
    public void setHeight(double k)
    {
        this.height = k;
    }
    public static void main (String[] args)
    {
        Rectangle test = new Rectangle(2.0,2.0, 2.0, 2.0);
        Rectangle test2 = new Rectangle(3.0, 3.0, 1.0, 1.0);
        System.out.println(test.intersects(test2));
    }
}






/*public class Rectangle
{
	private final double x;
	private final double y;
	private final double width;
	private final double height;
	public Rectangle(double x, double y, double width, double height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public double area()
	{
		return width * height;
	}
	public double perimeter()
	{
		return 2.0 * width + 2.0 * height; 
	}
	public boolean intersects (Rectangle b)
	{
		return (this.lodrett().intersects(b.lodrett()) && this.larett().intersects(b.larett()));
	}
	public boolean contains(Rectangle b)
	{
		//return (this.lodrett().contains(b.lodrett()) && this.larett().intersects(b.larett()));
		return true;
	}
	public void show (Rectangle b)
	{

	}
	public Interval larett()
	{
		return new Interval (x-(width/2.0), x+(width/2.0));
	}
	public Interval lodrett()
	{
		return new Interval (y-(height/2.0), y+(height/2.0));
	}
	public static void main (String[] args)
	{
		while (!StdIn.isEmpty())
		{
			Rectangle b = new Rectangle(StdIn.readDouble(), StdIn.readDouble(), StdIn.readDouble(), StdIn.readDouble());
		}		
	}
}*/