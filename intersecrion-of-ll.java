// Time Complexity : O(n)
// Space Complexity :(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// get the length of both arrays
// get tge difference and start the second pointer of the larger ll that many node ahead
//where both the pointer nodes are same that is the intersection

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        ListNode curr = headA;

        while (curr != null) {
            lenA++;
            curr = curr.next;
        }
        int lenB = 0;
        curr = headB;
        while (curr != null) {
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