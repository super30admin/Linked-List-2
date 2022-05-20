//Time Complexity: O(N) + O(N/2)
//Space Complexity: O(1)
//Leetcode: yes.
public class ReorderList {
    /**
     * Definition for singly-linked list. */
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public void reorderList(ListNode head) {


            if (head == null || head.next == null) {
                return;
            }

            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            //curr ---> is pointing to the node where we need start reversing the list

            //System.out.println("slow val : "+slow.val+ " fast val : "+fast.val);
            ListNode prev = null;
            while(slow != null) {
                fast = slow.next;
                slow.next = prev;
                prev = slow;
                slow = fast;
            }

            //now curr is pointing to the new head of the reverse link list/
            //merge the two list now
            ListNode newList = head;
            ListNode temp, revList = prev;
            System.out.println("newList val : "+newList.val+ " revList val : "+revList.val);
            while (revList.next != null) {
                temp = newList.next;
                newList.next = revList;
                newList = temp;

                temp = revList.next;
                revList.next = newList;
                revList = temp;
            }

        }
    }
}
