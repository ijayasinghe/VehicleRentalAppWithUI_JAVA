public class Car extends Vehicle{
    enum Type{SMALL,MEDIUM,LARGE}

    private Type vehicleType;

    public Car(String m, int y, double d,Type t){
        super(m,y,d);
        vehicleType = t;
    }
    public  String toString(){
        return vehicleType.toString()+" CAR "+ super.toString();
    }
}
