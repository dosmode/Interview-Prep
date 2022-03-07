package com.jackson.interviewPrep.easy.DepthFirstSerach.Template;

import org.junit.jupiter.api.Test;

import java.awt.image.Kernel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// This file is initialized with a code version of this
// question's sample test case. Feel free to add, edit,
// or remove test cases in this file as you see fit!



    class ProgramTest {
        @Test
        public void TestCase1() {
            Program.Node graph = new Program.Node("A");
            graph.addChild("B").addChild("C").addChild("D");
            graph.children.get(0).addChild("E").addChild("F");
            graph.children.get(2).addChild("G").addChild("H");
            graph.children.get(0).children.get(1).addChild("I").addChild("J");
            graph.children.get(2).children.get(0).addChild("K");
            String[] expected = {"A", "B", "E", "F", "I", "J", "C", "D", "G", "K", "H"};
            List<String> inputArray = new ArrayList<String>();
            assertTrue(compare(graph.depthFirstSearch(inputArray), expected));
        }

        public static boolean compare(List<String> arr1, String[] arr2) {
            if (arr1.size() != arr2.length) {
                return false;
            }
            for (int i = 0; i < arr1.size(); i++) {
                if (!arr1.get(i).equals(arr2[i])) {
                    return false;
                }
            }
            return true;
        }
    }


class Program {
    // Do not edit the class below except
    // for the depthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            array.add(name);
            for( int i = 0 ; children.size() > i ; i ++){
                children.get(i).depthFirstSearch(array);
            }
            return array;
        }



        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }}


