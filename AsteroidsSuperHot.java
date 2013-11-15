public class AsteroidsSuperHot
{
	public static void main(String[] args)
	{
		StdDraw.setXscale(-1.0, 1.0);
		StdDraw.setYscale(-1.0, 1.0);
		//StdDraw.rectangle(0.5, 0.5, 0.02, 0.04);
		double rx = 0.0, ry = 0.0;
        double vx = 0.001, vy = 0.0023;
        int degrees = 0;
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
        double acx = 0;
        double acy = 0;
        while(true)
        {
        	if (1 <= Math.abs(rx)) {rx *= -1;}
        	if (1 <= Math.abs(ry)) {ry *= -1;}
            if (1 <= Math.abs(c1x)) {c1x *= -1;}
            if (1 <= Math.abs(c1y)) {c1y *= -1;}
            if (1 <= Math.abs(c2x)) {c2x *= -1;}
            if (1 <= Math.abs(c2y)) {c2y *= -1;}
            if (1 <= Math.abs(c3x)) {c3x *= -1;}
            if (1 <= Math.abs(c3y)) {c3y *= -1;}
            if (1 <= Math.abs(c4x)) {c4x *= -1;}
            if (1 <= Math.abs(c4y)) {c4y *= -1;}
            if (1 <= Math.abs(c5x)) {c5x *= -1;}
            if (1 <= Math.abs(c5y)) {c5y *= -1;}
        	if (StdDraw.isKeyPressed(38)||StdDraw.isKeyPressed(87))
            {
                acx += 0.01*Math.sin(Math.toRadians(degrees));
                acy += 0.01*Math.cos(Math.toRadians(degrees));   
                if (acx < 0)  acx = acx%-0.03;
                if (acy < 0)  acy = acy%-0.03;
                if (acx > 0)  acx = acx%0.03;
                if (acy > 0)  acy = acy%0.03;
            }
            /*if (StdDraw.isKeyPressed(40)||StdDraw.isKeyPressed(87))
            {
                if (Math.abs(acx) > 0.0)
                {
                    acx -= 0.01;
                    acy -=0.01;   
               }
            }*/
            if (StdDraw.isKeyPressed(37)||StdDraw.isKeyPressed(83))
            {
                degrees--;
                degrees = degrees%360;
            }
            if (StdDraw.isKeyPressed(39)||StdDraw.isKeyPressed(68))
            {
                degrees++;
                degrees = degrees%360;
            }
        	c1x += vx;
        	c1y += vy;
        	c2x += vx;
        	c2y -= vy;
        	c3x -= vx;
        	c3y -= vy;
        	c4x -= vx;
        	c4y += vy;
        	c5x -= vx;
        	c5y += vy;
            ry += acy;
            rx +=acx;
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