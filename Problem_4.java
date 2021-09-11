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
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// count the lenght of both list
// get the pointer the node that is having same count to till the end
// go to next node till you get both of them the same node
// Your code here along with comments explaining your approach
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0;
        int countB = 0;
        ListNode top = headA;
        // get count of list A
        while(top != null){
            countA++;
            top = top.next;
        }
        // get count of list B
        top = headB;
        while(top != null){
            countB++;
            top = top.next;
        }
        // getting the common ground - lenght
        while(countA < countB){
            headB = headB.next;
            countB--;
        }
        while(countA > countB){
            headA = headA.next;
            countA--;
        }
        // check till not same
        while( headA != headB ){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}