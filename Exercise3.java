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
        if(headA==null  || headB==null)return null;
        HashSet<ListNode> set = new HashSet<>();
        while(headA!=null || headB!=null)
        {   
            
            if(headA!=null)
            {
                if(set.contains(headA))return headA;
                else set.add(headA);
                headA=headA.next;
            }
         
            if(headB!=null)
            {
                if(set.contains(headB))return headB;
            else set.add(headB);
                headB=headB.next;
            }
        }
        return null;
    }
}