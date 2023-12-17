import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import  java.sql.*;

public class secondJDBC {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            //1.
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver successfully loaded");

            //2.
            String url = "jdbc:mysql://localhost:3306/jdbc";
            String userName = "root";
            String psw = "Manish@3123";
            connection = DriverManager.getConnection(url,userName,psw);
            System.out.println("Connection Successfully created....");
            System.out.println(connection.getClass().getName());

            //3.
            String sqlQuary = "select id, firstname, lastname, age,city from jdtable";
            statement= connection.createStatement();
            resultSet = statement.executeQuery(sqlQuary);

            System.out.println("sucessesfully created Quary :");

            //4.
            System.out.println();
            System.out.println("ID\tFirstName\tLastName\tAge\tCity");
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                String firstname = resultSet.getString(2);
                String lastname = resultSet.getString(3);
                Integer age = resultSet.getInt(4);
                String city = resultSet.getString(5);

                System.out.println(id+"\t"+firstname+"\t"+lastname+"\t"+age+"\t"+city);
            }
        }
        //5.
        catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }

        //6.

        finally {
            if(connection!=null){
                try {
                    connection.close();
                    System.out.println("Connection Successfuly closed .....");
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

    }
}
