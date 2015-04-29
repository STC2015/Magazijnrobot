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
 
public class kliklijst extends JFrame  {
  private JList keuzelijst;
  private DefaultListModel lijst;
  public kliklijst() {
    setSize(500, 300);
    setTitle("aan te klikken lijst");
  } 
  public static void main (String[] args) {
    kliklijst  frame = new kliklijst();
    frame.createGUI();
    frame.setVisible(true);
  }
  private void createGUI() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container window = this.getContentPane();
    window.setLayout(new FlowLayout());
    lijst = new DefaultListModel();
    lijst.addElement("voorgerecht");
    lijst.addElement("hoofdgerecht");
    lijst.addElement("nagerecht");
    keuzelijst = new JList(lijst);
    JScrollPane metSchuif = new JScrollPane(keuzelijst);
    window.add(metSchuif);
    keuzelijst.addMouseListener(new muisvoeler());
  }
  class muisvoeler extends MouseAdapter {
    public void mouseClicked (MouseEvent e)
    {
      Object[] keuze = keuzelijst.getSelectedValues();
      for (int i=0; i<keuze.length; i++) {
        System.out.println(keuze[i].toString());
      }
      lijst.addElement("water");
    }
  }
}
