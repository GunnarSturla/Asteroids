public class Bullet extends SpaceObject {
	private int timeLeft = 200;
	private double dx, dy;

	public Bullet(double x, double y, int dir) {
		super(x, y, 0.03, dir, dir);
	}
	
	public void draw() {
		if(timeLeft > 0) {
			dx = x + 0.01 * Math.cos(Math.toRadians(this.getDirection()));
			dy = y + 0.01 * Math.sin(Math.toRadians(this.getDirection()));

			StdDraw.line(x,y,dx,dy);
			timeLeft--;
		}
	}
	
	/*public Rectangle getBoundinBox {
    	return new Rectangle(x - (0.5*dx), y - (0.5*dy), dx, dy);
	}*/
	
	public static void main(String[] args) {

		StdDraw.setXscale(-1, 1);
		StdDraw.setYscale(-1, 1);
		
		Bullet b = new Bullet(0.0,0.0,45);
			
		
		while(true) {
			StdDraw.clear();

			b.move();
			b.draw();
			
			StdDraw.show(20);
			
		}
	}
} /*

 line

public static void line(double x0,
                        double y0,
                        double x1,
                        double y1)

    Draw a line from (x0, y0) to (x1, y1).

    Parameters:
        x0 - the x-coordinate of the starting point
        y0 - the y-coordinate of the starting point
        x1 - the x-coordinate of the destination point
        y1 - the y-coordinate of the destination point

 
 */