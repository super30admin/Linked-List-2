// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Create a stack and push all the elements. We iterate over the stack,
// place elements in correct position

// LC 143. Reorder List

import java.util.*;

public class ReorderList {

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public void reorderList(ListNode head) {
    if (head == null) {
      return;
    }

    ListNode curr = head;
    Stack<ListNode> s1 = new Stack<>();

    while (curr != null) {
      s1.push(curr);
      curr = curr.next;
    }

    curr = head;

    while (curr != null) {
      ListNode tmp = curr.next;
      ListNode popped = s1.pop();

      curr.next = popped;
      popped.next = tmp;

      curr = tmp;

      if (curr != null && tmp.next == popped) {
        tmp.next = null;
        break;
      }
    }
  }
}
