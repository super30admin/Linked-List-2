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

//Bruteforce : This is solution would take a time complexity of O(n*n) and space complexity of O(1)
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA == null || headB == null)
      return null;

    boolean flag = true;
    while(headA != null){
      ListNode headBcopy = headB;
      while(headBcopy != null){
        if(headA == headBcopy){
          flag = true;
          break;
        }
        else{
          flag = false;
        }
        headBcopy = headBcopy.next;
      }
      if(flag)
        break;
      else
        headA = headA.next;
    }

    if(flag)
      return headA;
    else
      return null;
  }
}

//Optimal : This is solution would take a time complexity of O(n + n) and space complexity of O(n)
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    Set<ListNode> s = new HashSet<>();
    while(headA != null){
      s.add(headA);
      headA = headA.next;
    }
    while(headB != null){
      if(s.contains(headB))
        return headB;
      headB = headB.next;
    }
    return null;
  }
}