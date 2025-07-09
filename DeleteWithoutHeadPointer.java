// Time Complexity: O(1)
// Space Complexity: O(1)
// Did this code successfully run on GeeksforGeeks / Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach:
// - Copy the data from its next node into the current node.
// - Skip over the next node by adjusting the current node's `next` pointer.
// - This deletes the next node, but makes the current node look like the one after it.


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