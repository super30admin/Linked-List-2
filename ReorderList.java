public class ReorderList {

        public void reorderList(ListNode head) {

            //base
            if(head == null || head.next == null) return;

            // find the middle of the linked list for a split
            ListNode slow = head;
            ListNode fast = head;

            while(fast.next != null && fast.next.next != null) { //O(n/2)

                slow = slow.next;
                fast = fast.next.next;
            }
            // merger pointer 1
            ListNode down = reverseList(slow.next);

            //detach the first half from the reversed half
            slow.next = null;

            //merger pointer 2
            ListNode up = head;

            //merge
            while(down != null) { // O(n/2)

                ListNode temp = up.next;
                up.next = down;
                down = down.next;
                up.next.next = temp;
                up = temp;
            }
        }


        // reverse the second half
        private ListNode reverseList(ListNode head) {

            ListNode left = null;
            ListNode curr = head;
            ListNode right = head.next;

            while(right != null) { // O(n/2)

                curr.next = left;
                left = curr;
                curr = right;
                right = right.next;
            }
            curr.next = left;
            return curr;

        }
}
/* Time Complexity = O(n)
Space Complexity = O(1) */
