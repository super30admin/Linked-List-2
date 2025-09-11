//Time Complexity: O(1), since we are updating the current node's val with next node's val and updating the next ptr of the current to next.next
//Space Complexity: O(1)
//Approach: in order to delete a node, we always stand 1 position before the node to be deleted
//Using the same concept, we will change the val of the del_node to next node's val, and update the pointers of current's next to next.next
public class DeleteWithoutHeadPointer {

    public void deleteNode(ListNode del_node) {

        ListNode temp = del_node.next;
        del_node.val = temp.val;

        del_node.next = del_node.next.next;
        temp.next = null;
    }

    public static void main(String[] args) {
        final DeleteWithoutHeadPointer deleteWithoutHeadPointer = new DeleteWithoutHeadPointer();
        ListNode del_node = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))));
        ListNode head = new ListNode(1, del_node);

        deleteWithoutHeadPointer.deleteNode(del_node);

        int currentLength = 5;
        while (head != null) {
            currentLength--;
            head = head.next;
        }

        assert currentLength == 1;
    }
}
