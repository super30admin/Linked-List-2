// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : No

class Solution
{
    void deleteNode(Node del)
    {
         del.data = del.next.data;
         del.next = del.next.next;
    }
}