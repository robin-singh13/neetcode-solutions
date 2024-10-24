package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class NeetCodeSolutionsTwoPointersTest {

    private NeetCodeSolutionTwoPointers neetCodeSolutionTwoPointers = new NeetCodeSolutionTwoPointers();

    @Test
    public void sanityTwoSum() {
        int[] numbers = {1,2,3,4};
        int target=3;

        System.out.println(Arrays.toString(neetCodeSolutionTwoPointers.twoSum(numbers,target)));
    }

    @Test
    public void sanityThreeSum() {
        int[] nums = {0,0,0,0};
        System.out.println(neetCodeSolutionTwoPointers.threeSum(nums));
    }

    @Test
    public void sanityMoveZeroes() {
        int[] nums = {1};
        neetCodeSolutionTwoPointers.moveZeroes(nums);
        System.out.println(nums);
    }

    @Test
    public void sanityIsSubsequence() {
        System.out.println(neetCodeSolutionTwoPointers.isSubsequence("b","abc"));
    }

    @Test
    public void sanityMaxArea() {
        System.out.println(neetCodeSolutionTwoPointers.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    @Test
    public void sanityMaxOperations() {
        System.out.println(neetCodeSolutionTwoPointers.maxOperations(new int[]{1,2,3,4},5));
    }

    @Test
    public void swapVowels(){
        System.out.println(neetCodeSolutionTwoPointers.reverseVowels("leetcode"));
    }
}
