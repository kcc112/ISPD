package pl.lodz.p.it.isdp;

import java.sql.*;
import java.util.Properties;
import javax.sql.rowset.serial.SerialClob;

public class JdbcDerbyConnection {
    static void connect() {
        String connectionStrings = "jdbc:derby://localhost:1527/test1";
        Properties properties = new Properties();
        properties.put("user", "admin");
        properties.put("password", "123");

        String sql = "INSERT INTO array (Array) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(connectionStrings, properties);
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            Clob clob = new SerialClob("Kamil".toCharArray());
            preparedStatement.setClob(1, clob);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
