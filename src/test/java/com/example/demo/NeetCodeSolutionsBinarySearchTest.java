package com.example.demo;

import org.junit.jupiter.api.Test;

public class NeetCodeSolutionsBinarySearchTest {

    NeetCodeSolutionsBinarySearch neetCodeSolutionsBinarySearch = new NeetCodeSolutionsBinarySearch();

    @Test
    public void sanitySearchMatrix() {
        int[][] matrix = {{1,2,4,8},{10,11,12,13},{14,20,30,40}};

        //System.out.println(neetCodeSolutionsBinarySearch.searchMatrix(matrix,10));
        System.out.println(neetCodeSolutionsBinarySearch.searchMatrix(new int[][]{{1}},1));
        System.out.println(neetCodeSolutionsBinarySearch.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},3));
        /*System.out.println(neetCodeSolutionsBinarySearch.doBinarySearch(new int[]{14,20,30,40},0,4,31));
        System.out.println(neetCodeSolutionsBinarySearch.doBinarySearch(new int[]{14,20,30,40},0,4,30));
        System.out.println(neetCodeSolutionsBinarySearch.doBinarySearch(new int[]{14,20,30,40},0,4,40));
        System.out.println(neetCodeSolutionsBinarySearch.doBinarySearch(new int[]{14,20,30,40},0,4,14));
        System.out.println(neetCodeSolutionsBinarySearch.doBinarySearch(new int[]{14,20,30,40,60},0,5,20));
        System.out.println(neetCodeSolutionsBinarySearch.doBinarySearch(new int[]{14,20,30,40,60},0,5,60));
        System.out.println(neetCodeSolutionsBinarySearch.doBinarySearch(new int[]{14,20,30,40,60},0,5,13));
        System.out.println(neetCodeSolutionsBinarySearch.doBinarySearch(new int[]{14,20,30,40,60},0,5,61));*/


    }

    @Test
    public void sanityMinEatingSpeed() {
        assert neetCodeSolutionsBinarySearch.minEatingSpeed(new int[] {1,4,3,2},9) == 2;
        assert neetCodeSolutionsBinarySearch.minEatingSpeed(new int[] {25,10,23,4},4) == 25;
        assert neetCodeSolutionsBinarySearch.minEatingSpeed(new int[] {332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184},823855818) == 14;
    }

    @Test
    public void sanityFindMin() {
        assert neetCodeSolutionsBinarySearch.findMin(new int[] {4,5,0,1,2,3}) == 0;
        assert neetCodeSolutionsBinarySearch.findMin(new int[] {3,4,5,6,1,2}) == 1;
        assert neetCodeSolutionsBinarySearch.findMin(new int[] {4,5,6,7}) == 4;
    }

    @Test
    public void sanitySearch() {
        //assert neetCodeSolutionsBinarySearch.search(new int[]{3,4,5,6,1,2},1) == 4;
        //assert neetCodeSolutionsBinarySearch.search(new int[]{3,5,6,0,1,2},4) == -1;
        assert neetCodeSolutionsBinarySearch.search(new int[]{5,1,3},5) == 0;
        //assert neetCodeSolutionsBinarySearch.search(new int[]{3,1},3) == 0;
    }
}
