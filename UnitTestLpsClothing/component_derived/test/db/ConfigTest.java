package test;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ConfigTest {

    @Test
    public void testConfigValues() {
        // Mock the values
        String expectedDriver = "com.mysql.jdbc.Driver";
        String expectedUrl = "URL";
        String expectedUser = "USER";
        String expectedPass = "PASS";

        // Verify the values
        Assert.assertEquals(expectedDriver, Config.db_driver);
        Assert.assertEquals(expectedUrl, Config.db_url);
        Assert.assertEquals(expectedUser, Config.db_user);
        Assert.assertEquals(expectedPass, Config.db_pass);
    }
}
