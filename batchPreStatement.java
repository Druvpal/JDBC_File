import java.sql.*;
import java.util.Scanner;

public class batchPreStatement {
    public static void main(String[] args)throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement pstm = null;
        //1.
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver successfully loaded...");

        //2.
        String url = "jdbc:mysql:///manish";
        String userName = "root";
        String psw = "Manish@3123";
        connection = DriverManager.getConnection(url,userName,psw);
        String sqlQuery = "insert from student (firstname,lastname,age,city) values(?,?,?,?)";
        if(connection!=null)
            pstm = connection.prepareStatement(sqlQuery);
        if(pstm!=null){
            Scanner sc = new Scanner(System.in);
            while (true){
                System.out.print("Enter the firstname :: \t");
                String firstname = sc.next();
                System.out.print("Enter the lastname :: \t");
                String lastname = sc.next();
                System.out.print("Enter the age :: \t");
                Integer age = sc.nextInt();
                System.out.print("Enter the city :: \t");
                String city = sc.next();

                // Insert the pstm
                pstm.setString(1,firstname);
                pstm.setString(2,lastname);
                pstm.setInt(3,age);
                pstm.setString(4,city);

                // Insert into the batch
                pstm.addBatch();

                System.out.println("Do we want to insert one more record [Yes/No] :: \t");
                System.out.println("Enter the option :: \t");
                String option = sc.next();
                if(option.equalsIgnoreCase("No")){
                    break;
                }

            }
            pstm.executeBatch();
            System.out.println("Record successfully inserted ....");
        }



    }
}
