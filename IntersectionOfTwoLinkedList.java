// Time complexity:- O(n + m)
// Space complexity:- O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 
/**
 * Approach: 
 * In this problem, it is given that we need to find the intersection of two singly linked lists. 
 * First, I calculated the lengths of both lists and aligned their starting points by moving the pointer of the longer list forward. 
 * Then, I traversed both lists simultaneously to find the first node where they intersect and returned that node, or null if no intersection exists.
 */ 
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // Calculate the length of the first linked list (headA).
        ListNode cur = headA;
        int headAlength = 0;
        
        // Traverse the first list to calculate its length.
        while(cur != null) {
            headAlength++;
            cur = cur.next;
        }

        // Calculate the length of the second linked list (headB).
        cur = headB;
        int headBlength = 0;
        // Traverse the second list to calculate its length.
        while(cur != null) {
            headBlength++;
            cur = cur.next;
        }

        // If one list is longer than the other, we move its pointer forward until both lists are of equal length.
        while(headAlength > headBlength){
            headA = headA.next;
            headAlength--;
        }

        // Repeat for list B if it's longer than list A.
        while(headBlength > headAlength){
            headB = headB.next;
            headBlength--;
        }
        
        // Traverse both lists simultaneously to find the intersection.
        // Both pointers now point to nodes at the same distance from the end of the lists.
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        //Return the intersection node
        return headA;

    }
}

   

     