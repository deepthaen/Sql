package org.sql.com;

import java.sql.*;

public class SqlStart {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //System.setProperty("chrome.driver.","path")
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection
                ("jdbc:oracle:thin:@10.21.79.20:1521:FLOMSUAT","flstuatoms","flstuatoms");


        Statement workbook = connection.createStatement();
        ResultSet result = workbook.executeQuery("select MAX(retail_price) from yfs_order_line");
        //ResultSet result = workbook.executeQuery("select * from yfs_order_line");

        while(result.next()){
            //String price = result.getString("RETAIL_PRICE");
            String price = result.getString(1);
            if(price==null){
                break;
            }
            System.out.println(price);
        }
    }
    /**
     * Connect file(ipadresss, user, pass)
     * Workbook- statement
     * sheet -- execute query
     *
     */

    /**
     * Excel file reading
     *  File(path)
     *  Workbook.create();
     *  sheet
     *  row
     *  colum
     *  cell
     */
}
