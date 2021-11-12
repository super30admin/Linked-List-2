//Time Complexity: O(n)
//Space Complexityt: O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode fast, slow = fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast.next!=null)
            slow = slow.next;

        ListNode reversedListt = reverseList(slow);
        ListNode temp, temp2=null;
        while(head!=null){
            temp = head.next;
            head.next = reversedListt;
            if(reversedListt!=null){
                temp2 = reversedListt.next;
                reversedListt.next = temp;
            }

            head = temp;
            reversedListt = temp2;
        }
    }

    public static ListNode reverseList(ListNode head){
        if(head==null)
            return null;
        if(head.next==null)
            return head;

        ListNode remainder = reverseList(head.next);
        head.next.next=head;
        head.next = null;
        return remainder;
    }
}