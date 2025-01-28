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
    //Time Complexity: O(1)
    //Space Complexity: O(1)
    //Approach: Copy the data of the next node to the current node and delete the next node.
    void deleteNode(Node node) {
        // Your code here
        node.data = node.next.data;
        node.next= node.next.next;
        
    }
}