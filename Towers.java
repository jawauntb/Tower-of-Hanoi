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



	  // =========================================================================
    public static void solve (int[][] towers) {

	int numRings = towers[0].length;
	print(towers);
	doSolve(towers, 0, 2, 1, numRings);

    } // solve()
    // =========================================================================



    // =========================================================================
    public static void doSolve (int[][] towers, int from, int to, int other, int ringNum) {
	if(ringNum == 1){
	    System.out.println("move the block" + ringNum + " from" + from + "to" + to + "!!"); 
	    print(towers);
	}else{
	    doSolve(towers, from, other, to, (ringNum-1)); /* move smallest piece out of the way */
	    System.out.println("move the block" + ringNum + " from" + from + "to" + to + "!!"); /* show or say where we move to  */
	    print(towers);
	    doSolve(towers, other, to, from, (ringNum-1)); /*move the smalles piece away so larger piece can fit in its location */
	}
	       
       

    } // doSolve()
    // =========================================================================



    // =========================================================================
    public static int[][] initialize (int n) {

	int[][] towers = new int[3][n];
	for (int i = 0; i < n; i += 1) {
	    towers[0][i] = n - i;
	}

	return towers;

    } // initialize()




    // =========================================================================
    public static void print (int[][] towers) {

	int rings = towers[0].length;
	for (int row = rings - 1; row >= 0; row -= 1) {
	    for (int tower = 0; tower < 3; tower += 1) {
		printRing(towers[tower][row], rings);
		System.out.print("\t");
	    }
	    System.out.println();
	}
	System.out.println();

    }
    // =========================================================================



    // =========================================================================
    public static void printRing (int size, int rings) {

	int spaces = rings - size;
	printChar(' ', spaces);
	printChar('=', size);
	printChar('|', 1);
	printChar('=', size);
	printChar(' ', spaces);

    }
    // =========================================================================



    // =========================================================================
    	public static void printChar (char c, int reps) {

		for (int i = 0; i < reps; i += 1) {
		    System.out.print(c);
		}

    }
    // =========================================================================



	public static void showUsageAndExit () {
        System.err.println("Usage: type in your command line the following: java Towers <the num of rings>");
	System.exit(1); 
	}


}
