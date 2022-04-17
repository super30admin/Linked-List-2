// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* APPROACH:
Intuition is to break linked list in 2 halves and then merging
1. Find the middle of the linked list using slow and fast pointers.
2. Reverse the second part of the linked list using recursive or iterative solution
and set slow.next to null to separate the two linked lists.
3. Now merge the 2 linkedlist by taking pointers on each of the linkedlist and a temp pointer
temp = slow.next;
slow.next = fast;
fast = fast.next;
slow.next.next = temp;
slow = temp;
*/

public class ReorderList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static void printList(ListNode node)
    {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void reorderList(ListNode head) {
        // null case
        if(head == null || head.next == null) return;

        // Finding middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reversing second half of the linked list
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;

        // Merging the 2-halves of the linked list
        mergeLists(slow, fast);
    }

    // recursive reverse
    /*public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode head2 = reverse(head.next); //this is a global variable to recursive stack thus it will always contain the last element
        head.next.next = head;
        head.next = null;

        return head2;
    }*/

    // iterative reverse
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;

        while(fast != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }

    public static void mergeLists(ListNode slow, ListNode fast){

        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    public static void main(String[] args){
        ListNode head = new ListNode(3);
        ListNode next1 = new ListNode(2);
        ListNode next2 = new ListNode(0);
        ListNode next3 = new ListNode(-4);
        head.next = next1;
        next1.next = next2;
        next2.next = next3;
        next3.next = null;

        System.out.println("Before ");
        printList(head);

        reorderList(head);
        System.out.println("");
        System.out.println("After ");
        printList(head);

    }
}
