// Time Complexity : O(n)
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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //set a length variable for both list A and B
        int lenA = 1;
        int lenB = 1;
        ListNode slow;
        ListNode fast;
        int count = 0;
        //have the current pointer start of at headA
        ListNode curr = headA;
        //start a while loop that will iterate through List A and get the length
        while(curr != null){
            curr = curr.next;
            lenA++;
        }
        //set curr to be the start of List B
        curr = headB;
        //start a while loop that will iterate through List A and get the length
        while(curr != null){
            curr = curr.next;
            lenB++;
        }
        //get the differnce between them
        //int temp = Math.abs(lenB - lenA);
        //find which list is bigger and put the fast pointer in that list
        if(lenA > lenB){
            //set the fast to the bigger list
            fast = headA;
            slow = headB;
            //subtract the length of the bigger one until it is the same as the other one list and incerment the fast
            while(lenA != lenB){
                fast = fast.next;
                lenA--;
            }
        }
        else{
            //set the fast to the bigger list
            fast = headB;
            slow = headA;
            //subtract the length of the bigger one until it is the same as the other one list and incerment the fast
            while(lenB != lenA){
                fast = fast.next;
                lenB--;
            }
        }
        //now just increment both pointers at the same speed until they are the same pointer
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        //return either that should be the point of interseciton
        return slow;
    }
}