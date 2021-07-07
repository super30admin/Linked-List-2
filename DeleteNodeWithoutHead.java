
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Yo

public class DeleteNodeWithoutHead {
    public ListNode deleteNodeWithoutHead(ListNode head){
        if(head == null)
            return null;

        Node temp = head->next;
        head.val = head.val.val;
        head.next = head.next.next;
        temp = null;
        return head;
    }
}

