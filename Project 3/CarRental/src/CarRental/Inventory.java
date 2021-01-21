package CarRental;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Inventory {
    /*Car rental inventory*/

    static List<String> carsBeingUsed = new ArrayList<>();
    int count = 5;
    String car = "Not Defined";
    int cost = 0;
    String customerName = "Not Defined";
    int childSeatCost = 0;
    int GPSModuleCost = 0;
    int satelliteRadioCost = 0;

    Map<String,Integer> days_count = new HashMap<>();
    public abstract int getCost();
    public String getCarList() {
        return car;
    }
    public int getCarCounts() {
        return count;
    }
    public List<String> getCarsBeingUsed(){
        return carsBeingUsed;
    }
    public void update_days(String customerName, int days) {
    }
    public int getChildSeatCost() {
        return childSeatCost;
    }
    public int getGPSModuleCost() {
        return GPSModuleCost;
    }

    public int getSatelliteRadioCost() {
        return satelliteRadioCost;
    }
    public  void setCost() {

    }
}
