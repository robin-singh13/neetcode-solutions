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
}
