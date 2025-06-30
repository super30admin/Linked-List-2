//2 pointers: 
// Get the length of the two lists, 
// Move pointer of longer list to cover the gap -to align them to the same start point, 
// move both pointers by 1.
// Time complexity: O(n + m), where n and m are the lengths of the two linked lists.
// Space complexity: O(1), no extra space is used.
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lA = 0;
        int lB = 0;
        ListNode curr = headA;
        while(curr != null){
            curr = curr.next;
            lA++;
        }
        curr = headB;
        while(curr != null){
            curr = curr.next;
            lB++;
        }
        while (lA > lB){
            headA = headA.next;
            lA--;
        }
        while (lA < lB){
            headB = headB.next;
            lB--;
        }
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}