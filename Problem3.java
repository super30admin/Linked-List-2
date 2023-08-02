//Delete without head pointer

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//Function to delete a node without any reference to head pointer.
class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         if(del.next == null) return;
         Node prev = null;
         while(del.next != null){
             del.data = del.next.data;
             prev = del;
             del = del.next;
         }
         prev.next = null;
    }
}