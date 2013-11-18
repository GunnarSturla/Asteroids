public class Point2D {
    private final double x,y;

    public Point2D(double x, double y) {
	this.x = x;
	this.y = y;
    }

    public double getX() { return x;}
    
    public double getY() { return y;}
    
    // Notkun: x = a.distanceTo(b)
    // Fyrir: ekkert
    // Eftir: x er fjarlægðin milli a og b (í tvívíðu rúmi)
    public double distanceTo(Point2D b)
    {
    	double width = Math.abs(this.x - b.getX());
    	double height = Math.abs(this.y - b.getY());
    	return Math.sqrt(width*width + height*height);
    }
    
	// Notkun: s = a.toString()
	// Fyrir:  ekkert
	// Eftir:  s is a string representation of a
    public String toString() {
    	return this.x + "," + this.y;
    }
    

    public static void main(String[] args) {
    	double x1 = Double.parseDouble(args[0]);
    	double y1 = Double.parseDouble(args[1]);
    	double x2 = Double.parseDouble(args[2]);
    	double y2 = Double.parseDouble(args[3]);
    	
    	Point2D p1 = new Point2D(x1,y1);
    	Point2D p2 = new Point2D(x2,y2);
    
    	System.out.println(p1.distanceTo(p2));
    }
}


