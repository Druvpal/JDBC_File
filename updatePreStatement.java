import java.sql.*;
import java.util.Scanner;

public class updatePreStatement {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        PreparedStatement pstm = null;
        Scanner sc = new Scanner(System.in);
        ResultSet resultSet = null;
        //1.
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Successfuly Loaded....");

        String url = "jdbc:mysql:///jdbc";
        String userName = "root";
        String psw = "Manish@3123";
        Connection connection = DriverManager.getConnection(url,userName,psw);

        String sqlQuery = "update from jdtable set city = ? where id = ?";
        if(connection!=null)
            pstm = connection.prepareStatement(sqlQuery);
        if(pstm!=null){
            System.out.println("Enter the ID no :: \t");
            int id = sc.nextInt();
            System.out.println("Enter the City :: \t");
            String city = sc.next();
            pstm.setInt(1,id);
            pstm.setString(2,city);

            int count = pstm.executeUpdate();
            System.out.println("no of updated query are :: "+count);
        }



    }
}
