// Time Complexity :O(m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YEs
// Any problem you faced while coding this :No

// Your code here  with comments explaining your approach

public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null)
      return null;
    ListNode curr = headA;
    int lenA = 0;
    int lenB = 0;
    // Find length of both list
    while (curr != null) {
      lenA++;
      curr = curr.next;
    }
    curr = headB;
    while (curr != null) {
      lenB++;
      curr = curr.next;
    }
    // increment pointer untill shorter and longer meet
    while (lenA > lenB) {
      headA = headA.next;
      lenA--;
    }
    // increment pointer untill shorter and longer meet
    while (lenB > lenA) {
      headB = headB.next;
      lenB--;
    }
    // loop untill both are equal
    while (headA != headB) {
      headA = headA.next;
      headB = headB.next;
    }
    return headA;
  }
}