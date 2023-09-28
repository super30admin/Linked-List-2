// Time Complexity :O(m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
//in this problem we first find the len of each LL considering two LL
//then we try to equal the len of linked list by increasing the pointer of LL which has max len till len of a and b is equal
//and then we compare nodes till we get the same value
//once we get equal return headA or headB both are same


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        ListNode curr=headA;
        int lenA=0;
        while(curr!=null){
            lenA ++;
            curr=curr.next;
        }
         curr=headB;
        int lenB=0;
         while(curr!=null){
             lenB ++;
            curr=curr.next;
        }
        while(lenA>lenB){
            headA=headA.next;
            lenA--;
        }
        while(lenB>lenA){
            headB=headB.next;
            lenB--;
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}