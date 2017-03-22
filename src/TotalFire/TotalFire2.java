package TotalFire;

import CreateModel2.WriteAllModelQEST2;
import ParserProg5Fire.ModelFire;

public class TotalFire2 {
	
	public static int initialDimX = 25;   	
	public static int initialDimY = 25;
		
	//parameters
	public static double oN = 1.0;
	public static double pN = 1.0;
	public static double oS = 1.0;
	public static double pS = 1.0;
	public static double oE = 1.0;
	public static double pE = 1.0;
	public static double oSS = 1.0;
	public static double pSS = 1.0;
	public static double oNN = 1.0;
	public static double pNN = 1.0;
	public static double f = 0.5;
	public static double pf = 1.0;

	public static int rangeMovement = 1;
	public static int rangeFire = 1;
	
	public static int numberOfRuns = 1;
	public static int simulationTime = 11;
	
	public static int DangerLineX = 12;
	public static int DangerLineY = 12;
	
	public static int[] ZoneSafeX = {0,0,24,24};
	public static int[] ZoneSafeY = {0,24,0,24};
	
	public static int[] ZoneOSX = {0,11,11,24};
	public static int[] ZoneOSY = {11,0,24,11};
	
	public static int[] ZoneONX = {0,13,13,24};
	public static int[] ZoneONY = {13,0,24,13};
	
	public static int[] BurningX = {5};
	public static int[] BurningY = {5};
	
	public static int[] OccupiedX = {12,12,11,13};
	public static int[] OccupiedY = {11,13,12,12};
	
	public static int[] CentralX = {12};
	public static int[] CentralY = {12};
	
	
	//cost analysis
	public static String[] ListAction = {};
	public static double[] ListCost = {};
	
	public static void main(String[] args) throws Exception {
	
        //WriteAllModelQEST2.PrintAll();
		ModelFire.main(null);
     	

	}

}

