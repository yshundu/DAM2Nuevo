/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m3.UF6.Ejemplos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Alumne
 */
public class TextEg1 extends JFrame implements ActionListener{
    JTextField text;
    JTextField text2;
    JButton bQuit;
    public TextEg1(String title) {
        super(title);
        text = new JTextField(15);
        text2 = new JTextField(15);
        bQuit = new JButton("Pitja!");
        bQuit.addActionListener(this);
        setLayout(new FlowLayout());
        add(text);
        add(text2);
        add(bQuit);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main (String[] args) {
        TextEg1 teg = new TextEg1("TextField");
        teg.setSize(500,100);
        teg.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String name = text.getText();
        text2.setText(name);
        repaint();
    }
}
