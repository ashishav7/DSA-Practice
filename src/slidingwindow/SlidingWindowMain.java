package slidingwindow;

import java.util.*;

public class SlidingWindowMain {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-10,5,1,0,-13,19,18);
        int k=3;   //windowSize
        System.out.println(maxSumSubArray(list,k));
        System.out.println(firstNegativeNumberInEveryWindowOfSizeK(list,k));
        System.out.println(countOccurrencesOfAnagrams("baaabacdasdaaaba","ab"));
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

    //LeetCode Medium 438
    private static long countOccurrencesOfAnagrams(String s,String ana){
        int ans=0;
        int l=0;
        int r=0;
        Map<Character,Integer> freqMap = new HashMap<>();
        int k=ana.length();
        while(r<k){
            freqMap.put(ana.charAt(r),freqMap.getOrDefault(ana.charAt(r),0)+1);
            r++;
        }
        r=0;
        Map<Character,Integer> windowMap = new HashMap<>();

        while(r<s.length()){
            windowMap.put(s.charAt(r),windowMap.getOrDefault(s.charAt(r),0)+1);
            if(r-l+1==k){
                if(freqMap.size()==windowMap.size() &&freqMap.equals(windowMap)){
                    ans++;
                }
                if(windowMap.get(s.charAt(l))==1){
                    windowMap.remove(s.charAt(l));
                }else {
                    windowMap.put(s.charAt(l), windowMap.get(s.charAt(l)) - 1);
                }
                l++;
            }

            r++;
        }
        return ans;
    }
}
