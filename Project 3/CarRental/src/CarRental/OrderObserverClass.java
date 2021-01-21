package CarRental;

public class OrderObserverClass implements CarRental.OrderObserver {
    // subscriber class
    public static int countDays =1;
    private static int availableCars = 24;
    private static int profitOfTheDay = 0;
    private  static int netProfit = 0;
    String rental_records;

    public void updateObserver(int day_count,int cars_available,int profit, int totalProfit, String rentals) {
        countDays = day_count;
        availableCars = cars_available;
        profitOfTheDay = profit;
        netProfit = totalProfit;
        rental_records = rentals;
        this.eventAnnouncement();
    }

    public void eventAnnouncement() {
        // announces the information to the output file
        System.out.println("********************* PROFIT MADE ON DAY "+countDays+" IS $"+profitOfTheDay+" ***************************** ");
        System.out.println("********************* TOTAL PROFIT UNTIL THE END OF DAY "+countDays+" IS $"+netProfit+" ************************* ");
        System.out.println("\n\n\n");
        if(!rental_records.equalsIgnoreCase("Do not print yet")) {
            String[] records = rental_records.split("###");
            System.out.println("\n********************** TOTAL RENTALS FINISHED "+records.length+" ***********************\n");
            System.out.println("****************** ALL THE RECORDS FROM THE LAST " +countDays+" DAYS *********************** ");
            for(String record: records) {
                System.out.println(record);
            }
            System.out.println("******************SIMULATION COMPLETED. BYE.*********************** ");
        }
    }
}


