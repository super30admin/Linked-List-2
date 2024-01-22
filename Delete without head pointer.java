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
         while(del != null){
             del.data = del.next.data;
             if(del.next.next == null){
                 del.next = null; 
             }
             del = del.next;
         }
    }
}
