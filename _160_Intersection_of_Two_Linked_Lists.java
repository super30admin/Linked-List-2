/**** Method 1 ****/
//Time Complexity: O(n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

//As we do not know the head node, we have only one option to delete the node, i.e not deleting the node but changing the values of nodes and removing the last node. We start by replacing the node.val with node.next.val and keep note of last but one node as we need to set its next as null.

/**** Method 2 ****/
//Time Complexity: O(n)
//Space Complexity: O(1)

//Successfully submitted in LeetCode

//Rather than using extra space, we can use two pointers and return the node where both them become equal, and if any time one of the pointer becomes null we move it starting next list, this works as both the pointer are moving at the same speed and even if they start at different length, they start at same length at some point.

import java.util.HashSet;

public class _160_Intersection_of_Two_Linked_Lists {

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    HashSet<ListNode> set = new HashSet<>();

    ListNode curr = headA;
    while (curr != null) {
      set.add(curr);
      curr = curr.next;
    }

    curr = headB;

    while (curr != null) {
      if (set.contains(curr)) {
        return curr;
      }

      curr = curr.next;
    }

    return null;
  }

  public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
    ListNode currA = headA;
    ListNode currB = headB;

    while (currA != null || currB != null) {
      if (currA == null && currB == null) {
        return null;
      }
      if (currA == null) {
        currA = headB;
      }

      if (currB == null) {
        currB = headA;
      }

      if (currA == currB) {
        return currA;
      }

      currA = currA.next;
      currB = currB.next;
    }

    return null;
  }
}
