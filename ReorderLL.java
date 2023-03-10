public class ReorderLL {
    public void reorderList(ListNode head) {
        // find the mid
        // reverse list after mid
        // reorder the nodes

        if(head==null || head.next==null) return;

        ListNode slow = head;
        ListNode fast = head;

        // mid
        while(fast.next!=null && fast.next.next!=null){
                slow = slow.next;
                fast = fast.next.next;
        }

        // reverse
        fast = reverseList(slow.next);
        slow.next = null;
        slow = head;

        // reorder
        while(fast!=null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    private ListNode reverseList(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
        ListNode next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

// TC - O(n)
// SC - O(1)