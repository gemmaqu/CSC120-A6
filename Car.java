import java.security.AlgorithmParametersSpi;
import java.util.ArrayList;
// import Passenger;

public class Car implements CarRequirements{

    

    //Attributes
    private int Capacity;
    private ArrayList<Passenger> Passengeronboard;
    private int Currentpassengers;

    //constructor
    public Car(int Capacity){
        this.Capacity = Capacity;
        this.Passengeronboard = new ArrayList<Passenger>(Capacity);
        this.Currentpassengers = 0;
    }
        
        
    public int getCapacity(){
        return this.Capacity;
    }

    public int seatsRemaining(){
        return this.Capacity - this.Currentpassengers;
    }

    public Boolean addPassenger(Passenger p){
        if (seatsRemaining() > 0){
            this.Currentpassengers += 1;
            this.Passengeronboard.add(p);
            return Boolean.TRUE;    
        }
        else{
            return Boolean.FALSE;
        }
    }

    public Boolean removePassenger(Passenger p){
        if (this.Passengeronboard.contains(p)){
            this.Currentpassengers -= 1;
            this.Passengeronboard.remove(p);
            return Boolean.TRUE;
        }
        else{
            return Boolean.FALSE;
        }
    }

    public void printManifest(){
        if (this.Currentpassengers == 0){
            System.out.println("This car is EMPTY.");
        }
        for(int i=0;i<this.Passengeronboard.size();i++){
            
            System.out.println(this.Passengeronboard.get(i).getname());
            
        }

    }

    public static void main(String[] args) {
        Car mycar = new Car(1);
        Passenger onePassenger = new Passenger("Anna");
        Passenger bob = new Passenger("bob");
        mycar.removePassenger(onePassenger);
        mycar.printManifest();

    }



   }



