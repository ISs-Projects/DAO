import java.sql.*;

public class mostrarminiagenda {

    static String login = "root";
    static String password = "root";
    static String url = "jdbc:mysql://localhost/MiniAgenda?serverTimezone=UTC";

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, login, password);
            if (conn != null) {
                Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM contactos");
                System.out.println("\nNOMBRE \t\t EMAIL \t\t\t TELEFONO \n");
                while (res.next()) {
                    String nombre = res.getString("nombre");
                    String email = res.getString("email");
                    String telefono = res.getString("telefono");
                    System.out.println(nombre + " \t " + email + " \t " + telefono);
                }
                res.close();
                stmt.close();
                conn.close();
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
}