//https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//simply assign value of next node to the delete node and 
//point it to the next node of the next node


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
        node.data=node.next.data;
        node.next=node.next.next;
    }
}