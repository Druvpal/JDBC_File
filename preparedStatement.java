import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class preparedStatement {
    public static void main(String[] args)throws ClassNotFoundException, SQLException {
        PreparedStatement pstm = null;
        Scanner sc = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Successfuly loaded....");

        String url = "jdbc:mysql:///jdbc";
        String userName = "root";
        String psw = "Manish@3123";
        Connection connection = DriverManager.getConnection(url,userName,psw);

        String sqlQuery = "insert into jdtable (firstname,lastname,age,city) values(?,?,?,?)";
        if(connection!=null)
            pstm = connection.prepareStatement(sqlQuery);
        if(pstm!=null){
            System.out.println("Enter the firstname :: \t");
            String firstname = sc.next();
            System.out.println("Enter the lastname :: \t");
            String lastname = sc.next();
            System.out.println("Enter the age :: \t");
            int age = sc.nextInt();
            System.out.println("Enter the city :: \t");
            String city = sc.next();
            //use the precompiled query to set the value
            pstm.setString(1,firstname);
            pstm.setString(2,lastname);
            pstm.setInt(3,age);
            pstm.setString(4,city);

            System.out.println(sqlQuery);

            // Execute the query
            int count = pstm.executeUpdate();
            System.out.println("No of row Updated..."+count);
        }

        pstm.close();
        connection.close();
    }
}
