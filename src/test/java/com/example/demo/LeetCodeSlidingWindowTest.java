package com.example.demo;

import org.junit.jupiter.api.Test;

public class LeetCodeSlidingWindowTest {
    private LeetCodeSlidingWindow leetCodeSlidingWindow = new LeetCodeSlidingWindow();

    @Test
    public void sanityFindMaxAverage() {
        System.out.println(leetCodeSlidingWindow.findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
    }

    @Test
    public void sanityContaineVowels() {
        System.out.println(leetCodeSlidingWindow.maxVowels("leetcode",3));
    }
}
