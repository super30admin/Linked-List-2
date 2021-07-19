// Time Complexity : o(1)
// Space Complexity : o(1)
// Did this code successfully run on GeeksforGeeks : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         
         del.data=del.next.data;
         del.next=del.next.next;
    }
}