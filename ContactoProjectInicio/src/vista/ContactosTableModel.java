/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import modelo.Contacto;

/**
 *
 * @author Norberto Díaz-Díaz
 */
public class ContactosTableModel implements TableModel {

    private List<Contacto> contactos = new ArrayList<Contacto>();
    private List<TableModelListener> listeners = new ArrayList<TableModelListener>();

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
        fireContentsChanged();
    }

    public Contacto getRow(int indexRow){
        return contactos.get(indexRow);
    }
    public int getRowCount() {
        return contactos.size();
    }

    public int getColumnCount() {
        return 3; //ya que tendremos tres valores a mostrar por contacto
    }

    public String getColumnName(int columnIndex) {
        String name = null;
        switch (columnIndex) {
            case 0:
                name = "Nombre";
                break;
            case 1:
                name = "Telefono";
                break;
            case 2:
                name = "E-mail";
                break;
        }
        return name;
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class; //Todos los valores de contacto son un String
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //No permito editar celdas
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Contacto contacto = contactos.get(rowIndex);
        String value = null;
        switch (columnIndex) {
            case 0:
                value = contacto.getNombre();
                break;
            case 1:
                value = contacto.getTelefono();
                break;
            case 2:
                value = contacto.getEmail();
                break;
        }
        return value;

    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }

     protected void fireContentsChanged() {
        //TableModelEvent event = new TableModelEvent(this,0,getRowCount());
         TableModelEvent event = new TableModelEvent(this, 0, this.getRowCount()-1, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
        for (TableModelListener listener : listeners) {
            listener.tableChanged(event);
        }
    }
}
