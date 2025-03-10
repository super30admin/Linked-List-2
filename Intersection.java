// Time Complexity : O(m+n) where m and n are length of the both linked lists.
// Space Complexity : O(1) no extra space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/* Your code here along with comments explaining your approach
1) calculate the length of two linked lists
2) which ever length is long we try to move the pointer till the extra length and 
then move the two pointers at the same rate till both pointers are at the intersection point.
*/ 



 //Definition for singly-linked list.
 class ListNode {
     int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
       }
 }

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp = headA;
        int lenA = 0;
        while(temp != null)
        {
            temp = temp.next;
            lenA++;
        }
        int lenB = 0;
        temp = headB;
        while(temp != null)
        {
            temp = temp.next;
            lenB++;
        }

        ListNode a = headA;
        ListNode b = headB;
        while(lenA > lenB)
        {
            a = a.next;
            lenA--;
        }
        while(lenB > lenA)
        {
            b = b.next;
            lenB--;
        }

        while(a != b)
        {
            a = a.next;
            b = b.next;
        }
        return a;
    }
}
