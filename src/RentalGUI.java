import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.file.Path;

public class RentalGUI extends JFrame implements ActionListener {
    private JLabel vehicleLbl;
    private JComboBox<String> vehicleList;
    private JLabel durationLbl;
    private JComboBox<Integer> durationList;
    private JLabel customerNoLbl;
    private JTextArea customerNoIn;
    private JButton rentBtn;
    private JButton displayBtn;

    public ArrayList<Vehicle> vehicleArray = new ArrayList<Vehicle>();

    public ArrayList<Rental> rentalVehicleList = new ArrayList<Rental>();
    Path file = Paths.get("src/Vehicles.txt");
    public Rental tempRental;

    public RentalGUI(){

        super("Rental GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0,2));
        readVehicleList();

        vehicleLbl = new JLabel("Vehicle:");
        durationLbl = new JLabel("Duration in days:");
        customerNoLbl = new JLabel("Customer Number: ");
        customerNoIn = new JTextArea("");

        vehicleList = new JComboBox<String>();
        for(Vehicle val:vehicleArray){
            vehicleList.addItem(val.toString());
        }


        durationList = new JComboBox<Integer>();
        for(int i=1;i<=21;i++){
            durationList.addItem(i);
        }

        rentBtn = new JButton("Rent");
        displayBtn = new JButton("Display all rentals");

        add(vehicleLbl);
        add(vehicleList);
        add(durationLbl);
        add(durationList);
        add(customerNoLbl);
        add(customerNoIn);
        add(rentBtn);
        add(displayBtn);

        rentBtn.addActionListener(this);
        displayBtn.addActionListener(this);


    }


    public static void main(String[] args) {
        RentalGUI newRentalGUI = new RentalGUI();
        newRentalGUI.setSize(800,250);
        newRentalGUI.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==rentBtn){
            if(customerNoIn.getText().equals("")){
               JOptionPane.showMessageDialog(null,"Please enter a customer number!");
            }
            else{
                tempRental = new Rental(vehicleArray.get(vehicleList.getSelectedIndex()),durationList.getItemAt(durationList.getSelectedIndex()),Integer.parseInt(customerNoIn.getText()));

                rentalVehicleList.add(tempRental);

                vehicleList.removeItem(vehicleList.getItemAt(vehicleList.getSelectedIndex()));

            }
        }
        else if(e.getSource()==displayBtn){
            String message="";
            for(Rental item:rentalVehicleList){
                message=message+ item.toString()+"\n";
            }
            JOptionPane.showMessageDialog(null,message);

        }
    }


    //Read vehicles from the textfile
    public  void readVehicleList(){
        String vehicleType,vehicleModel,year,dailyRate,sizeOrCapacity;

        try{
            InputStream input = new BufferedInputStream(Files.newInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            vehicleType=reader.readLine();
            while(vehicleType != null){
                vehicleModel=reader.readLine();
                year=reader.readLine();
                dailyRate=reader.readLine();
                sizeOrCapacity=reader.readLine();

                if(vehicleType.equalsIgnoreCase("CAR")){
                    vehicleArray.add(new Car(vehicleModel,Integer.parseInt(year),Double.parseDouble(dailyRate),Car.Type.valueOf(sizeOrCapacity)));

                }
                else {
                    vehicleArray.add(new Truck(vehicleModel, Integer.parseInt(year), Double.parseDouble(dailyRate), Double.parseDouble(sizeOrCapacity)));
                }


                vehicleType=reader.readLine();

            }

            reader.close();

        }
        catch(Exception e){
            System.out.println("Message: "+e);
        }

    }
}