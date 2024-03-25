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

 //tc = o(n)
 //sc = o(1)
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        int sizeB = 0;
        ListNode tempA = headA;
        while(tempA != null){
            sizeA++;
            tempA = tempA.next;
        }
        ListNode tempB = headB;
        while(tempB != null){
            sizeB++;
            tempB = tempB.next;
        }
        //if 1st list is bigger by 2 it will move 2 steps ahead. 
        while(sizeA > sizeB){
            headA = headA.next;
            sizeA--;
        }

        while(sizeB > sizeA){
            headB = headB.next;
            sizeB--;
        }

        while(headA != null && headB != null){
             if(headA == headB){ //this case should be above the next logic below
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
           
        }

        return null;

    }
}