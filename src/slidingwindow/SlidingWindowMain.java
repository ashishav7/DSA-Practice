package slidingwindow;

import java.util.*;

public class SlidingWindowMain {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-10,5,1,0,-13,19,18);
        int k=3;   //windowSize
        System.out.println(maxSumSubArray(list,k));
        System.out.println(firstNegativeNumberInEveryWindowOfSizeK(list,k));
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
    private static List<Integer> firstNegativeNumberInEveryWindowOfSizeK(List<Integer> list, int k){
        int l=0;
        int r=0;
        List<Integer> possibleAnswerList = new ArrayList<>();
        List<Integer> answerList = new ArrayList<>();
        while(r<list.size()){
            int element=list.get(r);
            if(element<0){
                possibleAnswerList.add(element);
            }
            if(r-l+1==k){
                if(possibleAnswerList.isEmpty()){
                    answerList.add(0);
                }else{
                    answerList.add(possibleAnswerList.getFirst());
                }
                if(list.get(l)<0){
                    possibleAnswerList.removeFirst();
                }
                l++;
            }
            r++;
        }
        return answerList;
    }
}
