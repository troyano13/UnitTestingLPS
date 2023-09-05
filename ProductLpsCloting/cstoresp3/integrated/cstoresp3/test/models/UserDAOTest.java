
package models;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

import db.DB;

/*B-importTest-zone*/

public class UserDAOTest {

    private UserDAO userDAO;
    private Connection conn;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;

    @Before
    public void setUp() {
        userDAO = new UserDAO();
        conn = mock(Connection.class);
        st = mock(Statement.class);
        ps = mock(PreparedStatement.class);
        rs = mock(ResultSet.class);

        DB.setTestConnection(conn);

        when(conn.createStatement()).thenReturn(st);
        when(conn.prepareStatement(anyString())).thenReturn(ps);
        when(st.executeQuery(anyString())).thenReturn(rs);
    }

    @Test
    public void testGetOneUser() throws Exception {
       
	   when(rs.next()).thenReturn(true);
        when(rs.getInt("id")).thenReturn(1);
        when(rs.getString("name")).thenReturn("John Doe");
        when(rs.getString("type")).thenReturn("admin");
        when(rs.getString("user")).thenReturn("johndoe");
        when(rs.getString("pass")).thenReturn("password");

        User user = userDAO.getOneUser("johndoe", "password");

        assertEquals(1, user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals("admin", user.getType());
        assertEquals("johndoe", user.getUsername());
        assertEquals("password", user.getPassword());
    }

    @Test
    public void testGetOneUserNotFound() throws Exception {

        when(rs.next()).thenReturn(false);

        User user = userDAO.getOneUser("nonexistent", "password");

        assertEquals(null, user);
    }

    /*B-methodTest-zone*/

}


