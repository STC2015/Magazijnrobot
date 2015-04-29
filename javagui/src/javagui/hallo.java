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
 
public class hallo {
    /**
     * Maak de GUI en laat het zien.
     */
    private static void createAndShowGUI() {
        //Hier zorgt Java dat het er goed uit komt te zien.
        JFrame.setDefaultLookAndFeelDecorated(true);
 
        //Maak het venster.
        JFrame frame = new JFrame("HalloWereldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Laat de tekst zien.
        JLabel label = new JLabel("Hallo Wereld!");
        frame.getContentPane().add(label);
 
        //Laat het venster zien.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}