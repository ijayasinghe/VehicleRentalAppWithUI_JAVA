public class Truck extends Vehicle{
    private double capacity;

    public Truck(String m, int y, double d,double c){
        super(m,y,d);
        capacity = c;
    }
    public  String toString(){
        return "TRUCK with capacity  "+String.valueOf(capacity)+"kg: "+ super.toString();
    }
}
