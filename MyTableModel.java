package perzistencijahibernate;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel
{
    ArrayList<Zaposlenik> lista = new ArrayList();
    String[] kolone = {"ID", "Ime", "Godine", "Adresa", "Primanja"};
    
    public MyTableModel()
    {
        
    }
    
    public MyTableModel(ArrayList lista)
    {
        this.lista = lista;
    }
    
    @Override
    public String getColumnName(int columnIndex){
         return kolone[columnIndex];
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length; 
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zaposlenik zaposlenik = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return zaposlenik.getId();
            case 1: 
                return zaposlenik.getIme();
            case 2:
                return zaposlenik.getGodine();
            case 3:
                return zaposlenik.getAdresa();
            case 4:
                return zaposlenik.getPrimanja();
           }
           return null;
   }
    @Override
   public Class<?> getColumnClass(int columnIndex){
          switch (columnIndex){
              case 0:
                  return Integer.class;
             case 1:
               return String.class;
             case 2:
               return Integer.class;
             case 3:
               return String.class;
             case 4:
               return Float.class;
             }
             return null;
      }
    
}
