package CreateModel2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import ParserProg5Fire.ModelFire;


public class WriteAllModelQEST2 {	
	static String Model;
    
	public static void PrintAll(){	
		
    Model = "/Users/ludovicaluisavissat/workspacejSSTL/Fire-modelQEST2/src/Model";
 		  		
    PrintWriter writer_model = null;
	try {
		writer_model = new PrintWriter(Model+".mela", "UTF-8");		
	} catch (FileNotFoundException | UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

writer_model.println("#Space: TwoD(" + TotalFire.TotalFire2.initialDimX + "," + TotalFire.TotalFire2.initialDimY + ")\n" +
			"#Parameters");	

   writer_model.println("oN" +  "= " + TotalFire.TotalFire2.oN + ";");
   writer_model.println("pN" + "= " + TotalFire.TotalFire2.pN + ";");
   writer_model.println("oS" +  "= " + TotalFire.TotalFire2.oS + ";");
   writer_model.println("pS" + "= " + TotalFire.TotalFire2.pS + ";");
   writer_model.println("oE" +  "= " + TotalFire.TotalFire2.oE + ";");
   writer_model.println("pE" + "= " + TotalFire.TotalFire2.pE + ";");
   writer_model.println("oSS" +  "= " + TotalFire.TotalFire2.oSS + ";");
   writer_model.println("pSS" + "= " + TotalFire.TotalFire2.pSS + ";");
   writer_model.println("oNN" +  "= " + TotalFire.TotalFire2.oNN + ";");
   writer_model.println("pNN" + "= " + TotalFire.TotalFire2.pNN + ";");
   writer_model.println("f" +  "= " + TotalFire.TotalFire2.f + ";");
   writer_model.println("pf" + "= " + TotalFire.TotalFire2.pf + ";");
   
   writer_model.println(" ");
   
writer_model.println("#Agents");
//this part is for O(l)
writer_model.println("O(l) := ->{N(" + TotalFire.TotalFire2.rangeMovement + ")}(occupiedN, oN).OS(l) + ->{N(" + TotalFire.TotalFire2.rangeMovement + ")}(occupiedS, oS).ON(l) + ->{N(" + TotalFire.TotalFire2.rangeMovement + ")}(occupiedE, oE).P(l);");				;		
//this part is for E(l) 
writer_model.println("EM(l) := <-(occupiedE,pE).O(l) +  <-(occupiedSS,pSS).O(l) +  <-(occupiedNN,pNN).O(l);"); 
//this part is for NN(l) 
writer_model.println("NN(l) := <-(occupiedN,pN).O(l);");
//this part is for SS(l) 
writer_model.println("SS(l) := <-(occupiedS,pS).O(l);");
//this part is for OS(l) 
writer_model.println("OS(l) := ->{N(" + TotalFire.TotalFire2.rangeMovement + ")}(occupiedSS,oSS).P(l);");
//this part is for ON(l) 
writer_model.println("ON(l) := ->{N(" + TotalFire.TotalFire2.rangeMovement + ")}(occupiedNN,oNN).P(l);");

//this part is for B(l) 
writer_model.println("B(l) := ->{N(" + TotalFire.TotalFire2.rangeFire + ")}(fire,f).B(l);");
//this part is for I(l) 
writer_model.println("I(l) := <-(fire,pf).B(l);");

//this part is for Safe(l) 
writer_model.println("SF(l) := ;");

//this part is for Passed Locations 
writer_model.println("P(l) := ;");

//Initial Conditions:
    writer_model.println(" ");
	writer_model.println("#Initial conditions");	
	
	ArrayList<ArrayList<Integer>> listLoc = new ArrayList<>();
	for (int i=0; i <TotalFire.TotalFire2.initialDimX; i++){
		for (int j=0; j <TotalFire.TotalFire2.initialDimY; j++){
			ArrayList<Integer> newL = new ArrayList<>();
			newL.add(i);
			newL.add(j);
			listLoc.add(newL);
			}
		}
	
	ArrayList<ArrayList<Integer>> listLocNotFire = new ArrayList<>();
	for (int i=0; i <TotalFire.TotalFire2.initialDimX; i++){
		for (int j=0; j <TotalFire.TotalFire2.initialDimY; j++){
			ArrayList<Integer> newL2 = new ArrayList<>();
			newL2.add(i);
			newL2.add(j);
			listLocNotFire.add(newL2);
			}
		}
	
	//Agents central
	for (int i=0; i <TotalFire.TotalFire2.CentralX.length; i++){
		ArrayList<Integer> newL = new ArrayList<>();
		newL.add(TotalFire.TotalFire2.CentralX[i]);
		newL.add(TotalFire.TotalFire2.CentralY[i]);
		writer_model.print("P(" + TotalFire.TotalFire2.CentralX[i] + "," + TotalFire.TotalFire2.CentralY[i] + ")[1]||");
		int remove = listLoc.indexOf(newL);
		listLoc.remove(remove);					
	}
	
	//Agents O
	for (int i=0; i <TotalFire.TotalFire2.OccupiedX.length; i++){
		ArrayList<Integer> newL = new ArrayList<>();
		newL.add(TotalFire.TotalFire2.OccupiedX[i]);
		newL.add(TotalFire.TotalFire2.OccupiedY[i]);
		writer_model.print("O(" + TotalFire.TotalFire2.OccupiedX[i] + "," + TotalFire.TotalFire2.OccupiedY[i] + ")[1]||");
		int remove = listLoc.indexOf(newL);
		listLoc.remove(remove);					
	}
	
	//Agents S
	for (int i=0; i <TotalFire.TotalFire2.ZoneOSX.length; i++){
		ArrayList<Integer> newL = new ArrayList<>();
		newL.add(TotalFire.TotalFire2.ZoneOSX[i]);
		newL.add(TotalFire.TotalFire2.ZoneOSY[i]);
		writer_model.print("SS(" + TotalFire.TotalFire2.ZoneOSX[i] + "," + TotalFire.TotalFire2.ZoneOSY[i] + ")[1]||");
		int remove = listLoc.indexOf(newL);
		listLoc.remove(remove);				
	}
	
	//Agents N
	for (int i=0; i <TotalFire.TotalFire2.ZoneONX.length; i++){
		ArrayList<Integer> newL = new ArrayList<>();
		newL.add(TotalFire.TotalFire2.ZoneONX[i]);
		newL.add(TotalFire.TotalFire2.ZoneONY[i]);
		writer_model.print("NN(" + TotalFire.TotalFire2.ZoneONX[i] + "," + TotalFire.TotalFire2.ZoneONY[i] + ")[1]||");
		int remove = listLoc.indexOf(newL);
		listLoc.remove(remove);					
	}
	
	//Danger agents Horizontal
	for (int i=0; i <TotalFire.TotalFire2.initialDimX; i++){
		ArrayList<Integer> newL = new ArrayList<>();
		newL.add(i);
		newL.add(TotalFire.TotalFire2.DangerLineY);
		int remove = listLoc.indexOf(newL);
		if (listLoc.contains(newL)){
		writer_model.print("EM(" + i + "," + TotalFire.TotalFire2.DangerLineY + ")[1]||");			
		listLoc.remove(remove);
		}
	}	
	
	//Danger agents Vertical
	for (int i=0; i <TotalFire.TotalFire2.initialDimY; i++){
		ArrayList<Integer> newL = new ArrayList<>();
		newL.add(TotalFire.TotalFire2.DangerLineX);
		newL.add(i);
		int remove = listLoc.indexOf(newL);
		if (listLoc.contains(newL)){
		writer_model.print("EM(" + TotalFire.TotalFire2.DangerLineX + "," + i + ")[1]||");	
		listLoc.remove(remove);
		}
	}
	
	//safety zone
	for (int i=0; i <TotalFire.TotalFire2.ZoneSafeX.length; i++){
			ArrayList<Integer> newL = new ArrayList<>();
			newL.add(TotalFire.TotalFire2.ZoneSafeX[i]);
			newL.add(TotalFire.TotalFire2.ZoneSafeY[i]);
			writer_model.print("SF(" + TotalFire.TotalFire2.ZoneSafeX[i] + "," + TotalFire.TotalFire2.ZoneSafeY[i] + ")[1]||");
			int remove = listLoc.indexOf(newL);
			listLoc.remove(remove);	
		}
	
	for (int i=0; i <TotalFire.TotalFire2.ZoneSafeX.length; i++){
		ArrayList<Integer> newL2 = new ArrayList<>();
		newL2.add(TotalFire.TotalFire2.ZoneSafeX[i]);
		newL2.add(TotalFire.TotalFire2.ZoneSafeY[i]);
		int remove = listLocNotFire.indexOf(newL2);
		listLocNotFire.remove(remove);
	}
	
	//burning locations
	for (int i=0; i <TotalFire.TotalFire2.BurningX.length; i++){
			ArrayList<Integer> newL = new ArrayList<>();
			newL.add(TotalFire.TotalFire2.BurningX[i]);
			newL.add(TotalFire.TotalFire2.BurningY[i]);
			writer_model.print("B(" + TotalFire.TotalFire2.BurningX[i] + "," + TotalFire.TotalFire2.BurningY[i] + ")[1]||");
			int remove = listLoc.indexOf(newL);
			if (listLoc.contains(newL)){
			listLoc.remove(remove);			
			}		
		}
	
	for (int i=0; i <TotalFire.TotalFire2.BurningX.length; i++){
		ArrayList<Integer> newL2 = new ArrayList<>();
		newL2.add(TotalFire.TotalFire2.BurningX[i]);
		newL2.add(TotalFire.TotalFire2.BurningY[i]);
		int remove = listLocNotFire.indexOf(newL2);
		listLocNotFire.remove(remove);			
	}

	
	int lastList = listLocNotFire.size() - 1;
	for (int i=0; i < lastList; i++){
		writer_model.print("I(" + listLocNotFire.get(i).get(0) + "," + listLocNotFire.get(i).get(1) + ")[1]||");		
	}
	
	writer_model.print("I(" + listLocNotFire.get(lastList).get(0) + "," + listLocNotFire.get(lastList).get(1) + ")[1]");		
	writer_model.println(" ");

writer_model.close();
}



	  //used in SimulatorFire
    public static String Log (){	
    	String log = "/Users/ludovicaluisavissat/workspacejSSTL/Fire-modelQEST2/src/Output/Log/Output" +  ModelFire._SIMULATION_ID;
    	return log;
    }

    //used in SimulatorFire
    public static String Meta (){	
    	String meta = "/Users/ludovicaluisavissat/workspacejSSTL/Fire-modelQEST2/src/Output/Meta/Output" +  ModelFire._SIMULATION_ID;
    	return meta;
    }


    //used in SimulatorFire
    public static String Data (){	
    	String data = "/Users/ludovicaluisavissat/workspacejSSTL/Fire-modelQEST2/src/Output/Data/Output" +  ModelFire._SIMULATION_ID;
        return data;
    }
    
    //used in SimulatorFire
    public static String Cost (){	
    	String data = "/Users/ludovicaluisavissat/workspacejSSTL/Fire-modelQEST2/src/Output/Cost/Output" +  ModelFire._SIMULATION_ID;
        return data;
    }
    }
