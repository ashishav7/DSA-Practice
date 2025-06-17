package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlidingWindowMain {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,5,1,0,13,19,18);
        int k=3;   //windowSize
        System.out.println(maxSumSubArray(list,k));

    }
    private static long maxSumSubArray(List<Integer> list, int k) {
        long sum =0;
        long maxSum=Integer.MIN_VALUE;
        int l=0;
        int r=0;
        while(r<list.size()){
            if(r-l+1==k){
                sum+=list.get(r);
                if(sum>maxSum){
                    maxSum=sum;
                }
                sum-=list.get(l);
                l++;
            }else{
                sum+=list.get(r);
            }
            r++;
        }
        return maxSum;
    }
}
