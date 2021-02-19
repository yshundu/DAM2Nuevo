/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m3.UF6.Activitat1;

/**
 *
 * @author Alumne
 */
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class FanrenheitToCelsius extends JFrame implements ActionListener {
    JLabel label;
    JLabel label2;
    JLabel label3;
    JTextField fahr;
    JTextField cels;
    JButton bChange;
    JButton bChange2;
    JButton bChange3;
    
    //constructor
    public FanrenheitToCelsius(String title){
        super(title);
        label = new JLabel("Convent Fahrenheit to Celsius");
        label2 = new JLabel("Fahrenheit");
        label3 = new JLabel("Celsius");
        fahr = new JTextField(15);
        cels = new JTextField(15);
        
        setLayout(new FlowLayout());
        
        add(label);
        add(label2);
        add(label3);
        add(fahr);
        add(cels);
        
        
        bChange = new JButton("Fahr -> Cels");
        bChange.addActionListener(this);
        add(bChange);
        bChange2 = new JButton("Cels -> Fahr");
        bChange2.addActionListener(this);
        add(bChange2);
        bChange3 = new JButton("Esborrar");
        bChange3.addActionListener(this);
        add(bChange3);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Fahr -> Cels")) {
            int far = Integer.parseInt(fahr.getText());
            int cel = (far - 32) * 5 / 9;
            cels.setText(String.valueOf(cel));
        }
        if(e.getActionCommand().equals("Cels -> Fahr")) {
            int cel = Integer.parseInt(cels.getText());
            int far = (cel * 9 / 5) + 32;
            fahr.setText(String.valueOf(far));
        }
        if (e.getActionCommand().equals("Esborrar")) {
            fahr.setText("");
            cels.setText("");
        }
    }
    
    public static void main (String[] args) {
        FanrenheitToCelsius teg = new FanrenheitToCelsius("F to C");
        teg.setSize(400, 300);
        teg.setVisible(true);
    }
 
}