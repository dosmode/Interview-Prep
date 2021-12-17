package com.jackson.interviewPrep.easy.findClosestValueInBST.Template;

import com.sun.jdi.IntegerValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindClosestValueInBST {
    @Test
    public void TestCase1() {
        var root = new Program.BST(10);
        root.left = new Program.BST(5);
        root.left.left = new Program.BST(2);
        root.left.left.left = new Program.BST(1);
        root.left.right = new Program.BST(5);
        root.right = new Program.BST(15);
        root.right.left = new Program.BST(13);
        root.right.left.right = new Program.BST(14);
        root.right.right = new Program.BST(22);

        var expected = 13;
        var actual = Program.findClosestValueInBst(root, 12);
        assertEquals(expected, actual);
    }
}

class Program {
    public static int findClosestValueInBst(BST tree, int target) {
       return findClosestValueInBst(tree, target, tree.value);
    }
    public static int findClosestValueInBst(BST tree, int target, int closestValue) {
        if (Math.abs(target - closestValue) > Math.abs(target - tree.value)) {
            closestValue = tree.value;
        }
        if (tree.value < target && tree.right != null) {
            return findClosestValueInBst(tree.right, target, closestValue);
        } else if (tree.value > target && tree.left != null) {
            return findClosestValueInBst(tree.left, target, closestValue);
        } else return closestValue;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}

