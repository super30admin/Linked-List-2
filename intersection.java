//Time Complexity : O(N)
 //Space Complexity : O(1)
 //Did this code successfully run on Leetcode : Yes
 //Any problem you faced while coding this : No

 /**
  * The shorter list reaches the end first and then we switch the pointer traversing that list to the head of the longer list.
  * So now when the longer list reaches the end and we switch the pointer traversing that list to the head of the shorter list and by this time the other pointer would have traversed the extra length of the longer list.
  * Now both the pointers are equidistant from the intersection point and if we traverse them simultaneously they would meet at the intersection point.
  * If there is no intersection point then both pointers would reach the end(null) at the same time.
  * If both lists are of equal length and if they meet then it would have been found even without switching the pointers and if there is no intersection point then both would reach the end(null) at the same time.
  */

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
public class intersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode CurrA=headA;
        ListNode CurrB=headB;

        while(CurrA!=CurrB)
        {
            CurrA=CurrA.next;
            CurrB=CurrB.next;

            if(CurrA==null&& CurrB==null) return null;

            if(CurrA==null)
            {
                CurrA=headB;
            }

            if(CurrA==null)
            {
                CurrA=headB;
            }
        }

        return CurrA;

    }
}