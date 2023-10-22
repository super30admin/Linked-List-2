// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution
{
    void deleteNode(Node del)
    {
         Node fast = del.next;
         del.data = fast.data;
         del.next = del.next.next;
    }
}