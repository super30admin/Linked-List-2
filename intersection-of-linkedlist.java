class Solution {
    // Solution using two pointers
    // Time complexity is O(n) where n is the length of largest linked list
    // Space complexity is O(1)
    // This solution is submitted on leetcode with no errors.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
        val = x;
        next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode slow = headA;
        ListNode fast = headB;
        while(slow!=null){
            slow = slow.next;
            lenA++;
        }
        while(fast!=null){
            fast = fast.next;
            lenB++;
        }
        
        while(lenA>lenB) {
            headA = headA.next;
            lenA--;
        }
        while(lenB>lenA){
            headB = headB.next;
            lenB--;
        }
        //other method
        // if(lenA>lenB){
        //     int i = 0;
        //     slow = headA;
        //     fast = headB;
        //     while(i<(lenA-lenB)){
        //         slow = slow.next;
        //         i++;
        //     }
        // }
        // else {
        //     int i = 0;
        //     slow = headA;
        //     fast = headB;
        //     while(i<(lenB-lenA)){
        //         fast = fast.next;
        //         i++;
        //     }
        // }
        // while(slow!=fast){
        //     slow = slow.next;
        //     fast = fast.next;
        // }
        //return slow;
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}