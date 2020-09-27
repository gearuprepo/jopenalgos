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
        int retval = qs.qSortFirst(inpl,0,inpl.length-1);
        Arrays.sort(orig);
        Assert.assertArrayEquals(orig, inpl);

    }

}
