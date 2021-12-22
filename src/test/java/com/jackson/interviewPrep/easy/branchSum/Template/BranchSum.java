package com.jackson.interviewPrep.easy.branchSum.Template;

import com.jayway.jsonpath.internal.Utils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BranchSum {
    public class TestBinaryTree extends Program.BinaryTree {
        TestBinaryTree(int value) {
            super(value);
        }

        TestBinaryTree insert(List<Integer> values) {
            return insert(values, 0);
        }

        TestBinaryTree insert(List<Integer> values, int i) {
            if (i >= values.size()) return null;

            List<TestBinaryTree> queue = new ArrayList<TestBinaryTree>();
            queue.add(this);
            while (queue.size() > 0) {
                TestBinaryTree current = queue.get(0);
                queue.remove(0);
                if (current.left == null) {
                    current.left = new TestBinaryTree(values.get(i));
                    break;
                }
                queue.add((TestBinaryTree) current.left);
                if (current.right == null) {
                    current.right = new TestBinaryTree(values.get(i));
                    break;
                }
                queue.add((TestBinaryTree) current.right);
            }
            insert(values, i + 1);
            return this;
        }
    }

    @Test
    public void TestCase1() {
        TestBinaryTree tree = new TestBinaryTree(1).insert(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(15, 16, 18, 10, 11));
        assertTrue(Program.branchSums(tree).equals(expected));
    }
}

class Program {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> listSum = new LinkedList<>();
        recursionBranchSumsBranchSums(root, 0, listSum );
        return listSum;
    }

    public static void recursionBranchSumsBranchSums(BinaryTree root, int runningSum, List<Integer> listSum){
        if(root == null) return;

        runningSum = runningSum+ root.value;
        if(root.left == null && root.right == null){
            listSum.add(runningSum);
            return;
        }
        recursionBranchSumsBranchSums(root.left, runningSum, listSum);
        recursionBranchSumsBranchSums(root.right, runningSum, listSum);

    }

}

