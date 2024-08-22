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
}
