package db;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class DBTest {

    @Test
    public void testGetConexion() throws Exception {
        // Mock the dependencies
        String expectedDriver = "com.mysql.jdbc.Driver";
        String expectedUrl = "URL";
        String expectedUser = "USER";
        String expectedPassword = "PASS";

        // Mock the Config class
        Config configMock = Mockito.mock(Config.class);
        Mockito.when(configMock.db_driver).thenReturn(expectedDriver);
        Mockito.when(configMock.db_url).thenReturn(expectedUrl);
        Mockito.when(configMock.db_user).thenReturn(expectedUser);
        Mockito.when(configMock.db_pass).thenReturn(expectedPassword);

        // Mock the DriverManager class
        Connection connectionMock = Mockito.mock(Connection.class);
        Mockito.when(DriverManager.getConnection(expectedUrl, expectedUser, expectedPassword))
                .thenReturn(connectionMock);

        // Set the mock Config values
        Config.db_driver = expectedDriver;
        Config.db_url = expectedUrl;
        Config.db_user = expectedUser;
        Config.db_pass = expectedPassword;

        // Call the method under test
        Connection actualConnection = DB.getConexion();

        // Verify the connection is obtained
        Assert.assertEquals(connectionMock, actualConnection);
    }
}
