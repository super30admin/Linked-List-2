// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         Node dummy = del.next;
         del.data = dummy.data;
         del.next = dummy.next;
         dummy = null;
         
    }
}