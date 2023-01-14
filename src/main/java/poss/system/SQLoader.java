package poss.system;

import java.sql.*;
import java.util.ArrayList;

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
            SQL_DATA.executeQuery("UPDATE TABLE PossData SET ID = ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
