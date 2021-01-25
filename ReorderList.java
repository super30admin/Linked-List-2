// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
public class ReorderList {
    /**
     * Definition for singly-linked list.
     * */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public void reorderList(ListNode head) {
            if(head == null || head.next == null) return;

            //fast and slow pointer
            ListNode slow = head;
            ListNode fast = head;

            //find mid point
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            //reverse second half
            ListNode prev = null, curr = slow, tmp;
            while(curr != null){
                tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            //merge both halves
            ListNode n1 = head, n2 = prev;
            while(n2.next != null){
                tmp = n1.next;
                n1.next = n2;
                n1 = tmp;

                tmp = n2.next;
                n2.next = n1;
                n2 = tmp;
            }
        }
    }
}
