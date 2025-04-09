// Time Complexity: O(m+n) 
// Space Complexity: O(1)

//Leetcode problem: https://leetcode.com/problems/intersection-of-two-linked-lists/

/**
 * Finds the intersection node of two singly linked lists by aligning their start points.
 * Advances the longer list’s head until both lists are of equal length.
 * Then moves both pointers in tandem to identify the intersecting node.
 */

public class IntersectionOfTwoLinkedList {
  //Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != null && curB != null) {
            curA = curA.next;
            curB = curB.next;
        }

        while (curB != null) {
            curB = curB.next;
            headB = headB.next;
        }
        while (curA != null) {
            curA = curA.next;
            headA = headA.next;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
}
