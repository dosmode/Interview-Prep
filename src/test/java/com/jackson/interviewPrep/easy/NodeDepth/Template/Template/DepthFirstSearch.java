package com.jackson.interviewPrep.easy.NodeDepth.Template.Template;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NodeDepth {
    @Test
    public void TestCase1() {
        Program.BinaryTree root = new Program.BinaryTree(1);
        root.left = new Program.BinaryTree(2);
        root.left.left = new Program.BinaryTree(4);
        root.left.left.left = new Program.BinaryTree(8);
        root.left.left.right = new Program.BinaryTree(9);
        root.left.right = new Program.BinaryTree(5);
        root.right = new Program.BinaryTree(3);
        root.right.left = new Program.BinaryTree(6);
        root.right.right = new Program.BinaryTree(7);
        int actual = Program.nodeDepths(root);
        assertEquals(16, actual);
    }
}

class Program {
    public static int nodeDepths(BinaryTree root) {
        int sum = 0;
        nodeDepthsRecurusion(root, 0,  sum);
        return sum;
    }

    public static void nodeDepthsRecurusion(BinaryTree root, int level, int levelSum) {
        int result;
        if (root != null && root.left == null && root.right == null) {
            return;
        }
        if (root != null && root.left != null && root.right != null) {
            nodeDepthsRecurusion(root.left, level + 1, levelSum + level + 1);
        }
        if (root != null && root.left == null && root.right != null){
            nodeDepthsRecurusion(root.right, level +1 , levelSum + level + 1);
        }
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
