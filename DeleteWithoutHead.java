// Time complexity:- O(1)
// Space complexity:- O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 
/**
 * Approach: 
 * In this problem, we are given a node (del_node) in the middle of a singly linked list and tasked with deleting it.
 * Since we do not have access to the head of the list, we cannot traverse it to find the node.
 * The approach used here is to copy the data of the next node into the current node.
 * This overwrites the current node's data with the next node's data, "deleting" the current node by making it identical to the next node.
 * Then, we adjust the next pointer of the current node to point to the node after the next node, effectively removing the next node from the list 
 */ 
class Solution {
    void deleteNode(Node node) {
        // Copy the data of the next node into the current node.
        // This overwrites the current node's data with the next node's data.
        node.data = node.next.next.data;
        // Link the current node to the node after the next node.
        // This removes the reference to the next node, effectively deleting it from the list.
        node.next = node.next.next;

    }
}

   

     