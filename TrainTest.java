
import java.lang.classfile.AnnotationValue;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
//import static org.junit.Assert.*;
import org.junit.Test;


public class TrainTest {

    // Engine Tests
    @Test
    public void testEngineConstructor() {
        Engine engine = new Engine(FuelType.ELECTRIC, 30, 100);
        FuelType expectedFuelType = FuelType.ELECTRIC;
        double expectedcurrentfuellevel = 30;
        FuelType actuaFuelType = engine.getFuelType();
        double actualcurrentfuellevel = engine.getCurrentFuel();
        assertEquals(expectedFuelType, actuaFuelType);
        assertEquals(expectedcurrentfuellevel, actualcurrentfuellevel, 0.001);

    
    }

    @Test
    public void testEngineGo() {
        Engine engine = new Engine(FuelType.ELECTRIC, 10, 100);
        assertTrue(engine.go());//fuel will decrease by 2
        assertEquals(8, engine.getCurrentFuel(),0.001);
        
        assertTrue(engine.go()); // 8.0 -> 6.0
        assertTrue(engine.go()); // 6.0 -> 4.0
        assertTrue(engine.go()); // 4.0 -> 2.0
        assertTrue(engine.go()); 

        assertFalse(engine.go());

    }

    // Car Tests
    @Test
    public void testCarAddPassenger() {
        Car car = new Car(10);
        assertEquals(10, car.seatsRemaining(),0.001);  
             
        //adding one passenger
        Passenger onep = new Passenger("Amy");
        assertTrue(car.addPassenger(onep));
        assertEquals(9, car.seatsRemaining(), 0.001);

        //adding another passenger
        Passenger twop = new Passenger("Bob");
        assertTrue(car.addPassenger(twop));
        assertEquals(8, car.seatsRemaining(), 0.001);
    }

    @Test
    public void testCarRemovePassenger() {
       Car car = new Car(10);
       Passenger onep = new Passenger("Alice");
       car.addPassenger(onep);
       Passenger twop = new Passenger("Cat");
       car.addPassenger(twop);
       car.removePassenger(twop);//remove the second passenger
       assertEquals(9, car.seatsRemaining(),0.001);
    }

    // Passenger Tests
    @Test
    public void testPassengerBoardCarWithSpace() {
        Car car1 = new Car(2);
        Passenger one = new Passenger("John");
        one.boardCar(car1);  
        assertTrue(car1.containsPassenger(one));


    }

    @Test
    public void testPassengerBoardCarFull() {
        Car car2 = new Car(1);
        Passenger two = new Passenger("Ava");
        two.boardCar(car2);
        assertFalse(car2.containsPassenger(two));
        }

    // Train Tests
    @Test
    public void testTrainConstructor() {
        
    }

    @Test
    public void testTrainPassengerCount() {
        fail();
    }

    @Test
    public void testTrainGetCar() {
        fail();
    }

    @Test
    public void testTrainPrintManifest() {
        fail();
    }
    
}
