// Time complexity - O(n - larger linked list length)
// space complexity - O(1)
// Works on leetcode

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
        // Return null if any of the given list is empty
        if (headA == null || headB == null){
            return null;
        }
        int sizeA = find_size(headA);
        int sizeB = find_size(headB);
        ListNode startA = headA;
        ListNode startB = headB;
        
        // Set the start pointer such that they are both equal in length
        if(sizeA > sizeB){
            int diff = sizeA - sizeB;
            while(diff != 0){
                startA = startA.next;
                diff = diff - 1;
            }
        }
        else{
            int diff = sizeB - sizeA;
            while(diff != 0){
                startB = startB.next;
                diff = diff - 1;
            }
        }
        
        // Move both the points and stop when they are either null or when they point to the same point.
        while(startA != startB){
            startA = startA.next;
            startB = startB.next;
        }
        // Return any one of the pointers that is pointing to null or the intersection point
        return startA; 
    }
  
    // Function to find the size of the linked lists.
    private int find_size(ListNode node){
        int count = 1;
        while(node.next!=null){
            node = node.next;
            count = count + 1;
        }
        return count;
    }
}
