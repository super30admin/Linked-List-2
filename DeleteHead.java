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
*///Time and Space Complexity is O(1).
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No issues faced during implementation


//Replace the data of the delete node to next node's value.
// Function to delete a node without any reference to head pointer.
class Solution {
    void deleteNode(Node node) {
        
        node.data = node.next.data;
        node.next = node.next.next;
        // Your code here
    }
}