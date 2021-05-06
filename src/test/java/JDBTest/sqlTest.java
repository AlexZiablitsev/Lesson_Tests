package JDBTest;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import services.JdbcService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class sqlTest {
    Logger logger = Logger.getLogger(JdbcService.class);

    @Test
    public void connectionTest() throws SQLException {
        JdbcService jdbcService = new JdbcService();
        ResultSet resultSet = jdbcService.executeQuery("select * from Customers;");

        while (resultSet.next()){
            String id = resultSet.getString("id");
            String firstName = resultSet.getString("firstName");
            String lastName  = resultSet.getString(2);
            String email = resultSet.getString("email");
            int age = resultSet.getInt("age");
            logger.info("Result: id = " + id);
        }

        jdbcService.closeConnection();
    }
}
