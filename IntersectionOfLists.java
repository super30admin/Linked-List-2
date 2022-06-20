// Time Complexity: O(m+n)
// Space Complexity: O(1)
public class IntersectionOfLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr = headA;
        int lenA = 0;
        while(curr!=null){
            lenA++;
            curr = curr.next;
        }
        int lenB = 0;
        curr = headB;
        while(curr != null){
            lenB++;
            curr =curr.next;
        }
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
