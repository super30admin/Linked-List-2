//Problem4 (https://leetcode.com/problems/intersection-of-two-linked-lists/)
// Time Complexity :
// O(m + n), where m and n are the lengths of the two linked lists.
// In the worst case, both pointers traverse the full lengths of both lists. Each pointer visits each node at most twice.

// Space Complexity :
// O(1), since we are using only two pointers and no additional data structures.

// Did this code successfully run on Leetcode :
// Yes

// Any problem you faced while coding this :
// No major issues, but understanding how the two-pointer approach works and why it guarantees an intersection point (or null) took some time.

// Your code here along with comments explaining your approach
/*
    Approach:
    1. Use two pointers, `d1` and `d2`, starting at the heads of List A and List B, respectively.
    2. Traverse both lists:
       - When `d1` reaches the end of List A, move it to the head of List B.
       - When `d2` reaches the end of List B, move it to the head of List A.
    3. If the two lists intersect, `d1` and `d2` will meet at the intersection node after at most m + n steps.
       - If there is no intersection, `d1` and `d2` will both eventually become null.
    4. This two-pointer technique works because both pointers traverse the same total distance by the time they either meet or end.
    5. The method returns the intersection node or null if there is no intersection.
*/
public class problem4 {


  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode d1= headA;
        ListNode d2= headB;

        while(d1!=d2)
        {
            d1= d1==null? headB: d1.next;
            d2= d2==null? headA: d2.next;
        }
        return d1;
    }

}
