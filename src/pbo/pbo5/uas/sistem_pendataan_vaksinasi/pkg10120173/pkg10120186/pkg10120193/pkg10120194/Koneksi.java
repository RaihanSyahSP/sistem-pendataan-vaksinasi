
package pbo.pbo5.uas.sistem_pendataan_vaksinasi.pkg10120173.pkg10120186.pkg10120193.pkg10120194;
import java.sql.*;

public class Koneksi {
    public static Connection getConnection()
    {
        String user = "";
        String pwd = "";
        String host = "";
        String db = "";
        String urlValue = "";
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            urlValue = "jdbc:mysql://" + host + "/" + db + "?user=" + user + "&password=" + pwd;
            conn = DriverManager.getConnection(urlValue);
        }catch (SQLException e){
            System.out.println("Koneksi Gagal " + e.toString());
        } catch(ClassNotFoundException e) {
            System.out.println("JDBC Driver tidak ditemukan");
        } 
        return conn;
    }
}
