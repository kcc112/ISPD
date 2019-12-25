package pl.lodz.p.it.isdp;

import java.sql.*;
import java.util.Arrays;
import java.util.Properties;
import javax.sql.rowset.serial.SerialClob;

class JdbcDerbyConnection {
    static void saveArray(long[] tab) {
        String connectionStrings = "jdbc:derby://localhost:1527/" + System.getenv("DB_NAME");
        Properties properties = new Properties();
        properties.put("user", System.getenv("ADMIN"));
        properties.put("password", System.getenv("PASSWORD"));

        String sql = "INSERT INTO array (Array) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(connectionStrings, properties);
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            Clob clob = new SerialClob(Arrays.toString(tab).toCharArray());
            preparedStatement.setClob(1, clob);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
