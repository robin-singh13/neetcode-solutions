package com.example.demo;

import java.util.*;

public class NeetCodeSolutionsTree {

    /**
     * Definition for a binary tree node.*/
     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
    }

    public TreeNode invertTree(TreeNode root) {
         if(root == null) return null;

            invertTree(root.left);
            invertTree(root.right);
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = tmp;

        return root;
    }

    public int maxDepth(TreeNode root) {
        return calculateDepth(root);
     }

    private int calculateDepth(TreeNode root) {
         if(root == null) return 0;

         int leftSide = calculateDepth(root.left);
         int rightSide = calculateDepth(root.right);
         return 1 + Math.max(leftSide,rightSide);
    }

    public int diameterOfBinaryTree(TreeNode root) {
         int maxstep=0;
         depthFirstSearch(root,maxstep);
         return maxstep;
    }

    private int depthFirstSearch(TreeNode root, int maxstep) {
         if (root == null) return 0;
         int leftSide= depthFirstSearch(root.left,maxstep);
         int rightSide=depthFirstSearch(root.right,maxstep);
         maxstep=Math.max(maxstep,leftSide+rightSide);
         return 1+Math.max(leftSide,rightSide);
     }

    public boolean isBalanced(TreeNode root) {
        return depthFirstBalancedTree(root)[0] == 1;

    }

    private int[] depthFirstBalancedTree(TreeNode root) {
         if (root == null) return new int[]{1,0};
         int[] leftHeight = depthFirstBalancedTree(root.left);
         int[] rightHeight = depthFirstBalancedTree(root.right);
         int height = 1 + Math.max(leftHeight[1],rightHeight[1]);
         boolean balanced = leftHeight[0] == 1 && rightHeight[0] == 1 && Math.abs(leftHeight[1]-rightHeight[1])<=1;
         return new int[]{balanced ? 1 : 0, height};
     }

    public boolean isSameTree(TreeNode p, TreeNode q) {
         List<Integer> firstTree = new ArrayList<>();
         List<Integer> secondTree = new ArrayList<>();
         getpreNotation(p,firstTree);
         getpreNotation(q,secondTree);
         return firstTree.equals(secondTree);
    }

    private void getpreNotation(TreeNode root, List<Integer> posix) {
         if(root == null) return;
         posix.add(root.val);
         getpreNotation(root.left,posix);
         getpreNotation(root.right,posix);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
         if(subRoot==null) {
             return true;
         }
         if(root==null) {
             return false;
         }
         if(isSameTreeOptimal(root,subRoot)) {
             return true;
         } else {
             return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
         }
     }

    private boolean isSameTreeOptimal(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null) return true;
        if(root!=null && subRoot!=null && root.val==subRoot.val) {
            return isSameTreeOptimal(root.right,subRoot.right) && isSameTreeOptimal(root.left, subRoot.left);
        }
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if(p.val<q.val) {
             return commonAncestor(root,p,q);
         }
         return commonAncestor(root,q,p);
    }

    private TreeNode commonAncestor(TreeNode root, TreeNode smallVal, TreeNode bigVal) {
         if(root.val >= smallVal.val && root.val <= bigVal.val) {
             return root;
         }
         if(root.val >= smallVal.val && root.val >= bigVal.val ) {
             return commonAncestor(root.left,smallVal,bigVal);
         } else if(root.val <= smallVal.val && root.val <= bigVal.val) {
             return commonAncestor(root.right,smallVal,bigVal);

        }
         return null;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();

        performDFS(root,0,output);
        return output;
    }

    private void performDFS(TreeNode root, int level, List<List<Integer>> output) {
        if(root == null) {
            return;
        }
        if(output.size()<level+1) {
            output.add(level,new ArrayList<>());
        }
        output.get(level).add(root.val);
        performDFS(root.left,level+1,output);
        performDFS(root.right,level+1,output);
    }

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> output = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root!=null) {
            queue.add(root);
        }
        while(!queue.isEmpty()) {
            TreeNode rightSide = null;
            int queueSize = queue.size();
            for(int i=0; i<queueSize; i++) {
                TreeNode currentNode = queue.poll();
                if(currentNode!=null) {
                    rightSide = currentNode;
                    if(currentNode.left!=null) {
                        queue.add(currentNode.left);
                    }
                    if(currentNode.right!=null) {
                        queue.add(currentNode.right);
                    }
                }
            }
            if(rightSide!=null) {
                output.add(rightSide.val);
            }
        }
        return output;
    }

    public int goodNodes(TreeNode root) {
         int maxValue = -101;
         int[] result = new int[1];
         performDFSWithStack(root,maxValue,result);
         return result[0];
    }

    private void performDFSWithStack(TreeNode root, int maxValue, int[] result) {
         if(root == null) {
             return;
         }
         if(root.val >= maxValue) {
             maxValue=root.val;
             result[0]++;
         }
         performDFSWithStack(root.left,maxValue,result);
         performDFSWithStack(root.right,maxValue,result);
     }

    public boolean isValidBST(TreeNode root) {
         return checkBST(root,-1001,1001);
    }

    private boolean checkBST(TreeNode root, int lowerBound, int upperBound) {
        if(root == null) {
            return true;
        }
        if(!(lowerBound < root.val && root.val < upperBound)) {
            return false;
        }
        return checkBST(root.left,lowerBound,root.val) && checkBST(root.right,root.val,upperBound);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedList = new ArrayList<>();
        getOrderedList(root,sortedList,k);
        return sortedList.get(k-1);
    }

    private void getOrderedList(TreeNode root, List<Integer> sortedList, int k) {
        if(root == null) {
            return;
        }
        if(sortedList.size()==k) {
            return;
        }
        getOrderedList(root.left,sortedList,k);
        sortedList.add(root.val);
        getOrderedList(root.right,sortedList,k);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int mid = -1;
        for(int i=0;i<inorder.length; i++) {
            if(inorder[i]==preorder[0]) {
                mid=i;
                break;
            }
        }
        //Partiton list for left Sub tree
        int[] leftPreorder = Arrays.copyOfRange(preorder,1,mid+1);
        int[] leftInorder = Arrays.copyOfRange(inorder,0,mid+1);
        root.left = buildTree(leftPreorder,leftInorder);

        //Partition list ofr right Sub tree
        int[] rightPreorder = Arrays.copyOfRange(preorder,mid+1,preorder.length);
        int[] rightInOrder = Arrays.copyOfRange(inorder,mid+1,inorder.length);
        root.right = buildTree(rightPreorder,rightInOrder);

        return root;
    }

}
