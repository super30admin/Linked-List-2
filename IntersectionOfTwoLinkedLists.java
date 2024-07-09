// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    // Get first list length
    int countA = getLength(headA);

    // Get second list length
    int countB = getLength(headB);

    // Cover the extra distance in the longer list
    ListNode currentA = headA;
    ListNode currentB = headB;
    if(countA > countB) {
      for(int i = 0; i<(countA-countB); i++) {
        currentA = currentA.next;
      }
    }else {
      for(int i = 0; i<(countB-countA); i++) {
        currentB = currentB.next;
      }
    }
    // iterate both at the same speed and stop when they meet.
    while(currentA!=null && currentB!=null) {
      if(currentA == currentB) return currentA;
      currentA = currentA.next;
      currentB = currentB.next;

    }
    return null;
  }

  int getLength(ListNode head) {
    int count = 0;
    ListNode current = head;
    while(current != null) {
      current = current.next;
      count++;
    }
    return count;
  }
}