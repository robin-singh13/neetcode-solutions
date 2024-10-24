package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NeetCodeSolutionsBacktrack {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums,0,subset,output);
        return output;
    }

    private void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> output) {
        if(index>=nums.length) {
            output.add(subset);
            return;
        }
        subset.add(nums[index]);
        dfs(nums,index+1,subset,output);
        subset.remove(subset.size()-1);
        dfs(nums,index+1,subset,output);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfsCombinationSum(nums,0,subset,output,target);
        return output;
    }

    private void dfsCombinationSum(int[] nums, int i, List<Integer> subset, List<List<Integer>> output, int target) {
        if(i>=nums.length) {
            return;
        }

        int sum = subset.stream().mapToInt(Integer::intValue).sum();
        if(target == sum) {
            output.add(new ArrayList<>(subset));

        } else if (sum > target) {
            return;
        } else {
            subset.add(nums[i]);
            dfsCombinationSum(nums, i, subset, output, target);
            subset.remove(subset.size() - 1);
            dfsCombinationSum(nums, i + 1, subset, output, target);
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        if(nums.length==1) {
            List<Integer> singleNumber = new ArrayList<>();
            singleNumber.add(nums[0]);
            output.add(singleNumber);
            return output;
        }
        List<List<Integer>> permute =  permute(Arrays.copyOfRange(nums,1,nums.length));

        for(List<Integer> combination: permute) {
            for(int i=0; i<combination.size()+1;i++) {
                List<Integer> copyList = new ArrayList<>(combination);
                copyList.add(i,nums[0]);
                output.add(copyList);
            }

        }
        return output;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfsSubsetWithDuplicate(nums,subset,output,0);
        return output;
    }

    private void dfsSubsetWithDuplicate(int[] nums, List<Integer> subset, List<List<Integer>> output, int i) {
        if(i>=nums.length) {
            output.add(new ArrayList<>(subset));
            return;
        }


        subset.add(nums[i]);
        dfsSubsetWithDuplicate(nums,subset,output,i+1);
        subset.remove(subset.size()-1);
        while(i+1<nums.length && nums[i]==nums[i+1]) {
            i++;
        }
        dfsSubsetWithDuplicate(nums,subset,output,i+1);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> sublist = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        backTrackCombinationSum2(candidates,0,sublist,target,output);
        return output;
    }

    private void backTrackCombinationSum2(int[] candidates, int pos, List<Integer> sublist, int target, List<List<Integer>> output) {
        int sum = sublist.stream().mapToInt(Integer::intValue).sum();
        if(sum == target) {
            output.add(new ArrayList<>(sublist));
            return;
        }
        if(sum > target) {
            return;
        }
        int prev = -1;
        for(int i = pos; i<candidates.length; i++) {
            if(candidates[i] == prev) {
                continue;
            }
            sublist.add(candidates[i]);
            backTrackCombinationSum2(candidates, i + 1, sublist, target, output);
            sublist.remove(sublist.size() - 1);
            prev = candidates[i];
        }
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        int index=0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                if(board[i][j] == word.charAt(index)) {
                    boolean isWordFound = performDFS(board,word,i,j,index);
                    if(isWordFound) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    private boolean performDFS(char[][] board, String word, int i, int j, int index) {

        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        if(index == word.length()-1) {
            return true;
        }

        char prevChar = board[i][j];
        board[i][j] = '?';

        if(performDFS(board,word,i-1,j,index+1) ||
                performDFS(board,word,i+1,j,index+1) ||
                performDFS(board,word,i,j-1,index+1) ||
                performDFS(board,word,i,j+1,index+1)
        ) {
            return true;
        }
        board[i][j] = prevChar;
        return false;
    }
}
