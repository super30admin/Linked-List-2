
// Time Complexity :O(m+n)// higher of length
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
    Basically traverse the same length of linked list !!
    If A >B
    then start from A-B index in A
    this works bcoz length after intersection is common.
 */
public class IntersectionOfLinkedList {

     //* Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int m = 0;
            int n = 0;
            ListNode start = headA;
            while (start != null) {
                m++;
                start = start.next;
            }
            start = headB;
            while (start != null) {
                n++;
                start = start.next;
            }
            int skip = 0;
            int flag = 0;
            ListNode startA = headA;
            ;
            ListNode startB = headB;
            if (m > n) {
                skip = m - n;
                while (skip != 0) {
                    startA = startA.next;
                    skip--;
                }
            } else if (m < n) {
                skip = n - m;
                while (skip != 0) {
                    startB = startB.next;
                    skip--;
                }
                flag = 1;
            }
            while (startA != startB) {
                startA = startA.next;
                startB = startB.next;
            }
            return startA;
        }
}
