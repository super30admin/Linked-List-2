// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach - - Step 1: Use slow and fast pointers to find the middle of the linked list.
//   - Step 2: Reverse the second half of the list starting from the node after the middle.
//   - Step 3: Merge the first half and the reversed second half alternately to reorder the list.

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null)    return;

        ListNode slow = head, fast = head;
        //part 1 - find the middle element first
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow will have middle of list

        //part 2 - reverse the list after middle
        ListNode reverseHead = reverse(slow.next);   //reverse linked list after middle node i.e after slow
        slow.next = null;   //remove connection of middle node

        //part 3 - reorder the list
        fast = reverseHead;
        slow = head;

        while(fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    //helper function to reverse linkedlist
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original list: ");
        printList(head);

        ReorderList solution = new ReorderList();
        solution.reorderList(head);

        System.out.print("Reordered list: ");
        printList(head);
    }
}
