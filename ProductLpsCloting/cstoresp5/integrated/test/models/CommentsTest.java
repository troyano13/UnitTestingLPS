package models;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CommentsTest {

    private Comment comment;

    @Before
    public void setUp() {
        comment = new Comment(1, "Test description", "2023-08-12");
    }

    @Test
    public void testGetId() {
        comment.setId(123);
        assertEquals(123, comment.getId());
    }

    @Test
    public void testGetProduct() {
        assertEquals(1, comment.getProduct());
    }

    @Test
    public void testSetProduct() {
        comment.setProduct(456);
        assertEquals(456, comment.getProduct());
    }

    @Test
    public void testGetDescription() {
        assertEquals("Test description", comment.getDescription());
    }

    @Test
    public void testSetDescription() {
        comment.setDescription("Updated description");
        assertEquals("Updated description", comment.getDescription());
    }

    @Test
    public void testGetDate() {
        assertEquals("2023-08-12", comment.getDate());
    }

    @Test
    public void testSetDate() {
        comment.setDate("2023-08-13");
        assertEquals("2023-08-13", comment.getDate());
    }


}
