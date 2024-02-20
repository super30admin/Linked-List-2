// ## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)
// Time Complexity : O(M+N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


public class Solution {
    // Time: O(M+N)
    // Space: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0, lenB=0;

        // Find length
        ListNode h1=headA;
        ListNode h2=headB;

        while(h1!=null){
            lenA++;
            h1=h1.next;
        }

        while(h2!=null){
            lenB++;
            h2=h2.next;
        }

        // Take longer of lengths and move it until no difference in length
        h1=headA;
        h2=headB;
        if(lenA>lenB){
            while(lenA!=lenB){
                h1=h1.next;
                lenA--;
            }
        }else{
            while(lenA!=lenB){
                h2=h2.next;
                lenB--;
            }
        }

        // Move both together until common nodes encountered or both becomes null
        while(h1!=h2){
            h1=h1.next;
            h2=h2.next;
        }

        return h1;
    }
}