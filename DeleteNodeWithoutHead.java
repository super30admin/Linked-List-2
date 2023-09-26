// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes (GFG)
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Since head ptr is not given, we directly change the data and address of the node to be deleted
 */
class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         del.data = del.next.data;
         del.next = del.next.next;
    }
}