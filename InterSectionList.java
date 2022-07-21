// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        ListNode cur = headA;
        while(cur!=null){
            cur=cur.next;
            lenA++;
        }
        cur = headB;
        while(cur!=null){
            cur=cur.next;
            lenB++;
        }
        while(lenA>lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB>lenA){
            headB = headB.next;
            lenB--;
        }
        while(headA!=headB){
            headA= headA.next;
            headB= headB.next;
        }
        return headA;
    }
}