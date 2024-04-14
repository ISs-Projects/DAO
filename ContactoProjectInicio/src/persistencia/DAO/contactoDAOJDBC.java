
package persistencia.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Contacto;
import modelo.ContactoImpl;

/**
 *
 * @author developer
 */
public class contactoDAOJDBC implements ContactoDAO {

    private Persistencia conn;

    @Override
    public Contacto read(String name) {
	Contacto contacto = null;
	try {
	    conn = (Persistencia) Persistencia.getInstance();
	    if (conn != null) {
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery(" SELECT Contactos WHERE nombre = '" + name + "';  ");
		String nombre = res.getString("nombre");
		String email = res.getString("email");
		String telefono = res.getString("telefono");
		contacto = new ContactoImpl(nombre, telefono, email);
		stmt.close();
		conn.closeConecion();
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(contactoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
	}
	return contacto;
    }

    @Override
    public void create(Contacto contacto) {
	try {
	    conn = (Persistencia) Persistencia.getInstance();
	    if (conn != null) {
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("INSERT INTO Contactos (nombre,telefono,email) VALUES ('" + contacto.getNombre() + "','" + contacto.getTelefono() + "','" + contacto.getEmail() + "'); ");
		stmt.close();
		conn.closeConecion();
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(contactoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    @Override
    public void update(Contacto contacto) {
	try {
	    conn = (Persistencia) Persistencia.getInstance();
	    if (conn != null) {
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("UPDATE Contactos SET nombre = '" + contacto.getNombre() + "', telefono = '" + contacto.getTelefono() + "', email = '" + contacto.getEmail() + "' WHERE nombre = '" + contacto.getNombre() + "'; ");
		stmt.close();
		conn.closeConecion();
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(contactoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    @Override
    public void delete(Contacto contacto) {
	try {
	    conn = (Persistencia) Persistencia.getInstance();
	    if (conn != null) {
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("DELETE FROM Contactos WHERE nombre = '" + contacto.getNombre() + "';  ");
		stmt.close();
		conn.closeConecion();
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(contactoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    @Override
    public List<Contacto> list() {
	List<Contacto> contactos = new ArrayList<>();
	try {
	    conn = (Persistencia) Persistencia.getInstance();
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
		conn.closeConecion();
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(contactoDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
	}
	return contactos;
    }

}
