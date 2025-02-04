// Time Complexity : O (1)
// Space Complexity : O (1)

// 1->2->3 : delete 2, given a reference to 2 only
// a) set value of 2 to next's value: 1->3->3
// b) delete next node: 1->3
public class DeleteNode {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;
    }

    /**
     * Deletes a node in a list given only a reference to that node
     */
    public void deleteNode(ListNode node) {
        if (node.next == null) {
            //impossible to delete this node if it is the last
            return;
        }
        // set the value of this node to the next node's value
        node.val = node.next.val;
        // now delete the next node
        node.next = node.next.next;
    }
}
