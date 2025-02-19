//TC: O(n)
//SC: O(1)
//Did it run on leetcode: Yes
public class Solution_reorderList {

    public void reorderList(ListNode head) {

        if(head == null || head.next == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = slow.next;
        ListNode curr = prev.next;
        slow.next = null;
        prev.next = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        slow = head;
        fast = prev;
        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }

    }

}
