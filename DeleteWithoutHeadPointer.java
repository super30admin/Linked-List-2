// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)
// You are given a node del_node of a Singly Linked List where you have to delete a value of the given node from the linked list but you are not given the head of the list.
// By deleting the node value, we do not mean removing it from memory. We mean:
// The value of the given node should not exist in the linked list.
// The number of nodes in the linked list should decrease by one.
// All the values before & after the del_node node should be in the same order.
// Note:
// Multiple nodes can have the same values as the del_node, but you must only remove the node whose pointer del_node is given to you.
// It is guaranteed that there exists a node with a value equal to the del_node value and it will not be the last node of the linked list.

// Examples:
// Input: Linked List = 1 -> 2, del_node = 1
// Output: 2
// Explanation: After deleting 1 from the linked list, we have remaining nodes as 2.

// Input: Linked List = 10 -> 20 -> 4 -> 30, del_node = 20
// Output: 10->4->30
// Explanation: After deleting 20 from the linked list, we have remaining nodes as 10, 4, 30.

// Constraints:
// 2 <= number of nodes <= 106  
// 1 <= node->data <= 106

/*
class Node
{
    int data ;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
*/

// Function to delete a node without any reference to head pointer.
class Solution {
    void deleteNode(Node node) {
        
        // Edge case: if node is null or it's the last node, we cannot delete it this way
        if (node == null || node.next == null) {
            return; // Defensive check, though the problem guarantees it's not the last node
        }

        // Copying the data from the next node into the given node
        node.data = node.next.data;

        // Bypassing the next node to effectively "delete" it
        node.next = node.next.next;
    }
}
