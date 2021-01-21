package CarRental;

import java.util.*;

public class Standard extends CarRental.Inventory {
    public enum Cars{
        STA1, STA2, STA3, STA4, STA5
    }

    public List<String> carsBeingUsed = new ArrayList<>();
    private static int count = 5;
    private int cost;
    private String car;
    private int childSeatCost;
    private int GPSModuleCost;
    private int satelliteRadioCost;
    private String customerName;
    private boolean flag = false;
    private static Map<String, Integer> countDays = new HashMap<>();

    public Standard() {
        for (String key : countDays.keySet()) {
            if ((countDays.get(key) != 0)) {
                countDays.replace(key, countDays.get(key) - 1);
            }
        }

    }

    public Standard(String customerName) {
        super();
        for (String key : countDays.keySet()) {
            if (countDays.get(key) == 0) {
                carsBeingUsed.remove(key);

            }
        }
        this.customerName = customerName;

        this.childSeatCost = 7;
        this.GPSModuleCost = 12;
        this.satelliteRadioCost = 17;

    }

    public String getCarList() {

        List<String> list = new ArrayList<>();
        list.add("STA1");
        list.add("STA2");
        list.add("STA3");
        list.add("STA4");
        list.add("STA5");

        System.out.println("Cars in Standard are: ");
        if (carsBeingUsed.size() < 5) {
            for (Cars c : Cars.values()) {
                System.out.println(c.name());
            }
        } else {
            if (carsBeingUsed.size() == 5) {
                return "No cars in this category are available";
            }
        }

        String carRented = getRandomNumber(list);
        while (flag == false) {
            if (carsBeingUsed.contains(carRented)) {
                System.out.println("Car " + carRented + " is already rented. You can rent some other car");
                carRented = getRandomNumber(list);
            } else {
                flag = true;
            }
        }
        carsBeingUsed.add(carRented);
        return carRented;
    }

    public String getRandomNumber(List<String> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    @Override
    public void setCost() {
        this.cost = 60;
    }

    @Override
    public int getCarCounts() {
        return carsBeingUsed.size();
    }

    public void update_days(String carSelection, int days) {
        countDays.put(carSelection, days);
    }

    @Override

    public int getCost() {
        return cost;
    }

    @Override

    public int getChildSeatCost() {
        return this.childSeatCost;
    }

    @Override

    public int getGPSModuleCost() {
        return this.GPSModuleCost;
    }

    @Override

    public int getSatelliteRadioCost() {
        return this.satelliteRadioCost;
    }

    @Override

    public List<String> getCarsBeingUsed() {
        return carsBeingUsed;
    }

}