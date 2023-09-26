// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Find the lengths of the linkedlists, and increment the linked list whose length is greater 
 * such that both the linked list will have same length before the intersection point
 * Traverse the linkedlist until intersection is found
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        int lenA = lllength(headA);
        int lenB = lllength(headB);
        while(lenA > lenB){
            headA= headA.next;
            lenA--;
        }
        while(lenB > lenA){
            headB= headB.next;
            lenB--;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    int lllength(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        int count=0;
        while(fast != null && fast.next!=null){
            slow=slow.next;
            fast= fast.next.next;
            count+=1;
        }
        if(fast == null)
            count*=2;
        else
            count = count*2 +1;
        return count;
    }
}