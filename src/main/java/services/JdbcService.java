package services;

import org.testng.log4testng.Logger;

import java.sql.*;

public class JdbcService {
    static Logger logger = Logger.getLogger(JdbcService.class);
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USERNAME = "postgres";
    static final String PSW = "1111";
    Connection connection = null;
    Statement statement = null;

    public JdbcService() {
        logger.info("Setup connection to Postgres DB");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("Postgres JDBC Driver is not found.");
            logger.error(e.getMessage());
            return;
        }

        try {
            DriverManager.getConnection(DB_URL, USERNAME, PSW);
        } catch (SQLException e) {
            logger.error("Connection is failed.");
            logger.error(e.getMessage());
            return;
        }

        if (connection != null) {
            logger.info("You successfully connected to db.");
        } else {
            logger.info("Failed to connect to db.");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        try {

            if (statement == null) {
                statement = connection.createStatement();
            }
        }catch (SQLException ex){
            logger.error("Не удалось сщздать statement");
            logger.error(ex.getMessage());
        }
        return statement;
    }

    public Connection closeConnection() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            logger.error("Could not close connection.");
            logger.error(throwables.getMessage());
        }
        return connection;
    }

    public void executeSQL(String sql){
        try {
            getStatement().execute(sql);
        }catch (SQLException ex){
            logger.error(ex.getMessage());
        }
    }

    public ResultSet executeQuery(String sql) {
        ResultSet resultSet = null;
        try {
            getStatement().execute(sql);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }return resultSet;
    }
}
