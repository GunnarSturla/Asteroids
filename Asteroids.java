public class Asteroids {
	public static void main(String[] args) {
		StdDraw.setCanvasSize(800,800);
		StdDraw.setXscale(-1, 1);
		StdDraw.setYscale(-1, 1);
		Game game = new Game();
		game.menu();
	}
}