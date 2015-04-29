/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asrs;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.io.IOException;


/**
 *
 * @author jorian
 */
public class Main
{

    public static void main(String[] args) throws IOException
    {
        //ReadXMLFile read = new ReadXMLFile();
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
      
       
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                asrsGUI.createAndShowGUI();
            }
        });

    }
}
