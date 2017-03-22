package ParserProg5Fire;


import java.util.ArrayList;
import java.util.HashMap;

import ParserRulesFarms.MELArules;

public class ModelFire {
	
	public static int _SIMULATION_ID;
	public static int numberOfRuns = TotalFire.TotalFire2.numberOfRuns;

	public static void main(String[] args) throws Exception {
			
     	_SIMULATION_ID = 1;
		for(int i = 1; i <= numberOfRuns; i++)
		{   MELAprog5 Parser= new MELAprog5();
		    Parser.parseFromFile("/Users/ludovicaluisavissat/workspacejSSTL/Fire-modelQEST2/src/Model.mela");
 		    System.out.println("Model parsed correctly."); 
	        System.out.println("Simulation -> " + _SIMULATION_ID ); 
			MELArules Parser2= new MELArules();
			Parser2.parseFromFile("/Users/ludovicaluisavissat/GitHub/MELATotalDistance/Rules.txt");
			_SIMULATION_ID++;
		}	
	}
}




