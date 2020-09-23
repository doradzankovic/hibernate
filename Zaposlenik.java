package perzistencijahibernate;

import javax.persistence.*;

@Entity
@Table(name = "zaposlenik")

public class Zaposlenik
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "ime")
    private String ime;
    
    @Column(name = "godine")
    private int godine;
    
    @Column(name = "adresa")
    private String adresa;
    
    @Column(name = "primanja")
    private float primanja;
    
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getIme()
    {
        return ime;
    }
    public void setIme(String ime)
    {
        this.ime = ime;
    }
    public int getGodine()
    {
        return godine;
    }
    public void setGodine(int godine)
    {
        this.godine = godine;
    }
    public String getAdresa()
    {
        return adresa;
    }
    public void setAdresa(String adresa)
    {
        this.adresa = adresa;
    }
    public float getPrimanja()
    {
        return primanja;
    }
    public void setPrimanja(float primanja)
    {
        this.primanja = primanja;
    }
    
    public Zaposlenik(String ime, int godine, String adresa, float primanja) 
    {
        this.ime = ime;
        this.godine = godine;
        this.adresa = adresa;
        this.primanja = primanja;
    }
    
    public Zaposlenik(int id, String ime, int godine, String adresa, float primanja) 
    {
        this.id = id;
        this.ime = ime;
        this.godine = godine;
        this.adresa = adresa;
        this.primanja = primanja;
    }

    public Zaposlenik() {}

    @Override
    public String toString() {
        return ime + ";" + godine + ";" + adresa + ";" + primanja;
    }
    
}
