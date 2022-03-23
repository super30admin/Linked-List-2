// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// In this problem we will assign the data value from next node to current node
// Then we will skip the next node or make next of del equal to next of next of del
    // } Driver Code Ends
    
    
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
    
    //Function to delete a node without any reference to head pointer.
    class Solution
    {
        void deleteNode(Node del)
        {
             // Your code here
             int data = del.next.data;
             del.data = data;
             del.next = del.next.next;
        }
    }
    
    