/*
Thought Process: Multiple Pass Solution. Need to check the longer size, subtract extra elements from start in the longer Node. Compare both till we find the intersection, else null will be returned.

T.C -> O(N) -> 3 Pass Solution
S.C -> O(1)

Mistakes Commited -> None

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
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int sizeA = 0, sizeB = 0;
        ListNode A = headA, B = headB;
        while(A != null){
            sizeA++;
            A = A.next;
        }
        while(B != null){
            sizeB++;
            B = B.next;
        }
        while(sizeA != sizeB){
            if(sizeA > sizeB){
                sizeA--;
                headA = headA.next;
            }else{
                sizeB--;
                headB = headB.next;
            }
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}