// TC: O(N)
// SC: O(1)
// where N is the length of the linked list

public class LC143 {
    private ListNode reverseList(ListNode head){
        if(head == null) return null;

        ListNode prev = null;
        ListNode curr = head;
        ListNode nxt = head.next;

        while(curr!=null){
            curr.next = prev;
            prev = curr;
            curr = nxt;
            if(nxt!=null) nxt = nxt.next;
        }

        return prev;
    }
    public void reorderList(ListNode head) {
        if(head == null) return;
        if(head.next == null || head.next.next==null) return;

        ListNode slow = head, fast = head;

        while(fast!=null && fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode list1 = head;
        ListNode list2 = slow.next;
        slow.next=null;

        list2 = reverseList(list2);

        ListNode temp1 = list1, temp2 = list2;
        while(temp2!=null){
            ListNode x = temp2;
            temp2 = temp2.next;
            x.next = temp1.next;
            temp1.next = x;
            temp1 = temp1.next.next;
        }

    }
}
