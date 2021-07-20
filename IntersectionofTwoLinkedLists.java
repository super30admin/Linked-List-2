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

//TimeComplexity:O(N)
//SpaceComplexity:O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0, lenB=0;
        ListNode l1=headA;
        ListNode l2=headB;
        while(l1!=null){
            lenA++;
            l1=l1.next;
        }
        while(l2!=null){
            lenB++;
            l2=l2.next;
        }
        l1=headA;
        l2=headB;
        int dif = Math.abs(lenA-lenB);
        if(lenA >lenB){
            while(dif-->0){
                l1=l1.next;
            }
        }else{
            while(dif-->0){
                l2=l2.next;
            }
        }

        while(l1 != l2 && l1!=null && l2!=null){
            l1=l1.next;
            l2=l2.next;
            if(l1==null && l2==null){
                return null;
            }
        }
        return l1;
    }
}