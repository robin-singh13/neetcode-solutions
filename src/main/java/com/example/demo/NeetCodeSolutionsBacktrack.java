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
}
