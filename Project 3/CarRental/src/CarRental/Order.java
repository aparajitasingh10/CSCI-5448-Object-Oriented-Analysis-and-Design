package CarRental;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Order {

    public HashMap<String, String> order_func(int countDays, int customer_no, int availableCars,
                                              ArrayList<RecordBook> record, boolean bool) {
        //customers and car types are created
        Random random = new Random();
        ArrayList<String> originalCustomerType = new ArrayList<>();
        originalCustomerType.add("REGULAR");
        originalCustomerType.add("CASUAL");
        originalCustomerType.add("BUSINESS");
        ArrayList<String> modifiedCustomerType = new ArrayList<>();
        modifiedCustomerType.add("REGULAR");
        modifiedCustomerType.add("CASUAL");
        ArrayList<String> regularCustomers = new ArrayList<>();
        regularCustomers.add("RHAEGAR");
        regularCustomers.add("DANY");
        regularCustomers.add("VISERYS");
        regularCustomers.add("AEGON");
        ArrayList<String> casualCustomers = new ArrayList<>();
        casualCustomers.add("JOFFERY");
        casualCustomers.add("MYRCELLA");
        casualCustomers.add("TOMMEN");
        casualCustomers.add("SHIREEN");
        ArrayList<String> businessCustomers = new ArrayList<>();
        businessCustomers.add("ROBB");
        businessCustomers.add("SANSA");
        businessCustomers.add("ARYA");
        businessCustomers.add("BRAN");
        ArrayList<String> carTypes = new ArrayList<>();
        carTypes.add("ECONOMY");
        carTypes.add("STANDARD");
        carTypes.add("LUXURY");
        carTypes.add("SUV");
        carTypes.add("MINIVAN");

        /*---------------------------------*/

        ArrayList<String> carsInUse = new ArrayList<>();

        InventoryFactory inventoryFactory = new InventoryFactory();
        carRentalStore crs = new carRentalStore(inventoryFactory);
        StringBuilder stringBuilder = new StringBuilder();

        if (bool) {
            CarRental.TrackDays td = new CarRental.TrackDays();
            List<String> carsRentable = new ArrayList<>();
            carsRentable = td.getRemainingCars();
            System.out.println("***************************** DAY "+countDays+"******************************");
            System.out.println("***************************** NUMBER OF AVAILABLE OF CARS :"+carsRentable.size()+"***************************\n");
            System.out.println("***************************** LIST OF AVAILABLE CARS ************************\n");
            for (int i = 0; i < carsRentable.size(); i++) {
                System.out.print(carsRentable.get(i) + "  ");
                if (i > 1 && i % 10 == 0) {
                    System.out.println("\n");
                }
            }
            System.out.println("\n");
            if (countDays > 1) {
                int k = record.size();
                for (int i = 0; i < k; i++) {
                    System.out.println("Customer Record till day " +i + record.get(i));
                }
            }
        }

        System.out.println("****************************Customer Number: " + customer_no + "***********************************");

        String newCustomerType = "";

        if (availableCars < 3) { //this condition makes sure that business customers don't arrive when there are less than 3 cars
            System.out.println("Choose the type of customer: REGULAR or CASUAL");
            newCustomerType = modifiedCustomerType.get(random.nextInt(1)); //randomly decides the type of incoming customer from modified customer types
        } else {
            System.out.println("Choose the type of customer: REGULAR, CASUAL, BUSINESS"); //randomly decides the type of incoming customer from original customer type
            newCustomerType = originalCustomerType.get(random.nextInt(2));
        }

        System.out.println("HELLO " + newCustomerType + " CUSTOMER! HOW CAN WE HELP YOU TODAY?");
        String customer_name = "";
        int carCount = 0;

        if (newCustomerType.equalsIgnoreCase("REGULAR")) {
            System.out.println("What is your name? 1.RHAEGAR 2.DANY 3.VISERYS 4.AEGON");
            customer_name = regularCustomers.get(random.nextInt(3));  //randomly chooses one of the regular customer to be one the above 4 people
            CarRental.RegularCustomer customerInfo = new CarRental.RegularCustomer(customer_name);
            System.out.println("Hi " + customerInfo.name + " How many cars do you want to rent today? Since you are a regular customer, you can rent 1 - 3 cars \n");
            carCount += (random.nextInt(2)+1);

        } else {
            if (newCustomerType.equalsIgnoreCase("CASUAL")) {
                System.out.println("What is your name? 1.JOFFREY 2.MYRCELLA 3.TOMMEN 4.SHIREEN");
                customer_name = casualCustomers.get(random.nextInt(3));
                CasualCustomer customerInfo = new CasualCustomer(customer_name);
                System.out.println("Hi " + customerInfo.name+" Since you are a casual customer, you can rent only one car \n");
                carCount += 1;
            } else {
                if (newCustomerType.equalsIgnoreCase("BUSINESS")) {
                    System.out.println("What is your name? 1.ROBB 2.SANSA 3.ARYA 4.BRAN");
                    customer_name = businessCustomers.get(random.nextInt(3));
                    BusinessCustomer customerInfo = new BusinessCustomer(customer_name);
                    System.out.println("Hi " + customerInfo.name+" Since you are a business customer, you need to choose 3 cars \n");
                    carCount += 3;
                }
            }
        }
        System.out.println("You are about to rent "+carCount+" cars");
        String[] carModel = new String[carCount];
        int count = carCount;
        int i = 0;

        int netProfit = 0;
        while (carCount > 0) {

            System.out.println("We have the following categories of car : 1. ECONOMY 2. STANDARD 3. LUXURY 4. SUV 5. MINIVAN. So, which one would you like to have?");
            carModel[i] = carTypes.get(random.nextInt(4));
            HashMap<String, String> rentalInformation = crs.carOrder(carModel[i], customer_name, newCustomerType, record);
            if (rentalInformation.containsKey("no_cars")) {
                //All the cars are rented, therefore user must reselect the category
                continue;
            } else {
                netProfit += Integer.parseInt(rentalInformation.get("total"));
                stringBuilder.append(rentalInformation.get("record"));
                stringBuilder.append("###");
                i++;
                carCount--;
            }
        }

        int k = record.size();
        for (i = 0; i < k; i++) {
            System.out.println("Record is " + record.get(i));
        }

        HashMap<String, String> netProfitMap = new HashMap<>();
        netProfitMap.put("total_profit", Integer.toString(netProfit));
        netProfitMap.put("count", Integer.toString(count));
        netProfitMap.put("rental_records", stringBuilder.toString());
        return netProfitMap;
    }
}