package pl.lodz.p.it.isdp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcDerbyConnection {
    static void connect() {
        try {
            String dbURL3 = "jdbc:derby://localhost:1527/xd";
            Properties properties = new Properties();
            properties.put("create", "true");
            Connection conn3 = DriverManager.getConnection(dbURL3,properties);
            if (conn3 != null) {
                System.out.println("Connected to database #3");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
