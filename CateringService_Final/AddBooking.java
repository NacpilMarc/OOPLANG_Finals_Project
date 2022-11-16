/**
 * Write a description of class Add_Booking here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

//-----------------------IMPORTS------------------------------------------------
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.Random;
//-----------------------IMPORTS------------------------------------------------

public class AddBooking extends Layout
{   
    //Instance
    static String packageChoice = "";
    static String id = "";
    
    
    //Package List
    static String [] packageChoices  = {"Starter", "Standard", "Premium"};

    //Frames
    static JFrame frame = new JFrame("MMK Booking");
    
    //Combobox
    static JComboBox packageList = new JComboBox(packageChoices);
    
    //Buttons
    static JButton backBtn = new JButton();    
    static JButton confirmBtn = new JButton();
    static JButton clearBtn = new JButton();
    
    //TextFields
    static JTextField packageField = new JTextField();
    static JTextField nameField = new JTextField();
    static JTextField contactField = new JTextField();
    static JTextField dateField = new JTextField();
    static JTextField timeField = new JTextField();
    static JTextField addressField = new JTextField();
    static JTextField noPeopleField = new JTextField();
    
    
    //labels
    static JLabel headingTitle = new JLabel();
    static JLabel food_package = new JLabel();
    static JLabel client_name = new JLabel();
    static JLabel contact_no = new JLabel();
    static JLabel date = new JLabel();
    static JLabel time = new JLabel();
    static JLabel address = new JLabel();
    static JLabel number_of_people = new JLabel();
    
    //Grids
    static GridBagConstraints gridCons = new GridBagConstraints();
    static GridBagConstraints gridConsWidth = new GridBagConstraints(); //grid constraints for multi-width grids
    
    public AddBooking(){
        frame.setVisible(false);
        frame.setLocation(470, 200);
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //declaration for the gridBag layout
        frame.getContentPane().setLayout(new GridBagLayout());
        
        //HEADING TITLE
        setInsets(10,0,20,0, gridCons, gridConsWidth);
        addALabel(headingTitle, "MMK Booking", 0, 0, 2, 1, frame, gridConsWidth);
        headingTitle.setFont(new Font("Courier", Font.BOLD, 30));
        
        //-----------------------COMBOBOX-------------------------
        
        setInsets(10,0,0,0, gridCons, gridConsWidth);
        addAComboBox(packageList, 1, 1, frame, gridCons);
        
        packageList.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            JComboBox cb = (JComboBox)e.getSource();
            String selectedPackage = (String)cb.getSelectedItem();
            setPackageChoice(selectedPackage);
        }
        });
        
        //-----------------------TEXTFIELDS-------------------------
        
        setInsets(10,10,0,0, gridCons, gridConsWidth);
        addATextField(nameField,  1, 2, frame, gridCons);
        
        setInsets(10,10,0,0, gridCons, gridConsWidth);
        addATextField(contactField,  1, 3, frame, gridCons);
        
        setInsets(10,10,0,0, gridCons, gridConsWidth);
        addATextField(dateField, 1, 4, frame, gridCons);
        dateField.setText("mm-dd-yyyy");
        
        setInsets(10,10,0,0, gridCons, gridConsWidth);
        addATextField(timeField, 1, 5, frame, gridCons);
        timeField.setText("00:00");
        
        setInsets(10,10,0,0, gridCons, gridConsWidth);
        addATextField(addressField, 1, 6, frame, gridCons);
        
        setInsets(10,10,0,0, gridCons, gridConsWidth);
        addATextField(noPeopleField,  1, 7, frame, gridCons);
        
        //-----------------------LABELS------------------------
        
        setInsets(10,0,0,10, gridCons, gridConsWidth);
        addALabel(food_package, "Food Package: ", 0, 1, frame, gridCons);
        
        setInsets(10,0,0,10, gridCons, gridConsWidth);
        addALabel(client_name, "Name of Client: ", 0, 2, frame, gridCons);
        
        setInsets(10,0,0,10, gridCons, gridConsWidth);
        addALabel(contact_no, "Contact No.: ", 0, 3, frame, gridCons);
        
        setInsets(10,0,0,10, gridCons, gridConsWidth);
        addALabel(date, "Date: ", 0, 4, frame, gridCons);
        
        setInsets(10,0,0,10, gridCons, gridConsWidth);
        addALabel(time, "Time: ", 0, 5, frame, gridCons);
        
        setInsets(10,0,0,10, gridCons, gridConsWidth);
        addALabel(address, "Address: ", 0, 6, frame, gridCons);
        
        setInsets(10,0,0,10, gridCons, gridConsWidth);
        addALabel(number_of_people, "No. of People: ", 0, 7, frame, gridCons);
        
        //-----------------------BUTTONS-----------------------
        
        setInsets(20,0,0,0, gridCons, gridConsWidth);
        addAButton(confirmBtn, "Confirm", 1, 8, frame, gridCons);
        confirmBtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            confirmBooking(packageChoice);
        }
        });
        
        
        setInsets(20,0,0,0, gridCons, gridConsWidth);
        addAButton(clearBtn, "Clear", 0, 8, frame, gridCons);
        clearBtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            clearFields();}
        });
        
        setInsets(10,0,0,0, gridCons, gridConsWidth);
        addAButton(backBtn, "Back to Main Menu", 0, 9, 2, 1, frame, gridConsWidth);
        backBtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            backToMain();}
        });
    }
    
    //---------------------------BUTTONS----------------------------------------
    private static void confirmBooking(String pack){
        String name;
        String contact;
        String dateBooking;
        String timeBooking;
        String addressBooking;
        String noOfPeople;
        
        
        name = nameField.getText();
        contact = checkContact();
        dateBooking = dateField.getText();
        timeBooking = timeField.getText();
        addressBooking = addressField.getText();
        noOfPeople = noPeopleField.getText();
        
        //remove whitesaces
        name = name.replaceAll("\\s","");
        contact = contact.replaceAll("\\s","");
        dateBooking = dateBooking.replaceAll("\\s","");
        timeBooking = timeBooking.replaceAll("\\s","");
        //addressBooking.replaceAll("\\s","");
        noOfPeople = noOfPeople.replaceAll("\\s","");
        
        if (pack != "" & contact != ""& dateBooking != "" & timeBooking != "" & noOfPeople != "" & addressBooking != "")
        {
            try
            {   
                setID(); //generate random ID
                int no_people = Integer.parseInt(noOfPeople);
                float price;
                
                price = computePrice(pack, no_people);
                
                String priceString = Float.toString(price);
                FileWriter write = new FileWriter(id + name.toUpperCase() + ".txt");
                
                write.write("Package: " + pack);
                write.write("\n" + "Name: " + name);
                write.write("\n" + "Contact No.: " +contact);
                write.write("\n" + "Date: " + dateBooking);
                write.write("\n" + "Time: " + timeBooking);
                write.write("\n" + "Address: " + addressBooking);
                write.write("\n" + "No. of People: " + noOfPeople);
                write.write("\n" + "Price: " + priceString);
                write.close();
                
                JOptionPane.showMessageDialog(null, "The record was saved", "Processed",JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Total bill: " + "₱" + priceString, "Processed",JOptionPane.INFORMATION_MESSAGE);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "An error occurred while saving the record", "Error",JOptionPane.WARNING_MESSAGE);
            }
            
            clearFields();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please fill out all fields.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
     private static String checkContact(){
        String contactCheck = contactField.getText();
        
        int str_len = contactCheck.length();
        
        if (str_len != 11){
            contactCheck = "";
            JOptionPane.showMessageDialog(null, "Contact Number was exceeded/insufficient.", "Invalid Contant Number.",JOptionPane.WARNING_MESSAGE);
        }
        
        return contactCheck;
    }
    
    private static float computePrice(String pack, int noOfPeople) {
        
        int price = 0;
        int STARTER_PRICE = 200;
        int STANDARD_PRICE = 350;
        int PREMIUM_PRICE = 500;
                
        if (noOfPeople > 0) {
                    try {
                        if (pack == "Starter"){
                            price = STARTER_PRICE * noOfPeople;
                        }
                        else if(pack == "Standard"){
                            price = STANDARD_PRICE * noOfPeople;
                        }
                        else if(pack == "Premium"){
                            price = PREMIUM_PRICE * noOfPeople;
                        }
                    }
                    catch (Exception err) {
                        JOptionPane.showMessageDialog(null, "Please input a valid value.", "Error",JOptionPane.WARNING_MESSAGE);
                    }
                    
                }
        else {
            JOptionPane.showMessageDialog(null, "Please input a value greater than 0.", "Error",JOptionPane.WARNING_MESSAGE);
        }
        
        return price;
    }
    
    private static void backToMain(){
        frame.setVisible(false);
    }
    
    private static void clearFields(){
        final String CLEAR = "";
        
        packageField.setText(CLEAR);
        nameField.setText(CLEAR);
        contactField.setText(CLEAR);
        dateField.setText("mm-dd-yyyy");
        timeField.setText("00:00");
        addressField.setText(CLEAR);
        noPeopleField.setText(CLEAR);
    }
    
    //Random Number Generator
    public static void setID(){
        Random rand  = new Random();
        int rand_int1 = rand.nextInt(9);
        int rand_int2 = rand.nextInt(9);
        int rand_int3 = rand.nextInt(9);
        int rand_int4 = rand.nextInt(9);
        String num1 = Integer.toString(rand_int1);
        String num2 = Integer.toString(rand_int2);
        String num3 = Integer.toString(rand_int3);
        String num4 = Integer.toString(rand_int4);
        String randomCombination = num1 + num2 + num3 + num4;
        
        id = randomCombination;
    }
    
    //------------------------COMBOBOX--------------------------------------
    public static void setPackageChoice(String pack){
        packageChoice = pack;
    }
    
    //------------------------ADD_ELEMENTS--------------------------------------
    //Adds a text field in the desired location according to gridBag
        //Easier to reuse than copy pasting :)
    
    
    public static void toggleVisibilityTrue()
    {
        frame.setVisible(true);
    }
    
    public static void toggleVisibilityFalse()
    {
        frame.setVisible(false);
    }
    
}