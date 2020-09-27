package org.sort.qsort;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QSort {

    public int[] qSort(int[] input, int min, int max){
        int pivot = input[min];
        int i = min,iter = min+1;

        if(max-min <= 1){
            return null;
        }
        for (;iter<max;iter++){
            int elem = input[iter];
            if(elem  < pivot){
                if ((iter - i)>1){
                    int temp = input[i+1];
                    input[i+1]=input[iter];
                    input[iter]=temp;
                }
                i++;
            }
        }
        input[min] = input[i];
        input[i] = pivot;
        if((i-1)-min > 1) qSort(input,min,i-1);
        if(max - (i+1) >1) qSort(input,i+1, max);
        return null;
    }
    public static void main(String[] args) throws IOException {
        QSort qs = new QSort();
        //int[] inpl = {5,3,6,7,2,8};
        String filename = "./files/QuickSort.txt";
        Charset charset = Charset.forName("ISO-8859-1");
        List<String> result = Files.readAllLines(Paths.get(filename), charset);
        int[] inpl = result.stream().mapToInt(Integer::parseInt).toArray();
        qs.qSort(inpl,0,inpl.length);
        Arrays.stream(inpl).asLongStream().forEach(System.out::println);
       // Arrays.sort(inpl);
       // Arrays.stream(inpl).asLongStream().forEach(System.out::println);

        return;
    }
}
