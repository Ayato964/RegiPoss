package poss.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLoader {
    private static final SQLoader INSTANCE_BIGDATA = new SQLoader("bigdata/ItemData.db");
    private Connection connect;
    private String url;
    private  SQLoader(String path){
        url = "jdbc:sqlite:" + getClass().getClassLoader().getResource(path).toString();
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try{
                connect = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static SQLoader getBigData() {
        return SQLoader.INSTANCE_BIGDATA;
    }

}
