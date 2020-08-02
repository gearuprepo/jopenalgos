package org.dnc;

import java.util.Arrays;

public class MaxSubArr {
    public static void main(String[] args) {
        MaxSubArr msa = new MaxSubArr();
        //int[] inp = {-2,1,-3,4,-1,2,1,-5,4};
        //int[] inp = {31,-41,59,26,-53,58,97,-93,-23,84};
        //int[] inp = {-2,1};
        //int[] inp = {-2,-1};
        int[] inp = {-1,-2};
        System.out.println(msa.maxSubArray(inp));
    }
    public int maxSubArray(int[] nums) {
        int approved = nums[0];
        int preapproved = nums[0];
        for (int i=1;i<nums.length;i++){
             preapproved += nums[i];
             if(nums[i]>preapproved){
                approved = (nums[i]>approved)?nums[i]:approved;
                preapproved = nums[i];
             }else{
                 if(preapproved>approved){
                     approved = preapproved;
                 }
             }
        }
        return approved;
    }


    public int maxSubArrayWrong(int[] nums) {
        int minind=0,ctr=0,sum=0;
        if(nums.length==1){
            return nums[0];
        }
        for(int num:nums){
            if(num<nums[minind]){
                minind=ctr;
            }
            ctr++;
            sum+=num;
        }
        int[] left = Arrays.copyOfRange(nums, 0, minind);
        int[] right = Arrays.copyOfRange(nums, minind+1,nums.length);
        int retl = (left.length>0)?maxSubArray(left):Integer.MIN_VALUE;
        int retr = (right.length>0)?maxSubArray(right):Integer.MIN_VALUE;
        int retcmp = (retl>retr)?retl:retr;
        int ret = (sum>retcmp)?sum:retcmp;
        return ret;
        }
    
}