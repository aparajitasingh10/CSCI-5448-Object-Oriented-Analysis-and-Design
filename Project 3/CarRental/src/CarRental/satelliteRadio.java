package CarRental;

public class satelliteRadio extends CarRental.addOnsCost {
    CarRental.Inventory inventory;
    public satelliteRadio(CarRental.Inventory inventory) {
        this.inventory=inventory;
    }
    @Override
    public int getCost() {
        return inventory.getSatelliteRadioCost();
    }
}