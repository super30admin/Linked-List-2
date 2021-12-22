// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
/*Approach: Firstly calculate the sizes of each list then start the traversal for checking the intersection node by making each list to the
same length i.e., the start point for each lists should the same no. of nodes away from the intersection node. */

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
        if(headA==null||headB==null)
            return null;
        int headAsize=1;
        int headBsize=1;
        ListNode curr=headA;
        while(curr!=null)
        {
            curr=curr.next;
             headAsize++;
        }
         curr=headB;
         while(curr!=null)
        {
            curr=curr.next;
             headBsize++;
        }
       while(headAsize!=headBsize){
           if(headAsize>headBsize){
               headA=headA.next;
               headAsize--;
           }
           else{
               headB=headB.next;
               headBsize--;
           }
       }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}