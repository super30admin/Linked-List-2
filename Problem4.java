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
class Problem4 {
    public void reorderList(ListNode head) {
        // null check and length = 1 check
        if(head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        // finding mid
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        fast = reverseList(slow.next);
        slow.next = null;
        slow = head;
        // making necessary connection in the list to reorder it.
        while (fast!=null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }

    }
    // private static void findMid(ListNode head, ListNode slow, ListNode fast){
    //     while(fast.next != null && fast.next.next != null){
    //         slow = slow.next;
    //         fast = fast.next.next;
    //     }
    // }
    private ListNode reverseList(ListNode head){
        //base
        if(head == null || head.next == null) return head;// length of LL is 1 just return the list.

        //Logic
        ListNode reverse = reverseList(head.next);
        // stack.pop() takes place
        head.next.next = head;
        head.next = null;

        return reverse;
    }
}