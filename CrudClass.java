package perzistencijahibernate;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CrudClass {
    
    private Session dbconnection;
    private Transaction tx = null;
    
    ArrayList<Zaposlenik> listaZaposlenika = new ArrayList<Zaposlenik>();
    String hql;
    String keyword;
    Query query;
    
    public CrudClass(Session dbconnection)
    {
        this.dbconnection = dbconnection;
    }
    //dodavanje novog zaposlenika
    public void AddNew(String ime, int godine, String adresa, float primanja)
    {
        tx = dbconnection.beginTransaction();
        Zaposlenik zaposlenik = new Zaposlenik(ime, godine, adresa, primanja);
        Integer id = (Integer)dbconnection.save(zaposlenik);
        
        tx.commit();
        
        JFrame frame = new JFrame("Obavijest");
        JOptionPane.showMessageDialog(frame, "Zaposlenik je uspjesno dodan pod id brojem " + id + ".");
        
    }
    //azuriranje zaposlenika
    public void UpdateById(int id, String ime, int godine, String adresa, float primanja)
    {
        tx = dbconnection.beginTransaction();
        Zaposlenik zaposlenik = (Zaposlenik) dbconnection.get(Zaposlenik.class, id);
        zaposlenik.setIme(ime);
        zaposlenik.setGodine(godine);
        zaposlenik.setAdresa(adresa);
        zaposlenik.setPrimanja(primanja);
        
        dbconnection.merge(zaposlenik);
        tx.commit();
        
        JFrame frame = new JFrame("Obavijest");
        JOptionPane.showMessageDialog(frame, "Zaposlenik sa id brojem " + id + " je uspjesno uredjen.");

    }
    //brisanje zaposlenika
    public void RemoveById(int id)
    {
        tx = dbconnection.beginTransaction();
        Zaposlenik zaposlenik = (Zaposlenik) dbconnection.get(Zaposlenik.class, id);
        
        dbconnection.delete(zaposlenik);
        tx.commit();
        
        JFrame frame = new JFrame("Obavijest");
        JOptionPane.showMessageDialog(frame, "Zaposlenik sa id brojem  " + id + " je uspjesno obrisan.");
    }
    //pretraga po id
    public ArrayList<Zaposlenik> searchAllById(int id)
    {
        tx = dbconnection.beginTransaction();
        listaZaposlenika.clear();
        hql = "from Zaposlenik as zaposlenik where zaposlenik.id="+id+"";
        
        query = dbconnection.createQuery(hql);
        listaZaposlenika = (ArrayList<Zaposlenik>) query.list();
        tx.commit();
        return listaZaposlenika;
        
    }
    //prikazivanje svih zaposlenika
    public ArrayList<Zaposlenik> getAll()
    {
        tx = dbconnection.beginTransaction();
        listaZaposlenika.clear();
        hql = "from Zaposlenik as zaposlenik";
        query = dbconnection.createQuery(hql);
        listaZaposlenika = (ArrayList<Zaposlenik>) query.list();
        tx.commit();
        return listaZaposlenika;  
    }
    //pretraga po imenu
    public ArrayList<Zaposlenik> searchAllByName(String ime)
    {
        tx = dbconnection.beginTransaction();
        listaZaposlenika.clear();
        hql = "from Zaposlenik as zaposlenik where zaposlenik.ime like :keyword";
        keyword = ime;
        query = dbconnection.createQuery(hql);
        query.setParameter("keyword", "%" + keyword + "%");
        listaZaposlenika = (ArrayList<Zaposlenik>) query.list();
        
        tx.commit();
        return listaZaposlenika;
    }
     //pretraga po godinama
    public ArrayList<Zaposlenik> searchAllByAge(int godine)
    {
        tx = dbconnection.beginTransaction();
        listaZaposlenika.clear();
        hql = "from Zaposlenik as zaposlenik where zaposlenik.godine ="+godine+"";
        query = dbconnection.createQuery(hql);
        listaZaposlenika = (ArrayList<Zaposlenik>) query.list();
        
        tx.commit();
        return listaZaposlenika;
    }
    //pretraga po adresi
    public ArrayList<Zaposlenik> searchAllByAddress(String adresa)
    {
        tx = dbconnection.beginTransaction();
        listaZaposlenika.clear();
        hql = "from Zaposlenik as zaposlenik where zaposlenik.adresa like :keyword";
        keyword = adresa;
        query = dbconnection.createQuery(hql);
        query.setParameter("keyword", "%" + keyword + "%");
        listaZaposlenika = (ArrayList<Zaposlenik>) query.list();
        
        tx.commit();
        return listaZaposlenika;
    }
     //pretraga po visini primanja
    public ArrayList<Zaposlenik> searchAllByIncome(float primanja)
    {
        tx = dbconnection.beginTransaction();
        listaZaposlenika.clear();
        hql = "from Zaposlenik as zaposlenik where zaposlenik.primanja ="+primanja+"";
        query = dbconnection.createQuery(hql);
        listaZaposlenika = (ArrayList<Zaposlenik>) query.list();
        
        tx.commit();
        return listaZaposlenika;
        
    }
}
