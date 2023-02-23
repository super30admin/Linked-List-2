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
        int countA=0;
        int countB=0;
        ListNode cur=headA;
        while(cur!=null){
            countA++;
            cur=cur.next;
        }
        cur=headB;
        while(cur!=null){
            countB++;
            cur=cur.next;
        }
        if(countA>countB){
            ListNode tempA = headA;
            for(int i=0;i<countA-countB;i++){
                tempA=tempA.next;
            }
            ListNode tempB = headB;
            while(tempA!=tempB){
                tempA=tempA.next;
                tempB=tempB.next;
            } return tempA;
        }
        else {
            ListNode tempB = headB;
            for(int i=0;i<countB-countA;i++){
                tempB=tempB.next;
            }
            ListNode tempA = headA;
            while(tempA!=tempB){
                tempA=tempA.next;
                tempB=tempB.next;
            } return tempA;
        }
    }
}