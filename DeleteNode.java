// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//Copy the node to be deleted to it's previous node. In this case you would have a previous.
//As we have the previous node we can deleted the specified node without a head pointer.
class DeleteNode {

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int ele) {
            data = ele;
        }
    }

    public void deleteNode(ListNode node) {
        // Your code here
        if (node == null)
            return;
        else {

            if (node.next == null)
                return;

            node.data = node.next.data;

            node.next = node.next.next;

        }
    }

    public void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String args[]) {
        DeleteNode obj = new DeleteNode();
        ListNode list = new ListNode(10);
        list.next = new ListNode(20);
        list.next.next = new ListNode(4);
        list.next.next.next = new ListNode(30);
        ListNode node = list.next.next;
        obj.deleteNode(node);
        obj.printList(list);
    }
}