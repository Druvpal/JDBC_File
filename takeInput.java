import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class takeInput {
    public static void main(String[] args)throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Successfully loaded...");

        String url = "jdbc:mysql:///jdbc";
        String userName = "root";
        String psw = "Manish@3123";
        Connection connection = DriverManager.getConnection(url,userName,psw);
        System.out.println("Connection Successfully ....");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the firstname :\t");
        String firstname = sc.next();
        System.out.print("Enter the lastname :\t");
        String lastname = sc.next();
        System.out.print("Enter the age :\t");
        int age = sc.nextInt();
        System.out.print("Enter the city :\t");
        String city = sc.next();

//        firstname = "'"+firstname+"'";
//        lastname = "'"+lastname+"'";
//        city = "'"+city+"'";
        Statement statement = connection.createStatement();
//        String sqlQuery = "insert into jdtable (firstname,lastname,age,city) values("+firstname+","+lastname+","+age+","+city+")";
//        System.out.println(sqlQuery);

        String sqlQuery = String.format("Insert into jdtable (firstname,lastname,age,city) values ('%s','%s',%d,'%s') ", firstname,lastname,age,city);
        System.out.println(sqlQuery);
        int value = statement.executeUpdate(sqlQuery);
        System.out.println(value);
    }
}
