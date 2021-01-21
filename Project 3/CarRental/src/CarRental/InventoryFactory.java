package CarRental;

public class InventoryFactory {
    public CarRental.Inventory createCarInventory(String carTypes, String customerName) {
        if(carTypes == null) {
            return null;
        }
        if(carTypes.equalsIgnoreCase("ECONOMY")) {
            return new CarRental.Economy(customerName);
        }
        else if(carTypes.equalsIgnoreCase("STANDARD")) {
            return new CarRental.Standard(customerName);
        }
        else if(carTypes.equalsIgnoreCase("LUXURY")) {
            return new CarRental.Luxury(customerName);
        }
        else if(carTypes.equalsIgnoreCase("SUV")) {
            return new CarRental.SUV(customerName);
        }
        else if(carTypes.equalsIgnoreCase("MINIVAN")) {
            return new CarRental.Minivan(customerName);
        }
        return null;

    }

}
