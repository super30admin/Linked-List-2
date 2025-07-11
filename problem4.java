// Time Complexity : O(n+m) where n is the number of nodes in list A and m is the number of nodes in list B.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I calculated sized of both lists, then moved the pointer of the longer list ahead by the difference in sizes. After that, I moved both pointers one step at a time until they met, which would be the intersection point if it exists.
// If they don't meet, it means there is no intersection and return null.

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
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr = headA;
        int a = 0;
        int b = 0;
        while(curr!=null){
            curr=curr.next;
            a++;
        }
        curr = headB;
        while(curr!=null){
            curr=curr.next;
            b++;
        }
        if(a>=b){
            while(a!=b){
                headA = headA.next;
                a--;
            }
        }
        else{
            while(a!=b){
                headB = headB.next;
                b--;
            }
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}