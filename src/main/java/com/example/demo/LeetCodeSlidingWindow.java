package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCodeSlidingWindow {

    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        for(int i=0;i<k;i++) {
            sum+=nums[i];
        }
        double maxAvg = sum/k;
        if(k==nums.length) {
            return maxAvg;
        }
        for(int i=k; i<nums.length;i++) {
            sum+= nums[i]-nums[i-k];
            double avg = sum/k;
            if(avg>maxAvg) {
                maxAvg=avg;
            }
        }
        return maxAvg;
    }

    public int maxVowels(String s, int k) {
        int maxCount=0;
        for(int i=0;i<k;i++) {
            if(containeVowels(s.charAt(i))) {
                maxCount++;
            }
        }
        if(k == s.length()) {
            return maxCount;
        }
        int prevCount=maxCount;
        for(int i=k; i<s.length();i++) {
            if(containeVowels(s.charAt(i-k))) {
                prevCount--;
            }
            if(containeVowels(s.charAt(i))) {
                prevCount++;
            }
            if(prevCount > maxCount) {
                maxCount = prevCount;
            }
        }
        return maxCount;
    }

    private boolean containeVowels(char c) {
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }

    public int longestOnes(int[] nums, int k) {
        int start=0;
        int zeroes=0;
        int end=0;
        int maxLength=0;
        for(end=0;end<nums.length;end++) {
            if(nums[end]==0) {
                zeroes++;
            }
            while(zeroes > k) {
                if(nums[start] == 0) {
                    zeroes--;
                }
                start++;
            }
            maxLength = Math.max(maxLength,end-start+1);
        }
        return maxLength;
    }

    public int longestSubarray(int[] nums) {
        int zeroes=0;
        int start=0;
        int longestWindow=0;

        for(int i=0; i<nums.length;i++) {
            if(nums[i] == 0) {
                zeroes++;
            }
            while(zeroes > 1) {
                if(nums[start]==0) {
                    zeroes--;
                }
                start++;
            }
            longestWindow=Math.max(longestWindow,i-start);
        }
        return longestWindow;
    }
}
