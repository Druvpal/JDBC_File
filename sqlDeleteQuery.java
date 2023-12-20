import  java.sql.*;
public class sqlDeleteQuery {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver successfully loaded");

        //2.
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String userName = "root";
        String psw = "Manish@3123";
        Connection connection = DriverManager.getConnection(url,userName,psw);
        System.out.println("Connection Successfully created....");
        System.out.println(connection.getClass().getName());

        //3.
        Statement statement = connection.createStatement();
        String sqlQuary = "delete from jdtable where id=2";
        int delete = statement.executeUpdate(sqlQuary);
        System.out.println(delete);

//        resultSet.close();
        statement.close();
        connection.close();


    }
}
