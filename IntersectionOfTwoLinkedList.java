/*
    TC : O(m+n)
    SC : O(1)
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        int sizeB = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != null) {
            sizeA++;
            tempA = tempA.next;
        }
        while(tempB != null) {
            sizeB++;
            tempB = tempB.next;
        }
        int diff = Math.abs(sizeA-sizeB);
        System.out.println(diff);
        tempA = headA;
        tempB = headB;
        if(sizeA > sizeB) {    
            while(diff != 0) {
                tempA = tempA.next;
                diff--;
            }
        }
        else {
            while(diff != 0) {
                tempB = tempB.next;
                diff--;
            }
        }
        while(tempA != null && tempB != null && tempB != tempA) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }
}