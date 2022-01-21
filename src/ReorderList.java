public class ReorderList {
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

    // Find Mid -- > new reverse list after mid --> merge
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public void reorderList(ListNode head) {

            ListNode slow = head;
            ListNode fast = head;

            while(fast != null && fast.next!=null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode prev=null;
            ListNode curr=slow.next;
            slow.next = null;
            while(curr!=null) {
                ListNode next=curr.next;
                curr.next = prev;
                prev =curr;
                curr = next;
            }

            // System.out.println(prev.val +""+ slow.val+ " "+prev.next.val);
            ListNode start = head;
            ListNode temp = start.next;
            curr = prev;
            while(curr!=null) {
                temp = start.next;
                start.next = curr;
                start = temp;
                temp = curr.next;
                curr.next = start;
                curr = temp;
            }
            // curr = start;

        }
    }
}
