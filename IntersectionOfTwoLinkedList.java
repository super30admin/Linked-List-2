// Time Complexity :O(m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
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
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int lenA =0;
        int lenB = 0;
        while(nodeA != null){
            lenA++;
            nodeA = nodeA.next;
        }
        while(nodeB != null){
            lenB++;
            nodeB = nodeB.next;
        }
        nodeA = headA;
        nodeB = headB;
        while(lenA>lenB){
            nodeA = nodeA.next;
            lenA--;
        }
        while(lenB>lenA){
            nodeB = nodeB.next;
            lenB--;
        }
        while(nodeA!=nodeB){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }
}
