// 143.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//time - O(n) with constant space
class Solution {
    public void reorderList(ListNode head) {
        if(head == null)
        {
            return;
        }
        ListNode middle = findMiddle(head); //find mid
        ListNode second = reverseList(middle.next); //reverse 2nd part
        middle.next = null; //break into 2 lists
        ListNode first = head;
        head = mergeList(first, second); //merge
        return;
    }
    
    //time - O(n) and space - constant
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
        //1 -> 2 -> 3 -> 4 -> 5 returns 3 and 1 -> 2 -> 3 -> 4 returns 2 as middle
    }
    
    //time - O(n) with constant space
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next;
        
        while(current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    //time - O(n) with constant space
    //merges 1-2-3 and 4-5 into 1-4-2-5-3
    //merges 1-2-3 and 4-5-6 into 1-4-2-5-3-6
    //the other possiblity of 2nd list being larger is not handled as it won't occur in this problem
    private ListNode mergeList(ListNode first, ListNode second) {
        ListNode headA = first;
        ListNode headB = second;
        ListNode temp1;
        ListNode temp2;
        
        while(headB != null)
        {
            temp1 = headA.next;
            headA.next = headB;
            temp2 = headB.next;
            headB.next = temp1;
            headA = temp1;
            headB = temp2;
        }
        
        return first;
    }
}
