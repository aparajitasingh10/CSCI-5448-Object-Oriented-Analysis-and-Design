package CarRental;

public class GPSModule extends CarRental.addOnsCost {
    CarRental.Inventory inventory;
    public GPSModule(CarRental.Inventory inventory) {
        this.inventory=inventory;
    }
    @Override
    public int getCost() {
        return inventory.getGPSModuleCost();
    }
}