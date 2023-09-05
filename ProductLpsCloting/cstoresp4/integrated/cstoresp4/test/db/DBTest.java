package db;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class DBTest {

    @Test
    public void testGetConexion() throws Exception {
        
        String expectedDriver = "com.mysql.jdbc.Driver";
        String expectedUrl = "URL";
        String expectedUser = "USER";
        String expectedPassword = "PASS";

       
        Config configMock = Mockito.mock(Config.class);
        Mockito.when(configMock.db_driver).thenReturn(expectedDriver);
        Mockito.when(configMock.db_url).thenReturn(expectedUrl);
        Mockito.when(configMock.db_user).thenReturn(expectedUser);
        Mockito.when(configMock.db_pass).thenReturn(expectedPassword);

        
        Connection connectionMock = Mockito.mock(Connection.class);
        Mockito.when(DriverManager.getConnection(expectedUrl, expectedUser, expectedPassword))
                .thenReturn(connectionMock);

        
        Config.db_driver = expectedDriver;
        Config.db_url = expectedUrl;
        Config.db_user = expectedUser;
        Config.db_pass = expectedPassword;

        
        Connection actualConnection = DB.getConexion();

        
        Assert.assertEquals(connectionMock, actualConnection);
    }
}
