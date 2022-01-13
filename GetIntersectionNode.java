// Time Complexity : O(n + m) where n and m are lengths of input linked lists
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class GetIntersectionNode {
    public static void main(String[] args) {
        
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        
        int lenA =0, lenB= 0;
        
        ListNode ptA = headA, ptB = headB;
        
        //get length of headA and headB linkedlist
        while(ptA != null){
            ptA = ptA.next;
            lenA++;
        }
        while(ptB != null){
            ptB = ptB.next;
            lenB++;
        }
        ptA = headA;
        ptB = headB;
        
        //move either headA or headB to have to a listNode which is equal distance from intersetion
        while(lenA > lenB){
            ptA = ptA.next;
            lenA--;
        }
        while(lenB > lenA){
            ptB = ptB.next;
            lenB--;
        }
        
        //if both nodes are same then intersection is found
        while(ptA != ptB){
            ptA = ptA.next;
            ptB = ptB.next;
        }
        return ptA;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
