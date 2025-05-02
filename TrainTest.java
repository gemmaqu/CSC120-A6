import static org.junit.Assert.*;
import org.junit.Test;

public class TrainTest {

    // Engine Tests
    @Test
    public void testEngineConstructor() {
        Engine engine = new Engine(FuelType.ELECTRIC, 30, 100);
        FuelType expectedFuelType = FuelType.ELECTRIC;
        double expectedCurrentFuelLevel = 30;
        assertEquals(expectedFuelType, engine.getFuelType());
        assertEquals(expectedCurrentFuelLevel, engine.getCurrentFuel(), 0.001);
    }

    @Test
    public void testEngineGo() {
        Engine engine = new Engine(FuelType.ELECTRIC, 10, 100);
        assertTrue(engine.go()); // fuel will decrease by 2
        assertEquals(8, engine.getCurrentFuel(), 0.001);
        
        assertTrue(engine.go()); // 8.0 -> 6.0
        assertTrue(engine.go()); // 6.0 -> 4.0
        assertTrue(engine.go()); // 4.0 -> 2.0
        assertTrue(engine.go()); // 2.0 -> 0.0
        
        assertFalse(engine.go()); // should return false when out of fuel
    }

    // Car Tests
    @Test
    public void testCarAddPassenger() {
        Car car = new Car(10);
        assertEquals(10, car.seatsRemaining());  
             
        // Adding one passenger
        Passenger oneP = new Passenger("Amy");
        assertTrue(car.addPassenger(oneP));
        assertEquals(9, car.seatsRemaining());

        // Adding another passenger
        Passenger twoP = new Passenger("Bob");
        assertTrue(car.addPassenger(twoP));
        assertEquals(8, car.seatsRemaining());
    }

    @Test
    public void testCarRemovePassenger() {
       Car car = new Car(10);
       Passenger oneP = new Passenger("Alice");
       assertTrue(car.addPassenger(oneP));
       assertEquals(9, car.seatsRemaining());
       
       Passenger twoP = new Passenger("Cat");
       assertTrue(car.addPassenger(twoP));
       assertEquals(8, car.seatsRemaining());
       
       assertTrue(car.removePassenger(twoP)); // Remove the second passenger
       assertEquals(9, car.seatsRemaining());
    }

    // Passenger Tests
    @Test
    public void testPassengerBoardCarWithSpace() {
        Car car1 = new Car(2);
        Passenger one = new Passenger("John");
        
        // Store the initial seats remaining
        int initialSeats = car1.seatsRemaining();
        
        // Call boardCar method
        one.boardCar(car1);
        
        // Check that seats have decreased
        assertEquals(initialSeats - 1, car1.seatsRemaining());
    }

    @Test
    public void testPassengerBoardCarFull() {
        Car car2 = new Car(1);
        Passenger two = new Passenger("Ava");
        Passenger three = new Passenger("John");
        
        // First passenger boards
        two.boardCar(car2);
        assertEquals(0, car2.seatsRemaining()); // Car should be full
        
        // Second passenger tries to board a full car
        three.boardCar(car2);
        assertEquals(0, car2.seatsRemaining()); // Seats should still be 0
    }

    // Train Tests
    @Test
    public void testTrainConstructor() {
        Train train = new Train(FuelType.ELECTRIC, 10, 5, 2, 6);
        assertEquals(5, train.getancar());
    }

    @Test
    public void testTrainPassengerCount() {
        Train trainTwo = new Train(FuelType.ELECTRIC, 10, 2, 2, 6);
        // Total capacity: 2 cars * 2 capacity = 4 seats
        assertEquals(4, trainTwo.getMaxCapacity());
        
        Passenger first = new Passenger("Jane");
        assertTrue(trainTwo.getCar(0).addPassenger(first));
        
        // After adding 1 passenger, we should have 3 seats remaining
        assertEquals(3, trainTwo.seatsRemaining());
    }

    @Test
    public void testTrainGetCar() {
        Train trainThree = new Train(FuelType.ELECTRIC, 10, 5, 2, 5);
        
        // Get the third car (index 2)
        Car thirdCar = trainThree.getCar(2);
        assertNotNull("getCar(2) should return a car", thirdCar);
        
        // Add a passenger to the third car
        Passenger pThree = new Passenger("Alice");
        assertTrue(thirdCar.addPassenger(pThree));
        
        // Verify the car now has one less seat
        assertEquals(1, thirdCar.seatsRemaining());
    }

    @Test
    public void testTrainPrintManifest() {
        // This is a void method that prints to stdout
        // Generally, you would use a system output capture for this kind of test
        // For now, we'll just verify the method doesn't throw an exception
        Train train = new Train(FuelType.ELECTRIC, 10, 2, 2, 5);
        Passenger p1 = new Passenger("Alice");
        assertTrue(train.getCar(0).addPassenger(p1));
        
        try {
            train.printManifest();
            // If we get here, no exception was thrown
            assertTrue(true);
        } catch (Exception e) {
            fail("printManifest() threw an exception: " + e.getMessage());
        }
    }
}