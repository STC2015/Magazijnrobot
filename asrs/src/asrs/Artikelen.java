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
public class Artikelen
{
 private int ArtikelNr;
 private int ArtikelHoogte;
 private int ArtikelBreedte;
 private String ArtikelNaam;
 private int Aantal;
         
 public Artikelen(int nr,int hoogte,int breedte,String naam ,int aantal)
 {
     ArtikelNr = nr;
     ArtikelHoogte = hoogte;
     ArtikelBreedte = breedte;
     ArtikelNaam = naam;
     Aantal = aantal;       
     
 }

    /**
     * @return the ArtikelNr
     */
    public int getArtikelNr()
    {
        return ArtikelNr;
    }

    /**
     * @return the ArtikelHoogte
     */
    public int getArtikelHoogte()
    {
        return ArtikelHoogte;
    }

    /**
     * @return the ArtikelBreedte
     */
    public int getArtikelBreedte()
    {
        return ArtikelBreedte;
    }

    /**
     * @return the ArtikelNaam
     */
    public String getArtikelNaam()
    {
        return ArtikelNaam;
    }

    /**
     * @return the Aantal
     */
    public int getAantal()
    {
        return Aantal;
    }

    /**
     * @param Aantal the Aantal to set
     */
    public void setAantal(int Aantal)
    {
        this.Aantal = Aantal;
    }
 
 }
 
