package models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = new User(1, "John Doe", "Admin", "johndoe", "password");
    }

    @Test
    public void testGetId() {
        assertEquals(1, user.getId());
    }

    @Test
    public void testSetId() {
        user.setId(2);
        assertEquals(2, user.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", user.getName());
    }

    @Test
    public void testSetName() {
        user.setName("Jane Smith");
        assertEquals("Jane Smith", user.getName());
    }

    @Test
    public void testGetType() {
        assertEquals("Admin", user.getType());
    }

    @Test
    public void testSetType() {
        user.setType("User");
        assertEquals("User", user.getType());
    }

    @Test
    public void testGetUser() {
        assertEquals("johndoe", user.getUser());
    }

    @Test
    public void testSetUser() {
        user.setUser("janedoe");
        assertEquals("janedoe", user.getUser());
    }

    @Test
    public void testGetPass() {
        assertEquals("password", user.getPass());
    }

    @Test
    public void testSetPass() {
        user.setPass("newpassword");
        assertEquals("newpassword", user.getPass());
    }


}
