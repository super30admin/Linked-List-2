// Time Complexity : O(m+n)
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: We take two stacks. Traverse both the lists and create two stacks.
// We start popping from stack and the last commom popped element form both the 
// stacks is the element where the two lists intersect.

// LC 160. Intersection of Two Linked Lists

import java.util.*;

public class IntersectionOfTwoLL {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if ((headA == null && headB != null) || (headA != null && headB == null)) {
      return new ListNode(-1);
    }

    Stack<ListNode> s1 = new Stack<>();
    Stack<ListNode> s2 = new Stack<>();

    ListNode curr = headA;
    while (curr != null) {
      s1.push(curr);
      curr = curr.next;
    }

    curr = headB;
    while (curr != null) {
      s2.push(curr);
      curr = curr.next;
    }

    ListNode result = null;
    while (!s1.isEmpty() && !s2.isEmpty()) {
      if (s1.peek() == s2.peek()) {
        result = s1.pop();
        s2.pop();
      } else {
        break;
      }
    }

    return result;
  }
}
