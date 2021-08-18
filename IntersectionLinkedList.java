/* Time Complexity :  O(n)
   Space Complexity :  O(1)
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1=0,len2=0;
        ListNode t1=headA,t2=headB;
        //Find lengths
        while(t1!=null){
            len1++;
            t1=t1.next;
        }
        while(t2!=null){
            len2++;
            t2=t2.next;
        }
        //move the pointer whose length is greater
        if(len1>len2){
            while(len1!=len2){
                headA=headA.next;
                len1--;
            }
        }
        if(len2>len1){
            while(len1!=len2){
                headB=headB.next;
                len2--;
            }
        }
        //find the intersection
        while(headA!=headB)
        {
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}