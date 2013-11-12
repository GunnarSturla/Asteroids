public class Circle extends Shape
{
    // Viðfangsbreytur
	private double x;
	private double y;
	private double r;

    // Notkun: r = new Rectangle (x, y, r)
    // Fyrir: 0 < r
    // Eftir: r er hringur með miðju í x,y og radius r
	public Circle(double x, double y, double r)
	{
		this.x = x;
		this.y = y;
		this.r = r;
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
    	return new Rectangle(x, y, r*2, r*2);
    }
    // Notkun: c = s.intersects(o)
    // Fyrir:  ekkert
    // Eftir:  c er true ef s og o skarast
    public boolean intersects(Shape o)
    {
   		Rectangle d = this.getBoundingBox();
    	return o.intersects(d);
    }
    // Notkun: s.scale(f)
    // Fyrir:  f > 0
    // Eftir:  s er f-sinnum stærra og miðjan er óbreytt
    public void scale(double f)
    {
    	this.r = this.r * f;
    }
    // Notkun: c = s.GetRadius()
    // Fyrir: ekkert
    // Eftir: c = this.r
    public double getRadius()
    {
        return this.r;
    }
    public static void main(String[] args)
    {
        Circle test = new Circle (2.0, 2.0, 2.0);
        Circle test2 = new Circle (5.0, 5.0, 1.0);
        System.out.println(test.intersects(test2));
    }
}
