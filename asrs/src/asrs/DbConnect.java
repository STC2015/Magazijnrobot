package asrs;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DbConnect
{

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DbConnect()
    {

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/asrs", "root", "usbw");
            st = con.createStatement();

        } catch (Exception ex)
        {
            System.out.println("Error " + ex);

        }
    }

    public void setData(String v, String a, String ad, String pc, String wp, int ordernr, String datum)
    {
        Connection conn = null;
        Statement stmt = null;

       
        try
        {
           // String query0 = "SELECT Klantnr FROM klant where Voornaam = `" + v + "`";
           // rs = st.executeQuery("SELECT Klantnr FROM klant where Voornaam = '" + v + "'");
            //int klantnr = rs.getInt("Klantnr");
            int klantnr = 2;
            stmt = con.createStatement();
            String query1 = "INSERT INTO `klant`(`Klantnr`, `Voornaam`, `Achternaam`, `Adres`, `Postcode`, `Plaats`) VALUES ('" + 13 + "','" + v + "','" + a + "','" + ad + "','" + pc + "','" + wp + "')";
            stmt.executeUpdate(query1);
            System.out.println("Klant Opgeslagen.");
//            String query2 = "INSERT INTO `bestelling`(`Ordernr`, `Klantnr`, `Datum`) VALUES ("+ ordernr +",1,"+ datum +")";
//            rs = st.executeQuery(query2);
        } catch (Exception ex)
        {
            System.out.println("Error " + ex);
        }
    }

    public void getDataKlant(int klantNr)
    {
        try
        {

            String query = "SELECT * FROM klant where Klantnr = " + klantNr;
            rs = st.executeQuery(query);

            while (rs.next())
            {
                String voornaam = rs.getString("voornaam");
                String achternaam = rs.getString("achternaam");
                String adres = rs.getString("adres");
                String postcode = rs.getString("postcode");
                String woonplaats = rs.getString("plaats");
                System.out.println(voornaam + " " + achternaam + ", " + adres + ", " + postcode + " " + woonplaats);
            }
        } catch (Exception ex)
        {
            System.out.println("Error " + ex);
        }
    }

    public void getDataArtikel()
    {
        try
        {

            String query = "SELECT * FROM artikel";
            rs = st.executeQuery(query);

            while (rs.next())
            {
                String name = rs.getString("Artikelnaam");
                System.out.println(name);
            }
        } catch (Exception ex)
        {
            System.out.println("Error " + ex);
        }
    }

    public int getBestelling(int klantNr)
    {
        try
        {

            String query = "SELECT * FROM bestelling where Klantnr = " + klantNr;
            rs = st.executeQuery(query);

            while (rs.next())
            {
                int name = rs.getInt("orderNr");
                return name;
            }
        } catch (Exception ex)
        {
            System.out.println("Error " + ex);
        }
        return 0;
    }

    public void getDataBestelling(int orderNr)
    {
        try
        {

            String query = "SELECT * FROM orderitem o JOIN artikel a where o.Ordernr = " + orderNr + " And o.artikelnr = a.artikelnr";
            rs = st.executeQuery(query);

            while (rs.next())
            {
                String name = rs.getString("a.Artikelnaam");
                String nr = rs.getString("a.Artikelnr");
                System.out.println(nr + ". " + name);
            }
        } catch (Exception ex)
        {
            System.out.println("Error " + ex);
        }

    }
}
