// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Understood


// Your code here along with comments explaining your approach

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr = headA;
        int lenA = 0;
        int lenB = 0;
        
        //Find length of A
        while(curr != null){
            lenA ++;
            curr = curr.next;
        }
        //Find length of B
        curr = headB;
        while(curr != null){
            lenB ++;
            curr = curr.next;
        }
        //if A is longer than B then move the pointer until they start from same place and vice versa
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }
        //Move both nodes together until they are the same node refernced
        while(headA != headB){ 
            headA = headA.next;
            headB = headB.next;
        }
        return headA; //can return B also
    }
}