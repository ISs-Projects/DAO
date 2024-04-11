/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.Contacto;
import modelo.ContactoImpl;
import modelo.ContactoModel;
import vista.ContactoView;

/**
 *
 * @author Norberto Díaz-Díaz
 */
public class ContactoControllerImpl implements ContactoController{
    private ContactoModel model;
    private List<ContactoView> views=new ArrayList<ContactoView>();

    public void setup(ContactoModel model, List<ContactoView> views) {
        setModel(model);
        addViews(views);
        model.setController(this);
        
    }

    public void start() {
        for(ContactoView view:views)
            view.display();
    }

    private void addViews(List<ContactoView> views){
        for(ContactoView view:views)
            addView(view);
    }
    public void addView(ContactoView view) {
        view.setModel(model);
        view.setController(this);
        views.add(view);
    }

    public void removeView(ContactoView view) {
        views.remove(view);
    }

    public ContactoModel getModel() {
        return model;
    }

    public void setModel(ContactoModel model) {
        this.model=model;
    }

    public void nuevoContactoGesture(String nombre, String tlf, String email) {
        Contacto contacto=new ContactoImpl(nombre);
        contacto.setTelefono(tlf);
        contacto.setEmail(email);
        getModel().nuevoContacto(contacto);
    }

    public void actualizaContactoGesture(String nombre, String tlf, String email) {
        Contacto contacto=new ContactoImpl(nombre);
        contacto.setTelefono(tlf);
        contacto.setEmail(email);
        getModel().actualizarContacto(contacto);
    }

    public void borraContactoGesture(String nombre) {
        Contacto contacto=new ContactoImpl(nombre);
        getModel().eliminarContacto(contacto);
    }



    public void fireDataModelChanged() {
        for (ContactoView view : views) {
            view.dataModelChanged();
        }
    }

}
