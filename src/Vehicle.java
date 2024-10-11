public abstract class Vehicle {
    private String model;
    private int year;
    private double dailyRate;

    public Vehicle(String m, int y, double d){
        model=m;
        year=y;
        dailyRate=d;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }
    public String toString(){
        return String.valueOf(year)+" "+model+", daily rate: "+String.valueOf(dailyRate);
    }
}
