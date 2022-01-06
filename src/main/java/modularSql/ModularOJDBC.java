package modularSql;

import java.sql.*;

public class ModularOJDBC {

    public static String HOSTNAME="";
    public static String IP="";
    public static String PORT="";
    public static String DBNAME="";
    public static String USERNAME="";
    public static String PASSWORD="";
    public static String OJDBC_PATH="";
    public static String MAX_PRICE_QUERY="";
    public static String MIN_PRICE_QUERY="";

    public static Connection connection=null;

    public static Connection connection(){
        if(connection==null){
            try {
                return getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(OJDBC_PATH);
        connection = DriverManager.getConnection(HOSTNAME+IP+PORT+DBNAME,USERNAME,PASSWORD);
    return connection;
    }

    public static Statement createStatment(){
        Statement workbook=null;
        try {
             workbook = connection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workbook;
    }

    public static ResultSet getResult(Statement statement,String query) throws SQLException {
        ResultSet result = statement.executeQuery(query);
        return result;
    }

    public static void getResult_Index(ResultSet result ) throws SQLException {
        String price = result.getString(1);
        System.out.println(price);
    }

    public static void getResult_Header(ResultSet result,String header) throws SQLException {
        while (result.next()){
            String price = result.getString(header);
            if(price==null){
                break;
            }
            System.out.println(price);
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        connection = connection();
        Statement workbook = createStatment();
        ResultSet result = getResult(workbook, MAX_PRICE_QUERY);
        getResult_Index(result);
        getResult_Header(result,"RETAIL_PRICE");
    }
}
