class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
}
}

class Solution {
    void deleteNode(ListNode del_node) {
        if (del_node == null || del_node.next == null) {
            return;
        }

        ListNode nextNode = del_node.next;
        del_node.val = nextNode.val;
        del_node.next = nextNode.next;
        nextNode = null;
    }
}
