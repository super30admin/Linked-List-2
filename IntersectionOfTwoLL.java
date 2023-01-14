// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Find length of both lists by traversing them
// Make the pointers equidistant from the end and then move them both by 1 node till they meet
// If there is no intersection, it will still work because the pointers will meet at null

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int lenA = 0;
        int lenB = 0;
        while(nodeA!=null){
            lenA++;
            nodeA = nodeA.next;
        }
        while(nodeB!=null){
            lenB++;
            nodeB = nodeB.next;
        }
        nodeA = headA;
        nodeB = headB;
        while(lenA > lenB){
            nodeA = nodeA.next;
            lenA--;
        }
        while(lenB > lenA){
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