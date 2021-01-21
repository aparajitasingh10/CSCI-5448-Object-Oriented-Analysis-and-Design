package CarRental;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MyUnitTest {

    /*Testing decorator pattern for AddOns to the ECONOMY car*/
    @Test
    public void shouldInitializeAddonForEconomy() {
        Economy obj = new Economy("RHAEGAR");

        assertEquals(10, obj.getGPSModuleCost());
        assertEquals(5, obj.getChildSeatCost());

        System.out.println("Test : shouldInitializeAddonForEconomy() was Successful" );

    }
    /*Negative test for Testing decorator pattern for AddOns to the car*/
    @Test
    public void negativeTest_shouldFailInitializeAddonForEconomy() {
        Economy obj = new Economy("RHAEGAR");

        assertNotEquals(12, obj.getGPSModuleCost());
        assertNotEquals(7, obj.getChildSeatCost());
        System.out.println("Test : negativeTest_shouldFailInitializeAddonForEconomy() was Successful" );

    }


    /* Testing getRemainingCars method*/
    @Test
    public void testgetRemainingCars(){
        TrackDays obj = new TrackDays();
        obj.carsInUse = Arrays.asList("ECO3", "ECO4", "ECO5", "STA1", "STA2", "STA3", "STA4", "STA5", "LUX1", "LUX2", "LUX3", "LUX4", "LUX5", "SUV1", "SUV2", "SUV3", "SUV4", "SUV5", "MIN1", "MIN2","MIN3", "MIN4");
        List<String> carsavailable = Arrays.asList("ECO1", "ECO2");
        List<String> result = obj.getRemainingCars();
        assertEquals(carsavailable,result);

        System.out.println("Test : testgetRemainingCars() was Successful" );

    }

    /*Testing getcarsbeing used list for the Luxury car*/
    @Test
    public void testgetCarListLux(){
        Luxury obj = new Luxury("RHAEGAR");
        List<String> carsBeingUsed = Arrays.asList("L1", "L2","L3","L4","L5");
        obj.carsBeingUsed = carsBeingUsed;
        List<String> result = obj.getCarsBeingUsed();
        assertEquals(carsBeingUsed,result);
        System.out.println("Test : testgetCarListLux() was Successful" );

    }

    /* Testing getRemainingCars negative test method*/
    @Test
    public void testgetRemainingCarsShouldFail(){
        TrackDays obj = new TrackDays();
        obj.carsInUse = Arrays.asList("ECO3", "ECO4", "ECO5", "STA1", "STA2", "STA3", "STA4", "STA5", "LUX1", "LUX2", "LUX3", "LUX4", "LUX5", "SUV1", "SUV2", "SUV3", "SUV4", "SUV5", "MIN1", "MIN2","MIN3", "MIN4");
        List<String> carsavailable = Arrays.asList("ECO1", "ECO2","EC03");
        List<String> result = obj.getRemainingCars();
        assertNotEquals(carsavailable,result);
        System.out.println("Test : testgetRemainingCarsShouldFail() was Successful" );
    }
    /* Testing carsbeingused for the Standard cars*/
    @Test
    public void testcarListStandard(){
        Standard obj = new Standard("RHAEGAR");
        List<String> carsBeingUsed = Arrays.asList("S1", "S2","S3","S4","S5");
        obj.carsBeingUsed = carsBeingUsed;
        List<String> result = obj.getCarsBeingUsed();
        assertEquals(carsBeingUsed,result);

        System.out.println("Test : testcarListStandard() was Successful" );

    }
    /*Testing carsbeingused for the Minivan Cars*/
    @Test
    public void testcarListMinivan(){
        Minivan obj = new Minivan("RHAEGAR");
        List<String> carsBeingUsed = Arrays.asList("M1", "M2","M3","M4","M5");
        obj.carsBeingUsed = carsBeingUsed;
        List<String> result = obj.getCarsBeingUsed();
        assertEquals(carsBeingUsed,result);

        System.out.println("Test : testcarListMinivan() was Successful" );

    }

    /*Testing carsbeingused list for the SUV car*/
    @Test
    public void testcarListSUV(){
        SUV obj = new SUV("RHAEGAR");
        List<String> carsBeingUsed = Arrays.asList("SUV1", "SUV2","SUV3","SUV4","SUV5");
        obj.carsBeingUsed = carsBeingUsed;
        List<String> result = obj.getCarsBeingUsed();
        assertEquals(carsBeingUsed,result);

        System.out.println("Test : testcarListSUV() was Successful" );

    }

    /*Testing decorator pattern for AddOns to the Luxury car*/
    @Test
    public void shouldInitializeAddonForLuxury() {
        Luxury obj = new Luxury("RHAEGAR");
        assertEquals(30, obj.getGPSModuleCost());
        assertEquals(30, obj.getSatelliteRadioCost());

        System.out.println("Test : shouldInitializeAddonForLuxury() was Successful" );



    }
    /*Testing decorator pattern for AddOns to the Standard car*/
    @Test
    public void shouldInitializeAddonForStandard() {
        Standard obj = new Standard("RHAEGAR");

        assertEquals(17, obj.getSatelliteRadioCost());
        assertEquals(7, obj.getChildSeatCost());

        System.out.println("Test : shouldInitializeAddonForStandard() was Successful" );

    }

}


