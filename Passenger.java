

public class Passenger implements PassengerRequirements{
    
    //attribute
    private String name;

    //constructor
    public Passenger(String name) {
        this.name = name;
    }

    public String getname(){
        return this.name;
    }

    public void boardCar(Car c){
        if (c.addPassenger(this)) {
            System.out.println("I am on the car");
        }
    else {
        System.out.println("I don't want to get on the car");
    }
    }

    public void getOffCar(Car c){
        if( c.removePassenger(this)){
            System.out.println("I want to get off the car");
        }
        else{
            System.out.println("I am not on the car");
        }
    
    }


    public static void main(String[] args) {
        Passenger onePassenger = new Passenger("Anna");
        Car busCar = new Car(100);
        onePassenger.boardCar(busCar);
        onePassenger.getOffCar(busCar);
        onePassenger.getOffCar(busCar);
    }
}