// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class DeleteWithoutHead {
    class Solution
    {
        void deleteNode(Node del)
        {
            // Your code here
            while(del.next.next != null){
                del.data = del.next.data;
                del = del.next;
            }
            del.data = del.next.data;
            del.next = null;
        }
    }
}
