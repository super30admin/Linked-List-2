// Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)

// Time Complexity : O(1) 
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, the value at that place is removed and all the values are moved forward. If the value is null or its the last node then no action is
 * taken.
 */

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
        if(node == null || node.next == null){
            return;
        }
        
        node.data=node.next.data;
        node.next = node.next.next;
    }
}
