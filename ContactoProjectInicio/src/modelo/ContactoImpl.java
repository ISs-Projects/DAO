/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author Norberto Díaz-Díaz
 */
public class ContactoImpl implements Contacto {
    private String nombre;
    private String tlf;
    private String email;

    public ContactoImpl(String nombre) {
        this(nombre,null,null);
    }

    public ContactoImpl(String nombre, String tlf, String email) {
        this.nombre = nombre;
        this.tlf = tlf;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return tlf;
    }

    public void setTelefono(String tlf) {
        this.tlf = tlf;
    }

    @Override
     public String toString(){
        String s=this.nombre;
        s+="\t"+this.tlf;
        s+="\t"+this.email+"\n";
        return s;
    }

    



}
