public class Towers{
	/* main class where action will happen */

	public static void main (String [] args) {
	
	//if we give the wrong number of args then show usage and exit

	if (args.length != 1) {
		showUsageAndExit();
	}
	// Grab the argument.
	int rings = 0;
	try {
	    rings = Integer.parseInt(args[0]);
	} catch (NumberFormatException e) {
	    showUsageAndExit();
	}
	if (rings < 0) {
	    showUsageAndExit();
	}

	int[][] towers = initialize(rings);
	solve(towers); 
	} // main()

	public static void showUsageAndExit () {
        System.err.println("Usage: type in your command line the following: java Towers <the num of rings>");
	System.exit(1); 
	}


}
