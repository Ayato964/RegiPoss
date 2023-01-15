package poss.system;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import org.sqlite.*;
public class SQLoader {
    private static SQLoader INSTANCE_BIGDATA = null;
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
                PreparedStatement s = connect.prepareStatement("SELECT ID, Name, Price FROM ItemData WHERE ID = 0");
                //ResultSet resultSet = SQL_DATA.executeQuery("SELECT ID, Name, Price FROM ItemData WHERE ID = 0");
                ResultSet resultSet = s.executeQuery();
                while (resultSet.next()){
                    System.out.println(resultSet.getInt(1) + "   " + resultSet.getString(2) + "    " + resultSet.getInt(3));
                   // System.out.println(resultSet.getInt(1));
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Contract(pure = true)
    public @Nullable ItemData get(int id){
        ItemData idata = null;
        try {
            ResultSet resultSet = SQL_DATA.executeQuery("SELECT ID, Name, Price FROM ItemData WHERE ID = " + id);
            resultSet.next();
            idata = ItemData.create(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return idata;
    }
    @Contract(pure = true)
    public @Nullable ItemData get(String name){
        try {
            ResultSet resultSet = SQL_DATA.executeQuery("SELECT ID, Name, Price FROM ItemData WHERE Name = " + name);
            return ItemData.create(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Contract(pure = true)
    public ArrayList<ItemData> gets(String category){
        System.out.println("Category:" + category);
        try {
            ResultSet resultSet = SQL_DATA.executeQuery("SELECT ID, Name, Price FROM ItemData WHERE Category =  '" + category + "'");
            ArrayList<ItemData> data = new ArrayList<>();
            while (resultSet.next())
                 data.add(ItemData.create(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
            return data;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static SQLoader getBigData() {
        if(INSTANCE_BIGDATA == null)
            INSTANCE_BIGDATA = new SQLoader("bigdata/ItemData.db");
        return SQLoader.INSTANCE_BIGDATA;

    }

    public void pushes(ArrayList<ItemData> data)  {
        try {
            connect.setAutoCommit(false);
            ResultSet max = SQL_DATA.executeQuery("SELECT MAX (ID) FROM PossData");
            max.next();
            int id = max.getInt(1) + 1;
            PreparedStatement push = connect.prepareStatement("INSERT INTO PossData VALUES (?, ?, ?, ?)");
            int i = 0;
            connect.beginRequest();
            for(ItemData d : data){
                push.setInt(1, id);
                push.setInt(2, d.id);
                push.setString(3, "DATETIME('now')");
                push.setInt(4, 0);
                i += push.executeUpdate();
                //i += SQL_DATA.executeUpdate("INSERT INTO PossData VALUES (1, 0, DATETIME('now') 0)");
            }
            connect.endRequest();
            connect.commit();
            System.out.println(i + " <- UPDATE!!");

        } catch (SQLException e) {
            try {
                connect.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }

    }
}
