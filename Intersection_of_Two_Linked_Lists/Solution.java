// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We first travel 1st LL and take its count. Then we 2nd LL and take its count.
 * Whichever count is greater, we incremenet pointer of that LL till both counts become equal.
 * We do this so that both LL we come to equal distance from their intersection point if any.
 * From there we will push both pointers ahead and check if we get a common node.
 * If yes, we got intersection point else both pointers will be pointing at null so we can return any of them
*/


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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode start1 = headA;
        int countA = 0;
        
        while(start1!= null){
            start1 = start1.next;
            countA++;
        }
        
        ListNode start2 = headB;
        int countB = 0;
        
        while(start2!= null){
            start2 = start2.next;
            countB++;
        }
        
        if(countA > countB){
            while(countA - countB != 0){
                headA = headA.next;
                countA--;
            }
        }
        else if(countB > countA){
             while(countB - countA != 0){
                headB = headB.next;
                 countB--;
            }
        }
        while(headA != null || headB != null){
            if(headA == headB)return headA;
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}