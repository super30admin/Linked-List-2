package com.ds.rani.linkedlist;

/**
 * You are given a pointer/ reference to the node which is to be deleted from the linked list of N nodes. The task is to delete the node. Pointer/ reference to head node is not given.
 * <p>
 * Note: No head reference is given to you.
 * <p>
 * Input Format: First line of input contains number of testcases T.
 * For each testcase, first line of input contains length of linked list and next line contains the data of the linked list.
 * The last line contains the node to be deleted.
 * <p>
 * Output Format: For each testcase, in a newline, print the linked list after deleting the given node.
 * Your Task: This is a function problem. You only need to complete the function deleteNode that takes reference to the node that needs to be deleted. The printing is doneautomatically by the driver code.
 * Constraints: 1 <= T <= 100 1 <= N <= 103
 * <p>
 * Example: Input: 2 2 1 2 1 4 10 20 4 30 20
 * <p>
 * Output: 2 10 4 30
 * <p>
 * Explanation: Testcase 1: After deleting 20 from the linked list, we have remaining nodes as 10, 4 and 30
 */
//Approach:copy next nodes data in given node,then just skip reference to the next node.
//Time complexity:o(1)
//space complexity:o(1)

public class DeleteNode {
    class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
        }
    }

    void deleteNode(Node node) {
        //cope next node data to the given node
        node.data = node.next.data;
        //skip next node
        node.next = node.next.next;
    }
}
