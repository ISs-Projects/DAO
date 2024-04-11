/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ContactoController;
import java.util.List;


/**
 *
 * @author Norberto Díaz-Díaz
 */
public class ContactoModelImpl implements ContactoModel {

    private ContactoController controller;

    public ContactoController getController() {
        return controller;
    }

    public void setController(ContactoController controller) {
        this.controller = controller;
    }

    public void nuevoContacto(Contacto contacto) {
        throw new UnsupportedOperationException();
    }

    public void eliminarContacto(Contacto contacto) {
        throw new UnsupportedOperationException();
    }

    public Contacto obtenerContacto(String nombre) {
        throw new UnsupportedOperationException();
    }

    public void actualizarContacto(Contacto contacto) {
        throw new UnsupportedOperationException();

    }

    public List<Contacto> obtenerContactos() {
        throw new UnsupportedOperationException();
    }

 

    protected void fireModelChanged() {
        getController().fireDataModelChanged();
    }
}
