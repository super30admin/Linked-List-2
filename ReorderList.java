public class ReorderList {
    /*
    The concept is divided into three methods.
    1. Find the middle node in the linked list using slow and fast pointers.
    2. From the middle node to end of the list, reverse the order.
    3. Merge the first and second halves by moving the pointers alternatively.
     */
    public static void reorderList(ListNode head) { //O(n) T.C, O(1) S.C
        //find mid
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) { //O(n) T.C
            fast = fast.next.next; //while fast moves twice the speed to reach end of the list
            slow = slow.next; //slow will move up to the middle node
        }

        //reverse from mid to end
        fast = reverseList(slow.next); //from the next element of middle, reverse the list and store the head in fast
        slow.next = null; //remove the pointer from slow to next part of the list
        slow = head; //move back the slow to head

        //merge
        while(fast != null) { //traversing fast pointer on the second part of list, O(n) T.c
            assert slow != null; //asserting slow as cautionary
            ListNode temp = slow.next; //store next node of slow to temp
            slow.next = fast; //point slow -> fast
            fast = fast.next; //move up fast
            slow.next.next = temp; //make initial fast point to second in slow
            slow = temp; //move up slow
        }
    }

    static ListNode reverseList(ListNode node) {
        ListNode prev = null; //previous pointer pointing to dummy
        ListNode curr = node; //start current node at head

        while(curr != null) { //reversing the list, O(n) T.C
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public static void main(String[] args) {
        // Creating linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Running the reorderList function
        reorderList(head);

        // Printing the reordered list
        PrintList.printList(head);
    }
}