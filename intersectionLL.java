// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

//Approach: Find the length of both the linked lists, move the pointer on the bigger LL by
//difference between the lengths of 2 linked lists and then whereever both the pointers meet ////will be our intersection
//TC O(m+n) SC O(1)


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode curr = headA;

        //getting length of list A
        while(curr != null){
            lenA++;
            curr = curr.next;
        }

        //getting length of list B
        curr = headB;
        while(curr != null){
            lenB++;
            curr = curr.next;
        }

        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }

        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}