
package models;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/*B-importTest-zone*/

public class UserDAOTest {

	@Mock
	private UserDAO userDAO;

	@Mock
	private Connection conn;

	@Mock
	private Statement statement;

	@Mock
	private ResultSet resultSet;

	@Before
	public void setUp() throws SQLException {
		userDAO = new UserDAO();
		MockitoAnnotations.openMocks(this);

		when(conn.createStatement()).thenReturn(statement);
		when(statement.executeQuery(anyString())).thenReturn(resultSet);

	}


	@Test
	public void testGetOneUserNotFound() throws Exception {

		when(resultSet.next()).thenReturn(false);

		User user = userDAO.getOneUser("nonexistent", "password");

		assertEquals(null, user);
	}

	/*B-methodTest-zone*/

}


