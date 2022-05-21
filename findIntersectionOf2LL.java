// Time Complexity : o(m + n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// simple problem wher we use two counters arrive at a common point then iterate both till their head meet return head
// Your code here along with comments explaining your approach
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        ListNode cur = headA;
        while(cur != null) {
            lenA++;
            cur = cur.next;
        }
        cur = headB;
        while(cur != null) {
            lenB++;
            cur = cur.next;
        }
        while(lenA > lenB) { // cuz he dont know which's bigger A or B
            lenA--;
            headA = headA.next;
        }
        while(lenB > lenA) {    // cuz he dont know which's bigger A or B
            lenB--;
            headB = headB.next;
        }
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA; // can return headB also, doesn't matter
    }
}