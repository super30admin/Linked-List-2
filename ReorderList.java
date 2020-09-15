public class ReorderList {
    public static void reOrder(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // get mid point
        // 1 2 3 4 N
        // 1 4 2 3 N
        
        // 1 2 3 4 5 N
        // 1 5 2 4 3 N
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second half, and store references to the first and second half of the list
        ListNode h1 = head;
        // why node after slow
        // if we use node after slow, we do not have to handle odd and even length separately
        // also for even length 1 -> 2 ->  3 ->  4 - > N, doesnt matter if 3 is part of 2nd or first list
        ListNode h2 = reverse(slow.next);
        slow.next = null; // to terminate the final result

        // interweave the 2 lists
        // h2 is shorter than h1, since we reverse the node after slow, enough to check h2 is null
        ListNode temp1 = null, temp2 = null;
        while (h2 != null) {
            temp1 = h1.next;
            temp2 = h2.next;

            h1.next = h2;
            h2.next = temp1;
            h1 = temp1;
            h2 = temp2;
        }
    }

    // TC: O(n)
    // SC: O(1)
    public static ListNode reverse(ListNode head) {
        ListNode prev = null, next = null, curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String args[]) {
        // Odd length
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = null;

        reOrder(head);
        head.print();

        // Even length
        head = new ListNode(1);
        two = new ListNode(2);
        three = new ListNode(3);
        four = new ListNode(4);

        head.next = two;
        two.next = three;
        three.next = four;
        four.next = null;

        reOrder(head);
        head.print();
    }
}
