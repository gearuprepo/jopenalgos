package org;

import static org.junit.Assert.assertTrue;
import org.math.Multiply;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class MultiplyTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testNaiveImpl()
    {
        assertTrue( Multiply.naivemultiply("55", "34") == (55*34) );
        assertTrue( Multiply.naivemultiply("554", "3") == (554*3) );
        assertTrue( Multiply.naivemultiply("552", "344") == (552*344) );
        assertTrue( Multiply.naivemultiply("1", "1") == (1*1) );
    }
}
