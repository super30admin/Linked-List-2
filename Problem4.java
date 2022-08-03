//Time Complexity: O(m+n)
//Space Complexity: O(1)
//Code run successfully on LeetCode.

public class Problem4 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null)
            return null;
        
        if(headA == headB)
            return headA;
        
        int lenA =0 , lenB = 0;
        
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        
        while(nodeA != null){
            nodeA = nodeA.next;
            lenA++;
        }
        
        while(nodeB != null){
            nodeB = nodeB.next;
            lenB++;
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
        
        while(nodeA != nodeB){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        
        return nodeA;
    }
}
