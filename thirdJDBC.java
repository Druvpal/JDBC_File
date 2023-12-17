import java.sql.*;

public class thirdJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = jdbcUtil.getJdbcConnection();
            if(connection!=null)
                statement = connection.createStatement();
            if(statement!=null)
                resultSet = statement.executeQuery("select id,firstname,lastname,age,city from jdtable");
            if(resultSet!=null){
                System.out.println("ID\tFirstName\tLastName\tAge\tCity");
                while (resultSet.next()){
                    System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)
                    +"\t"+resultSet.getString(3)+"\t"+resultSet.getInt(4)+"\t"+
                            resultSet.getString(5));
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                jdbcUtil.CleanUp(connection,statement,resultSet);
                System.out.println("Successfully closed....");
            }
            catch (SQLException e){
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        // 6.
        resultSet.close();
        statement.close();
        connection.close();
        System.out.println("All the connections are closed...");
    }
}
