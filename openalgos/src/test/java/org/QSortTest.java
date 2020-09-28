package org;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sort.qsort.QSort;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class QSortTest {
    int[] inpl = null;

    @Before
    public void load() throws IOException {
        String filename = "./files/QuickSort.txt";
        Charset charset = Charset.forName("ISO-8859-1");
        List<String> result = Files.readAllLines(Paths.get(filename), charset);
         inpl = result.stream().mapToInt(Integer::parseInt).toArray();
    }

    @Test
    public void testFirst(){
        QSort qs = new QSort();
        int orig[] = Arrays.copyOf(inpl,inpl.length);
        int retval = qs.qSortFirst(inpl,0,inpl.length-1,null);
        Arrays.sort(orig);
        System.out.println("First >> "+retval);
        Assert.assertArrayEquals(orig, inpl);

    }

    @Test
    public void testLast(){
        QSort qs = new QSort();
        int orig[] = Arrays.copyOf(inpl,inpl.length);
        int retval = qs.qSortFirst(inpl,0,inpl.length-1,"End");
        Arrays.sort(orig);
        System.out.println("End >> "+retval);
        Assert.assertArrayEquals(orig, inpl);

    }
    @Test
    public void testMed(){
        QSort qs = new QSort();
        int orig[] = Arrays.copyOf(inpl,inpl.length);
        int retval = qs.qSortFirst(inpl,0,inpl.length-1,"Med");
        Arrays.sort(orig);
        System.out.println("Med >> "+retval);
        Assert.assertArrayEquals(orig, inpl);

    }

    @Test
    public void dummytest(){
        QSort qs = new QSort();
        int inpl1[] =  {2, 20, 1, 15, 3, 11, 13, 6, 16, 10, 19, 5, 4, 9, 8, 14, 18, 17, 7, 12};
        int orig[] =  {2, 20, 1, 15, 3, 11, 13, 6, 16, 10, 19, 5, 4, 9, 8, 14, 18, 17, 7, 12};
        int retval = qs.qSortFirst(inpl1,0,inpl1.length-1,"Med");
        Arrays.sort(orig);
        System.out.println("Med >> "+retval);
        Assert.assertArrayEquals(orig, inpl1);

    }

}
