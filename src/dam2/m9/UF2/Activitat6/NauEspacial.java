/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dam2.m9.UF2.Activitat6;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;
import javax.swing.*;

public class NauEspacial extends javax.swing.JFrame {    
    
    public NauEspacial() {
        initComponents();
        }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGap(0, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGap(0, 300, Short.MAX_VALUE));
        pack();
        }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                    }
                }
            }
        catch (Exception ex) {
            java.util.logging.Logger.getLogger(NauEspacial.class.getName()).log(
                java.util.logging.Level.SEVERE, null, ex);
            }       
        NauEspacial f = new NauEspacial();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Naus Espacials");
        f.setContentPane(new PanelNau());
        f.setSize(480, 560);
        f.setVisible(true);
        }
    }


class PanelNau extends JPanel implements Runnable, KeyListener{
    private int numNaus=3;   
    Nau[] nau;
    Bala bala;
    Nau nauJugador;
    int ddX=0;
    public PanelNau(){
        nau = new Nau[numNaus];
        for (int i=0;i<nau.length;i++) {
            Random rand = new Random();
            int velocitat=(rand.nextInt(3)+5)*10;
            int posX=rand.nextInt(100)+30;
            int posY=rand.nextInt(100)+30;
            int dX=rand.nextInt(3)+1;
            int dY=rand.nextInt(3)+1;
            nau[i]= new Nau(i,posX,posY,dX,dY,velocitat);
            
            }
        nauJugador = new Nau(4,200,450,0,0,50);
        Thread n = new Thread(this);
        n.start();
        
        addKeyListener(this);
        setFocusable(true);
        
        }
    
    
    public void run() {
        System.out.println("Inici fil repintar");
        bala = new Bala(3, nauJugador.getX(),nauJugador.getY(), 0, 0, 50);
        while(true) {
            try { Thread.sleep(50);} catch(Exception e) {} // espero 0,1 segons
            System.out.println("Repintant");
            repaint();            
            }                   
        }


    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed code =" + e.getKeyCode() + ", char="+ e.getKeyChar());
        if(e.getKeyCode()==65) {
            if(!(nauJugador.getX()<= 0 - nauJugador.getTx())) {
                ddX=-5;
                nauJugador.setDsx(ddX);
            }
        } else if (e.getKeyCode()==68) {
            if(!(nauJugador.getX()>= 440 - nauJugador.getTx())) {
                ddX=5;
                nauJugador.setDsx(ddX);
            }
        } else if (e.getKeyCode()==32) {
            bala.setX(nauJugador.getX());
            bala.setY(nauJugador.getY());
            bala.setDsy(-10);
        }
        else {
            nauJugador.setDsx(0);
        }
    }
    public synchronized void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i=0; i<nau.length;++i){
            nau[i].pinta(g);
        nauJugador.pinta(g);
        }
        if (bala.getDsy()==0){
            
        } else {
          bala.pinta(g);
        }
     }

    @Override
    public void keyReleased(KeyEvent e) {
        nauJugador.setDsx(0);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    }


class Nau extends Thread {
    private int numero;
    private int x,y;
    private int dsx,dsy,v;
    private int tx = 10;
    private int ty = 10;

    public int getY() {
        return y;
    }
    
    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getTx() {
        return tx;
    }

    public void setTx(int tx) {
        this.tx = tx;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    public int getDsx() {
        return dsx;
    }

    public void setDsx(int dsx) {
        this.dsx = dsx;
    }

    private String img = "/images/nau.jpg";
    
    private Image image;

    public Nau(int numero, int x, int y, int dsx, int dsy, int v ) {
        this.numero = numero;
        this.x=x;
        this.y=y;
        this.dsx=dsx;
        this.dsy=dsy;
        this.v=v;
        image = new ImageIcon(Nau.class.getResource("nau.png")).getImage();
        Thread t = new Thread(this);
        t.start();
        }
    
    public int velocitat (){
        return v;
        }
    
    public synchronized void moure (){
        x=x + dsx;
        y=y + dsy;
        // si arriva als marges ...
        if ( x>= 440 - tx || x<= tx)
            dsx = - dsx;
        if ( y >= 400 - ty || y<=ty )
            dsy = - dsy;
        }
    public synchronized void pinta (Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(this.image, x, y, null);
        }
    

    public void run() {
        while (true) {
            System.out.println("Movent nau numero " + this.numero);
            try { Thread.sleep(this.v); } catch (Exception e) {}
            moure();
            }
        }
    
    }

class Bala extends Thread {
    private int numero;
    private int x,y;
    private int dsx,dsy,v;
    private int tx = 10;
    private int ty = 10;
    
    public int getV() {
        return v;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getTx() {
        return tx;
    }

    public void setTx(int tx) {
        this.tx = tx;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    public int getDsx() {
        return dsx;
    }

    public void setDsx(int dsx) {
        this.dsx = dsx;
    }
        public int getDsy() {
        return dsy;
    }

    public void setDsy(int dsy) {
        this.dsy = dsy;
    }
    
    
    private String img = "/images/balas.jpg";
    
    private Image imageBalas;

    public Bala(int numero, int x, int y, int dsx, int dsy, int v ) {
        this.numero = numero;
        this.x=x;
        this.y=y;
        this.dsx=dsx;
        this.dsy=dsy;
        this.v=v;
        imageBalas = new ImageIcon(Nau.class.getResource("balas.png")).getImage();
        Thread t = new Thread(this);
        t.start();
        }
    
    public int velocitat (){
        return v;
        }
    
    public synchronized void moure (){
        y = y + dsy;
        if (y<=ty) {
            
        }
        }
    public synchronized void pinta (Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(this.imageBalas, x, y, null);
        }
    

    public void run() {
        while (true) {
            System.out.println("Movent bala numero " + this.numero);
            try { Thread.sleep(this.v); } 
            catch (Exception e) {}
            moure();
            }
        }
    
    }
