// Time Complexity : O(m+n) as we iterate over both lists
// Space Complexity : O (1) no extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : yes, forgot assign the head of LL to variable, due to which, 
// when i was advacing both pts after creating correct gap, getting NPE

public class prob1 {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null) return headB;
        if(headB == null) return headA;
        
        int lenA = 0; int lenB = 0;
        ListNode curr = headA;
        while(curr != null){
            curr = curr.next;
            lenA++;
        }
        curr = headB;
        while(curr != null){
            curr = curr.next;
            lenB++;
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

    public static void main(String[] args) {
        

    }
    
}