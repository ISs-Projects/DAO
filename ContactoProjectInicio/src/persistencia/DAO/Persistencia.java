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

    private static Connection instance;

    private static Connection createConnection() throws ClassNotFoundException, SQLException {
	String login = "root";
	String password = "developer";
	String url = "jdbc:mysql://127.0.0.1:3306/miniagenda?serverTimezone=UTC";

	Class.forName("com.mysql.cj.jdbc.Driver");
	instance = DriverManager.getConnection(url, login, password);

	return instance;
    }

    public static Connection getInstance() throws SQLException {
	if (instance == null) {
	    try {
		instance = createConnection();
	    } catch (ClassNotFoundException ex) {
		Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	return instance;
    }

    void closeConecion() throws SQLException {
	instance.close();
    }

    Statement createStatement() throws SQLException {
	return instance.createStatement();
    }
}
