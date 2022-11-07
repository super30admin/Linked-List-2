
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

public class ReorderList {
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
        public void reorderList(ListNode head) {

            ListNode middle= getMiddleNode(head);
            ListNode nextL = middle.next;
            middle.next = null;

            ListNode nextR = reverseList(nextL);

            while (nextR != null){

                ListNode nodeNext = nextR.next;

                nextR.next = head.next;
                head.next = nextR;

                nextR = nodeNext;
                head = head.next.next;
            }



        }

        public ListNode reverseList(ListNode node){
            ListNode prev = null;
            ListNode curr = node;

            while (curr != null){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }

        public ListNode getMiddleNode(ListNode node){
            ListNode slow = node;
            ListNode fast = node;

            while (fast.next != null && fast.next.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }