package com.example.demo;

import org.junit.jupiter.api.Test;

public class NeetCodeSolutionsBacktrackTest {
    private NeetCodeSolutionsBacktrack neetCodeSolutionsBacktrack = new NeetCodeSolutionsBacktrack();

    @Test
    public void sanitycombinationSum() {
        System.out.println(neetCodeSolutionsBacktrack.combinationSum(new int[]{8,7,4,3},11));
    }

    @Test
    public void sanityPermute() {
        System.out.println(neetCodeSolutionsBacktrack.permute(new int[]{1,2,3}));
    }

    @Test
    public void sanitySubset() {
        System.out.println(neetCodeSolutionsBacktrack.subsetsWithDup(new int[]{1,2,1}));
    }
}
