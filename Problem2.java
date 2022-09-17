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
public class Problem2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // null check
        if(headA == null || headB == null) return null;

        ListNode ptrA = headA;
        ListNode ptrB = headB;
        int lenA = 0, lenB = 0;
        // 1st traversal on the LLs to find respective lengths.
        while (ptrA!=null || ptrB != null){
            if(ptrA!=null){
                lenA += 1;
                ptrA = ptrA.next;
            }
            if(ptrB!=null){
                lenB += 1;
                ptrB = ptrB.next;
            }
        }
        ptrA = headA;
        ptrB = headB;
        // Finding the intersection in 2nd traversal.
        if(lenA >= lenB){
            int diff = lenA - lenB;
            for(int i = 1; i <= diff; i++){
                ptrA = ptrA.next;
            }
            while(ptrA !=null){
                if(ptrA == ptrB) return ptrA;
                ptrA = ptrA.next;
                ptrB = ptrB.next;
            }
        }
        else{
            int diff = lenB - lenA;
            for(int i = 1; i <= diff; i++){
                ptrB = ptrB.next;
            }
            while(ptrB !=null){
                if(ptrA == ptrB) return ptrA;
                ptrA = ptrA.next;
                ptrB = ptrB.next;
            }
        }
        // When no intersection was found and returned.
        return null;
    }
}

// TC: O(n)
// SC: O(1)