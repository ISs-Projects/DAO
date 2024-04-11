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
public interface ContactoModel {
    //Enlaces con el controlador
    ContactoController getController();
    void setController(ContactoController controller);


    //Funciones que debe permitir el modelo
    void nuevoContacto(Contacto contacto);
    Contacto obtenerContacto(String nombre);
    void eliminarContacto(Contacto contacto);
    void actualizarContacto(Contacto contacto);
    List<Contacto> obtenerContactos();

}
