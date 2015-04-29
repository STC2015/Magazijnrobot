/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asrs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorian
 */
public class asrsGUI extends JFrame
        implements ActionListener
{

    // ReadXMLFile read;
    JButton SelectOrder, Run, Pakbon, Robot;
    JTextArea log;
    JFileChooser fc;
    String Lfile;
    int ordernr;
    private JTextField textField;
     private ArrayList<String> artikelen = new ArrayList<String>();

    public asrsGUI()
    {

        setLayout(new FlowLayout());
        setSize(600, 400);
        setTitle("ASRS Controle Systeem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Create the log first, because the action listeners
        //need to refer to it.
        log = new JTextArea(10, 30);
        log.setMargin(new Insets(5, 5, 5, 5));
        log.setEditable(false);
        
        JScrollPane logScrollPane = new JScrollPane(log);

        //Create a file chooser
        fc = new JFileChooser();

        //Uncomment one of the following lines to try a different
        //file selection mode.  The first allows just directories
        //to be selected (and, at least in the Java look and feel,
        //shown).  The second allows both files and directories
        //to be selected.  If you leave these lines commented out,
        //then the default mode (FILES_ONLY) will be used.
        //
        //fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //Create the open button.  We use the image from the JLF
        //Graphics Repository (but we extracted it from the jar).
        SelectOrder = new JButton("Selecteer een order");
        SelectOrder.addActionListener(this);
        Run = new JButton("Run Order");
        Run.addActionListener(this);
        Pakbon = new JButton("Genereer pakbon");
        Pakbon.addActionListener(this);
        Robot = new JButton("Haal bestelling op");
        Robot.addActionListener(this);

        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(SelectOrder);
        buttonPanel.add(Run);
        buttonPanel.add(Pakbon);
        buttonPanel.add(Robot);

        //Add the buttons and the log to this panel.
        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);

    }
    String newline = System.getProperty("line.separator");//This will retrieve line separator dependent on OS

    public void Xmlread(String locatie)
    {
        ReadXMLFile xml = new ReadXMLFile(locatie);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        if (e.getSource() == Pakbon)
        {
            
        }
        //Handle open button action.
        if (e.getSource() == Run)
        {
            File file = fc.getSelectedFile();
            //This is where a real application would open the file.

            String locatie = (fc.getSelectedFile().getAbsolutePath());

            ReadXMLFile read = new ReadXMLFile(locatie);
            log.append(read.getVoornaam() + newline);

            DbConnect connectie = new DbConnect();
            String voornaam = read.getVoornaam();
            String achternaam = read.getAchternaam();
            String adres = read.getAdres();
            String postcode = read.getPostcode();
            String woonplaats = read.getPlaats();
            artikelen = read.getArtikelen();

            this.ordernr = read.getOrderNummer();
            String datum = read.getDatum();

            connectie.setData(voornaam, achternaam, adres, postcode, woonplaats, ordernr, datum);
            
            PrintWriter OutputStream;
            try
            {

                Integer.toString(ordernr);

                OutputStream = new PrintWriter("Pakbon; " + Integer.toString(ordernr) + ".txt");
                OutputStream.println("####################### PAKLIJST ##################");
                OutputStream.println(newline);
                OutputStream.println("Aan: "+voornaam+ " "+achternaam+", "+ adres +", "+ postcode+" "+woonplaats);
                OutputStream.println(newline);
                OutputStream.println(newline);
                OutputStream.println("Inhoud Doos:");
                OutputStream.println(newline);
                OutputStream.println(newline);
                OutputStream.println(artikelen);
                OutputStream.close();
                System.out.println("Done.");

            } catch (FileNotFoundException ex)
            {
                Logger.getLogger(asrsGUI.class.getName()).log(Level.SEVERE, null, ex);
            }


        }
        if (e.getSource() == Robot)
        {
            log.append("Robot haalt bestelling op");
            log.append("Bestelling opgehaald");
        }
//        if (e.getSource() == Run)
//        {
//            File file = fc.getSelectedFile();
//                //This is where a real application would open the file.
//
//            String locatie = (fc.getSelectedFile().getAbsolutePath());
//
//            ReadXMLFile read = new ReadXMLFile(locatie);
//            log.append(read.getVoornaam() + newline);
//
//            
//            String voornaam = read.getVoornaam();
//            String achternaam = read.getAchternaam();
//            String adres = read.getAdres();
//            String postcode = read.getPostcode();
//            String woonplaats = read.getPlaats();
//            int ordernr = read.getOrderNummer();
//            String datum = read.getDatum();
//            
//            PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
//            writer.println("The first line");
//            writer.println("The second line");
//            writer.close();
//
//            
//
//        }

        if (e.getSource() == SelectOrder)
        {
            int returnVal = fc.showOpenDialog(asrsGUI.this);

            if (returnVal == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                log.append("je hebt: " + file.getName() + ". geselecteerd" + newline);
                Lfile = file.getName();

            } else
            {
                log.append("Je hebt niks geselecteerd." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());

            //Handle save button action.
        }
    }

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     */
    protected static ImageIcon createImageIcon(String path)
    {
        java.net.URL imgURL = asrsGUI.class.getResource(path);
        if (imgURL != null)
        {
            return new ImageIcon(imgURL);
        } else
        {
            System.err.println("Couldn't find file: " + path);
            return null;

        }
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event dispatch thread.
     */
    public static void createAndShowGUI()
    {
        //Create and set up the window.
        JFrame frame = new JFrame("ASRS Controle Systeem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new asrsGUI());

        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }
}
