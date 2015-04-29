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
 
public class javaKnoppen extends JFrame
  implements ActionListener{
  private JTextField tekstveld;
  private JLabel tekst, melding;
  private JButton knop;
 
  public javaKnoppen() {     // constructor
    setSize(500, 250);
    setTitle("Titeltekst");
    //setResizable(false);    // voorkomt herschalen
  }
  public static void main(String[] args) {
    javaKnoppen venster = new javaKnoppen();
    venster.createGUI();
    venster.setVisible(true);
  }
  private void createGUI(){
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container venster = this.getContentPane();
    venster.setLayout(new FlowLayout() );
    JPanel bladhoofd = new JPanel();   // hulpconstructie
    {
      tekst = new JLabel("Geef uw keuze: ");
      tekstveld = new JTextField(20);
      knop = new JButton("Kies");
      melding = new JLabel();
      bladhoofd.add(tekst);
      bladhoofd.add(tekstveld);
      bladhoofd.add(knop);
    }
    venster.add(bladhoofd);
    venster.add(melding);
    knop.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e){
    String tkt = "U koos: " +
      tekstveld.getText();
    melding.setText(tkt);
  }
}