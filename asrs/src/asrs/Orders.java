/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asrs;

import java.util.Date;
import java.util.*;

/**
 *
 * @author jorian
 */
public class Orders
{
    private int KlantNr;
    private int OrderNr;
    private Date datum;
    private ArrayList artikel;

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
     * @return the OrderNr
     */
    public int getOrderNr()
    {
        return OrderNr;
    }

    /**
     * @param OrderNr the OrderNr to set
     */
    public void setOrderNr(int OrderNr)
    {
        this.OrderNr = OrderNr;
    }

    /**
     * @return the datum
     */
    public Date getDatum()
    {
        return datum;
    }

    /**
     * @param datum the datum to set
     */
    public void setDatum(Date datum)
    {
        this.datum = datum;
    }

    /**
     * @return the artikel
     */
    public ArrayList getArtikel()
    {
        return artikel;
    }

    /**
     * @param artikel the artikel to set
     */
    public void setArtikel(ArrayList artikel)
    {
        this.artikel = artikel;
    }
    
}
