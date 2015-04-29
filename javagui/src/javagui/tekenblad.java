/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagui;

/**
 *
 * @author jorian
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class tekenblad extends JFrame implements ActionListener {
  private int breedte = 350, hoogte = 50, horizontaal = 0, verticaal = 10;
  private JButton knop1, knop2;
  private JPanel blad;
  private Graphics g;
 
  public tekenblad() {
    setSize(breedte + 100, hoogte + 100);
    setTitle("tekenblad");
  }
  public static void main(String[] args) {
    tekenblad frame = new tekenblad();
    frame.createGUI();
    frame.setVisible(true);
  }
  private void createGUI(){
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container venster = this.getContentPane();
    venster.setLayout(new FlowLayout() );
    JPanel knoppen = new JPanel();
    venster.add(knoppen);
    knop1 = new JButton();
    knop1.setText("1");
    venster.add(knop1);
    knop1.addActionListener(this);
    knop2 = new JButton();
    knop2.setText("2");
    venster.add(knop2);
    knop2.addActionListener(this);
    blad = new JPanel();
    blad.setPreferredSize(new Dimension(breedte,hoogte));
    venster.add(blad);
  }
  public void actionPerformed(ActionEvent e){
    horizontaal += 10;
    if (horizontaal > breedte) {
    horizontaal = 0;
    verticaal += 15;
    }
    String tekst;
    if (e.getSource() == knop1) {tekst = "1";}
    else {tekst = "" + e.getActionCommand();}  // Neemt de tekst op de knop
    g = blad.getGraphics();
    g.drawString(tekst,horizontaal,verticaal);
  }
}
