package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtility {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;


    public static void createConnection() {

        switch (Config.getProperty("dbType")) {

            case "oracle":
                try {
                    connection = DriverManager.getConnection(Config.getProperty("oracleURL"),
                            Config.getProperty("oracleUserName"),
                            Config.getProperty("oraclePassword"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "mysql":
                // create connection for mysql
                break;
            default:
                connection = null;

        }
    }


    public static List<Map<Object,Object>> executeQuery(String query){
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSetMetaData metaData = null;
        try {
            metaData = resultSet.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int numberOfColumns = 0;
        try {
            numberOfColumns = metaData.getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Map<Object, Object>> data = new ArrayList<>();

        while (true){
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Map<Object,Object> map = new HashMap<>();
            for (int i =1; i<=numberOfColumns; i++){
                try {
                    map.put(metaData.getColumnName(i), resultSet.getObject(i));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            data.add(map);
        }
        return data;
    }

    public static void close() throws SQLException {
        if(connection!= null){
            connection.close();
        }
        if(statement!= null){
            statement.close();
        }
        if(resultSet!= null){
            resultSet.close();
        }



    }



}
