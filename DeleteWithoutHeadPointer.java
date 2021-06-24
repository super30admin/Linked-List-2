// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on GFG : Yes
// Any problem you faced while coding this : No

class Solution
{
    void deleteNode(Node del)
    {
         if(del.next == null)
            del = null;
         del.data = del.next.data;
         del.next = del.next.next;
    }
}
