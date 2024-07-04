/**
 Approach: 2 pointers, splitting the list , reverse the second half an merge the list

 Working:
     Find the mid of the LL
     Reverse the second half of LL
     Merge the list with 2 pointers with slow -> left og th LL and fast - right of the LL

 Time Complexity: O(n)
 Space Complexity: O(1)
 */

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
class ReorderList {
    public void reorderList(ListNode head) {

        if(head == null || head.next == null) {
            return;
        }

        //find middle
        ListNode slow = head;
        ListNode fast = head;

        // similarly you can use fast.next != null && fast.next.next != null, the mid will be slow.next
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode revhead = reverse(slow.next);

        slow.next = null;
        slow = head;
        fast = revhead;

        while(fast!=null) {

            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp; //slow.next -> fast.next-> temp
            slow = temp; //assigning the next vale of slow to slow
        }

    }

    private ListNode reverse(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode currentNode = head;
        ListNode prevNode = null;
        ListNode nextNode = null;

        while(currentNode != null) {

            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        ListNode nh = prevNode;
        while(nh != null) {
            System.out.print(nh.val+", ");
            nh = nh.next;
        }

        return prevNode;
    }
}