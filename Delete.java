// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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
    // Function to delete a node in a singly linked list
    void deleteNode(Node node) {
        // Check if the node or its next node is null
        if (node == null || node.next == null) {
            return;
        }
        // Copy data of the next node to the current node
        Node nextNode = node.next;
        node.data = nextNode.data;
        // Update the next pointer of the current node to skip the next node
        node.next = nextNode.next;
    }
}