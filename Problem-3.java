// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


//Solution: Will remove value to be deleted, not the refernce pointer
// Duplicate the value of del.next to del node
class Solution
{
    void deleteNode(Node del)
    {
         del.data = del.next.data;
         del.next = del.next.next;
         
    }
}