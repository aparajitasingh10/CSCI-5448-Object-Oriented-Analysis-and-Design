package CarRental;

import java.util.*;

public class TrackDays {
    // this class keeps track of the available cars and rented cars

    public List<String> carsInUse = new ArrayList<>(); //list of cars that has been rented
    public TrackDays() {
        CarRental.Economy a = new CarRental.Economy();
        Standard b = new Standard();
        Luxury c = new Luxury();
        SUV d = new SUV();
        Minivan e = new Minivan();

        for(String k : a.getCarsBeingUsed())
            carsInUse.add(k);
        for(String k : b.getCarsBeingUsed())
            carsInUse.add(k);
        for(String k : c.getCarsBeingUsed())
            carsInUse.add(k);
        for(String k : d.getCarsBeingUsed())
            carsInUse.add(k);
        for(String k : e.getCarsBeingUsed())
            carsInUse.add(k);
    }

    public List<String> getRemainingCars() {
        List<String> carsList = Arrays.asList("ECO1", "ECO2", "ECO3", "ECO4", "ECO5", "STA1", "STA2", "STA3", "STA4", "STA5", "LUX1", "LUX2", "LUX3", "LUX4", "LUX5", "SUV1", "SUV2", "SUV3", "SUV4", "SUV5", "MIN1", "MIN2","MIN3", "MIN4");
        List<String> result = difference(carsList, carsInUse);  //result will have the available cars.
        return result;
    }
    public <T> List<T> difference(List<T> list1, List<T> list2) {
        List<T> result = new ArrayList<T>();
        Set<T> set2 = new HashSet<T>(list2);
        for (T t1 : list1) {
            if( !set2.contains(t1) ) {
                result.add(t1);
            }
        }
        return result;
    }

}
