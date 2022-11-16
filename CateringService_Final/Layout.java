
/**
 * Write a description of class Layout here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.Random;

public class Layout
{
    
    
    //------------------------ADD_ELEMENTS--------------------------------------
    //Adds a text field in the desired location according to gridBag
    //Easier to reuse than copy pasting :)
    
    public static void setGridWidthHeight(int w, int h, GridBagConstraints gridCons) 
    {
       gridCons.gridwidth = w;
       gridCons.gridheight = h;
    }
    
    public static void addATextField(JTextField text, int x, int y, JFrame frame, GridBagConstraints gridCons)
    {
        text.setColumns(15);
        gridCons.gridx = x;
        gridCons.gridy = y;
        frame.getContentPane().add(text, gridCons);
    }
    
    public static void addAButton(JButton button, String text, int x, int y, int w, int h, JFrame frame, GridBagConstraints gridConsWidth)
    {
        button.setText(text);
        gridConsWidth.gridx = x;
        gridConsWidth.gridy = y;
        gridConsWidth.gridwidth = w;
        gridConsWidth.gridheight = h;
        frame.getContentPane().add(button, gridConsWidth);
    }
    
    public static void addAButton(JButton button,String text, int x, int y, JFrame frame, GridBagConstraints gridCons)
    {
        button.setText(text);
        gridCons.gridx = x;
        gridCons.gridy = y;
        frame.getContentPane().add(button, gridCons);
    }
    
    public static void addALabel(JLabel label, String text, int x, int y, int w, int h, JFrame frame, GridBagConstraints gridConsWidth)
    {
        label.setText(text);
        gridConsWidth.gridx = x;
        gridConsWidth.gridy = y;
        gridConsWidth.gridwidth = w;
        gridConsWidth.gridheight = h;
        frame.getContentPane().add(label, gridConsWidth);
    }
    
    public static void addALabel(JLabel label, String text, int x, int y, JFrame frame, GridBagConstraints gridCons)
    {
        label.setText(text);
        gridCons.gridx = x;
        gridCons.gridy = y;
        frame.getContentPane().add(label, gridCons);
    }
    
    public static void addAComboBox(JComboBox comboBox, int x, int y, JFrame frame, GridBagConstraints gridCons)
    {
        gridCons.gridx = x;
        gridCons.gridy = y;
        frame.getContentPane().add(comboBox, gridCons);
    }
    
    public static void setGridGap(int x, int y, GridBagConstraints gridCons)
    {
        gridCons.weightx = x;
        gridCons.weighty = y;
    }
    
    public static void setInsets(int top, int left, int bottom, int right, GridBagConstraints gridCons, GridBagConstraints gridConsWidth)
    {
        gridCons.insets = new Insets(top, left, bottom, right);
        gridConsWidth.insets = new Insets(top, left, bottom, right);
    }
    
    public static void setInsets(int top, int left, int bottom, int right, GridBagConstraints gridCons)
    {
        gridCons.insets = new Insets(top, left, bottom, right);
    }
    
    public static void addATextField(JTextField text,final int _COLUMNS, int x, int y, JFrame frame, GridBagConstraints gridCons)
    {
        text.setColumns(_COLUMNS);
        gridCons.gridx = x;
        gridCons.gridy = y;
        frame.getContentPane().add(text, gridCons);
    }
    
    
    public static void addATextArea(JTextArea text, JScrollPane scroll,final int _COLUMNS, int x, int y, JFrame frame, GridBagConstraints gridCons)
    {
        text.setColumns(_COLUMNS);
        //text.setEditable(false); //uneditable text area
        gridCons.gridx = x;
        gridCons.gridy = y;
        frame.getContentPane().add(scroll, gridCons);
    }
}
