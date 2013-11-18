public class Bullet extends SpaceObject {
	private int timeLeft = 50; // Muna að stilla hraðann!

	public Bullet(double x, double y, int dir) {
		// SpaceObject(double x, double y, double w, double h, double spd, double dir, int rot)
		super(x, y, 0.05 * Math.cos(Math.toRadians(dir)), 0.05 * Math.sin(Math.toRadians(dir)), 0.05, (double)dir, dir);
	}
	
	public void draw() {
		if(timeLeft > 0) {
			StdDraw.line(this.x, this.y, this.x+this.w, this.y+this.h);
			timeLeft--;
		}
	}
	
	/*public Rectangle getBoundinBox {
    	return new Rectangle(x - (0.5*dx), y - (0.5*dy), dx, );
	}*/
	
	public static void main(String[] args) {

		StdDraw.setXscale(-1, 1);
		StdDraw.setYscale(-1, 1);
		
		Bullet b[] = new Bullet[25];
			b[0] = new Bullet(0.0,0.0,(int)(Math.random()*360));
		int noBullets = 1;
		int nextSeat = 1;
		int interval = 0;
		
		while(true) {
			StdDraw.clear();
			if(interval == 50) {
				b[nextSeat] = new Bullet(0.0,0.0,(int)(Math.random()*360));
				if(noBullets < 25) noBullets++;
				nextSeat = (nextSeat + 1) % 25;
				interval = 0;
			}
		//	b[0].move();
		//	b[0].draw();
		
			for(int i = 0; i < noBullets; i++)
			{
				b[i].move();
				b[i].draw();
			}
			
			interval++;
			
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