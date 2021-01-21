package CarRental;

public class childSeat extends CarRental.addOnsCost {
    CarRental.Inventory inventory;
    public childSeat(CarRental.Inventory inventory) {
        this.inventory=inventory;
    }
    @Override
    public int getCost() {
        return inventory.getChildSeatCost();
    }
}