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
public class IntersectionTwoLL {
    // Time Complexity: O(n)
    // Space Complexity : O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lA = 0, lB = 0;
        
        //1. Finding the length
        ListNode dummyA = headA;
        ListNode dummyB = headB;
        
        while(dummyA != null){
            lA++;
            dummyA = dummyA.next;
        }
        
        while(dummyB != null){
            lB++;
            dummyB = dummyB.next;
        }
        
        dummyA = headA;
        dummyB = headB;
        
        //2. Traversing the extra length so that both have equal length
        if( lA > lB){
            while(lA != lB){
                lA--;
                dummyA = dummyA.next;
            }
        } else{
            while(lB != lA){
                lB--;
                dummyB = dummyB.next;
            }
        }
        
        // 3. Finding the intersection node
        while(dummyA != null && dummyB != null){
            if(dummyA == dummyB)
                return dummyA;
            dummyA = dummyA.next;
            dummyB = dummyB.next;
        }
        return null;
    }
}