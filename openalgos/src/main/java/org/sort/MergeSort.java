package org.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

//TODO - Needs cleaning and commenting
public class MergeSort {
    public static void main(String[] args) {
        System.out.println("In Merge Sort");
        Integer[] arr = {4,3,2,1,5,43,23,0,44,7,88};
        MergeSort ms = new MergeSort();
        Stream.of(ms.mergeSort(arr)).forEach(System.out::println);
    }
    
    //Sort numbers, O(n) = nlogn
    public Integer[] sort(Integer[] input){
        if(input.length<=1){
            return input;
        }
        mergeSort(input);
        return null;
    } 
    public Integer[] mergeSort(Integer[] input){
        if(input.length == 1){
            return input;
        }
        if(input.length == 2){
            if(input[0]>input[1]){
                Integer temp = input[0];
                input[0] = input[1];
                input[1] = temp;
            }
            return input;
        }else{
            Integer[] left = Arrays.copyOfRange(input, 0, (input.length/2));
            Integer[] right = Arrays.copyOfRange(input,(input.length/2),input.length);
            Integer[] lsort = mergeSort(left);
            Integer[] rsort = mergeSort(right);
            Integer[] merged = merge(lsort,rsort);
            return merged;
        }

    }
    public Integer[] merge(Integer[] l1,Integer[] l2){
        int tot = l1.length + l2.length;
        int lctr =0,rctr =0;
        Integer[] ret = new Integer[tot];
        while(tot >0){
            if(rctr == l2.length ){
                ret[lctr+rctr] = l1[lctr];
                lctr++;

            }else if(lctr == l1.length){
                ret[lctr+rctr] = l2[rctr];
                rctr++;                
            }
            else if(l1[lctr]<l2[rctr]){
                ret[lctr+rctr] = l1[lctr];
                lctr++;
            }
            else if(l1[lctr]>l2[rctr]){
                ret[lctr+rctr] = l2[rctr];
                rctr++;
            }
            tot--;
        }
        return ret;
    }


}