package Model;

import java.util.Arrays;

public class Cost {
	
	
	public static double Update(double cost, String nameToCheck){
		if (Arrays.asList(TotalFire.TotalFire2.ListAction).contains(nameToCheck)){
			int positionAction = Arrays.asList(TotalFire.TotalFire2.ListAction).indexOf(nameToCheck);
			double costToAdd = TotalFire.TotalFire2.ListCost[positionAction];
		    double costUp = cost + costToAdd;
		    return costUp;
		}else{
		return cost;
	}
	}

}
