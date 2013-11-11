public class AsteroidsSuperHot
{
	public static void main(String[] args)
	{
		StdDraw.setXscale(-1.0, 1.0);
		StdDraw.setYscale(-1.0, 1.0);
		//StdDraw.rectangle(0.5, 0.5, 0.02, 0.04);
		double rx = 0.0, ry = 0.0;
        double vx = 0.001, vy = 0.0023;
        double c1x = 0.0;
        double c1y = 0.0;
        double c2x = 0.1;
        double c2y = 0.7;
        double c3x = 0.9;
        double c3y = 0.8;
        double c4x = 0.5;
        double c4y = 0.2;
        double c5x = 0.86;
        double c5y = 0.4;
        double ac = 0;
        while(true)
        {
        	if (1 <= Math.abs(rx)) {rx *= -1;}
        	if (1 <= Math.abs(ry)) {ry *= -1;}
        	if (StdDraw.isKeyPressed(38)||StdDraw.isKeyPressed(87))
                        {
                                if (ac < 0.5)
                                {
                                     ac += 0.01;   
                                }
                        }
        	/*c1x += vx;
        	c1y += vy;
        	c2x += vx;
        	c2y -= vy;
        	c3x -= vx;
        	c3y -= vy;
        	c4x -= vx;
        	c4y += vy;
        	c5x -= vx;
        	c5y += vy;*/
                ry += ac;
        	StdDraw.clear();
        	StdDraw.rectangle(rx, ry, 0.02, 0.04);
        	StdDraw.circle(c1x, c1y, 0.1);
			StdDraw.circle(c2x, c2y, 0.05);
			StdDraw.circle(c3x, c3y, 0.05);
			StdDraw.circle(c4x, c4y, 0.1);
			StdDraw.circle(c5x, c5y, 0.05);
        	StdDraw.show(20);
        }
	}
}