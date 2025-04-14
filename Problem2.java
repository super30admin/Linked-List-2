// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO
public class Problem2 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        //break the ll into 2 parts
        ListNode slow = head;
        ListNode fast  = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse the 2nd ll
        fast = reverseLL(slow.next);
        slow.next = null;

        //merge the 2 list
        slow = head;
        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    private ListNode reverseLL(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        while(next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }
}
