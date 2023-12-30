import java.sql.*;
import java.util.Scanner;

public class transactionApp {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        ResultSet resultSet = null;
        Scanner sc = new Scanner(System.in);
        //1.
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Successfully loaded....");

        //2.
        String url = "jdbc:mysql:///manish";
        String userName = "root";
        String psw = "Manish@3123";
        Connection connection = DriverManager.getConnection(url,userName,psw);

        //3.
        if(connection!=null)
            stmt = connection.createStatement();
        if(stmt!=null){
            resultSet = stmt.executeQuery("select name,bal from account ");
        }

        if(resultSet!=null){
            System.out.println("Name\tBalance");
            while (resultSet.next()){
                System.out.println(resultSet.getString(1)+"\t"+resultSet.getInt(2));
            }
        }
        /// Transaction beings
        System.out.println("\n Transactions beings...");
        connection.setAutoCommit(false);

         stmt.executeUpdate("update account set bal = bal+2000 where name='manish'");
         stmt.executeUpdate("update account set bal = bal-2000 where name = 'anish'");
        System.out.println("Can you please confirm transaction 2000INR [yes/no]..");
        String option = sc.next();
        if(option.equalsIgnoreCase("yes")){
            connection.commit();
        }
        else{
            connection.rollback();
        }

        ResultSet rs = stmt.executeQuery("select name, bal from account");
        if (rs!=null){
            System.out.println("Name\tBalance");
            while (rs.next()){
                System.out.println(rs.getString(1)+"\t"+rs.getInt(2));
//                System.out.println(resultSet.getString(1)+"\t"+resultSet.getInt(2));
            }
        }

    }
}
