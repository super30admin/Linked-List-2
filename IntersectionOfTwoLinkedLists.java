// Time Complexity : O(n) - Worst case traversing O(3 n) n - nodes; Twice to determine nodes + Once to find the common node, if the common node is end of the list then traversed N nodes
// Space Complexity : O(1)- storing the node references
// Did this code successfully run on Leetcode : Yes; (https://leetcode.com/submissions/detail/674578960/)
// Any problem you faced while coding this : No
// My Notes : Calculates the nodes in two list, increment the greater list by diff of nodes and traverse till the common node.

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
        ListNode tempA = headA, tempB = headB;
        int counterA = 0, counterB = 0;
        // Count list 1 nodes
        while(tempA.next!=null){
            tempA = tempA.next;
            counterA++;
        }
        // Count list 2 nodes
        while(tempB.next!=null){
            tempB = tempB.next;
            counterB++;
        }
        // If not point at the same end reference
        if(tempA != tempB){
            return null;
        }
        //System.out.println(" nodes : "+counterA+" - "+counterB);
        // Increase the greater by difference
        tempA = headA; tempB = headB;
        int diff = Math.abs(counterA - counterB);
        // Increment the list with greater number of node
        if(counterA > counterB){
            while(diff>0){
                tempA = tempA.next;
                diff--;
            }
        }else if(counterB > counterA){
            while(diff>0){
                tempB = tempB.next;
                diff--;
            }
        }
        
        // Till they are found equal; comparing by reference not node values
        while(tempA!=tempB){
            tempA = tempA.next;
            tempB = tempB.next;
        }
        // Return the common node
        return tempA;
    }
}