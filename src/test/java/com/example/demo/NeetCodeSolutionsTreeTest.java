package com.example.demo;

import org.junit.jupiter.api.Test;
import com.example.demo.NeetCodeSolutionsTree.TreeNode;


import java.util.ArrayDeque;
import java.util.Deque;


public class NeetCodeSolutionsTreeTest {

    NeetCodeSolutionsTree neetCodeSolutionsTree = new NeetCodeSolutionsTree();

    @Test
    public void sanityInvertTree() {
        TreeNode root = new TreeNode(1, new TreeNode(2,new TreeNode(4),new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        printTreeContent(root);
        TreeNode result = neetCodeSolutionsTree.invertTree(root);
        printTreeContent(result);

        printTreeContent(neetCodeSolutionsTree.invertTree(null));
    }

    @Test
    public void sanityMaxDepth() {
        TreeNode root = new TreeNode(1, new TreeNode(2,null,null), new TreeNode(3,new TreeNode(4),null));
        //printTreeContent(root);
        System.out.println(neetCodeSolutionsTree.maxDepth(root));
    }

    @Test
    public void sanityIsBalanced() {
        TreeNode root = new TreeNode(1, new TreeNode(2,null,null), new TreeNode(3,new TreeNode(4),null));
        System.out.println(neetCodeSolutionsTree.isBalanced(root));
    }

    @Test
    public void sanityLevelOrder() {
        TreeNode root = new TreeNode(1, new TreeNode(2,new TreeNode(4),new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        System.out.println(neetCodeSolutionsTree.levelOrder(root));
    }

    @Test
    public void sanityRightView() {
        TreeNode root = new TreeNode(1, new TreeNode(2,new TreeNode(4),new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        System.out.println(neetCodeSolutionsTree.rightSideView(root));
    }

    @Test
    public void sanityGoodNodes() {
        TreeNode root = new TreeNode(2, new TreeNode(1,new TreeNode(3),null), new TreeNode(1,new TreeNode(1),new TreeNode(5)));
        System.out.println(neetCodeSolutionsTree.goodNodes(root));
    }

    @Test
    public void sanityIsValidBST() {
        //TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(6,new TreeNode(3),new TreeNode(7)));
        TreeNode root = new TreeNode(2,new TreeNode(1),new TreeNode(3));
        System.out.println(neetCodeSolutionsTree.isValidBST(root));
    }

    private void printTreeContent(TreeNode result) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(result);
        while(!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            System.out.print(currNode.val + ", ");
            if(currNode.left!=null) {
                queue.add(currNode.left);
            }
            if(currNode.right!=null) {
                queue.add(currNode.right);
            }
        }
    }
}
