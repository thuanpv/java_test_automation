import java.util.*;
import static org.junit.Assert.*;
import static org.junit.Assume.*;

import org.junit.runner.RunWith;
import com.pholser.junit.quickcheck.*;
import com.pholser.junit.quickcheck.generator.*;
import edu.berkeley.cs.jqf.fuzz.*;

@RunWith(JQF.class)
public class TriangleJQFTest {

    @Fuzz
    public void testInvalidTriangle(int a, int b, int c) {
        assumeTrue(a <= 0 || b <= 0 || c <= 0);
        Triangle obj = new Triangle();
        System.out.printf("\nGenerated lengths: a=%d, b=%d, c=%d\n", a, b, c);
        assertTrue("Invalid triangle", obj.classify(a, b, c) == 4);
    }
}
