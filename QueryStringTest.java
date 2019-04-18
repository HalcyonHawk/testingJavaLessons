
import static org.junit.Assert.*;
import org.junit.Test;

public class QueryStringTest {
    QueryString name = new QueryString("name=Alice&age=19&country=UK");
    QueryString message = new QueryString("message=Hello%2C+world%21");
    
    @Test
    public void testGetParameter(){
        //gives value after = 
        assertEquals("Alice", name.getParameter("name"));
        assertEquals("19", name.getParameter("age"));
        assertEquals("UK", name.getParameter("country"));
         //null with any string that isnt in the string tested
        assertEquals(null, name.getParameter("")); 
        //uses decoded version of message 
        assertEquals("Hello, world!", message.getParameter("message"));
    }
    
    @Test
    public void testHasParameter(){
        //checks if a string is in the string tested
        assertTrue(name.hasParameter("name"));
         //returns false with any string that isnt in the string tested
        assertFalse(name.hasParameter(""));
    }
    
    @Test
    public void testGetParameterOffset(){
        //test parameter at start is 0
        assertEquals(0, name.getParameterOffset("name"));
        //correct amount of characters counted 
        assertEquals(11, name.getParameterOffset("age"));
        assertEquals(18, name.getParameterOffset("country"));
    }
    
    @Test
    public void testDecode(){
        //test each thing to be decoded 
        assertEquals(",", message.decode("%2C"));
        assertEquals("!", message.decode("%21"));
        assertEquals(" ", message.decode("+"));
    }
}
