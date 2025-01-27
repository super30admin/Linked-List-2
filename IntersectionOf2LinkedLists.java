/**
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

public class IntersectionOf2LinkedLists {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode currA = headA;
    int lenA = 0;
    while (currA != null) {
      currA = currA.next;
      lenA++;
    }
    ListNode currB = headB;
    int lenB = 0;
    while (currB != null) {
      currB = currB.next;
      lenB++;
    }
    currA = headA;
    currB = headB;
    while (lenA > lenB) {
      currA = currA.next;
      lenA--;
    }
    while (lenB > lenA) {
      currB = currB.next;
      lenB--;
    }
    while (currA != currB) {
      currA = currA.next;
      currB = currB.next;
    }
    return currA;
  }

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
