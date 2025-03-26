import java.util.ArrayList;

public class Train implements TrainRequirements{


    //Attributes
    private ArrayList<Car> cars;
    private int nCars;
    private Engine engine;


    //constructor
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity,double currentfuellevel){
        this.engine = new Engine(fuelType, currentfuellevel, fuelCapacity);
        this.cars = new ArrayList<>();
        for (int i = 0; i < nCars; i++){
            this.cars.add(new Car(passengerCapacity));
        }
    }


    public Engine getEngine() {
        return this.engine;
    }


    public Car getCar(int i) {
        if (i >= 0 && i < cars.size()) {
            return cars.get(i);
        }else{
            return null;
        }
    }

    public int getancar(){
        return cars.size();
    }

    public int getMaxCapacity() {
        int totalCapacity = 0;
        for (Car car : cars) {
            totalCapacity += car.getCapacity();
        }
        return totalCapacity;
    }


    public int seatsRemaining() {
        int remainingSeats = 0;
        for (Car car : cars) {
            remainingSeats += car.seatsRemaining();
        }
        return remainingSeats;
    }
    
 
    public void printManifest() {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println("Car " + i + " Manifest:");
            cars.get(i).printManifest();
        }
    }

    public static void main(String[] args) {
        
        Passenger onePassenger = new Passenger("Anna");
        Passenger bob = new Passenger("bob");
        
        // anothercar.addPassenger(onePassenger);
        // anothercar.addPassenger(bob);
        Train mytrain = new Train(FuelType.ELECTRIC, 100, 10, 50, 30);
        mytrain.getEngine();
        mytrain.cars.get(2).addPassenger(bob);
        mytrain.cars.get(2).addPassenger(onePassenger);
        mytrain.printManifest();

    }
    
}



