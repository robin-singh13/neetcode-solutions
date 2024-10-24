package com.example.demo;

import java.util.*;
import java.util.stream.Collectors;

public class NeetCodeSolutionTwoPointers {
    public int[] twoSum(int[] numbers, int target) {
        int firstPointer=0;
        int secondPointer=1;
        while(firstPointer<numbers.length) {
            while(secondPointer<numbers.length) {
                if(numbers[firstPointer]+numbers[secondPointer]==target) {
                    return new int[]{numbers[firstPointer], numbers[secondPointer]};
                }
                else if(numbers[firstPointer]+numbers[secondPointer] > target) {
                    break;
                }
                else secondPointer++;
            }
            firstPointer++;
            secondPointer=firstPointer+1;
        }
        return new int[2];
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
            }
        }
        return res;
    }

    public void moveZeroes(int[] nums) {
        int currIndex=-1;
        boolean isFirstZero=true;

        for(int i=0; i< nums.length; i++) {
            if(nums[i]==0 && isFirstZero) {
                currIndex=i;
                isFirstZero=false;
            }
            else if(nums[i]!=0 && currIndex>-1) {
                nums[currIndex]=nums[i];
                currIndex++;
            }
        }
        if(currIndex > 0) {
            for (int i = currIndex; i < nums.length; i++) {
                nums[i] = 0;
            }
        }

    }

    public boolean isSubsequence(String s, String t) {
        if(s.length()==0) {
            return true;
        }
        int sIndex=0;
        for(int i=0;i<t.length() && sIndex<s.length();i++) {
            if(t.charAt(i) == s.charAt(sIndex)) {
                sIndex++;
            }
        }
        return sIndex==s.length();
    }

    public int maxArea(int[] height) {
        int left=0;
        int right= height.length-1;
        int maxArea=0;
        while(left<right) {
            int length = height[left]<height[right]? height[left] : height[right];
            int area = length*(right-left);
            if(area > maxArea) {
                maxArea = area;
            }
            if(height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left=0;
        int right= nums.length-1;
        int count=0;

        while(left<right) {
            if(nums[left]+nums[right] == k) {
                left++;
                right--;
                count++;
            }
            else if(nums[left] + nums[right] > k) {
                right--;
            } else {
                left++;
            }
        }
        return count;
    }

    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int left = 0;
        int right= s.length()-1;
        String vowels = "aAeEiIoOuU";
        while(left<right) {
            if(vowels.indexOf(str[left])!=-1 && vowels.indexOf(str[right])!=-1) {
                char temp =  str[left];
                str[left]=str[right];
                str[right]=temp;
                left++;
                right--;
            }
            else if(vowels.indexOf(str[left])!=-1) {
                right--;
            }
            else {
                left++;
            }
        }
        return new String(str);
    }
}
