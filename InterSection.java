/**
 * // Time Complexity : O(n)
 // Space Complexity : O(1)
 // Did this code successfully run on Leetcode : yes

 // Your code here along with comments explaining your approach
 // calculate the length of both the linkedlists,
 since ends are same,
 move fast pointer in larger list to reach same pointer len as smaller list.
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int A = 0 ;
        int B = 0 ;

        while(curA != null){
            A++;
            curA = curA.next;
        }

        while(curB != null){
            B++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;

        if(A > B){
            while(A != B){
                curA = curA.next;
                A--;
            }
        }
        else if(B >A){
            while(A != B){
                curB = curB.next;
                B--;
            }
        }

        while(curA != null){
            if(curA == curB)
                return curA;
            curA = curA.next;
            curB = curB.next;
        }

        return null;
    }
}
