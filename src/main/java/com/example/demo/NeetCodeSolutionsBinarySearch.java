package com.example.demo;

import java.util.Arrays;
import java.util.Collections;

public class NeetCodeSolutionsBinarySearch {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0; i<m;i++) {
            //Check for desired row
            if(matrix[i][n-1] >= target && matrix[i][0]<=target) {

                return doBinarySearch(matrix[i],0,n,target);
            }
        }
        return false;
    }

    public boolean doBinarySearch(int[] matrix, int lowerIndex, int upperIndex, int target) {

        if(upperIndex==0 || lowerIndex==matrix.length || upperIndex==lowerIndex) {
            return false;
        }
        if(matrix[(lowerIndex+upperIndex)/2] < target) {
            return doBinarySearch(matrix,(lowerIndex+upperIndex)/2+1,upperIndex,target);
        }
        else if (matrix[(lowerIndex+upperIndex)/2] > target){
            return doBinarySearch(matrix,lowerIndex,(lowerIndex+upperIndex)/2,target);
        }
        else if(matrix[(lowerIndex+upperIndex)/2] == target){
            return true;
        }
        return false;

    }

    public int minEatingSpeed(int[] piles, int h) {

        int minValue=1;
        int maxValue=Arrays.stream(piles).max().getAsInt();
        int result=-1;
        int minDiff=h;

        while(maxValue>=minValue) {
            int currentNumber = (minValue+maxValue)/2;
            //int[] newPiles = Arrays.copyOf(piles,piles.length);
            int i=0;
            int steps=0;
            while(i<piles.length) {
                steps+= Math.ceil((double) piles[i]/currentNumber);
                i++;
            }
            if(steps<=h && (h-steps)<minDiff) {
                minDiff=h-steps;
                result=currentNumber;
                maxValue = (minValue+maxValue)/2-1;
            } else  {
                minValue = (minValue+maxValue)/2+1;
            }
        }
        return result;
    }

    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int min=Integer.MAX_VALUE;
        while(right>=left) {
            int middle=(right+left)/2;
            if(nums[middle]<=nums[right]) {
                min=Math.min(nums[middle],min);
                right=(right+left)/2-1;
            }
            else if(nums[left]<=nums[middle]) {
                left=(right+left)/2+1;
            }

        }
        return min;
    }

    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(right>=left) {
            int middle=(right+left)/2;
            if(nums[middle]==target) {
                return middle;
            }
            if(nums[left] <= nums[middle]) {
                if(target > nums[middle] || target < nums[left]) {
                    left=middle+1;
                } else {
                    right = middle-1;
                }
            } else {
                if(target < nums[middle] || target > nums[right])
                {
                    right = middle-1;
                } else {
                    left = middle + 1;
                }
            }
        }
        return -1;
    }
}
