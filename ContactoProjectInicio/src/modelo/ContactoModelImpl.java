/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ContactoController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Norberto Díaz-Díaz
 */
public class ContactoModelImpl implements ContactoModel {

    private ContactoController controller;

    @Override
    public ContactoController getController() {
	return controller;
    }

    @Override
    public void setController(ContactoController controller) {
	this.controller = controller;
    }

    @Override
    public void nuevoContacto(Contacto contacto) {
	String login = "root";
	String password = "developer";
	String url = "jdbc:mysql://127.0.0.1:3306/miniagenda?serverTimezone=UTC";
	Connection conn = null;
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    conn = DriverManager.getConnection(url, login, password);
	    if (conn != null) {
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("INSERT INTO Contactos (nombre,telefono,email) VALUES ('"+contacto.getNombre()+"','"+contacto.getTelefono()+"','"+contacto.getEmail()+"'); ");
		stmt.close();
		conn.close();
	    }

	} catch (SQLException ex) {
	    System.out.println(ex);
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(ContactoModelImpl.class.getName()).log(Level.SEVERE, null, ex);
	}
	this.fireModelChanged();

    }

    @Override
    public void eliminarContacto(Contacto contacto) {
	String login = "root";
	String password = "developer";
	String url = "jdbc:mysql://127.0.0.1:3306/miniagenda?serverTimezone=UTC";
	Connection conn = null;
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    conn = DriverManager.getConnection(url, login, password);
	    if (conn != null) {
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("DELETE FROM Contactos WHERE nombre = '"+contacto.getNombre()+"';  ");
		stmt.close();
		conn.close();
	    }

	} catch (SQLException ex) {
	    System.out.println(ex);
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(ContactoModelImpl.class.getName()).log(Level.SEVERE, null, ex);
	}
	this.fireModelChanged();
    }

    @Override
    public Contacto obtenerContacto(String nombre) {
	String login = "root";
	String password = "developer";
	String url = "jdbc:mysql://127.0.0.1:3306/miniagenda?serverTimezone=UTC";
	Connection conn = null;
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    conn = DriverManager.getConnection(url, login, password);
	    if (conn != null) {
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(" SELECT Contactos WHERE nombre = '"+nombre+"';  ");
		stmt.close();
		conn.close();
	    }

	} catch (SQLException ex) {
	    System.out.println(ex);
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(ContactoModelImpl.class.getName()).log(Level.SEVERE, null, ex);
	}
	return null;
    }

    @Override
    public void actualizarContacto(Contacto contacto) {
	String login = "root";
	String password = "developer";
	String url = "jdbc:mysql://127.0.0.1:3306/miniagenda?serverTimezone=UTC";
	Connection conn = null;
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    conn = DriverManager.getConnection(url, login, password);
	    if (conn != null) {
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("UPDATE Contactos SET nombre = '"+contacto.getNombre()+"', telefono = '"+contacto.getTelefono()+"', email = '"+contacto.getEmail()+"' WHERE nombre = '"+contacto.getNombre()+"'; ");
		stmt.close();
		conn.close();
	    }

	} catch (SQLException ex) {
	    System.out.println(ex);
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(ContactoModelImpl.class.getName()).log(Level.SEVERE, null, ex);
	}
	this.fireModelChanged();

    }

    @Override
    public List<Contacto> obtenerContactos() {
	return obtenerContactosInternal();
    }

    protected void fireModelChanged() {
	getController().fireDataModelChanged();
    }

    private List<Contacto> obtenerContactosInternal() {
	List<Contacto> contactos = new ArrayList<>();
	String login = "root";
	String password = "developer";
//        String url = "jdbc:mysql://127.0.0.1:8889/miniagenda?serverTimezone=UTC&useSSL=false";
	String url = "jdbc:mysql://127.0.0.1:3306/miniagenda?serverTimezone=UTC&usesSSL=false";
	Connection conn = null;
	try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	    conn = DriverManager.getConnection(url, login, password);
	    if (conn != null) {
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery("SELECT * FROM Contactos");
		System.out.println("\nNOMBRE \t\t EMAIL \t\t\t TELEFONO \n");
		while (res.next()) {
		    String nombre = res.getString("nombre");
		    String email = res.getString("email");
		    String telefono = res.getString("telefono");
		    System.out.println(nombre + " \t " + email + " \t " + telefono);
		    Contacto contacto = new ContactoImpl(nombre, telefono, email);
		    contactos.add(contacto);
		}
		res.close();
		stmt.close();
		conn.close();
	    }

	} catch (SQLException ex) {
	    System.out.println(ex);
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(ContactoModelImpl.class.getName()).log(Level.SEVERE, null, ex);
	}
	return contactos;
    }
}
