/*The time complexity of this implementation is O(n)*/
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle node of the linked list.
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow;

        // Step 2: Reverse the second half of the linked list.
        ListNode prev = null;
        ListNode curr = middle;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode secondHalf = prev;

        // Step 3: Merge the first half and the reversed second half of the linked list.
        ListNode firstHalf = head;
        while (secondHalf != null) {
            ListNode next1 = firstHalf.next;
            ListNode next2 = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = next1;
            firstHalf = next1;
            secondHalf = next2;
        }
        if (firstHalf != null) {
            firstHalf.next = null;
        }
    }
    public static void main(String[] args) {
        // Create the linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        // Print the original linked list
        System.out.print("Original linked list: ");
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();

        // Reorder the linked list
        ReorderList solution = new ReorderList();
        solution.reorderList(head);

        // Print the reordered linked list
        System.out.print("Reordered linked list: ");
        curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

}
