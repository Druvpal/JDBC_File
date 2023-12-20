import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlUpdateQuery {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Successfully Loaded...");

        String url = "jdbc:mysql:///jdbc";
        String userName = "root";
        String psw = "Manish@3123";
        Connection connection = DriverManager.getConnection(url,userName,psw);

        Statement statement = connection.createStatement();
        String sqlinsert = "insert into jdtable (firstname,lastname,age,city) Values ('anish','manis',26,'varanasi')";
        int number = statement.executeUpdate(sqlinsert);
        System.out.println(number);

        statement.close();
        connection.close();

    }
}
