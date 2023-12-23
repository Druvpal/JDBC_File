import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.Scanner;

public class deletePreStatement {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        PreparedStatement pstm = null;
        Scanner sc = new Scanner(System.in);
//        ResultSet resultSet = null;
        //1.
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Successfuly Loaded....");

        String url = "jdbc:mysql:///jdbc";
        String userName = "root";
        String psw = "Manish@3123";
        Connection connection = DriverManager.getConnection(url,userName,psw);

        String sqlQuery = "delete from jdtable where id = ?";
        if(connection!=null)
            pstm = connection.prepareStatement(sqlQuery);
        if(pstm!=null){
            System.out.println("Enter the ID no :: \t");
            int id = sc.nextInt();
            pstm.setInt(1,id);
            int  count = pstm.executeUpdate();
            System.out.println("No of update rows are :: "+count);
        }
        sc.close();
        connection.close();
        pstm.close();
    }
}
