// Time Complexity : O(max(n,m)) , n and m are length of LL
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/* Calculate the length of the LL, move head point of larger one by the difference, so that we have equal number od nodes 
left to be traversed for both
now, iterate from this point till the pointers point to the same node, that pointer is the intersection point
*/
public class IntersectionofLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1!=null){
            lenA+=1;
            p1 = p1.next;
        }
        while(p2!=null){
            lenB+=1;
            p2 = p2.next;
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