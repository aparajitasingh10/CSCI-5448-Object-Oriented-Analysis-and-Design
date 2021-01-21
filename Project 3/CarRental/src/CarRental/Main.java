package CarRental;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {

    public static void main(String args[]) throws FileNotFoundException {
        int countDays = 1;
        int availableCars = 24;
        int totalProfit = 0;
        int totalDays = 35;

        PrintStream out = new PrintStream(new File("OUTPUT.txt"));

        PrintStream console = System.out;

        System.setOut(out);
        StringBuilder stringBuilder = new StringBuilder();

        CarRental.OrderObserver obj_obs = new CarRental.OrderObserverClass();

        CarRental.Order obj = new CarRental.Order();
        Random random = new Random();
        ArrayList<RecordBook> record = new ArrayList<RecordBook>();
        while (countDays <= totalDays) {
            int profitOfTheDay = 0;
            int customersToday = random.nextInt(2) + 1; //randomly select between 1 and 2 customers, on any given day.
            boolean bool = true;
            for (int i = 1; i <= customersToday; i++) {
                HashMap<String, String> carProfitMap = obj.order_func(countDays, i, availableCars, record, bool);
                availableCars -= Integer.parseInt(carProfitMap.get("count"));
                profitOfTheDay += Integer.parseInt(carProfitMap.get("total_profit"));
                stringBuilder.append(carProfitMap.get("rental_records"));
                bool = false;
            }
            totalProfit += profitOfTheDay;
            if (countDays == totalDays) {
                obj_obs.updateObserver(countDays, availableCars, profitOfTheDay, totalProfit, stringBuilder.toString());
            } else {
                obj_obs.updateObserver(countDays, availableCars, profitOfTheDay, totalProfit, "Do not print yet");
            }
            countDays++;
        }

/* Creating a runner for MyUnitTest to run the @Test */
        System.out.println("\n\n******************* Calling MyUnitTest: ***************\n");


        Result result = JUnitCore.runClasses(MyUnitTest.class);
        for (Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }

        System.out.println("\n\nSuccessful: " + result.wasSuccessful() + " ran " + result.getRunCount() +" tests");;

        System.out.println("\n\n***************** MyUnitTest: completed *****************\n");
    }
}
