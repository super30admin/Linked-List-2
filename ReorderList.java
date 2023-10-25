// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class ReorderList {
    lass Solution {
        public void reorderList(ListNode head) {
            ListNode slow = head, fast = head;

            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            //fast at reverse head
            fast = reverse(slow.next);
            //slow at middle
            slow.next = null;

            slow = head;

            while(fast != null){
                ListNode temp = slow.next;
                slow.next = fast;
                fast = fast.next;
                slow.next.next = temp;
                slow = temp;
            }

        }
        private ListNode reverse(ListNode head){
            ListNode prev = null, cur = head, next = null;

            while(cur != null){
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }
    }
}
