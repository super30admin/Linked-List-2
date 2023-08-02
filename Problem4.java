//160. Intersection of Two Linked Lists

// Time Complexity : O(lenA + lenB)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode hA = headA;
        while(hA != null){
            lenA++;
            hA = hA.next;
        }
        ListNode hB = headB;
        while(hB != null){
            lenB++;
            hB = hB.next;
        }
        while(lenA > lenB){
            headA= headA.next;
            lenA--;
        }
        while(lenA < lenB){
            headB= headB.next;
            lenB--;
        }
        while( headA != headB && headA != null && headB != null){
            headA= headA.next;
            headB= headB.next;
        }
        return headA;
    }
}