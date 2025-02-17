//The approach here is to keep both pointers at both linkedlists equidistant from the intersection point so that when traversing them both at same pace, they meet at the intersection point
//Time Complexity:O(n)
//Space Complexity: O(1)
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lA = 0;
        int lB = 0;
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA!= null){
            pA = pA.next;
            lA++;
        }
        while(pB!=null){
            pB = pB.next;
            lB++;
        }
        while(lB>lA){
            headB = headB.next;
            lB--;
        }
        while(lA>lB){
            headA = headA.next;
            lA--;
        }
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}