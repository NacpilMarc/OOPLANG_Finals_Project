//-----------------------IMPORTS------------------------------------------------
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
//-----------------------IMPORTS------------------------------------------------

public class MainMenu extends Layout
{
    //Frames
    static JFrame frame = new JFrame("MMK Catering");
    
    static AddBooking addBook = new AddBooking();
    static DeleteBooking cancel = new DeleteBooking(15);
    static ShowMenu showPackages = new ShowMenu();
    static ShowBookings show = new ShowBookings(15);
    
    //Buttons
    static JButton bookingBtn = new JButton();
    static JButton cancelBookingBtn = new JButton();
    static JButton showBookingBtn = new JButton();
    static JButton showMenuBtn = new JButton();
    static JButton exitBtn = new JButton();

    //labels
    static JLabel mainMenuLb = new JLabel();
    
    //Grids
    static GridBagConstraints gridCons = new GridBagConstraints();
    
    public MainMenu(){
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(580, 250);
        frame.setSize(280, 300);
        frame.setResizable(false);
        
        //declaration for the gridBag layout
        frame.getContentPane().setLayout(new GridBagLayout());
        
        //-----------------------LABELS-----------------------
        setInsets(10,0,10,0, gridCons);
        addALabel(mainMenuLb, "MMK Catering Services", 0, 0, frame, gridCons);
        mainMenuLb.setFont(new Font("Courier", Font.BOLD, 20));
        setGridWidthHeight(1, 1, gridCons);
        
        //-----------------------BUTTONS-----------------------
        setInsets(10,0,0,0, gridCons);
        addAButton(bookingBtn, "Start Booking", 0, 1, frame, gridCons);
        setGridWidthHeight(1, 1, gridCons);
        bookingBtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        startBooking();}
        });
        setInsets(10,0,0,0, gridCons);
        addAButton(cancelBookingBtn, "Cancel Booking", 0, 2, frame, gridCons);
        setGridWidthHeight(1, 1, gridCons);
        cancelBookingBtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        cancelBooking();}
        });
        
        setInsets(10,0,0,0, gridCons);
        addAButton(showBookingBtn, "Show Bookings", 0, 3, frame, gridCons);
        setGridWidthHeight(1, 1, gridCons);
        showBookingBtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        showBooking();}
        });
        
        setInsets(10,0,0,0, gridCons);
        addAButton(showMenuBtn, "Show Packages", 0, 4, frame, gridCons);
        setGridWidthHeight(1, 1, gridCons);
        showMenuBtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        showMenu();}
        });
        
        setInsets(10,0,0,0, gridCons);
        addAButton(exitBtn, "Exit", 0, 5, frame, gridCons);
        setGridWidthHeight(1, 1, gridCons);
        exitBtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        exitProgram();}
        });
        
    }
    
    //---------------------------BUTTONS----------------------------------------
    private static void startBooking(){
        addBook.toggleVisibilityTrue();
        
        show.toggleVisibilityFalse();
        cancel.toggleVisibilityFalse();
    }
    
    private static void cancelBooking(){
        cancel.toggleVisibilityTrue();
        boolean frameState= show.isVisible;
        if(!frameState){
            cancel.showFileList();
        }
        addBook.toggleVisibilityFalse();
        show.toggleVisibilityFalse();
    }
    
    private static void showMenu(){
        showPackages.toggleVisibility();

        show.toggleVisibilityFalse();
        cancel.toggleVisibilityFalse();
    }

    
    private static void showBooking(){
        show.toggleVisibilityTrue();
        show.showFileList();
        addBook.toggleVisibilityFalse();
        cancel.toggleVisibilityFalse();
    }
    
    private static void exitProgram(){
        int choice = JOptionPane.showConfirmDialog(null, "Do you really wish to exit the program?", "Exit Program", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
        
    
    //------------------------Main--------------------------------------
    public static void main (String[] args) {
        MainMenu mainMenu = new MainMenu();
    } 
    
}