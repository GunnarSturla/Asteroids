public class Game
{
	public static void main(String[] args)
	{
	int N = 20;
	Ship s = new Ship (0.0, 0.0, "skip.jpg", 0.1, 0.2, 90.0);
	//Astroid[] a = new astroid[N];
	/*for (int i = 0; i < N; i++)
	{
		a[i] = Math.random(), Math.random(), 1;

	}*/
	while (true)
	{
		StdDraw.clear();
		StdDraw.picture(s);
		//StdDraw.s;
		StdDraw.show(20);
	}
	}
}