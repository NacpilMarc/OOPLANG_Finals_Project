//-----------------------IMPORTS------------------------------------------------
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//-----------------------IMPORTS------------------------------------------------

public class ShowMenu extends Layout
{
    //Frames
    static JFrame frame = new JFrame("Packages");
    
    //Buttons
    static JButton backBtn = new JButton();
    
    //Prices Labels
    static JLabel starterPrice= new JLabel();
    static JLabel standardPrice= new JLabel();
    static JLabel premiumPrice= new JLabel();
    
    //Starter Labels
    static JLabel starterPackage= new JLabel();
    static JLabel starterAppetizer = new JLabel();
    static JLabel starterMainCourse = new JLabel();
    static JLabel starterDessert = new JLabel();
    static JLabel starterDrink = new JLabel();

    
    //Standard Labels
    static JLabel standardPackage = new JLabel();
    static JLabel standardAppetizer = new JLabel();
    static JLabel standardMainCourse = new JLabel();
    static JLabel standardDessert = new JLabel();
    static JLabel standardDrink = new JLabel();
    
    //Premium Labels
    static JLabel premiumPackage = new JLabel();
    static JLabel premiumAppetizer = new JLabel();
    static JLabel premiumMainCourse = new JLabel();
    static JLabel premiumDessert = new JLabel();
    static JLabel premiumDrink = new JLabel();
    
    static Color green = new Color(42, 157, 143);
    static Color blue = new Color(61, 64, 91);
    static Color yellow = new Color(238, 155, 0);
    static Color orange = new Color(224, 122, 95);
    
    //Menu Category
    static JLabel  menuMainLabel = new JLabel();
    static JLabel  menuAppetizer = new JLabel();
    static JLabel  menuMainCourse = new JLabel();
    static JLabel  menuDesserts = new JLabel();
    static JLabel  menuDrinks = new JLabel();
    
    //Appetizers
    static JLabel  appetizersFood1 = new JLabel();
    static JLabel  appetizersFood2 = new JLabel();
    static JLabel  appetizersFood3 = new JLabel();
    static JLabel  appetizersFood4 = new JLabel();

    //Main Courses
    static JLabel  maincourseFood1 = new JLabel();
    static JLabel  maincourseFood2 = new JLabel();
    static JLabel  maincourseFood3 = new JLabel();
    static JLabel  maincourseFood4 = new JLabel();
    static JLabel  maincourseFood5 = new JLabel();
    static JLabel  maincourseFood6 = new JLabel();
    static JLabel  maincourseFood7 = new JLabel();
    static JLabel  maincourseFood8 = new JLabel();
    
    //Drinks
    static JLabel  menudrinks1 = new JLabel();
    static JLabel  menudrinks2 = new JLabel();
    static JLabel  menudrinks3 = new JLabel();
    static JLabel  menudrinks4 = new JLabel();
    static JLabel  menudrinks5 = new JLabel();
    static JLabel  menudrinks6 = new JLabel();
    
    //Desserts
    static JLabel  menudessert1 = new JLabel();
    static JLabel  menudessert2 = new JLabel();
    static JLabel  menudessert3 = new JLabel();

    
    //Grids
    static GridBagConstraints gridCons = new GridBagConstraints();
    
    public ShowMenu(){
        frame.setVisible(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocation(420, 40);
        frame.setSize(600, 775);
        frame.setResizable(false);
        
        //declaration for the gridBag layout
        frame.getContentPane().setLayout(new GridBagLayout());
        
        //-----------------------BUTTON------------------------
        setInsets(25,0,10,0, gridCons);
        addAButton(backBtn, "Back", 1, 25, frame, gridCons);
        backBtn.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        backToMain();}
        });
        
        //-----------------------STARTER------------------------
        setInsets(10,0,10,0, gridCons);
        starterPrice.setFont(new Font("Courier", Font.BOLD, 20));
        starterPrice.setForeground(green);
        addALabel(starterPrice, "200 Php/head", 0, 1, frame, gridCons);
        
        setInsets(10,0,20,0, gridCons);
        starterPackage.setForeground(orange);
        addALabel(starterPackage, "--- Starter Package ---", 0, 0, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(starterAppetizer, "1 Type of Appetizers", 0, 2, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(starterMainCourse, "3 Types of Main Courses", 0, 3, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(starterDessert, "2 Types of Desserts ", 0, 4, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(starterDrink, "1 Type of Unli Drinks", 0, 5, frame, gridCons);
        
        //-----------------------STANDARD------------------------
        setInsets(10,0,10,0, gridCons);
        standardPrice.setFont(new Font("Courier", Font.BOLD, 20));
        standardPrice.setForeground(green);
        addALabel(standardPrice, "350 Php/head", 1, 1, frame, gridCons);
        
        setInsets(10,0,20,0, gridCons);
        standardPackage.setForeground(blue);
        addALabel(standardPackage, "--- Standard Package ---", 1, 0, frame, gridCons);
        
        setInsets(10,30,0,30, gridCons);
        addALabel(standardAppetizer, "2 Types of Appetizers", 1, 2, frame, gridCons);
        
        setInsets(10,30,0,30, gridCons);
        addALabel(standardMainCourse, "5 Types of Main Courses", 1, 3, frame, gridCons);
        
        setInsets(10,30,0,30, gridCons);
        addALabel(standardDessert, "3 Types of Desserts ", 1, 4, frame, gridCons);
        
        setInsets(10,30,0,30, gridCons);
        addALabel(standardDrink, "2 Types of Unli Drinks", 1, 5, frame, gridCons);
        
        //-----------------------PREMIUM------------------------
        setInsets(10,0,10,0, gridCons);
        premiumPrice.setFont(new Font("Courier", Font.BOLD, 20));
        premiumPrice.setForeground(green);
        addALabel(premiumPrice, "500 Php/head", 2, 1, frame, gridCons);
        
        setInsets(10,0,20,0, gridCons);
        premiumPackage.setForeground(yellow);
        addALabel(premiumPackage, "--- Premium Package ---", 2, 0, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(premiumAppetizer, "4 Types of Appetizers", 2, 2, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(premiumMainCourse, "8 Types of Main Courses", 2, 3, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(premiumDessert, "4 Types of Desserts ", 2, 4, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(premiumDrink, "3 Types of Unli Drinks", 2, 5, frame, gridCons);

        // --------------------Menu Categories----------------------
        setInsets(20,0,20,0, gridCons);
        //starterPackage.setForeground(orange);
        addALabel(menuMainLabel, "", 1, 8, frame, gridCons);
        menuMainLabel.setFont(new Font("Courier", Font.BOLD, 20));
        
        setInsets(10,0,20,0, gridCons);
        menuAppetizer.setForeground(orange);
        addALabel(menuAppetizer, "--- Appetizers ---", 0, 9, frame, gridCons);
        
        setInsets(10,0,20,0, gridCons);
        menuMainCourse.setForeground(blue);
        addALabel(menuMainCourse, "--- Main Courses ---", 1, 9, frame, gridCons);
        
        setInsets(10,0,20,0, gridCons);
        menuDrinks.setForeground(yellow);
        addALabel(menuDrinks, "--- Drinks ---", 2, 9, frame, gridCons);
        
        setInsets(30,0,20,0, gridCons);
        menuDesserts.setForeground(orange);
        addALabel(menuDesserts, "--- Desserts ---", 1, 20, frame, gridCons);
        
        // -------------------Appetizers------------------------
        
        setInsets(10,0,0,0, gridCons);
        addALabel(appetizersFood1, "Mozzarella sticks", 0, 10, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(appetizersFood2, "Garlic Bread", 0, 11, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(appetizersFood3, "Egg Soup", 0, 12, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(appetizersFood4, "Jallapeno Poppers", 0, 13, frame, gridCons);
        
        // -------------------Main Courses------------------------
        
        setInsets(10,0,0,0, gridCons);
        addALabel(maincourseFood1, "Pancit Guisado", 1, 10, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(maincourseFood2, "Carbonarra", 1, 11, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(maincourseFood3, "Roast Beef", 1, 12, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(maincourseFood4, "Crispy Pata", 1, 13, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(maincourseFood5, "Cochinillo", 1, 14, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(maincourseFood6, "Roast Pork Belly", 1, 15, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(maincourseFood7, "Original Sisig", 1, 16, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(maincourseFood8, "Sinigang na Tuna", 1, 17, frame, gridCons);
        
        // ---------------------Drinks--------------------
        
        setInsets(10,0,0,0, gridCons);
        addALabel(menudrinks1, "Coke", 2, 10, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(menudrinks2, "Spirte", 2, 11, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(menudrinks3, "Root Beer", 2, 12, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(menudrinks4, "Dark Gulaman", 2, 13, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(menudrinks5, "Orange Juice", 2, 14, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(menudrinks6, "Iced Tea", 2, 15, frame, gridCons);
        
        // ---------------------Desserts--------------------
        
        setInsets(10,0,0,0, gridCons);
        addALabel(menudessert1, "Ice Cream", 1, 21, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(menudessert2, "Halo-Halo", 1, 22, frame, gridCons);
        
        setInsets(10,0,0,0, gridCons);
        addALabel(menudessert3, "Coffee Jelly", 1, 23, frame, gridCons);
        
    }
    
    //------------------------BUTTONS--------------------------------------
    private static void backToMain(){
        frame.setVisible(false);
    }

    
    public static void toggleVisibility()
    {
        frame.setVisible(true);
    }
}