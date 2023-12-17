import java.io.FileNotFoundException;
import java.sql.*;

public class firstJDBC {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            // 1. Load and register the Driver;
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Successfuly loaded.......");

            // 2. Established the connection with database;
            String url = "jdbc:mysql://localhost:3306/manish";
            String userName = "root";
            String psw = "Manish@3123";
            connection = DriverManager.getConnection(url,userName,psw);
            System.out.println("Connection established successfully.....");
            System.out.println("The implement class name is " + connection.getClass().getName());

            // 3. Create the Statement and Quary

            String sqlQuary = "select id,firstname,lastname,age,city,country from student";

            statement = connection.createStatement();
            System.out.println("The implementation class name is :: " + statement.getClass().getName());

            resultSet = statement.executeQuery(sqlQuary);
            System.out.println("The imlementation class name is :: " + resultSet.getClass().getName());

            //4.  Process the ResultSet
            System.out.println();
            System.out.println("ID\tFirstName\tLastName\tAge\t\tCity\tCountry");

            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                String firstname = resultSet.getString(2);
                String lastname = resultSet.getString(3);
                Integer age = resultSet.getInt(4);
                String city = resultSet.getString(5);
                String county = resultSet.getString(6);

                System.out.println(id+"\t\t"+firstname+"\t\t"+lastname+"\t\t"+age+"\t\t"+city+"\t\t"+county);
            }


        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException se) {
            throw new RuntimeException(se);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
