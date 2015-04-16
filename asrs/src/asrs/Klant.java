/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asrs;

/**
 *
 * @author jorian
 */
public class Klant
{
    private int KlantNr;
    private String Voornaam;
    private String Achternaam;
    private String Adres;
    private String Postcode;
    private String Plaats;
    
    
    public Klant (int nr,String vnaam,String anaam,String adres,String postcode,String plaats)
    {
     KlantNr = nr;
     Voornaam = vnaam;
     Achternaam = anaam;
     Adres = adres;
     Postcode = postcode;
     Plaats = plaats;
    }
}
