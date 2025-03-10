public class Engine implements EngineRequirements {

    //attributes
    private FuelType f;
    private double  currentfuellevel;
    private double maxfuellevel;

    //constructor
    /**
     * 
     * @param f
     * @param currentfuellevel
     * @param maxfuellevel
     */
    public Engine(FuelType f, double currentfuellevel, double maxfuellevel){
        this.f = f;
        this.currentfuellevel = currentfuellevel;
        this.maxfuellevel = maxfuellevel;

    }

    public FuelType getFuelType(){
        return this.f;
    }

    public double getMaxFuel(){
        return this.maxfuellevel;
    }

    public double getCurrentFuel(){
        return this.currentfuellevel;

    }

    public void refuel(){
       this.currentfuellevel = this.maxfuellevel;
      
    }
    // above 0 return true, otherwise false, decreasing
    public Boolean go(){
        if (this.currentfuellevel > 0 ){
            this.currentfuellevel -= 2;
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        return "Engine has fuel type: "+this.f+", current fuel level:"+this.currentfuellevel+ ", max fuel level: "+this.maxfuellevel;
    }

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 10.0, 100.0);
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
        System.out.println(myEngine);
    }
}
