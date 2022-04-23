// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

public class DeleteWithoutHeadPointer {
    
    public static void deleteNode(ListNode delete)
    {
        ListNode temp = delete.next;
        delete.val = temp.val;
        delete.next=temp.next;
        temp = null;
    }
}
