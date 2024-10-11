import java.time.LocalDate;
import java.time.*;


public class Rental {
    private Vehicle rentalVehicle;
    private int durationInDays;

    private int customerNumber;
     private LocalDate returnDate;
     private LocalDate today= LocalDate.now();

     public Rental(Vehicle v,int d,int c){
        rentalVehicle = v;
        durationInDays = d;
        customerNumber = c;
     }
    public String toString(){
         returnDate=today.plusDays(durationInDays);
        String message=rentalVehicle.toString() +" rented for "+durationInDays+" days by customer "+customerNumber+" with return date "+returnDate+ "for a total of $"+rentalVehicle.getDailyRate()*durationInDays;

        return message;

    }
}
