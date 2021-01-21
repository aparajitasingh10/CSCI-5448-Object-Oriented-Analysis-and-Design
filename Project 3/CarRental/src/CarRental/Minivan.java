package CarRental;

import java.util.*;

public class Minivan extends CarRental.Inventory {
    public enum Cars{
        MIN1, MIN2, MIN3, MIN4
    }

    public List<String> carsBeingUsed = new ArrayList<>();
    private static int count = 4;
    private int cost;
    private String car;
    private int childSeatCost;
    private int GPSModuleCost;
    private int satelliteRadioCost;
    private String customerName;
    private boolean flag = false;
    private static Map<String, Integer> countDays = new HashMap<>();

    public Minivan() {
        for (String key : countDays.keySet()) {
            if ((countDays.get(key) != 0)) {
                countDays.replace(key, countDays.get(key) - 1);
            }
        }

    }

    public Minivan(String customerName) {
        super();
        for (String key : countDays.keySet()) {
            if (countDays.get(key) == 0) {
                carsBeingUsed.remove(key);

            }
        }
        this.customerName = customerName;

        this.childSeatCost = 10;
        this.GPSModuleCost = 15;
        this.satelliteRadioCost = 20;

    }

    public String getCarList() {

        List<String> list = new ArrayList<>();
        list.add("MIN1");
        list.add("MIN2");
        list.add("MIN3");
        list.add("MIN4");

        System.out.println("Cars in Standard are: ");
        if (carsBeingUsed.size() < 4) {
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
        this.cost = 70;
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