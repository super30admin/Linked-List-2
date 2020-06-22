/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// This is solution would take a time complexity of O(n) and space complexity of O(1)
class Solution {
  public void reorderList(ListNode head) {

    if(head == null)
      return;

    ListNode newList = head;
    ListNode first = newList;
    ListNode second = newList;

    while(second != null && second.next != null && second.next.next != null){
      first = first.next;
      second = second.next.next;
    }

    ListNode secondList = first.next;
    first.next = null;

    ListNode prevPtr = null;
    ListNode curr = secondList;
    ListNode nextPtr = null;

    while(curr != null){
      nextPtr = curr.next;
      curr.next = prevPtr;
      prevPtr = curr;
      curr = nextPtr;
    }
    secondList = prevPtr;

    ListNode p1 = head;
    ListNode p2 = secondList;

    while(p2 != null){
      ListNode temp1 = p1.next;
      ListNode temp2 = p2.next;

      p1.next = p2;
      p2.next = temp1;

      p1 = temp1;
      p2 = temp2;
    }

  }
}