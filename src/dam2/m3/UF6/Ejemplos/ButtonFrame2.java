/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m3.UF6.Ejemplos;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Alumne
 */
public class ButtonFrame2 extends JFrame implements ActionListener{
    
    JButton bQuit;
    //constructor
    public ButtonFrame2() {
        bQuit = new JButton("Exit!");
        setLayout(new FlowLayout());
        //register the ButtonFrame object as the listener for the JButton.
        bQuit.addActionListener(this);
        add(bQuit);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
        @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
        public static void main(String[] args){
         ButtonFrame2 button = new ButtonFrame2();
         button.setSize(300, 300);
         
         button.setVisible(true);
         
    }
    //listener method required by the interface
}
