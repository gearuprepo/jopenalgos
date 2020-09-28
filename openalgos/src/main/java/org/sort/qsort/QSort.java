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

    public int qSortFirst(int[] input, int start, int end, String flag){
        int retCount = end - start;
        int pivot;
        if(flag!=null && flag.equals("End")){
            swap(input,start, end);
        }if(flag!=null && flag.equals("Med")){
            middleOfThree(input,start,end);
        }
        pivot = input[start];
        int pivotmarker = start;
        for(int i = start+1;i<=end;i++){
            if(input[i]<pivot) {
                /*int temp = input[i];
                input[i] = input[pivotmarker + 1];
                input[pivotmarker + 1] = temp;*
                 */
                swap(input,i,pivotmarker+1);
                pivotmarker++;
            }
        }
        /*int temp = input[pivotmarker];
        input[pivotmarker] = pivot;
        input[start] = temp;*/
        swap(input,pivotmarker,start);
        if((pivotmarker-1)> start) retCount+=qSortFirst(input,start, pivotmarker-1,flag);
        if(end> (pivotmarker+1)) retCount+=qSortFirst(input,pivotmarker+1,end,flag);

    return retCount;
    }

    public void swap(int[] input, int i,int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    public  int middleOfThree(int[] input, int start, int end) {
     int diff = end - start + 1;
     int mid = start + ((diff%2 == 0)?(diff/2)-1:diff/2);
     int f = input[start];
     int l = input[end];
     int m = input[mid];
    // if(diff>2){
         if((m>f && m<l)  || (m>l && m<f)){
             swap(input, start, mid);
         }else if((l>f && l<m) || (l>m && l<f)){
             //l is mid
             swap(input,start,end);
         }
    // }
     return 0;

    }
    public static void main(String[] args) throws IOException {
        QSort qs = new QSort();
        //int[] inpl = {5,3,6,7,2,8,12,44,1,0,500,43,1234,523,65,77,95,234,656};
        String filename = "./files/QuickSort.txt";
        Charset charset = Charset.forName("ISO-8859-1");
        List<String> result = Files.readAllLines(Paths.get(filename), charset);
        int[] inpl = result.stream().mapToInt(Integer::parseInt).toArray();
        int retval = qs.qSortFirst(inpl,0,inpl.length-1,null);
        Arrays.stream(inpl).asLongStream().forEach(System.out::println);
       // Arrays.sort(inpl);
       // Arrays.stream(inpl).asLongStream().forEach(System.out::println);

        return;
    }
}
