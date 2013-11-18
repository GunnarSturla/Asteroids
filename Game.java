public class Game
{
	public static void main(String[] args)
	{
	//int N = 20;
	Ship s = new Ship (0.0, 0.0, 0.0, 0.1, 0.2, 90.0, 0.0);
	//Astroid[] a = new astroid[N];
	/*for (int i = 0; i < N; i++)
	{
		a[i] = Math.random(), Math.random(), 1;

	}*/
	while (true)
	{
		StdDraw.setXscale(-1.0, 1.0);
		StdDraw.setYscale(-1.0, 1.0);
		if (StdDraw.isKeyPressed(38)||StdDraw.isKeyPressed(87))
        {
        	s.shipForward();
        }
        if (StdDraw.isKeyPressed(37)||StdDraw.isKeyPressed(65))
        {
            s.shipLeft();
        }
        if (StdDraw.isKeyPressed(39)||StdDraw.isKeyPressed(68))
        {
            s.shipRight();
        }
		StdDraw.clear();
		s.draw();
		//StdDraw.s;
		StdDraw.show(20);
	}

	}
}