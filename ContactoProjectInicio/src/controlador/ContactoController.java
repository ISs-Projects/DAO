/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.List;
import modelo.ContactoModel;
import vista.ContactoView;

/**
 *
 * @author Norberto Díaz-Díaz
 */
public interface ContactoController {
    //Metodo para enlazar la vista y el modelo
    void setup(ContactoModel model, List<ContactoView> view);
    //Metodo para lanzar la aplicación MVC
    void start();

    void addView(ContactoView view);
    void removeView(ContactoView view);

    ContactoModel getModel();
    void setModel(ContactoModel model);

    //Métodos a los que la vista llamará. Por ahora permitimos crear nuevos contactos
    void nuevoContactoGesture(String nombre, String tlf, String email);
    void borraContactoGesture(String nombre);
    void actualizaContactoGesture(String nombre, String tlf, String email);

    //Métodos que el modelo puede llamar
    void fireDataModelChanged();

}
