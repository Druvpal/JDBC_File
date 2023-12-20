import java.io.FileNotFoundException;
import java.sql.SQLException;

public class SQLQuery {
    public static void main(String[] args)throws ClassNotFoundException, FileNotFoundException, SQLException {
        //1.
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Successfully loaded....");

        //2.
        String url = "jdbc:mysql:///mydb";
        String userName = "root";
        
    }
}
