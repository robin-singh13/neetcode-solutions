package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class NeetCodeSolutionsArrayTest {
    NeetCodeSolutionsArray neetCodeSolutionsArray = new NeetCodeSolutionsArray();

    @Test
    public void sanityTestcode() {

        List<String> strings = Arrays.asList("act","pots","tops","cat","stop","hat");
        
        System.out.println(neetCodeSolutionsArray.groupAnagrams((String[]) strings.toArray()));

    }

    @Test
    public void sanityTopKFrequent() {
         int[] nums = {1,2,2,3,3,3};
        System.out.println(Arrays.toString(neetCodeSolutionsArray.topKFrequent(nums,2)));
    }

    @Test
    public void sanityTestDecodeEncode() {
        List<String> strings = Arrays.asList();
        System.out.println(neetCodeSolutionsArray.decode(neetCodeSolutionsArray.encode(strings)));
    }

    @Test
    public void sanityArrayProductExceptItself() {
        int [] nums = {0,8,0};
        System.out.println(Arrays.toString(neetCodeSolutionsArray.productExceptSelf(nums)));
    }

    @Test
    public void sanitySudokuArray() {
        char[][] board =
                {{'.','.','4','.','.','.','6','3','.'},
                 {'.','.','.','.','.','.','.','.','.'},
                 {'5','.','.','.','.','.','.','9','.'},
                 {'.','.','.','5','6','.','.','.','.'},
                 {'4','.','3','.','.','.','.','.','1'},
                 {'.','.','.','7','.','.','.','.','.'},
                 {'.','.','.','5','.','.','.','.','.'},
                 {'.','.','.','.','.','.','.','.','.'},
                 {'.','.','.','.','.','.','.','.','.'}};
        System.out.println(neetCodeSolutionsArray.isValidSudoku(board));
    }

    @Test
    public void sanityLongestConsecutive() {
        int [] nums = {2,20,4,10,3,4,5};
        System.out.println(neetCodeSolutionsArray.longestConsecutive(nums));
    }

    @Test
    public void sanityStringGCD() {
        System.out.println(neetCodeSolutionsArray.gcdOfStrings("ABCABCABC","ABCABC"));
    }

    @Test
    public void sanityCompress() {
        char[] input = new char[]{'a','a','b','b','c','c','c'};
        System.out.println(neetCodeSolutionsArray.compress(input));
        System.out.println(input);
    }
}