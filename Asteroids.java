public class Asteroids {
	private static void play() {
		play(1);
	}
	private static void play(int startlevel, int startlives) {
	/* búa til fjölda asteroids byggt á levelinu (2+startlevel
	
	
	
		*/
		int lives = startlives;
		boolean alive == (lives > 0);
		
		
		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		
		
		
		// The game loop. Here's where the magic happens
		while(alive) {
			// Check for user input
			// Run AI
			// Move enemies / asteroids
			// Resolve collision
				// hitti skotið, rakst skipið á asteroid?
			// Draw graphics
					// Hvernig veit Draw hvað hann á að teikna?
					// vector.java heldur utan um asteroids og skot
					//
			// Play sounds
		}


	}


	public static void main(String[] args) {
		int startlevel = 1;
		int startlives = 3;
	
		Setja inn upphafslevel og lives bygg á input
		if(args.length > 0) {
			startlevel = Integer.parseInt(args(0)); // vantar að passa að sé ekki 0	
		}

		if(args.length > 1) {
			startlevel = Integer.parseInt(args(0)); // vantar að passa að sé ekki 0
			startlives = Integer.parseInt(args(1));	
		}
		
		play(startlevel,startlives);
	}


}