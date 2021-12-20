//Time Complexity : O(1)
//Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
            del.data = del.next.data;
        del.next = del.next.next;
    }
}
