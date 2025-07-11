// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on GFG : Yes
// Any problem you faced while coding this : No

// Approach : I just copied the data from the next node to the current node and then updated the next pointer to skip the next node, effectively deleting it.

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
        // Your code here
        node.data = node.next.data;
        node.next = node.next.next;
    }
}