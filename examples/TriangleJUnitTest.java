import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleJUnitTest {

    @Test
    public void testInvalidTriangle() {
        Triangle obj = new Triangle();
        assertEquals(4, obj.classify(-1, 1, 1));
        assertEquals(4, obj.classify(1, 2, 3));
        assertEquals(4, obj.classify(-5, -5, -5));
    }
}
