// TIME: O(n)
// SPACE: O(1)
// SUCCESS on LeetCode

public class IntersectionOf2LL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        int sizeB = 0;
        
        ListNode curr1 = headA;
        ListNode curr2 = headB;
        
        while (curr1 != null) {
            sizeA++;
            curr1 = curr1.next;
        }
        
        while (curr2 != null) {
            sizeB++;
            curr2 = curr2.next;
        }
        
        int diff = Math.abs(sizeA - sizeB);
        
        int count = 0;
        
        while (count < diff) {
            if (sizeB > sizeA) {
                headB = headB.next;
            } else if (sizeA > sizeB) {
                headA = headA.next;
            }
            count++;
        }
        
        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
}
