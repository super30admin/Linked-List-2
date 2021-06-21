// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
1. Loop through the Linked List and put the node value with the next node's value
*/

// Your code here along with comments explaining your approach

class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         Node temp = del;
         Node prev = null;
         while(temp.next!=null) {
            temp.data = temp.next.data;
            prev = temp;
            temp = temp.next;   
         }
         
         prev.next = null;
    }
}
