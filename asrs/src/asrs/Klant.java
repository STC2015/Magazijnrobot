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

    /**
     * @return the KlantNr
     */
    public int getKlantNr()
    {
        return KlantNr;
    }

    /**
     * @param KlantNr the KlantNr to set
     */
    public void setKlantNr(int KlantNr)
    {
        this.KlantNr = KlantNr;
    }

    /**
     * @return the Voornaam
     */
    public String getVoornaam()
    {
        return Voornaam;
    }

    /**
     * @param Voornaam the Voornaam to set
     */
    public void setVoornaam(String Voornaam)
    {
        this.Voornaam = Voornaam;
    }

    /**
     * @return the Achternaam
     */
    public String getAchternaam()
    {
        return Achternaam;
    }

    /**
     * @param Achternaam the Achternaam to set
     */
    public void setAchternaam(String Achternaam)
    {
        this.Achternaam = Achternaam;
    }

    /**
     * @return the Adres
     */
    public String getAdres()
    {
        return Adres;
    }

    /**
     * @param Adres the Adres to set
     */
    public void setAdres(String Adres)
    {
        this.Adres = Adres;
    }

    /**
     * @return the Postcode
     */
    public String getPostcode()
    {
        return Postcode;
    }

    /**
     * @param Postcode the Postcode to set
     */
    public void setPostcode(String Postcode)
    {
        this.Postcode = Postcode;
    }

    /**
     * @return the Plaats
     */
    public String getPlaats()
    {
        return Plaats;
    }

    /**
     * @param Plaats the Plaats to set
     */
    public void setPlaats(String Plaats)
    {
        this.Plaats = Plaats;
    }
}
