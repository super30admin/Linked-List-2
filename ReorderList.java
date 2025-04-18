
//  TC: O(n/2+n/2+n/2) ==> O(n)
//  SC: O(1)
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow  = head;
        ListNode fast = head;

        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversedHead = reverse(slow.next);
        slow.next = null;
        fast = reversedHead;
        slow = head;
        while(fast!=null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;

        }
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;

        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}