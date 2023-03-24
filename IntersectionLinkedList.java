
/**
 * Time Complexity - O(M + N) where N is the length of list headA, M is the length of list headB.
 * Space Complexity - O(1).
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {    
        ListNode ptr1 = headA, ptr2 = headB;
        int len1 = 0, len2 = 0;

        while(ptr1 != null) {
            len1++;
            ptr1 = ptr1.next;
        }
        while(ptr2 != null) {
            len2++;
            ptr2 = ptr2.next;
        }
        if(len1 > len2) {
            ptr1 = headA;
            ptr2 = headB;
            len1 = len1 - len2;
        }
        else {
            ptr1 = headB;
            ptr2 = headA;
            len1 = len2 - len1;
        }
        while(len1 > 0) {
            --len1;
            ptr1 = ptr1.next;
        }
        
        while(ptr1 != null && ptr2 != null) {
            if(ptr1 == ptr2)
                return ptr1;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return null;
    }
}
