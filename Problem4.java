Time Complexity: O(m+n). m is length of linkedlist A and n is length of linkedlist B.
Space Complexity: O(1)
Ran successfully on leetcode?: yes

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int sizeA = 0, sizeB = 0;
        ListNode nodeA = headA, nodeB = headB;
        while(nodeA != null){
            sizeA++;
            nodeA = nodeA.next;
        }
        
        while(nodeB != null){
            sizeB++;
            nodeB = nodeB.next;
        }
        
        nodeA = headA; nodeB = headB;
        if(sizeA > sizeB){
            int diff = sizeA - sizeB;
            while(diff > 0){
                nodeA = nodeA.next;
                diff--;
            }
        } else if(sizeB > sizeA){
            int diff = sizeB - sizeA;
            while(diff > 0){
                nodeB = nodeB.next;
                diff--;
            }
        }
        
        while(nodeA != null && nodeB != null){
            if(nodeA == nodeB) return nodeA;
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        
        return null;
    }
}
