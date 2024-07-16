public class DeleteWithoutHead {
    public static void deleteNode(ListNode node) {
        node.val = node.next.val; //change given value to next node's value
        node.next = node.next.next; //remove next node altogether
    }
}
