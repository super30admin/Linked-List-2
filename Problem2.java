
//T.C  : O(n)
//S.C : O(1)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No

public class Problem2 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = reversed(slow.next);
        slow.next = null;

        ListNode curr = head;
        ListNode temp1 = null;


        slow = head;
        while(fast != null){
            temp1 = slow.next;
            slow.next = fast;
            fast= fast.next;
            slow.next.next = temp1;
            slow = temp1;

        }


    }
    private ListNode reversed(ListNode head){
        ListNode prev = null, curr = head, next = null;
        while(curr != null){
            next = curr.next;
            curr.next= prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
