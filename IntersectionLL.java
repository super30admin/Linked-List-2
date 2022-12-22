//TC : o(n)
//Sc : O(1)
//https://leetcode.com/problems/intersection-of-two-linked-lists/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int length_a=findLength(headA);
        int length_b=findLength(headB);
        ListNode ptA = headA;
        ListNode ptB = headB;
        while(length_a > length_b){
            ptA = ptA.next;
            length_a--;
            
        }
        while(length_b > length_a){
            ptB = ptB.next;
            length_b--;
            
        }
        while(ptA != ptB){
            
            ptA = ptA.next;
            ptB = ptB.next;
        }
        return ptA;
    }
    private int findLength(ListNode head){
        int count =0;
        while(head != null){
            head=head.next;
            count++;
        }
        return count;
    }
}
