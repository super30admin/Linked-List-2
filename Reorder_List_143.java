//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None


class Reorder_List_143 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        //Finding the mid of the list
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        
        ListNode prev = null;
        ListNode temp = null;
        
        // Reversing the second half of the original list
        while(fast != null)
        {
            temp = fast.next;
            fast.next = prev;
            prev = fast;
            fast = temp;
        }
        fast = prev;
        
        // Merging both the lists which are halved
        while(fast != null)
        {
            temp = head.next;
            head.next = fast;
            fast = fast.next;
            head.next.next = temp;
            head = temp;
        }
    }
}
