package by.russianzak.db.impl;

import by.russianzak.db.ConnectionManager;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManagerImpl implements ConnectionManager {

  private final HikariDataSource dataSource;

  public ConnectionManagerImpl(String jdbcUrl, String username, String password) {
    if (jdbcUrl == null || jdbcUrl.isEmpty()) {
      throw new IllegalArgumentException("JDBC URL cannot be null or empty");
    }
    if (username == null || username.isEmpty()) {
      throw new IllegalArgumentException("Username cannot be null or empty");
    }
    if (password == null || password.isEmpty()) {
      throw new IllegalArgumentException("Password cannot be null or empty");
    }

    final HikariConfig config = new HikariConfig();
    config.setJdbcUrl(jdbcUrl);
    config.setUsername(username);
    config.setPassword(password);
    dataSource = new HikariDataSource(config);
  }
  public ConnectionManagerImpl() {
    final HikariConfig config = new HikariConfig();
    ClassLoader classLoader = getClass().getClassLoader();
    try (InputStream input = classLoader.getResourceAsStream("db.properties")) {
      if (input == null) {
        throw new IllegalArgumentException("Unable to find db.properties");
      }
      Properties properties = new Properties();
      properties.load(input);

      config.setDataSourceClassName(properties.getProperty("dataSourceClassName"));
      config.addDataSourceProperty("databaseName", properties.getProperty("dataSource.databaseName"));
      config.addDataSourceProperty("portNumber", properties.getProperty("dataSource.portNumber"));
      config.addDataSourceProperty("serverName", properties.getProperty("dataSource.serverName"));
      config.setUsername(properties.getProperty("dataSource.user"));
      config.setPassword(properties.getProperty("dataSource.password"));

      dataSource = new HikariDataSource(config);
    } catch (IOException e) {
      throw new RuntimeException("Error loading db.properties", e);
    }
  }


  public HikariDataSource getDataSource() {
    return dataSource;
  }

  @Override
  public Connection getConnection() throws SQLException {
    return dataSource.getConnection();
  }
}
