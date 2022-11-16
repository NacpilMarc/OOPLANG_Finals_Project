//-----------------------IMPORTS------------------------------------------------
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;
//-----------------------IMPORTS------------------------------------------------

public class DeleteBooking extends Layout
{
    //Instance
    static boolean isVisible = false;
    
    //Frames
    static JFrame frame = new JFrame("Delete Booking");
    
    //Buttons
    static JButton backBtn = new JButton();    
    static JButton confirmBtn = new JButton();
    static JButton clearBtn = new JButton();
    
    //TextAreas
    static JTextArea showBookedList = new JTextArea(10,15);
        //Scroll Pane for Text Area
    static JScrollPane spBookedList = new JScrollPane(showBookedList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    
    //TextFields
    static JTextField fileNameField = new JTextField();
    
    //Labels
    static JLabel bookingsLabel = new JLabel();
    static JLabel showBookingLabel = new JLabel();
    static JLabel bookingDataLabel = new JLabel();
    
    //Grids
    static GridBagConstraints gridCons = new GridBagConstraints();
    static GridBagConstraints gridConsWidth = new GridBagConstraints(); //grid constraints for multi-width grids
    
    public DeleteBooking(final int _COLUMNS){
        frame.setVisible(false);
        frame.setLocation(520, 200);
        frame.setSize(400, 450);
        frame.setResizable(false);
        showBookedList.setEditable(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //declaration for the gridBag layout
        frame.getContentPane().setLayout(new GridBagLayout());
        
        //-----------------------TEXTAREAS-------------------------
        addATextArea(showBookedList, spBookedList, _COLUMNS, 0, 1, frame, gridCons);
        
        showFileList();
        showBookedList.setEditable(false); //Uneditable Text Area
        
        //-----------------------TEXTFIELD-------------------------
        setInsets(0,0,0,0, gridCons, gridConsWidth);
        addATextField(fileNameField, _COLUMNS, 0, 3, frame, gridCons);
        
        //-----------------------LABELS------------------------
        setInsets(10,0,20,0, gridCons, gridConsWidth);
        addALabel(bookingsLabel, "Bookings", 0, 0, frame, gridCons);
        bookingsLabel.setFont(new Font("Courier", Font.BOLD, 20));
        
        setInsets(10,0,0,0, gridCons, gridConsWidth);
        addALabel(showBookingLabel, "Delete Booking: ", 0, 2, frame, gridCons);
        
        //-----------------------BUTTONS-----------------------
        setInsets(10,0,0,0, gridCons, gridConsWidth);
        addAButton(confirmBtn, "Confirm", 0, 5, frame, gridCons);
        confirmBtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        confirmInput();}
        });
        setInsets(10,0,0,0, gridCons, gridConsWidth);
        addAButton(clearBtn, "Clear", 0, 4, frame, gridCons);
        clearBtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        clearInput();}
        });
        
        setInsets(10,0,0,0, gridCons, gridConsWidth);
        addAButton(backBtn, "Back to Main Menu", 0, 6, frame, gridCons);
        backBtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        backToMain();}
        });
        
    }
    
    //---------------------------BUTTONS----------------------------------------
    private static void confirmInput(){
        String fileName;
        
        try{
            fileName = fileNameField.getText();
            File deletes = new File(fileName + ".txt");
            Scanner scan = new Scanner(deletes);
            scan.close();
            deletes.delete();
            JOptionPane.showMessageDialog(null, "The record was deleted", "Processed",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR! \nINVALID_NAME", "Error",JOptionPane.WARNING_MESSAGE);
        }
        fileNameField.setText("");
        showFileList();
        showBookedList.setEditable(false); //make textarea uneditable after updating data
    }
    
    private static void clearInput(){
        fileNameField.setText("");
    }
    
    private static void backToMain(){
        frame.setVisible(false);
    }

    
    
    public static void toggleVisibilityTrue()
    {
        frame.setVisible(true);
        isVisible = true;
    }
    
    public static void toggleVisibilityFalse()
    {
        frame.setVisible(false);
        isVisible = false;
    }
    
    public static void getFiles() throws IOException {
        String fileNameOne = "";
        
        
        File directoryPath = new File(".");
        FilenameFilter textFilefilter = new FilenameFilter(){
            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith(".txt")) {
                   return true;
                } else {
                   return false;
                }
             }
        };
      
        String filesList[] = directoryPath.list(textFilefilter);
        for(String fileName : filesList) {
            fileNameOne = fileNameOne + "\n" + fileName;
            showBookedList.setText(fileNameOne);
            }
        
    }
    
    public static void showFileList() {
        try
        {
            getFiles();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
}