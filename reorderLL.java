//time complexity O(n) since
//finding the middle is O(n)
//reversing the LL is O(n)
//merging the splits LLs O(n)
//O(3n) => O(n)

//space complexity O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        //middle
        ListNode slow = head; ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse
        fast = reverse(slow.next);
        slow.next = null; slow = head;

        //merge
        ListNode curr;
        while(fast != null){
            curr = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = curr;
            slow = curr;
        }
    }
    private ListNode reverse(ListNode head){
            ListNode prev = null;
            ListNode fast = head.next;
            while(fast != null){
                head.next = prev;
                prev = head;
                head = fast;
                fast = fast.next;
            }
            head.next = prev;
            return head;
        }
}
