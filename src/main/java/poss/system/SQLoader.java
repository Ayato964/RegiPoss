package poss.system;

import java.sql.*;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import org.sqlite.*;
public class SQLoader {
    private static final SQLoader INSTANCE_BIGDATA = new SQLoader("bigdata/ItemData.db");
    private Connection connect;
    private Statement SQL_DATA;
    private String url;
    private  SQLoader(String path){
        url = "jdbc:sqlite:" + getClass().getClassLoader().getResource(path).toString();
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try{
                connect = DriverManager.getConnection(url);
                SQL_DATA = connect.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Contract(pure = true)
    public @Nullable ItemData get(int id){
        ItemData idata = null;
        try {
            ResultSet resultSet = SQL_DATA.executeQuery("SELECT ItemID, ItemName, ItemPrice FROM ItemData WHERE ItemID = " + id);
            //System.out.println(resultSet.getInt(1) + "   " + resultSet.getString(2) + "       " +  resultSet.getInt(3));
            idata = ItemData.create(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return idata;
    }
    @Contract(pure = true)
    public @Nullable ItemData get(String name){
        try {
            ResultSet resultSet = SQL_DATA.executeQuery("SELECT ItemID, ItemName, ItemPrice FROM ItemData WHERE ItemName = " + name);
            return ItemData.create(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Contract(pure = true)
    public ItemData @Nullable []  gets(String category){
        try {
            ResultSet resultSet = SQL_DATA.executeQuery("SELECT ItemID, ItemName, ItemPrice FROM ItemData WHERE ItemCategory = " + category);
            ItemData[] data = new ItemData[resultSet.getFetchSize()];
            int i = 0;
            do {
                data[i] = ItemData.create(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
                i ++;
            }while (resultSet.next());
            return data;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static SQLoader getBigData() {
        return SQLoader.INSTANCE_BIGDATA;
    }

}
