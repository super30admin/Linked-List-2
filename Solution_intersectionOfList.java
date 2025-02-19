//TC: O(n)
//SC: O(1)
//Did it run on leetcode: Yes
public class Solution_intersectionOfList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lA = 0;
        int lB = 0;
        ListNode ptrA = headA;
        ListNode ptrB = headB;

        while(ptrA != null){
            lA++;
            ptrA = ptrA.next;
        }

        while(ptrB != null){
            lB++;
            ptrB = ptrB.next;
        }

        ptrA = headA;
        ptrB = headB;
        while(lA > lB){
            ptrA = ptrA.next;
            lA--;
        }
        while(lB > lA){
            ptrB = ptrB.next;
            lB--;
        }

        while(ptrA != ptrB){
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }

        return ptrA;
    }
}
