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

//T.C = O(M+N)
//S.C - O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0, lenB=0;
        ListNode curr = headA;
        
        //calculating the length of headA
        while(curr!=null){
            curr = curr.next;
            lenA++;
        }
        
        curr = headB;
        
        //calculating the length of headB
        while(curr!=null){
            curr = curr.next;
            lenB++;
        }
        
        //Go to the same size of lenB
        while(lenA>lenB){
            headA = headA.next;
            lenA--;
        }
        
        //Go to the same size of lenA
        while(lenB>lenA){
            headB = headB.next;
            lenB--;
        }
        
        //Traverse until they are not equal
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}
