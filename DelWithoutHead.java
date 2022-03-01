//Function to delete a node without any reference to head pointer.

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution
{
    void deleteNode(Node del)
    {
        //if node is the last node, then mkae it null
         if(del.next == null) {
             del = null;
         } else { //else point data and next to del.next;
             del.data = del.next.data;
             del.next = del.next.next;
         }
    }
}
