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

    public int qSortFirst(int[] input, int start, int end){
        int pivot = input[start];
        int pivotmarker = start;
        for(int i = start+1;i<=end;i++){
            if(input[i]<pivot) {
                int temp = input[i];
                input[i] = input[pivotmarker + 1];
                input[pivotmarker + 1] = temp;
                pivotmarker++;
            }
        }
        int temp = input[pivotmarker];
        input[pivotmarker] = pivot;
        input[start] = temp;

        if((pivotmarker-1)> start) qSortFirst(input,start, pivotmarker-1);
        if(end> (pivotmarker+1)) qSortFirst(input,pivotmarker+1,end);

    return 0;
    }


    public static void main(String[] args) throws IOException {
        QSort qs = new QSort();
        //int[] inpl = {5,3,6,7,2,8,12,44,1,0,500,43,1234,523,65,77,95,234,656};
        String filename = "./files/QuickSort.txt";
        Charset charset = Charset.forName("ISO-8859-1");
        List<String> result = Files.readAllLines(Paths.get(filename), charset);
        int[] inpl = result.stream().mapToInt(Integer::parseInt).toArray();
        qs.qSortFirst(inpl,0,inpl.length-1);
        Arrays.stream(inpl).asLongStream().forEach(System.out::println);
       // Arrays.sort(inpl);
       // Arrays.stream(inpl).asLongStream().forEach(System.out::println);

        return;
    }
}
