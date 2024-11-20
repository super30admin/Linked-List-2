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
// Approach : calculate lengths of each linkedlist and whichever linkedlist has higher length move the pointer of that linkedlist
// in such a way that height of both LL becomes equal - pointer a and pointerb will be equidistance from intersection
// Time : O(m+n)  // max of m or n
// Space : O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0;
        int lenB = 0;
        // len of llA
        while(curA != null){
            lenA++;
            curA=curA.next;
        }
        // len of llB
        while(curB != null){
            lenB++;
            curB=curB.next;
        }
        // After calculating lengths , both pointers moved to end of the LL's. So reset back to individual head's
        curA = headA;
        curB = headB;
        // move curA equidistance
        while(lenA>lenB){
            curA=curA.next;
            lenA--;
        }
        // move curB equidistance
        while(lenB>lenA){
            curB=curB.next;
            lenB--;
        }
        // At meeting point exit out of loop and return any pointer
        while(curA!=curB){
            curA=curA.next;
            curB=curB.next;
        }
        return curA;
    }
}