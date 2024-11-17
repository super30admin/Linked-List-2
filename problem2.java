//Problem2 (https://leetcode.com/problems/reorder-list/)

//Time Complexity: O(n)
//Space Complexity: O(1)
// Did this code successfully run on Leetcode :
// Yes

// Any problem you faced while coding this :
// No major issues, but keeping track of pointers during the merge step
// was tricky and needed careful handling to avoid mistakes.

// Your code here along with comments explaining your approach
/*
    Approach:
    1. Use the two-pointer technique to find the middle of the list.
    2. Reverse the second half of the list starting from the middle node.
    3. Merge the first half and the reversed second half.
    4. Time Complexity: O(n), where n is the number of nodes in the list.
    5. Space Complexity: O(1), as we only use a few pointers and no extra data structures.
*/
public class problem2 {


     // Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) return;

            // Step 1: Find the middle of the list
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // Step 2: Reverse the second half of the list
            ListNode prev = null, curr = slow;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }

            // Step 3: Merge the two halves
            ListNode first = head, second = prev;
            while (second.next != null) {
                ListNode temp1 = first.next;
                ListNode temp2 = second.next;
                first.next = second;
                second.next = temp1;
                first = temp1;
                second = temp2;
            }
        }
    }

}
