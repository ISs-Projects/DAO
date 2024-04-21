/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author developer
 */
public class Persistencia {

    private static Persistencia instance;
    private Connection conn;
    
    private Persistencia(){
	try {
	    this.conn = createConnection();
	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
	} catch (SQLException ex) {
	    Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    public Connection getConn() {
	return conn;
    }

    private Connection createConnection() throws ClassNotFoundException, SQLException {
	String login = "root";
	String password = "developer";
	String url = "jdbc:mysql://127.0.0.1:3306/miniagenda?serverTimezone=UTC";

	Class.forName("com.mysql.cj.jdbc.Driver");

	return DriverManager.getConnection(url, login, password);
    }

    public static Persistencia getInstance() throws SQLException {
	if (instance == null) {
	    instance = new Persistencia();
	}
	return instance;
    }

    void closeConecion() throws SQLException {
	this.conn.close();
    }

    Statement createStatement() throws SQLException {
	return instance.createStatement();
    }
}
